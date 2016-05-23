package converTor;

import java.io.*;
import java.util.zip.GZIPOutputStream;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecord;


class WriterJson implements Writer {

  Schema schema;
  String writerID;
  File outputFile;
  BufferedWriter fileWriter;


  WriterJson(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    outputFile = new File(
        args.getOutPath() + writerID + args.getOutputFileEnding()
    );

    java.io.Writer jsonWriter;
    if (args.isCompressed()) {
      jsonWriter =
          new OutputStreamWriter(
              new GZIPOutputStream(
                  new FileOutputStream(outputFile)
              )
          );
    }
    else {
      jsonWriter = new FileWriter(outputFile);
    }
    fileWriter = new BufferedWriter(jsonWriter);

  }

  public void append(SpecificRecord load) throws IOException {
    fileWriter.write(load + "\n");
  }

  public void close() throws IOException {
    fileWriter.close();
  }

}