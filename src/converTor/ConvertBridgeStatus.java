package converTor;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeNetworkStatus;
import converTor.encoders.classes.bridgeStatus.BridgeStatus;


public class ConvertBridgeStatus extends Convert {

  ConvertBridgeStatus() {}
  ConvertBridgeStatus(Descriptor desc) {
    convert((BridgeNetworkStatus) desc);
  }


  public void convert(BridgeNetworkStatus desc) {

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