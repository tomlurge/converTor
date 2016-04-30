package converTor;

import java.io.File;
import java.io.IOException;

import org.torproject.descriptor.*;

/*
 *  Read all descriptors provided in the 'in' directory
 *  and for each initiate conversion to the desired format
 */

class Base {

  static String[] commandLineArguments;
  Args args;
  Types type;
  Writers writers;
  Iterator iterator;


  public static void main(String[] args) {
    Base base = new Base(args);
    //  START CONVERSION
    try {
      base.run();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  Base(String[] args) {
    //  MAKE COMMAND LINE ARGS AVAILABLE TO SINGLETON 'ARGS'
    commandLineArguments = args;
    //  SETUP ARGUMENTS SINGLETON
    this.args = Args.INSTANCE;
    //  SETUP OUTPUT WRITERS MAP SINGLETON
    this.writers = Writers.INSTANCE;
  }

  void run() throws IOException {
    int counter = 0;

    //  SET UP ITERATOR OVER INPUT FILES
    iterator = new Iterator(args.getInPath(), args.getMaxFiles());
    //  ITERATE OVER INPUT FILES
    while (iterator.descriptorFiles.hasNext()) {
      DescriptorFile currentFile = iterator.getNextFile();
      //  ITERATE OVER DESCRIPTORS IN EACH INPUT FILE
      for (Descriptor descriptor : currentFile.getDescriptors()) {

        //  DETERMINE DESCRIPTOR TYPE
        type = Types.getDescriptorType(descriptor);

        //  INITIALIZE CONVERTER
        Convert<? extends Convert> converter = null;
        try {
          converter = type.converter.newInstance();
        } catch (InstantiationException|IllegalAccessException e) {
          e.printStackTrace();
        }

        //  CONVERT DESCRIPTOR
        converter.convert(descriptor);

        //  todo    remove test
        //  System.out.println(converter.load);

        //  GET APPROPRIATE OUTPUT WRITER
        Write writer = writers.getWriter(converter.type, converter.date);

        //  APPEND CONVERTED DESCRIPTOR TO OUTPUT WRITER
        writer.append(converter.load);

        //  CHECK FOR UNRECOGNIZED ATTRIBUTES
        converter.checkUnrecognized(descriptor, currentFile);

        counter++;
      }
    }

    //  WRAP UP
    closeAllWriters();
    System.out.println(
      "\nTHIS MACHINE KILLS FASCISTS\n" + counter + " descriptor" +
          (counter < 1 || counter > 1 ? "s" : "") + " converted"
    );
    System.exit(0);
  }


  //  FILE ITERATOR
  private class Iterator {

    private java.util.Iterator<DescriptorFile> descriptorFiles;

    Iterator(String inPath, int maxFiles) {
      DescriptorReader descriptorReader =
          DescriptorSourceFactory.createDescriptorReader();
      descriptorReader.addDirectory(new File(inPath));
      descriptorReader.setMaxDescriptorFilesInQueue(maxFiles);
      descriptorFiles = descriptorReader.readDescriptors();
    }

    private DescriptorFile getNextFile() {
      DescriptorFile nextFile = descriptorFiles.next();
      //  check for exceptions
      if (null != nextFile.getException()) {
        System.err.print(nextFile.getException()
            + "\n    in " + nextFile.getFileName() + "\n");
      }
      return nextFile;
    }

  }


  //  WRAP UP AFTER ITERATOR HAS FINISHED ITERATING OVER INCOMING DESCRIPTORS
  void closeAllWriters() throws IOException {
    for (Write write : writers.getAllWriters()) {
      write.close();
    }
  }


}