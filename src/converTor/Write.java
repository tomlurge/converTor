package converTor;
import java.io.*;
import org.apache.avro.specific.SpecificRecord;

interface Write {  // Write<T extends Object>   crazy generics

  //  TODO    wouldn't this make more sense as an abstract class?
  //          the concrete classes share not only some methods but also fields:
  //                Schema schema;
  //                String writerID;
  //                String output;
  //                Object outputFile;  // to be casted in the concrete class
  //                Object fileWriter;  // to be casted in the concrete class
  //  TODO    but, OTOH, future output formats could be quite different
  //          the 'pedestrian' version of JSON already is
  //          so better stick with the interface approach

  Args args = Args.INSTANCE;

  //  APPEND CONVERTED DATA TO APPROPRIATE FILE WRITER
  void append(SpecificRecord load) throws IOException;

  //  WRAP UP AFTER ITERATOR HAS FINISHED ITERATING OVER INCOMING DESCRIPTORS
  void close() throws IOException;


}