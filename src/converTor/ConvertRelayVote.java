package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayNetworkStatusVote;


public class ConvertRelayVote extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  ConvertRelayVote(Descriptor desc) {
    convert((RelayNetworkStatusVote) desc);
  }


  public void convert(RelayNetworkStatusVote desc) {

    converTor.encoders.classes.relayVote.RelayVote conversion =
        new converTor.encoders.classes.relayVote.RelayVote();

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