package converTor.util;

import converTor.util.WriterObject;
import org.apache.avro.file.DataFileWriter;
import org.apache.parquet.hadoop.ParquetWriter;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import static converTor.Main.*;


public class TypeWriter {


  /*
   *  a map to hold all writers per type + month
   */
  private static Map<String, WriterObject> typeWriterMap = new HashMap();


  /*
   *  a getter for that map
   */
  public static <T extends Object> WriterObject get(DescriptorType type, String date)
      throws IOException {
    // construct writer id
    String writerID = type.name + "_" + date;
    //  create if not existant
    if (typeWriterMap.get(writerID) == null) {
      WriterObject writer = new WriterObject(type, date);
      typeWriterMap.put(writerID, writer);
    }
    return typeWriterMap.get(writerID);
  }


  /*
   *  clean up after the last descriptor has been converted
   */
  public static void wrapUp() throws IOException {
    for ( WriterObject writerObject : typeWriterMap.values()) {

      if (avro) {
        ((DataFileWriter) writerObject.dataFileWriter).close();
      }
      if (parquet) {
        ((ParquetWriter) writerObject.dataFileWriter).close();
      }
      if (json) {

        //  the OLD way
        //  todo wrap up buffered writer
        //  ((BufferedWriter) writerObject.dataFileWriter).close();

        //  the AVRO way
        writerObject.jsonEncoder.flush();

      }
    }
  }

}