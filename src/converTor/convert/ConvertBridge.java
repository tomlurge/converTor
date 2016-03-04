package converTor.convert;

import converTor.util.Convert;
import converTor.util.Converted;
import converTor.util.DescriptorType;
import converTor.avro.classes.bridge.Bridge;
import org.torproject.descriptor.BridgeServerDescriptor;


public class ConvertBridge extends Convert {

  public static Converted convert(BridgeServerDescriptor desc) {

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
