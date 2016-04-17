package converTor;

import java.io.File;
import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;


class WriteAvro implements Write {

  Schema schema;
  String writerID;
  File outputFile;
  DataFileWriter fileWriter;


  WriteAvro(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    outputFile = new File(
        args.getOutPath() + writerID + args.getOutputFileEnding()
    );

    DatumWriter avroDatumWriter = new SpecificDatumWriter(schema);
    fileWriter = new DataFileWriter(avroDatumWriter);
    if (args.isCompressed())
      fileWriter.setCodec(CodecFactory.snappyCodec());
    fileWriter.create(schema, outputFile);

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