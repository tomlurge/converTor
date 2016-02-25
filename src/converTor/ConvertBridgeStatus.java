package converTor;

import converTor.bridgeStatus.BridgeStatus;
import org.torproject.descriptor.BridgeNetworkStatus;


public class ConvertBridgeStatus extends ConvertCommons {

  static Converted convert(BridgeNetworkStatus desc) {

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


    Converted converted = new Converted();
    converted.type = DescriptorType.bridgeStatusType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}