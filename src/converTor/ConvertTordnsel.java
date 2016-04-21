package converTor;

import java.util.ArrayList;
import java.util.List;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.ExitList;
import converTor.encoders.classes.tordnsel.Tordnsel;
import converTor.encoders.classes.tordnsel.ExitNode;


//  Tordnsel == ExitList
class ConvertTordnsel extends Convert {

  //  EXITLIST
  void convert(Descriptor descriptor) {

    ExitList desc = (ExitList) descriptor;
    Tordnsel conversion = new Tordnsel();

    conversion.setDescriptorType("tordnsel 1.0");
    conversion.setDownloaded(desc.getDownloadedMillis());
    conversion.setExitNodes(convertExitNodesList(desc));


    this.type = Types.TORDNSEL;
    this.date = dateTimeFormat
        .format(desc.getDownloadedMillis()).substring(0,7);
    this.load = conversion;

  }

  //  EXITLIST NODES
  private List<ExitNode> convertExitNodesList(ExitList desc) {

    List<ExitNode> conversionExitNodesList = new ArrayList<>();


    if (desc.getEntries() != null && !desc.getEntries().isEmpty()) {

      for (ExitList.Entry entry : desc.getEntries()) {

        ExitNode con = new ExitNode();
        con.setFingerprint(entry.getFingerprint());
        con.setPublished(entry.getPublishedMillis());
        con.setLastStatus(entry.getLastStatusMillis());
        if (entry.getExitAddresses() != null &&
            !entry.getExitAddresses().isEmpty()) {
          con.setExitAdresses(entry.getExitAddresses());
        }

        conversionExitNodesList.add(con);
      }
    }

    return conversionExitNodesList;
  }

}

