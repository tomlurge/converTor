package converTor;

import java.io.File;
import java.io.IOException;
import org.apache.avro.Schema;
import org.torproject.descriptor.*;

/**
 * Configures descriptor types and their attributes
 */
enum Types {

  /**
   * Initializes singleton per type
   */
  RELAY("Relay"),
  BRIDGE("Bridge"),
  RELAY_EXTRA("RelayExtra"),
  BRIDGE_EXTRA("BridgeExtra"),
  RELAY_VOTE("RelayVote"),
  RELAY_CONSENSUS("RelayConsensus"),
  BRIDGE_STATUS("BridgeStatus"),
  TORDNSEL("Tordnsel"),
  TORPERF("Torperf");

  /**
   * Name of descriptor type and class
   */
  String name;

  /**
   * Parsed JSON schema
   */
  Schema avsc;

  /**
   * Converter by type
   */
  Class<? extends Convert> converter;

  /**
   * Metrics-lib class to cast to
   */
  Class cast;

  /**
   * Sets up and configures type singletons
   * @param name  Name of descriptor type
   */
  Types(String name) {
    this.name = name;
    try {
      Schema.Parser parser = new Schema.Parser();
      this.avsc = parser.parse(
          new File("schema/" + this.name + ".avsc")
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
      System.err.println("ClassNotFoundException for metrics-lib descriptor:");
      System.err.println(e.getMessage());
    }
  }

  /**
   *
   * @param desc  Incoming descriptor
   * @return      Type of incoming descriptor
   */
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
