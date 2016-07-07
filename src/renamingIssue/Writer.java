package renamingIssue;

import java.io.IOException;
import org.apache.avro.specific.SpecificRecord;


interface Writer {

  Args args = Args.INSTANCE;

  /**
   * append converted data to appropriate file writer
   */
  void append(SpecificRecord load) throws IOException;

  /**
   * wrap up after iterator has finished iterating over incoming descriptors
   */
  void close() throws IOException;


}