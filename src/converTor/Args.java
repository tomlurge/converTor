package converTor;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.HelpFormatter;

/*
 *  command line arguments evaluation
 */

public enum Args {

  INSTANCE(Base.commandLineArguments);

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
  private int maxFiles = 20;
  private String outputFileEnding;


  //  EVALUATE COMMAND LINE ARGUMENTS
  Args(String[] commandLineArguments) {

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
            "and include all properties with 'null' values (the latter is\n" +
            "only relevant for the JSON encoding).\n" +
            "some SQL engines like Apache Drill require this.\n" +
            "CAUTION: this option is not supported yet...");
            // depending on fixing a bug in the Avro 1.8.0 JSON encoder
    options.addOption("c", "compressed", false,
        "use gz codec for JSON and snappy codec for Avro and Parquet");
    options.addOption("p", "pretty", false,
        "generate pretty printed JSON output. \n" +
            "CAUTION: this option is not supported yet...");
            // depending on fixing a bug in the Avro 1.8.0 JSON encoder
    options.addOption("m", "maxFiles", true,
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
        setMaxFiles(Integer.parseInt(cmd.getOptionValue("m")));
      } catch (NumberFormatException e) {
        System.out.println("m/maxFiles has to be an integer");
        System.exit(1);
      }
    }
    setOutputFileEnding(getSuffix()
        + "."
        + ( isCompressed() && (isAvro() || isParquet()) ? "snappy." : "")
        + getFormat()
        + ( isCompressed() && isJson() ? ".gz" : ""));

    //  PARAMETERS SET
    System.out.println(
        "\nConverter from Tor CollecTor data to JSON, Parquet or Avro.\n" +
        "Call with parameter '-h' for help and more options.\n");
    System.out.println("Current parameters:");
    System.out.println("  format               " + getFormat());
    System.out.println("  suffix               " + getSuffix());
    System.out.println("  inPath               " + getInPath());
    System.out.println("  outPath              " + getOutPath());
    System.out.println("  verbose              " + isVerbose());
    System.out.println("  compressed           " + isCompressed());
    System.out.println("  pretty printed JSON  " + isPretty());
    System.out.println("  maxFiles files       " + getMaxFiles());
    System.out.println("  outputFileEnding     " + getOutputFileEnding());
    System.out.println("\n");

  }


  String getInPath() {
    return inPath;
  }
  private void setInPath(String inPath) {
    this.inPath = inPath;
  }

  boolean isVerbose() {
    return verbose;
  }
  private void setVerbose(boolean verbose) {
    this.verbose = verbose;
  }

  boolean isCompressed() {
    return compressed;
  }
  private void setCompressed(boolean compressed) {
    this.compressed = compressed;
  }

  boolean isPretty() {
    return pretty;
  }
  private void setPretty(boolean pretty) {
    this.pretty = pretty;
  }

  boolean isJson() {
    return json;
  }
  private void setJson(boolean json) {
    this.json = json;
  }

  boolean isAvro() {
    return avro;
  }
  private void setAvro(boolean avro) {
    this.avro = avro;
  }

  boolean isParquet() {
    return parquet;
  }
  private void setParquet(boolean parquet) {
    this.parquet = parquet;
  }

  String getFormat() {
    return format;
  }
  private void setFormat(String format) {
    this.format = format;
  }

  String getOutPath() {
    return outPath;
  }
  private void setOutPath(String outPath) {
    this.outPath = outPath;
  }

  String getSuffix() {
    return suffix;
  }
  private void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  int getMaxFiles() {
    return maxFiles;
  }
  private void setMaxFiles(int max) {
    this.maxFiles = max;
  }

  String getOutputFileEnding() {
    return outputFileEnding;
  }
  private void setOutputFileEnding(String outputFileEnding) {
    this.outputFileEnding = outputFileEnding;
  }


}
