package converTor;

import converTor.format.WriterObject;
import org.apache.avro.file.DataFileWriter;
import org.apache.parquet.hadoop.ParquetWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WriterFactory {

  //  initialized   SINGLETON
  private Boolean initialized = false;

  //  writerMap   A MAP TO HOLD ALL WRITERS PER TYPE + MONTH
  private Map<String, WriterObject> writerMap;


  //  WriterFactory   CONSTRUCTOR
  WriterFactory() {
    if (initialized) return;
    //  initialize writer map
    writerMap = new HashMap();
    initialized = true;
  }


  //  getWriter   GET WRITER FROM MAP
  public <T extends Object> WriterObject getWriter(TypeFactory type, String date)
      throws IOException {
    // construct writer id
    String writerID = type.name + "_" + date;
    //  create if not existant
    if (writerMap.get(writerID) == null) {
      WriterObject writer = new WriterObject(type, date);
      writerMap.put(writerID, writer);
    }
    return writerMap.get(writerID);
  }


  //  wrapUp    CLEAN UP AFTER THE LAST DESCRIPTOR HAS BEEN CONVERTED
  public void wrapUp() throws IOException {
    for ( WriterObject writerObject : writerMap.values()) {

      if (Main.config.isAvro()) {
        ((DataFileWriter) writerObject.dataFileWriter).close();
      }
      if (Main.config.isParquet()) {
        ((ParquetWriter) writerObject.dataFileWriter).close();
      }
      if (Main.config.isJson()) {

        //  the OLD way
        //  todo wrap up buffered writer
        //  ((BufferedWriter) writerObject.dataFileWriter).close();

        //  the AVRO way
        writerObject.jsonEncoder.flush();

      }
    }
  }


}