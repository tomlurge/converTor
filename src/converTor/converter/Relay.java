package converTor.converter;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayServerDescriptor;


public class Relay extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  Relay(Descriptor desc) {
    convert((RelayServerDescriptor) desc);
  }

  public void convert(RelayServerDescriptor desc) {

    converTor.avro.classes.relay.Relay conversion =
        new converTor.avro.classes.relay.Relay();

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
