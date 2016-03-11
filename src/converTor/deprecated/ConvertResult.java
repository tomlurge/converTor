package converTor.deprecated;

import converTor.TypeFactory;
import org.apache.avro.specific.SpecificRecordBase;

@Deprecated
public class ConvertResult {
  // a lot of details about name, schema, schema class etc
  public TypeFactory type;
  // month of creation of original descriptor, as YYYY_MM
  public String date;
  // the actual data, converted to an Avro object
  public SpecificRecordBase load;
}
