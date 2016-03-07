package converTor.convert;


import converTor.util.ConvertResult;
import converTor.Type;
import org.torproject.descriptor.RelayExtraInfoDescriptor;

public class RelayExtra extends ConvertCommons {

  public static ConvertResult convert(RelayExtraInfoDescriptor desc) {

    converTor.avro.classes.relayExtra.RelayExtra conversion =
        new converTor.avro.classes.relayExtra.RelayExtra();

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
    converted.type = Type.relayExtraType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}