package convertor;

import java.util.List;
import java.util.ArrayList;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeServerDescriptor;
import org.torproject.descriptor.BandwidthHistory;
import convertor.encoders.bridge.*;


class ConvertBridge extends Convert {

  void convert(Descriptor descriptor) {

    BridgeServerDescriptor desc = (BridgeServerDescriptor) descriptor;
    Bridge conversion = new Bridge();

    for (String annotation : desc.getAnnotations()) {
      conversion.setDescriptorType(annotation.substring("@type ".length()));
    }
    conversion.setServerDescriptorDigest(
      desc.getServerDescriptorDigest().toUpperCase()
    );
    conversion.setServerDescriptorSha256(
      desc.getServerDescriptorDigestSha256()
    );
    conversion.setRouter(
      convertRouter(desc)
    );
    conversion.setIdentityEd25519(desc.getIdentityEd25519() != null);
    conversion.setMasterKeyEd25519(desc.getMasterKeyEd25519());
    conversion.setBandwidth(
      convertBandwidth(desc)
    );
    conversion.setPlatform(desc.getPlatform());
    conversion.setPublished(desc.getPublishedMillis());
    conversion.setFingerprint(desc.getFingerprint());
    if (desc.isHibernating()) {
      conversion.setHibernating(desc.isHibernating());
    }
    conversion.setUptime(desc.getUptime());
    conversion.setOnionKey(desc.getOnionKey() != null);
    conversion.setOnionKeyCrosscert(desc.getOnionKeyCrosscert() != null);
    conversion.setNtorOnionKey(desc.getNtorOnionKey() != null);
    conversion.setNtorOnionKeyCrosscert(
        desc.getNtorOnionKeyCrosscert() != null
    );
    conversion.setSigningKey(desc.getSigningKey() != null);
    if (desc.getExitPolicyLines() != null &&
        !desc.getExitPolicyLines().isEmpty()) {
      conversion.setExitPolicy(desc.getExitPolicyLines());
    }
    conversion.setIpv6Policy(desc.getIpv6DefaultPolicy());
    conversion.setIpv6Portlist(desc.getIpv6PortList());
    conversion.setContact(desc.getContact());
    conversion.setFamily(desc.getFamilyEntries());
    if (desc.getReadHistory() != null) {
      conversion.setReadHistory(
          convertReadHistory(desc.getReadHistory())
      );
    }
    if (desc.getWriteHistory() != null) {
      conversion.setWriteHistory(
          convertWriteHistory(desc.getWriteHistory())
      );
    }
    conversion.setEventdns(desc.getUsesEnhancedDnsLogic());
    conversion.setCachesExtraInfo(desc.getCachesExtraInfo());
    if (desc.getExtraInfoDigest() != null) {
      conversion.setExtraInfoDigest(desc.getExtraInfoDigest().toUpperCase());
    }
    conversion.setExtraInfoDigestSha256(desc.getExtraInfoDigestSha256());
    if (desc.getFamilyEntries() != null &&
        !desc.getFamilyEntries().isEmpty()) {
      conversion.setHiddenServiceDir(desc.getHiddenServiceDirVersions());
    }
    if (desc.getLinkProtocolVersions() != null &&
        !desc.getLinkProtocolVersions().isEmpty()) {
      conversion.setLinkProtocolVersions(desc.getLinkProtocolVersions());
    }
    if (desc.getCircuitProtocolVersions() != null &&
        !desc.getCircuitProtocolVersions().isEmpty()) {
      conversion.setCircuitProtocolVersions(desc.getCircuitProtocolVersions());
    }
    conversion.setAllowSingleHopExits(desc.getAllowSingleHopExits());
    if (desc.getOrAddresses() != null && !desc.getOrAddresses().isEmpty()) {
      conversion.setOrAddress(
          convertOrAdresses(desc.getOrAddresses())
      );
    }

    this.type = Types.BRIDGE;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }


  private Router convertRouter(BridgeServerDescriptor desc) {
    Router con = new Router();
    con.setNickname(desc.getNickname());
    con.setAddress(desc.getAddress());
    con.setOrPort(desc.getOrPort());
    con.setSocksPort(desc.getSocksPort());
    con.setDirPort(desc.getDirPort());
    return con;
  }


  private Bandwidth convertBandwidth(BridgeServerDescriptor desc) {
    Bandwidth con = new Bandwidth();
    con.setAvg(desc.getBandwidthRate());
    con.setBurst(desc.getBandwidthBurst());
    if (desc.getBandwidthObserved() >= 0) {
      con.setObserved(desc.getBandwidthObserved());
    }
    return con;
  }


  private ReadHistory convertReadHistory(BandwidthHistory hist) {
    ReadHistory con = new ReadHistory();
    con.setDate(hist.getHistoryEndMillis());
    con.setInterval(hist.getIntervalLength());
    con.setBytes(new ArrayList<Long>(hist.getBandwidthValues().values()));
    return con;
  }


  private WriteHistory convertWriteHistory(BandwidthHistory hist) {
    WriteHistory con = new WriteHistory();
    con.setDate(hist.getHistoryEndMillis());
    con.setInterval(hist.getIntervalLength());
    con.setBytes(new ArrayList<Long>(hist.getBandwidthValues().values()));
    return con;
  }


  private List<OrAddress> convertOrAdresses(List<String>  orAddresses) {
    List<OrAddress> conList = new ArrayList();
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

}
