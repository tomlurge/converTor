package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayNetworkStatusVote;
import converTor.encoders.classes.relayVote.RelayVote;


class ConvertRelayVote extends Convert {

  void convert(Descriptor descriptor) {

    RelayNetworkStatusVote desc = (RelayNetworkStatusVote) descriptor;
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


    this.type = Types.RELAY_VOTE;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}