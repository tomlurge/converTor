package converTor;

import java.io.*;
import java.util.*;

//  metrics-lib
import org.torproject.descriptor.*;

//  command line interface
import org.apache.commons.cli.*;

import static converTor.DescriptorType.*;



/*
 *
 *  Read all descriptors provided in the in directory
 *  and initiate conversion to the declared format
 *
 */


public class ConverTor {

  //  ARGUMENT DEFAULTS
  public static boolean verbose = false;
  public static boolean compressed = false;
  public static boolean pretty = false;
  public static boolean json = false;
  public static boolean avro = false;
  public static boolean parquet = true;
  public static String format = "parquet";
  public static String inPath = "data/in/";
  public static String outPath = "data/out/" + format + "/";
  public static String suffix = "";
  private static int max = 20;
  public static String outputFileEnding;


  public static void main(String[] args) throws IOException {

    //  COMMAND LINE ARGUMENTS
    //  https://commons.apache.org/proper/commons-cli/usage.html
    Options options = new Options();
    options.addOption("h", "help", false,
            "display this help text");
    options.addOption("f", "format", true,
            "e.g. '-f=json'\n" +
                    "to which serialization format to convert\n" +
                    "defaults to 'parquet'\n" +
                    "possible values are 'avro', 'parquet' and 'json'");
    options.addOption("s", "suffix", true,
            "e.g. '-s=_Suffix'");
    options.addOption("i", "inPath", true,
            "e.g. '-i=/my/data/in/dir'\n" +
                    "from which directory to read data\n" +
                    "defaults to 'data/in/'");
    options.addOption("o", "outPath", true,
            "e.g. '-o=/my/data/out/dir'\n" +
                    "to which directory to write the converted data\n" +
                    "defaults to 'data/out/<format>/'");
    options.addOption("v", "verbose", false,
            "encode 'jagged' maps (objects with non-uniform attribute sets) \n" +
                    "additionally as 'flattened' arrays (with suffix '_FLAT')\n" +
                    "and include all properties with 'null' values (this is only\n" +
                    "relevant for the JSON encoding).\n" +
                    "some SQL engines like Apache Drill require this.");
    //  TODO  implement multi-file compression for JSON
    options.addOption("c", "compressed", false,
            "uses gz codec for JSON and snappy codec for Avro and Parquet");
    options.addOption("p", "pretty", false,
            "does generate pretty printed JSON output");
    options.addOption("m", "max", true,
            "maximum file readers to open, \n" +
                    "e.g. '-m=5'\n" +
                    "defaults to 20");

    //  PARSE ARGUMENTS, SET PARAMETERS
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = null;
    try {
      cmd = parser.parse(options, args);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if(cmd.hasOption("h")) {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp( "ConverTor\n", options );
    }

    if(cmd.hasOption("f") && cmd.getOptionValue("f") != null) {
      String formatArgument = cmd.getOptionValue("f").toLowerCase();
      if (formatArgument.equals("avro")) {
        avro = true;
        json = false;
        parquet = false;
        format = formatArgument;
        outPath = "data/out/" + format + "/";
      }
      else if (formatArgument.equals("json")) {
        avro = false;
        json = true;
        parquet = false;
        format = formatArgument;
        outPath = "data/out/" + format + "/";
      }
      else if (formatArgument.equals("parquet")) {
        avro = false;
        json = false;
        parquet = true;
        format = formatArgument;
        outPath = "data/out/" + format + "/";
      }
      else  {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ConverTor\n\n" +
                "Sorry, but " + cmd.getOptionValue("f") +
                " is not a valid format.\n\n", options );
        // System.out.println("\nShutting down");
        System.exit(1);
      }
    }
    if(cmd.hasOption("s") && cmd.getOptionValue("s") != null) {
      //  TODO  sanitize
      suffix  = cmd.getOptionValue("s");
    }
    if(cmd.hasOption("i") && cmd.getOptionValue("i") != null) {
      //  TODO  sanitize
      inPath = cmd.getOptionValue("i");
    }
    if(cmd.hasOption("o") && cmd.getOptionValue("o") != null) {
      //  TODO  sanitize
      outPath = cmd.getOptionValue("o");
    }
    if(cmd.hasOption("v")) {
      verbose = true;
    }
    if(cmd.hasOption("p")) {
      pretty = true;
    }
    if(cmd.hasOption("c")) {
      compressed = true;
    }
    outputFileEnding =
        suffix
        + "."
        + ( compressed && avro ? "snappy." : "")
        //  + ( compressed && parquet ? "snappy." : "") todo implement
        + format
        + ( compressed && json ? ".gz" : "");

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

/*      //  relay
        if (descriptor instanceof RelayServerDescriptor) {
          Converted converted = ConvertRelay
              .convert((RelayServerDescriptor) descriptor);
          TypeWriter
              .get(relayType, converted.date)
              .append(converted.load);
        }
        //  bridge
        if (descriptor instanceof BridgeServerDescriptor) {
          Converted converted = ConvertBridge
              .convert((BridgeServerDescriptor) descriptor);
          TypeWriter
              .get(bridgeType, converted.date)
              .append(converted.load);
        }
        //  relayExtra
        if (descriptor instanceof RelayExtraInfoDescriptor) {
          Converted converted = ConvertRelayExtra
              .convert((RelayExtraInfoDescriptor) descriptor);
          TypeWriter
              .get(relayExtraType, converted.date)
              .append(converted.load);
        }
        //  bridgeExtra
        if (descriptor instanceof BridgeExtraInfoDescriptor) {
          Converted converted = ConvertBridgeExtra
              .convert((BridgeExtraInfoDescriptor) descriptor);
          TypeWriter
              .get(bridgeExtraType, converted.date)
              .append(converted.load);
        }
        //  relayVote
        if (descriptor instanceof RelayNetworkStatusVote) {
          Converted converted = ConvertRelayVote
              .convert((RelayNetworkStatusVote) descriptor);
          TypeWriter
              .get(relayVoteType, converted.date)
              .append(converted.load);
        }
        //  relayConsensus
        if (descriptor instanceof RelayNetworkStatusConsensus) {
          Converted converted = ConvertRelayConsensus
              .convert((RelayNetworkStatusConsensus) descriptor);
          TypeWriter
              .get(relayConsensusType, converted.date)
              .append(converted.load);
        }
        //  bridgeStatus
        if (descriptor instanceof BridgeNetworkStatus) {
          Converted converted = ConvertBridgeStatus
              .convert((BridgeNetworkStatus) descriptor);
          TypeWriter
              .get(bridgeStatusType, converted.date)
              .append(converted.load);
        }
        //  tordnsel
        if (descriptor instanceof ExitList) {
          Converted converted = ConvertExitList
              .convert((ExitList) descriptor);
          TypeWriter
              .get(tordnselType, converted.date)
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