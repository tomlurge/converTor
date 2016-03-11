package converTor;

import org.torproject.descriptor.Descriptor;

import java.io.*;


/*
 *  Read all descriptors provided in the 'in' directory
 *  and for each initiate conversion to the desired format
 */

public class Main {



  public static Config config;
  static TypeFactory types;
  static WriterFactory writers;
  static EncoderFactory encoder;
  // static Iterator iterator;


  public static void main(String[] args) throws IOException, ClassNotFoundException {

    // so würde zb ein komplett nicht statische sprojekt anfangen
    // aus der statischen main() heraus wird ein neues objekt erzeugt
    // (in diesem fall vom typ Main, aber das ist nicht zwingend)
    // in dem dann alle arbeit in instnazen abgewickelt wird
    Main meins = new Main();    // neu

    //  EVALUATE COMMAND LINE ARGUMENTS
    meins.config = new Config(args); // verändert


    //  SETUP ENCODERS
    EncoderFactory encoder = new EncoderFactory();     //  todo singleton //

    // kann ganz weg, stattdessen singleton da wo er gebraucht wird
    // und aufruf wie näcshte zeile
    // EncoderFactory.getInstance().

    /*  SETUP CONVERTERS
    new ConverterFactory();       todo   probably not necessary   */


    //  SETUP OUTPUT WRITERS
    writers = new WriterFactory();


    //  ITERATE OVER INPUT FILES
    Iterator iterator = new Iterator(config.getInPath(), config.getMaxFiles());

    while (iterator.hasNextFile) {
      for (Descriptor descriptor : iterator.getNextFile().getDescriptors()) {


        //  CONVERT EACH DESCRIPTOR
        new Conversion(descriptor);


        iterator.checkUnrecognized(descriptor, iterator.getNextFile());
      }
    }


    //  CLOSE/FLUSH FILE WRITERS + EXIT
    writers.wrapUp();
    System.exit(0);

  }


}

