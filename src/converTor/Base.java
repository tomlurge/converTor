package converTor;
import java.io.*;

import org.torproject.descriptor.*;

/*
 *  Read all descriptors provided in the 'in' directory
 *  and for each initiate conversion to the desired format
 */

public class Base {

  static String[] commandLineArguments;
  Args args;
  Write write;
  Types type;
  Writers writers;
  Iterator iterator;

  Integer testCount = 0;

  public static void main(String[] args) {
    Base base = new Base(args);
    //  START CONVERSION
    try {
      base.run();
    } catch (IOException e) {
      //  todo    it seems a bit lazy to throw exceptions all over the place
      //          and only handle them once, here
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

    //  SET UP ITERATOR OVER INPUT FILES
    iterator = new Iterator(args.getInPath(), args.getMaxFiles());
    //  ITERATE OVER INPUT FILES
    while (iterator.descriptorFiles.hasNext()) {
      DescriptorFile currentFile = iterator.getNextFile();
      //  ITERATE OVER DESCRIPTORS IN EACH INPUT FILE
      for (Descriptor descriptor : currentFile.getDescriptors()) {

        //  DETERMINE DESCRIPTOR TYPE
        type = Types.getDescriptorType(descriptor);

        //  CONVERT DESCRIPTOR
        //  todo    parametrize converter according to type e.g. like this:
        //  choose the right Convert Class
        //  Class<?> ConvertClass = null;
        //  try {
        //    ConvertClass = Class.forName("converTor.Convert" + type.clas);
        //  } catch (ClassNotFoundException e) { e.printStackTrace();}
        //  Convert<?> c = ConvertClass(descriptor);
        //  todo    and obsolete this hardcoded reference to ConvertTorperf
        Convert<?> converted = new ConvertTorperf(descriptor);

        //  todo    remove after testing
        if (testCount++ == 0) System.out.println("1. descriptor: " + converted.load);


        //  GET APPROPRIATE OUTPUT WRITER
        //  todo    i wonder if I should get a new Write write per descriptor eg
        //              Write write = writers.getWriter(type,date);
        //          may i run into synchronization issues/race conditions
        //          if i reuse the same Write defined above per instance of Base
        //          ?
        write = writers.getWriter(converted.type, converted.date);

        //  APPEND CONVERTED DESCRIPTOR TO OUTPUT WRITER
        write.append(converted.load);

        //  CHECK FOR UNRECOGNIZED ATTRIBUTES
        converted.checkUnrecognized(descriptor, currentFile);
      }
    }

    //  WRAP UP
    closeAllWriters();
    System.out.println("\n" + testCount + " descriptors counted.");
    System.out.println("All done. Hope to see you again soon!");
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

    DescriptorFile getNextFile() {
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
  public void closeAllWriters() throws IOException {
    for (Write write : writers.getAllWriters()) {
      write.close();
    }
  }



}

/*

      //  torperf
      if (descriptor instanceof TorperfResult) {
        ConvertResult converted = Torperf
            .convert((TorperfResult) descriptor);
        Main.writers
            .<TorperfResult>get(Type.torperfType, converted.date)  // crazy generics
            .append(converted.load);

        // making reference to JSON Encoder more explicit
        // WriterObject<TorperfResult> writer = TypeWriter.<TorperfResult>get(torperfType, converted.date);
        // Encoder jsonEncoder = writer.jsonEncoder;
        // writer.append(converted.load, jsonEncoder);  // requires change to WriterObject.append() signature
      }

      ////////////////////////////////////////////////////

      //  relay
      if (descriptor instanceof RelayServerDescriptor) {
       Converted converted = ConvertRelay
           .convert((RelayServerDescriptor) descriptor);
       TypeWriter
           .<RelayServerDescriptor>get(RELAY, converted.date)
           .append(converted.load);
      }
      //  bridge
      if (descriptor instanceof BridgeServerDescriptor) {
       Converted converted = ConvertBridge
           .convert((BridgeServerDescriptor) descriptor);
       TypeWriter
           .<BridgeServerDescriptor>get(BRIDGE, converted.date)
           .append(converted.load);
      }
      //  relayExtra
      if (descriptor instanceof RelayExtraInfoDescriptor) {
       Converted converted = ConvertRelayExtra
           .convert((RelayExtraInfoDescriptor) descriptor);
       TypeWriter
           .<RelayExtraInfoDescriptor>get(relayExtraType, converted.date)
           .append(converted.load);
      }
      //  bridgeExtra
      if (descriptor instanceof BridgeExtraInfoDescriptor) {
       Converted converted = ConvertBridgeExtra
           .convert((BridgeExtraInfoDescriptor) descriptor);
       TypeWriter
           .<BridgeExtraInfoDescriptor>get(bridgeExtraType, converted.date)
           .append(converted.load);
      }
      //  relayVote
      if (descriptor instanceof RelayNetworkStatusVote) {
       Converted converted = ConvertRelayVote
           .convert((RelayNetworkStatusVote) descriptor);
       TypeWriter
           .<RelayNetworkStatusVote>get(relayVoteType, converted.date)
           .append(converted.load);
      }
      //  relayConsensus
      if (descriptor instanceof RelayNetworkStatusConsensus) {
       Converted converted = ConvertRelayConsensus
           .convert((RelayNetworkStatusConsensus) descriptor);
       TypeWriter
           .<RelayNetworkStatusConsensus>get(relayConsensusType, converted.date)
           .append(converted.load);
      }
      //  bridgeStatus
      if (descriptor instanceof BridgeNetworkStatus) {
       Converted converted = ConvertBridgeStatus
           .convert((BridgeNetworkStatus) descriptor);
       TypeWriter
           .<BridgeNetworkStatus>get(bridgeStatusType, converted.date)
           .append(converted.load);
      }
      //  tordnsel
      if (descriptor instanceof ExitList) {
       Converted converted = ConvertExitList
           .convert((ExitList) descriptor);
       TypeWriter
           .<ExitList>get(tordnselType, converted.date)
           .append(converted.load);
      }
*/
