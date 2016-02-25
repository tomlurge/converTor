package converTor;

import converTor.relayVote.RelayVote;
import org.torproject.descriptor.RelayNetworkStatusVote;


public class ConvertRelayVote extends ConvertCommons {

  static Converted convert(RelayNetworkStatusVote desc) {

    RelayVote conversion = new RelayVote();

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
    converted.type = DescriptorType.relayVoteType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}