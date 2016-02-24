package converTor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//  stupid ParquetWriter needs Hadoop FS aoutput path
import org.apache.avro.file.CodecFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import org.apache.avro.Schema;
import org.apache.avro.data.Json;
import org.apache.avro.file.DataFileWriter;
// import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.ValidatingEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
// import org.apache.parquet.avro.AvroSchemaConverter;
// import org.apache.parquet.avro.AvroWriteSupport;
// import org.apache.parquet.hadoop.metadata.CompressionCodecName;
// import org.apache.parquet.schema.MessageType;

//  avro classes auto-generated from schemas
import converTor.relay.*;
import converTor.relayExtra.*;
import converTor.bridgeExtra.*;
import converTor.relayVote.*;
import converTor.relayConsensus.*;
import converTor.bridgeStatus.*;
import converTor.tordnsel.*;
import converTor.torperf.*;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;


import static converTor.ConverTor.*;
import static org.apache.avro.data.Json.SCHEMA;



class WriterObject<T extends Object> {  // crazy generics

  //  gets casted within append()
  Object dataFileWriter;

  //  jump through hoop to get the jsonEncoder from Constructor to append()
  //  not validating 1 of 2
  Encoder jsonEncoder = null;
  //  validating 1 of 2
  //ValidatingEncoder jsonEncoder;


  /*
   *  append converted data to encoder/writer todo
   */
  void append(SpecificRecord load, Encoder jsonEncoder) throws IOException {

    // append the converted descriptor to it
    if (avro) {
      DataFileWriter<SpecificRecord> avroWriter = (DataFileWriter) dataFileWriter;
      avroWriter.append(load);
    }
    else if (json) {
      Json.ObjectWriter jsonWriter = (Json.ObjectWriter) dataFileWriter;
      jsonWriter.write(load, jsonEncoder);
    }
    else { // parquet
      // AvroParquetWriter parquetWriter = (AvroParquetWriter) writer;
      // parquetWriter.write(converted.load);
      ParquetWriter parquetWriter = (ParquetWriter) dataFileWriter;
      parquetWriter.write(load);
    }
  }



  /*
   *  TODO constructor
   */
  WriterObject(DescriptorType descType, String date) throws IOException {

    String writerID = descType.name + "_" + date;
    File outputFile = new File(outPath + writerID + outputFileEnding);
    Path outputPath = new Path(outPath + writerID + outputFileEnding);
    Class<?> clas = descType.schemaClas;  // crazy generics - this can go
    Schema schema = descType.avsc;
    //  trying another deserialization approach
    //  because of the trouble with JSON conversion
    Schema jsonschema = descType.jsonavsc;


    if (avro) {

      //  https://avro.apache.org/docs/1.8.0/api/java/org/apache/avro/specific/SpecificDatumWriter.html
      //  https://avro.apache.org/docs/current/gettingstartedjava.html#Serializing
      DatumWriter<T> avroDatumWriter = new SpecificDatumWriter<>(schema); // crazy generics
      DataFileWriter<T> avroFileWriter = new DataFileWriter<>(avroDatumWriter); // crazy generics
      //  https://avro.apache.org/docs/1.8.0/api/java/org/apache/avro/file/DataFileWriter.html#setCodec(org.apache.avro.file.CodecFactory)
      if (compressed) avroFileWriter.setCodec(CodecFactory.snappyCodec());
      avroFileWriter.create(schema, outputFile);
      dataFileWriter = avroFileWriter;

      /*  if the conversion type was known beforehand the above could look like this:
      DatumWriter<Torperf> avroTorperfDatumWriter = new SpecificDatumWriter<>(Torperf.class);
      DataFileWriter<Torperf> avroTorperfFileWriter = new DataFileWriter<>(avroTorperfDatumWriter);
      avroTorperfFileWriter.create(schema, outputFile);
      dataFileWriter = avroTorperfFileWriter;  */

    }


    if (json) {

      // Json.ObjectWriter   ... nobody seems to use this - googling return no results
      // file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/data/Json.ObjectWriter.html
      Json.ObjectWriter jsonDatumWriter = new Json.ObjectWriter();
      jsonDatumWriter.setSchema(schema);


      //  define output stream
      OutputStream out = new FileOutputStream(outputFile);
      //  define encoder
      //  file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/io/JsonEncoder.html
      //  TODO  this is inefficient as it creates one encoder per month and type
      //        instead of just one encoder per type.
      //        but a solution is involved since an encoder depends not only on a
      //        schema but also the output path, which contains the month. so...
      Encoder encoder = EncoderFactory.get().jsonEncoder(schema, out, pretty);

      //  not validating 2 of 2
      jsonEncoder = encoder;

      //  validating 2 of 2
      //  layering validation on top
      //  file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/io/EncoderFactory.html#validatingEncoder%28org.apache.avro.Schema,%20org.apache.avro.io.Encoder%29
      //  ValidatingEncoder validatingEncoder = EncoderFactory.get().validatingEncoder(schema, encoder);
      //  jsonEncoder = validatingEncoder;


      //  call writer with datum AND encoder
      //    public void write(Object datum, Encoder out) throws IOException
      //  that's bad, because we want to return a writer without data, but with encoder preconfigured
      dataFileWriter = jsonDatumWriter;



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

      // problems with JSON number conversion? see: https://docs.oracle.com/cd/E26161_02/html/GettingStartedGuide/jsonbinding-overview.html
    }


    if (parquet) { // uses parquet-mr

      CompressionCodecName cc = CompressionCodecName.UNCOMPRESSED;
      if (compressed) {
        cc = CompressionCodecName.SNAPPY;
      }

      //  Hadoop Definitive Guide p.375
      //  Path is a Hadoop FileSystem command - not sure how (or if) this works on a normal file system
      //  Path parquetOutput = new Path(outPath + writerID + outputFileEnding);
      //  AvroParquetWriter<SpecificRecord> parquetWriter = new AvroParquetWriter<>(parquetOutput, schema);

      //  file:///Users/t/Desktop/parquet-avro-1.8.1-javadoc/org/apache/parquet/avro/AvroParquetWriter.Builder.html
      //  AvroParquetWriter.Builder<T> 	withSchema(org.apache.avro.Schema schema)
      //
      //  https://stackoverflow.com/questions/35315992/parquet-mr-avroparquetwriter-how-to-convert-data-to-parquet-with-specific-map
      //  Try AvroParquetWriter.builder :
      ParquetWriter<Object> parquetWriter = AvroParquetWriter.builder(outputPath)
          .withSchema(schema)
          .withCompressionCodec(cc)
          .build();
      dataFileWriter = parquetWriter;

    }

  }

}