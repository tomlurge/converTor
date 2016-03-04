package converTor.convert;

import converTor.avro.classes.relayConsensus.RelayConsensus;
import converTor.util.Convert;
import converTor.util.Converted;
import converTor.util.ConvertType;
import org.torproject.descriptor.RelayNetworkStatusConsensus;


public class ConvertRelayConsensus extends Convert {

  public static Converted convert(RelayNetworkStatusConsensus desc) {

    RelayConsensus conversion = new RelayConsensus();

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


    Converted converted = new Converted();
    converted.type = ConvertType.relayConsensusType;
    converted.date = dateTimeFormat.format(desc.getValidAfterMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}