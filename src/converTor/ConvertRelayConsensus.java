package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayNetworkStatusConsensus;
import converTor.encoders.classes.relayConsensus.RelayConsensus;


public class ConvertRelayConsensus extends Convert {

  ConvertRelayConsensus() {}
  ConvertRelayConsensus(Descriptor desc) {
    convert((RelayNetworkStatusConsensus) desc);
  }


  public void convert(RelayNetworkStatusConsensus desc) {

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


    this.type = Types.RELAY_CONSENSUS;
    this.date = dateTimeFormat.format(desc.getValidAfterMillis()).substring(0,7);
    this.load = conversion;

  }
}