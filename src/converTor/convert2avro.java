package converTor;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* avro */
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

/* avro classes auto-generated from schemas */
import converTor.relay.*;
import converTor.relayExtra.*;
import converTor.bridgeExtra.*;
import converTor.relayVote.*;
import converTor.relayConsensus.*;
import converTor.bridgeStatus.*;
import converTor.tordnsel.*;
import converTor.torperf.*;

/*  metrics-lib  */
import org.torproject.descriptor.*;

/* command line interface */
import org.apache.commons.cli.*;

/* fileWriter - TODO maybe useful for multifile output */
import org.apache.commons.io.FileUtils;


public class Convert2avro {

  /*  argument defaults  */
  static boolean verbose = false;
  static boolean compressed = false;
  static boolean json = false;
  static boolean avro = false;
  static boolean parquet = true;
  static String format = "parquet";
  static String in = "data/in/";
  static String out = "data/out/" + format + "/";
  //  static String prefix = "";
  //  static String name = "result";
  static String suffix = "";
  static int max = 20;

  static class Converted {
    String type;
    String date;
    Object load;  //  TODO  was'n das tatsächlich für'n typ?
  }

  /*  Read all descriptors in the provided directory and
   *  convert them to the appropriate JSON format.  */
  public static void main(String[] args) throws IOException {

    //  INPUT ARGUMENTS
    // https://commons.apache.org/proper/commons-cli/usage.html
    Options options = new Options();
    options.addOption("h", "help", false,
            "display this help text");
    options.addOption("f", "format", true,
            "e.g. '-f=json'\n" +
                    "to which serialization format to convert\n" +
                    "defaults to 'parquet'\n" +
                    "possible values are 'avro', 'parquet' and 'json'");
    //  options.addOption("n", "name", true,
    //          "e.g. '-n=myConversion'");
    //  options.addOption("p", "prefix", true,
    //          "e.g. '-p=NEW_'");
    options.addOption("s", "suffix", true,
            "e.g. '-s=_Suffix'");
    options.addOption("i", "in", true,
            "e.g. '-i=/my/data/in/dir'\n" +
                    "from which directory to read data\n" +
                    "defaults to 'data/in/'");
    options.addOption("o", "out", true,
            "e.g. '-i=/my/data/out/dir'\n" +
                    "to which directory to write the converted data\n" +
                    "defaults to 'data/out/'");
    options.addOption("v", "verbose", false,
            "encode 'jagged' maps (objects with non-uniform attribute sets) \n" +
                    "additionally as 'flattened' arrays (with suffix '_FLAT')\n" +
                    "and include all properties with 'null' values (this is only\n" +
                    "relevant for the JSON encoding).\n" +
                    "some SQL engines like Apache Drill require this.";
    //  TODO  implement multi-file compression for JSON
    options.addOption("c", "compressed", false,
            "does generate .gz archive, \n" +
                    "(this is only relevant for JSON)");
    options.addOption("m", "max", true,
            "maximum file readers to open, \n" +
                    "e.g. '-m=5'\n" +
                    "defaults to 20");
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = null;
    try {
      cmd = parser.parse(options, args);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if(cmd.hasOption("h")) {
      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp( "ConvertTor\n", options );
    }

    if(cmd.hasOption("f") && cmd.getOptionValue("f") != null) {
      String formatArgument = cmd.getOptionValue("f").toLowerCase();
      if (formatArgument == "avro") {
        avro = true;
        parquet = false;
        format = formatArgument;
      }
      else if (formatArgument == "json") {
        json = true;
        parquet = false;
        format = formatArgument;
      }
      else if (formatArgument != "parquet")  {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "ConvertTor\n\n" +
                "Sorry, but " + cmd.getOptionValue("f") +
                " is not a valid format.\n\n", options );
      }
    }
    //  if(cmd.hasOption("n") && cmd.getOptionValue("n") != null) {
    //    name  = cmd.getOptionValue("n");
    //  }
    //  if(cmd.hasOption("p") && cmd.getOptionValue("p") != null) {
    //    prefix  = cmd.getOptionValue("p");
    //  }
    if(cmd.hasOption("s") && cmd.getOptionValue("s") != null) {
      suffix  = cmd.getOptionValue("s");
    }
    if(cmd.hasOption("i") && cmd.getOptionValue("i") != null) {
      in = cmd.getOptionValue("i");
    }
    if(cmd.hasOption("o") && cmd.getOptionValue("o") != null) {
      out = cmd.getOptionValue("o");
    }
    if(cmd.hasOption("v")) {
      verbose = true;
    }
    if(verbose && json) {
      compressed = true;
    }

    System.out.println("format = " + format);
    //  System.out.println("name = " + name);
    //  System.out.println("prefix = " + prefix);
    System.out.println("suffix = " + suffix);
    System.out.println("in = " + in);
    System.out.println("out = " + out);
    System.out.println("verbose = " + verbose);
    System.out.println("compressed = " + compressed);

    String outputFileEnding = suffix + "." + format + ( compressed ? ".gz" : "");
    //  String outputFile = type + date + outputFileEnding;
    //  String outputPath = out + outputFile;


    DescriptorReader descriptorReader = DescriptorSourceFactory.createDescriptorReader();
    descriptorReader.addDirectory(new File(in));
    descriptorReader.setMaxDescriptorFilesInQueue(max);
    Iterator<DescriptorFile> descriptorFiles = descriptorReader.readDescriptors();


    //  TODO  oder map?
    ArrayList<DataFileWriter> dataFileWriters = new ArrayList<>();

    /*  TODO  add(type,date,load)
              check array/map dataFileWriters if writer type+date already exists
                c.type
                c.date
              if no create it
                all that writer gedöns
              append load to it
                c.load
    */

    //  TODO  bullshit
    //  das kann alles weg
    //  in der descriptor abarbeitungs schleife wird einfach gefragt werden,
    //  ob so eine datei schon existiert
    //  und wenn nicht wird das alles initialisiert
    //  nur der array, in dem die datei gespeichert wird, muss schon vorher da sein

    /* initialize files and writers */
    File relayAvroFile = null;
    DatumWriter<Relay> relayDatumWriter = null;
    DataFileWriter<Relay> relayDataFileWriter = null;

    File bridgeAvroFile = null;
    DatumWriter<converTor.bridge.Bridge> bridgeDatumWriter = null;
    DataFileWriter<converTor.bridge.Bridge> bridgeDataFileWriter = null;

    File relayExtraAvroFile = null;
    DatumWriter<RelayExtra> relayExtraDatumWriter = null;
    DataFileWriter<RelayExtra> relayExtraDataFileWriter = null;

    File bridgeExtraAvroFile = null;
    DatumWriter<BridgeExtra> bridgeExtraDatumWriter = null;
    DataFileWriter<BridgeExtra> bridgeExtraDataFileWriter = null;

    File relayVoteAvroFile = null;
    DatumWriter<RelayVote> relayVoteDatumWriter = null;
    DataFileWriter<RelayVote> relayVoteDataFileWriter = null;

    File relayConsensusAvroFile = null;
    DatumWriter<RelayConsensus> relayConsensusDatumWriter = null;
    DataFileWriter<RelayConsensus> relayConsensusDataFileWriter = null;

    File bridgeStatusAvroFile = null;
    DatumWriter<BridgeStatus> bridgeStatusDatumWriter = null;
    DataFileWriter<BridgeStatus> bridgeStatusDataFileWriter = null;

    File tordnselAvroFile = null;
    DatumWriter<Tordnsel> tordnselDatumWriter = null;
    DataFileWriter<Tordnsel> tordnselDataFileWriter = null;

    File torperfAvroFile = null;
    DatumWriter<Torperf> torperfDatumWriter = null;
    DataFileWriter<Torperf> torperfDataFileWriter = null;



    while (descriptorFiles.hasNext()) {
      DescriptorFile descriptorFile = descriptorFiles.next();
      if(null != descriptorFile.getException()){
        System.err.print(descriptorFile.getException()
                + "\n    in " + descriptorFile.getFileName() + "\n");
      }

      for (Descriptor descriptor : descriptorFile.getDescriptors()) {
        String avroDescriptor = null;   // TODO  wozu soll der gut sein?

        /*
        //  relay descriptors
        if (descriptor instanceof RelayServerDescriptor) {
          avroDescriptor = ConvertRelay
                  .convert((RelayServerDescriptor) descriptor);
        }
        //  bridge descriptors
        if (descriptor instanceof BridgeServerDescriptor) {
          avroDescriptor = ConvertBridge
                  .convert((BridgeServerDescriptor) descriptor);
        }
        //  relay extra info descriptors
        if (descriptor instanceof RelayExtraInfoDescriptor) {
          avroDescriptor = ConvertRelayExtra
                  .convert((RelayExtraInfoDescriptor) descriptor);
        }
        //  bridge extra info descriptors
        if (descriptor instanceof BridgeExtraInfoDescriptor) {
          avroDescriptor = ConvertBridgeExtra
                  .convert((BridgeExtraInfoDescriptor) descriptor);
        }
        //  relay network status vote
        if (descriptor instanceof RelayNetworkStatusVote) {
          avroDescriptor = ConvertRelayVote
                  .convert((RelayNetworkStatusVote) descriptor);
        }
        //  relay network status consensus
        if (descriptor instanceof RelayNetworkStatusConsensus) {
          avroDescriptor = ConvertRelayConsensus
                  .convert((RelayNetworkStatusConsensus) descriptor);
        }
        //  bridge network status
        if (descriptor instanceof BridgeNetworkStatus) {
          avroDescriptor = ConvertBridgeStatus
                  .convert((BridgeNetworkStatus) descriptor);
        }*/


        //  tordnsel
        /*if (descriptor instanceof ExitList) {
          avroDescriptor = ConvertExitList
                  .convert((ExitList) descriptor);
        }*/
        if (descriptor instanceof ExitList) {
          //  add descriptor
          if (tordnselAvroFile != null) {
            Tordnsel tordnsel = ConvertTordnsel.populate((ExitList) descriptor);
            tordnselDataFileWriter.append(tordnsel);
          }
          // initialize tordnsel and add first descriptor
          else {
            tordnselAvroFile = new File("tordnsel.avro");
            tordnselDatumWriter = new SpecificDatumWriter<Tordnsel>(Tordnsel.class);
            tordnselDataFileWriter = new DataFileWriter<Tordnsel>(tordnselDatumWriter);
            dataFileWriters.add(tordnselDataFileWriter);
            Tordnsel tordnsel = ConvertTordnsel.populate((ExitList) descriptor);
            tordnselDataFileWriter.create(tordnsel.getSchema(), tordnselAvroFile);
            tordnselDataFileWriter.append(tordnsel);
          }
        }




        //  torperf
        if (descriptor instanceof TorperfResult) {

          //  TODO  mehr brauchts hier nicht
          Converted c = ConvertTorperf.populate((TorperfResult) descriptor);
          dataFileWriters.add( c ); // TODO  wrong type

          //  TODO das kann weg
          //  add descriptor
          if (torperfAvroFile != null) {
            Torperf torperf = ConvertTorperf.populate((TorperfResult) descriptor);
            torperfDataFileWriter.append(torperf);
          }
          //  TODO  das muß woanders hin
          // initialize torperf and add first descriptor
          else {
            torperfAvroFile = new File("torperf.avro");
            torperfDatumWriter = new SpecificDatumWriter<Torperf>(Torperf.class);
            torperfDataFileWriter = new DataFileWriter<Torperf>(torperfDatumWriter);
            dataFileWriters.add(torperfDataFileWriter);
            Torperf torperf = ConvertTorperf.populate((TorperfResult) descriptor);
            torperfDataFileWriter.create(torperf.getSchema(), torperfAvroFile);
            torperfDataFileWriter.append(torperf);
          }
        }

        /* from multifile output branch
        //  torperf
        if (descriptor instanceof TorperfResult) {
          jsonDescriptor = JsonTorperf
                  .convert((TorperfResult) descriptor);
          String pathFileName = out + prefix + "torperf_" + jsonDescriptor.yearMonth + suffix + "." + format;
          File theFile;
          theFile = new File(pathFileName);
          FileUtils.writeStringToFile(theFile, jsonDescriptor.jsonDesc + "\n", "UTF8", true);
        }
         */

        if (!descriptor.getUnrecognizedLines().isEmpty()) {
          System.err.println("Unrecognized lines in "
                  + descriptorFile.getFileName() + ":");
          System.err.println(descriptor.getUnrecognizedLines());
          continue;
        }

      }
    }

    for ( DataFileWriter dataFileWriter : dataFileWriters) {
      dataFileWriter.close();
    }

  }


  //  all descriptors
  static class AvroDescriptor {

    /*  generic key/value objects for verbose output  */
    static class StringInt {
      String key;
      int val;
      StringInt(String key, int val) {
        this.key = key;
        this.val = val;
      }
    }
    static class StringLong {
      String key;
      Long val;
      StringLong(String key, Long val) {
        this.key = key;
        this.val = val;
      }
    }
    static class StringDouble {
      String key;
      Double val;
      StringDouble(String key, Double val) {
        this.key = key;
        this.val = val;
      }
    }

    /* ExtraInfo and Stats objects used in extra info descriptors */
    static class ExtraInfo {
      String nickname;
      String fingerprint;
    }
    static class Stats {
      String date;
      Long interval = 86400L;   // TODO  is it really useful to insert the default here?
    }

    /*  Serialize "read-history" and "write-history" lines  */
    static class BandwidthHistory {
      String date; // format is YYYY-MM-DD HH:MM:SS
      long interval; // seconds
      Collection<Long> bytes;
    }
    /*  Convert read or write history  */
    static BandwidthHistory convertBandwidthHistory(org.torproject.descriptor.BandwidthHistory hist) {
      BandwidthHistory bandwidthHistory = new BandwidthHistory();
      bandwidthHistory.date = dateTimeFormat.format(hist.getHistoryEndMillis());
      bandwidthHistory.interval = hist.getIntervalLength();
      bandwidthHistory.bytes = hist.getBandwidthValues().values();
      return bandwidthHistory;
    }
    /*  Date/time formatter  */
    static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
    static final Locale dateTimeLocale = Locale.US;
    static final TimeZone dateTimezone = TimeZone.getTimeZone("UTC");
    static DateFormat dateTimeFormat;
    static {
      dateTimeFormat = new SimpleDateFormat(dateTimePattern, dateTimeLocale);
      dateTimeFormat.setLenient(false);
      dateTimeFormat.setTimeZone(dateTimezone);
    }
  }


  //  tordnsel
  static class ConvertTordnsel extends AvroDescriptor {

    List<ExitNode> exit_nodes;
    static class ExitNode {
      String fingerprint;
      String published;
      String last_status;
      // List<Exit> exit_list;
      Object exit_list;
    }
    static class Exit {
      String ip;
      String date;
    }

    static Tordnsel populate(ExitList desc) {
      Tordnsel tordnsel = new Tordnsel();
      for (String annotation : desc.getAnnotations()) {
        tordnsel.setDescriptorType(annotation.substring("@type ".length()));
      }
      tordnsel.setDownloaded(desc.getDownloadedMillis();
      tordnsel.setExitNodes(AvroExitNodes.populate( ));

      /*  how to populate nested records/arrays/maps
      https://stackoverflow.com/questions/5480043/question-populating-nested-records-in-avro-using-a-genericrecord

      Schema  sch =  Schema.parse(schemaFile);
      DataFileWriter<GenericRecord> fw = new DataFileWriter<GenericRecord>(new GenericDatumWriter<GenericRecord>()).create(sch, new File(outFile));
      GenericRecord r = new GenericData.Record(sch);
      r.put(“firstName”, “John”);
      fw.append(r);

      GenericRecord t = new GenericData.Record(sch.getField("address").schema());
      t.put("city","beijing");
      r.put("address",t);
      */

      tordnsel.exit_nodes = new ArrayList<>();
      if (desc.getEntries() != null && !desc.getEntries().isEmpty()) {
        for(ExitList.Entry exitEntry : desc.getEntries()) {
          ExitNode exitNode = new ExitNode();
          exitNode.fingerprint = exitEntry.getFingerprint();
          exitNode.published = dateTimeFormat.format(exitEntry.getPublishedMillis());
          exitNode.last_status = dateTimeFormat.format(exitEntry.getLastStatusMillis());
          if (exitEntry.getExitAddresses() != null && !exitEntry.getExitAddresses().isEmpty()) {
            /* jagged */
            exitNode.exit_list = new HashMap<String, String>();
            HashMap<String, String> jaggedList = new HashMap<>();
            for (Map.Entry<String, Long> exitAddress : exitEntry.getExitAddresses().entrySet()) {
              jaggedList.put(exitAddress.getKey(), dateTimeFormat.format(exitAddress.getValue()));
            }
            exitNode.exit_list = jaggedList;
            if (verbose) {
              exitNode.exit_list_VERBOSE = new ArrayList<Exit>();
              ArrayList<Exit> flatExit = new ArrayList<>();
              for (Map.Entry<String, Long> exitAddress : exitEntry.getExitAddresses().entrySet()) {
                Exit exit = new Exit();
                exit.ip = exitAddress.getKey();
                exit.date = dateTimeFormat.format(exitAddress.getValue());
                flatExit.add(exit);
              }
              exitNode.exit_list = flatExit;
            }
          }
          tordnsel.exit_nodes.add(exitNode);
        }
      }
      /* */
      return tordnsel;
    }



    //  inner class exitList
    static class AvroExitNodes extends AvroDescriptor {
      static Torperf populate(TorperfResult desc) {
        Torperf torperf = new Torperf();
        torperf.setDescriptorType("torperf 1.0");
        torperf.setSource(desc.getSource());
        torperf.setFilesize(desc.getFileSize());
        return torperf;
      }
    }

  }


  //  torperf
  //  SPECIFIC with CONSTRUCTOR
  static class ConvertTorperf extends AvroDescriptor {
    static Converted populate(TorperfResult desc) {
      Torperf torperf = new Torperf();
      torperf.setDescriptorType("torperf 1.0");
      torperf.setSource(desc.getSource());
      torperf.setFilesize(desc.getFileSize());
      torperf.setStart(desc.getStartMillis());
      torperf.setSocket(desc.getSocketMillis());
      torperf.setConnect(desc.getConnectMillis());
      torperf.setNegotiate(desc.getNegotiateMillis());
      torperf.setRequest(desc.getRequestMillis());
      torperf.setResponse(desc.getResponseMillis());
      torperf.setDatarequest(desc.getDataRequestMillis());
      torperf.setDataresponse(desc.getDataResponseMillis());
      torperf.setDatacomplete(desc.getDataCompleteMillis());
      torperf.setWritebytes(desc.getWriteBytes());
      torperf.setReadbytes(desc.getReadBytes());
      torperf.setDidtimeout(desc.didTimeout());
      if (desc.getDataPercentiles() != null && !desc.getDataPercentiles().isEmpty()) {
        torperf.setDataperc10(desc.getDataPercentiles().get(10));
        torperf.setDataperc20(desc.getDataPercentiles().get(20));
        torperf.setDataperc30(desc.getDataPercentiles().get(30));
        torperf.setDataperc40(desc.getDataPercentiles().get(40));
        torperf.setDataperc50(desc.getDataPercentiles().get(50));
        torperf.setDataperc60(desc.getDataPercentiles().get(60));
        torperf.setDataperc70(desc.getDataPercentiles().get(70));
        torperf.setDataperc80(desc.getDataPercentiles().get(80));
        torperf.setDataperc90(desc.getDataPercentiles().get(90));
      }
      torperf.setLaunch(desc.getLaunchMillis());
      torperf.setUsedAt(desc.getUsedAtMillis());
      //  TODO  type mismatch char_sequence/array -> string
      //  it's an array stupid
      if (desc.getPath() != null && !desc.getPath().isEmpty()) {
        torperf.setPath(desc.getPath());
      }
      torperf.setBuildtimes(desc.getBuildTimes());
      torperf.setTimeout(desc.getTimeout());
      torperf.setQuantile(desc.getQuantile());
      torperf.setCircId(desc.getCircId());
      torperf.setUsedBy(desc.getUsedBy());

      Converted c = new Converted();
      c.date = torperf.dateTimeFormat.format(desc.getStartMillis()).substring(0,7);
      c.type = "torperf";
      c.load = torperf;
      return c;
    }
  }

  //  SPECIFIC with BUILDER
  /*
  static class SpecificBuilderAvroTorperfDescriptor extends AvroDescriptor {
    static Torperf populate(TorperfResult desc) {

      Torperf torperf;
      torperf = Torperf.newBuilder()
                       .setDescriptorType("torperf 1.0")
                       .setSource(desc.getSource())
                       .setFilesize(desc.getFileSize())
                       .setStart(desc.getStartMillis())
                       .setSocket(desc.getSocketMillis())
                       .setConnect(desc.getConnectMillis())
                       .setNegotiate(desc.getNegotiateMillis())
                       .setRequest(desc.getRequestMillis())
                       .setResponse(desc.getResponseMillis())
                       .setDatarequest(desc.getDataRequestMillis())
                       .setDataresponse(desc.getDataResponseMillis())
                       .setDatacomplete(desc.getDataCompleteMillis())
                       .setWritebytes(desc.getWriteBytes())
                       .setReadbytes(desc.getReadBytes())
                       .setDidtimeout(desc.didTimeout())
                       .build();
      //  TODO BUILDER APPROACH BREAKS DOWN HERE
      //  i have no idea how i could introduce any logic
      //  like the following switch into that process
      //  in a reasonable way
      if (desc.getDataPercentiles() != null && !desc.getDataPercentiles().isEmpty()) {
        torperf.setDataperc10(desc.getDataPercentiles().get(10));
        torperf.setDataperc20(desc.getDataPercentiles().get(20));
        torperf.setDataperc30(desc.getDataPercentiles().get(30));
        torperf.setDataperc40(desc.getDataPercentiles().get(40));
        torperf.setDataperc50(desc.getDataPercentiles().get(50));
        torperf.setDataperc60(desc.getDataPercentiles().get(60));
        torperf.setDataperc70(desc.getDataPercentiles().get(70));
        torperf.setDataperc80(desc.getDataPercentiles().get(80));
        torperf.setDataperc90(desc.getDataPercentiles().get(90));
      }
      torperf.setLaunch(desc.getLaunchMillis());
      torperf.setUsedAt(desc.getUsedAtMillis());
      if (desc.getPath() != null && !desc.getPath().isEmpty()) {
        torperf.setPath(desc.getPath());
      }
      torperf.setBuildtimes(desc.getBuildTimes());
      torperf.setTimeout(desc.getTimeout());
      torperf.setQuantile(desc.getQuantile());
      torperf.setCircId(desc.getCircId());
      torperf.setUsedBy(desc.getUsedBy());

      return torperf;
    }
  }
  */

  //  GENERIC
  /*  TODO  delete after settling for SPECIIFIC mapping
  static class GenericAvroTorperfDescriptor extends AvroDescriptor {
    static GenericRecord populate(GenericRecord torperf, TorperfResult desc) {

      //  TODO  manually check types for consistency
      //        yes, manually! one might think "this is java", but still...

      torperf.put("descriptor_type", "torperf 1.0");
      torperf.put("source", desc.getSource());
      torperf.put("filesize", desc.getFileSize());
      torperf.put("start", dateTimeFormat.format(desc.getStartMillis()));
      torperf.put("socket", dateTimeFormat.format(desc.getSocketMillis()));
      torperf.put("connect", dateTimeFormat.format(desc.getConnectMillis()));
      torperf.put("negotiate", dateTimeFormat.format(desc.getNegotiateMillis()));
      torperf.put("request", dateTimeFormat.format(desc.getRequestMillis()));
      torperf.put("response", dateTimeFormat.format(desc.getResponseMillis()));
      torperf.put("datarequest", dateTimeFormat.format(desc.getDataRequestMillis()));
      torperf.put("dataresponse", dateTimeFormat.format(desc.getDataResponseMillis()));
      torperf.put("datacomplete", dateTimeFormat.format(desc.getDataCompleteMillis()));
      torperf.put("writebytes", desc.getWriteBytes());
      torperf.put("readbytes", desc.getReadBytes());
      torperf.put("didtimeout", desc.didTimeout());
      if (desc.getDataPercentiles() != null && !desc.getDataPercentiles().isEmpty()) {
        torperf.put("dataperc10", desc.getDataPercentiles().get(10));
        torperf.put("dataperc20", desc.getDataPercentiles().get(20));
        torperf.put("dataperc30", desc.getDataPercentiles().get(30));
        torperf.put("dataperc40", desc.getDataPercentiles().get(40));
        torperf.put("dataperc50", desc.getDataPercentiles().get(50));
        torperf.put("dataperc60", desc.getDataPercentiles().get(60));
        torperf.put("dataperc70", desc.getDataPercentiles().get(70));
        torperf.put("dataperc80", desc.getDataPercentiles().get(80));
        torperf.put("dataperc90", desc.getDataPercentiles().get(90));
      }
      torperf.put("launch", desc.getLaunchMillis());
      torperf.put("used_at", desc.getUsedAtMillis());
      torperf.put("path", desc.getPath());
      torperf.put("buildtimes", desc.getBuildTimes());
      torperf.put("timeout", desc.getTimeout());
      torperf.put("quantile", desc.getQuantile());
      torperf.put("circ_id", desc.getCircId());
      torperf.put("used_by", desc.getUsedBy());

      return torperf;
    }
  }
  */




  /*  Convert everything to a JSON string and return that.
   *  If flag 'verbose' is set also serialize attributes evaluating to null.
   *  Gson docs: https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/GsonBuilder.html
   */
  static class ToAvro {
    static String serialize(AvroDescriptor avroDescriptor) {

      return "TODO";

    }
  }

}