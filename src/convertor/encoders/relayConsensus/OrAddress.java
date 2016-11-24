/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package convertor.encoders.relayConsensus;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class OrAddress extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2085443250875942826L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrAddress\",\"namespace\":\"convertor.encoders.relayConsensus\",\"fields\":[{\"name\":\"address\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"implementation specific, see actual converter\"},{\"name\":\"port\",\"type\":[\"null\",\"int\"],\"doc\":\"implementation specific, see actual converter\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** implementation specific, see actual converter */
  @Deprecated public java.lang.String address;
  /** implementation specific, see actual converter */
  @Deprecated public java.lang.Integer port;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public OrAddress() {}

  /**
   * All-args constructor.
   * @param address implementation specific, see actual converter
   * @param port implementation specific, see actual converter
   */
  public OrAddress(java.lang.String address, java.lang.Integer port) {
    this.address = address;
    this.port = port;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return address;
    case 1: return port;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: address = (java.lang.String)value$; break;
    case 1: port = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'address' field.
   * @return implementation specific, see actual converter
   */
  public java.lang.String getAddress() {
    return address;
  }

  /**
   * Sets the value of the 'address' field.
   * implementation specific, see actual converter
   * @param value the value to set.
   */
  public void setAddress(java.lang.String value) {
    this.address = value;
  }

  /**
   * Gets the value of the 'port' field.
   * @return implementation specific, see actual converter
   */
  public java.lang.Integer getPort() {
    return port;
  }

  /**
   * Sets the value of the 'port' field.
   * implementation specific, see actual converter
   * @param value the value to set.
   */
  public void setPort(java.lang.Integer value) {
    this.port = value;
  }

  /**
   * Creates a new OrAddress RecordBuilder.
   * @return A new OrAddress RecordBuilder
   */
  public static convertor.encoders.relayConsensus.OrAddress.Builder newBuilder() {
    return new convertor.encoders.relayConsensus.OrAddress.Builder();
  }
  
  /**
   * Creates a new OrAddress RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrAddress RecordBuilder
   */
  public static convertor.encoders.relayConsensus.OrAddress.Builder newBuilder(convertor.encoders.relayConsensus.OrAddress.Builder other) {
    return new convertor.encoders.relayConsensus.OrAddress.Builder(other);
  }
  
  /**
   * Creates a new OrAddress RecordBuilder by copying an existing OrAddress instance.
   * @param other The existing instance to copy.
   * @return A new OrAddress RecordBuilder
   */
  public static convertor.encoders.relayConsensus.OrAddress.Builder newBuilder(convertor.encoders.relayConsensus.OrAddress other) {
    return new convertor.encoders.relayConsensus.OrAddress.Builder(other);
  }
  
  /**
   * RecordBuilder for OrAddress instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrAddress>
    implements org.apache.avro.data.RecordBuilder<OrAddress> {

    /** implementation specific, see actual converter */
    private java.lang.String address;
    /** implementation specific, see actual converter */
    private java.lang.Integer port;

    /** Creates a new Builder */
    private Builder() {
      super(convertor.encoders.relayConsensus.OrAddress.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(convertor.encoders.relayConsensus.OrAddress.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.address)) {
        this.address = data().deepCopy(fields()[0].schema(), other.address);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.port)) {
        this.port = data().deepCopy(fields()[1].schema(), other.port);
        fieldSetFlags()[1] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing OrAddress instance
     * @param other The existing instance to copy.
     */
    private Builder(convertor.encoders.relayConsensus.OrAddress other) {
            super(convertor.encoders.relayConsensus.OrAddress.SCHEMA$);
      if (isValidValue(fields()[0], other.address)) {
        this.address = data().deepCopy(fields()[0].schema(), other.address);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.port)) {
        this.port = data().deepCopy(fields()[1].schema(), other.port);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'address' field.
      * implementation specific, see actual converter
      * @return The value.
      */
    public java.lang.String getAddress() {
      return address;
    }

    /**
      * Sets the value of the 'address' field.
      * implementation specific, see actual converter
      * @param value The value of 'address'.
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.OrAddress.Builder setAddress(java.lang.String value) {
      validate(fields()[0], value);
      this.address = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'address' field has been set.
      * implementation specific, see actual converter
      * @return True if the 'address' field has been set, false otherwise.
      */
    public boolean hasAddress() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'address' field.
      * implementation specific, see actual converter
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.OrAddress.Builder clearAddress() {
      address = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'port' field.
      * implementation specific, see actual converter
      * @return The value.
      */
    public java.lang.Integer getPort() {
      return port;
    }

    /**
      * Sets the value of the 'port' field.
      * implementation specific, see actual converter
      * @param value The value of 'port'.
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.OrAddress.Builder setPort(java.lang.Integer value) {
      validate(fields()[1], value);
      this.port = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'port' field has been set.
      * implementation specific, see actual converter
      * @return True if the 'port' field has been set, false otherwise.
      */
    public boolean hasPort() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'port' field.
      * implementation specific, see actual converter
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.OrAddress.Builder clearPort() {
      port = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public OrAddress build() {
      try {
        OrAddress record = new OrAddress();
        record.address = fieldSetFlags()[0] ? this.address : (java.lang.String) defaultValue(fields()[0]);
        record.port = fieldSetFlags()[1] ? this.port : (java.lang.Integer) defaultValue(fields()[1]);
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
