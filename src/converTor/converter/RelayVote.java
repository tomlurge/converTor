package converTor.converter;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayNetworkStatusVote;


public class RelayVote extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  RelayVote(Descriptor desc) {
    convert((RelayNetworkStatusVote) desc);
  }


  public void convert(RelayNetworkStatusVote desc) {

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


    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}