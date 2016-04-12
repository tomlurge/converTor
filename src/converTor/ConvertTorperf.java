package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.TorperfResult;


public class ConvertTorperf extends Convert {


  //  INHERITED FIELDS
  //    public Types type;
  //    public String date;
  //    public SpecificRecordBase load;


  //  CONSTRUCTOR
  ConvertTorperf(Descriptor desc) {
    convert((TorperfResult) desc);
  }


  //  CONVERT TORPERF DESCRIPTOR
  public void convert(TorperfResult desc) {

    converTor.encoders.classes.torperf.Torperf conversion =
        new converTor.encoders.classes.torperf.Torperf();

    conversion.setDescriptorType("torperf 1.0");
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
    if (desc.getDataPercentiles() != null &&
        !desc.getDataPercentiles().isEmpty()) {
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
    conversion.setLaunch(desc.getLaunchMillis());
    conversion.setUsedAt(desc.getUsedAtMillis());
    if (desc.getPath() != null && !desc.getPath().isEmpty()) {
      conversion.setPath(desc.getPath());
    }
    conversion.setBuildtimes(desc.getBuildTimes());
    conversion.setTimeout(desc.getTimeout());
    conversion.setQuantile(desc.getQuantile());
    conversion.setCircId(desc.getCircId());
    conversion.setUsedBy(desc.getUsedBy());

    this.type = Types.TORPERF;
    this.date = dateTimeFormat.format(desc.getStartMillis()).substring(0,7);
    this.load = conversion;

  }


}
