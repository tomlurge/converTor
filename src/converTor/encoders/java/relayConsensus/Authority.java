/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.encoders.java.relayConsensus;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Authority extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 3877687095683190932L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Authority\",\"namespace\":\"converTor.encoders.java.relayConsensus\",\"fields\":[{\"name\":\"dir_source\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"DirSource\",\"fields\":[{\"name\":\"nickname\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirSourceEntry: String getNickname()\"},{\"name\":\"identity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirSourceEntry: String getIdentity()\"},{\"name\":\"hostname\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirSourceEntry: String getHostname()\"},{\"name\":\"address\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirSourceEntry: String getIp()\"},{\"name\":\"dir_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/DirSourceEntry: int getDirPort()\"},{\"name\":\"or_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/DirSourceEntry: int getOrPort()\"},{\"name\":\"is_legacy\",\"type\":[\"null\",\"boolean\"],\"doc\":\"metrics-lib/DirSourceEntry: boolean isLegacy()\"}]}]},{\"name\":\"contact\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirSourceEntry: String getContactLine()\"},{\"name\":\"vote_digest\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirSourceEntry: String getVoteDigest()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public converTor.encoders.java.relayConsensus.DirSource dir_source;
  /** metrics-lib/DirSourceEntry: String getContactLine() */
  @Deprecated public java.lang.String contact;
  /** metrics-lib/DirSourceEntry: String getVoteDigest() */
  @Deprecated public java.lang.String vote_digest;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Authority() {}

  /**
   * All-args constructor.
   * @param contact metrics-lib/DirSourceEntry: String getContactLine()
   * @param vote_digest metrics-lib/DirSourceEntry: String getVoteDigest()
   */
  public Authority(converTor.encoders.java.relayConsensus.DirSource dir_source, java.lang.String contact, java.lang.String vote_digest) {
    this.dir_source = dir_source;
    this.contact = contact;
    this.vote_digest = vote_digest;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return dir_source;
    case 1: return contact;
    case 2: return vote_digest;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: dir_source = (converTor.encoders.java.relayConsensus.DirSource)value$; break;
    case 1: contact = (java.lang.String)value$; break;
    case 2: vote_digest = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'dir_source' field.
   */
  public converTor.encoders.java.relayConsensus.DirSource getDirSource() {
    return dir_source;
  }

  /**
   * Sets the value of the 'dir_source' field.
   * @param value the value to set.
   */
  public void setDirSource(converTor.encoders.java.relayConsensus.DirSource value) {
    this.dir_source = value;
  }

  /**
   * Gets the value of the 'contact' field.
   * @return metrics-lib/DirSourceEntry: String getContactLine()
   */
  public java.lang.String getContact() {
    return contact;
  }

  /**
   * Sets the value of the 'contact' field.
   * metrics-lib/DirSourceEntry: String getContactLine()
   * @param value the value to set.
   */
  public void setContact(java.lang.String value) {
    this.contact = value;
  }

  /**
   * Gets the value of the 'vote_digest' field.
   * @return metrics-lib/DirSourceEntry: String getVoteDigest()
   */
  public java.lang.String getVoteDigest() {
    return vote_digest;
  }

  /**
   * Sets the value of the 'vote_digest' field.
   * metrics-lib/DirSourceEntry: String getVoteDigest()
   * @param value the value to set.
   */
  public void setVoteDigest(java.lang.String value) {
    this.vote_digest = value;
  }

  /**
   * Creates a new Authority RecordBuilder.
   * @return A new Authority RecordBuilder
   */
  public static converTor.encoders.java.relayConsensus.Authority.Builder newBuilder() {
    return new converTor.encoders.java.relayConsensus.Authority.Builder();
  }
  
  /**
   * Creates a new Authority RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Authority RecordBuilder
   */
  public static converTor.encoders.java.relayConsensus.Authority.Builder newBuilder(converTor.encoders.java.relayConsensus.Authority.Builder other) {
    return new converTor.encoders.java.relayConsensus.Authority.Builder(other);
  }
  
  /**
   * Creates a new Authority RecordBuilder by copying an existing Authority instance.
   * @param other The existing instance to copy.
   * @return A new Authority RecordBuilder
   */
  public static converTor.encoders.java.relayConsensus.Authority.Builder newBuilder(converTor.encoders.java.relayConsensus.Authority other) {
    return new converTor.encoders.java.relayConsensus.Authority.Builder(other);
  }
  
  /**
   * RecordBuilder for Authority instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Authority>
    implements org.apache.avro.data.RecordBuilder<Authority> {

    private converTor.encoders.java.relayConsensus.DirSource dir_source;
    private converTor.encoders.java.relayConsensus.DirSource.Builder dir_sourceBuilder;
    /** metrics-lib/DirSourceEntry: String getContactLine() */
    private java.lang.String contact;
    /** metrics-lib/DirSourceEntry: String getVoteDigest() */
    private java.lang.String vote_digest;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.encoders.java.relayConsensus.Authority.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.encoders.java.relayConsensus.Authority.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.dir_source)) {
        this.dir_source = data().deepCopy(fields()[0].schema(), other.dir_source);
        fieldSetFlags()[0] = true;
      }
      if (other.hasDirSourceBuilder()) {
        this.dir_sourceBuilder = converTor.encoders.java.relayConsensus.DirSource.newBuilder(other.getDirSourceBuilder());
      }
      if (isValidValue(fields()[1], other.contact)) {
        this.contact = data().deepCopy(fields()[1].schema(), other.contact);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.vote_digest)) {
        this.vote_digest = data().deepCopy(fields()[2].schema(), other.vote_digest);
        fieldSetFlags()[2] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing Authority instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.encoders.java.relayConsensus.Authority other) {
            super(converTor.encoders.java.relayConsensus.Authority.SCHEMA$);
      if (isValidValue(fields()[0], other.dir_source)) {
        this.dir_source = data().deepCopy(fields()[0].schema(), other.dir_source);
        fieldSetFlags()[0] = true;
      }
      this.dir_sourceBuilder = null;
      if (isValidValue(fields()[1], other.contact)) {
        this.contact = data().deepCopy(fields()[1].schema(), other.contact);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.vote_digest)) {
        this.vote_digest = data().deepCopy(fields()[2].schema(), other.vote_digest);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'dir_source' field.
      * @return The value.
      */
    public converTor.encoders.java.relayConsensus.DirSource getDirSource() {
      return dir_source;
    }

    /**
      * Sets the value of the 'dir_source' field.
      * @param value The value of 'dir_source'.
      * @return This builder.
      */
    public converTor.encoders.java.relayConsensus.Authority.Builder setDirSource(converTor.encoders.java.relayConsensus.DirSource value) {
      validate(fields()[0], value);
      this.dir_sourceBuilder = null;
      this.dir_source = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'dir_source' field has been set.
      * @return True if the 'dir_source' field has been set, false otherwise.
      */
    public boolean hasDirSource() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'dir_source' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public converTor.encoders.java.relayConsensus.DirSource.Builder getDirSourceBuilder() {
      if (dir_sourceBuilder == null) {
        if (hasDirSource()) {
          setDirSourceBuilder(converTor.encoders.java.relayConsensus.DirSource.newBuilder(dir_source));
        } else {
          setDirSourceBuilder(converTor.encoders.java.relayConsensus.DirSource.newBuilder());
        }
      }
      return dir_sourceBuilder;
    }

    /**
     * Sets the Builder instance for the 'dir_source' field
     * @return This builder.
     */
    public converTor.encoders.java.relayConsensus.Authority.Builder setDirSourceBuilder(converTor.encoders.java.relayConsensus.DirSource.Builder value) {
      clearDirSource();
      dir_sourceBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'dir_source' field has an active Builder instance
     * @return True if the 'dir_source' field has an active Builder instance
     */
    public boolean hasDirSourceBuilder() {
      return dir_sourceBuilder != null;
    }

    /**
      * Clears the value of the 'dir_source' field.
      * @return This builder.
      */
    public converTor.encoders.java.relayConsensus.Authority.Builder clearDirSource() {
      dir_source = null;
      dir_sourceBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'contact' field.
      * metrics-lib/DirSourceEntry: String getContactLine()
      * @return The value.
      */
    public java.lang.String getContact() {
      return contact;
    }

    /**
      * Sets the value of the 'contact' field.
      * metrics-lib/DirSourceEntry: String getContactLine()
      * @param value The value of 'contact'.
      * @return This builder.
      */
    public converTor.encoders.java.relayConsensus.Authority.Builder setContact(java.lang.String value) {
      validate(fields()[1], value);
      this.contact = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'contact' field has been set.
      * metrics-lib/DirSourceEntry: String getContactLine()
      * @return True if the 'contact' field has been set, false otherwise.
      */
    public boolean hasContact() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'contact' field.
      * metrics-lib/DirSourceEntry: String getContactLine()
      * @return This builder.
      */
    public converTor.encoders.java.relayConsensus.Authority.Builder clearContact() {
      contact = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'vote_digest' field.
      * metrics-lib/DirSourceEntry: String getVoteDigest()
      * @return The value.
      */
    public java.lang.String getVoteDigest() {
      return vote_digest;
    }

    /**
      * Sets the value of the 'vote_digest' field.
      * metrics-lib/DirSourceEntry: String getVoteDigest()
      * @param value The value of 'vote_digest'.
      * @return This builder.
      */
    public converTor.encoders.java.relayConsensus.Authority.Builder setVoteDigest(java.lang.String value) {
      validate(fields()[2], value);
      this.vote_digest = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'vote_digest' field has been set.
      * metrics-lib/DirSourceEntry: String getVoteDigest()
      * @return True if the 'vote_digest' field has been set, false otherwise.
      */
    public boolean hasVoteDigest() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'vote_digest' field.
      * metrics-lib/DirSourceEntry: String getVoteDigest()
      * @return This builder.
      */
    public converTor.encoders.java.relayConsensus.Authority.Builder clearVoteDigest() {
      vote_digest = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public Authority build() {
      try {
        Authority record = new Authority();
        if (dir_sourceBuilder != null) {
          record.dir_source = this.dir_sourceBuilder.build();
        } else {
          record.dir_source = fieldSetFlags()[0] ? this.dir_source : (converTor.encoders.java.relayConsensus.DirSource) defaultValue(fields()[0]);
        }
        record.contact = fieldSetFlags()[1] ? this.contact : (java.lang.String) defaultValue(fields()[1]);
        record.vote_digest = fieldSetFlags()[2] ? this.vote_digest : (java.lang.String) defaultValue(fields()[2]);
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
