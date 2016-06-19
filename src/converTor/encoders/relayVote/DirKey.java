/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package convertor.encoders.relayVote;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DirKey extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4331860813463028289L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DirKey\",\"namespace\":\"convertor.encoders.relayVote\",\"fields\":[{\"name\":\"version\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion()\"},{\"name\":\"dir_key_published\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis()\"},{\"name\":\"dir_key_expires\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion() */
  @Deprecated public java.lang.Integer version;
  /** metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis() */
  @Deprecated public java.lang.Long dir_key_published;
  /** metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis() */
  @Deprecated public java.lang.Long dir_key_expires;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DirKey() {}

  /**
   * All-args constructor.
   * @param version metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion()
   * @param dir_key_published metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis()
   * @param dir_key_expires metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis()
   */
  public DirKey(java.lang.Integer version, java.lang.Long dir_key_published, java.lang.Long dir_key_expires) {
    this.version = version;
    this.dir_key_published = dir_key_published;
    this.dir_key_expires = dir_key_expires;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return version;
    case 1: return dir_key_published;
    case 2: return dir_key_expires;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: version = (java.lang.Integer)value$; break;
    case 1: dir_key_published = (java.lang.Long)value$; break;
    case 2: dir_key_expires = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'version' field.
   * @return metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion()
   */
  public java.lang.Integer getVersion() {
    return version;
  }

  /**
   * Sets the value of the 'version' field.
   * metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion()
   * @param value the value to set.
   */
  public void setVersion(java.lang.Integer value) {
    this.version = value;
  }

  /**
   * Gets the value of the 'dir_key_published' field.
   * @return metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis()
   */
  public java.lang.Long getDirKeyPublished() {
    return dir_key_published;
  }

  /**
   * Sets the value of the 'dir_key_published' field.
   * metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis()
   * @param value the value to set.
   */
  public void setDirKeyPublished(java.lang.Long value) {
    this.dir_key_published = value;
  }

  /**
   * Gets the value of the 'dir_key_expires' field.
   * @return metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis()
   */
  public java.lang.Long getDirKeyExpires() {
    return dir_key_expires;
  }

  /**
   * Sets the value of the 'dir_key_expires' field.
   * metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis()
   * @param value the value to set.
   */
  public void setDirKeyExpires(java.lang.Long value) {
    this.dir_key_expires = value;
  }

  /**
   * Creates a new DirKey RecordBuilder.
   * @return A new DirKey RecordBuilder
   */
  public static convertor.encoders.relayVote.DirKey.Builder newBuilder() {
    return new convertor.encoders.relayVote.DirKey.Builder();
  }
  
  /**
   * Creates a new DirKey RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DirKey RecordBuilder
   */
  public static convertor.encoders.relayVote.DirKey.Builder newBuilder(convertor.encoders.relayVote.DirKey.Builder other) {
    return new convertor.encoders.relayVote.DirKey.Builder(other);
  }
  
  /**
   * Creates a new DirKey RecordBuilder by copying an existing DirKey instance.
   * @param other The existing instance to copy.
   * @return A new DirKey RecordBuilder
   */
  public static convertor.encoders.relayVote.DirKey.Builder newBuilder(convertor.encoders.relayVote.DirKey other) {
    return new convertor.encoders.relayVote.DirKey.Builder(other);
  }
  
  /**
   * RecordBuilder for DirKey instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DirKey>
    implements org.apache.avro.data.RecordBuilder<DirKey> {

    /** metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion() */
    private java.lang.Integer version;
    /** metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis() */
    private java.lang.Long dir_key_published;
    /** metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis() */
    private java.lang.Long dir_key_expires;

    /** Creates a new Builder */
    private Builder() {
      super(convertor.encoders.relayVote.DirKey.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(convertor.encoders.relayVote.DirKey.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.version)) {
        this.version = data().deepCopy(fields()[0].schema(), other.version);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.dir_key_published)) {
        this.dir_key_published = data().deepCopy(fields()[1].schema(), other.dir_key_published);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.dir_key_expires)) {
        this.dir_key_expires = data().deepCopy(fields()[2].schema(), other.dir_key_expires);
        fieldSetFlags()[2] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing DirKey instance
     * @param other The existing instance to copy.
     */
    private Builder(convertor.encoders.relayVote.DirKey other) {
            super(convertor.encoders.relayVote.DirKey.SCHEMA$);
      if (isValidValue(fields()[0], other.version)) {
        this.version = data().deepCopy(fields()[0].schema(), other.version);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.dir_key_published)) {
        this.dir_key_published = data().deepCopy(fields()[1].schema(), other.dir_key_published);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.dir_key_expires)) {
        this.dir_key_expires = data().deepCopy(fields()[2].schema(), other.dir_key_expires);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'version' field.
      * metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion()
      * @return The value.
      */
    public java.lang.Integer getVersion() {
      return version;
    }

    /**
      * Sets the value of the 'version' field.
      * metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion()
      * @param value The value of 'version'.
      * @return This builder.
      */
    public convertor.encoders.relayVote.DirKey.Builder setVersion(java.lang.Integer value) {
      validate(fields()[0], value);
      this.version = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'version' field has been set.
      * metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion()
      * @return True if the 'version' field has been set, false otherwise.
      */
    public boolean hasVersion() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'version' field.
      * metrics-lib/RelayNetworkStatusVote: int getDirKeyCertificateVersion()
      * @return This builder.
      */
    public convertor.encoders.relayVote.DirKey.Builder clearVersion() {
      version = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'dir_key_published' field.
      * metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis()
      * @return The value.
      */
    public java.lang.Long getDirKeyPublished() {
      return dir_key_published;
    }

    /**
      * Sets the value of the 'dir_key_published' field.
      * metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis()
      * @param value The value of 'dir_key_published'.
      * @return This builder.
      */
    public convertor.encoders.relayVote.DirKey.Builder setDirKeyPublished(java.lang.Long value) {
      validate(fields()[1], value);
      this.dir_key_published = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'dir_key_published' field has been set.
      * metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis()
      * @return True if the 'dir_key_published' field has been set, false otherwise.
      */
    public boolean hasDirKeyPublished() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'dir_key_published' field.
      * metrics-lib/RelayNetworkStatusVote: long getDirKeyPublishedMillis()
      * @return This builder.
      */
    public convertor.encoders.relayVote.DirKey.Builder clearDirKeyPublished() {
      dir_key_published = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'dir_key_expires' field.
      * metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis()
      * @return The value.
      */
    public java.lang.Long getDirKeyExpires() {
      return dir_key_expires;
    }

    /**
      * Sets the value of the 'dir_key_expires' field.
      * metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis()
      * @param value The value of 'dir_key_expires'.
      * @return This builder.
      */
    public convertor.encoders.relayVote.DirKey.Builder setDirKeyExpires(java.lang.Long value) {
      validate(fields()[2], value);
      this.dir_key_expires = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'dir_key_expires' field has been set.
      * metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis()
      * @return True if the 'dir_key_expires' field has been set, false otherwise.
      */
    public boolean hasDirKeyExpires() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'dir_key_expires' field.
      * metrics-lib/RelayNetworkStatusVote: long getDirKeyExpiresMillis()
      * @return This builder.
      */
    public convertor.encoders.relayVote.DirKey.Builder clearDirKeyExpires() {
      dir_key_expires = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public DirKey build() {
      try {
        DirKey record = new DirKey();
        record.version = fieldSetFlags()[0] ? this.version : (java.lang.Integer) defaultValue(fields()[0]);
        record.dir_key_published = fieldSetFlags()[1] ? this.dir_key_published : (java.lang.Long) defaultValue(fields()[1]);
        record.dir_key_expires = fieldSetFlags()[2] ? this.dir_key_expires : (java.lang.Long) defaultValue(fields()[2]);
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
