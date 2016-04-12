package converTor.stuff;

@Deprecated
public class WriterFactory {
/*
  //  initialized   SINGLETON
  private Boolean initialized = false;

  //  writerMap   A MAP TO HOLD ALL WRITERS PER TYPE + MONTH
  private Map<String, Write> writerMap;


  //  WriterFactory   CONSTRUCTOR
  WriterFactory() {
    if (initialized) return;
    //  initialize writer map
    writerMap = new HashMap();
    initialized = true;
  }


  //  getWriter   GET WRITER FROM MAP
  public <T extends Object> Write getWriter(Types type, String date)
      throws IOException {
    // construct writer id
    String writerID = type.name + "_" + date;
    //  create if not existant
    if (writerMap.get(writerID) == null) {
      Write writer = new Write(type, date);
      writerMap.put(writerID, writer);
    }
    return writerMap.get(writerID);
  }


  //  wrapUp    CLEAN UP AFTER THE LAST DESCRIPTOR HAS BEEN CONVERTED
  public void wrapUp() throws IOException {

    Args args = Args.INSTANCE;

    for (Write writerObject : writerMap.values()) {

      if (args.isAvro()) {
        ((DataFileWriter) writerObject.dataFileWriter).close();
      }
      else if (args.isParquet()) {
        ((ParquetWriter) writerObject.dataFileWriter).close();
      }
      else if (args.isJson()) {

        //  the OLD way
        //  todo wrap up buffered writer
        //  ((BufferedWriter) writerObject.dataFileWriter).close();

        //  the AVRO way
        writerObject.jsonEncoder.flush();

      }
    }
  }

*/
}