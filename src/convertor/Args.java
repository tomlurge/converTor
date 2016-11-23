package convertor;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.HelpFormatter;

/**
 * Evaluates command line arguments.
 */
public enum Args {

  /**
   * Initializes Singleton with CLI arguments.
   */
  INSTANCE(Base.commandLineArguments);

  /**
   * Provide argument defaults.
   */
  private boolean zip = false;
  private boolean snappy = false;
  private boolean pretty = false;
  private boolean json = true;
  private boolean avro = false;
  private boolean parquet = false;
  private String format = "json";
  private String inPath = "";
  private String outPath = "";
  private String logsPath = "";
  private String suffix = "";
  private boolean log = false;
  private boolean debug = false;
  private int maxFiles = 20;
  private String outputFileEnding;


  /**
   * Evaluates command line arguments.
   * see https://commons.apache.org/proper/commons-cli/usage.html
   */
  Args(String[] commandLineArguments) {

    Options options = new Options();
    options.addOption("h", "help", false,
        "Displays this help text.");
    options.addOption("f", "format", true,
        "To which serialization format to convert.\n" +
        "Possible values are 'avro', 'parquet' and 'json'.\n" +
        "Default: 'json'.\n" +
        "e.g. '-f=parquet'");
    options.addOption("s", "suffix", true,
        "Any string that might be helpful.\n" +
        "e.g. '-s=_Suffix'\n\n");
    options.addOption("i", "inPath", true,
        "From which directory to read data.\n" +
        "Default: current working directory.\n" +
        "e.g. '-i=/my/data/in'");
    options.addOption("o", "outPath", true,
        "To which directory to write the converted data.\n" +
        "Default: current working directory.\n" +
        "e.g. '-outPath=/my/data/out/format/' (note the trailing slash)" );
    options.addOption("l", "logsPath", true,
        "To which directory to write log files.\n" +
        "Default: current working directory.\n" +
        "e.g. '-l=/my/data/logs/'");
    options.addOption("cs", "snappy", false,
        "Compresses output with 'snappy' codec.");
    options.addOption("cz", "zip", false,
        "Compresses output with GZip codec (Parquet and JSON) or BZip2 codec (Avro).");
    options.addOption("p", "pretty", false,
        "Pretty printed JSON output.");
    options.addOption("m", "maxFiles", true,
        "Maximum file readers to open.\n" +
        "Default: 20.\n" +
        "e.g. '-m=5'\n" );
    options.addOption("d", "debug", false,
        "Prints JSON representation of each converted descriptor to terminal.");
    options.addOption("g", "log", false,
        "Prints logging statements to 'converTor.log'.");

    /* Parse arguments, set parameters */
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = null;
    try {
      cmd = parser.parse(options,commandLineArguments);
    } catch (ParseException e) {
      System.out.println("ParseException when parsing command line arguments:");
      e.printStackTrace();
    }
    if(cmd.hasOption("h")) {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp("\n", options);
      System.exit(0);
    }
    if(cmd.hasOption("i") && cmd.getOptionValue("i") != null) {
      setInPath(cmd.getOptionValue("i"));
    }
    if(cmd.hasOption("o") && cmd.getOptionValue("o") != null) {
      setOutPath(cmd.getOptionValue("o"));
    }
    if(cmd.hasOption("l") && cmd.getOptionValue("l") != null) {
      setLogsPath(cmd.getOptionValue("l"));
    }
    if(cmd.hasOption("f") && cmd.getOptionValue("f") != null) {
      String formatArgument = cmd.getOptionValue("f").toLowerCase();
      if (formatArgument.equals("avro")) {
        setAvro(true);
        setJson(false);
        setFormat(formatArgument);
      } else if (formatArgument.equals("parquet")) {
        setJson(false);
        setParquet(true);
        setFormat(formatArgument);
      } else if ( ! formatArgument.equals("json")) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ConverTor\n\n" +
            "\'" + cmd.getOptionValue("f") + "\' is not a valid format.\n\n",
            options );
        System.exit(1);
      }
    }
    if (cmd.hasOption("s") && cmd.getOptionValue("s") != null) {
      setSuffix(cmd.getOptionValue("s"));
    }
    if (cmd.hasOption("p")) {
      setPretty(true);
    }
    if (cmd.hasOption("cs")) {
      setSnappy(true);
      setZip(false);
    }
    if (cmd.hasOption("cz")) {
      setZip(true);
      setSnappy(false);
    }
    if (cmd.hasOption("m")) {
      try {
        setMaxFiles(Integer.parseInt(cmd.getOptionValue("m")));
      } catch (NumberFormatException e) {
        System.out.println("m/maxFiles has to be an integer");
        System.exit(1);
      }
    }
    if (cmd.hasOption("d")) {
      setDebug(true);
    }
    if (cmd.hasOption("g")) {
      setLog(true);
    }
    setOutputFileEnding(
        getSuffix()
        + "."
        + getFormat()
        + ( isSnappy() ? ".snappy" : "")
        + ( isZip() && (isJson() || isParquet()) ? ".gz" : "")
        + ( isZip() && isAvro() ? ".bz2" : "")
    );

  }



  boolean isZip() {
    return zip;
  }
  private void setZip(boolean zip) {
    this.zip = zip;
  }

  boolean isSnappy() {
    return snappy;
  }
  private void setSnappy(boolean snappy) {
    this.snappy = snappy;
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

  String getInPath() {
    return inPath;
  }
  private void setInPath(String in) {
    this.inPath = in;
  }

  String getOutPath() {
    return outPath;
  }
  private void setOutPath(String out) {
    this.outPath = out ;
  }

  String getLogsPath() {
    return logsPath;
  }
  private void setLogsPath(String logs) {
    this.logsPath = logs;
  }

  String getSuffix() {
    return suffix;
  }
  private void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  boolean isLog() {
    return log;
  }
  private void setLog(boolean log) {
    this.log = log;
  }

  boolean isDebug() {
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
