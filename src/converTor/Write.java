package converTor;

import java.io.IOException;
import org.apache.avro.specific.SpecificRecord;


interface Write {

  Args args = Args.INSTANCE;

  //  APPEND CONVERTED DATA TO APPROPRIATE FILE WRITER
  void append(SpecificRecord load) throws IOException;

  //  WRAP UP AFTER ITERATOR HAS FINISHED ITERATING OVER INCOMING DESCRIPTORS
  void close() throws IOException;


}