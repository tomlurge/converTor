package converTor.convert;

import converTor.util.ConvertResult;
import converTor.Type;
import org.torproject.descriptor.RelayServerDescriptor;


public class Relay extends ConvertCommons {

  public static ConvertResult convert(RelayServerDescriptor desc) {

    converTor.avro.classes.relay.Relay conversion =
        new converTor.avro.classes.relay.Relay();

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
    converted.type = Type.relayType;
    converted.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    converted.load = conversion;
    return converted;

  }
}
