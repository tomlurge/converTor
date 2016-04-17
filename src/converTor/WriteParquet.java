package converTor;

import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecord;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;


//  parquet-mr
class WriteParquet implements Write {

  Schema schema;
  String writerID;
  Path outputPath;
  ParquetWriter fileWriter;


  WriteParquet(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    outputPath = new Path(
        args.getOutPath() + writerID + args.getOutputFileEnding()
    );

    fileWriter = AvroParquetWriter.builder(outputPath)
        .withSchema(schema)
        .withCompressionCodec(
            args.isCompressed()
                ?
                CompressionCodecName.SNAPPY
                :
                CompressionCodecName.UNCOMPRESSED
        )
        .build();

  }


  //  APPEND CONVERTED DATA TO ENCODER/WRITER
  public void append(SpecificRecord load) throws IOException {
    fileWriter.write(load);
  }


  //  WRAP UP AFTER ITERATOR HAS FINISHED ITERATING OVER INCOMING DESCRIPTORS
  public void close() throws IOException {
    fileWriter.close();
  }

}
