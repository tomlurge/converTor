/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.bridgeExtra;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class HidservDirOnionsSeen extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8031721531763277441L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"HidservDirOnionsSeen\",\"namespace\":\"converTor.bridgeExtra\",\"fields\":[{\"name\":\"onions\",\"type\":\"double\",\"doc\":\"metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen()\"},{\"name\":\"obfuscation\",\"type\":{\"type\":\"map\",\"values\":\"int\",\"avro.java.string\":\"String\"},\"doc\":\"metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen() */
  @Deprecated public double onions;
  /** metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters() */
  @Deprecated public java.util.Map<java.lang.String,java.lang.Integer> obfuscation;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public HidservDirOnionsSeen() {}

  /**
   * All-args constructor.
   * @param onions metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen()
   * @param obfuscation metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters()
   */
  public HidservDirOnionsSeen(java.lang.Double onions, java.util.Map<java.lang.String,java.lang.Integer> obfuscation) {
    this.onions = onions;
    this.obfuscation = obfuscation;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return onions;
    case 1: return obfuscation;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: onions = (java.lang.Double)value$; break;
    case 1: obfuscation = (java.util.Map<java.lang.String,java.lang.Integer>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'onions' field.
   * @return metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen()
   */
  public java.lang.Double getOnions() {
    return onions;
  }

  /**
   * Sets the value of the 'onions' field.
   * metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen()
   * @param value the value to set.
   */
  public void setOnions(java.lang.Double value) {
    this.onions = value;
  }

  /**
   * Gets the value of the 'obfuscation' field.
   * @return metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters()
   */
  public java.util.Map<java.lang.String,java.lang.Integer> getObfuscation() {
    return obfuscation;
  }

  /**
   * Sets the value of the 'obfuscation' field.
   * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters()
   * @param value the value to set.
   */
  public void setObfuscation(java.util.Map<java.lang.String,java.lang.Integer> value) {
    this.obfuscation = value;
  }

  /**
   * Creates a new HidservDirOnionsSeen RecordBuilder.
   * @return A new HidservDirOnionsSeen RecordBuilder
   */
  public static converTor.bridgeExtra.HidservDirOnionsSeen.Builder newBuilder() {
    return new converTor.bridgeExtra.HidservDirOnionsSeen.Builder();
  }
  
  /**
   * Creates a new HidservDirOnionsSeen RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new HidservDirOnionsSeen RecordBuilder
   */
  public static converTor.bridgeExtra.HidservDirOnionsSeen.Builder newBuilder(converTor.bridgeExtra.HidservDirOnionsSeen.Builder other) {
    return new converTor.bridgeExtra.HidservDirOnionsSeen.Builder(other);
  }
  
  /**
   * Creates a new HidservDirOnionsSeen RecordBuilder by copying an existing HidservDirOnionsSeen instance.
   * @param other The existing instance to copy.
   * @return A new HidservDirOnionsSeen RecordBuilder
   */
  public static converTor.bridgeExtra.HidservDirOnionsSeen.Builder newBuilder(converTor.bridgeExtra.HidservDirOnionsSeen other) {
    return new converTor.bridgeExtra.HidservDirOnionsSeen.Builder(other);
  }
  
  /**
   * RecordBuilder for HidservDirOnionsSeen instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<HidservDirOnionsSeen>
    implements org.apache.avro.data.RecordBuilder<HidservDirOnionsSeen> {

    /** metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen() */
    private double onions;
    /** metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters() */
    private java.util.Map<java.lang.String,java.lang.Integer> obfuscation;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.bridgeExtra.HidservDirOnionsSeen.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.bridgeExtra.HidservDirOnionsSeen.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.onions)) {
        this.onions = data().deepCopy(fields()[0].schema(), other.onions);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.obfuscation)) {
        this.obfuscation = data().deepCopy(fields()[1].schema(), other.obfuscation);
        fieldSetFlags()[1] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing HidservDirOnionsSeen instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.bridgeExtra.HidservDirOnionsSeen other) {
            super(converTor.bridgeExtra.HidservDirOnionsSeen.SCHEMA$);
      if (isValidValue(fields()[0], other.onions)) {
        this.onions = data().deepCopy(fields()[0].schema(), other.onions);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.obfuscation)) {
        this.obfuscation = data().deepCopy(fields()[1].schema(), other.obfuscation);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'onions' field.
      * metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen()
      * @return The value.
      */
    public java.lang.Double getOnions() {
      return onions;
    }

    /**
      * Sets the value of the 'onions' field.
      * metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen()
      * @param value The value of 'onions'.
      * @return This builder.
      */
    public converTor.bridgeExtra.HidservDirOnionsSeen.Builder setOnions(double value) {
      validate(fields()[0], value);
      this.onions = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'onions' field has been set.
      * metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen()
      * @return True if the 'onions' field has been set, false otherwise.
      */
    public boolean hasOnions() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'onions' field.
      * metrics-lib/ExtraInfoDescriptor: Double getHidservDirOnionsSeen()
      * @return This builder.
      */
    public converTor.bridgeExtra.HidservDirOnionsSeen.Builder clearOnions() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'obfuscation' field.
      * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters()
      * @return The value.
      */
    public java.util.Map<java.lang.String,java.lang.Integer> getObfuscation() {
      return obfuscation;
    }

    /**
      * Sets the value of the 'obfuscation' field.
      * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters()
      * @param value The value of 'obfuscation'.
      * @return This builder.
      */
    public converTor.bridgeExtra.HidservDirOnionsSeen.Builder setObfuscation(java.util.Map<java.lang.String,java.lang.Integer> value) {
      validate(fields()[1], value);
      this.obfuscation = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'obfuscation' field has been set.
      * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters()
      * @return True if the 'obfuscation' field has been set, false otherwise.
      */
    public boolean hasObfuscation() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'obfuscation' field.
      * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservDirOnionsSeenParameters()
      * @return This builder.
      */
    public converTor.bridgeExtra.HidservDirOnionsSeen.Builder clearObfuscation() {
      obfuscation = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public HidservDirOnionsSeen build() {
      try {
        HidservDirOnionsSeen record = new HidservDirOnionsSeen();
        record.onions = fieldSetFlags()[0] ? this.onions : (java.lang.Double) defaultValue(fields()[0]);
        record.obfuscation = fieldSetFlags()[1] ? this.obfuscation : (java.util.Map<java.lang.String,java.lang.Integer>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);  

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);  

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in));
  }

}
