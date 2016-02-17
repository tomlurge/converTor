package converTor;

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
  static WriterObject get(DescriptorType type, String date) throws IOException {
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
    for ( WriterObject writer : typeWriterMap.values()) {
      if (avro) {
        //  pseudo todo
        //  DataFileWriter avroWriter = (DataFileWriter) writer.toDisk;
        //  avroWriter.close();
      }
      else if (json) {
        //  pseudo todo
      }
      else { // parquet
        //  pseudo todo
        //  AvroParquetWriter parquetWriter = (AvroParquetWriter) writer.toDisk;
        //  parquetWriter.close();
      }
    }
  }


}