package convertor;

import java.io.*;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecord;
import org.xerial.snappy.SnappyOutputStream;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;


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

    if (args.isSnappy()) {
      jsonWriter =
          new OutputStreamWriter(
              new SnappyOutputStream(
                  new FileOutputStream(outputFile)
              )
          );
    }
    else if (args.isZip()) {
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
    if (args.isPretty()) {
      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");
      scriptEngine.put("jsonString", load);
      try {
        scriptEngine.eval("result = JSON.stringify(JSON.parse(jsonString), null, 2)");
      } catch (ScriptException e) {
        if (Args.INSTANCE.isLog())
          Base.logger.log(Level.WARNING, e.getMessage(), e);
        else e.printStackTrace();
      }
      String prettyLoad = (String) scriptEngine.get("result");
      fileWriter.write(prettyLoad + "\n");
    }
    else {
      fileWriter.write(load + "\n");
    }
  }

  public void close() throws IOException {
    fileWriter.close();
  }

}