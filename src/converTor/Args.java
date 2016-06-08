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
  private boolean zip = false;
  private boolean snappy = false;
  private boolean pretty = false;
  private boolean json = false;
  private boolean avro = false;
  private boolean parquet = true;
  private String format = "parquet";
  private String inPath = "";
  private String outPath = "";
  private String logsPath = "";
  private String suffix = "";
  private boolean log = false;
  private boolean debug = false;
  private int maxFiles = 20;
  private String outputFileEnding;


  /**
   * Evaluates command line arguments
   * see https://commons.apache.org/proper/commons-cli/usage.html
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
        "e.g. '-s=_Suffix'"+
            "Any string that might be helpful.");
    options.addOption("i", "inPath", true,
        "e.g. '-i=/my/data/in'\n" +
            "From which directory to read data.");
    options.addOption("o", "outPath", true,
        "e.g. '-outPath=/my/data/out/format'\n" +
            "To which directory to write the converted data.");
    options.addOption("l", "logsPath", true,
        "e.g. '-l=/my/data/logs/'\n" +
            "From which directory to read data.");
    options.addOption("cs", "snappy", false,
        "compresses output with 'snappy' codec.\n");
    options.addOption("cz", "zip", false,
        "compresses output with GZip codec (Parquet and JSON) or BZip2 codec (Avro).\n");
    options.addOption("p", "pretty", false,
        "generates pretty printed JSON output.");
    options.addOption("m", "maxFiles", true,
        "e.g. '-m=5'\n" +
            "Maximum file readers to open,\n" +
            "Defaults to 20");
    options.addOption("d", "debug", false,
        "Print JSON representation of each converted descriptor to console.");
    options.addOption("log", false,
        "Print logs to file ./conversion.log.");

    /* Parse arguments, set parameters */
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = null;
    try {
      cmd = parser.parse(options,commandLineArguments);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if(cmd.hasOption("h")) {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp( "ConverTor\n", options );
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
        setParquet(false);
        setFormat(formatArgument);
      }
      else if (formatArgument.equals("json")) {
        setAvro(false);
        setJson(true);
        setParquet(false);
        setFormat(formatArgument);
      }
      else if (formatArgument.equals("parquet")) {
        setAvro(false);
        setJson(false);
        setParquet(true);
        setFormat(formatArgument);
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
    if(cmd.hasOption("p")) {
      setPretty(true);
    }
    if(cmd.hasOption("cs")) {
      setSnappy(true);
      setZip(false);
    }
    if(cmd.hasOption("cz")) {
      setZip(true);
      setSnappy(false);
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
    if(cmd.hasOption("log")) {
      setLog(true);
    }
    setOutputFileEnding(getSuffix()
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
