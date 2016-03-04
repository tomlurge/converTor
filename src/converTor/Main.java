package converTor;

import java.io.*;
import java.util.*;

import converTor.util.*;
import converTor.convert.*;
import org.torproject.descriptor.*;  // metrics-lib

import static converTor.util.ConvertType.*;  // some constants
import static converTor.Config.*;  // some constants


/*
 *
 *  Read all descriptors provided in the in directory
 *  and initiate conversion to the declared format
 *
 */


public class Main {


  public static void main(String[] args) throws IOException {

    new Config(args);

    //  PARAMETERS SET TODO  remove after testing
    System.out.println("format = " + format);
    System.out.println("suffix = " + suffix);
    System.out.println("inPath = " + inPath);
    System.out.println("outPath = " + outPath);
    System.out.println("verbose = " + verbose);
    System.out.println("compressed = " + compressed);
    System.out.println("pretty printed JSON = " + pretty);
    System.out.println("outputFileEnding = " + outputFileEnding);
    System.out.println();


    // SET UP ITERATOR OVER INPUT DESCRIPTORS
    DescriptorReader descriptorReader = DescriptorSourceFactory.createDescriptorReader();
    descriptorReader.addDirectory(new File(inPath));
    descriptorReader.setMaxDescriptorFilesInQueue(max);
    Iterator<DescriptorFile> descriptorFiles = descriptorReader.readDescriptors();


    // ITERATE OVER INPUT DESCRIPTORS AND INITIATE CONVERSION ACCORDING TO TYPE
    while (descriptorFiles.hasNext()) {
      //  initialize iterator
      DescriptorFile descriptorFile = descriptorFiles.next();
      //  handle exceptions
      if(null != descriptorFile.getException()){
        System.err.print(descriptorFile.getException()
                + "\n    in " + descriptorFile.getFileName() + "\n");
      }
      //  initiate conversion according to type
      for (Descriptor descriptor : descriptorFile.getDescriptors()) {


        //  TODO make it one method with parameters
/*
        //  relay
        if (descriptor instanceof RelayServerDescriptor) {
          Converted converted = ConvertRelay
              .convert((RelayServerDescriptor) descriptor);
          TypeWriter
              .<RelayServerDescriptor>get(relayType, converted.date)
              .append(converted.load);
        }
        //  bridge
        if (descriptor instanceof BridgeServerDescriptor) {
          Converted converted = ConvertBridge
              .convert((BridgeServerDescriptor) descriptor);
          TypeWriter
              .<BridgeServerDescriptor>get(bridgeType, converted.date)
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
        //  torperf
        if (descriptor instanceof TorperfResult) {
          Converted converted = ConvertTorperf
              .convert((TorperfResult) descriptor);
          TypeWriter
              .<TorperfResult>get(torperfType, converted.date)  // crazy generics
              .append(converted.load);
          // making reference to JSON Encoder more explicit
          // WriterObject<TorperfResult> writer = TypeWriter.<TorperfResult>get(torperfType, converted.date);
          // Encoder jsonEncoder = writer.jsonEncoder;
          // writer.append(converted.load, jsonEncoder);  // requires change to WriterObject.append() signature
        }

        //  handle unrecognized attributes
        if (!descriptor.getUnrecognizedLines().isEmpty()) {
          System.err.println("Unrecognized lines in "
                  + descriptorFile.getFileName() + ":");
          System.err.println(descriptor.getUnrecognizedLines());
          continue;
        }
      }
    }

    //  after all descriptors have been converted
    //  close fileWriters (flushing data to disk)
    TypeWriter.wrapUp();
    //  and close the door
    System.out.println("\nDeed done, shutting down.");
    System.exit(42);

  } // end of  main

}