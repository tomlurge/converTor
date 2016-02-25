package converTor;

import converTor.bridgeExtra.BridgeExtra;
import org.torproject.descriptor.BridgeExtraInfoDescriptor;


public class ConvertBridgeExtra extends ConvertCommons {

  static Converted convert(BridgeExtraInfoDescriptor desc) {

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


    Converted converted = new Converted();
    converted.type = DescriptorType.bridgeExtraType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}