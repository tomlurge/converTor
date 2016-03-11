package converTor.converter;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.BridgeNetworkStatus;


public class BridgeStatus extends Convert {

  //  inherits fields 'type', 'date' and 'load'

  BridgeStatus(Descriptor desc) {
    convert((BridgeNetworkStatus) desc);
  }

  public void convert(BridgeNetworkStatus desc) {

    converTor.avro.classes.bridgeStatus.BridgeStatus conversion =
        new converTor.avro.classes.bridgeStatus.BridgeStatus();

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