package converTor;

import org.apache.commons.cli.*;  // command line interface


public class Config {

  //  SINGLETON
  private Boolean initialized = false;

  //  ARGUMENT DEFAULTS
  private boolean verbose = false;
  private boolean compressed = false;
  private boolean pretty = false;
  private boolean json = false;
  private boolean avro = false;
  private boolean parquet = true;
  private String format = "parquet";
  private String inPath = "data/in/";
  private String outPath = "data/out/" + getFormat() + "/";
  private String suffix = "";
  private int max = 20;
  private String outputFileEnding;


  //  CONSTRUCTOR
  //  EVALUATES COMMAND LINE ARGUMENTS
  Config(String[] commandLineArguments) {

    if (initialized) return;
    initialized = true;

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
    if(cmd.hasOption("m")) {
      try {
        setMax(Integer.parseInt(cmd.getOptionValue("m")));
      } catch (NumberFormatException e) {
        System.out.println("m/max has to be an integer");
        System.exit(1);
      }
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
    System.out.println("max files = " + getMax());
    System.out.println("outputFileEnding = " + getOutputFileEnding());
    System.out.println("\n");

  }

  public String getInPath() {
    return inPath;
  }
  private void setInPath(String inPath) {
    this.inPath = inPath;
  }

  public boolean isVerbose() {
    return verbose;
  }
  private void setVerbose(boolean verbose) {
    this.verbose = verbose;
  }

  public boolean isCompressed() {
    return compressed;
  }
  private void setCompressed(boolean compressed) {
    this.compressed = compressed;
  }

  public boolean isPretty() {
    return pretty;
  }
  private void setPretty(boolean pretty) {
    this.pretty = pretty;
  }

  public boolean isJson() {
    return json;
  }
  private void setJson(boolean json) {
    this.json = json;
  }

  public boolean isAvro() {
    return avro;
  }
  private void setAvro(boolean avro) {
    this.avro = avro;
  }

  public boolean isParquet() {
    return parquet;
  }
  private void setParquet(boolean parquet) {
    this.parquet = parquet;
  }

  public String getFormat() {
    return format;
  }
  private void setFormat(String format) {
    this.format = format;
  }

  public String getOutPath() {
    return outPath;
  }
  private void setOutPath(String outPath) {
    this.outPath = outPath;
  }

  public String getSuffix() {
    return suffix;
  }
  private void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  public int getMax() {
    return max;
  }
  private void setMax(int max) {
    this.max = max;
  }

  public String getOutputFileEnding() {
    return outputFileEnding;
  }
  private void setOutputFileEnding(String outputFileEnding) {
    this.outputFileEnding = outputFileEnding;
  }


}
