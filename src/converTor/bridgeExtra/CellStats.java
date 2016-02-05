/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.bridgeExtra;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class CellStats extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3591867000887620871L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CellStats\",\"namespace\":\"converTor.bridgeExtra\",\"fields\":[{\"name\":\"date\",\"type\":\"string\",\"doc\":\"metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis()\"},{\"name\":\"interval\",\"type\":\"long\",\"doc\":\"metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength()\",\"default\":86400}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis() */
  @Deprecated public java.lang.CharSequence date;
  /** metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength() */
  @Deprecated public long interval;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public CellStats() {}

  /**
   * All-args constructor.
   * @param date metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis()
   * @param interval metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength()
   */
  public CellStats(java.lang.CharSequence date, java.lang.Long interval) {
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
    case 0: date = (java.lang.CharSequence)value$; break;
    case 1: interval = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'date' field.
   * @return metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis()
   */
  public java.lang.CharSequence getDate() {
    return date;
  }

  /**
   * Sets the value of the 'date' field.
   * metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis()
   * @param value the value to set.
   */
  public void setDate(java.lang.CharSequence value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'interval' field.
   * @return metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength()
   */
  public java.lang.Long getInterval() {
    return interval;
  }

  /**
   * Sets the value of the 'interval' field.
   * metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength()
   * @param value the value to set.
   */
  public void setInterval(java.lang.Long value) {
    this.interval = value;
  }

  /**
   * Creates a new CellStats RecordBuilder.
   * @return A new CellStats RecordBuilder
   */
  public static converTor.bridgeExtra.CellStats.Builder newBuilder() {
    return new converTor.bridgeExtra.CellStats.Builder();
  }
  
  /**
   * Creates a new CellStats RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CellStats RecordBuilder
   */
  public static converTor.bridgeExtra.CellStats.Builder newBuilder(converTor.bridgeExtra.CellStats.Builder other) {
    return new converTor.bridgeExtra.CellStats.Builder(other);
  }
  
  /**
   * Creates a new CellStats RecordBuilder by copying an existing CellStats instance.
   * @param other The existing instance to copy.
   * @return A new CellStats RecordBuilder
   */
  public static converTor.bridgeExtra.CellStats.Builder newBuilder(converTor.bridgeExtra.CellStats other) {
    return new converTor.bridgeExtra.CellStats.Builder(other);
  }
  
  /**
   * RecordBuilder for CellStats instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CellStats>
    implements org.apache.avro.data.RecordBuilder<CellStats> {

    /** metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis() */
    private java.lang.CharSequence date;
    /** metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength() */
    private long interval;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.bridgeExtra.CellStats.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.bridgeExtra.CellStats.Builder other) {
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
     * Creates a Builder by copying an existing CellStats instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.bridgeExtra.CellStats other) {
            super(converTor.bridgeExtra.CellStats.SCHEMA$);
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
      * metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis()
      * @return The value.
      */
    public java.lang.CharSequence getDate() {
      return date;
    }

    /**
      * Sets the value of the 'date' field.
      * metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis()
      * @param value The value of 'date'.
      * @return This builder.
      */
    public converTor.bridgeExtra.CellStats.Builder setDate(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.date = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'date' field has been set.
      * metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis()
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'date' field.
      * metrics-lib/ExtraInfoDescriptor: long getCellStatsEndMillis()
      * @return This builder.
      */
    public converTor.bridgeExtra.CellStats.Builder clearDate() {
      date = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'interval' field.
      * metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength()
      * @return The value.
      */
    public java.lang.Long getInterval() {
      return interval;
    }

    /**
      * Sets the value of the 'interval' field.
      * metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength()
      * @param value The value of 'interval'.
      * @return This builder.
      */
    public converTor.bridgeExtra.CellStats.Builder setInterval(long value) {
      validate(fields()[1], value);
      this.interval = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'interval' field has been set.
      * metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength()
      * @return True if the 'interval' field has been set, false otherwise.
      */
    public boolean hasInterval() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'interval' field.
      * metrics-lib/ExtraInfoDescriptor: long getCellStatsIntervalLength()
      * @return This builder.
      */
    public converTor.bridgeExtra.CellStats.Builder clearInterval() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public CellStats build() {
      try {
        CellStats record = new CellStats();
        record.date = fieldSetFlags()[0] ? this.date : (java.lang.CharSequence) defaultValue(fields()[0]);
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
