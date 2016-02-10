/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.bridge;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class NtorCrossCert extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 717512494071795171L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NtorCrossCert\",\"namespace\":\"converTor.bridge\",\"fields\":[{\"name\":\"cert\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert()\"},{\"name\":\"bit\",\"type\":\"int\",\"doc\":\"metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert() */
  @Deprecated public java.lang.String cert;
  /** metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign() */
  @Deprecated public int bit;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public NtorCrossCert() {}

  /**
   * All-args constructor.
   * @param cert metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert()
   * @param bit metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign()
   */
  public NtorCrossCert(java.lang.String cert, java.lang.Integer bit) {
    this.cert = cert;
    this.bit = bit;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return cert;
    case 1: return bit;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: cert = (java.lang.String)value$; break;
    case 1: bit = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'cert' field.
   * @return metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert()
   */
  public java.lang.String getCert() {
    return cert;
  }

  /**
   * Sets the value of the 'cert' field.
   * metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert()
   * @param value the value to set.
   */
  public void setCert(java.lang.String value) {
    this.cert = value;
  }

  /**
   * Gets the value of the 'bit' field.
   * @return metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign()
   */
  public java.lang.Integer getBit() {
    return bit;
  }

  /**
   * Sets the value of the 'bit' field.
   * metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign()
   * @param value the value to set.
   */
  public void setBit(java.lang.Integer value) {
    this.bit = value;
  }

  /**
   * Creates a new NtorCrossCert RecordBuilder.
   * @return A new NtorCrossCert RecordBuilder
   */
  public static converTor.bridge.NtorCrossCert.Builder newBuilder() {
    return new converTor.bridge.NtorCrossCert.Builder();
  }
  
  /**
   * Creates a new NtorCrossCert RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new NtorCrossCert RecordBuilder
   */
  public static converTor.bridge.NtorCrossCert.Builder newBuilder(converTor.bridge.NtorCrossCert.Builder other) {
    return new converTor.bridge.NtorCrossCert.Builder(other);
  }
  
  /**
   * Creates a new NtorCrossCert RecordBuilder by copying an existing NtorCrossCert instance.
   * @param other The existing instance to copy.
   * @return A new NtorCrossCert RecordBuilder
   */
  public static converTor.bridge.NtorCrossCert.Builder newBuilder(converTor.bridge.NtorCrossCert other) {
    return new converTor.bridge.NtorCrossCert.Builder(other);
  }
  
  /**
   * RecordBuilder for NtorCrossCert instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NtorCrossCert>
    implements org.apache.avro.data.RecordBuilder<NtorCrossCert> {

    /** metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert() */
    private java.lang.String cert;
    /** metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign() */
    private int bit;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.bridge.NtorCrossCert.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.bridge.NtorCrossCert.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.cert)) {
        this.cert = data().deepCopy(fields()[0].schema(), other.cert);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.bit)) {
        this.bit = data().deepCopy(fields()[1].schema(), other.bit);
        fieldSetFlags()[1] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing NtorCrossCert instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.bridge.NtorCrossCert other) {
            super(converTor.bridge.NtorCrossCert.SCHEMA$);
      if (isValidValue(fields()[0], other.cert)) {
        this.cert = data().deepCopy(fields()[0].schema(), other.cert);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.bit)) {
        this.bit = data().deepCopy(fields()[1].schema(), other.bit);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'cert' field.
      * metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert()
      * @return The value.
      */
    public java.lang.String getCert() {
      return cert;
    }

    /**
      * Sets the value of the 'cert' field.
      * metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert()
      * @param value The value of 'cert'.
      * @return This builder.
      */
    public converTor.bridge.NtorCrossCert.Builder setCert(java.lang.String value) {
      validate(fields()[0], value);
      this.cert = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'cert' field has been set.
      * metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert()
      * @return True if the 'cert' field has been set, false otherwise.
      */
    public boolean hasCert() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'cert' field.
      * metrics-lib/ServerDescriptor: String getNtorOnionKeyCrosscert()
      * @return This builder.
      */
    public converTor.bridge.NtorCrossCert.Builder clearCert() {
      cert = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'bit' field.
      * metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign()
      * @return The value.
      */
    public java.lang.Integer getBit() {
      return bit;
    }

    /**
      * Sets the value of the 'bit' field.
      * metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign()
      * @param value The value of 'bit'.
      * @return This builder.
      */
    public converTor.bridge.NtorCrossCert.Builder setBit(int value) {
      validate(fields()[1], value);
      this.bit = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'bit' field has been set.
      * metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign()
      * @return True if the 'bit' field has been set, false otherwise.
      */
    public boolean hasBit() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'bit' field.
      * metrics-lib/ServerDescriptor: int getNtorOnionKeyCrosscertSign()
      * @return This builder.
      */
    public converTor.bridge.NtorCrossCert.Builder clearBit() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public NtorCrossCert build() {
      try {
        NtorCrossCert record = new NtorCrossCert();
        record.cert = fieldSetFlags()[0] ? this.cert : (java.lang.String) defaultValue(fields()[0]);
        record.bit = fieldSetFlags()[1] ? this.bit : (java.lang.Integer) defaultValue(fields()[1]);
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
