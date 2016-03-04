package converTor.convert;

import converTor.avro.classes.relayVote.RelayVote;
import converTor.util.Convert;
import converTor.util.Converted;
import converTor.util.DescriptorType;
import org.torproject.descriptor.RelayNetworkStatusVote;


public class ConvertRelayVote extends Convert {

  public static Converted convert(RelayNetworkStatusVote desc) {

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