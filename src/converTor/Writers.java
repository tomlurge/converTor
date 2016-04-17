package converTor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


enum Writers {

  INSTANCE;

  //  A MAP TO HOLD ALL WRITERS PER TYPE + MONTH
  private Map<String, Write> writersMap;


  Writers() {
    //  initialize writer map
    writersMap = new HashMap();
  }


  Write getWriter(Types type, String date) {

    //  DETERMINE WRITER_ID
    String writerID = type.name + "_" + date;

    //  IF WRITER DOESN'T EXIST ALREADY CREATE IT
    if (writersMap.get(writerID) == null) {
      Write writer = null;
      try {

        //  CREATE WRITER ACCORDING TO FORMAT SETTING
        switch (Args.INSTANCE.getFormat()) {
          case ("avro") : writer = new WriteAvro(type, date); break;
          case ("parquet") : writer = new WriteParquet(type, date); break;
          case ("json") : writer = new WriteJson(type, date); break;
        }

      } catch (IOException e1) {
        System.out.println("IOException when trying to create a writer:");
        e1.printStackTrace();
      }
      writersMap.put(writerID, writer);
    }
    return writersMap.get(writerID);
  }


  List<Write> getAllWriters() {
    List writersList = new ArrayList();
    for (Write writer : writersMap.values()) {
      writersList.add(writer);
    }
    return writersList;
  }

}
