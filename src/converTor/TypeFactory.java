package converTor;

import converTor.converter.Convert;
import converTor.format.Encoder;
import org.apache.avro.Schema;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.*;

import java.io.File;
import java.io.IOException;


/*
 * descriptor types and their attributes
 */



public enum TypeFactory {

  RELAY("relay"),
  BRIDGE("bridge"),
  RELAY_EXTRA("relayExtra"),
  BRIDGE_EXTRA("bridgeExtra"),
  RELAY_VOTE("relayVote"),
  RELAY_CONSENSUS("relayConsensus"),
  BRIDGE_STATUS("bridgeStatus"),
  TORDNSEL("tordnsel"),
  TORPERF("torperf");

// todo   remove after testing
/*
  public static final Type RELAY          = new Type("relay");
  public static final Type BRIDGE         = new Type("bridge");
  public static final Type RELAY_EXTRA     = new Type("relayExtra");
  public static final Type BRIDGE_EXTRA    = new Type("bridgeExtra");
  public static final Type RELAYVOTE      = new Type("relayVote");
  public static final Type RELAYCONSENSUS = new Type("relayConsensus");
  public static final Type BRIDGESTATUS   = new Type("bridgeStatus");
  public static final Type EXITLIST       = new Type("tordnsel");
  public static final Type TORPERF        = new Type("torperf");
*/

  public String name;       // identifying name of the DescriptorType
  public String clas;       // Name of class (First Letter Capitalized)
  public Schema avsc;       // parsed JSON schema
  public Object cast;       // metrics-lib class to cast to
  public Convert converter; // Converter
  public Encoder encoder;   // Encoder, according to format
  // public Writer writer;  // todo does this make sense?

  private TypeFactory(String name) {
    this.name = name;
    this.clas = name.substring(0, 1).toUpperCase() + name.substring(1);
    try {
      Schema.Parser parser = new Schema.Parser();
      this.avsc = parser.parse(
          new File("src/converTor/avro/schemata/" + clas + ".avsc")
      );
    } catch (IOException e) {
      System.err.println("IOException: " + e.getMessage());
      e.printStackTrace();
    }
    try {
      if (name == "relay") this.cast =
          Class.forName("org.torproject.descriptor.RelayServerDescriptor");
      else if (name == "bridge") this.cast =
          Class.forName("org.torproject.descriptor.BridgeServerDescriptor");
      else if (name == "relayExtra") this.cast =
          Class.forName("org.torproject.descriptor.RelayExtraInfoDescriptor");
      else if (name == "bridgeExtra") this.cast =
          Class.forName("org.torproject.descriptor.BridgeExtraInfoDescriptor");
      else if (name == "relayVote") this.cast =
          Class.forName("org.torproject.descriptor.RelayNetworkStatusVote");
      else if (name == "relayConsensus") this.cast =
          Class.forName("org.torproject.descriptor.RelayNetworkStatusConsensus");
      else if (name == "bridgeStatus") this.cast =
          Class.forName("org.torproject.descriptor.BridgeNetworkStatus");
      else if (name == "tordnsel") this.cast =
          Class.forName("org.torproject.descriptor.ExitList");
      else if (name == "torperf") this.cast =
          Class.forName("org.torproject.descriptor.TorperfResult");
    } catch (ClassNotFoundException e) {
      System.err.println("ClassNotFoundException: " + e.getMessage());
    }
    this.converter = null;      //  TODO
    this.encoder = null;        //  TODO
    // this.writer = null;         //  TODO
  }


  public static TypeFactory getDescriptorType(Descriptor desc) {
    TypeFactory type = null;
    if (desc instanceof RelayServerDescriptor) type = RELAY;
    else if (desc instanceof BridgeServerDescriptor) type = BRIDGE;
    else if (desc instanceof RelayExtraInfoDescriptor) type = RELAY_EXTRA;
    else if (desc instanceof BridgeExtraInfoDescriptor) type = BRIDGE_EXTRA;
    else if (desc instanceof RelayNetworkStatusVote) type = RELAY_VOTE;
    else if (desc instanceof RelayNetworkStatusConsensus) type = RELAY_CONSENSUS;
    else if (desc instanceof BridgeNetworkStatus) type = BRIDGE_STATUS;
    else if (desc instanceof ExitList) type = TORDNSEL;
    else if (desc instanceof TorperfResult) type = TORPERF;
    return type;
  }

}
