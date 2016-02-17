package converTor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

import org.torproject.descriptor.Descriptor;

import org.apache.avro.specific.SpecificRecordBase;


/*
 * object to return from conversion
 */

class Converted  {
  // a lot of details about name, schema, schema class etc
  DescriptorType type;
  // month of creation of original descriptor, as YYYY_MM
  String date;
  // the actual data, converted to an Avro object
  SpecificRecordBase load;
}


/*
 *  templates for elements common to some or all descriptor types
 */

class ConvertCommons {

  /* make ConvertCommons super type of all Converters */
  static Converted convert(Descriptor descriptor) {
    return null;
  }


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