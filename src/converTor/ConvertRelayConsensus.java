package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayNetworkStatusConsensus;
import converTor.encoders.classes.relayConsensus.RelayConsensus;


class ConvertRelayConsensus extends Convert {

  void convert(Descriptor descriptor) {

    RelayNetworkStatusConsensus desc = (RelayNetworkStatusConsensus) descriptor;
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