package converTor;

import converTor.convert.*;
import converTor.util.*;
import org.apache.avro.Schema;
import org.torproject.descriptor.*;

import java.io.File;
import java.io.IOException;


public class Converter {

  /*
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



  Converter(Descriptor descriptor) throws java.io.IOException {










    //  torperf
    //  todo  make it one method with parameters
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

  }

  Type getType(Descriptor descriptor) {
    return null;
  }

  void convert() {  // todo   return type?
  }

  String getDate() {
    return null;
  }
}



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

