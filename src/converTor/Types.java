package converTor;

import org.apache.avro.Schema;
import org.torproject.descriptor.Descriptor;

import java.io.File;
import java.io.IOException;


/*
 *  descriptor types and their attributes
 *  for singleton pattern with enum see docs/java/singleton.md
 */

public enum Types {

  RELAY("relay"),
  BRIDGE("bridge"),
  RELAY_EXTRA("relayExtra"),
  BRIDGE_EXTRA("bridgeExtra"),
  RELAY_VOTE("relayVote"),
  RELAY_CONSENSUS("relayConsensus"),
  BRIDGE_STATUS("bridgeStatus"),
  TORDNSEL("tordnsel"),
  TORPERF("torperf");

  public String name;       // identifying name of the DescriptorType
  public String clas;       // Name of class (First Letter Capitalized)
  public Schema avsc;       // parsed JSON schema
  public String fuln;       // full name of metrics-lib descriptor class
  public String cann;       // canonical name of metrics-lib descriptor class
  public Class cast;        // metrics-lib class to cast to
  //  todo    proper generics, e.g.:  public Convert converter;
  public Class<?> converter; // Converter


  Types(String name) {
    this.name = name;
    this.clas = name.substring(0, 1).toUpperCase() + name.substring(1);
    try {
      Schema.Parser parser = new Schema.Parser();
      this.avsc = parser.parse(
          new File("src/converTor/encoders/schemata/" + clas + ".avsc")
      );
    } catch (IOException e) {
      System.err.println("IOException: " + e.getMessage());
      e.printStackTrace();
    }
    try {
      String metrics = "org.torproject.descriptor.";
      String encoder = "converTor.encoders.classes.";
      switch (name) {
        case "relay" :
          this.fuln = "RelayServerDescriptor";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.RelayServerDescriptorImpl";
          this.converter = Class.forName("converTor.ConvertRelay");
          break;
        case  "bridge" :
          this.fuln = "BridgeServerDescriptor";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.BridgeServerDescriptorImpl";
          this.converter = Class.forName("converTor.ConvertBridge");
          break;
        case "relayExtra" :
          this.fuln = "RelayExtraInfoDescriptor";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.RelayExtraInfoDescriptorImpl";
          this.converter = Class.forName("converTor.ConvertRelayExtra");
          break;
        case "bridgeExtra" :
          this.fuln = "BridgeExtraInfoDescriptor";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.BridgeExtraInfoDescriptorImpl";
          this.converter = Class.forName("converTor.ConvertBridgeExtra");
          break;
        case "relayVote" :
          this.fuln = "RelayNetworkStatusVote";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.RelayNetworkStatusVoteImpl";
          this.converter = Class.forName("converTor.ConvertRelayVote");
          break;
        case "relayConsensus" :
          this.fuln = "RelayNetworkStatusConsensus";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.RelayNetworkStatusConsensusImpl";
          this.converter = Class.forName("converTor.ConvertRelayConsensus");
          break;
        case "bridgeStatus" :
          this.fuln = "BridgeNetworkStatus";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.BridgeNetworkStatusImpl";
          this.converter = Class.forName("converTor.ConvertBridgeStatus");
          break;
        case "tordnsel" :
          this.fuln = "ExitList";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.ExitListImpl";
          this.converter = Class.forName("converTor.ConvertTordnsel");
          break;
        case "torperf" :
          this.fuln = "TorperfResult";
          this.cast = Class.forName(metrics + this.fuln);
          this.cann = metrics + "impl.TorperfResultImpl";
          this.converter = Class.forName("converTor.ConvertTorperf");
          break;
      }
    } catch (ClassNotFoundException e) {
      System.err.println("ClassNotFoundException: " + e.getMessage());
    }
  }


  public static Types getDescriptorType(Descriptor desc) {
    Types type = null;

    //  TODO    check if this works
    for (Types t : Types.values()) {
      if (desc.getClass().getCanonicalName().equals(t.cann)) {
        type = t;
        break;
      }
    }

    /*  OR - but this doesn't work, for reasons unknown
    for (Types t : Types.values()) {
      Class cast = t.cast;
      if (desc instanceof cast) {
        type = t;
        break;
      }
    }
    */
    /*  OR
    if (desc instanceof RelayServerDescriptor) type = RELAY;
    else if (desc instanceof BridgeServerDescriptor) type = BRIDGE;
    else if (desc instanceof RelayExtraInfoDescriptor) type = RELAY_EXTRA;
    else if (desc instanceof BridgeExtraInfoDescriptor) type = BRIDGE_EXTRA;
    else if (desc instanceof RelayNetworkStatusVote) type = RELAY_VOTE;
    else if (desc instanceof RelayNetworkStatusConsensus) type = RELAY_CONSENSUS;
    else if (desc instanceof BridgeNetworkStatus) type = BRIDGE_STATUS;
    else if (desc instanceof ExitList) type = TORDNSEL;
    else if (desc instanceof TorperfResult) type = TORPERF;
    */
    /*  OR
    //  https://stackoverflow.com/questions/29570767/switch-over-type-in-java
    switch (desc.getClass().getCanonicalName()) {
      case ("org.torproject.descriptor.impl.RelayServerDescriptorImpl") :
        type = RELAY;
        break;
      case ("org.torproject.descriptor.impl.BridgeServerDescriptorImpl") :
        type = BRIDGE;
        break;
      case ("org.torproject.descriptor.impl.RelayExtraInfoDescriptorImpl") :
        type = RELAY_EXTRA;
        break;
      case ("org.torproject.descriptor.impl.BridgeExtraInfoDescriptorImpl") :
        type = BRIDGE_EXTRA;
        break;
      case ("org.torproject.descriptor.impl.RelayNetworkStatusVoteImpl") :
        type = RELAY_VOTE;
        break;
      case ("org.torproject.descriptor.impl.RelayNetworkStatusConsensusImpl") :
        type = RELAY_CONSENSUS;
        break;
      case ("org.torproject.descriptor.impl.BridgeNetworkStatusImpl") :
        type = BRIDGE_STATUS;
        break;
      case ("org.torproject.descriptor.impl.ExitListImpl") :
        type = TORDNSEL;
        break;
      case ("org.torproject.descriptor.impl.TorperfResultImpl") :
        type = TORPERF;
        break;
    }
    */
    return type;
  }

}
