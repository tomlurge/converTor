package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeServerDescriptor;
import converTor.encoders.classes.bridge.Bridge;


public class ConvertBridge extends Convert {

  ConvertBridge() {}
  ConvertBridge(Descriptor desc) {
    convert((BridgeServerDescriptor) desc);
  }


  public void convert(BridgeServerDescriptor desc) {

    Bridge conversion = new Bridge();

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


    this.type = Types.BRIDGE;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }

}
