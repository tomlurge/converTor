package converTor.util;

import converTor.Type;
import org.apache.avro.specific.SpecificRecordBase;

public class ConvertResult {
  // a lot of details about name, schema, schema class etc
  public Type type;
  // month of creation of original descriptor, as YYYY_MM
  public String date;
  // the actual data, converted to an Avro object
  public SpecificRecordBase load;
}
