package convertor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;


enum Writers {

  /**
   * Writers is a singleton to hold all file writers.
   */
  INSTANCE;

  /**
   * Map to hold all writers per type + month
   */
  private Map<String, Writer> writersMap;

  /**
   * Initializes writer map
   */
  Writers() {
    writersMap = new HashMap();
  }

  /**
   * Returns writer (and creates it first if it doesn't exist yet).
   * @param type  Type of descriptor that needs to be written
   * @param date  Month of descriptor that needs to be written
   * @return      Writer for this type and month
   */
  Writer getWriter(Types type, String date) {

    /* determine writer_id */
    String writerID = type.name + "_" + date;

    /* if writer doesn't exist already create it */
    if (writersMap.get(writerID) == null) {
      Writer writer = null;
      try {
        /* create writer according to format setting */
        if (Args.INSTANCE.isAvro())
          writer = new WriterAvro(type, date);
        else if (Args.INSTANCE.isParquet())
          writer = new WriterParquet(type, date);
        else
          writer = new WriterJson(type, date);
      } catch (IOException e) {
        if (Args.INSTANCE.isLog())
          Base.logger.log(Level.WARNING,
              "IOException when trying to create writer: \n" + e.getMessage(), e
          );
        else {
          System.out.println("IOException when trying to create a writer:");
          e.printStackTrace();
        }
      }
      writersMap.put(writerID, writer);
    }
    return writersMap.get(writerID);
  }

  /**
   * Returns a list of all writers in writersMap.
   * @return  List of all writers in writersMap
   */
  List<Writer> getAllWriters() {
    List writersList = new ArrayList();
    for (Writer writer : writersMap.values()) {
      writersList.add(writer);
    }
    return writersList;
  }

}
