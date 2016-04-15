package converTor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.avro.specific.SpecificRecordBase;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.DescriptorFile;


public class Convert<C> {

  // a lot of details about name, schema, schema class etc
  public Types type;
  // month of creation of original descriptor, as YYYY_MM
  public String date;
  // the actual data, converted to an Avro object
  public SpecificRecordBase load;


  //  CHECK FOR UNRECOGNIZED ATTRIBUTES
  public void checkUnrecognized(Descriptor descriptor, DescriptorFile descriptorFile) {
    if (!descriptor.getUnrecognizedLines().isEmpty()) {
      System.err.println("Unrecognized lines in "
          + descriptorFile.getFileName() + ":");
      System.err.println(descriptor.getUnrecognizedLines());
    }
  }

  public void convert(Descriptor descriptor) {
  }

  /*  generic key/value objects for verbose output  */
  public static class StringInt {
    String key;
    int val;
    StringInt(String key, int val) {
      this.key = key;
      this.val = val;
    }
  }
  public static class StringLong {
    String key;
    Long val;
    StringLong(String key, Long val) {
      this.key = key;
      this.val = val;
    }
  }
  public static class StringDouble {
    String key;
    Double val;
    StringDouble(String key, Double val) {
      this.key = key;
      this.val = val;
    }
  }

  /* ExtraInfo and Stats objects used in extra info descriptors */
  public static class ExtraInfo {
    String nickname;
    String fingerprint;
  }
  public static class Stats {
    String date;
    Long interval;
  }

  /*  Serialize "read-history" and "write-history" lines  */
  public static class BandwidthHistory {
    String date; // format is YYYY-MM-DD HH:MM:SS
    long interval; // seconds
    Collection<Long> bytes;
  }
  /*  Convert read or write history  */
  public static BandwidthHistory convertBandwidthHistory(org.torproject.descriptor.BandwidthHistory hist) {
    BandwidthHistory bandwidthHistory = new BandwidthHistory();
    bandwidthHistory.date = dateTimeFormat.format(hist.getHistoryEndMillis());
    bandwidthHistory.interval = hist.getIntervalLength();
    bandwidthHistory.bytes = hist.getBandwidthValues().values();
    return bandwidthHistory;
  }
  /*  Date/time formatter  */
  public static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
  public static final Locale dateTimeLocale = Locale.US;
  public static final TimeZone dateTimezone = TimeZone.getTimeZone("UTC");
  public static DateFormat dateTimeFormat;
  static {
    dateTimeFormat = new SimpleDateFormat(dateTimePattern, dateTimeLocale);
    dateTimeFormat.setLenient(false);
    dateTimeFormat.setTimeZone(dateTimezone);
  }


  /*
   *  todo    what was that for again ?
   *          and how to make it useable ?
   *
  public class ParsePLine {
    public static void main(String[] args) {
      String[] pLines = new String[] {
          "p accept 1-24,26-1024",
          "p accept 1-65535",
          "p accept 1024-65000",
          "p accept 20-23,43,53,79-81,88,110,143,194,220,389,443,464,531,"
              + "543-544,554,563,636,706,749,873,902-904,981,989-995,1194,"
              + "1220,1293,1500,1533,1677,1723,1755,1863,2082-2083,2086-2087,"
              + "2095-2096,2102-2104,3128,3389,3690,4321,4643,5050,5190,"
              + "5222-5223,5228,5900,6660-6669,6679,6697,8000,8008,8074,8080,"
              + "8087-8088,8332-8333,8443,8888,9418,9999-10000,11371,12350,"
              + "19294,19638,23456,33033,64738",
          "p accept 80",
          "p reject 1-442,445,563,1214,4661-4666,6346-6429,6699,6881-6999,"
              + "9001",
          "p reject 1-65535",
          "p reject 21-23,25,119,135-139,445,563,1080,1214,4661-4666,4899,"
              + "5060,6346-6429,6660-6669,6699,6881-7000,12000,62078",
          "p reject 25",
          "p reject 25,119",
          "p reject 25,119,135-139,445,563,1024-3127,3129-7999,8081-65535",
          "p reject 1-65534"
      };
      for (String pLine : pLines) {
        System.out.println(pLine);
        printAcceptedPortIntervals(parsePLine(pLine));
        System.out.println();
      }
    }

    private static List<int[]> parsePLine(String pLine) {
      List<int[]> acceptedPortIntervals = new ArrayList<>();
      String[] pLineParts = pLine.split(" ");
      boolean policyIsAccept = "accept".equals(pLineParts[1]);
      String[] portIntervals = pLineParts[2].split(",");
      int lastToPort = 0;
      for (String portInterval : portIntervals) {
        String[] ports = portInterval.split("-");
        int fromPort = Integer.parseInt(ports[0]);
        int toPort = ports.length == 1 ? fromPort
            : Integer.parseInt(ports[1]);
        if (policyIsAccept) {
          acceptedPortIntervals.add(new int[] { fromPort, toPort });
        } else if (fromPort > lastToPort + 1) {
          acceptedPortIntervals.add(new int[] { lastToPort + 1,
              fromPort - 1 });
        }
        lastToPort = toPort;
      }
      if (!policyIsAccept && lastToPort < 65535) {
        acceptedPortIntervals.add(new int[] { lastToPort + 1, 65535 });
      }
      return acceptedPortIntervals;
    }

    private static void printAcceptedPortIntervals(
        List<int[]> acceptedPortIntervals) {
      System.out.print("p accept ");
      int writtenIntervals = 0;
      for (int[] interval : acceptedPortIntervals) {
        System.out.print((writtenIntervals++ > 0 ? "," : "") + interval[0]);
        if (interval[1] > interval[0]) {
          System.out.print("-" + interval[1]);
        }
      }
      System.out.println();
    }
  }
  */


}