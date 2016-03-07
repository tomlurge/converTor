package converTor;

import java.io.*;
import java.util.*;

import converTor.convert.Torperf;
import converTor.util.ConvertResult;
import converTor.util.ConvertType;
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

          /*

          // todo  make it one method with parameters
          Conversion c = new Conversion(descriptor);

          TODO Class Conversion
              // in constructor of class Conversion
              c.type = c.getType(descriptor);
              c.load = c.convert(descriptor, type.convertType)
              System.out.println(c.load); // test
              c.date = c.getDate(load)
              c.code = EncoderFactory.get(type)
              c.writ = WriterFactory.get(type,date)
              // inner class
              Type // was: ConvertType (DescriptorType)
              // methods
              getType // switch
              convert // runs appropriate convert.*
              getDate // from converted


           */

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


          ConvertResult converted = Torperf
              .convert((TorperfResult) descriptor);
          Main.writers
              .<TorperfResult>get(ConvertType.torperfType, converted.date)  // crazy generics
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
        }
      }

    }

  }

}