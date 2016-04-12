package converTor;
import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeServerDescriptor;

public class ConvertBridge extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  ConvertBridge(Descriptor desc) {
    convert((BridgeServerDescriptor) desc);
  }

  public void convert(BridgeServerDescriptor desc) {

    converTor.encoders.classes.bridge.Bridge conversion =
        new converTor.encoders.classes.bridge.Bridge();

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


    this.type = Types.BRIDGE;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}
