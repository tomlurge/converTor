package converTor;


import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.parquet.avro.AvroParquetWriter;

import static converTor.ConverTor.*;


class TypeWriter {

  DescriptorType type;
  String date;
  Object encode;
  Object serialize;

  TypeWriter(DescriptorType type, String date, Object encode, Object serialize) {
    this.type = type;
    this.date = date;
    this.encode = encode;
    this.serialize = serialize;
  }


  /*
   *  a map to hold all writers per type + month
   */
  private static Map<String, TypeWriter> typeWriterMap = new HashMap();

  static TypeWriter get(DescriptorType type, String date) {

    // construct writer id
    String writerID = type.name + "_" + date;

    //  create if not existant
    if (typeWriterMap.get(writerID) == null) {
      // create writer
      // writer = TypeWriterFactory.createWriter(converted.type, converted.date);
      TypeWriter typeWriter = TypeWriterFactory.createWriter(type, date);
      typeWriterMap.put(writerID, typeWriter);
    }
    return typeWriterMap.get(writerID);
  }


  /*
   * append converted data to encoder/writer
   */
  void append(SpecificRecordBase load) throws IOException {

    // append the converted descriptor to it
    if (avro) {
      //  pseudo todo
      DataFileWriter avroWriter = (DataFileWriter) this.encode;
      avroWriter.append(load);
    }
    else if (json) {

    }
    else { // parquet
      // AvroParquetWriter parquetWriter = (AvroParquetWriter) writer;
      // parquetWriter.write(converted.load);
    }
  }

  /*
   * flush dataWriters data to disc
   */
  static void wrapUp() throws IOException {
    for ( Object writer : typeWriterMap.values()) {
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