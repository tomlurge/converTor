package converTor;

import org.apache.commons.cli.*;  // command line interface


public class Config {

  /*

  todo

  private Config c;

  init(args) {
     if (c == null) c = new Config(args);
     // done already, no else required
  }

  probably change all  setters to
      c.<...> = ...
  and all getters to
     return c.<...>;

   */



  //  ARGUMENT DEFAULTS
  private static boolean verbose = false;
  private static boolean compressed = false;
  private static boolean pretty = false;
  private static boolean json = false;
  private static boolean avro = false;
  private static boolean parquet = true;
  private static String format = "parquet";
  private static String inPath = "data/in/";
  private static String outPath = "data/out/" + getFormat() + "/";
  private static String suffix = "";
  private static int max = 20;
  private static String outputFileEnding;


  //  EVALUATE COMMAND LINE ARGUMENTS
  Config(String[] commandLineArguments) {

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
      cmd = parser.parse(options, commandLineArguments);
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
        setAvro(true);
        setJson(false);
        setParquet(false);
        setFormat(formatArgument);
        setOutPath("data/out/" + getFormat() + "/");
      }
      else if (formatArgument.equals("json")) {
        setAvro(false);
        setJson(true);
        setParquet(false);
        setFormat(formatArgument);
        setOutPath("data/out/" + getFormat() + "/");
      }
      else if (formatArgument.equals("parquet")) {
        setAvro(false);
        setJson(false);
        setParquet(true);
        setFormat(formatArgument);
        setOutPath("data/out/" + getFormat() + "/");
      }
      else  {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ConverTor\n\n" +
            cmd.getOptionValue("f") + " is not a valid format.\n\n", options );
        System.exit(1);
      }
    }
    if(cmd.hasOption("s") && cmd.getOptionValue("s") != null) {
      setSuffix(cmd.getOptionValue("s"));
    }
    if(cmd.hasOption("i") && cmd.getOptionValue("i") != null) {
      setInPath(cmd.getOptionValue("i"));
    }
    if(cmd.hasOption("o") && cmd.getOptionValue("o") != null) {
      setOutPath(cmd.getOptionValue("o"));
    }
    if(cmd.hasOption("v")) {
      setVerbose(true);
    }
    if(cmd.hasOption("p")) {
      setPretty(true);
    }
    if(cmd.hasOption("c")) {
      setCompressed(true);
    }
    setOutputFileEnding(getSuffix()
        + "."
        + ( isCompressed() && isAvro() ? "snappy." : "")
        + ( isCompressed() && isParquet() ? "snappy." : "")
        + getFormat()
        + ( isCompressed() && isJson() ? ".gz" : ""));

    //  PARAMETERS SET
    //  TODO  remove after testing
    System.out.println("format = " + getFormat());
    System.out.println("suffix = " + getSuffix());
    System.out.println("inPath = " + getInPath());
    System.out.println("outPath = " + getOutPath());
    System.out.println("verbose = " + isVerbose());
    System.out.println("compressed = " + isCompressed());
    System.out.println("pretty printed JSON = " + isPretty());
    System.out.println("outputFileEnding = " + getOutputFileEnding());
    System.out.println();

  }

  public static String getInPath() {
    return inPath;
  }

  private static void setInPath(String inPath) {
    Config.inPath = inPath;
  }

  public static boolean isVerbose() {
    return verbose;
  }

  private static void setVerbose(boolean verbose) {
    Config.verbose = verbose;
  }

  public static boolean isCompressed() {
    return compressed;
  }

  private static void setCompressed(boolean compressed) {
    Config.compressed = compressed;
  }

  public static boolean isPretty() {
    return pretty;
  }

  private static void setPretty(boolean pretty) {
    Config.pretty = pretty;
  }

  public static boolean isJson() {
    return json;
  }

  public static void setJson(boolean json) {
    Config.json = json;
  }

  public static boolean isAvro() {
    return avro;
  }

  public static void setAvro(boolean avro) {
    Config.avro = avro;
  }

  public static boolean isParquet() {
    return parquet;
  }

  public static void setParquet(boolean parquet) {
    Config.parquet = parquet;
  }

  public static String getFormat() {
    return format;
  }

  public static void setFormat(String format) {
    Config.format = format;
  }

  public static String getOutPath() {
    return outPath;
  }

  public static void setOutPath(String outPath) {
    Config.outPath = outPath;
  }

  public static String getSuffix() {
    return suffix;
  }

  public static void setSuffix(String suffix) {
    Config.suffix = suffix;
  }

  public static int getMax() {
    return max;
  }

  public static void setMax(int max) {
    Config.max = max;
  }

  public static String getOutputFileEnding() {
    return outputFileEnding;
  }

  public static void setOutputFileEnding(String outputFileEnding) {
    Config.outputFileEnding = outputFileEnding;
  }


}
