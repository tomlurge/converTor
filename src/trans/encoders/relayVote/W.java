/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package trans.encoders.relayVote;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class W extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1403593077350096372L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"W\",\"namespace\":\"trans.encoders.relayVote\",\"fields\":[{\"name\":\"bandwidth\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/NetworkStatusEntry: long getBandwidth()\"},{\"name\":\"measured\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/NetworkStatusEntry: long getMeasured()\"},{\"name\":\"unmeasured\",\"type\":[\"null\",\"boolean\"],\"doc\":\"metrics-lib/NetworkStatusEntry: boolean getUnmeasured()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/NetworkStatusEntry: long getBandwidth() */
  @Deprecated public java.lang.Long bandwidth;
  /** metrics-lib/NetworkStatusEntry: long getMeasured() */
  @Deprecated public java.lang.Long measured;
  /** metrics-lib/NetworkStatusEntry: boolean getUnmeasured() */
  @Deprecated public java.lang.Boolean unmeasured;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public W() {}

  /**
   * All-args constructor.
   * @param bandwidth metrics-lib/NetworkStatusEntry: long getBandwidth()
   * @param measured metrics-lib/NetworkStatusEntry: long getMeasured()
   * @param unmeasured metrics-lib/NetworkStatusEntry: boolean getUnmeasured()
   */
  public W(java.lang.Long bandwidth, java.lang.Long measured, java.lang.Boolean unmeasured) {
    this.bandwidth = bandwidth;
    this.measured = measured;
    this.unmeasured = unmeasured;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return bandwidth;
    case 1: return measured;
    case 2: return unmeasured;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: bandwidth = (java.lang.Long)value$; break;
    case 1: measured = (java.lang.Long)value$; break;
    case 2: unmeasured = (java.lang.Boolean)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'bandwidth' field.
   * @return metrics-lib/NetworkStatusEntry: long getBandwidth()
   */
  public java.lang.Long getBandwidth() {
    return bandwidth;
  }

  /**
   * Sets the value of the 'bandwidth' field.
   * metrics-lib/NetworkStatusEntry: long getBandwidth()
   * @param value the value to set.
   */
  public void setBandwidth(java.lang.Long value) {
    this.bandwidth = value;
  }

  /**
   * Gets the value of the 'measured' field.
   * @return metrics-lib/NetworkStatusEntry: long getMeasured()
   */
  public java.lang.Long getMeasured() {
    return measured;
  }

  /**
   * Sets the value of the 'measured' field.
   * metrics-lib/NetworkStatusEntry: long getMeasured()
   * @param value the value to set.
   */
  public void setMeasured(java.lang.Long value) {
    this.measured = value;
  }

  /**
   * Gets the value of the 'unmeasured' field.
   * @return metrics-lib/NetworkStatusEntry: boolean getUnmeasured()
   */
  public java.lang.Boolean getUnmeasured() {
    return unmeasured;
  }

  /**
   * Sets the value of the 'unmeasured' field.
   * metrics-lib/NetworkStatusEntry: boolean getUnmeasured()
   * @param value the value to set.
   */
  public void setUnmeasured(java.lang.Boolean value) {
    this.unmeasured = value;
  }

  /**
   * Creates a new W RecordBuilder.
   * @return A new W RecordBuilder
   */
  public static trans.encoders.relayVote.W.Builder newBuilder() {
    return new trans.encoders.relayVote.W.Builder();
  }
  
  /**
   * Creates a new W RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new W RecordBuilder
   */
  public static trans.encoders.relayVote.W.Builder newBuilder(trans.encoders.relayVote.W.Builder other) {
    return new trans.encoders.relayVote.W.Builder(other);
  }
  
  /**
   * Creates a new W RecordBuilder by copying an existing W instance.
   * @param other The existing instance to copy.
   * @return A new W RecordBuilder
   */
  public static trans.encoders.relayVote.W.Builder newBuilder(trans.encoders.relayVote.W other) {
    return new trans.encoders.relayVote.W.Builder(other);
  }
  
  /**
   * RecordBuilder for W instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<W>
    implements org.apache.avro.data.RecordBuilder<W> {

    /** metrics-lib/NetworkStatusEntry: long getBandwidth() */
    private java.lang.Long bandwidth;
    /** metrics-lib/NetworkStatusEntry: long getMeasured() */
    private java.lang.Long measured;
    /** metrics-lib/NetworkStatusEntry: boolean getUnmeasured() */
    private java.lang.Boolean unmeasured;

    /** Creates a new Builder */
    private Builder() {
      super(trans.encoders.relayVote.W.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(trans.encoders.relayVote.W.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.bandwidth)) {
        this.bandwidth = data().deepCopy(fields()[0].schema(), other.bandwidth);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.measured)) {
        this.measured = data().deepCopy(fields()[1].schema(), other.measured);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.unmeasured)) {
        this.unmeasured = data().deepCopy(fields()[2].schema(), other.unmeasured);
        fieldSetFlags()[2] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing W instance
     * @param other The existing instance to copy.
     */
    private Builder(trans.encoders.relayVote.W other) {
            super(trans.encoders.relayVote.W.SCHEMA$);
      if (isValidValue(fields()[0], other.bandwidth)) {
        this.bandwidth = data().deepCopy(fields()[0].schema(), other.bandwidth);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.measured)) {
        this.measured = data().deepCopy(fields()[1].schema(), other.measured);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.unmeasured)) {
        this.unmeasured = data().deepCopy(fields()[2].schema(), other.unmeasured);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'bandwidth' field.
      * metrics-lib/NetworkStatusEntry: long getBandwidth()
      * @return The value.
      */
    public java.lang.Long getBandwidth() {
      return bandwidth;
    }

    /**
      * Sets the value of the 'bandwidth' field.
      * metrics-lib/NetworkStatusEntry: long getBandwidth()
      * @param value The value of 'bandwidth'.
      * @return This builder.
      */
    public trans.encoders.relayVote.W.Builder setBandwidth(java.lang.Long value) {
      validate(fields()[0], value);
      this.bandwidth = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'bandwidth' field has been set.
      * metrics-lib/NetworkStatusEntry: long getBandwidth()
      * @return True if the 'bandwidth' field has been set, false otherwise.
      */
    public boolean hasBandwidth() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'bandwidth' field.
      * metrics-lib/NetworkStatusEntry: long getBandwidth()
      * @return This builder.
      */
    public trans.encoders.relayVote.W.Builder clearBandwidth() {
      bandwidth = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'measured' field.
      * metrics-lib/NetworkStatusEntry: long getMeasured()
      * @return The value.
      */
    public java.lang.Long getMeasured() {
      return measured;
    }

    /**
      * Sets the value of the 'measured' field.
      * metrics-lib/NetworkStatusEntry: long getMeasured()
      * @param value The value of 'measured'.
      * @return This builder.
      */
    public trans.encoders.relayVote.W.Builder setMeasured(java.lang.Long value) {
      validate(fields()[1], value);
      this.measured = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'measured' field has been set.
      * metrics-lib/NetworkStatusEntry: long getMeasured()
      * @return True if the 'measured' field has been set, false otherwise.
      */
    public boolean hasMeasured() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'measured' field.
      * metrics-lib/NetworkStatusEntry: long getMeasured()
      * @return This builder.
      */
    public trans.encoders.relayVote.W.Builder clearMeasured() {
      measured = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'unmeasured' field.
      * metrics-lib/NetworkStatusEntry: boolean getUnmeasured()
      * @return The value.
      */
    public java.lang.Boolean getUnmeasured() {
      return unmeasured;
    }

    /**
      * Sets the value of the 'unmeasured' field.
      * metrics-lib/NetworkStatusEntry: boolean getUnmeasured()
      * @param value The value of 'unmeasured'.
      * @return This builder.
      */
    public trans.encoders.relayVote.W.Builder setUnmeasured(java.lang.Boolean value) {
      validate(fields()[2], value);
      this.unmeasured = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'unmeasured' field has been set.
      * metrics-lib/NetworkStatusEntry: boolean getUnmeasured()
      * @return True if the 'unmeasured' field has been set, false otherwise.
      */
    public boolean hasUnmeasured() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'unmeasured' field.
      * metrics-lib/NetworkStatusEntry: boolean getUnmeasured()
      * @return This builder.
      */
    public trans.encoders.relayVote.W.Builder clearUnmeasured() {
      unmeasured = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public W build() {
      try {
        W record = new W();
        record.bandwidth = fieldSetFlags()[0] ? this.bandwidth : (java.lang.Long) defaultValue(fields()[0]);
        record.measured = fieldSetFlags()[1] ? this.measured : (java.lang.Long) defaultValue(fields()[1]);
        record.unmeasured = fieldSetFlags()[2] ? this.unmeasured : (java.lang.Boolean) defaultValue(fields()[2]);
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
