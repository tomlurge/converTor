/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package trans.encoders.relayExtra;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ExitStats extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -9093416978962352799L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ExitStats\",\"namespace\":\"trans.encoders.relayExtra\",\"fields\":[{\"name\":\"date\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis()\"},{\"name\":\"interval\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis() */
  @Deprecated public java.lang.Long date;
  /** metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength() */
  @Deprecated public java.lang.Long interval;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ExitStats() {}

  /**
   * All-args constructor.
   * @param date metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis()
   * @param interval metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength()
   */
  public ExitStats(java.lang.Long date, java.lang.Long interval) {
    this.date = date;
    this.interval = interval;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return date;
    case 1: return interval;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: date = (java.lang.Long)value$; break;
    case 1: interval = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'date' field.
   * @return metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis()
   */
  public java.lang.Long getDate() {
    return date;
  }

  /**
   * Sets the value of the 'date' field.
   * metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis()
   * @param value the value to set.
   */
  public void setDate(java.lang.Long value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'interval' field.
   * @return metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength()
   */
  public java.lang.Long getInterval() {
    return interval;
  }

  /**
   * Sets the value of the 'interval' field.
   * metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength()
   * @param value the value to set.
   */
  public void setInterval(java.lang.Long value) {
    this.interval = value;
  }

  /**
   * Creates a new ExitStats RecordBuilder.
   * @return A new ExitStats RecordBuilder
   */
  public static trans.encoders.relayExtra.ExitStats.Builder newBuilder() {
    return new trans.encoders.relayExtra.ExitStats.Builder();
  }
  
  /**
   * Creates a new ExitStats RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ExitStats RecordBuilder
   */
  public static trans.encoders.relayExtra.ExitStats.Builder newBuilder(trans.encoders.relayExtra.ExitStats.Builder other) {
    return new trans.encoders.relayExtra.ExitStats.Builder(other);
  }
  
  /**
   * Creates a new ExitStats RecordBuilder by copying an existing ExitStats instance.
   * @param other The existing instance to copy.
   * @return A new ExitStats RecordBuilder
   */
  public static trans.encoders.relayExtra.ExitStats.Builder newBuilder(trans.encoders.relayExtra.ExitStats other) {
    return new trans.encoders.relayExtra.ExitStats.Builder(other);
  }
  
  /**
   * RecordBuilder for ExitStats instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ExitStats>
    implements org.apache.avro.data.RecordBuilder<ExitStats> {

    /** metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis() */
    private java.lang.Long date;
    /** metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength() */
    private java.lang.Long interval;

    /** Creates a new Builder */
    private Builder() {
      super(trans.encoders.relayExtra.ExitStats.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(trans.encoders.relayExtra.ExitStats.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.interval)) {
        this.interval = data().deepCopy(fields()[1].schema(), other.interval);
        fieldSetFlags()[1] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing ExitStats instance
     * @param other The existing instance to copy.
     */
    private Builder(trans.encoders.relayExtra.ExitStats other) {
            super(trans.encoders.relayExtra.ExitStats.SCHEMA$);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.interval)) {
        this.interval = data().deepCopy(fields()[1].schema(), other.interval);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'date' field.
      * metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis()
      * @return The value.
      */
    public java.lang.Long getDate() {
      return date;
    }

    /**
      * Sets the value of the 'date' field.
      * metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis()
      * @param value The value of 'date'.
      * @return This builder.
      */
    public trans.encoders.relayExtra.ExitStats.Builder setDate(java.lang.Long value) {
      validate(fields()[0], value);
      this.date = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'date' field has been set.
      * metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis()
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'date' field.
      * metrics-lib/ExtraInfoDescriptor: long getExitStatsEndMillis()
      * @return This builder.
      */
    public trans.encoders.relayExtra.ExitStats.Builder clearDate() {
      date = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'interval' field.
      * metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength()
      * @return The value.
      */
    public java.lang.Long getInterval() {
      return interval;
    }

    /**
      * Sets the value of the 'interval' field.
      * metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength()
      * @param value The value of 'interval'.
      * @return This builder.
      */
    public trans.encoders.relayExtra.ExitStats.Builder setInterval(java.lang.Long value) {
      validate(fields()[1], value);
      this.interval = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'interval' field has been set.
      * metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength()
      * @return True if the 'interval' field has been set, false otherwise.
      */
    public boolean hasInterval() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'interval' field.
      * metrics-lib/ExtraInfoDescriptor: long getExitStatsIntervalLength()
      * @return This builder.
      */
    public trans.encoders.relayExtra.ExitStats.Builder clearInterval() {
      interval = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public ExitStats build() {
      try {
        ExitStats record = new ExitStats();
        record.date = fieldSetFlags()[0] ? this.date : (java.lang.Long) defaultValue(fields()[0]);
        record.interval = fieldSetFlags()[1] ? this.interval : (java.lang.Long) defaultValue(fields()[1]);
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
