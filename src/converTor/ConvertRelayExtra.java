package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayExtraInfoDescriptor;


public class ConvertRelayExtra extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  ConvertRelayExtra(Descriptor desc) {
    convert((RelayExtraInfoDescriptor) desc);
  }

  public void convert(RelayExtraInfoDescriptor desc) {

    converTor.encoders.classes.relayExtra.RelayExtra conversion =
        new converTor.encoders.classes.relayExtra.RelayExtra();

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


    this.type = Types.RELAY_EXTRA;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}