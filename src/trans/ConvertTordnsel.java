package trans;

import java.util.List;
import java.util.ArrayList;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.ExitList;
import trans.encoders.tordnsel.*;


/* Tordnsel == ExitList */
class ConvertTordnsel extends Convert {

  void convert(Descriptor descriptor, Long srcDate) {

    ExitList desc = (ExitList) descriptor;
    Tordnsel conversion = new Tordnsel();

    for (String annotation : desc.getAnnotations()) {
      conversion.setDescriptorType(annotation.substring("@type ".length()));
    }
    conversion.setSrcDate(srcDate);
    conversion.setDownloaded(desc.getDownloadedMillis());
    conversion.setExitNodes(convertExitNodesList(desc));

    this.type = Types.TORDNSEL;
    this.date = dateTimeFormat
        .format(desc.getDownloadedMillis()).substring(0,7);
    this.load = conversion;

  }


  private List<ExitNode> convertExitNodesList(ExitList desc) {
    List<ExitNode> conList = new ArrayList<>();

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
        conList.add(con);
      }
    }

    return conList;
  }

}

