/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package trans.encoders.relayVote;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ID extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -667189628646329718L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ID\",\"namespace\":\"trans.encoders.relayVote\",\"fields\":[{\"name\":\"ed25519\",\"type\":[\"null\",\"boolean\"],\"doc\":\"metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519() */
  @Deprecated public java.lang.Boolean ed25519;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ID() {}

  /**
   * All-args constructor.
   * @param ed25519 metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519()
   */
  public ID(java.lang.Boolean ed25519) {
    this.ed25519 = ed25519;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ed25519;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ed25519 = (java.lang.Boolean)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'ed25519' field.
   * @return metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519()
   */
  public java.lang.Boolean getEd25519() {
    return ed25519;
  }

  /**
   * Sets the value of the 'ed25519' field.
   * metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519()
   * @param value the value to set.
   */
  public void setEd25519(java.lang.Boolean value) {
    this.ed25519 = value;
  }

  /**
   * Creates a new ID RecordBuilder.
   * @return A new ID RecordBuilder
   */
  public static trans.encoders.relayVote.ID.Builder newBuilder() {
    return new trans.encoders.relayVote.ID.Builder();
  }
  
  /**
   * Creates a new ID RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ID RecordBuilder
   */
  public static trans.encoders.relayVote.ID.Builder newBuilder(trans.encoders.relayVote.ID.Builder other) {
    return new trans.encoders.relayVote.ID.Builder(other);
  }
  
  /**
   * Creates a new ID RecordBuilder by copying an existing ID instance.
   * @param other The existing instance to copy.
   * @return A new ID RecordBuilder
   */
  public static trans.encoders.relayVote.ID.Builder newBuilder(trans.encoders.relayVote.ID other) {
    return new trans.encoders.relayVote.ID.Builder(other);
  }
  
  /**
   * RecordBuilder for ID instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ID>
    implements org.apache.avro.data.RecordBuilder<ID> {

    /** metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519() */
    private java.lang.Boolean ed25519;

    /** Creates a new Builder */
    private Builder() {
      super(trans.encoders.relayVote.ID.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(trans.encoders.relayVote.ID.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ed25519)) {
        this.ed25519 = data().deepCopy(fields()[0].schema(), other.ed25519);
        fieldSetFlags()[0] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing ID instance
     * @param other The existing instance to copy.
     */
    private Builder(trans.encoders.relayVote.ID other) {
            super(trans.encoders.relayVote.ID.SCHEMA$);
      if (isValidValue(fields()[0], other.ed25519)) {
        this.ed25519 = data().deepCopy(fields()[0].schema(), other.ed25519);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'ed25519' field.
      * metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519()
      * @return The value.
      */
    public java.lang.Boolean getEd25519() {
      return ed25519;
    }

    /**
      * Sets the value of the 'ed25519' field.
      * metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519()
      * @param value The value of 'ed25519'.
      * @return This builder.
      */
    public trans.encoders.relayVote.ID.Builder setEd25519(java.lang.Boolean value) {
      validate(fields()[0], value);
      this.ed25519 = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'ed25519' field has been set.
      * metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519()
      * @return True if the 'ed25519' field has been set, false otherwise.
      */
    public boolean hasEd25519() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'ed25519' field.
      * metrics-lib/NetworkStatusEntry: String getMasterKeyEd25519()
      * @return This builder.
      */
    public trans.encoders.relayVote.ID.Builder clearEd25519() {
      ed25519 = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public ID build() {
      try {
        ID record = new ID();
        record.ed25519 = fieldSetFlags()[0] ? this.ed25519 : (java.lang.Boolean) defaultValue(fields()[0]);
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
