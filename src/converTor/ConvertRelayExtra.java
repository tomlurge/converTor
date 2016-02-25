package converTor;


import converTor.relayExtra.RelayExtra;
import org.torproject.descriptor.RelayExtraInfoDescriptor;

public class ConvertRelayExtra extends ConvertCommons {

  static Converted convert(RelayExtraInfoDescriptor desc) {

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
    converted.type = DescriptorType.relayExtraType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}