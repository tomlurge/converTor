package converTor;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.HelpFormatter;

/**
 * Evaluates command line arguments
 */
public enum Args {

  /**
   * Initializes Singleton with CLI arguments
   */
  INSTANCE(Base.commandLineArguments);

  /**
   * Provide argument defaults
   */
  private boolean compressedZ = false;
  private boolean compressedSnappy = false;
  private boolean pretty = false;
  private boolean json = false;
  private boolean avro = false;
  private boolean parquet = true;
  private String format = "parquet";
  private String inPath = "data/in/";
  private String outPath = "data/out/" + getFormat() + "/";
  private String suffix = "";
  private boolean debug = false;
  private int maxFiles = 20;
  private String outputFileEnding;


  /**
   * Evaluates command line arguments
   * @see https://commons.apache.org/proper/commons-cli/usage.html
   */
  Args(String[] commandLineArguments) {

    Options options = new Options();
    options.addOption("h", "help", false,
        "Display this help text.");
    options.addOption("f", "format", true,
        "e.g. '-f=json'\n" +
            "To which serialization format to convert.\n" +
            "Defaults to 'parquet'.\n" +
            "Possible values are 'avro', 'parquet' and 'json'.");
    options.addOption("s", "suffix", true,
        "e.g. '-s=_Suffix'");
    options.addOption("i", "inPath", true,
        "e.g. '-i=/my/data/in/dir'\n" +
            "From which directory to read data.\n" +
            "Defaults to 'data/in/'.");
    options.addOption("o", "outPath", true,
        "e.g. '-outPath=/my/data/out/dir'\n" +
            "To which directory to write the converted data.\n" +
            "Defaults to 'data/out/<format>/'.");
    options.addOption("cs", "compressedSnappy", false,
        "compresses output with 'snappy' codec.\n" +
            "CAVEAT: do not use together with Z compression.");
    options.addOption("cz", "compressedZ", false,
        "compresses output with GZip codec (Parquet and JSON) or BZip2 codec (Avro).\n" +
            "CAVEAT: do not use together with snappy compression.");
    options.addOption("p", "pretty", false,
        "generates pretty printed JSON output.");
    options.addOption("m", "maxFiles", true,
        "e.g. '-m=5'\n" +
            "Maximum file readers to open,\n" +
            "Defaults to 20");
    options.addOption("d", "debug", false,
        "Print JSON representation of each converted descriptor to console.");

    /* Parse arguments, set parameters */
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
    if(cmd.hasOption("p")) {
      setPretty(true);
    }
    if(cmd.hasOption("cs")) {
      setCompressedSnappy(true);
      setCompressedZ(false);
    }
    if(cmd.hasOption("cz")) {
      setCompressedZ(true);
      setCompressedSnappy(false);
    }
    if(cmd.hasOption("m")) {
      try {
        setMaxFiles(Integer.parseInt(cmd.getOptionValue("m")));
      } catch (NumberFormatException e) {
        System.out.println("m/maxFiles has to be an integer");
        System.exit(1);
      }
    }
    if(cmd.hasOption("d")) {
      setDebug(true);
    }
    setOutputFileEnding(getSuffix()
        + "."
        + getFormat()
        + ( isCompressedSnappy() ? ".snappy" : "")
        + ( isCompressedZ() && (isJson() || isParquet()) ? ".gz" : "")
        + ( isCompressedZ() && isAvro() ? ".bz2" : "")
    );

    System.out.println(
        "\nConverter from Tor CollecTor data to JSON, Parquet or Avro.\n" +
        "Call with parameter '-h' for help and more options.\n");
    System.out.println("  Current parameters:\n");
    System.out.println("  f   format            ('parquet', 'json' or 'avro')    " + getFormat());
    System.out.println("  s   suffix                                             " + getSuffix());
    System.out.println("  i   inPath                                             " + getInPath());
    System.out.println("  o   outPath                                            " + getOutPath());
    System.out.println("  cs  compressedSnappy                                   " + isCompressedSnappy());
    System.out.println("  cz  compressedZ       (Avro:BZip2, Parquet/JSON:GZip)  " + isCompressedZ());
    System.out.println("  p   pretty            (pretty printed JSON)            " + isPretty());
    System.out.println("  m   maxFiles                                           " + getMaxFiles());
    System.out.println("  d   debug             (print descriptors to console)   " + getDebug());
    System.out.println("      outputFileEnding                                   " + getOutputFileEnding());
    System.out.println("\n");

  }


  String getInPath() {
    return inPath;
  }
  private void setInPath(String inPath) {
    this.inPath = inPath;
  }

  boolean isCompressedZ() {
    return compressedZ;
  }
  private void setCompressedZ(boolean compressedZ) {
    this.compressedZ = compressedZ;
  }
  boolean isCompressedSnappy() {
    return compressedSnappy;
  }
  private void setCompressedSnappy(boolean compressedSnappy) {
    this.compressedSnappy = compressedSnappy;
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

  boolean getDebug() {
    return debug;
  }
  private void setDebug(boolean debug) {
    this.debug = debug;
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
