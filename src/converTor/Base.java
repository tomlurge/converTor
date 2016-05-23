package converTor;

import java.io.File;
import java.io.IOException;

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


  public static void main(String[] args) {
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
   * @param args    arguments provided to the command line interface
   */
  Base(String[] args) {
    /* make command line args available to singleton 'args' */
    commandLineArguments = args;
    /* setup arguments singleton */
    this.args = Args.INSTANCE;
    /* setup output writers map singleton */
    this.writers = Writers.INSTANCE;
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

        //  todo    remove test
        //  System.out.println(converter.load);

        /* get appropriate output writer */
        Writer writer = writers.getWriter(converter.type, converter.date);

        /* append converted descriptor to output writer */
        writer.append(converter.load);

        /* check for unrecognized attributes */
        converter.checkUnrecognized(descriptor, currentFile);

        counter++;
      }
    }

    /* wrap up */
    closeAllWriters();
    System.out.println(
      "\nTHIS MACHINE KILLS FASCISTS\n" + counter + " descriptor" +
          (counter < 1 || counter > 1 ? "s" : "") + " converted"
    );
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