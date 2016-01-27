/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.torproject.metrics.converTor.bridge;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Bandwidth extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Bandwidth\",\"namespace\":\"org.torproject.metrics.converTor.bridge\",\"fields\":[{\"name\":\"avg\",\"type\":[\"null\",\"int\"]},{\"name\":\"burst\",\"type\":[\"null\",\"int\"]},{\"name\":\"observed\",\"type\":[\"null\",\"int\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.Integer avg;
  @Deprecated public java.lang.Integer burst;
  @Deprecated public java.lang.Integer observed;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Bandwidth() {}

  /**
   * All-args constructor.
   */
  public Bandwidth(java.lang.Integer avg, java.lang.Integer burst, java.lang.Integer observed) {
    this.avg = avg;
    this.burst = burst;
    this.observed = observed;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return avg;
    case 1: return burst;
    case 2: return observed;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: avg = (java.lang.Integer)value$; break;
    case 1: burst = (java.lang.Integer)value$; break;
    case 2: observed = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'avg' field.
   */
  public java.lang.Integer getAvg() {
    return avg;
  }

  /**
   * Sets the value of the 'avg' field.
   * @param value the value to set.
   */
  public void setAvg(java.lang.Integer value) {
    this.avg = value;
  }

  /**
   * Gets the value of the 'burst' field.
   */
  public java.lang.Integer getBurst() {
    return burst;
  }

  /**
   * Sets the value of the 'burst' field.
   * @param value the value to set.
   */
  public void setBurst(java.lang.Integer value) {
    this.burst = value;
  }

  /**
   * Gets the value of the 'observed' field.
   */
  public java.lang.Integer getObserved() {
    return observed;
  }

  /**
   * Sets the value of the 'observed' field.
   * @param value the value to set.
   */
  public void setObserved(java.lang.Integer value) {
    this.observed = value;
  }

  /** Creates a new Bandwidth RecordBuilder */
  public static org.torproject.metrics.converTor.bridge.Bandwidth.Builder newBuilder() {
    return new org.torproject.metrics.converTor.bridge.Bandwidth.Builder();
  }
  
  /** Creates a new Bandwidth RecordBuilder by copying an existing Builder */
  public static org.torproject.metrics.converTor.bridge.Bandwidth.Builder newBuilder(org.torproject.metrics.converTor.bridge.Bandwidth.Builder other) {
    return new org.torproject.metrics.converTor.bridge.Bandwidth.Builder(other);
  }
  
  /** Creates a new Bandwidth RecordBuilder by copying an existing Bandwidth instance */
  public static org.torproject.metrics.converTor.bridge.Bandwidth.Builder newBuilder(org.torproject.metrics.converTor.bridge.Bandwidth other) {
    return new org.torproject.metrics.converTor.bridge.Bandwidth.Builder(other);
  }
  
  /**
   * RecordBuilder for Bandwidth instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Bandwidth>
    implements org.apache.avro.data.RecordBuilder<Bandwidth> {

    private java.lang.Integer avg;
    private java.lang.Integer burst;
    private java.lang.Integer observed;

    /** Creates a new Builder */
    private Builder() {
      super(org.torproject.metrics.converTor.bridge.Bandwidth.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.torproject.metrics.converTor.bridge.Bandwidth.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.avg)) {
        this.avg = data().deepCopy(fields()[0].schema(), other.avg);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.burst)) {
        this.burst = data().deepCopy(fields()[1].schema(), other.burst);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.observed)) {
        this.observed = data().deepCopy(fields()[2].schema(), other.observed);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Bandwidth instance */
    private Builder(org.torproject.metrics.converTor.bridge.Bandwidth other) {
            super(org.torproject.metrics.converTor.bridge.Bandwidth.SCHEMA$);
      if (isValidValue(fields()[0], other.avg)) {
        this.avg = data().deepCopy(fields()[0].schema(), other.avg);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.burst)) {
        this.burst = data().deepCopy(fields()[1].schema(), other.burst);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.observed)) {
        this.observed = data().deepCopy(fields()[2].schema(), other.observed);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'avg' field */
    public java.lang.Integer getAvg() {
      return avg;
    }
    
    /** Sets the value of the 'avg' field */
    public org.torproject.metrics.converTor.bridge.Bandwidth.Builder setAvg(java.lang.Integer value) {
      validate(fields()[0], value);
      this.avg = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'avg' field has been set */
    public boolean hasAvg() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'avg' field */
    public org.torproject.metrics.converTor.bridge.Bandwidth.Builder clearAvg() {
      avg = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'burst' field */
    public java.lang.Integer getBurst() {
      return burst;
    }
    
    /** Sets the value of the 'burst' field */
    public org.torproject.metrics.converTor.bridge.Bandwidth.Builder setBurst(java.lang.Integer value) {
      validate(fields()[1], value);
      this.burst = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'burst' field has been set */
    public boolean hasBurst() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'burst' field */
    public org.torproject.metrics.converTor.bridge.Bandwidth.Builder clearBurst() {
      burst = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'observed' field */
    public java.lang.Integer getObserved() {
      return observed;
    }
    
    /** Sets the value of the 'observed' field */
    public org.torproject.metrics.converTor.bridge.Bandwidth.Builder setObserved(java.lang.Integer value) {
      validate(fields()[2], value);
      this.observed = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'observed' field has been set */
    public boolean hasObserved() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'observed' field */
    public org.torproject.metrics.converTor.bridge.Bandwidth.Builder clearObserved() {
      observed = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public Bandwidth build() {
      try {
        Bandwidth record = new Bandwidth();
        record.avg = fieldSetFlags()[0] ? this.avg : (java.lang.Integer) defaultValue(fields()[0]);
        record.burst = fieldSetFlags()[1] ? this.burst : (java.lang.Integer) defaultValue(fields()[1]);
        record.observed = fieldSetFlags()[2] ? this.observed : (java.lang.Integer) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
