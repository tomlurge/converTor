package converTor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Writers {

  //  SINGLETON
  //  todo    when everything else is done make this an enum
  public static final Writers INSTANCE = new Writers();


  //  A MAP TO HOLD ALL WRITERS PER TYPE + MONTH
  private Map<String, Write> writersMap;


  private Writers() {
    //  initialize writer map
    writersMap = new HashMap();
  }


  public <T extends Object> Write getWriter(Types type, String date) {
    // construct writer id
    String writerID = type.name + "_" + date;
    //  create if not existant
    if (writersMap.get(writerID) == null) {
      Write writer = null;
      try {

        switch (Args.INSTANCE.getFormat()) {
          case ("avro") : writer = new WriteAvro(type, date); break;
          case ("parquet") : writer = new WriteParquet(type, date); break;
          case ("json") : writer = new WriteJson(type, date); break;
        }

      } catch (IOException e1) {
        System.out.println("Exception when trying to create a writer:");
        e1.printStackTrace();
      }
      writersMap.put(writerID, writer);
    }
    return writersMap.get(writerID);
  }


  public List<Write> getAllWriters() {
    List writersList = new ArrayList();
    for (Write writerObject : writersMap.values()) {
      writersList.add(writerObject);
    }
    return writersList;
  }

}
