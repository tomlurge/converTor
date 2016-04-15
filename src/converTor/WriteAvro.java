package converTor;

import java.io.File;
import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;


public class WriteAvro implements Write {

  Schema schema;
  String writerID;
  String output;
  File outputFile;
  DataFileWriter fileWriter;


  WriteAvro(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    output = args.getOutPath() + writerID + args.getOutputFileEnding();
    outputFile = new File(output);


    //  https://avro.apache.org/docs/1.8.0/api/java/org/apache/avro/specific/SpecificDatumWriter.html
    //  https://avro.apache.org/docs/current/gettingstartedjava.html#Serializing
    DatumWriter avroDatumWriter = new SpecificDatumWriter<>(schema);
    DataFileWriter avroFileWriter = new DataFileWriter<>(avroDatumWriter);
    if (args.isCompressed()) avroFileWriter.setCodec(CodecFactory.snappyCodec());
    avroFileWriter.create(schema, outputFile);
    fileWriter = avroFileWriter;

  }


  //  APPEND CONVERTED DATA TO ENCODER/WRITER
  public void append(SpecificRecord load) throws IOException {
    DataFileWriter<SpecificRecord> avroWriter = (DataFileWriter) fileWriter;
    avroWriter.append(load);
  }


  //  WRAP UP AFTER ITERATOR HAS FINISHED ITERATING OVER INCOMING DESCRIPTORS
  public void close() throws IOException {
    fileWriter.close();
  }

}