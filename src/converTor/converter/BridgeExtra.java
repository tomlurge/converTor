package converTor.converter;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeExtraInfoDescriptor;


public class BridgeExtra extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  BridgeExtra(Descriptor desc) {
    convert((BridgeExtraInfoDescriptor) desc);
  }

  public void convert(BridgeExtraInfoDescriptor desc) {

    converTor.avro.classes.bridgeExtra.BridgeExtra conversion =
        new converTor.avro.classes.bridgeExtra.BridgeExtra();

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