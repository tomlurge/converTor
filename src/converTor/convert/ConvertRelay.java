package converTor.convert;

import converTor.avro.classes.relay.Relay;
import converTor.util.Convert;
import converTor.util.Converted;
import converTor.util.DescriptorType;
import org.torproject.descriptor.RelayServerDescriptor;


public class ConvertRelay extends Convert {

  public static Converted convert(RelayServerDescriptor desc) {

    Relay conversion = new Relay();

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
    converted.type = DescriptorType.relayType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}
