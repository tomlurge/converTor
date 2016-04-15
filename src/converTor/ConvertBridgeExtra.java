package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeExtraInfoDescriptor;
import converTor.encoders.classes.bridgeExtra.BridgeExtra;


public class ConvertBridgeExtra extends Convert {

  ConvertBridgeExtra(){}
  ConvertBridgeExtra(Descriptor desc) {
    convert((BridgeExtraInfoDescriptor) desc);
  }


  public void convert(BridgeExtraInfoDescriptor desc) {

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