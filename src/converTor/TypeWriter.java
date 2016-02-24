package converTor;

import org.apache.avro.file.DataFileWriter;
import org.apache.parquet.avro.AvroParquetWriter;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import static converTor.ConverTor.*;


class TypeWriter {


  /*
   *  a map to hold all writers per type + month
   */
  private static Map<String, WriterObject> typeWriterMap = new HashMap();


  /*
   *  a getter for that map
   */
  // static WriterObject get(DescriptorType type, String date) throws IOException {
  static <T extends Object> WriterObject get(DescriptorType type, String date) throws IOException {  // crazy generics
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
  static void wrapUp() throws IOException {
    for ( WriterObject writerObject : typeWriterMap.values()) {
      if (avro) {
        ((DataFileWriter) writerObject.dataFileWriter).close();
      }
      if (json) {
        // todo
      }
      if (parquet) {
        ((AvroParquetWriter) writerObject.dataFileWriter).close();
      }
    }
  }


}