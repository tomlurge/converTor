package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeNetworkStatus;


public class ConvertBridgeStatus extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  ConvertBridgeStatus(Descriptor desc) {
    convert((BridgeNetworkStatus) desc);
  }

  public void convert(BridgeNetworkStatus desc) {

    converTor.encoders.classes.bridgeStatus.BridgeStatus conversion =
        new converTor.encoders.classes.bridgeStatus.BridgeStatus();

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


    this.type = Types.BRIDGE_STATUS;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}