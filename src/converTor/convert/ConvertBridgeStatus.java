package converTor.convert;

import converTor.avro.classes.bridgeStatus.BridgeStatus;
import converTor.util.Convert;
import converTor.util.Converted;
import converTor.util.ConvertType;
import org.torproject.descriptor.BridgeNetworkStatus;


public class ConvertBridgeStatus extends Convert {

  public static Converted convert(BridgeNetworkStatus desc) {

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
    converted.type = ConvertType.bridgeStatusType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}