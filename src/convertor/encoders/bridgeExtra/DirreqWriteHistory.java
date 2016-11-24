/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package convertor.encoders.bridgeExtra;
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DirreqWriteHistory extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6585263533842145646L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DirreqWriteHistory\",\"namespace\":\"convertor.encoders.bridgeExtra\",\"fields\":[{\"name\":\"date\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BandwidthHistory: long getHistoryEndMillis()\"},{\"name\":\"interval\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BandwidthHistory: long getIntervalLength()\"},{\"name\":\"bytes\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"long\"}],\"doc\":\"metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/BandwidthHistory: long getHistoryEndMillis() */
  @Deprecated public java.lang.Long date;
  /** metrics-lib/BandwidthHistory: long getIntervalLength() */
  @Deprecated public java.lang.Long interval;
  /** metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values() */
  @Deprecated public java.util.List<java.lang.Long> bytes;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DirreqWriteHistory() {}

  /**
   * All-args constructor.
   * @param date metrics-lib/BandwidthHistory: long getHistoryEndMillis()
   * @param interval metrics-lib/BandwidthHistory: long getIntervalLength()
   * @param bytes metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values()
   */
  public DirreqWriteHistory(java.lang.Long date, java.lang.Long interval, java.util.List<java.lang.Long> bytes) {
    this.date = date;
    this.interval = interval;
    this.bytes = bytes;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return date;
    case 1: return interval;
    case 2: return bytes;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: date = (java.lang.Long)value$; break;
    case 1: interval = (java.lang.Long)value$; break;
    case 2: bytes = (java.util.List<java.lang.Long>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'date' field.
   * @return metrics-lib/BandwidthHistory: long getHistoryEndMillis()
   */
  public java.lang.Long getDate() {
    return date;
  }

  /**
   * Sets the value of the 'date' field.
   * metrics-lib/BandwidthHistory: long getHistoryEndMillis()
   * @param value the value to set.
   */
  public void setDate(java.lang.Long value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'interval' field.
   * @return metrics-lib/BandwidthHistory: long getIntervalLength()
   */
  public java.lang.Long getInterval() {
    return interval;
  }

  /**
   * Sets the value of the 'interval' field.
   * metrics-lib/BandwidthHistory: long getIntervalLength()
   * @param value the value to set.
   */
  public void setInterval(java.lang.Long value) {
    this.interval = value;
  }

  /**
   * Gets the value of the 'bytes' field.
   * @return metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values()
   */
  public java.util.List<java.lang.Long> getBytes() {
    return bytes;
  }

  /**
   * Sets the value of the 'bytes' field.
   * metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values()
   * @param value the value to set.
   */
  public void setBytes(java.util.List<java.lang.Long> value) {
    this.bytes = value;
  }

  /**
   * Creates a new DirreqWriteHistory RecordBuilder.
   * @return A new DirreqWriteHistory RecordBuilder
   */
  public static convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder newBuilder() {
    return new convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder();
  }
  
  /**
   * Creates a new DirreqWriteHistory RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DirreqWriteHistory RecordBuilder
   */
  public static convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder newBuilder(convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder other) {
    return new convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder(other);
  }
  
  /**
   * Creates a new DirreqWriteHistory RecordBuilder by copying an existing DirreqWriteHistory instance.
   * @param other The existing instance to copy.
   * @return A new DirreqWriteHistory RecordBuilder
   */
  public static convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder newBuilder(convertor.encoders.bridgeExtra.DirreqWriteHistory other) {
    return new convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder(other);
  }
  
  /**
   * RecordBuilder for DirreqWriteHistory instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DirreqWriteHistory>
    implements org.apache.avro.data.RecordBuilder<DirreqWriteHistory> {

    /** metrics-lib/BandwidthHistory: long getHistoryEndMillis() */
    private java.lang.Long date;
    /** metrics-lib/BandwidthHistory: long getIntervalLength() */
    private java.lang.Long interval;
    /** metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values() */
    private java.util.List<java.lang.Long> bytes;

    /** Creates a new Builder */
    private Builder() {
      super(convertor.encoders.bridgeExtra.DirreqWriteHistory.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.interval)) {
        this.interval = data().deepCopy(fields()[1].schema(), other.interval);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.bytes)) {
        this.bytes = data().deepCopy(fields()[2].schema(), other.bytes);
        fieldSetFlags()[2] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing DirreqWriteHistory instance
     * @param other The existing instance to copy.
     */
    private Builder(convertor.encoders.bridgeExtra.DirreqWriteHistory other) {
            super(convertor.encoders.bridgeExtra.DirreqWriteHistory.SCHEMA$);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.interval)) {
        this.interval = data().deepCopy(fields()[1].schema(), other.interval);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.bytes)) {
        this.bytes = data().deepCopy(fields()[2].schema(), other.bytes);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'date' field.
      * metrics-lib/BandwidthHistory: long getHistoryEndMillis()
      * @return The value.
      */
    public java.lang.Long getDate() {
      return date;
    }

    /**
      * Sets the value of the 'date' field.
      * metrics-lib/BandwidthHistory: long getHistoryEndMillis()
      * @param value The value of 'date'.
      * @return This builder.
      */
    public convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder setDate(java.lang.Long value) {
      validate(fields()[0], value);
      this.date = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'date' field has been set.
      * metrics-lib/BandwidthHistory: long getHistoryEndMillis()
      * @return True if the 'date' field has been set, false otherwise.
      */
    public boolean hasDate() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'date' field.
      * metrics-lib/BandwidthHistory: long getHistoryEndMillis()
      * @return This builder.
      */
    public convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder clearDate() {
      date = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'interval' field.
      * metrics-lib/BandwidthHistory: long getIntervalLength()
      * @return The value.
      */
    public java.lang.Long getInterval() {
      return interval;
    }

    /**
      * Sets the value of the 'interval' field.
      * metrics-lib/BandwidthHistory: long getIntervalLength()
      * @param value The value of 'interval'.
      * @return This builder.
      */
    public convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder setInterval(java.lang.Long value) {
      validate(fields()[1], value);
      this.interval = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'interval' field has been set.
      * metrics-lib/BandwidthHistory: long getIntervalLength()
      * @return True if the 'interval' field has been set, false otherwise.
      */
    public boolean hasInterval() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'interval' field.
      * metrics-lib/BandwidthHistory: long getIntervalLength()
      * @return This builder.
      */
    public convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder clearInterval() {
      interval = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'bytes' field.
      * metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values()
      * @return The value.
      */
    public java.util.List<java.lang.Long> getBytes() {
      return bytes;
    }

    /**
      * Sets the value of the 'bytes' field.
      * metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values()
      * @param value The value of 'bytes'.
      * @return This builder.
      */
    public convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder setBytes(java.util.List<java.lang.Long> value) {
      validate(fields()[2], value);
      this.bytes = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'bytes' field has been set.
      * metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values()
      * @return True if the 'bytes' field has been set, false otherwise.
      */
    public boolean hasBytes() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'bytes' field.
      * metrics-lib/BandwidthHistory: Collection<Long> getBandwidthValues().values()
      * @return This builder.
      */
    public convertor.encoders.bridgeExtra.DirreqWriteHistory.Builder clearBytes() {
      bytes = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public DirreqWriteHistory build() {
      try {
        DirreqWriteHistory record = new DirreqWriteHistory();
        record.date = fieldSetFlags()[0] ? this.date : (java.lang.Long) defaultValue(fields()[0]);
        record.interval = fieldSetFlags()[1] ? this.interval : (java.lang.Long) defaultValue(fields()[1]);
        record.bytes = fieldSetFlags()[2] ? this.bytes : (java.util.List<java.lang.Long>) defaultValue(fields()[2]);
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