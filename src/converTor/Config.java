package converTor;

import org.apache.commons.cli.*;  // command line interface


public class Config {

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
  public static int max = 20;
  public static String outputFileEnding;


  Config(String[] args) {

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
            cmd.getOptionValue("f") + " is not a valid format.\n\n", options );
        System.exit(1);
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
    if(cmd.hasOption("c")) {
      compressed = true;
    }
    outputFileEnding =
        suffix
            + "."
            + ( compressed && avro ? "snappy." : "")
            + ( compressed && parquet ? "snappy." : "")
            + format
            + ( compressed && json ? ".gz" : "");

  }

}

