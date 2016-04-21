package converTor;

import converTor.encoders.classes.relayVote.FlagTresholds;
import converTor.encoders.classes.relayVote.Vote;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayNetworkStatusVote;
import converTor.encoders.classes.relayVote.RelayVote;

import java.util.ArrayList;


class ConvertRelayVote extends Convert {

  void convert(Descriptor descriptor) {

    RelayNetworkStatusVote desc = (RelayNetworkStatusVote) descriptor;
    RelayVote conversion = new RelayVote();

    conversion.setDescriptorType("network-status-vote-3 1.0");
    conversion.setNetworkStatusVersion(desc.getNetworkStatusVersion());
    conversion.setVoteStatus("vote");
    conversion.setConsensusMethods(desc.getConsensusMethods());
    conversion.setPublished(desc.getPublishedMillis());
    conversion.setValidAfter(desc.getValidAfterMillis());
    conversion.setFlagTresholds(convertFlagTresholds(desc));
    conversion.setFreshUntil(desc.getFreshUntilMillis());
    conversion.setValidUntil(desc.getValidUntilMillis());
    conversion.setVotingDelay(convertVote(desc));
    conversion.setClientVersions(desc.getRecommendedClientVersions());
    conversion.setServerVersions(desc.getRecommendedServerVersions());
    conversion.setKnownFlags(new ArrayList<>(desc.getKnownFlags()));
    conversion.setParams(desc.getConsensusParams());
//  conversion.set


    this.type = Types.RELAY_VOTE;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }


  private FlagTresholds convertFlagTresholds(RelayNetworkStatusVote desc) {
    FlagTresholds con = new FlagTresholds();
    con.setStableUptime(desc.getStableUptime());
    con.setStableMtbf(desc.getStableMtbf());
    con.setEnoughMtbf(desc.getEnoughMtbfInfo());
    con.setFastSpeed(desc.getFastBandwidth());
    con.setGuardWfu(desc.getGuardWfu());
    con.setGuardTk(desc.getGuardTk());
    con.setGuardBwIncExits(desc.getGuardBandwidthIncludingExits());
    con.setGuardBwExcExits(desc.getGuardBandwidthExcludingExits());
    con.setIgnoringAdvertisedBws(desc.getIgnoringAdvertisedBws());
    return con;
  }


  private Vote convertVote(RelayNetworkStatusVote desc) {
    Vote con = new Vote();
    con.setVoteSeconds(desc.getVoteSeconds());
    con.setDistSeconds(desc.getDistSeconds());
    return con;
  }



}