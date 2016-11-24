package convertor;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.DirectorySignature;
import org.torproject.descriptor.NetworkStatusEntry;
import org.torproject.descriptor.RelayNetworkStatusVote;
import convertor.encoders.relayVote.*;


class ConvertRelayVote extends Convert {

  void convert(Descriptor descriptor, Long srcDate) {

    RelayNetworkStatusVote desc = (RelayNetworkStatusVote) descriptor;
    RelayVote conversion = new RelayVote();

    for (String annotation : desc.getAnnotations()) {
      conversion.setDescriptorType(annotation.substring("@type ".length()));
    }
    conversion.setSrcDate(srcDate);
    conversion.setNetworkStatusVersion(desc.getNetworkStatusVersion());
    conversion.setVoteStatus("vote");
    if (desc.getConsensusMethods() != null && !desc.getConsensusMethods().isEmpty()) {
      conversion.setConsensusMethods(desc.getConsensusMethods());
    }
    conversion.setPublished(desc.getPublishedMillis());
    conversion.setValidAfter(desc.getValidAfterMillis());
    conversion.setFlagTresholds(convertFlagTresholds(desc));
    conversion.setFreshUntil(desc.getFreshUntilMillis());
    conversion.setValidUntil(desc.getValidUntilMillis());
    conversion.setVotingDelay(convertVote(desc));
    if (desc.getRecommendedClientVersions() != null &&
        !desc.getRecommendedClientVersions().isEmpty()) {
      conversion.setClientVersions(desc.getRecommendedClientVersions());
    }
    if (desc.getRecommendedServerVersions() != null &&
        !desc.getRecommendedServerVersions().isEmpty()) {
      conversion.setServerVersions(desc.getRecommendedServerVersions());
    }
    if (desc.getPackageLines() != null &&
        !desc.getPackageLines().isEmpty()) {
      conversion.setPackage$(desc.getPackageLines());
    }
    if (desc.getKnownFlags() != null && !desc.getKnownFlags().isEmpty()) {
      conversion.setKnownFlags(new ArrayList<>(desc.getKnownFlags()));
    }
    if (desc.getConsensusParams() != null && !desc.getConsensusParams().isEmpty()) {
      conversion.setParams(desc.getConsensusParams());
    }
    conversion.setDirSource(convertDirSource(desc));
    conversion.setContact(desc.getContactLine());
    conversion.setLegacyDirKey(desc.getLegacyDirKey());
    conversion.setDirectoryKey(convertDirKey(desc));
    if (desc.getStatusEntries() != null && !desc.getStatusEntries().isEmpty()) {
      conversion.setStatus(convertStatus(desc));
    }
    if (desc.getDirectorySignatures() != null && !desc.getDirectorySignatures().isEmpty()) {
      conversion.setDirectoryFooter(convertDirFooter(desc));
    }
    conversion.setSigningKeyDigest(desc.getSigningKeyDigest());

    this.type = Types.RELAY_VOTE;
    this.date = dateTimeFormat.format(desc.getValidAfterMillis()).substring(0,7);
    this.load = conversion;

  }


  private FlagTresholds convertFlagTresholds(RelayNetworkStatusVote desc) {
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


  private Vote convertVote(RelayNetworkStatusVote desc) {
    Vote con = new Vote();
    con.setVoteSeconds(desc.getVoteSeconds());
    con.setDistSeconds(desc.getDistSeconds());
    return con;
  }


  private DirSource convertDirSource(RelayNetworkStatusVote desc) {
    DirSource con = new DirSource();
    con.setNickname(desc.getNickname());
    con.setHostname(desc.getHostname());
    con.setIdentity(desc.getIdentity());
    con.setAddress(desc.getAddress());
    con.setDirPort(desc.getDirport());
    con.setOrPort(desc.getOrport());
    return con;
  }


  private DirKey convertDirKey(RelayNetworkStatusVote desc) {
    DirKey con = new DirKey();
    con.setVersion(desc.getDirKeyCertificateVersion());
    con.setDirKeyPublished(desc.getDirKeyPublishedMillis());
    con.setDirKeyExpires(desc.getDirKeyExpiresMillis());
    return con;
  }


  private Map<String,Status> convertStatus(RelayNetworkStatusVote desc) {
    Map<String,Status> conMap = new HashMap<>();
    for (
        Map.Entry<String, NetworkStatusEntry> entry :
        desc.getStatusEntries().entrySet()
        ) {
      Status con = new Status();
      con.setR(convertR(entry.getValue()));
      if (entry.getValue().getOrAddresses() != null &&
          !entry.getValue().getOrAddresses().isEmpty()) {
        con.setA(convertOrAdresses(entry.getValue().getOrAddresses()));
      }
      if (entry.getValue().getFlags() != null && !entry.getValue().getFlags().isEmpty()) {
        con.setS(new ArrayList<>(entry.getValue().getFlags()));
      }
      con.setV(entry.getValue().getVersion());
      con.setW(convertW(entry.getValue()));
      if (entry.getValue().getDefaultPolicy() != null
          && entry.getValue().getPortList() != null) {
        con.setP(convertPolicy(entry.getValue()));
      }
      con.setId(convertId(entry.getValue()));
      conMap.put(entry.getKey(),con);
    }
    return conMap;
  }


  private R convertR(NetworkStatusEntry entry) {
    R con = new R();
    con.setNickname(entry.getNickname());
    con.setIdentity(entry.getFingerprint());
    con.setDigest(entry.getDescriptor());
    con.setPublication(entry.getPublishedMillis());
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


  private ID convertId(NetworkStatusEntry entry) {
    ID con = new ID();
    con.setEd25519(entry.getMasterKeyEd25519() != null);
    return con;
  }


  private DirFooter convertDirFooter(RelayNetworkStatusVote desc) {
    DirFooter con = new DirFooter();
    con.setDirectorySignature(convertDirSig(desc));
    return con;
  }


  private DirSig convertDirSig(RelayNetworkStatusVote desc) {
    DirSig con = new DirSig();
    /*  The spec says that a vote can contain at most 1 Directory Signature
     *  but metrics.lib RelayNetworkStatusVote's getDirectorySignatures()
     *  returns a map. See:
     *  https://trac.torproject.org/projects/tor/ticket/18875
     *  As a workaround we always use the first entry but check the length of
     *  the map and print a warning to the console if there are more than one.
     */
    for (
        Map.Entry<String, DirectorySignature> entry :
        desc.getDirectorySignatures().entrySet()
        ) {
      con.setAlgorithm(entry.getValue().getAlgorithm());
      con.setIdentity(entry.getValue().getIdentity());
      con.setSigningKeyDigest(entry.getValue().getSigningKeyDigest());
      con.setSignature(entry.getValue().getSignature() != null);
      //  TODO    update to new metrics-lib method getDirectorySignature()
      if (desc.getDirectorySignatures().size() > 1) {
        System.out.println(
          "RelayVote descriptor contains more than 1 Directory Signature:\n    "
          + desc.getValidAfterMillis() + "\n    " + desc.getIdentity() +
          "\nOmitting all Directory Signatures but the first one."
        );
      }
      break;
    }
    return con;
  }

}