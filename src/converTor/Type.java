package converTor;

import org.apache.avro.Schema;

import java.io.File;
import java.io.IOException;


/*
 * descriptor types and their attributes
 */

public class Type {

  public String name;      // identifying name of the DescriptorType
  public String clasName;  // Name of class (like 'name', but First Letter Capitalized) // todo rename to 'clas'
  public Schema avsc;      // parsed JSON schema

  Type(String name) {
    this.name = name;
    this.clasName = name.substring(0, 1).toUpperCase() + name.substring(1);
    try {
      Schema.Parser parser = new Schema.Parser();
      this.avsc = parser.parse(
          new File("src/converTor/avro/schemata/" + clasName + ".avsc")
      );
    } catch (IOException e) {
      System.err.println("IOException: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static Type relayType          = new Type("relay");
  public static Type bridgeType         = new Type("bridge");
  public static Type relayExtraType     = new Type("relayExtra");
  public static Type bridgeExtraType    = new Type("bridgeExtra");
  public static Type relayVoteType      = new Type("relayVote");
  public static Type relayConsensusType = new Type("relayConsensus");
  public static Type bridgeStatusType   = new Type("bridgeStatus");
  public static Type tordnselType       = new Type("tordnsel");
  public static Type torperfType        = new Type("torperf");

}
