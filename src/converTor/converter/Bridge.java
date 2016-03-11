package converTor.converter;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeServerDescriptor;


public class Bridge extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  Bridge(Descriptor desc) {
    convert((BridgeServerDescriptor) desc);
  }

  public void convert(BridgeServerDescriptor desc) {

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


    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}
