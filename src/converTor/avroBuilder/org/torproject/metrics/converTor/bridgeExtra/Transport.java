/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.torproject.metrics.converTor.bridgeExtra;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Transport extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Transport\",\"namespace\":\"org.torproject.metrics.converTor.bridgeExtra\",\"fields\":[{\"name\":\"transportname\",\"type\":[\"null\",\"string\"]},{\"name\":\"address\",\"type\":[\"null\",\"string\"]},{\"name\":\"port\",\"type\":[\"null\",\"int\"]},{\"name\":\"args\",\"type\":[\"null\",\"string\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence transportname;
  @Deprecated public java.lang.CharSequence address;
  @Deprecated public java.lang.Integer port;
  @Deprecated public java.lang.CharSequence args;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Transport() {}

  /**
   * All-args constructor.
   */
  public Transport(java.lang.CharSequence transportname, java.lang.CharSequence address, java.lang.Integer port, java.lang.CharSequence args) {
    this.transportname = transportname;
    this.address = address;
    this.port = port;
    this.args = args;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return transportname;
    case 1: return address;
    case 2: return port;
    case 3: return args;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: transportname = (java.lang.CharSequence)value$; break;
    case 1: address = (java.lang.CharSequence)value$; break;
    case 2: port = (java.lang.Integer)value$; break;
    case 3: args = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'transportname' field.
   */
  public java.lang.CharSequence getTransportname() {
    return transportname;
  }

  /**
   * Sets the value of the 'transportname' field.
   * @param value the value to set.
   */
  public void setTransportname(java.lang.CharSequence value) {
    this.transportname = value;
  }

  /**
   * Gets the value of the 'address' field.
   */
  public java.lang.CharSequence getAddress() {
    return address;
  }

  /**
   * Sets the value of the 'address' field.
   * @param value the value to set.
   */
  public void setAddress(java.lang.CharSequence value) {
    this.address = value;
  }

  /**
   * Gets the value of the 'port' field.
   */
  public java.lang.Integer getPort() {
    return port;
  }

  /**
   * Sets the value of the 'port' field.
   * @param value the value to set.
   */
  public void setPort(java.lang.Integer value) {
    this.port = value;
  }

  /**
   * Gets the value of the 'args' field.
   */
  public java.lang.CharSequence getArgs() {
    return args;
  }

  /**
   * Sets the value of the 'args' field.
   * @param value the value to set.
   */
  public void setArgs(java.lang.CharSequence value) {
    this.args = value;
  }

  /** Creates a new Transport RecordBuilder */
  public static org.torproject.metrics.converTor.bridgeExtra.Transport.Builder newBuilder() {
    return new org.torproject.metrics.converTor.bridgeExtra.Transport.Builder();
  }
  
  /** Creates a new Transport RecordBuilder by copying an existing Builder */
  public static org.torproject.metrics.converTor.bridgeExtra.Transport.Builder newBuilder(org.torproject.metrics.converTor.bridgeExtra.Transport.Builder other) {
    return new org.torproject.metrics.converTor.bridgeExtra.Transport.Builder(other);
  }
  
  /** Creates a new Transport RecordBuilder by copying an existing Transport instance */
  public static org.torproject.metrics.converTor.bridgeExtra.Transport.Builder newBuilder(org.torproject.metrics.converTor.bridgeExtra.Transport other) {
    return new org.torproject.metrics.converTor.bridgeExtra.Transport.Builder(other);
  }
  
  /**
   * RecordBuilder for Transport instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Transport>
    implements org.apache.avro.data.RecordBuilder<Transport> {

    private java.lang.CharSequence transportname;
    private java.lang.CharSequence address;
    private java.lang.Integer port;
    private java.lang.CharSequence args;

    /** Creates a new Builder */
    private Builder() {
      super(org.torproject.metrics.converTor.bridgeExtra.Transport.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.torproject.metrics.converTor.bridgeExtra.Transport.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.transportname)) {
        this.transportname = data().deepCopy(fields()[0].schema(), other.transportname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.address)) {
        this.address = data().deepCopy(fields()[1].schema(), other.address);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.port)) {
        this.port = data().deepCopy(fields()[2].schema(), other.port);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.args)) {
        this.args = data().deepCopy(fields()[3].schema(), other.args);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Transport instance */
    private Builder(org.torproject.metrics.converTor.bridgeExtra.Transport other) {
            super(org.torproject.metrics.converTor.bridgeExtra.Transport.SCHEMA$);
      if (isValidValue(fields()[0], other.transportname)) {
        this.transportname = data().deepCopy(fields()[0].schema(), other.transportname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.address)) {
        this.address = data().deepCopy(fields()[1].schema(), other.address);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.port)) {
        this.port = data().deepCopy(fields()[2].schema(), other.port);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.args)) {
        this.args = data().deepCopy(fields()[3].schema(), other.args);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'transportname' field */
    public java.lang.CharSequence getTransportname() {
      return transportname;
    }
    
    /** Sets the value of the 'transportname' field */
    public org.torproject.metrics.converTor.bridgeExtra.Transport.Builder setTransportname(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.transportname = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'transportname' field has been set */
    public boolean hasTransportname() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'transportname' field */
    public org.torproject.metrics.converTor.bridgeExtra.Transport.Builder clearTransportname() {
      transportname = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'address' field */
    public java.lang.CharSequence getAddress() {
      return address;
    }
    
    /** Sets the value of the 'address' field */
    public org.torproject.metrics.converTor.bridgeExtra.Transport.Builder setAddress(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.address = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'address' field has been set */
    public boolean hasAddress() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'address' field */
    public org.torproject.metrics.converTor.bridgeExtra.Transport.Builder clearAddress() {
      address = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'port' field */
    public java.lang.Integer getPort() {
      return port;
    }
    
    /** Sets the value of the 'port' field */
    public org.torproject.metrics.converTor.bridgeExtra.Transport.Builder setPort(java.lang.Integer value) {
      validate(fields()[2], value);
      this.port = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'port' field has been set */
    public boolean hasPort() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'port' field */
    public org.torproject.metrics.converTor.bridgeExtra.Transport.Builder clearPort() {
      port = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'args' field */
    public java.lang.CharSequence getArgs() {
      return args;
    }
    
    /** Sets the value of the 'args' field */
    public org.torproject.metrics.converTor.bridgeExtra.Transport.Builder setArgs(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.args = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'args' field has been set */
    public boolean hasArgs() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'args' field */
    public org.torproject.metrics.converTor.bridgeExtra.Transport.Builder clearArgs() {
      args = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public Transport build() {
      try {
        Transport record = new Transport();
        record.transportname = fieldSetFlags()[0] ? this.transportname : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.address = fieldSetFlags()[1] ? this.address : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.port = fieldSetFlags()[2] ? this.port : (java.lang.Integer) defaultValue(fields()[2]);
        record.args = fieldSetFlags()[3] ? this.args : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
