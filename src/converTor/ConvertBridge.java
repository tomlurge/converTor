package converTor;

import converTor.bridge.Bridge;
import org.torproject.descriptor.BridgeServerDescriptor;


public class ConvertBridge extends ConvertCommons {

  static Converted convert(BridgeServerDescriptor desc) {

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


    Converted converted = new Converted();
    converted.type = DescriptorType.bridgeType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}
