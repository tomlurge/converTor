package converTor;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeNetworkStatus;
import converTor.encoders.classes.bridgeStatus.BridgeStatus;


class ConvertBridgeStatus extends Convert {

  void convert(Descriptor descriptor) {

    BridgeNetworkStatus desc = (BridgeNetworkStatus) descriptor;
    BridgeStatus conversion = new BridgeStatus();

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