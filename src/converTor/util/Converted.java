package converTor.util;

import converTor.util.DescriptorType;
import org.apache.avro.specific.SpecificRecordBase;

public class Converted  {
  // a lot of details about name, schema, schema class etc
  public DescriptorType type;
  // month of creation of original descriptor, as YYYY_MM
  public String date;
  // the actual data, converted to an Avro object
  public SpecificRecordBase load;
}
