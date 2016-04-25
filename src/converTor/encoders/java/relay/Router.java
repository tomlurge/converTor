/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.encoders.java.relay;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Router extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5365292223340387042L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Router\",\"namespace\":\"converTor.encoders.java.relay\",\"fields\":[{\"name\":\"nickname\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/ServerDescriptor: String getNickname()\"},{\"name\":\"address\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/ServerDescriptor: String getAddress()\"},{\"name\":\"or_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/ServerDescriptor: int getOrPort()\"},{\"name\":\"socks_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/ServerDescriptor: int getSocksPort()\"},{\"name\":\"dir_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/ServerDescriptor: int getDirPort()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/ServerDescriptor: String getNickname() */
  @Deprecated public java.lang.String nickname;
  /** metrics-lib/ServerDescriptor: String getAddress() */
  @Deprecated public java.lang.String address;
  /** metrics-lib/ServerDescriptor: int getOrPort() */
  @Deprecated public java.lang.Integer or_port;
  /** metrics-lib/ServerDescriptor: int getSocksPort() */
  @Deprecated public java.lang.Integer socks_port;
  /** metrics-lib/ServerDescriptor: int getDirPort() */
  @Deprecated public java.lang.Integer dir_port;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Router() {}

  /**
   * All-args constructor.
   * @param nickname metrics-lib/ServerDescriptor: String getNickname()
   * @param address metrics-lib/ServerDescriptor: String getAddress()
   * @param or_port metrics-lib/ServerDescriptor: int getOrPort()
   * @param socks_port metrics-lib/ServerDescriptor: int getSocksPort()
   * @param dir_port metrics-lib/ServerDescriptor: int getDirPort()
   */
  public Router(java.lang.String nickname, java.lang.String address, java.lang.Integer or_port, java.lang.Integer socks_port, java.lang.Integer dir_port) {
    this.nickname = nickname;
    this.address = address;
    this.or_port = or_port;
    this.socks_port = socks_port;
    this.dir_port = dir_port;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return nickname;
    case 1: return address;
    case 2: return or_port;
    case 3: return socks_port;
    case 4: return dir_port;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: nickname = (java.lang.String)value$; break;
    case 1: address = (java.lang.String)value$; break;
    case 2: or_port = (java.lang.Integer)value$; break;
    case 3: socks_port = (java.lang.Integer)value$; break;
    case 4: dir_port = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'nickname' field.
   * @return metrics-lib/ServerDescriptor: String getNickname()
   */
  public java.lang.String getNickname() {
    return nickname;
  }

  /**
   * Sets the value of the 'nickname' field.
   * metrics-lib/ServerDescriptor: String getNickname()
   * @param value the value to set.
   */
  public void setNickname(java.lang.String value) {
    this.nickname = value;
  }

  /**
   * Gets the value of the 'address' field.
   * @return metrics-lib/ServerDescriptor: String getAddress()
   */
  public java.lang.String getAddress() {
    return address;
  }

  /**
   * Sets the value of the 'address' field.
   * metrics-lib/ServerDescriptor: String getAddress()
   * @param value the value to set.
   */
  public void setAddress(java.lang.String value) {
    this.address = value;
  }

  /**
   * Gets the value of the 'or_port' field.
   * @return metrics-lib/ServerDescriptor: int getOrPort()
   */
  public java.lang.Integer getOrPort() {
    return or_port;
  }

  /**
   * Sets the value of the 'or_port' field.
   * metrics-lib/ServerDescriptor: int getOrPort()
   * @param value the value to set.
   */
  public void setOrPort(java.lang.Integer value) {
    this.or_port = value;
  }

  /**
   * Gets the value of the 'socks_port' field.
   * @return metrics-lib/ServerDescriptor: int getSocksPort()
   */
  public java.lang.Integer getSocksPort() {
    return socks_port;
  }

  /**
   * Sets the value of the 'socks_port' field.
   * metrics-lib/ServerDescriptor: int getSocksPort()
   * @param value the value to set.
   */
  public void setSocksPort(java.lang.Integer value) {
    this.socks_port = value;
  }

  /**
   * Gets the value of the 'dir_port' field.
   * @return metrics-lib/ServerDescriptor: int getDirPort()
   */
  public java.lang.Integer getDirPort() {
    return dir_port;
  }

  /**
   * Sets the value of the 'dir_port' field.
   * metrics-lib/ServerDescriptor: int getDirPort()
   * @param value the value to set.
   */
  public void setDirPort(java.lang.Integer value) {
    this.dir_port = value;
  }

  /**
   * Creates a new Router RecordBuilder.
   * @return A new Router RecordBuilder
   */
  public static converTor.encoders.java.relay.Router.Builder newBuilder() {
    return new converTor.encoders.java.relay.Router.Builder();
  }
  
  /**
   * Creates a new Router RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Router RecordBuilder
   */
  public static converTor.encoders.java.relay.Router.Builder newBuilder(converTor.encoders.java.relay.Router.Builder other) {
    return new converTor.encoders.java.relay.Router.Builder(other);
  }
  
  /**
   * Creates a new Router RecordBuilder by copying an existing Router instance.
   * @param other The existing instance to copy.
   * @return A new Router RecordBuilder
   */
  public static converTor.encoders.java.relay.Router.Builder newBuilder(converTor.encoders.java.relay.Router other) {
    return new converTor.encoders.java.relay.Router.Builder(other);
  }
  
  /**
   * RecordBuilder for Router instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Router>
    implements org.apache.avro.data.RecordBuilder<Router> {

    /** metrics-lib/ServerDescriptor: String getNickname() */
    private java.lang.String nickname;
    /** metrics-lib/ServerDescriptor: String getAddress() */
    private java.lang.String address;
    /** metrics-lib/ServerDescriptor: int getOrPort() */
    private java.lang.Integer or_port;
    /** metrics-lib/ServerDescriptor: int getSocksPort() */
    private java.lang.Integer socks_port;
    /** metrics-lib/ServerDescriptor: int getDirPort() */
    private java.lang.Integer dir_port;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.encoders.java.relay.Router.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.encoders.java.relay.Router.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.nickname)) {
        this.nickname = data().deepCopy(fields()[0].schema(), other.nickname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.address)) {
        this.address = data().deepCopy(fields()[1].schema(), other.address);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.or_port)) {
        this.or_port = data().deepCopy(fields()[2].schema(), other.or_port);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.socks_port)) {
        this.socks_port = data().deepCopy(fields()[3].schema(), other.socks_port);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.dir_port)) {
        this.dir_port = data().deepCopy(fields()[4].schema(), other.dir_port);
        fieldSetFlags()[4] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing Router instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.encoders.java.relay.Router other) {
            super(converTor.encoders.java.relay.Router.SCHEMA$);
      if (isValidValue(fields()[0], other.nickname)) {
        this.nickname = data().deepCopy(fields()[0].schema(), other.nickname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.address)) {
        this.address = data().deepCopy(fields()[1].schema(), other.address);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.or_port)) {
        this.or_port = data().deepCopy(fields()[2].schema(), other.or_port);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.socks_port)) {
        this.socks_port = data().deepCopy(fields()[3].schema(), other.socks_port);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.dir_port)) {
        this.dir_port = data().deepCopy(fields()[4].schema(), other.dir_port);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'nickname' field.
      * metrics-lib/ServerDescriptor: String getNickname()
      * @return The value.
      */
    public java.lang.String getNickname() {
      return nickname;
    }

    /**
      * Sets the value of the 'nickname' field.
      * metrics-lib/ServerDescriptor: String getNickname()
      * @param value The value of 'nickname'.
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder setNickname(java.lang.String value) {
      validate(fields()[0], value);
      this.nickname = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'nickname' field has been set.
      * metrics-lib/ServerDescriptor: String getNickname()
      * @return True if the 'nickname' field has been set, false otherwise.
      */
    public boolean hasNickname() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'nickname' field.
      * metrics-lib/ServerDescriptor: String getNickname()
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder clearNickname() {
      nickname = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'address' field.
      * metrics-lib/ServerDescriptor: String getAddress()
      * @return The value.
      */
    public java.lang.String getAddress() {
      return address;
    }

    /**
      * Sets the value of the 'address' field.
      * metrics-lib/ServerDescriptor: String getAddress()
      * @param value The value of 'address'.
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder setAddress(java.lang.String value) {
      validate(fields()[1], value);
      this.address = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'address' field has been set.
      * metrics-lib/ServerDescriptor: String getAddress()
      * @return True if the 'address' field has been set, false otherwise.
      */
    public boolean hasAddress() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'address' field.
      * metrics-lib/ServerDescriptor: String getAddress()
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder clearAddress() {
      address = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'or_port' field.
      * metrics-lib/ServerDescriptor: int getOrPort()
      * @return The value.
      */
    public java.lang.Integer getOrPort() {
      return or_port;
    }

    /**
      * Sets the value of the 'or_port' field.
      * metrics-lib/ServerDescriptor: int getOrPort()
      * @param value The value of 'or_port'.
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder setOrPort(java.lang.Integer value) {
      validate(fields()[2], value);
      this.or_port = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'or_port' field has been set.
      * metrics-lib/ServerDescriptor: int getOrPort()
      * @return True if the 'or_port' field has been set, false otherwise.
      */
    public boolean hasOrPort() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'or_port' field.
      * metrics-lib/ServerDescriptor: int getOrPort()
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder clearOrPort() {
      or_port = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'socks_port' field.
      * metrics-lib/ServerDescriptor: int getSocksPort()
      * @return The value.
      */
    public java.lang.Integer getSocksPort() {
      return socks_port;
    }

    /**
      * Sets the value of the 'socks_port' field.
      * metrics-lib/ServerDescriptor: int getSocksPort()
      * @param value The value of 'socks_port'.
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder setSocksPort(java.lang.Integer value) {
      validate(fields()[3], value);
      this.socks_port = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'socks_port' field has been set.
      * metrics-lib/ServerDescriptor: int getSocksPort()
      * @return True if the 'socks_port' field has been set, false otherwise.
      */
    public boolean hasSocksPort() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'socks_port' field.
      * metrics-lib/ServerDescriptor: int getSocksPort()
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder clearSocksPort() {
      socks_port = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'dir_port' field.
      * metrics-lib/ServerDescriptor: int getDirPort()
      * @return The value.
      */
    public java.lang.Integer getDirPort() {
      return dir_port;
    }

    /**
      * Sets the value of the 'dir_port' field.
      * metrics-lib/ServerDescriptor: int getDirPort()
      * @param value The value of 'dir_port'.
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder setDirPort(java.lang.Integer value) {
      validate(fields()[4], value);
      this.dir_port = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'dir_port' field has been set.
      * metrics-lib/ServerDescriptor: int getDirPort()
      * @return True if the 'dir_port' field has been set, false otherwise.
      */
    public boolean hasDirPort() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'dir_port' field.
      * metrics-lib/ServerDescriptor: int getDirPort()
      * @return This builder.
      */
    public converTor.encoders.java.relay.Router.Builder clearDirPort() {
      dir_port = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public Router build() {
      try {
        Router record = new Router();
        record.nickname = fieldSetFlags()[0] ? this.nickname : (java.lang.String) defaultValue(fields()[0]);
        record.address = fieldSetFlags()[1] ? this.address : (java.lang.String) defaultValue(fields()[1]);
        record.or_port = fieldSetFlags()[2] ? this.or_port : (java.lang.Integer) defaultValue(fields()[2]);
        record.socks_port = fieldSetFlags()[3] ? this.socks_port : (java.lang.Integer) defaultValue(fields()[3]);
        record.dir_port = fieldSetFlags()[4] ? this.dir_port : (java.lang.Integer) defaultValue(fields()[4]);
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
