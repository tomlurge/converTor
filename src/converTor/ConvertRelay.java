package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayServerDescriptor;
import converTor.encoders.classes.relay.Relay;


class ConvertRelay extends Convert {

  void convert(Descriptor descriptor) {

    RelayServerDescriptor desc = (RelayServerDescriptor) descriptor;
    Relay conversion = new Relay();

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



    this.type = Types.RELAY;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}
