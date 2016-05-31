package converTor;

import java.io.File;
import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;


class WriterAvro implements Writer {

  Schema schema;
  String writerID;
  File outputFile;
  DataFileWriter fileWriter;


  WriterAvro(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    outputFile = new File(
        args.getOutPath() + writerID + args.getOutputFileEnding()
    );

    /* specific datum writer */
    DatumWriter avroDatumWriter = new SpecificDatumWriter(schema);

    /* file writer */
    fileWriter = new DataFileWriter(avroDatumWriter);
    if (args.isCompressedSnappy()) {
      fileWriter.setCodec(CodecFactory.snappyCodec());
    }
    else if (args.isCompressedZ()) {
      fileWriter.setCodec(CodecFactory.bzip2Codec());
      // fileWriter.setCodec(CodecFactory.deflateCodec(CodecFactory.DEFAULT_DEFLATE_LEVEL));
      // fileWriter.setCodec(CodecFactory.xzCodec(CodecFactory.DEFAULT_XZ_LEVEL));
    }
    fileWriter.create(schema, outputFile);

  }

  public void append(SpecificRecord load) throws IOException {
    /*  call fileWriter (which holds datumWriter/schema) */
    DataFileWriter<SpecificRecord> avroWriter = (DataFileWriter) fileWriter;
    /*  append load to fileWriter */
    avroWriter.append(load);
  }

  public void close() throws IOException {
    fileWriter.close();
  }

}