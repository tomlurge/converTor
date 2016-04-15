package converTor;

import org.torproject.descriptor.Descriptor;
import org.torproject.descriptor.RelayExtraInfoDescriptor;
import converTor.encoders.classes.relayExtra.RelayExtra;


public class ConvertRelayExtra extends Convert {

  ConvertRelayExtra() {}
  ConvertRelayExtra(Descriptor desc) {
    convert((RelayExtraInfoDescriptor) desc);
  }


  public void convert(RelayExtraInfoDescriptor desc) {

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


    this.type = Types.RELAY_EXTRA;
    this.date = dateTimeFormat.format(desc.getPublishedMillis()).substring(0,7);
    this.load = conversion;

  }
}