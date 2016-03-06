package converTor.convert;

import converTor.util.ConvertResult;
import converTor.util.ConvertType;
import org.torproject.descriptor.BridgeExtraInfoDescriptor;


public class BridgeExtra extends ConvertCommons {

  public static ConvertResult convert(BridgeExtraInfoDescriptor desc) {

    converTor.avro.classes.bridgeExtra.BridgeExtra conversion =
        new converTor.avro.classes.bridgeExtra.BridgeExtra();

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
    converted.type = ConvertType.bridgeExtraType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}