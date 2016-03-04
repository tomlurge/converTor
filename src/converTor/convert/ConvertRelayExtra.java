package converTor.convert;


import converTor.avro.classes.relayExtra.RelayExtra;
import converTor.util.Convert;
import converTor.util.Converted;
import converTor.util.ConvertType;
import org.torproject.descriptor.RelayExtraInfoDescriptor;

public class ConvertRelayExtra extends Convert {

  public static Converted convert(RelayExtraInfoDescriptor desc) {

    RelayExtra conversion = new RelayExtra();

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
    converted.type = ConvertType.relayExtraType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}