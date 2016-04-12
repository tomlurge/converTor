package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayServerDescriptor;


public class ConvertRelay extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  ConvertRelay(Descriptor desc) {
    convert((RelayServerDescriptor) desc);
  }

  public void convert(RelayServerDescriptor desc) {

    converTor.encoders.classes.relay.Relay conversion =
        new converTor.encoders.classes.relay.Relay();

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
