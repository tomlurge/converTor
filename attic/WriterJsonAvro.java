package converTor;

import java.io.*;

import org.apache.avro.Schema;
import org.apache.avro.data.Json;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.ValidatingEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;

/**
 * TODO   this code is buggy
 *        it writes only the first descriptor to the output
 *        it also doesn't compress
 *
 *  I gave up on it because the JSON that Avro generates is very verbose
 *        it expands every value to an object {type_of_value: value}
 *        which is just plain annoying
 *
 * some resources that were useful:
 * # https://gist.github.com/hammer/76996fb8426a0ada233e
 * + http://www.javased.com/?api=org.apache.avro.io.EncoderFactory (example 10)
 * # http://www.programcreek.com/java-api-examples/index.php?api=org.apache.avro.specific.SpecificDatumWriter
 * # http://blog.jeffli.me/blog/2014/04/08/avro-cookbook-part-iii/
 */

@Deprecated
public class WriterJsonAvro implements Writer {

  Schema schema;
  String writerID;
  File outputFile;
  DataFileWriter fileWriter;
  SpecificDatumWriter avroDatumWriter;
  Encoder jsonEncoder;
  ValidatingEncoder validatingJsonEncoder;
  OutputStream out;
  ByteArrayOutputStream bytes;

  WriterJsonAvro(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    outputFile = new File(
        args.getOutPath() + writerID + args.getOutputFileEnding()
    );

    /* file output stream */
    out = new FileOutputStream(outputFile);

    /* byte array output stream */
    bytes = new ByteArrayOutputStream();


    /* validating JSON encoder */
    jsonEncoder =
        EncoderFactory.get().jsonEncoder(schema, bytes, args.isPretty());
    validatingJsonEncoder =
        EncoderFactory.get().validatingEncoder(schema, jsonEncoder);

    /* specific datum writer */
    avroDatumWriter = new SpecificDatumWriter(schema);

    /* file writer */
    fileWriter = new DataFileWriter(avroDatumWriter);
    if (args.isCompressed()) {
      fileWriter.setCodec(CodecFactory.snappyCodec()); // or: deflate, bzip2, xz
    }
    fileWriter.create(schema, outputFile);
  }

  public void append(SpecificRecord load) throws IOException {
    System.out.println(load); // todo   test__remove after testing
    avroDatumWriter.write(load,jsonEncoder);
  }

  public void close() throws IOException {
    jsonEncoder.flush();
    bytes.writeTo(out);
    fileWriter.close();
  }

}