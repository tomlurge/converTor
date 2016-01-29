/*

TODO

think: are the null's/defaults rightly laid out?
integrate avro builder objects
avro schema is not always like json schema (more records/sub-objects)
  -> consequences ?!

 */
package converTor;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* avro */
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

/*  metrics-lib  */
import org.torproject.descriptor.*;


public class Convert2avro {

  /*  argument defaults  */
  static String format = "avro";
  static String dir = "";

  /*  Read all descriptors in the provided directory and
   *  convert them to the appropriate JSON format.  */
  public static void main(String[] args) throws IOException {

    /*  optional command line arguments
     *    -a, -avro         convert to Avro (default)
     *    -p, -parquet      convert to Parquet
     *    -j, -json         convert to JSON
     *    <directory name>  scan only given subdirectory of default dir data/in/
     */
    for (String arg : args) {
      if (arg.equals("-a") || arg.equals("--avro")) format = "avro";
      else if (arg.equals("-p") || arg.equals("--parquet")) format = "parquet";
      else if (arg.equals("-j") || arg.equals("--json")) format = "json";
      else dir = arg;
    }

    DescriptorReader descriptorReader = DescriptorSourceFactory.createDescriptorReader();
    descriptorReader.addDirectory(new File("data/in/" + dir));
    descriptorReader.setMaxDescriptorFilesInQueue(5);
    Iterator<DescriptorFile> descriptorFiles = descriptorReader.readDescriptors();

    int written = 0;
    String outputPath = "data/out/" + format + "/";
    String outputName = "";
    Writer AvroWriter = new FileWriter(outputPath + outputName);
    BufferedWriter bw = new BufferedWriter(AvroWriter);


    while (descriptorFiles.hasNext()) {
      DescriptorFile descriptorFile = descriptorFiles.next();

      for (Descriptor descriptor : descriptorFile.getDescriptors()) {

        // TODO which type?!
        Object avroDescriptor = null;

        //  relays & bridges descriptors
        if (descriptor instanceof ServerDescriptor) {
          avroDescriptor = AvroServerDescriptor
                  .convert((ServerDescriptor) descriptor);
        }

        //  torperf
        if (descriptor instanceof TorperfResult) {
          avroDescriptor = AvroTorperfResult
                  .construct((TorperfResult) descriptor);
        }

        if (!descriptor.getUnrecognizedLines().isEmpty()) {
          System.err.println("Unrecognized lines in "
                  + descriptorFile.getFileName() + ":");
          System.err.println(descriptor.getUnrecognizedLines());
          continue;
        }
        if (avroDescriptor != null) {
          // TODO remove this comma -v- after testing
          bw.write((written++ > 0 ? ",\n" : "") + avroDescriptor);
        }
      }
    }
    bw.close();
  }


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

  static class AvroServerDescriptor extends AvroDescriptor {

    /*  Take a single server descriptor, test if it is a server-descriptor or a
     *  bridge-server-descriptor and return a JSON string representation. */

    static Server construct(ServerDescriptor desc) {

      //  TODO that will probably not work out as expected
      if (annotation.startsWith("@type server-descriptor")) {
        Relay server = Relay.newBuilder();
      }
      else {
        Bridge server = Bridge.newBuilder();
      }

      for (String annotation : desc.getAnnotations()) {
        server.setDescriptorType(annotation.substring("@type ".length()));
        //  relay specific attribute
        if (annotation.startsWith("@type server-descriptor")) {
          server.setRouterSignature(desc.getRouterSignature() != null);
        }
      }
      // TODO router record
      server.setNickname(desc.getNickname());
      server.setAddress(desc.getAddress());
      server.setOr_port(desc.getOrPort());
      server.setSocks_port(desc.getSocksPort());
      server.setDir_port(desc.getDirPort());
      // TODO bandwidth record
      server.setBandwidth_avg(desc.getBandwidthRate());
      server.setBandwidth_burst(desc.getBandwidthBurst());
      //  test, if there is a key: return 'true' if yes, 'false' otherwise
      server.setOnion_key(desc.getOnionKey() != null);
      server.setSigning_key(desc.getSigningKey() != null);
      //  verbose testing because of List type
      //  first check that the list is not null, then if it's empty
      //  (checking for emptiness right away could lead to null pointer exc)
      if (desc.getExitPolicyLines() != null && !desc.getExitPolicyLines().isEmpty()) {
        server.setExit_policy(desc.getExitPolicyLines());
      }
      //  can be '-1' if null. in that case we don't touch it here, leaving the
      //  default from the class definition intact
      if (desc.getBandwidthObserved() >= 0) {
        server.setBandwidth_observed(desc.getBandwidthObserved());
      }
      if (desc.getOrAddresses() != null && !desc.getOrAddresses().isEmpty()) {
        server.setOr_addresses(new ArrayList<StringInt>());
        for (String orAddress : desc.getOrAddresses()) {
          if (!orAddress.contains(":")) {
            continue;
          }
          int lastColon = orAddress.lastIndexOf(":");
          try {
            int val = Integer.parseInt(orAddress.substring(lastColon + 1));
            server.setOr_addresses.add(
                    new StringInt(orAddress.substring(0, lastColon), val)
            );
          } catch (NumberFormatException e) {
            continue;
          }
        }
      }
      server.setPlatform(desc.getPlatform());
      server.setPublished(dateTimeFormat.format(desc.getPublishedMillis()));
      server.setFingerprint(desc.getFingerprint().toUpperCase());
      //  isHibernating can't return 'null' because it's of type 'boolean'
      //  (with little 'b') but it's only present in the collecTor data if it's
      //  true. therefor we check for it's existence and include it if it
      //  exists. otherwise we leave it alone / to the default value from
      //  the class definition above (which is null)
      if (desc.isHibernating()) {
        server.setHibernating(desc.isHibernating());
      }
      server.setUptime(desc.getUptime());
      server.setIpv6_policy(desc.getIpv6DefaultPolicy());
      server.setContact(desc.getContact());
      server.setFamily(desc.getFamilyEntries());
      //  check for 'null' first because we want to run a method on it
      //  and not get a null pointer exception meanwhile
      if (desc.getReadHistory() != null) {
        server.setRead_history(convertBandwidthHistory(desc.getReadHistory()));
      }
      if (desc.getWriteHistory() != null) {
        server.setWrite_history(convertBandwidthHistory(desc.getWriteHistory()));
      }
      server.setEventdns(desc.getUsesEnhancedDnsLogic());
      server.setCaches_extra_info(desc.getCachesExtraInfo());
      if (desc.getExtraInfoDigest() != null) {
        server.setExtra_info_digest(desc.getExtraInfoDigest().toUpperCase());
      }
      server.setHidden_service_dir_versions(desc.getHiddenServiceDirVersions());
      server.setLink_protocol_versions(desc.getLinkProtocolVersions());
      server.setCircuit_protocol_versions(desc.getCircuitProtocolVersions());
      server.setAllow_single_hop_exits(desc.getAllowSingleHopExits());
      server.setNtor_onion_key(desc.getNtorOnionKey() != null);
      server.setRouter_digest(desc.getServerDescriptorDigest().toUpperCase());

      return ToAvro.serialize(server);
    }
  }


//  static class AvroTorperfResult extends AvroDescriptor {
//    String descriptor_type;
//    String source;
//    Integer filesize;
//    String start;
//    String socket;
//    String connect;
//    String negotiate;
//    String request;
//    String response;
//    String datarequest;
//    String dataresponse;
//    String datacomplete;
//    Integer writebytes;
//    Integer readbytes;
//    Boolean didtimeout;
//    Long dataperc10;
//    Long dataperc20;
//    Long dataperc30;
//    Long dataperc40;
//    Long dataperc50;
//    Long dataperc60;
//    Long dataperc70;
//    Long dataperc80;
//    Long dataperc90;
//    String launch;
//    String used_at;
//    List<String> path;
//    List<Long> buildtimes;
//    String timeout;
//    Double quantile;
//    Integer circ_id;
//    Integer used_by;
//
//    static String convert(TorperfResult desc) {
//      AvroTorperfResult torperf = new AvroTorperfResult();
//      torperf.descriptor_type = "torperf 1.0";
//      /*  TODO  hardcoding the descriptor type is a workaround to bug #17696 in
//          metrics-lib (https://trac.torproject.org/projects/tor/ticket/17696)
//      for (String annotation : desc.getAnnotations()) {
//        torperf.descriptor_type = annotation.substring("@type ".length());
//      }
//      */
//      torperf.source = desc.getSource();
//      torperf.filesize = desc.getFileSize();
//      torperf.start = dateTimeFormat.format(desc.getStartMillis());
//      torperf.socket = dateTimeFormat.format(desc.getSocketMillis());
//      torperf.connect = dateTimeFormat.format(desc.getConnectMillis());
//      torperf.negotiate = dateTimeFormat.format(desc.getNegotiateMillis());
//      torperf.request = dateTimeFormat.format(desc.getRequestMillis());
//      torperf.response = dateTimeFormat.format(desc.getResponseMillis());
//      torperf.datarequest = dateTimeFormat.format(desc.getDataRequestMillis());
//      torperf.dataresponse = dateTimeFormat.format(desc.getDataResponseMillis());
//      torperf.datacomplete = dateTimeFormat.format(desc.getDataCompleteMillis());
//      torperf.writebytes = desc.getWriteBytes();
//      torperf.readbytes = desc.getReadBytes();
//      torperf.didtimeout = desc.didTimeout();
//      if (desc.getDataPercentiles() != null && !desc.getDataPercentiles().isEmpty()) {
//        torperf.dataperc10 = desc.getDataPercentiles().get(10);
//        torperf.dataperc20 = desc.getDataPercentiles().get(20);
//        torperf.dataperc30 = desc.getDataPercentiles().get(30);
//        torperf.dataperc40 = desc.getDataPercentiles().get(40);
//        torperf.dataperc50 = desc.getDataPercentiles().get(50);
//        torperf.dataperc60 = desc.getDataPercentiles().get(60);
//        torperf.dataperc70 = desc.getDataPercentiles().get(70);
//        torperf.dataperc80 = desc.getDataPercentiles().get(80);
//        torperf.dataperc90 = desc.getDataPercentiles().get(90);
//      }
//      if (desc.getLaunchMillis() >= 0) {
//        torperf.launch = dateTimeFormat.format(desc.getLaunchMillis());
//      }
//      if (desc.getUsedAtMillis() >= 0) {
//        torperf.used_at = dateTimeFormat.format(desc.getUsedAtMillis());
//      }
//      if (desc.getPath() != null && !desc.getPath().isEmpty()) {
//        torperf.path = desc.getPath();
//      }
//      if (desc.getBuildTimes() != null && !desc.getBuildTimes().isEmpty()) {
//        torperf.buildtimes = desc.getBuildTimes();
//      }
//      if (desc.getTimeout() >= 0) {
//        torperf.timeout = dateTimeFormat.format(desc.getTimeout());
//      }
//      if (desc.getQuantile() >= 0) {
//        torperf.quantile = desc.getQuantile();
//      }
//      if (desc.getCircId() >= 0) {
//        torperf.circ_id = desc.getCircId();
//      }
//      if (desc.getUsedBy() >= 0) {
//        torperf.used_by = desc.getUsedBy();
//      }
//      return ToAvro.serialize(torperf);
//    }
//  }


  static class AvroTorperfResult extends AvroDescriptor {
    static Torperf construct(TorperfResult desc) {

      Torperf torperf = Torperf.newBuilder();
      /*  TODO  hardcoding the descriptor type is a workaround to bug #17696 in
          metrics-lib (https://trac.torproject.org/projects/tor/ticket/17696)
      for (String annotation : desc.getAnnotations()) {
        torperf.setDescriptorType(annotation.substring("@type ".length()));
      }
      */
      //  TODO check CamelCasing with generated classes
      torperf.setDescriptorType("torperf 1.0");
      torperf.setSource(desc.getSource());
      torperf.setFilesize(desc.getFileSize());
      torperf.setStart(dateTimeFormat.format(desc.getStartMillis()));
      torperf.setSocket(dateTimeFormat.format(desc.getSocketMillis()));
      torperf.setConnect(dateTimeFormat.format(desc.getConnectMillis()));
      torperf.setNegotiate(dateTimeFormat.format(desc.getNegotiateMillis()));
      torperf.setRequest(dateTimeFormat.format(desc.getRequestMillis()));
      torperf.setResponse(dateTimeFormat.format(desc.getResponseMillis()));
      torperf.setDatarequest(dateTimeFormat.format(desc.getDataRequestMillis()));
      torperf.setDataresponse(dateTimeFormat.format(desc.getDataResponseMillis()));
      torperf.setDatacomplete(dateTimeFormat.format(desc.getDataCompleteMillis()));
      torperf.setWritebytes(desc.getWriteBytes());
      torperf.setReadBytes(desc.getReadBytes());
      torperf.setDidTimeout(desc.didTimeout());
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
      if (desc.getLaunchMillis() >= 0) {
        torperf.setLaunch(dateTimeFormat.format(desc.getLaunchMillis()));
      }
      if (desc.getUsedAtMillis() >= 0) {
        torperf.setUsedAt(dateTimeFormat.format(desc.getUsedAtMillis()));
      }
      if (desc.getPath() != null && !desc.getPath().isEmpty()) {
        torperf.setPath(desc.getPath());
      }
      if (desc.getBuildTimes() != null && !desc.getBuildTimes().isEmpty()) {
      torperf.setBuildtimes(desc.getBuildTimes());
      }
      if (desc.getTimeout() >= 0) {
        torperf.setTimeout(dateTimeFormat.format(desc.getTimeout()));
      }
      if (desc.getQuantile() >= 0) {
        torperf.setQuantile(desc.getQuantile());
      }
      if (desc.getCircId() >= 0) {
        torperf.setCircId(desc.getCircId());
      }
      if (desc.getUsedBy() >= 0) {
        torperf.setUsedBy(desc.getUsedBy());
      }
      torperf.build();
      return torperf;
    }
  }



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