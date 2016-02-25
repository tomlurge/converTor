package converTor;


import converTor.relayConsensus.RelayConsensus;
import org.torproject.descriptor.RelayNetworkStatusConsensus;

public class ConvertRelayConsensus extends ConvertCommons {

  static Converted convert(RelayNetworkStatusConsensus desc) {

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
    converted.type = DescriptorType.relayConsensusType;
    converted.date = dateTimeFormat.format(desc.getValidAfterMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}