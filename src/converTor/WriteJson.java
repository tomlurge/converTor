package converTor;

import java.io.*;
import java.util.zip.GZIPOutputStream;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecord;


class WriteJson implements Write {

  Schema schema;
  String writerID;
  File outputFile;
  BufferedWriter fileWriter;


  WriteJson(Types type, String date) throws IOException {

    schema = type.avsc;
    writerID = type.name + "_" + date;
    outputFile = new File(
        args.getOutPath() + writerID + args.getOutputFileEnding()
    );

    Writer jsonWriter;
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

  //  APPEND CONVERTED DATA TO ENCODER/WRITER
  public void append(SpecificRecord load) throws IOException {
    fileWriter.write(load + "\n");
  }

  //  WRAP UP AFTER ITERATOR HAS FINISHED ITERATING OVER INCOMING DESCRIPTORS
  public void close() throws IOException {
    fileWriter.close();
  }

}