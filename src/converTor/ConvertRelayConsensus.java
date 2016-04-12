package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayNetworkStatusConsensus;


public class ConvertRelayConsensus extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  ConvertRelayConsensus(Descriptor desc) {
    convert((RelayNetworkStatusConsensus) desc);
  }

  public void convert(RelayNetworkStatusConsensus desc) {

    converTor.encoders.classes.relayConsensus.RelayConsensus conversion =
        new converTor.encoders.classes.relayConsensus.RelayConsensus();

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


    this.type = Types.RELAY_CONSENSUS;
    this.date = dateTimeFormat.format(desc.getValidAfterMillis()).substring(0,7);
    this.load = conversion;

  }
}