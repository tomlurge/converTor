/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.encoders.java.relayVote;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DirSource extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 9033789820426832205L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DirSource\",\"namespace\":\"converTor.encoders.java.relayVote\",\"fields\":[{\"name\":\"nickname\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/RelayNetworkStatusVote: String getNickname()\"},{\"name\":\"identity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/RelayNetworkStatusVote: String getIdentity(\"},{\"name\":\"hostname\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/RelayNetworkStatusVote: String getHostname()\"},{\"name\":\"address\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/RelayNetworkStatusVote: String getAddress()\"},{\"name\":\"dir_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/RelayNetworkStatusVote: int getDirport()\"},{\"name\":\"or_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/RelayNetworkStatusVote: int getOrport()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/RelayNetworkStatusVote: String getNickname() */
  @Deprecated public java.lang.String nickname;
  /** metrics-lib/RelayNetworkStatusVote: String getIdentity( */
  @Deprecated public java.lang.String identity;
  /** metrics-lib/RelayNetworkStatusVote: String getHostname() */
  @Deprecated public java.lang.String hostname;
  /** metrics-lib/RelayNetworkStatusVote: String getAddress() */
  @Deprecated public java.lang.String address;
  /** metrics-lib/RelayNetworkStatusVote: int getDirport() */
  @Deprecated public java.lang.Integer dir_port;
  /** metrics-lib/RelayNetworkStatusVote: int getOrport() */
  @Deprecated public java.lang.Integer or_port;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DirSource() {}

  /**
   * All-args constructor.
   * @param nickname metrics-lib/RelayNetworkStatusVote: String getNickname()
   * @param identity metrics-lib/RelayNetworkStatusVote: String getIdentity(
   * @param hostname metrics-lib/RelayNetworkStatusVote: String getHostname()
   * @param address metrics-lib/RelayNetworkStatusVote: String getAddress()
   * @param dir_port metrics-lib/RelayNetworkStatusVote: int getDirport()
   * @param or_port metrics-lib/RelayNetworkStatusVote: int getOrport()
   */
  public DirSource(java.lang.String nickname, java.lang.String identity, java.lang.String hostname, java.lang.String address, java.lang.Integer dir_port, java.lang.Integer or_port) {
    this.nickname = nickname;
    this.identity = identity;
    this.hostname = hostname;
    this.address = address;
    this.dir_port = dir_port;
    this.or_port = or_port;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return nickname;
    case 1: return identity;
    case 2: return hostname;
    case 3: return address;
    case 4: return dir_port;
    case 5: return or_port;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: nickname = (java.lang.String)value$; break;
    case 1: identity = (java.lang.String)value$; break;
    case 2: hostname = (java.lang.String)value$; break;
    case 3: address = (java.lang.String)value$; break;
    case 4: dir_port = (java.lang.Integer)value$; break;
    case 5: or_port = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'nickname' field.
   * @return metrics-lib/RelayNetworkStatusVote: String getNickname()
   */
  public java.lang.String getNickname() {
    return nickname;
  }

  /**
   * Sets the value of the 'nickname' field.
   * metrics-lib/RelayNetworkStatusVote: String getNickname()
   * @param value the value to set.
   */
  public void setNickname(java.lang.String value) {
    this.nickname = value;
  }

  /**
   * Gets the value of the 'identity' field.
   * @return metrics-lib/RelayNetworkStatusVote: String getIdentity(
   */
  public java.lang.String getIdentity() {
    return identity;
  }

  /**
   * Sets the value of the 'identity' field.
   * metrics-lib/RelayNetworkStatusVote: String getIdentity(
   * @param value the value to set.
   */
  public void setIdentity(java.lang.String value) {
    this.identity = value;
  }

  /**
   * Gets the value of the 'hostname' field.
   * @return metrics-lib/RelayNetworkStatusVote: String getHostname()
   */
  public java.lang.String getHostname() {
    return hostname;
  }

  /**
   * Sets the value of the 'hostname' field.
   * metrics-lib/RelayNetworkStatusVote: String getHostname()
   * @param value the value to set.
   */
  public void setHostname(java.lang.String value) {
    this.hostname = value;
  }

  /**
   * Gets the value of the 'address' field.
   * @return metrics-lib/RelayNetworkStatusVote: String getAddress()
   */
  public java.lang.String getAddress() {
    return address;
  }

  /**
   * Sets the value of the 'address' field.
   * metrics-lib/RelayNetworkStatusVote: String getAddress()
   * @param value the value to set.
   */
  public void setAddress(java.lang.String value) {
    this.address = value;
  }

  /**
   * Gets the value of the 'dir_port' field.
   * @return metrics-lib/RelayNetworkStatusVote: int getDirport()
   */
  public java.lang.Integer getDirPort() {
    return dir_port;
  }

  /**
   * Sets the value of the 'dir_port' field.
   * metrics-lib/RelayNetworkStatusVote: int getDirport()
   * @param value the value to set.
   */
  public void setDirPort(java.lang.Integer value) {
    this.dir_port = value;
  }

  /**
   * Gets the value of the 'or_port' field.
   * @return metrics-lib/RelayNetworkStatusVote: int getOrport()
   */
  public java.lang.Integer getOrPort() {
    return or_port;
  }

  /**
   * Sets the value of the 'or_port' field.
   * metrics-lib/RelayNetworkStatusVote: int getOrport()
   * @param value the value to set.
   */
  public void setOrPort(java.lang.Integer value) {
    this.or_port = value;
  }

  /**
   * Creates a new DirSource RecordBuilder.
   * @return A new DirSource RecordBuilder
   */
  public static converTor.encoders.java.relayVote.DirSource.Builder newBuilder() {
    return new converTor.encoders.java.relayVote.DirSource.Builder();
  }
  
  /**
   * Creates a new DirSource RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DirSource RecordBuilder
   */
  public static converTor.encoders.java.relayVote.DirSource.Builder newBuilder(converTor.encoders.java.relayVote.DirSource.Builder other) {
    return new converTor.encoders.java.relayVote.DirSource.Builder(other);
  }
  
  /**
   * Creates a new DirSource RecordBuilder by copying an existing DirSource instance.
   * @param other The existing instance to copy.
   * @return A new DirSource RecordBuilder
   */
  public static converTor.encoders.java.relayVote.DirSource.Builder newBuilder(converTor.encoders.java.relayVote.DirSource other) {
    return new converTor.encoders.java.relayVote.DirSource.Builder(other);
  }
  
  /**
   * RecordBuilder for DirSource instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DirSource>
    implements org.apache.avro.data.RecordBuilder<DirSource> {

    /** metrics-lib/RelayNetworkStatusVote: String getNickname() */
    private java.lang.String nickname;
    /** metrics-lib/RelayNetworkStatusVote: String getIdentity( */
    private java.lang.String identity;
    /** metrics-lib/RelayNetworkStatusVote: String getHostname() */
    private java.lang.String hostname;
    /** metrics-lib/RelayNetworkStatusVote: String getAddress() */
    private java.lang.String address;
    /** metrics-lib/RelayNetworkStatusVote: int getDirport() */
    private java.lang.Integer dir_port;
    /** metrics-lib/RelayNetworkStatusVote: int getOrport() */
    private java.lang.Integer or_port;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.encoders.java.relayVote.DirSource.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.encoders.java.relayVote.DirSource.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.nickname)) {
        this.nickname = data().deepCopy(fields()[0].schema(), other.nickname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.identity)) {
        this.identity = data().deepCopy(fields()[1].schema(), other.identity);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.hostname)) {
        this.hostname = data().deepCopy(fields()[2].schema(), other.hostname);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.address)) {
        this.address = data().deepCopy(fields()[3].schema(), other.address);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.dir_port)) {
        this.dir_port = data().deepCopy(fields()[4].schema(), other.dir_port);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.or_port)) {
        this.or_port = data().deepCopy(fields()[5].schema(), other.or_port);
        fieldSetFlags()[5] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing DirSource instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.encoders.java.relayVote.DirSource other) {
            super(converTor.encoders.java.relayVote.DirSource.SCHEMA$);
      if (isValidValue(fields()[0], other.nickname)) {
        this.nickname = data().deepCopy(fields()[0].schema(), other.nickname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.identity)) {
        this.identity = data().deepCopy(fields()[1].schema(), other.identity);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.hostname)) {
        this.hostname = data().deepCopy(fields()[2].schema(), other.hostname);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.address)) {
        this.address = data().deepCopy(fields()[3].schema(), other.address);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.dir_port)) {
        this.dir_port = data().deepCopy(fields()[4].schema(), other.dir_port);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.or_port)) {
        this.or_port = data().deepCopy(fields()[5].schema(), other.or_port);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'nickname' field.
      * metrics-lib/RelayNetworkStatusVote: String getNickname()
      * @return The value.
      */
    public java.lang.String getNickname() {
      return nickname;
    }

    /**
      * Sets the value of the 'nickname' field.
      * metrics-lib/RelayNetworkStatusVote: String getNickname()
      * @param value The value of 'nickname'.
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder setNickname(java.lang.String value) {
      validate(fields()[0], value);
      this.nickname = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'nickname' field has been set.
      * metrics-lib/RelayNetworkStatusVote: String getNickname()
      * @return True if the 'nickname' field has been set, false otherwise.
      */
    public boolean hasNickname() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'nickname' field.
      * metrics-lib/RelayNetworkStatusVote: String getNickname()
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder clearNickname() {
      nickname = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'identity' field.
      * metrics-lib/RelayNetworkStatusVote: String getIdentity(
      * @return The value.
      */
    public java.lang.String getIdentity() {
      return identity;
    }

    /**
      * Sets the value of the 'identity' field.
      * metrics-lib/RelayNetworkStatusVote: String getIdentity(
      * @param value The value of 'identity'.
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder setIdentity(java.lang.String value) {
      validate(fields()[1], value);
      this.identity = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'identity' field has been set.
      * metrics-lib/RelayNetworkStatusVote: String getIdentity(
      * @return True if the 'identity' field has been set, false otherwise.
      */
    public boolean hasIdentity() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'identity' field.
      * metrics-lib/RelayNetworkStatusVote: String getIdentity(
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder clearIdentity() {
      identity = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'hostname' field.
      * metrics-lib/RelayNetworkStatusVote: String getHostname()
      * @return The value.
      */
    public java.lang.String getHostname() {
      return hostname;
    }

    /**
      * Sets the value of the 'hostname' field.
      * metrics-lib/RelayNetworkStatusVote: String getHostname()
      * @param value The value of 'hostname'.
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder setHostname(java.lang.String value) {
      validate(fields()[2], value);
      this.hostname = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'hostname' field has been set.
      * metrics-lib/RelayNetworkStatusVote: String getHostname()
      * @return True if the 'hostname' field has been set, false otherwise.
      */
    public boolean hasHostname() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'hostname' field.
      * metrics-lib/RelayNetworkStatusVote: String getHostname()
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder clearHostname() {
      hostname = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'address' field.
      * metrics-lib/RelayNetworkStatusVote: String getAddress()
      * @return The value.
      */
    public java.lang.String getAddress() {
      return address;
    }

    /**
      * Sets the value of the 'address' field.
      * metrics-lib/RelayNetworkStatusVote: String getAddress()
      * @param value The value of 'address'.
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder setAddress(java.lang.String value) {
      validate(fields()[3], value);
      this.address = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'address' field has been set.
      * metrics-lib/RelayNetworkStatusVote: String getAddress()
      * @return True if the 'address' field has been set, false otherwise.
      */
    public boolean hasAddress() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'address' field.
      * metrics-lib/RelayNetworkStatusVote: String getAddress()
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder clearAddress() {
      address = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'dir_port' field.
      * metrics-lib/RelayNetworkStatusVote: int getDirport()
      * @return The value.
      */
    public java.lang.Integer getDirPort() {
      return dir_port;
    }

    /**
      * Sets the value of the 'dir_port' field.
      * metrics-lib/RelayNetworkStatusVote: int getDirport()
      * @param value The value of 'dir_port'.
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder setDirPort(java.lang.Integer value) {
      validate(fields()[4], value);
      this.dir_port = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'dir_port' field has been set.
      * metrics-lib/RelayNetworkStatusVote: int getDirport()
      * @return True if the 'dir_port' field has been set, false otherwise.
      */
    public boolean hasDirPort() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'dir_port' field.
      * metrics-lib/RelayNetworkStatusVote: int getDirport()
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder clearDirPort() {
      dir_port = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'or_port' field.
      * metrics-lib/RelayNetworkStatusVote: int getOrport()
      * @return The value.
      */
    public java.lang.Integer getOrPort() {
      return or_port;
    }

    /**
      * Sets the value of the 'or_port' field.
      * metrics-lib/RelayNetworkStatusVote: int getOrport()
      * @param value The value of 'or_port'.
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder setOrPort(java.lang.Integer value) {
      validate(fields()[5], value);
      this.or_port = value;
      fieldSetFlags()[5] = true;
      return this; 
    }

    /**
      * Checks whether the 'or_port' field has been set.
      * metrics-lib/RelayNetworkStatusVote: int getOrport()
      * @return True if the 'or_port' field has been set, false otherwise.
      */
    public boolean hasOrPort() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'or_port' field.
      * metrics-lib/RelayNetworkStatusVote: int getOrport()
      * @return This builder.
      */
    public converTor.encoders.java.relayVote.DirSource.Builder clearOrPort() {
      or_port = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public DirSource build() {
      try {
        DirSource record = new DirSource();
        record.nickname = fieldSetFlags()[0] ? this.nickname : (java.lang.String) defaultValue(fields()[0]);
        record.identity = fieldSetFlags()[1] ? this.identity : (java.lang.String) defaultValue(fields()[1]);
        record.hostname = fieldSetFlags()[2] ? this.hostname : (java.lang.String) defaultValue(fields()[2]);
        record.address = fieldSetFlags()[3] ? this.address : (java.lang.String) defaultValue(fields()[3]);
        record.dir_port = fieldSetFlags()[4] ? this.dir_port : (java.lang.Integer) defaultValue(fields()[4]);
        record.or_port = fieldSetFlags()[5] ? this.or_port : (java.lang.Integer) defaultValue(fields()[5]);
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
