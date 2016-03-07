package converTor;

import java.io.*;


/*
 *  Read all descriptors provided in the 'in' directory
 *  and initiate conversion to the desired format
 */

public class Main {

  public static Config config;
  static WriterFactory writers;
  static Controller controller;

  public static void main(String[] args) throws IOException {

    //  SET UP GLOBAL VARIABLES
    config = new Config(args);

    //  SETUP ENCODERS
    new EncoderFactory();     // todo

    //  SETUP CONVERTERS
    new ConverterFactory();   // todo

    //  SETUP OUTPUT WRITERS
    writers = new WriterFactory();

    //  READ INPUT FILES + TRIGGER APPROPRIATE CONVERSION
    controller = new Controller(config.getInPath(), config.getMax());

    //  CLOSE/FLUSH FILE WRITERS + EXIT
    writers.wrapUp();
    System.exit(0);

  }

}

