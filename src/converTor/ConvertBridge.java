package converTor;

import java.util.List;
import java.util.ArrayList;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeServerDescriptor;
import org.torproject.descriptor.BandwidthHistory;
import converTor.encoders.classes.bridge.Bridge;
import converTor.encoders.classes.bridge.Router;
import converTor.encoders.classes.bridge.Bandwidth;
import converTor.encoders.classes.bridge.OrAddress;
import converTor.encoders.classes.bridge.ReadHistory;
import converTor.encoders.classes.bridge.WriteHistory;


class ConvertBridge extends Convert {

  void convert(Descriptor descriptor) {

    BridgeServerDescriptor desc = (BridgeServerDescriptor) descriptor;
    Bridge conversion = new Bridge();

    conversion.setDescriptorType("server-descriptor 1.0");
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
    //  isHibernating can't return 'null' because it's of type 'boolean'
    //  (with little 'b') but it's only present in the collecTor data if it's
    //  true. therefor we check for it's existence and include it if it
    //  exists. otherwise we leave it alone / to the default value from
    //  the class definition above (which is null)
    if (desc.isHibernating()) {
      conversion.setHibernating(desc.isHibernating());
    }
    conversion.setUptime(desc.getUptime());
    //  test, if there is a key: return 'true' if yes, 'false' otherwise
    conversion.setOnionKey(desc.getOnionKey() != null);
    conversion.setOnionKeyCrosscert(desc.getOnionKeyCrosscert() != null);
    conversion.setNtorOnionKey(desc.getNtorOnionKey() != null);
    conversion.setNtorOnionKeyCrosscert(
        desc.getNtorOnionKeyCrosscert() != null
    );
    conversion.setSigningKey(desc.getSigningKey() != null);
    //  verbose testing because of List type
    //  first check that the list is not null, then if it's empty
    //  (checking for emptiness right away could lead to null pointer exc)
    if (desc.getExitPolicyLines() != null &&
        !desc.getExitPolicyLines().isEmpty()) {
      conversion.setExitPolicy(desc.getExitPolicyLines());
    }
    conversion.setIpv6Policy(desc.getIpv6DefaultPolicy());
    conversion.setIpv6Portlist(desc.getIpv6PortList());
    conversion.setContact(desc.getContact());
    conversion.setFamily(desc.getFamilyEntries());
    //  check for 'null' first because we want to run a method on it
    //  and not get a null pointer exception meanwhile
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
    Router conversionRouter = new Router();
    conversionRouter.setNickname(desc.getNickname());
    conversionRouter.setAddress(desc.getAddress());
    conversionRouter.setOrPort(desc.getOrPort());
    conversionRouter.setSocksPort(desc.getSocksPort());
    conversionRouter.setDirPort(desc.getDirPort());
    return conversionRouter;
  }


  private Bandwidth convertBandwidth(BridgeServerDescriptor desc) {
    Bandwidth conversionBandwidth = new Bandwidth();
    conversionBandwidth.setAvg(desc.getBandwidthRate());
    conversionBandwidth.setBurst(desc.getBandwidthBurst());
    //  can be '-1' if null. in that case we don't touch it here, leaving the
    //  default from the class definition intact
    if (desc.getBandwidthObserved() >= 0) {
      conversionBandwidth.setObserved(desc.getBandwidthObserved());
    }
    return conversionBandwidth;
  }


  private ReadHistory convertReadHistory(BandwidthHistory hist) {
    ReadHistory conversionReadHistory = new ReadHistory();
    conversionReadHistory.setDate(hist.getHistoryEndMillis());
    conversionReadHistory.setInterval(hist.getIntervalLength());
    conversionReadHistory.setBytes(
        (ArrayList<Long>) hist.getBandwidthValues().values()
    );
    return conversionReadHistory;
  }


  private WriteHistory convertWriteHistory(BandwidthHistory hist) {
    WriteHistory conversionWriteHistory = new WriteHistory();
    conversionWriteHistory.setDate(hist.getHistoryEndMillis());
    conversionWriteHistory.setInterval(hist.getIntervalLength());
    conversionWriteHistory.setBytes(
        (ArrayList<Long>) hist.getBandwidthValues().values()
    );
    return conversionWriteHistory;
  }


  private List<OrAddress> convertOrAdresses(List<String>  orAddresses) {
    List<OrAddress> conversionOrAddresses = new ArrayList();
    for (String orAddress : orAddresses) {
      if (!orAddress.contains(":")) {
        continue;
      }
      OrAddress ora = new OrAddress();
      int lastColon = orAddress.lastIndexOf(":");
      try {
        ora.setAddress(orAddress.substring(0, lastColon));
        ora.setPort(Integer.parseInt(orAddress.substring(lastColon + 1)));
        conversionOrAddresses.add(ora);
      } catch (NumberFormatException e) {
        continue;
      }
    }
    return conversionOrAddresses;
  }

}
