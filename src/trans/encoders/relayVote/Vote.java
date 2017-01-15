/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package trans.encoders.relayVote;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Vote extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2043170774354214405L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Vote\",\"namespace\":\"trans.encoders.relayVote\",\"fields\":[{\"name\":\"vote_seconds\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/RelayNetworkStatusVote: long getVoteSeconds()\"},{\"name\":\"dist_seconds\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/RelayNetworkStatusVote: long getDistSeconds()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/RelayNetworkStatusVote: long getVoteSeconds() */
  @Deprecated public java.lang.Long vote_seconds;
  /** metrics-lib/RelayNetworkStatusVote: long getDistSeconds() */
  @Deprecated public java.lang.Long dist_seconds;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Vote() {}

  /**
   * All-args constructor.
   * @param vote_seconds metrics-lib/RelayNetworkStatusVote: long getVoteSeconds()
   * @param dist_seconds metrics-lib/RelayNetworkStatusVote: long getDistSeconds()
   */
  public Vote(java.lang.Long vote_seconds, java.lang.Long dist_seconds) {
    this.vote_seconds = vote_seconds;
    this.dist_seconds = dist_seconds;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return vote_seconds;
    case 1: return dist_seconds;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: vote_seconds = (java.lang.Long)value$; break;
    case 1: dist_seconds = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'vote_seconds' field.
   * @return metrics-lib/RelayNetworkStatusVote: long getVoteSeconds()
   */
  public java.lang.Long getVoteSeconds() {
    return vote_seconds;
  }

  /**
   * Sets the value of the 'vote_seconds' field.
   * metrics-lib/RelayNetworkStatusVote: long getVoteSeconds()
   * @param value the value to set.
   */
  public void setVoteSeconds(java.lang.Long value) {
    this.vote_seconds = value;
  }

  /**
   * Gets the value of the 'dist_seconds' field.
   * @return metrics-lib/RelayNetworkStatusVote: long getDistSeconds()
   */
  public java.lang.Long getDistSeconds() {
    return dist_seconds;
  }

  /**
   * Sets the value of the 'dist_seconds' field.
   * metrics-lib/RelayNetworkStatusVote: long getDistSeconds()
   * @param value the value to set.
   */
  public void setDistSeconds(java.lang.Long value) {
    this.dist_seconds = value;
  }

  /**
   * Creates a new Vote RecordBuilder.
   * @return A new Vote RecordBuilder
   */
  public static trans.encoders.relayVote.Vote.Builder newBuilder() {
    return new trans.encoders.relayVote.Vote.Builder();
  }
  
  /**
   * Creates a new Vote RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Vote RecordBuilder
   */
  public static trans.encoders.relayVote.Vote.Builder newBuilder(trans.encoders.relayVote.Vote.Builder other) {
    return new trans.encoders.relayVote.Vote.Builder(other);
  }
  
  /**
   * Creates a new Vote RecordBuilder by copying an existing Vote instance.
   * @param other The existing instance to copy.
   * @return A new Vote RecordBuilder
   */
  public static trans.encoders.relayVote.Vote.Builder newBuilder(trans.encoders.relayVote.Vote other) {
    return new trans.encoders.relayVote.Vote.Builder(other);
  }
  
  /**
   * RecordBuilder for Vote instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Vote>
    implements org.apache.avro.data.RecordBuilder<Vote> {

    /** metrics-lib/RelayNetworkStatusVote: long getVoteSeconds() */
    private java.lang.Long vote_seconds;
    /** metrics-lib/RelayNetworkStatusVote: long getDistSeconds() */
    private java.lang.Long dist_seconds;

    /** Creates a new Builder */
    private Builder() {
      super(trans.encoders.relayVote.Vote.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(trans.encoders.relayVote.Vote.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.vote_seconds)) {
        this.vote_seconds = data().deepCopy(fields()[0].schema(), other.vote_seconds);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.dist_seconds)) {
        this.dist_seconds = data().deepCopy(fields()[1].schema(), other.dist_seconds);
        fieldSetFlags()[1] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing Vote instance
     * @param other The existing instance to copy.
     */
    private Builder(trans.encoders.relayVote.Vote other) {
            super(trans.encoders.relayVote.Vote.SCHEMA$);
      if (isValidValue(fields()[0], other.vote_seconds)) {
        this.vote_seconds = data().deepCopy(fields()[0].schema(), other.vote_seconds);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.dist_seconds)) {
        this.dist_seconds = data().deepCopy(fields()[1].schema(), other.dist_seconds);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'vote_seconds' field.
      * metrics-lib/RelayNetworkStatusVote: long getVoteSeconds()
      * @return The value.
      */
    public java.lang.Long getVoteSeconds() {
      return vote_seconds;
    }

    /**
      * Sets the value of the 'vote_seconds' field.
      * metrics-lib/RelayNetworkStatusVote: long getVoteSeconds()
      * @param value The value of 'vote_seconds'.
      * @return This builder.
      */
    public trans.encoders.relayVote.Vote.Builder setVoteSeconds(java.lang.Long value) {
      validate(fields()[0], value);
      this.vote_seconds = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'vote_seconds' field has been set.
      * metrics-lib/RelayNetworkStatusVote: long getVoteSeconds()
      * @return True if the 'vote_seconds' field has been set, false otherwise.
      */
    public boolean hasVoteSeconds() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'vote_seconds' field.
      * metrics-lib/RelayNetworkStatusVote: long getVoteSeconds()
      * @return This builder.
      */
    public trans.encoders.relayVote.Vote.Builder clearVoteSeconds() {
      vote_seconds = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'dist_seconds' field.
      * metrics-lib/RelayNetworkStatusVote: long getDistSeconds()
      * @return The value.
      */
    public java.lang.Long getDistSeconds() {
      return dist_seconds;
    }

    /**
      * Sets the value of the 'dist_seconds' field.
      * metrics-lib/RelayNetworkStatusVote: long getDistSeconds()
      * @param value The value of 'dist_seconds'.
      * @return This builder.
      */
    public trans.encoders.relayVote.Vote.Builder setDistSeconds(java.lang.Long value) {
      validate(fields()[1], value);
      this.dist_seconds = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'dist_seconds' field has been set.
      * metrics-lib/RelayNetworkStatusVote: long getDistSeconds()
      * @return True if the 'dist_seconds' field has been set, false otherwise.
      */
    public boolean hasDistSeconds() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'dist_seconds' field.
      * metrics-lib/RelayNetworkStatusVote: long getDistSeconds()
      * @return This builder.
      */
    public trans.encoders.relayVote.Vote.Builder clearDistSeconds() {
      dist_seconds = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Vote build() {
      try {
        Vote record = new Vote();
        record.vote_seconds = fieldSetFlags()[0] ? this.vote_seconds : (java.lang.Long) defaultValue(fields()[0]);
        record.dist_seconds = fieldSetFlags()[1] ? this.dist_seconds : (java.lang.Long) defaultValue(fields()[1]);
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