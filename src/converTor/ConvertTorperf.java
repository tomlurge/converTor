package converTor;

import converTor.torperf.Torperf;
import org.torproject.descriptor.TorperfResult;



/*
 *
 *  convert Torperf descriptors
 *
 *  provides 3 different types of conversion with Avro:
 *    SPECIFIC with CONSTRUCTOR
 *    SPECIFIC with BUILDER
 *    GENERIC
 *  see discussion in docs/avro.md for details
 *
 */


//  SPECIFIC with CONSTRUCTOR
class ConvertTorperf extends ConvertCommons { //  TODO  replace with interface

  static Converted convert(TorperfResult desc) {

    Torperf conversion = new Torperf();

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
    if (desc.getDataPercentiles() != null && !desc.getDataPercentiles().isEmpty()) {
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

    Converted converted = new Converted();
    converted.type = DescriptorType.torperfType;
    converted.date = dateTimeFormat.format(desc.getStartMillis()).substring(0,7);
    converted.load = conversion;
    return converted;
  }
}






//  SPECIFIC with BUILDER
/*
static class SpecificBuilderAvroTorperfDescriptor extends AvroDescriptor {
  static Torperf convert(TorperfResult desc) {

    //  tests needed below
    boolean percentiles = desc.getDataPercentiles() != null &&
                          !desc.getDataPercentiles().isEmpty();
    boolean path = desc.getPath() != null && !desc.getPath().isEmpty();

    Torperf torperf;
    torperf = Torperf.newBuilder()

            .setDescriptorType("torperf 1.0")
            .setSource(desc.getSource())
            .setFilesize(desc.getFileSize())
            .setStart(desc.getStartMillis())
            .setSocket(desc.getSocketMillis())
            .setConnect(desc.getConnectMillis())
            .setNegotiate(desc.getNegotiateMillis())
            .setRequest(desc.getRequestMillis())
            .setResponse(desc.getResponseMillis())
            .setDatarequest(desc.getDataRequestMillis())
            .setDataresponse(desc.getDataResponseMillis())
            .setDatacomplete(desc.getDataCompleteMillis())
            .setWritebytes(desc.getWriteBytes())
            .setReadbytes(desc.getReadBytes())
            .setDidtimeout(desc.didTimeout())
            .setDataperc10(percentiles ? desc.getDataPercentiles().get(10) : null)
            .setDataperc20(percentiles ? desc.getDataPercentiles().get(20) : null)
            .setDataperc30(percentiles ? desc.getDataPercentiles().get(30) : null)
            .setDataperc40(percentiles ? desc.getDataPercentiles().get(40) : null)
            .setDataperc50(percentiles ? desc.getDataPercentiles().get(50) : null)
            .setDataperc60(percentiles ? desc.getDataPercentiles().get(60) : null)
            .setDataperc70(percentiles ? desc.getDataPercentiles().get(70) : null)
            .setDataperc80(percentiles ? desc.getDataPercentiles().get(80) : null)
            .setDataperc90(percentiles ? desc.getDataPercentiles().get(90) : null)
            .setLaunch(desc.getLaunchMillis())
            .setUsedAt(desc.getUsedAtMillis())
            .setPath(path ? desc.getPath() : null)
            .setBuildtimes(desc.getBuildTimes())
            .setTimeout(desc.getTimeout())
            .setQuantile(desc.getQuantile())
            .setCircId(desc.getCircId())
            .setUsedBy(desc.getUsedBy())

            .build();

    return torperf;
  }
}
*/

//  GENERIC
/*
static class GenericAvroTorperfDescriptor extends AvroDescriptor {
  static GenericRecord convert(GenericRecord torperf, TorperfResult desc) {

    //      manually check types for consistency
    //        yes, manually! one might think "this is java", but still...
    //        BUT there is a validatingEncoder that checks types
    //            against the schema while encoding

    torperf.put("descriptor_type", "torperf 1.0");
    torperf.put("source", desc.getSource());
    torperf.put("filesize", desc.getFileSize());
    torperf.put("start", dateTimeFormat.format(desc.getStartMillis()));
    torperf.put("socket", dateTimeFormat.format(desc.getSocketMillis()));
    torperf.put("connect", dateTimeFormat.format(desc.getConnectMillis()));
    torperf.put("negotiate", dateTimeFormat.format(desc.getNegotiateMillis()));
    torperf.put("request", dateTimeFormat.format(desc.getRequestMillis()));
    torperf.put("response", dateTimeFormat.format(desc.getResponseMillis()));
    torperf.put("datarequest", dateTimeFormat.format(desc.getDataRequestMillis()));
    torperf.put("dataresponse", dateTimeFormat.format(desc.getDataResponseMillis()));
    torperf.put("datacomplete", dateTimeFormat.format(desc.getDataCompleteMillis()));
    torperf.put("writebytes", desc.getWriteBytes());
    torperf.put("readbytes", desc.getReadBytes());
    torperf.put("didtimeout", desc.didTimeout());
    if (desc.getDataPercentiles() != null && !desc.getDataPercentiles().isEmpty()) {
      torperf.put("dataperc10", desc.getDataPercentiles().get(10));
      torperf.put("dataperc20", desc.getDataPercentiles().get(20));
      torperf.put("dataperc30", desc.getDataPercentiles().get(30));
      torperf.put("dataperc40", desc.getDataPercentiles().get(40));
      torperf.put("dataperc50", desc.getDataPercentiles().get(50));
      torperf.put("dataperc60", desc.getDataPercentiles().get(60));
      torperf.put("dataperc70", desc.getDataPercentiles().get(70));
      torperf.put("dataperc80", desc.getDataPercentiles().get(80));
      torperf.put("dataperc90", desc.getDataPercentiles().get(90));
    }
    torperf.put("launch", desc.getLaunchMillis());
    torperf.put("used_at", desc.getUsedAtMillis());
    torperf.put("path", desc.getPath());
    torperf.put("buildtimes", desc.getBuildTimes());
    torperf.put("timeout", desc.getTimeout());
    torperf.put("quantile", desc.getQuantile());
    torperf.put("circ_id", desc.getCircId());
    torperf.put("used_by", desc.getUsedBy());

    return torperf;
  }
}
*/
