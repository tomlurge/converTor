package converTor.converter;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayExtraInfoDescriptor;


public class RelayExtra extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  RelayExtra(Descriptor desc) {
    convert((RelayExtraInfoDescriptor) desc);
  }

  public void convert(RelayExtraInfoDescriptor desc) {

    converTor.avro.classes.relayExtra.RelayExtra conversion =
        new converTor.avro.classes.relayExtra.RelayExtra();

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