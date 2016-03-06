package converTor.convert;

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


/*
 *  templates for elements common to some or all descriptor types
 */

public class ConvertCommons {

  /* make ConvertCommons super type of all Converters
  static Converted convert(Descriptor descriptor) {
    return null;
  }
  */

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
}