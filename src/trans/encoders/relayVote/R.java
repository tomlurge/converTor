/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package trans.encoders.relayVote;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class R extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4214729391511958933L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"R\",\"namespace\":\"trans.encoders.relayVote\",\"fields\":[{\"name\":\"nickname\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getNickname()\"},{\"name\":\"identity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getFingerprint()\"},{\"name\":\"digest\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getDescriptor()\"},{\"name\":\"publication\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/NetworkStatusEntry: long getPublishedMillis()\"},{\"name\":\"ip\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getAddress()\"},{\"name\":\"or_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/NetworkStatusEntry: int getOrPort()\"},{\"name\":\"dir_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/NetworkStatusEntry: int getDirPort()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/NetworkStatusEntry: String getNickname() */
  @Deprecated public java.lang.String nickname;
  /** metrics-lib/NetworkStatusEntry: String getFingerprint() */
  @Deprecated public java.lang.String identity;
  /** metrics-lib/NetworkStatusEntry: String getDescriptor() */
  @Deprecated public java.lang.String digest;
  /** metrics-lib/NetworkStatusEntry: long getPublishedMillis() */
  @Deprecated public java.lang.Long publication;
  /** metrics-lib/NetworkStatusEntry: String getAddress() */
  @Deprecated public java.lang.String ip;
  /** metrics-lib/NetworkStatusEntry: int getOrPort() */
  @Deprecated public java.lang.Integer or_port;
  /** metrics-lib/NetworkStatusEntry: int getDirPort() */
  @Deprecated public java.lang.Integer dir_port;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public R() {}

  /**
   * All-args constructor.
   * @param nickname metrics-lib/NetworkStatusEntry: String getNickname()
   * @param identity metrics-lib/NetworkStatusEntry: String getFingerprint()
   * @param digest metrics-lib/NetworkStatusEntry: String getDescriptor()
   * @param publication metrics-lib/NetworkStatusEntry: long getPublishedMillis()
   * @param ip metrics-lib/NetworkStatusEntry: String getAddress()
   * @param or_port metrics-lib/NetworkStatusEntry: int getOrPort()
   * @param dir_port metrics-lib/NetworkStatusEntry: int getDirPort()
   */
  public R(java.lang.String nickname, java.lang.String identity, java.lang.String digest, java.lang.Long publication, java.lang.String ip, java.lang.Integer or_port, java.lang.Integer dir_port) {
    this.nickname = nickname;
    this.identity = identity;
    this.digest = digest;
    this.publication = publication;
    this.ip = ip;
    this.or_port = or_port;
    this.dir_port = dir_port;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return nickname;
    case 1: return identity;
    case 2: return digest;
    case 3: return publication;
    case 4: return ip;
    case 5: return or_port;
    case 6: return dir_port;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: nickname = (java.lang.String)value$; break;
    case 1: identity = (java.lang.String)value$; break;
    case 2: digest = (java.lang.String)value$; break;
    case 3: publication = (java.lang.Long)value$; break;
    case 4: ip = (java.lang.String)value$; break;
    case 5: or_port = (java.lang.Integer)value$; break;
    case 6: dir_port = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'nickname' field.
   * @return metrics-lib/NetworkStatusEntry: String getNickname()
   */
  public java.lang.String getNickname() {
    return nickname;
  }

  /**
   * Sets the value of the 'nickname' field.
   * metrics-lib/NetworkStatusEntry: String getNickname()
   * @param value the value to set.
   */
  public void setNickname(java.lang.String value) {
    this.nickname = value;
  }

  /**
   * Gets the value of the 'identity' field.
   * @return metrics-lib/NetworkStatusEntry: String getFingerprint()
   */
  public java.lang.String getIdentity() {
    return identity;
  }

  /**
   * Sets the value of the 'identity' field.
   * metrics-lib/NetworkStatusEntry: String getFingerprint()
   * @param value the value to set.
   */
  public void setIdentity(java.lang.String value) {
    this.identity = value;
  }

  /**
   * Gets the value of the 'digest' field.
   * @return metrics-lib/NetworkStatusEntry: String getDescriptor()
   */
  public java.lang.String getDigest() {
    return digest;
  }

  /**
   * Sets the value of the 'digest' field.
   * metrics-lib/NetworkStatusEntry: String getDescriptor()
   * @param value the value to set.
   */
  public void setDigest(java.lang.String value) {
    this.digest = value;
  }

  /**
   * Gets the value of the 'publication' field.
   * @return metrics-lib/NetworkStatusEntry: long getPublishedMillis()
   */
  public java.lang.Long getPublication() {
    return publication;
  }

  /**
   * Sets the value of the 'publication' field.
   * metrics-lib/NetworkStatusEntry: long getPublishedMillis()
   * @param value the value to set.
   */
  public void setPublication(java.lang.Long value) {
    this.publication = value;
  }

  /**
   * Gets the value of the 'ip' field.
   * @return metrics-lib/NetworkStatusEntry: String getAddress()
   */
  public java.lang.String getIp() {
    return ip;
  }

  /**
   * Sets the value of the 'ip' field.
   * metrics-lib/NetworkStatusEntry: String getAddress()
   * @param value the value to set.
   */
  public void setIp(java.lang.String value) {
    this.ip = value;
  }

  /**
   * Gets the value of the 'or_port' field.
   * @return metrics-lib/NetworkStatusEntry: int getOrPort()
   */
  public java.lang.Integer getOrPort() {
    return or_port;
  }

  /**
   * Sets the value of the 'or_port' field.
   * metrics-lib/NetworkStatusEntry: int getOrPort()
   * @param value the value to set.
   */
  public void setOrPort(java.lang.Integer value) {
    this.or_port = value;
  }

  /**
   * Gets the value of the 'dir_port' field.
   * @return metrics-lib/NetworkStatusEntry: int getDirPort()
   */
  public java.lang.Integer getDirPort() {
    return dir_port;
  }

  /**
   * Sets the value of the 'dir_port' field.
   * metrics-lib/NetworkStatusEntry: int getDirPort()
   * @param value the value to set.
   */
  public void setDirPort(java.lang.Integer value) {
    this.dir_port = value;
  }

  /**
   * Creates a new R RecordBuilder.
   * @return A new R RecordBuilder
   */
  public static trans.encoders.relayVote.R.Builder newBuilder() {
    return new trans.encoders.relayVote.R.Builder();
  }
  
  /**
   * Creates a new R RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new R RecordBuilder
   */
  public static trans.encoders.relayVote.R.Builder newBuilder(trans.encoders.relayVote.R.Builder other) {
    return new trans.encoders.relayVote.R.Builder(other);
  }
  
  /**
   * Creates a new R RecordBuilder by copying an existing R instance.
   * @param other The existing instance to copy.
   * @return A new R RecordBuilder
   */
  public static trans.encoders.relayVote.R.Builder newBuilder(trans.encoders.relayVote.R other) {
    return new trans.encoders.relayVote.R.Builder(other);
  }
  
  /**
   * RecordBuilder for R instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<R>
    implements org.apache.avro.data.RecordBuilder<R> {

    /** metrics-lib/NetworkStatusEntry: String getNickname() */
    private java.lang.String nickname;
    /** metrics-lib/NetworkStatusEntry: String getFingerprint() */
    private java.lang.String identity;
    /** metrics-lib/NetworkStatusEntry: String getDescriptor() */
    private java.lang.String digest;
    /** metrics-lib/NetworkStatusEntry: long getPublishedMillis() */
    private java.lang.Long publication;
    /** metrics-lib/NetworkStatusEntry: String getAddress() */
    private java.lang.String ip;
    /** metrics-lib/NetworkStatusEntry: int getOrPort() */
    private java.lang.Integer or_port;
    /** metrics-lib/NetworkStatusEntry: int getDirPort() */
    private java.lang.Integer dir_port;

    /** Creates a new Builder */
    private Builder() {
      super(trans.encoders.relayVote.R.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(trans.encoders.relayVote.R.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.nickname)) {
        this.nickname = data().deepCopy(fields()[0].schema(), other.nickname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.identity)) {
        this.identity = data().deepCopy(fields()[1].schema(), other.identity);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.digest)) {
        this.digest = data().deepCopy(fields()[2].schema(), other.digest);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.publication)) {
        this.publication = data().deepCopy(fields()[3].schema(), other.publication);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ip)) {
        this.ip = data().deepCopy(fields()[4].schema(), other.ip);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.or_port)) {
        this.or_port = data().deepCopy(fields()[5].schema(), other.or_port);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.dir_port)) {
        this.dir_port = data().deepCopy(fields()[6].schema(), other.dir_port);
        fieldSetFlags()[6] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing R instance
     * @param other The existing instance to copy.
     */
    private Builder(trans.encoders.relayVote.R other) {
            super(trans.encoders.relayVote.R.SCHEMA$);
      if (isValidValue(fields()[0], other.nickname)) {
        this.nickname = data().deepCopy(fields()[0].schema(), other.nickname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.identity)) {
        this.identity = data().deepCopy(fields()[1].schema(), other.identity);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.digest)) {
        this.digest = data().deepCopy(fields()[2].schema(), other.digest);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.publication)) {
        this.publication = data().deepCopy(fields()[3].schema(), other.publication);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ip)) {
        this.ip = data().deepCopy(fields()[4].schema(), other.ip);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.or_port)) {
        this.or_port = data().deepCopy(fields()[5].schema(), other.or_port);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.dir_port)) {
        this.dir_port = data().deepCopy(fields()[6].schema(), other.dir_port);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'nickname' field.
      * metrics-lib/NetworkStatusEntry: String getNickname()
      * @return The value.
      */
    public java.lang.String getNickname() {
      return nickname;
    }

    /**
      * Sets the value of the 'nickname' field.
      * metrics-lib/NetworkStatusEntry: String getNickname()
      * @param value The value of 'nickname'.
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder setNickname(java.lang.String value) {
      validate(fields()[0], value);
      this.nickname = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'nickname' field has been set.
      * metrics-lib/NetworkStatusEntry: String getNickname()
      * @return True if the 'nickname' field has been set, false otherwise.
      */
    public boolean hasNickname() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'nickname' field.
      * metrics-lib/NetworkStatusEntry: String getNickname()
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder clearNickname() {
      nickname = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'identity' field.
      * metrics-lib/NetworkStatusEntry: String getFingerprint()
      * @return The value.
      */
    public java.lang.String getIdentity() {
      return identity;
    }

    /**
      * Sets the value of the 'identity' field.
      * metrics-lib/NetworkStatusEntry: String getFingerprint()
      * @param value The value of 'identity'.
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder setIdentity(java.lang.String value) {
      validate(fields()[1], value);
      this.identity = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'identity' field has been set.
      * metrics-lib/NetworkStatusEntry: String getFingerprint()
      * @return True if the 'identity' field has been set, false otherwise.
      */
    public boolean hasIdentity() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'identity' field.
      * metrics-lib/NetworkStatusEntry: String getFingerprint()
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder clearIdentity() {
      identity = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'digest' field.
      * metrics-lib/NetworkStatusEntry: String getDescriptor()
      * @return The value.
      */
    public java.lang.String getDigest() {
      return digest;
    }

    /**
      * Sets the value of the 'digest' field.
      * metrics-lib/NetworkStatusEntry: String getDescriptor()
      * @param value The value of 'digest'.
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder setDigest(java.lang.String value) {
      validate(fields()[2], value);
      this.digest = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'digest' field has been set.
      * metrics-lib/NetworkStatusEntry: String getDescriptor()
      * @return True if the 'digest' field has been set, false otherwise.
      */
    public boolean hasDigest() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'digest' field.
      * metrics-lib/NetworkStatusEntry: String getDescriptor()
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder clearDigest() {
      digest = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'publication' field.
      * metrics-lib/NetworkStatusEntry: long getPublishedMillis()
      * @return The value.
      */
    public java.lang.Long getPublication() {
      return publication;
    }

    /**
      * Sets the value of the 'publication' field.
      * metrics-lib/NetworkStatusEntry: long getPublishedMillis()
      * @param value The value of 'publication'.
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder setPublication(java.lang.Long value) {
      validate(fields()[3], value);
      this.publication = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'publication' field has been set.
      * metrics-lib/NetworkStatusEntry: long getPublishedMillis()
      * @return True if the 'publication' field has been set, false otherwise.
      */
    public boolean hasPublication() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'publication' field.
      * metrics-lib/NetworkStatusEntry: long getPublishedMillis()
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder clearPublication() {
      publication = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ip' field.
      * metrics-lib/NetworkStatusEntry: String getAddress()
      * @return The value.
      */
    public java.lang.String getIp() {
      return ip;
    }

    /**
      * Sets the value of the 'ip' field.
      * metrics-lib/NetworkStatusEntry: String getAddress()
      * @param value The value of 'ip'.
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder setIp(java.lang.String value) {
      validate(fields()[4], value);
      this.ip = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'ip' field has been set.
      * metrics-lib/NetworkStatusEntry: String getAddress()
      * @return True if the 'ip' field has been set, false otherwise.
      */
    public boolean hasIp() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ip' field.
      * metrics-lib/NetworkStatusEntry: String getAddress()
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder clearIp() {
      ip = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'or_port' field.
      * metrics-lib/NetworkStatusEntry: int getOrPort()
      * @return The value.
      */
    public java.lang.Integer getOrPort() {
      return or_port;
    }

    /**
      * Sets the value of the 'or_port' field.
      * metrics-lib/NetworkStatusEntry: int getOrPort()
      * @param value The value of 'or_port'.
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder setOrPort(java.lang.Integer value) {
      validate(fields()[5], value);
      this.or_port = value;
      fieldSetFlags()[5] = true;
      return this; 
    }

    /**
      * Checks whether the 'or_port' field has been set.
      * metrics-lib/NetworkStatusEntry: int getOrPort()
      * @return True if the 'or_port' field has been set, false otherwise.
      */
    public boolean hasOrPort() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'or_port' field.
      * metrics-lib/NetworkStatusEntry: int getOrPort()
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder clearOrPort() {
      or_port = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'dir_port' field.
      * metrics-lib/NetworkStatusEntry: int getDirPort()
      * @return The value.
      */
    public java.lang.Integer getDirPort() {
      return dir_port;
    }

    /**
      * Sets the value of the 'dir_port' field.
      * metrics-lib/NetworkStatusEntry: int getDirPort()
      * @param value The value of 'dir_port'.
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder setDirPort(java.lang.Integer value) {
      validate(fields()[6], value);
      this.dir_port = value;
      fieldSetFlags()[6] = true;
      return this; 
    }

    /**
      * Checks whether the 'dir_port' field has been set.
      * metrics-lib/NetworkStatusEntry: int getDirPort()
      * @return True if the 'dir_port' field has been set, false otherwise.
      */
    public boolean hasDirPort() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'dir_port' field.
      * metrics-lib/NetworkStatusEntry: int getDirPort()
      * @return This builder.
      */
    public trans.encoders.relayVote.R.Builder clearDirPort() {
      dir_port = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    public R build() {
      try {
        R record = new R();
        record.nickname = fieldSetFlags()[0] ? this.nickname : (java.lang.String) defaultValue(fields()[0]);
        record.identity = fieldSetFlags()[1] ? this.identity : (java.lang.String) defaultValue(fields()[1]);
        record.digest = fieldSetFlags()[2] ? this.digest : (java.lang.String) defaultValue(fields()[2]);
        record.publication = fieldSetFlags()[3] ? this.publication : (java.lang.Long) defaultValue(fields()[3]);
        record.ip = fieldSetFlags()[4] ? this.ip : (java.lang.String) defaultValue(fields()[4]);
        record.or_port = fieldSetFlags()[5] ? this.or_port : (java.lang.Integer) defaultValue(fields()[5]);
        record.dir_port = fieldSetFlags()[6] ? this.dir_port : (java.lang.Integer) defaultValue(fields()[6]);
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
