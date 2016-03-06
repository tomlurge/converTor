package converTor;

import java.io.*;


/*
 *  Read all descriptors provided in the 'in' directory
 *  and initiate conversion to the desired format
 */


public class Main {

  public static void main(String[] args) throws IOException {

    //  SET UP GLOBAL VARIABLES
    new Config(args);
    //  Config.init(args)         // todo   without new(), singleton

    //  SETUP ENCODERS
    //  EncoderFactory.init();    // todo   without new(), singleton

    //  SETUP CONVERTERS
    //  ConverterFactory.init();  // todo   without new(), singleton

    //  SETUP OUTPUT WRITERS
    new WriterStore();
    //  WriterFactory.init()      // todo   without new(), singleton

    //  READ INPUT FILES + TRIGGER APPROPRIATE CONVERSION
    new Controller();
    //  Controller.iterate(Config.inPath) // todo   without new(), singleton

    //  CLOSE/FLUSH FILE WRITERS + EXIT
    WriterStore.wrapUp();         // todo   WriterFactory.wrapUp();
    System.exit(0);

  }

}

