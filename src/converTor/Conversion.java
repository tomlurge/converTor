package converTor;

import converTor.converter.Convert;
import converTor.converter.Torperf;
import converTor.format.Writer;
import converTor.format.Encoder;
import org.apache.avro.specific.SpecificRecordBase;
import org.torproject.descriptor.*;



public class Conversion {


  Conversion(Descriptor descriptor) throws java.io.IOException, ClassNotFoundException {



    //  TYPE SELECTOR
    //  check of which type the descriptor is
    TypeFactory type = TypeFactory.getDescriptorType(descriptor);


    //  INITIATE CONVERSION
    //  todo    do the generic magic on the converter type

    Class<?> claz = Class.forName("converter." + type.clas);
    Convert<? extends Convert> c = new Convert();
    c.load = (SpecificRecordBase) (descriptor);

    c.type = type;  // 'load' and 'date' are set through conversion
    System.out.println(c.load); // test

    //  GET ENCODER
    Main.encoder e = type.encoder;

    //  GET WRITER
    Writer w = WriterFactory.getWriter(type.name, c.date);

    //  WRITE TO OUTPUT
    write(e,w,c.load);


  }


  void write(Encoder e, Writer w, SpecificRecordBase r) {

    //  todo    depending on format and type

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

