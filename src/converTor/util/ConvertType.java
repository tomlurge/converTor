package converTor.util;

import java.io.File;
import java.io.IOException;
import org.apache.avro.Schema;


/*
 * descriptor types and their attributes
 */

public class ConvertType {

  public String name;      // identifying name of the DescriptorType
  public String clasName;  // Name of class (like 'name', but First Letter Capitalized) // todo rename to 'clas'
  public Schema avsc;      // parsed JSON schema

  ConvertType(String name) {
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

  public static ConvertType relayType          = new ConvertType("relay");
  public static ConvertType bridgeType         = new ConvertType("bridge");
  public static ConvertType relayExtraType     = new ConvertType("relayExtra");
  public static ConvertType bridgeExtraType    = new ConvertType("bridgeExtra");
  public static ConvertType relayVoteType      = new ConvertType("relayVote");
  public static ConvertType relayConsensusType = new ConvertType("relayConsensus");
  public static ConvertType bridgeStatusType   = new ConvertType("bridgeStatus");
  public static ConvertType tordnselType       = new ConvertType("tordnsel");
  public static ConvertType torperfType        = new ConvertType("torperf");

}