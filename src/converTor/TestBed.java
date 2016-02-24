package converTor;


import org.torproject.descriptor.Descriptor;

class TestBed {


  public TestBed(Descriptor descriptor2convert, DescriptorType descType) {


    //  1. try - quite chatty, doesn't use descType

    ConvertCommons convertClas = null;
    try {
      Class<?> tmp = Class.forName("converTor.Convert" + descType.clasName);
      convertClas = (ConvertCommons) tmp.newInstance();
    } catch (ClassNotFoundException c) {
      System.err.println("ClassNotFoundException: "+ c.getMessage());
      c.printStackTrace();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    convertClas.convert(descriptor2convert);


    //  2. try

    ConvertTorperf foo = null; // variant:  ConvertTorperf asdf = new ConvertTorperf();
    Converted bar = foo.convert(descriptor2convert); //  TODO refine


  }








}