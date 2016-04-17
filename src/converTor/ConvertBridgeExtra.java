package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeExtraInfoDescriptor;
import converTor.encoders.classes.bridgeExtra.BridgeExtra;


class ConvertBridgeExtra extends Convert {

  void convert(Descriptor descriptor) {

    BridgeExtraInfoDescriptor desc = (BridgeExtraInfoDescriptor) descriptor;
    BridgeExtra conversion = new BridgeExtra();

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