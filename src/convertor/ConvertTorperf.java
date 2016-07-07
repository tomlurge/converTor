package convertor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.TorperfResult;
import convertor.encoders.torperf.Torperf;


class ConvertTorperf extends Convert {

  void convert(Descriptor descriptor) {

    TorperfResult desc = (TorperfResult) descriptor;
    Torperf conversion = new Torperf();

    for (String annotation : desc.getAnnotations()) {
      conversion.setDescriptorType(annotation.substring("@type ".length()));
    }
    conversion.setSource(desc.getSource());
    conversion.setFilesize(desc.getFileSize());
    conversion.setStart(desc.getStartMillis());
    conversion.setSocket(desc.getSocketMillis());
    conversion.setConnect(desc.getConnectMillis());
    conversion.setNegotiate(desc.getNegotiateMillis());
    conversion.setRequest(desc.getRequestMillis());
    conversion.setResponse(desc.getResponseMillis());
    conversion.setDatarequest(desc.getDataRequestMillis());
    conversion.setDataresponse(desc.getDataResponseMillis());
    conversion.setDatacomplete(desc.getDataCompleteMillis());
    conversion.setWritebytes(desc.getWriteBytes());
    conversion.setReadbytes(desc.getReadBytes());
    conversion.setDidtimeout(desc.didTimeout());
    if (desc.getDataPercentiles() != null
        && !desc.getDataPercentiles().isEmpty()) {
      conversion.setDataperc10(desc.getDataPercentiles().get(10));
      conversion.setDataperc20(desc.getDataPercentiles().get(20));
      conversion.setDataperc30(desc.getDataPercentiles().get(30));
      conversion.setDataperc40(desc.getDataPercentiles().get(40));
      conversion.setDataperc50(desc.getDataPercentiles().get(50));
      conversion.setDataperc60(desc.getDataPercentiles().get(60));
      conversion.setDataperc70(desc.getDataPercentiles().get(70));
      conversion.setDataperc80(desc.getDataPercentiles().get(80));
      conversion.setDataperc90(desc.getDataPercentiles().get(90));
    }
    if (desc.getLaunchMillis() >= 0) {
      conversion.setLaunch(desc.getLaunchMillis());
    }
    if (desc.getUsedAtMillis() >= 0) {
      conversion.setUsedAt(desc.getUsedAtMillis());
    }
    if (desc.getPath() != null && !desc.getPath().isEmpty()) {
      conversion.setPath(desc.getPath());
    }
    conversion.setBuildtimes(desc.getBuildTimes());
    if (desc.getTimeout() >= 0) {
      conversion.setTimeout(desc.getTimeout());
    }
    if (desc.getQuantile() >= 0) {
      conversion.setQuantile(desc.getQuantile());
    }
    if (desc.getCircId() >= 0) {
      conversion.setCircId(desc.getCircId());
    }
    if (desc.getUsedBy() >= 0) {
      conversion.setUsedBy(desc.getUsedBy());
    }

    this.type = Types.TORPERF;
    this.date = dateTimeFormat.format(desc.getStartMillis()).substring(0, 7);
    this.load = conversion;

    if (desc.getUnrecognizedKeys() != null) {
      if (Args.INSTANCE.isLog()) {
        Base.logger.info("Unrecognized keys: " + desc.getUnrecognizedKeys());
      } else {
        System.out.println("Unrecognized keys: " + desc.getUnrecognizedKeys());
      }
    }
  }

}
