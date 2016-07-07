package renamingIssue;

import java.util.ArrayList;
import org.torproject.descriptor.BandwidthHistory;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeExtraInfoDescriptor;
import renamingIssue.encoders.bridgeExtra.*;


class ConvertBridgeExtra extends Convert {

  void convert(Descriptor descriptor) {

    BridgeExtraInfoDescriptor desc = (BridgeExtraInfoDescriptor) descriptor;
    BridgeExtra conversion = new BridgeExtra();

    for (String annotation : desc.getAnnotations()) {
      conversion.setDescriptorType(annotation.substring("@type ".length()));
    }
    conversion.setExtraInfo(convertExtraInfo(desc));
    conversion.setIdentityEd25519(desc.getIdentityEd25519() != null);
    conversion.setPublished(desc.getPublishedMillis());
    if (desc.getReadHistory() != null) {
      conversion.setReadHistory(convertReadHistory(desc.getReadHistory()));
    }
    if (desc.getWriteHistory() != null) {
      conversion.setWriteHistory(convertWriteHistory(desc.getWriteHistory()));
    }
    conversion.setGeoipDbDigest(desc.getGeoipDbDigest());
    conversion.setGeoip6DbDigest(desc.getGeoip6DbDigest());
    if (desc.getGeoipStartTimeMillis() >= 0) {
      conversion.setGeoipStartTime(desc.getGeoipStartTimeMillis());
    }
    /* start bridge only */
    if (desc.getGeoipClientOrigins() != null && 
        !desc.getGeoipClientOrigins().isEmpty()) {
      conversion.setGeoipClientOrigins(desc.getGeoipClientOrigins());
    }
    conversion.setBridgeStatsEnd(convertBridgeStats(desc));
    if (desc.getBridgeIps() != null && !desc.getBridgeIps().isEmpty()) {
      conversion.setBridgeIps(desc.getBridgeIps());
    }
    if (desc.getBridgeIpVersions() != null && 
        !desc.getBridgeIpVersions().isEmpty()) {
      conversion.setBridgeIpVersions(desc.getBridgeIpVersions());
    }
    if (desc.getBridgeIpTransports() != null && 
        !desc.getBridgeIpTransports().isEmpty()) {
      conversion.setBridgeIpTransports(desc.getBridgeIpTransports());
    }
    /* end bridge only */
    conversion.setDirreqStatsEnd(convertDirreqStats(desc));
    if (desc.getDirreqV2Ips() != null && !desc.getDirreqV2Ips().isEmpty()) {
      conversion.setDirreqV2Ips(desc.getDirreqV2Ips());
    }
    if (desc.getDirreqV3Ips() != null && !desc.getDirreqV3Ips().isEmpty()) {
      conversion.setDirreqV3Ips(desc.getDirreqV3Ips());
    }
    if (desc.getDirreqV2Reqs() != null && !desc.getDirreqV2Reqs().isEmpty()) {
      conversion.setDirreqV2Reqs(desc.getDirreqV2Reqs());
    }
    if (desc.getDirreqV3Reqs() != null && !desc.getDirreqV3Reqs().isEmpty()) {
      conversion.setDirreqV3Reqs(desc.getDirreqV3Reqs());
    }
    if (desc.getDirreqV2Share() >= 0) {
      conversion.setDirreqV2Share(desc.getDirreqV2Share());
    }
    if (desc.getDirreqV3Share() >= 0) {
      conversion.setDirreqV3Share(desc.getDirreqV3Share());
    }
    if (desc.getDirreqV2Resp() != null && !desc.getDirreqV2Resp().isEmpty()) {
      conversion.setDirreqV2Resp(desc.getDirreqV2Resp());
    }
    if (desc.getDirreqV3Resp() != null && !desc.getDirreqV3Resp().isEmpty()) {
      conversion.setDirreqV3Resp(desc.getDirreqV3Resp());
    }
    if (desc.getDirreqV2DirectDl() != null && !desc.getDirreqV2DirectDl().isEmpty()) {
      conversion.setDirreqV2DirectDl(desc.getDirreqV2DirectDl());
    }
    if (desc.getDirreqV3DirectDl() != null && !desc.getDirreqV3DirectDl().isEmpty()) {
      conversion.setDirreqV3DirectDl(desc.getDirreqV3DirectDl());
    }
    if (desc.getDirreqV2TunneledDl() != null && !desc.getDirreqV2TunneledDl().isEmpty()) {
      conversion.setDirreqV2TunneledDl(desc.getDirreqV2TunneledDl());
    }
    if (desc.getDirreqV3TunneledDl() != null && !desc.getDirreqV3TunneledDl().isEmpty()) {
      conversion.setDirreqV3TunneledDl(desc.getDirreqV3TunneledDl());
    }
    if (desc.getDirreqReadHistory() != null) {
      conversion.setDirreqReadHistory(
          convertDirreqReadHistory(desc.getDirreqReadHistory())
      );
    }
    if (desc.getDirreqWriteHistory() != null) {
      conversion.setDirreqWriteHistory(
          convertDirreqWriteHistory(desc.getDirreqWriteHistory())
      );
    }
    conversion.setEntryStatsEnd(convertEntryStats(desc));
    if (desc.getEntryIps() != null && !desc.getEntryIps().isEmpty()) {
      conversion.setEntryIps(desc.getEntryIps());
    }
    conversion.setCellStatsEnd(convertCellStats(desc));
    if (desc.getCellProcessedCells() != null && !desc.getCellProcessedCells().isEmpty()) {
      conversion.setCellProcessedCells(desc.getCellProcessedCells());
    }
    if (desc.getCellQueuedCells() != null && !desc.getCellQueuedCells().isEmpty()) {
      conversion.setCellQueuedCells(desc.getCellQueuedCells());
    }
    if (desc.getCellTimeInQueue() != null && !desc.getCellTimeInQueue().isEmpty()) {
      conversion.setCellTimeInQueue(desc.getCellTimeInQueue());
    }
    if (desc.getCellCircuitsPerDecile() >= 0) {
      conversion.setCellCircuitsPerDecile(desc.getCellCircuitsPerDecile());
    }
    conversion.setConnBiDirect(convertConnBiDirect(desc));
    conversion.setExitStatsEnd(convertExitStats(desc));
    if (desc.getExitKibibytesWritten() != null && !desc.getExitKibibytesWritten().isEmpty()) {
      conversion.setExitKibibytesWritten(desc.getExitKibibytesWritten());
    }
    if (desc.getExitKibibytesRead() != null && !desc.getExitKibibytesRead().isEmpty()) {
      conversion.setExitKibibytesRead(desc.getExitKibibytesRead());
    }
    if (desc.getExitStreamsOpened() != null && !desc.getExitStreamsOpened().isEmpty()) {
      conversion.setExitStreamsOpened(desc.getExitStreamsOpened());
    }
    conversion.setHidservStatsEnd(convertHidservStats(desc));
    conversion.setHidservRendRelayedCells(convertHidservRendRelayedCells(desc));
    conversion.setHidservDirOnionsSeen(convertHidservDirOnionsSeen(desc));
    conversion.setTransport(desc.getTransports());
    conversion.setExtraInfoDigest(desc.getExtraInfoDigest());
    conversion.setExtraInfoDigestSha256(desc.getExtraInfoDigestSha256());
    conversion.setMasterKeyEd25519(desc.getMasterKeyEd25519());

    this.type = Types.BRIDGE_EXTRA;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }


  private ExtraInfo convertExtraInfo(BridgeExtraInfoDescriptor desc) {
    ExtraInfo con = new ExtraInfo();
    con.setNickname(desc.getNickname());
    con.setFingerprint(desc.getFingerprint());
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


  private DirreqReadHistory convertDirreqReadHistory(BandwidthHistory hist) {
    DirreqReadHistory con = new DirreqReadHistory();
    con.setDate(hist.getHistoryEndMillis());
    con.setBytes(new ArrayList<Long>(hist.getBandwidthValues().values()));
    return con;
  }


  private DirreqWriteHistory convertDirreqWriteHistory(BandwidthHistory hist) {
    DirreqWriteHistory con = new DirreqWriteHistory();
    con.setDate(hist.getHistoryEndMillis());
    con.setInterval(hist.getIntervalLength());
    con.setBytes(new ArrayList<Long>(hist.getBandwidthValues().values()));
    return con;
  }


  private BridgeStats convertBridgeStats(BridgeExtraInfoDescriptor desc) {
    BridgeStats con = new BridgeStats();
    if (desc.getBridgeStatsEndMillis() >= 0) {
      con.setDate(desc.getBridgeStatsEndMillis());
    }
    if (desc.getBridgeStatsIntervalLength() >= 0) {
      con.setInterval(desc.getBridgeStatsIntervalLength());
    }
    return con;
  }


  private DirreqStats convertDirreqStats(BridgeExtraInfoDescriptor desc) {
    DirreqStats con = new DirreqStats();
    if (desc.getDirreqStatsEndMillis() >= 0) {
      con.setDate(desc.getDirreqStatsEndMillis());
    }
    if (desc.getDirreqStatsIntervalLength() >= 0) {
      con.setInterval(desc.getDirreqStatsIntervalLength());
    }
    return con;
  }


  private EntryStats convertEntryStats(BridgeExtraInfoDescriptor desc) {
    EntryStats con = new EntryStats();
    if (desc.getEntryStatsEndMillis() >= 0) {
      con.setDate(desc.getEntryStatsEndMillis());
    }
    if (desc.getEntryStatsIntervalLength() >= 0) {
      con.setInterval(desc.getEntryStatsIntervalLength());
    }
    return con;
  }


  private CellStats convertCellStats(BridgeExtraInfoDescriptor desc) {
    CellStats con = new CellStats();
    if (desc.getCellStatsEndMillis() >= 0) {
      con.setDate(desc.getCellStatsEndMillis());
    }
    if (desc.getCellStatsIntervalLength() >= 0) {
      con.setInterval(desc.getCellStatsIntervalLength());
    }
    return con;
  }


  private ConnBiDirect convertConnBiDirect(BridgeExtraInfoDescriptor desc) {
    ConnBiDirect con = new ConnBiDirect();
    if (desc.getConnBiDirectStatsEndMillis() >= 0) {
      con.setDate(desc.getConnBiDirectStatsEndMillis());
    }
    if (desc.getConnBiDirectStatsIntervalLength() >= 0) {
      con.setInterval(desc.getConnBiDirectStatsIntervalLength());
    }
    if (desc.getConnBiDirectBelow() >= 0) {
      con.setBelow(desc.getConnBiDirectBelow());
    }
    if (desc.getConnBiDirectRead() >= 0) {
      con.setRead(desc.getConnBiDirectRead());
    }
    if (desc.getConnBiDirectWrite() >= 0) {
      con.setWrite(desc.getConnBiDirectWrite());
    }
    if (desc.getConnBiDirectBoth() >= 0) {
      con.setBoth(desc.getConnBiDirectBoth());
    }
    return con;
  }


  private ExitStats convertExitStats(BridgeExtraInfoDescriptor desc) {
    ExitStats con = new ExitStats();
    if (desc.getExitStatsEndMillis() >= 0) {
      con.setDate(desc.getExitStatsEndMillis());
    }
    if (desc.getExitStatsIntervalLength() >= 0) {
      con.setInterval(desc.getExitStatsIntervalLength());
    }
    return con;
  }


  private HidservStats convertHidservStats(BridgeExtraInfoDescriptor desc) {
    HidservStats con = new HidservStats();
    if (desc.getHidservStatsEndMillis() >= 0) {
      con.setDate(desc.getHidservStatsEndMillis());
    }
    if (desc.getHidservStatsIntervalLength() >= 0) {
      con.setInterval(desc.getHidservStatsIntervalLength());
    }
    return con;
  }


  private HidservRendRelayedCells convertHidservRendRelayedCells(
      BridgeExtraInfoDescriptor desc
  ) {
    HidservRendRelayedCells con = new HidservRendRelayedCells();
    if (desc.getHidservRendRelayedCells() != null) {
      con.setCells(desc.getHidservRendRelayedCells());
    }
    if (desc.getHidservRendRelayedCellsParameters() != null &&
        !desc.getHidservRendRelayedCellsParameters().isEmpty()) {
      con.setObfuscation(desc.getHidservRendRelayedCellsParameters());
    }
    return con;
  }


  private HidservDirOnionsSeen convertHidservDirOnionsSeen(
      BridgeExtraInfoDescriptor desc
  ) {
    HidservDirOnionsSeen con = new HidservDirOnionsSeen();
    if (desc.getHidservDirOnionsSeen() != null) {
      con.setOnions(desc.getHidservDirOnionsSeen());
    }
    if (desc.getHidservRendRelayedCellsParameters() != null &&
        !desc.getHidservRendRelayedCellsParameters().isEmpty()) {
      con.setObfuscation(desc.getHidservDirOnionsSeenParameters());
    }
    return con;
  }

}