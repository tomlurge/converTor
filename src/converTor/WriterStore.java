package converTor;

import converTor.util.ConvertType;
import converTor.format.WriterObject;
import org.apache.avro.file.DataFileWriter;
import org.apache.parquet.hadoop.ParquetWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class WriterStore {

  //  A MAP TO HOLD ALL WRITERS PER TYPE + MONTH
  private static Map<String, WriterObject> writerStoreMap;

  //  MAP INITIALIZED THROUGH CALL IN MAIN
  public WriterStore() {
    writerStoreMap = new HashMap();
  }

  //  A GETTER FOR THAT MAP
  public static <T extends Object> WriterObject get(ConvertType type, String date)
      throws IOException {
    // construct writer id
    String writerID = type.name + "_" + date;
    //  create if not existant
    if (writerStoreMap.get(writerID) == null) {
      WriterObject writer = new WriterObject(type, date);
      writerStoreMap.put(writerID, writer);
    }
    return writerStoreMap.get(writerID);
  }

  //  CLEAN UP AFTER THE LAST DESCRIPTOR HAS BEEN CONVERTED
  public static void wrapUp() throws IOException {
    for ( WriterObject writerObject : writerStoreMap.values()) {

      if (Config.isAvro()) {
        ((DataFileWriter) writerObject.dataFileWriter).close();
      }
      if (Config.isParquet()) {
        ((ParquetWriter) writerObject.dataFileWriter).close();
      }
      if (Config.isJson()) {

        //  the OLD way
        //  todo wrap up buffered writer
        //  ((BufferedWriter) writerObject.dataFileWriter).close();

        //  the AVRO way
        writerObject.jsonEncoder.flush();

      }
    }
  }

}