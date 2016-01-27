/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.torproject.metrics.converTor.bridgeExtra;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class HidservStats extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"HidservStats\",\"namespace\":\"org.torproject.metrics.converTor.bridgeExtra\",\"fields\":[{\"name\":\"date\",\"type\":\"string\"},{\"name\":\"interval\",\"type\":\"long\",\"default\":86400}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence date;
  @Deprecated public long interval;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public HidservStats() {}

  /**
   * All-args constructor.
   */
  public HidservStats(java.lang.CharSequence date, java.lang.Long interval) {
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
   */
  public java.lang.CharSequence getDate() {
    return date;
  }

  /**
   * Sets the value of the 'date' field.
   * @param value the value to set.
   */
  public void setDate(java.lang.CharSequence value) {
    this.date = value;
  }

  /**
   * Gets the value of the 'interval' field.
   */
  public java.lang.Long getInterval() {
    return interval;
  }

  /**
   * Sets the value of the 'interval' field.
   * @param value the value to set.
   */
  public void setInterval(java.lang.Long value) {
    this.interval = value;
  }

  /** Creates a new HidservStats RecordBuilder */
  public static org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder newBuilder() {
    return new org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder();
  }
  
  /** Creates a new HidservStats RecordBuilder by copying an existing Builder */
  public static org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder newBuilder(org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder other) {
    return new org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder(other);
  }
  
  /** Creates a new HidservStats RecordBuilder by copying an existing HidservStats instance */
  public static org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder newBuilder(org.torproject.metrics.converTor.bridgeExtra.HidservStats other) {
    return new org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder(other);
  }
  
  /**
   * RecordBuilder for HidservStats instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<HidservStats>
    implements org.apache.avro.data.RecordBuilder<HidservStats> {

    private java.lang.CharSequence date;
    private long interval;

    /** Creates a new Builder */
    private Builder() {
      super(org.torproject.metrics.converTor.bridgeExtra.HidservStats.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder other) {
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
    
    /** Creates a Builder by copying an existing HidservStats instance */
    private Builder(org.torproject.metrics.converTor.bridgeExtra.HidservStats other) {
            super(org.torproject.metrics.converTor.bridgeExtra.HidservStats.SCHEMA$);
      if (isValidValue(fields()[0], other.date)) {
        this.date = data().deepCopy(fields()[0].schema(), other.date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.interval)) {
        this.interval = data().deepCopy(fields()[1].schema(), other.interval);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'date' field */
    public java.lang.CharSequence getDate() {
      return date;
    }
    
    /** Sets the value of the 'date' field */
    public org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder setDate(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.date = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'date' field has been set */
    public boolean hasDate() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'date' field */
    public org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder clearDate() {
      date = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'interval' field */
    public java.lang.Long getInterval() {
      return interval;
    }
    
    /** Sets the value of the 'interval' field */
    public org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder setInterval(long value) {
      validate(fields()[1], value);
      this.interval = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'interval' field has been set */
    public boolean hasInterval() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'interval' field */
    public org.torproject.metrics.converTor.bridgeExtra.HidservStats.Builder clearInterval() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public HidservStats build() {
      try {
        HidservStats record = new HidservStats();
        record.date = fieldSetFlags()[0] ? this.date : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.interval = fieldSetFlags()[1] ? this.interval : (java.lang.Long) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
