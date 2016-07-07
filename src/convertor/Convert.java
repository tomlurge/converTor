package convertor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.avro.specific.SpecificRecordBase;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.DescriptorFile;

/**
 * Provides fields and methods that all types of converters need
 * @param <C>   type of incoming descriptor
 */
abstract class Convert<C> {

  /**
   * Details about type: name, schema, avro schema class etc
   */
  Types type;

  /**
   * Month of creation of original descriptor, as YYYY_MM
   */
  String date;

  /**
   * Avro object, containing the converted descriptor
   */
  SpecificRecordBase load;

  /**
   * Abstract convert method
   * @param descriptor   incoming descriptor
   */
  abstract void convert(Descriptor descriptor);


  /**
   * Check for unrecognized attributes
   */
  void checkUnrecognized(Descriptor descriptor, DescriptorFile descriptorFile) {
    if (!descriptor.getUnrecognizedLines().isEmpty()) {
      if (Args.INSTANCE.isLog()) {
        Base.logger.warning(
          "Unrecognized lines in " + descriptorFile.getFileName() + ":\n" +
          descriptor.getUnrecognizedLines()
        );
      }
      else {
        System.err.println("Unrecognized lines in "
            + descriptorFile.getFileName() + ":");
        System.err.println(descriptor.getUnrecognizedLines());
      }
    }
  }


  /**
   * Date-time formatter
   */
  static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
  static final Locale dateTimeLocale = Locale.US;
  static final TimeZone dateTimezone = TimeZone.getTimeZone("UTC");
  static DateFormat dateTimeFormat;
  static {
    dateTimeFormat = new SimpleDateFormat(dateTimePattern, dateTimeLocale);
    dateTimeFormat.setLenient(false);
    dateTimeFormat.setTimeZone(dateTimezone);
  }


  /**
   * Derive accepted ports
   */
  String acceptedPortIntervals(String policy, String ports)
      throws NullPointerException {

    /**
     * incoming policy - accept or reject
     */
    Boolean policyIsAccept = "accept".equals(policy);

    /**
     * incoming port intervals as array
     */
    String[] incomingIntervals = ports.split(",");

    /**
     * outgoing string containing all accepted ports
     */
    String accepted = "";

    /* derive array of accepted port intervals */
    List<int[]> intervalsArrays = new ArrayList<>();
    int lastToPort = 0;
    for (String incomingInterval : incomingIntervals) {
      String[] incomingIntervalPorts = incomingInterval.split("-");
      int fromPort = Integer.parseInt(incomingIntervalPorts[0]);
      int toPort = ( incomingIntervalPorts.length == 1
              ? fromPort
              : Integer.parseInt(incomingIntervalPorts[1])
      );
      if (policyIsAccept) {
        intervalsArrays.add(new int[] { fromPort, toPort });
      } else if (fromPort > lastToPort + 1) {
        intervalsArrays.add(new int[] { lastToPort + 1, fromPort - 1 });
      }
      lastToPort = toPort;
    }
    if (!policyIsAccept && lastToPort < 65535) {
      intervalsArrays.add(new int[] { lastToPort + 1, 65535 });
    }

    /* write array of accepted port intervals to string */
    int writtenIntervals = 0;
    for (int[] interval : intervalsArrays) {
      accepted = accepted + (writtenIntervals++ > 0 ? "," : "") + interval[0];
      if (interval[1] > interval[0]) {
        accepted = accepted + "-" + interval[1];
      }
    }

    return accepted;
  }


}