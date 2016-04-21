package converTor;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import converTor.encoders.classes.bridgeStatus.*;
import converTor.encoders.classes.bridgeStatus.OrAddress;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeNetworkStatus;
import org.torproject.descriptor.NetworkStatusEntry;


class ConvertBridgeStatus extends Convert {

  void convert(Descriptor descriptor) {

    BridgeNetworkStatus desc = (BridgeNetworkStatus) descriptor;
    BridgeStatus conversion = new BridgeStatus();

    conversion.setDescriptorType("bridge-network-status 1.0");
    conversion.setPublished(desc.getPublishedMillis());
    conversion.setFlagTresholds(convertFlagTresholds(desc));
    conversion.setStatus(convertStatus(desc));

    this.type = Types.BRIDGE_STATUS;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }


  private FlagTresholds convertFlagTresholds(BridgeNetworkStatus desc) {
    FlagTresholds con = new FlagTresholds();
    con.setStableUptime(desc.getStableUptime());
    con.setStableMtbf(desc.getStableMtbf());
    con.setEnoughMtbf(desc.getEnoughMtbfInfo());
    con.setFastSpeed(desc.getFastBandwidth());
    con.setGuardWfu(desc.getGuardWfu());
    con.setGuardTk(desc.getGuardTk());
    con.setGuardBwIncExits(desc.getGuardBandwidthIncludingExits());
    con.setGuardBwExcExits(desc.getGuardBandwidthExcludingExits());
    con.setIgnoringAdvertised(desc.getIgnoringAdvertisedBws());
    return con;
  }


  private List<Status> convertStatus(BridgeNetworkStatus desc) {
    List<Status> cons = new ArrayList<>();
    for (
      Map.Entry<String,NetworkStatusEntry> entry :
      desc.getStatusEntries().entrySet()
    ) {
      Status con = new Status();
      con.setR(convertR(entry.getValue()));
      con.setA(convertOrAdresses(entry.getValue().getOrAddresses()));
      con.setS(new ArrayList<String>(entry.getValue().getFlags()));
      con.setV(entry.getValue().getVersion());
      con.setW(convertW(entry.getValue()));
      con.setP(convertPolicy(entry.getValue()));
      cons.add(con);
    }
    return cons;
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
    List<OrAddress> cons = new ArrayList<>();
    for (String orAddress : orAddresses) {
      if (!orAddress.contains(":")) {
        continue;
      }
      OrAddress ora = new OrAddress();
      int lastColon = orAddress.lastIndexOf(":");
      try {
        ora.setAddress(orAddress.substring(0, lastColon));
        ora.setPort(Integer.parseInt(orAddress.substring(lastColon + 1)));
        cons.add(ora);
      } catch (NumberFormatException e) {
        continue;
      }
    }
    return cons;
  }


  private W convertW(NetworkStatusEntry entry) {
    W con = new W();
    con.setBandwidth(entry.getBandwidth());
    con.setMeasured(entry.getMeasured());
    con.setUnmeasured(entry.getUnmeasured());
    return con;
  }


  private Policy convertPolicy(NetworkStatusEntry entry) {
    Policy con = new Policy();
    con.setDefaultPolicy(entry.getDefaultPolicy());
    con.setPortSummary(entry.getPortList());
    return con;
  }


}