package converTor.convert;

import converTor.util.ConvertResult;
import converTor.util.ConvertType;
import org.torproject.descriptor.RelayNetworkStatusConsensus;


public class RelayConsensus extends ConvertCommons {

  public static ConvertResult convert(RelayNetworkStatusConsensus desc) {

    converTor.avro.classes.relayConsensus.RelayConsensus conversion =
        new converTor.avro.classes.relayConsensus.RelayConsensus();

//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set
//  conversion.set


    ConvertResult converted = new ConvertResult();
    converted.type = ConvertType.relayConsensusType;
    converted.date = dateTimeFormat.format(desc.getValidAfterMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}