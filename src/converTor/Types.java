package converTor;

import java.io.File;
import java.io.IOException;
import org.apache.avro.Schema;
import org.torproject.descriptor.*;

/*
 *  descriptor types and their attributes
 */

enum Types {

  RELAY("Relay"),
  BRIDGE("Bridge"),
  RELAY_EXTRA("RelayExtra"),
  BRIDGE_EXTRA("BridgeExtra"),
  RELAY_VOTE("RelayVote"),
  RELAY_CONSENSUS("RelayConsensus"),
  BRIDGE_STATUS("BridgeStatus"),
  TORDNSEL("Tordnsel"),
  TORPERF("Torperf");


  String name;                         // of descriptor type and class
  Schema avsc;                         // parsed JSON schema
  Class<? extends Convert> converter;  // concrete converter
  Class cast;                          // metrics-lib class to cast to


  Types(String name) {
    this.name = name;
    try {
      Schema.Parser parser = new Schema.Parser();
      this.avsc = parser.parse(
          new File("src/converTor/encoders/schemata/JSON/" + this.name + ".avsc")
      );
    } catch (IOException e) {
      System.err.println("IOException for JSON schema:");
      System.err.println(e.getMessage());
    }
    try {
      String convert = "converTor.Convert";
      this.converter =
          (Class<? extends Convert>) Class.forName(convert + this.name);
    } catch (ClassNotFoundException e) {
      System.err.println("ClassNotFoundException for converter class :");
      System.err.println(e.getMessage());
    }
    try {
      String metrics = "org.torproject.descriptor.";
      switch (name) {
        case "Relay" :
          this.cast = Class.forName(metrics + "RelayServerDescriptor");
          break;
        case  "Bridge" :
          this.cast = Class.forName(metrics + "BridgeServerDescriptor");
          break;
        case "RelayExtra" :
          this.cast = Class.forName(metrics + "RelayExtraInfoDescriptor");
          break;
        case "BridgeExtra" :
          this.cast = Class.forName(metrics + "BridgeExtraInfoDescriptor");
          break;
        case "RelayVote" :
          this.cast = Class.forName(metrics + "RelayNetworkStatusVote");
          break;
        case "RelayConsensus" :
          this.cast = Class.forName(metrics + "RelayNetworkStatusConsensus");
          break;
        case "BridgeStatus" :
          this.cast = Class.forName(metrics + "BridgeNetworkStatus");
          break;
        case "Tordnsel" :
          this.cast = Class.forName(metrics + "ExitList");
          break;
        case "Torperf" :
          this.cast = Class.forName(metrics + "TorperfResult");
          break;
      }
    } catch (ClassNotFoundException e) {
      System.err.println("ClassNotFoundException for metrics-lib descriptor class:");
      System.err.println(e.getMessage());
    }
  }


  static Types getDescriptorType(Descriptor desc) {
    Types type = null;
    for (Types t : Types.values()) {
      if ((t.cast).isInstance(desc)) {
        type = t;
        break;
      }
    }
    return type;
  }

}
