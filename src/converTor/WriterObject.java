package converTor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.avro.Schema;
import org.apache.avro.data.Json;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
// import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.ValidatingEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;

//  avro classes auto-generated from schemas
// import converTor.relay.*;
// import converTor.relayExtra.*;
// import converTor.bridgeExtra.*;
// import converTor.relayVote.*;
// import converTor.relayConsensus.*;
// import converTor.bridgeStatus.*;
// import converTor.tordnsel.*;
import converTor.torperf.*;

import static converTor.ConverTor.*;


class WriterObject {

  //  gets casted within append()
  Object dataFileWriter;

  //  jump through hoop to get the jsonEncoder from Constructor to append()
  ValidatingEncoder jsonEncoder;


  /*
   *  append converted data to encoder/writer todo
   */
  void append(SpecificRecord load) throws IOException {

    // append the converted descriptor to it
    if (avro) {
      DataFileWriter<?> avroWriter = (DataFileWriter) dataFileWriter;
      avroWriter.append(load);  //  TODO  remove the <?> from DataFileWriter<?> ?
    }
    else if (json) {
      Json.ObjectWriter jsonWriter = (Json.ObjectWriter) dataFileWriter;
      jsonWriter.write(load, jsonEncoder);
    }
    else { // parquet
      // AvroParquetWriter parquetWriter = (AvroParquetWriter) writer;
      // parquetWriter.write(converted.load);
    }
  }

  /*
   *  TODO constructor
   */
  WriterObject(DescriptorType descType, String date) throws IOException {

    String writerID = descType.name + "_" + date;
    File outputFile = new File(outPath + writerID + outputFileEnding);
    Class<?> clas = descType.schemaClas;
    Schema schema = descType.avsc;


    if (avro) {


      //  https://avro.apache.org/docs/1.8.0/api/java/org/apache/avro/specific/SpecificDatumWriter.html
      //  https://avro.apache.org/docs/current/gettingstartedjava.html#Serializing
      //  TODO  'clas' is not recognized
      DatumWriter<clas> avroDatumWriter = new SpecificDatumWriter<>(schema;
      DataFileWriter<clas> avroFileWriter = new DataFileWriter<>(avroDatumWriter);
      avroFileWriter.create(schema, outputFile);
      dataFileWriter = avroFileWriter;

      /*  if the conversion type was known beforehand the above could look like this:
      DatumWriter<Torperf> avroTorperfDatumWriter = new SpecificDatumWriter<>(Torperf.class);
      DataFileWriter<Torperf> avroTorperfFileWriter = new DataFileWriter<>(avroTorperfDatumWriter);
      avroTorperfFileWriter.create(schema, outputFile);
      dataFileWriter = avroTorperfFileWriter;  */

      /*  TRIAL AND ERROR
      //  SpecificRecordBase is the super class of all schema classes

      //  DOESN'T WORK
          Class<SpecificRecordBase> classy = (SpecificRecordBase) descType.schemaClas;
          Class<?> classy = descType.schemaClas;

      //  DOESN'T WORK EITHER
          SpecificRecordBase schemaClass = null;
          try {
            Class<?> tmp = Class.forName("converTor.ConvertTorperf"); //("converTor.Convert" + descType.clasName);
            schemaClass = (SpecificRecordBase) tmp.newInstance();
          } catch (ClassNotFoundException c) {
            System.err.println("ClassNotFoundException: "+ c.getMessage());
            c.printStackTrace();
          } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
          }
          schemaClass.getSchema();  // just checking that schemaClass is recognized

       */


    }
    if (json) {

      //  TODO  a mess
      // Json.ObjectWriter   (where was that from?)
      // nobody seems to use this - googling return no results
      // file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/data/Json.ObjectWriter.html
      Json.ObjectWriter jsonDatumWriter = new Json.ObjectWriter();
      jsonDatumWriter.setSchema(schema);
      //  define output stream
      OutputStream out = new FileOutputStream(outputFile);
      //  define encoder
      //  file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/io/JsonEncoder.html
      Encoder encoder = EncoderFactory.get().jsonEncoder(schema, out, pretty);
      //  optionally enhance by layering validation on top
      //  file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/io/EncoderFactory.html#validatingEncoder%28org.apache.avro.Schema,%20org.apache.avro.io.Encoder%29
      ValidatingEncoder validatingEncoder = EncoderFactory.get().validatingEncoder(schema, encoder);
      jsonEncoder = validatingEncoder;
      //  call writer with datum AND encoder
      //  public void write(Object datum, Encoder out) throws IOException
      //  that's bad, because we want to return a writer without data, but with encoder preconfigured
      dataFileWriter = jsonDatumWriter;


      /* maybe an alternative:
      file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/data/Json.html
      Json.toString(Object datum) Converts an instance of the object model to a JSON string.
      ... which maybe we could append to a JSON output file like we did in the ConvertToJson of old
       */

      /* or like this - https://gist.github.com/hammer/76996fb8426a0ada233e
         together with this- http://www.javased.com/?api=org.apache.avro.io.EncoderFactory - example 10
      DatumWriter<Torperf> jsonDatumWriter = new SpecificDatumWriter<>(Torperf.class);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(schema, baos);
      jsonDatumWriter.write(descType.load, jsonEncoder);
      jsonEncoder.flush();
      System.out.println("JSON encoded record: " + baos); // is this additionally? didn't we write to a file? ah, what file...
      */

      // problems with JSON number conversion? see: https://docs.oracle.com/cd/E26161_02/html/GettingStartedGuide/jsonbinding-overview.html
    }
    if (parquet) { // uses parquet-mr
      //  Hadoop Definitive Guide p.375
      //  Path is a Hadoop FileSystem command - not sure how (or if) this works on a normal file system
      //  Path parquetOutput = new Path(outPath + writerID + outputFileEnding);
      //  AvroParquetWriter<SpecificRecord> parquetWriter = new AvroParquetWriter<>(parquetOutput, schema);

      //  file:///Users/t/Desktop/parquet-avro-1.8.1-javadoc/org/apache/parquet/avro/AvroParquetWriter.Builder.html
      //  AvroParquetWriter.Builder<T> 	withSchema(org.apache.avro.Schema schema)



      //  todo  nobody answers my cry for help on stackoverflow (bloody bastards!)
      //        https://stackoverflow.com/questions/35315992/parquet-mr-avroparquetwriter-how-to-convert-data-to-parquet-with-specific-map
      //
      //        so either getting it done by more playing with the code
      //        and more staring at the javadocs

      //  todo  or prepare switch to generic mapping
      //        which will also solve some other problems with
      //          nested converter code
      //          referencing classes in WriterObject
      //          all examples using generic mapping

    }

  }

}