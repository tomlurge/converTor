package converTor;
import org.torproject.descriptor.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.DescriptorFile;
import org.torproject.descriptor.DescriptorReader;
import org.torproject.descriptor.DescriptorSourceFactory;
import org.torproject.descriptor.RelayNetworkStatusConsensus;

public class NewWriterObject<T extends Descriptor> {
  NewWriterObject(String date) throws IOException {
  }
  public static void main(String[] args) throws Exception {
    DescriptorReader descriptorReader =
        DescriptorSourceFactory.createDescriptorReader();
    descriptorReader.addDirectory(new File("descriptors"));
    Iterator<DescriptorFile> descriptorFiles =
        descriptorReader.readDescriptors();
    while (descriptorFiles.hasNext()) {
      DescriptorFile descriptorFile = descriptorFiles.next();
      for (Descriptor descriptor : descriptorFile.getDescriptors()) {
        // -> doesn't work!  new NewWriterObject<descriptor...>("2016-02-18");
      }
    }
    System.out.println("klappt");
  }
}

