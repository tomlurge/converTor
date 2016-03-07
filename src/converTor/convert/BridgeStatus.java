package converTor.convert;

import converTor.util.ConvertResult;
import converTor.Type;
import org.torproject.descriptor.BridgeNetworkStatus;


public class BridgeStatus extends ConvertCommons {

  public static ConvertResult convert(BridgeNetworkStatus desc) {

    converTor.avro.classes.bridgeStatus.BridgeStatus conversion =
        new converTor.avro.classes.bridgeStatus.BridgeStatus();

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


    ConvertResult converted = new ConvertResult();
    converted.type = Type.bridgeStatusType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}