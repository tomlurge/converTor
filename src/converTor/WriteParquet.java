package converTor;

import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecord;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;


//  parquet-mr
public class WriteParquet implements Write {

  Schema schema;
  String writerID;
  String output;
  Path outputPath;
  ParquetWriter fileWriter;


  WriteParquet(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    output = args.getOutPath() + writerID + args.getOutputFileEnding();
    outputPath = new Path(output);

    ParquetWriter<Object> parquetWriter = AvroParquetWriter.builder(outputPath)
        .withSchema(schema)
        .withCompressionCodec(
            args.isCompressed() ? CompressionCodecName.SNAPPY : CompressionCodecName.UNCOMPRESSED
        )
        .build();
    fileWriter = parquetWriter;

  }


  //  APPEND CONVERTED DATA TO ENCODER/WRITER
  public void append(SpecificRecord load) throws IOException {

      // AvroParquetWriter parquetWriter = (AvroParquetWriter) writer;
      // parquetWriter.write(converted.load);
      ParquetWriter parquetWriter = (ParquetWriter) fileWriter;
      parquetWriter.write(load);
  }


  //  WRAP UP AFTER ITERATOR HAS FINISHED ITERATING OVER INCOMING DESCRIPTORS
  public void close() throws IOException {
    fileWriter.close();
  }

}
