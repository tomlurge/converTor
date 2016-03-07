package converTor;

import java.io.*;
import java.util.*;

import org.torproject.descriptor.*;


public class Controller {

  //  SET UP ITERATOR OVER INPUT DESCRIPTOR FILES
  Controller(String inPath, int maxFiles) throws java.io.IOException {

    DescriptorReader descriptorReader = DescriptorSourceFactory.createDescriptorReader();
    descriptorReader.addDirectory(new File(inPath));
    descriptorReader.setMaxDescriptorFilesInQueue(maxFiles);
    Iterator<DescriptorFile> descriptorFiles = descriptorReader.readDescriptors();

    while (descriptorFiles.hasNext()) {
      //  initialize iterator
      DescriptorFile descriptorFile = descriptorFiles.next();
      //  handle exceptions
      if (null != descriptorFile.getException()) {
        System.err.print(descriptorFile.getException()
            + "\n    in " + descriptorFile.getFileName() + "\n");
      }

      //  initiate conversion according to type
      for (Descriptor descriptor : descriptorFile.getDescriptors()) {

        new Converter(descriptor);


        //  handle unrecognized attributes
        //  todo  is this a good time to ask this question?
        if (!descriptor.getUnrecognizedLines().isEmpty()) {
          System.err.println("Unrecognized lines in "
              + descriptorFile.getFileName() + ":");
          System.err.println(descriptor.getUnrecognizedLines());
        }


      }

    }

  }

}