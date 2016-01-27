/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.torproject.metrics.converTor.relayVote;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DirKey extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DirKey\",\"namespace\":\"org.torproject.metrics.converTor.relayVote\",\"fields\":[{\"name\":\"version\",\"type\":[\"null\",\"int\"]},{\"name\":\"dir_key_published\",\"type\":[\"null\",\"string\"]},{\"name\":\"dir_key_expires\",\"type\":[\"null\",\"string\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.Integer version;
  @Deprecated public java.lang.CharSequence dir_key_published;
  @Deprecated public java.lang.CharSequence dir_key_expires;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DirKey() {}

  /**
   * All-args constructor.
   */
  public DirKey(java.lang.Integer version, java.lang.CharSequence dir_key_published, java.lang.CharSequence dir_key_expires) {
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
    case 1: dir_key_published = (java.lang.CharSequence)value$; break;
    case 2: dir_key_expires = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'version' field.
   */
  public java.lang.Integer getVersion() {
    return version;
  }

  /**
   * Sets the value of the 'version' field.
   * @param value the value to set.
   */
  public void setVersion(java.lang.Integer value) {
    this.version = value;
  }

  /**
   * Gets the value of the 'dir_key_published' field.
   */
  public java.lang.CharSequence getDirKeyPublished() {
    return dir_key_published;
  }

  /**
   * Sets the value of the 'dir_key_published' field.
   * @param value the value to set.
   */
  public void setDirKeyPublished(java.lang.CharSequence value) {
    this.dir_key_published = value;
  }

  /**
   * Gets the value of the 'dir_key_expires' field.
   */
  public java.lang.CharSequence getDirKeyExpires() {
    return dir_key_expires;
  }

  /**
   * Sets the value of the 'dir_key_expires' field.
   * @param value the value to set.
   */
  public void setDirKeyExpires(java.lang.CharSequence value) {
    this.dir_key_expires = value;
  }

  /** Creates a new DirKey RecordBuilder */
  public static org.torproject.metrics.converTor.relayVote.DirKey.Builder newBuilder() {
    return new org.torproject.metrics.converTor.relayVote.DirKey.Builder();
  }
  
  /** Creates a new DirKey RecordBuilder by copying an existing Builder */
  public static org.torproject.metrics.converTor.relayVote.DirKey.Builder newBuilder(org.torproject.metrics.converTor.relayVote.DirKey.Builder other) {
    return new org.torproject.metrics.converTor.relayVote.DirKey.Builder(other);
  }
  
  /** Creates a new DirKey RecordBuilder by copying an existing DirKey instance */
  public static org.torproject.metrics.converTor.relayVote.DirKey.Builder newBuilder(org.torproject.metrics.converTor.relayVote.DirKey other) {
    return new org.torproject.metrics.converTor.relayVote.DirKey.Builder(other);
  }
  
  /**
   * RecordBuilder for DirKey instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DirKey>
    implements org.apache.avro.data.RecordBuilder<DirKey> {

    private java.lang.Integer version;
    private java.lang.CharSequence dir_key_published;
    private java.lang.CharSequence dir_key_expires;

    /** Creates a new Builder */
    private Builder() {
      super(org.torproject.metrics.converTor.relayVote.DirKey.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.torproject.metrics.converTor.relayVote.DirKey.Builder other) {
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
    
    /** Creates a Builder by copying an existing DirKey instance */
    private Builder(org.torproject.metrics.converTor.relayVote.DirKey other) {
            super(org.torproject.metrics.converTor.relayVote.DirKey.SCHEMA$);
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

    /** Gets the value of the 'version' field */
    public java.lang.Integer getVersion() {
      return version;
    }
    
    /** Sets the value of the 'version' field */
    public org.torproject.metrics.converTor.relayVote.DirKey.Builder setVersion(java.lang.Integer value) {
      validate(fields()[0], value);
      this.version = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'version' field has been set */
    public boolean hasVersion() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'version' field */
    public org.torproject.metrics.converTor.relayVote.DirKey.Builder clearVersion() {
      version = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'dir_key_published' field */
    public java.lang.CharSequence getDirKeyPublished() {
      return dir_key_published;
    }
    
    /** Sets the value of the 'dir_key_published' field */
    public org.torproject.metrics.converTor.relayVote.DirKey.Builder setDirKeyPublished(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.dir_key_published = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'dir_key_published' field has been set */
    public boolean hasDirKeyPublished() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'dir_key_published' field */
    public org.torproject.metrics.converTor.relayVote.DirKey.Builder clearDirKeyPublished() {
      dir_key_published = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'dir_key_expires' field */
    public java.lang.CharSequence getDirKeyExpires() {
      return dir_key_expires;
    }
    
    /** Sets the value of the 'dir_key_expires' field */
    public org.torproject.metrics.converTor.relayVote.DirKey.Builder setDirKeyExpires(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.dir_key_expires = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'dir_key_expires' field has been set */
    public boolean hasDirKeyExpires() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'dir_key_expires' field */
    public org.torproject.metrics.converTor.relayVote.DirKey.Builder clearDirKeyExpires() {
      dir_key_expires = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public DirKey build() {
      try {
        DirKey record = new DirKey();
        record.version = fieldSetFlags()[0] ? this.version : (java.lang.Integer) defaultValue(fields()[0]);
        record.dir_key_published = fieldSetFlags()[1] ? this.dir_key_published : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.dir_key_expires = fieldSetFlags()[2] ? this.dir_key_expires : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
