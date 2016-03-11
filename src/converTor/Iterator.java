package converTor;

import java.io.*;
import org.torproject.descriptor.*;


public class Iterator {


  //  descriptorFiles   FILE ITERATOR
  private java.util.Iterator<DescriptorFile> descriptorFiles;


  //  Iterator    SETUP FILE ITERATOR
  Iterator(String inPath, int maxFiles) throws java.io.IOException {
    DescriptorReader descriptorReader =
        DescriptorSourceFactory.createDescriptorReader();
    descriptorReader.addDirectory(new File(inPath));
    descriptorReader.setMaxDescriptorFilesInQueue(maxFiles);
    descriptorFiles = descriptorReader.readDescriptors();
  }


  //  hasNextFile   CHECK FOR NEXT
  public boolean hasNextFile = descriptorFiles.hasNext();


  //  getNextFile   GETTER
  DescriptorFile getNextFile() {
    DescriptorFile nextFile = descriptorFiles.next();
    //  check for exceptions
    if (null != nextFile.getException()) {
      System.err.print(nextFile.getException()
          + "\n    in " + nextFile.getFileName() + "\n");
    }
    return nextFile;
  }


  //  checkUnrecognized   CHECK FOR UNRECOGNIZED ATTRIBUTES
  void checkUnrecognized(Descriptor descriptor, DescriptorFile descriptorFile) {
    if (!descriptor.getUnrecognizedLines().isEmpty()) {
      System.err.println("Unrecognized lines in "
          + descriptorFile.getFileName() + ":");
      System.err.println(descriptor.getUnrecognizedLines());
    }
  }


}