package converTor;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.torproject.descriptor.*;

/**
 *  Read all descriptor files provided in the 'in' directory
 *  and convert them to the format specified in arguments.
 */
class Base {

  static String[] commandLineArguments;
  Args args;
  Types type;
  Writers writers;
  Walker walker;
  Logger logger;

  public static void main(String[] args) {

    System.out.println(
        "\nConverter from Tor CollecTor data to JSON, Parquet or Avro.\n" +
        "Call with parameter '-h' for help and more options.\n"
    );

    Base base = new Base(args);

    /* start conversion */
    try {
      base.runConversion();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Sets up conversion environment by evaluating input arguments
   * and initializing output file writers.
   * @param arguments    arguments provided to the command line interface
   */
  Base(String[] arguments) {
    /* make command line args available to singleton 'args' */
    commandLineArguments = arguments;
    /* setup arguments singleton */
    args = Args.INSTANCE;
    /* setup output writers map singleton */
    this.writers = Writers.INSTANCE;


    if (args.isLog()) {
      logger = Logger.getLogger("ConversionLog");
      FileHandler fh;

      try {
        // Configure the logger with handler and formatter
        fh = new FileHandler(
            this.args.getLogsPath() + "convertor.log",
            100000000,  // 100 MB
            100,
            true
        );
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        String argz = "";
        for (String arg : commandLineArguments) {argz = argz.concat(arg) + " ";}

        logger.info(
          "Conversion with arguments:\n      " + argz + "\n" +
          "\n" +
          "      Current parameters:\n" +
          "      -f     -format       'parquet', 'json' or 'avro'            " + args.getFormat() + "\n" +
          "      -s     -suffix                                              " + args.getSuffix() + "\n" +
          "      -i     -inPath                                              " + args.getInPath() + "\n" +
          "      -o     -outPath                                             " + args.getOutPath() + "\n" +
          "      -l     -logsPath                                            " + args.getLogsPath() + "\n" +
          "      -cs    -snappy                                              " + args.isSnappy() + "\n" +
          "      -cz    -zip          Avro as BZip2, Parquet/JSON as GZip    " + args.isZip() + "\n" +
          "      -p     -pretty       pretty printed JSON                    " + args.isPretty() + "\n" +
          "      -m     -maxFiles                                            " + args.getMaxFiles() + "\n" +
          "      -d     -debug        print JSON descriptors to console      " + args.isDebug() + "\n" +
          "      -log                 log to file 'convertor.log'            " + args.isLog() + "\n" +
          "\n"
        );
      } catch (SecurityException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  /**
   * Iterates over all files in input directory, calls appropriate converter
   * and writes conversion to disc.
   * @throws IOException
   */
  void runConversion() throws IOException {
    int counter = 0;

    /* set up iterator over input files */
    walker = new Walker(args.getInPath(), args.getMaxFiles());

    /* iterate over input files */
    while (walker.descriptorFiles.hasNext()) {

      DescriptorFile currentFile = walker.getNextFile();

      /* iterate over descriptors in each input file */
      for (Descriptor descriptor : currentFile.getDescriptors()) {

        /* determine descriptor type */
        type = Types.getDescriptorType(descriptor);

        /* initialize converter */
        Convert<? extends Convert> converter = null;
        try {
          converter = type.converter.newInstance();
        } catch (InstantiationException|IllegalAccessException e) {
          e.printStackTrace();
        }

        /* convert descriptor */
        converter.convert(descriptor);
        if (args.isDebug()) {
          System.out.println(converter.load);
        }

        /* get appropriate output writer */
        Writer writer = writers.getWriter(converter.type, converter.date);

        /* append converted descriptor to output writer */
        try {
          writer.append(converter.load);
        }
        catch (Exception e){
          if (args.isLog()) {
            logger.warning("Exception in descriptor of type " + converter.type
              + " at date " + converter.date + ":");
            logger.info(converter.load.toString());
            logger.info(e.toString());
          } else {
            System.out.println("Exception in descriptor of type " + converter.type
                + " at date " + converter.date + ":");
            System.out.println(converter.load);
            System.out.println(e);
          }
        }

        /* check for unrecognized attributes */
        converter.checkUnrecognized(descriptor,currentFile);

        counter++;
      }
    }

    /* wrap up */
    closeAllWriters();
    if (args.isLog()) {
      logger.info( counter + " descriptor" +
          (counter < 1 || counter > 1 ? "s" : "") + " converted");
    } else {
      System.out.println(
          counter + " descriptor" +
              (counter < 1 || counter > 1 ? "s" : "") + " converted"
      );
    }
    System.exit(0);

  }


  /**
   * Iterates through files in input directory
   */
  private class Walker {

    private java.util.Iterator<DescriptorFile> descriptorFiles;

    Walker(String inPath, int maxFiles) {
      DescriptorReader descriptorReader =
          DescriptorSourceFactory.createDescriptorReader();
      descriptorReader.addDirectory(new File(inPath));
      descriptorReader.setMaxDescriptorFilesInQueue(maxFiles);
      descriptorFiles = descriptorReader.readDescriptors();
    }

    private DescriptorFile getNextFile() {
      DescriptorFile nextFile = descriptorFiles.next();
      /* check for exceptions */
      if (null != nextFile.getException()) {
        System.err.print(nextFile.getException()
            + "\n    in " + nextFile.getFileName() + "\n");
      }
      return nextFile;
    }

  }


  /**
   * Makes sure all writers properly finish and write their content to disk
   * after iterator has finished iterating over incoming descriptors
   */
  void closeAllWriters() throws IOException {
    for (Writer writer : writers.getAllWriters()) {
      writer.close();
    }
  }


}