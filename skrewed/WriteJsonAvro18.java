package converTor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.avro.Schema;
import org.apache.avro.data.Json;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.ValidatingEncoder;
import org.apache.avro.specific.SpecificRecord;

/*
    CAUTION   this never worked
              mainly because of a bug in Avro (presumably)
              but who knows what else is going wrong
 */


public class WriteJsonAvro18 implements Write {

  Schema schema;
  String writerID;
  String output;
  File outputFile;
  Json.ObjectWriter fileWriter;

  public ValidatingEncoder jsonEncoder;


  WriteJsonAvro18(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    output = args.getOutPath() + writerID + args.getOutputFileEnding();
    outputFile = new File(output);

    // Json.ObjectWriter   ... nobody seems to use this -
    // googling returns no results
    // file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/data/Json.ObjectWriter.html
    OutputStream out = new FileOutputStream(outputFile);
    fileWriter = new Json.ObjectWriter();
    Encoder encoder = EncoderFactory.get().jsonEncoder(schema, out, args.isPretty());
    ValidatingEncoder validatingEncoder =
        EncoderFactory.get().validatingEncoder(schema, encoder);
    jsonEncoder = validatingEncoder;

    //  call writer with datum AND encoder
    //    public void write(Object datum, Encoder out) throws IOException
    //  that's bad, because we want to return a writer without data,
    //  but with encoder preconfigured



    //  MATERIALS

    /*  maybe an alternative:
    file:///Users/t/Desktop/avro/1.8/avro-1.8.0-javadoc/org/apache/avro/data/Json.html
    Json.toString(Object datum) Converts an instance of the object model to
    a JSON string... which maybe we could append to a JSON output file like
    we did in the ConvertToJson of old
     */

    /*  or like this - https://gist.github.com/hammer/76996fb8426a0ada233e
        together with this (example 10)
        - http://www.javased.com/?api=org.apache.avro.io.EncoderFactory -
    DatumWriter<Torperf> jsonDatumWriter = new SpecificDatumWriter<>(Torperf.class);
    OutputStream out = new FileOutputStream(outputFile);
    JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(schema, out);
    jsonDatumWriter.write(descType.load, jsonEncoder);
    jsonEncoder.flush();
    System.out.println("JSON encoded record: " + baos);
    // is this additionally? didn't we write to a file? ah, what file...
    */


  }

  //  APPEND CONVERTED DATA TO ENCODER/WRITER
  public void append(SpecificRecord load) throws IOException {

    Json.ObjectWriter jsonWriter = (Json.ObjectWriter) fileWriter;

    System.out.println(load); // todo   test__remove after testing

    jsonWriter.write(load, jsonEncoder);
    // fileWriter.write(load, jsonEncoder);   he? why two times??

  }

  //  WRAP UP AFTER ITERATOR HAS FINISHED ITERATING OVER INCOMING DESCRIPTORS
  public void close() throws IOException {
    //  the OLD way
    //  before big refactoring with factories
    //      ((BufferedWriter) writerObject.fileWriter).close();
    //  now probably just
    //      fileWriter.close();

    //  the AVRO way
    jsonEncoder.flush();
  }

}