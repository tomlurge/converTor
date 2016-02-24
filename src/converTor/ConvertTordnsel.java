package converTor;


import java.util.List;


/*
 * Tordnsel / ExitList
 */

class ConvertTordnsel extends ConvertCommons {

  List<ExitNode> exit_nodes;

  class ExitNode {
      String fingerprint;
      String published;
      String last_status;
      // List<Exit> exit_list;
      Object exit_list;
  }

  class Exit {
      String ip;
      String date;
  }

  /*  how to populate nested records/arrays/maps

  Question populating nested records in Avro using a GenericRecord
  https://stackoverflow.com/questions/5480043/question-populating-nested-records-in-avro-using-a-genericrecord

  Schema  sch =  Schema.parse(schemaFile);
  DataFileWriter<GenericRecord> fw = new DataFileWriter<GenericRecord>(new GenericDatumWriter<GenericRecord>()).create(sch, new File(outFile));
  GenericRecord r = new GenericData.Record(sch);
  r.put(“firstName”, “John”);

  GenericRecord t = new GenericData.Record(sch.getField("address").schema());
  t.put("city","beijing");
  r.put("address",t);

  fw.append(r);

  */

  /*
  Tordnsel convert(ExitList desc) {


    Tordnsel tordnsel = new Tordnsel();
    for (String annotation : desc.getAnnotations()) {
      tordnsel.setDescriptorType(annotation.substring("@type ".length()));
    }
    tordnsel.setDownloaded(desc.getDownloadedMillis();
    tordnsel.setExitNodes(AvroExitNodes.convert( ));


    tordnsel.exit_nodes = new ArrayList<>();
    if (desc.getEntries() != null && !desc.getEntries().isEmpty()) {
      for(ExitList.Entry exitEntry : desc.getEntries()) {
        ExitNode exitNode = new ExitNode();
        exitNode.fingerprint = exitEntry.getFingerprint();
        exitNode.published = dateTimeFormat.format(exitEntry.getPublishedMillis());
        exitNode.last_status = dateTimeFormat.format(exitEntry.getLastStatusMillis());
        if (exitEntry.getExitAddresses() != null && !exitEntry.getExitAddresses().isEmpty()) {
          *//**//**//**//* jagged *//**//**//**//*
          exitNode.exit_list = new HashMap<String, String>();
          HashMap<String, String> jaggedList = new HashMap<>();
          for (Map.Entry<String, Long> exitAddress : exitEntry.getExitAddresses().entrySet()) {
            jaggedList.put(exitAddress.getKey(), dateTimeFormat.format(exitAddress.getValue()));
          }
          exitNode.exit_list = jaggedList;
          if (verbose) {
            exitNode.exit_list_VERBOSE = new ArrayList<Exit>();
            ArrayList<Exit> flatExit = new ArrayList<>();
            for (Map.Entry<String, Long> exitAddress : exitEntry.getExitAddresses().entrySet()) {
              Exit exit = new Exit();
              exit.ip = exitAddress.getKey();
              exit.date = dateTimeFormat.format(exitAddress.getValue());
              flatExit.add(exit);
            }
            exitNode.exit_list = flatExit;
          }
        }
        tordnsel.exit_nodes.add(exitNode);
      }
    }


    //  inner class exitList
    class AvroExitNodes extends AvroDescriptor {
      Torperf convert(TorperfResult desc) {
        Torperf torperf = new Torperf();
        torperf.setDescriptorType("torperf 1.0");
        torperf.setSource(desc.getSource());
        torperf.setFilesize(desc.getFileSize());
        return torperf;
      }
    }

    return tordnsel;
  }
  */

}

