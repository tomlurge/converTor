package trans;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import trans.encoders.relayConsensus.DirFooter;
import trans.encoders.relayConsensus.DirSig;
import trans.encoders.relayConsensus.DirSource;
import trans.encoders.relayConsensus.OrAddress;
import trans.encoders.relayConsensus.Policy;
import trans.encoders.relayConsensus.R;
import trans.encoders.relayConsensus.Status;
import trans.encoders.relayConsensus.Vote;
import trans.encoders.relayConsensus.W;
import trans.encoders.relayVote.*;
import org.torproject.descriptor.*;
import trans.encoders.relayConsensus.*;


class ConvertRelayConsensus extends Convert {

  void convert(Descriptor descriptor, Long srcDate) {

    RelayNetworkStatusConsensus desc = (RelayNetworkStatusConsensus) descriptor;
    RelayConsensus conversion = new RelayConsensus();

    for (String annotation : desc.getAnnotations()) {
      conversion.setDescriptorType(annotation.substring("@type ".length()));
    }
    conversion.setSrcDate(srcDate);
    conversion.setNetworkStatusVersion(desc.getNetworkStatusVersion());
    conversion.setVoteStatus("consensus");
    conversion.setConsensusMethod(desc.getConsensusMethod());
    conversion.setConsensusFlavor(desc.getConsensusFlavor());
    conversion.setValidAfter(desc.getValidAfterMillis());
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
    if (desc.getConsensusParams() != null &&
        !desc.getConsensusParams().isEmpty()) {
      conversion.setParams(desc.getConsensusParams());
    }
    if (desc.getDirSourceEntries() != null &&
        !desc.getDirSourceEntries().isEmpty()) {
      conversion.setAuthorities(convertAuthorities(desc));
    }
    if (desc.getStatusEntries() != null &&
        !desc.getStatusEntries().isEmpty()) {
      conversion.setStatus(convertStatus(desc));
    }
    conversion.setDirectoryFooter(convertDirFooter(desc));

    this.type = Types.RELAY_CONSENSUS;
    this.date = dateTimeFormat.format(desc.getValidAfterMillis()).substring(0,7);
    this.load = conversion;

  }


  private Vote convertVote(RelayNetworkStatusConsensus desc) {
    Vote con = new Vote();
    con.setVoteSeconds(desc.getVoteSeconds());
    con.setDistSeconds(desc.getDistSeconds());
    return con;
  }


  private Map<String,Authority> convertAuthorities(RelayNetworkStatusConsensus desc) {
    Map<String,Authority> conMap = new HashMap<>();
    for (
        Map.Entry<String,DirSourceEntry> entry :
        desc.getDirSourceEntries().entrySet()
        ) {
      Authority con = new Authority();
      con.setDirSource(convertDirSource(entry.getValue()));
      con.setContact(entry.getValue().getContactLine());
      con.setVoteDigest(entry.getValue().getVoteDigest());
      conMap.put(entry.getKey(),con);
    }
    return conMap;
  }


  private DirSource convertDirSource(DirSourceEntry entry) {
    DirSource con = new DirSource();
    con.setNickname(entry.getNickname());
    con.setIdentity(entry.getIdentity());
    con.setHostname(entry.getHostname());
    con.setAddress(entry.getIp());
    con.setDirPort(entry.getDirPort());
    con.setOrPort(entry.getOrPort());
    con.setIsLegacy(entry.isLegacy());
    return con;
  }


  private Map<String,Status> convertStatus(RelayNetworkStatusConsensus desc) {
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
      acceptedPortIntervals(entry.getDefaultPolicy(), entry.getPortList())
    );
    return con;
  }


  private DirFooter convertDirFooter(RelayNetworkStatusConsensus desc) {
    DirFooter con = new DirFooter();
    con.setBandwidthWeights(desc.getBandwidthWeights());
    con.setConsensusDigest(desc.getConsensusDigest());
    if (desc.getSignatures() != null && !desc.getSignatures().isEmpty()) {
      con.setDirectorySignature(convertDirSig(desc));
    }
    return con;
  }


  private List<DirSig> convertDirSig(RelayNetworkStatusConsensus desc) {
    List<DirSig> conList = new ArrayList<>();
    for ( DirectorySignature dirSig : desc.getSignatures()) {
      DirSig con = new DirSig();
      con.setAlgorithm(dirSig.getAlgorithm());
      con.setIdentity(dirSig.getIdentity());
      con.setSigningKeyDigest(dirSig.getSigningKeyDigest());
      con.setSignature(dirSig.getSignature() != null);
      conList.add(con);
    }
    return conList;
  }

}