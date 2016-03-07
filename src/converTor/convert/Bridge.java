package converTor.convert;

import converTor.util.ConvertResult;
import converTor.Type;
import org.torproject.descriptor.BridgeServerDescriptor;


public class Bridge extends ConvertCommons {

  public static ConvertResult convert(BridgeServerDescriptor desc) {

    converTor.avro.classes.bridge.Bridge conversion =
        new converTor.avro.classes.bridge.Bridge();

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
    converted.type = Type.bridgeType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}
