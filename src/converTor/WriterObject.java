package converTor;

import java.io.*;
import java.util.zip.GZIPOutputStream;

import org.apache.avro.io.ValidatingEncoder;
import org.apache.hadoop.fs.Path;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.Schema;
import org.apache.avro.data.Json;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;

import static converTor.ConverTor.*;



class WriterObject<T extends Object> {  // crazy generics

  //  gets casted within append()
  Json.ObjectWriter dataFileWriter;


  //  json the PEDESTRIAN way
  int written;

  //  json the AVRO way
  //  jump through hoop to get the jsonEncoder from Constructor to append()
  //  Encoder jsonEncoder;        //  not validating 1 of 2
  ValidatingEncoder jsonEncoder;  //  validating 1 of 2


  /*
   *  append converted data to encoder/writer
   */
  void append(SpecificRecord load) throws IOException {

    if (json) { // TODO

      //  the PEDESTRIAN way
/*
      System.out.println("PEDESTRIAN");
      System.out.println(load);
      System.out.println(written);
      BufferedWriter jsonWriter = (BufferedWriter) dataFileWriter;
      jsonWriter.write((written++ > 0 ? "\n" : "") + load);
*/

      //  the AVRO way
      Json.ObjectWriter jsonWriter = dataFileWriter;
      System.out.println(load);
      jsonWriter.write(load, jsonEncoder);
      dataFileWriter.write(load, jsonEncoder);

    }
/*
    if (avro) {
      DataFileWriter<SpecificRecord> avroWriter =
          (DataFileWriter) dataFileWriter;
      avroWriter.append(load);
    }
    if (parquet) {
      // AvroParquetWriter parquetWriter = (AvroParquetWriter) writer;
      // parquetWriter.write(converted.load);
      ParquetWriter parquetWriter = (ParquetWriter) dataFileWriter;
      parquetWriter.write(load);
    }
*/

  }



  /*
   *  constructor
   */
  WriterObject(DescriptorType descType, String date) throws IOException {

    String writerID = descType.name + "_" + date;
    File outputFile = new File(outPath + writerID + outputFileEnding);
    Path outputPath = new Path(outPath + writerID + outputFileEnding);
    Schema schema = descType.avsc;

    if (json) { // TODO

      //  the PEDESTRIAN way
/*
      Writer pedestrianJsonWriter;
      if (compressed) {
        pedestrianJsonWriter = new OutputStreamWriter(new GZIPOutputStream(
            new FileOutputStream(outputFile)));
      }
      else {
        pedestrianJsonWriter = new FileWriter(outputFile);
      }
      BufferedWriter bufferedPedestrianJsonWriter =
          new BufferedWriter(pedestrianJsonWriter);
      dataFileWriter = bufferedPedestrianJsonWriter;
      written = 0;
*/

      //  the AVRO way

      // Json.ObjectWriter   ... nobody seems to use this - googling return no results
      // file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/data/Json.ObjectWriter.html
      Json.ObjectWriter jsonDatumWriter = new Json.ObjectWriter();
      // jsonDatumWriter.setSchema((org.apache.avro.data.Json.SCHEMA)); // no need
      OutputStream out = new FileOutputStream(outputFile);
      //  TODO  this is inefficient as it creates one encoder per month and type
      //        instead of just one encoder per type.
      //        but a solution is involved since an encoder depends not only on a
      //        schema but also the output path, which contains the month. so..
      Encoder encoder = EncoderFactory.get().jsonEncoder(schema, out, pretty);

      //  jsonEncoder = encoder;    //  not validating 2 of 2
      //  validating 2 of 2
      ValidatingEncoder validatingEncoder =
          EncoderFactory.get().validatingEncoder(schema, encoder);
      jsonEncoder = validatingEncoder;

      //  call writer with datum AND encoder
      //    public void write(Object datum, Encoder out) throws IOException
      //  that's bad, because we want to return a writer without data, but with encoder preconfigured

      dataFileWriter = jsonDatumWriter;


      /*   TODO  file bug report

      Json.ObjectWriter jsonDatumWriter = new Json.ObjectWriter();
      jsonDatumWriter.setSchema((org.apache.avro.data.Json.SCHEMA));
      OutputStream out = new FileOutputStream(outputFile);
      Encoder encoder = EncoderFactory.get().jsonEncoder(schema, out, pretty);
      jsonEncoder = encoder;
      dataFileWriter = jsonDatumWriter;

      throws
      Exception in thread "main" java.lang.NullPointerException
        at org.apache.avro.data.Json.write(Json.java:183)
        at org.apache.avro.data.Json.writeObject(Json.java:272)
        at org.apache.avro.data.Json.access$000(Json.java:48)
        at org.apache.avro.data.Json$ObjectWriter.write(Json.java:122)
        at converTor.WriterObject.append(WriterObject.java:52)
        at converTor.ConverTor.main(ConverTor.java:251)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:606)
        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)

       */


      //  MATERIALS

      /*  maybe an alternative:
      file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/data/Json.html
      Json.toString(Object datum) Converts an instance of the object model to a JSON string.
      ... which maybe we could append to a JSON output file like we did in the ConvertToJson of old
       */

      /*  or like this - https://gist.github.com/hammer/76996fb8426a0ada233e
          together with this- http://www.javased.com/?api=org.apache.avro.io.EncoderFactory - example 10
      DatumWriter<Torperf> jsonDatumWriter = new SpecificDatumWriter<>(Torperf.class);
      OutputStream out = new FileOutputStream(outputFile);
      JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(schema, out);
      jsonDatumWriter.write(descType.load, jsonEncoder);
      jsonEncoder.flush();
      System.out.println("JSON encoded record: " + baos); // is this additionally? didn't we write to a file? ah, what file...
      */

    }
/*

    if (avro) {
      //  https://avro.apache.org/docs/1.8.0/api/java/org/apache/avro/specific/SpecificDatumWriter.html
      //  https://avro.apache.org/docs/current/gettingstartedjava.html#Serializing
      DatumWriter<T> avroDatumWriter = new SpecificDatumWriter<>(schema); // crazy generics
      DataFileWriter<T> avroFileWriter = new DataFileWriter<>(avroDatumWriter); // crazy generics
      if (compressed) avroFileWriter.setCodec(CodecFactory.snappyCodec());
      avroFileWriter.create(schema, outputFile);
      dataFileWriter = avroFileWriter;
    }

    if (parquet) { // uses parquet-mr
      CompressionCodecName cc = CompressionCodecName.UNCOMPRESSED;
      if (compressed) {
        cc = CompressionCodecName.SNAPPY;
      }
      ParquetWriter<Object> parquetWriter = AvroParquetWriter.builder(outputPath)
          .withSchema(schema)
          .withCompressionCodec(cc)
          .build();
      dataFileWriter = parquetWriter;
    }
*/

  }

}