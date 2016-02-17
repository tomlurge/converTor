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
  //  String prefix = "";
  //  String name = "result";
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
            "does generate .gz archive, \n" +
                    "(this is only relevant for JSON)");
    options.addOption("p", "pretty", false,
            "does generate pretty printed JSON output, \n" +
                    "(obviously this is only relevant for JSON too)");
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
        parquet = false;
        format = formatArgument;
      }
      else if (formatArgument.equals("json")) {
        json = true;
        parquet = false;
        format = formatArgument;
      }
      else if (!formatArgument.equals("parquet"))  {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ConverTor\n\n" +
                "Sorry, but " + cmd.getOptionValue("f") +
                " is not a valid format.\n\n", options );
      }
    }
    if(cmd.hasOption("s") && cmd.getOptionValue("s") != null) {
      suffix  = cmd.getOptionValue("s");
    }
    if(cmd.hasOption("i") && cmd.getOptionValue("i") != null) {
      inPath = cmd.getOptionValue("i");
    }
    if(cmd.hasOption("o") && cmd.getOptionValue("o") != null) {
      outPath = cmd.getOptionValue("o");
    }
    if(cmd.hasOption("v")) {
      verbose = true;
    }
    if(cmd.hasOption("p")) {
      pretty = true;
    }
    if(cmd.hasOption("c") && verbose && json) {
      compressed = true;
    }
    outputFileEnding = suffix + "." + format + ( compressed ? ".gz" : "");

    //  PARAMETERS SET TODO  remove after testing
    System.out.println("format = " + format);
    System.out.println("suffix = " + suffix);
    System.out.println("inPath = " + inPath);
    System.out.println("outPath = " + outPath);
    System.out.println("verbose = " + verbose);
    System.out.println("compressed JSON = " + compressed);
    System.out.println("pretty printed JSON = " + pretty);
    System.out.println("outputFileEnding = " + outputFileEnding);


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
          TypeWriter.dispatch(ConvertRelay.convert((RelayServerDescriptor) descriptor));
        }
        //  bridge
        if (descriptor instanceof BridgeServerDescriptor) {
          TypeWriter.dispatch(ConvertBridge.convert((BridgeServerDescriptor) descriptor));
        }
        //  relayExtra
        if (descriptor instanceof RelayExtraInfoDescriptor) {
          TypeWriter.dispatch(ConvertRelayExtra.convert((RelayExtraInfoDescriptor) descriptor));
        }
        //  bridgeExtra
        if (descriptor instanceof BridgeExtraInfoDescriptor) {
          TypeWriter.dispatch(ConvertBridgeExtra.convert((BridgeExtraInfoDescriptor) descriptor));
        }
        //  relayVote
        if (descriptor instanceof RelayNetworkStatusVote) {
          TypeWriter.dispatch(ConvertRelayVote.convert((RelayNetworkStatusVote) descriptor));
        }
        //  relayConsensus
        if (descriptor instanceof RelayNetworkStatusConsensus) {
          TypeWriter.dispatch(ConvertRelayConsensus.convert((RelayNetworkStatusConsensus) descriptor));
        }
        //  bridgeStatus
        if (descriptor instanceof BridgeNetworkStatus) {
          TypeWriter.dispatch(ConvertBridgeStatus.convert((BridgeNetworkStatus) descriptor));
        }
        //  tordnsel
        if (descriptor instanceof ExitList) {
          TypeWriter.dispatch(ConvertExitList.convert((ExitList) descriptor));
        }
*/
        //  torperf
        if (descriptor instanceof TorperfResult) {

          Converted converted = ConvertTorperf.convert((TorperfResult) descriptor);
          TypeWriter typeWriter = TypeWriter.get(torperfType, converted.date);
          typeWriter.append(converted.load);
          /*  more elegant but somewhat unusual
          TypeWriter
              .get(torperfType, converted.date)
              .append(converted.load);
          */
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

    //  after all descriptors have been converted flush writers to disk and clean up
    TypeWriter.wrapUp();

  } // end of  main

}