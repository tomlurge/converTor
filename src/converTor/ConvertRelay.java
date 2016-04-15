package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayServerDescriptor;
import converTor.encoders.classes.relay.Relay;


public class ConvertRelay extends Convert {

  ConvertRelay() {}
  ConvertRelay(Descriptor desc) {
    convert((RelayServerDescriptor) desc);
  }


  public void convert(RelayServerDescriptor desc) {

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



    this.type = Types.RELAY;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}
