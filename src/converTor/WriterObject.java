package converTor;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.data.Json;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
// import org.apache.avro.io.EncoderFactory;
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

  /*
   *  append converted data to encoder/writer
   */
  void append(SpecificRecordBase load) throws IOException {

    // append the converted descriptor to it
    if (avro) {
      //  pseudo todo
      //  DataFileWriter avroWriter = (DataFileWriter) this.encode;
      //  avroWriter.append(load);
    }
    else if (json) {
      //
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
    Schema schema = descType.avsc;



    WriterObject writer = null;

    if (avro) {

      //  Class<SpecificRecordBase> classy = (SpecificRecordBase) descType.schemaClas;
      //  Class<?> classy = descType.schemaClas;

      // SpecificRecordBase is the super class of all schema classes
      SpecificRecordBase clas = null;
      try {
        clas = (SpecificRecordBase) descType.schemaClas.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        e.printStackTrace();
      }
      clas.getSchema(); // test that clas is alive and kickin' todo remove

      //  https://avro.apache.org/docs/1.8.0/api/java/org/apache/avro/specific/SpecificDatumWriter.html
      //  https://avro.apache.org/docs/current/gettingstartedjava.html#Serializing
      // TODO
      DatumWriter<clas> avroDatumWriter = new SpecificDatumWriter<>(descType.avsc);
      DataFileWriter<clas> dataFileWriter = new DataFileWriter<>(avroDatumWriter);
      dataFileWriter.create(schema, outputFile);




    }
    else if (json) {

      //  TODO  a mess
      // Json.ObjectWrite   (where was that from?)
      // nobody seems to use this - queries return no results
      // it seems very low level
      Json.ObjectWriter aJsonDatumWriter = new Json.ObjectWriter();
      aJsonDatumWriter.setSchema(schema);


      /*
      // or like this - https://gist.github.com/hammer/76996fb8426a0ada233e
      // together with this- http://www.javased.com/?api=org.apache.avro.io.EncoderFactory - example 10
      DatumWriter<Torperf> jsonDatumWriter = new SpecificDatumWriter<>(Torperf.class);

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(schema, baos);


      jsonDatumWriter.write(descType.load, jsonEncoder);
      jsonEncoder.flush();
      System.out.println("JSON encoded record: " + baos); // is this additionally? didn't we write to a file? ah, what file...
      */

      // problems with JSON number conversion? see: https://docs.oracle.com/cd/E26161_02/html/GettingStartedGuide/jsonbinding-overview.html
    }
    else { // parquet, uses parquet-mr
      // Hadoop Definitive Guide p.375
      // Path is a Hadoop FileSystem command - not sure how (or if) this works on a normal file system
      //  Path parquetOutput = new Path(outPath + writerID + outputFileEnding);
      //  AvroParquetWriter<SpecificRecord> parquetWriter = new AvroParquetWriter<>(parquetOutput, schema);

      // todo   nobody answers my cry for help on stackoverflow
      //        https://stackoverflow.com/questions/35315992/parquet-mr-avroparquetwriter-how-to-convert-data-to-parquet-with-specific-map
      //
      //        so either getting it done by more playing with the code
      //        and more staring at the javadocs

      // todo   or prepare switch to generic mapping
      //        which will also solve some other problems with
      //          nested converter code
      //          referencing classes in WriterObject
      //          all examples using generic mapping

    }

  }





}

