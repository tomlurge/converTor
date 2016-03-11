package converTor.converter;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayNetworkStatusConsensus;


public class RelayConsensus extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  RelayConsensus(Descriptor desc) {
    convert((RelayNetworkStatusConsensus) desc);
  }

  public void convert(RelayNetworkStatusConsensus desc) {

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


    this.date = dateTimeFormat.format(desc.getValidAfterMillis()).substring(0,7);
    this.load = conversion;

  }
}