package converTor.convert;

import converTor.util.ConvertResult;
import converTor.Type;
import org.torproject.descriptor.RelayNetworkStatusVote;


public class RelayVote extends ConvertCommons {

  public static ConvertResult convert(RelayNetworkStatusVote desc) {

    converTor.avro.classes.relayVote.RelayVote conversion =
        new converTor.avro.classes.relayVote.RelayVote();

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
    converted.type = Type.relayVoteType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}