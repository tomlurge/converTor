package converTor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.avro.specific.SpecificRecordBase;
import org.torproject.descriptor.BandwidthHistory;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.DescriptorFile;


abstract class Convert<C> {

  // a lot of details about name, schema, avro schema class etc
  Types type;
  // month of creation of original descriptor, as YYYY_MM
  String date;
  // the actual data, converted to an Avro object
  SpecificRecordBase load;


  abstract void convert(Descriptor descriptor);


  //  CHECK FOR UNRECOGNIZED ATTRIBUTES
  void checkUnrecognized(Descriptor descriptor, DescriptorFile descriptorFile) {
    if (!descriptor.getUnrecognizedLines().isEmpty()) {
      System.err.println("Unrecognized lines in "
          + descriptorFile.getFileName() + ":");
      System.err.println(descriptor.getUnrecognizedLines());
    }
  }


  //  DATE-TIME FORMATTER
  static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
  static final Locale dateTimeLocale = Locale.US;
  static final TimeZone dateTimezone = TimeZone.getTimeZone("UTC");
  static DateFormat dateTimeFormat;
  static {
    dateTimeFormat = new SimpleDateFormat(dateTimePattern, dateTimeLocale);
    dateTimeFormat.setLenient(false);
    dateTimeFormat.setTimeZone(dateTimezone);
  }


  //  POLICY FORMATTER
  List<int[]> parsePLine(String pLine) {
    List<int[]> accepted = new ArrayList<>();
    String[] pLineParts = pLine.split(" ");
    boolean policyIsAccept = "accept".equals(pLineParts[1]);
    String[] portIntervals = pLineParts[2].split(",");
    int lastToPort = 0;
    for (String portInterval : portIntervals) {
      String[] ports = portInterval.split("-");
      int fromPort = Integer.parseInt(ports[0]);
      int toPort = (ports.length == 1 ? fromPort : Integer.parseInt(ports[1]));
      if (policyIsAccept) {
        accepted.add(new int[] { fromPort, toPort });
      } else if (fromPort > lastToPort + 1) {
        accepted.add(new int[] { lastToPort + 1, fromPort - 1 });
      }
      lastToPort = toPort;
    }
    if (!policyIsAccept && lastToPort < 65535) {
      accepted.add(new int[] { lastToPort + 1, 65535 });
    }
    return accepted;
  }

  String acceptedPortIntervals(List<int[]> intervals) {
    String accepted = "p accept ";
    int writtenIntervals = 0;
    for (int[] interval : intervals) {
      accepted = accepted + (writtenIntervals++ > 0 ? "," : "") + interval[0];
      if (interval[1] > interval[0]) {
        accepted = accepted + "-" + interval[1];
      }
    }
    return accepted;
  }


}