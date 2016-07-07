package renamingIssue;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeNetworkStatus;
import org.torproject.descriptor.NetworkStatusEntry;
import renamingIssue.encoders.bridgeStatus.*;


class ConvertBridgeStatus extends Convert {

  void convert(Descriptor descriptor) {

    BridgeNetworkStatus desc = (BridgeNetworkStatus) descriptor;
    BridgeStatus conversion = new BridgeStatus();

    for (String annotation : desc.getAnnotations()) {
      conversion.setDescriptorType(annotation.substring("@type ".length()));
    }
    conversion.setPublished(desc.getPublishedMillis());
    conversion.setFlagTresholds(convertFlagTresholds(desc));
    if (desc.getStatusEntries() != null && !desc.getStatusEntries().isEmpty()) {
      conversion.setStatus(convertStatus(desc));
    }

    this.type = Types.BRIDGE_STATUS;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }


  private FlagTresholds convertFlagTresholds(BridgeNetworkStatus desc) {
    FlagTresholds con = new FlagTresholds();
    if (desc.getStableUptime() >= 0) {
      con.setStableUptime(desc.getStableUptime());
    }
    if (desc.getStableMtbf() >= 0) {
      con.setStableMtbf(desc.getStableMtbf());
    }
    if (desc.getEnoughMtbfInfo() >= 0) {
      con.setEnoughMtbf(desc.getEnoughMtbfInfo());
    }
    if (desc.getFastBandwidth() >= 0) {
      con.setFastSpeed(desc.getFastBandwidth());
    }
    if (desc.getGuardWfu() >= 0) {
      con.setGuardWfu(desc.getGuardWfu());
    }
    if (desc.getGuardTk() >= 0) {
      con.setGuardTk(desc.getGuardTk());
    }
    if (desc.getGuardBandwidthIncludingExits() >= 0) {
      con.setGuardBwIncExits(desc.getGuardBandwidthIncludingExits());
    }
    if (desc.getGuardBandwidthExcludingExits() >= 0) {
      con.setGuardBwExcExits(desc.getGuardBandwidthExcludingExits());
    }
    if (desc.getIgnoringAdvertisedBws() >= 0) {
      con.setIgnoringAdvertisedBws(desc.getIgnoringAdvertisedBws());
    }
    return con;
  }


  private Map<String,Status> convertStatus(BridgeNetworkStatus desc) {
    Map<String,Status> conMap = new HashMap<>();
    for (
        Map.Entry<String,NetworkStatusEntry> entry :
        desc.getStatusEntries().entrySet()
      ) {
      Status con = new Status();
      con.setR(convertR(entry.getValue()));
      con.setA(convertOrAdresses(entry.getValue().getOrAddresses()));
      if (entry.getValue().getFlags() != null &&
          !entry.getValue().getFlags().isEmpty()) {
        con.setS(new ArrayList<String>(entry.getValue().getFlags()));
      }
      con.setV(entry.getValue().getVersion());
      con.setW(convertW(entry.getValue()));
      if (entry.getValue().getDefaultPolicy() != null
          && entry.getValue().getPortList() != null) {
        con.setP(convertPolicy(entry.getValue()));
      }
      conMap.put(entry.getKey(),con);
    }
    return conMap;
  }


  private R convertR(NetworkStatusEntry entry) {
    R con = new R();
    con.setNickname(entry.getNickname());
    con.setIdentity(entry.getFingerprint());
    con.setDigest(entry.getDescriptor());
    con.setPublished(entry.getPublishedMillis());
    con.setIp(entry.getAddress());
    con.setOrPort(entry.getOrPort());
    con.setDirPort(entry.getDirPort());
    return con;
  }


  private List<OrAddress> convertOrAdresses(List<String> orAddresses) {
    List<OrAddress> conList = new ArrayList<>();
    for (String orAddress : orAddresses) {
      if (!orAddress.contains(":")) {
        continue;
      }
      OrAddress con = new OrAddress();
      int lastColon = orAddress.lastIndexOf(":");
      try {
        con.setAddress(orAddress.substring(0, lastColon));
        con.setPort(Integer.parseInt(orAddress.substring(lastColon + 1)));
        conList.add(con);
      } catch (NumberFormatException e) {
        continue;
      }
    }
    return conList;
  }


  private W convertW(NetworkStatusEntry entry) {
    W con = new W();
    if (entry.getBandwidth() >= 0) {
      con.setBandwidth(entry.getBandwidth());
    }
    if (entry.getMeasured() >= 0) {
      con.setMeasured(entry.getMeasured());
    }
    con.setUnmeasured(entry.getUnmeasured());
    return con;
  }


  private Policy convertPolicy(NetworkStatusEntry entry) {
    Policy con = new Policy();
    con.setDefaultPolicy("accept");
    con.setPortSummary(
        acceptedPortIntervals(entry.getDefaultPolicy(),entry.getPortList())
    );
    return con;
  }

}