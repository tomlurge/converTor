package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeExtraInfoDescriptor;


public class ConvertBridgeExtra extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  ConvertBridgeExtra(Descriptor desc) {
    convert((BridgeExtraInfoDescriptor) desc);
  }

  public void convert(BridgeExtraInfoDescriptor desc) {

    converTor.encoders.classes.bridgeExtra.BridgeExtra conversion =
        new converTor.encoders.classes.bridgeExtra.BridgeExtra();

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


    this.type = Types.BRIDGE_EXTRA;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}