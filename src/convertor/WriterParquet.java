package convertor;

import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecord;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;


/* uses parquet-mr */
class WriterParquet implements Writer {

  Schema schema;
  String writerID;
  Path outputPath;
  ParquetWriter fileWriter;


  WriterParquet(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    outputPath = new Path(
        args.getOutPath() + writerID + args.getOutputFileEnding()
    );

    fileWriter = AvroParquetWriter
        .builder(outputPath)
        .withSchema(schema)
        .withCompressionCodec(
            args.isSnappy()
              ?
              CompressionCodecName.SNAPPY
              :
              args.isZip()
                ?
                CompressionCodecName.GZIP
                :
                CompressionCodecName.UNCOMPRESSED
        )
        .build();

  }

  public void append(SpecificRecord load) throws IOException {
    fileWriter.write(load);
  }

  public void close() throws IOException {
    fileWriter.close();
  }

}