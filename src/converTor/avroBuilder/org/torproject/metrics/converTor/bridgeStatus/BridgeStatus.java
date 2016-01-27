/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.torproject.metrics.converTor.bridgeStatus;  
@SuppressWarnings("all")
/** bridge-network-status 1.0 */
@org.apache.avro.specific.AvroGenerated
public class BridgeStatus extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BridgeStatus\",\"namespace\":\"org.torproject.metrics.converTor.bridgeStatus\",\"doc\":\"bridge-network-status 1.0\",\"fields\":[{\"name\":\"descriptor_type\",\"type\":\"string\",\"default\":\"bridge-network-status 1.0\"},{\"name\":\"published\",\"type\":[\"null\",\"string\"]},{\"name\":\"flag_tresholds\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"FlagTresholds\",\"fields\":[{\"name\":\"stable_uptime\",\"type\":[\"null\",\"long\"]},{\"name\":\"stable_mtbf\",\"type\":[\"null\",\"long\"]},{\"name\":\"enough_mtbf\",\"type\":[\"null\",\"int\"]},{\"name\":\"fast_speed\",\"type\":[\"null\",\"long\"]},{\"name\":\"guard_wfu\",\"type\":[\"null\",\"double\"]},{\"name\":\"guard_tk\",\"type\":[\"null\",\"long\"]},{\"name\":\"guard_bw_inc_exits\",\"type\":[\"null\",\"long\"]},{\"name\":\"guard_bw_exc_exits\",\"type\":[\"null\",\"long\"]},{\"name\":\"ignoring_advertised\",\"type\":[\"null\",\"int\"]}]}]},{\"name\":\"bridges\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Bridge\",\"fields\":[{\"name\":\"r\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"R\",\"fields\":[{\"name\":\"nickname\",\"type\":[\"null\",\"string\"]},{\"name\":\"identity\",\"type\":[\"null\",\"string\"]},{\"name\":\"digest\",\"type\":[\"null\",\"string\"]},{\"name\":\"published\",\"type\":[\"null\",\"string\"]},{\"name\":\"ip\",\"type\":[\"null\",\"string\"]},{\"name\":\"or_port\",\"type\":[\"null\",\"int\"]},{\"name\":\"dir_port\",\"type\":[\"null\",\"int\"]}]}]},{\"name\":\"s\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"string\"}]},{\"name\":\"w\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"W\",\"fields\":[{\"name\":\"bandwidth\",\"type\":[\"null\",\"long\"]},{\"name\":\"measured\",\"type\":[\"null\",\"long\"]},{\"name\":\"unmeasured\",\"type\":[\"null\",\"boolean\"]}]}]},{\"name\":\"p\",\"type\":[\"null\",\"string\"]},{\"name\":\"a\",\"type\":[\"null\",\"string\"]},{\"name\":\"v\",\"type\":[\"null\",\"string\"]}]}}]}],\"aliases\":[\"bridge_network_status\",\"bridge_network_status_descriptor\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence descriptor_type;
  @Deprecated public java.lang.CharSequence published;
  @Deprecated public org.torproject.metrics.converTor.bridgeStatus.FlagTresholds flag_tresholds;
  @Deprecated public java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge> bridges;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public BridgeStatus() {}

  /**
   * All-args constructor.
   */
  public BridgeStatus(java.lang.CharSequence descriptor_type, java.lang.CharSequence published, org.torproject.metrics.converTor.bridgeStatus.FlagTresholds flag_tresholds, java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge> bridges) {
    this.descriptor_type = descriptor_type;
    this.published = published;
    this.flag_tresholds = flag_tresholds;
    this.bridges = bridges;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return descriptor_type;
    case 1: return published;
    case 2: return flag_tresholds;
    case 3: return bridges;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: descriptor_type = (java.lang.CharSequence)value$; break;
    case 1: published = (java.lang.CharSequence)value$; break;
    case 2: flag_tresholds = (org.torproject.metrics.converTor.bridgeStatus.FlagTresholds)value$; break;
    case 3: bridges = (java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'descriptor_type' field.
   */
  public java.lang.CharSequence getDescriptorType() {
    return descriptor_type;
  }

  /**
   * Sets the value of the 'descriptor_type' field.
   * @param value the value to set.
   */
  public void setDescriptorType(java.lang.CharSequence value) {
    this.descriptor_type = value;
  }

  /**
   * Gets the value of the 'published' field.
   */
  public java.lang.CharSequence getPublished() {
    return published;
  }

  /**
   * Sets the value of the 'published' field.
   * @param value the value to set.
   */
  public void setPublished(java.lang.CharSequence value) {
    this.published = value;
  }

  /**
   * Gets the value of the 'flag_tresholds' field.
   */
  public org.torproject.metrics.converTor.bridgeStatus.FlagTresholds getFlagTresholds() {
    return flag_tresholds;
  }

  /**
   * Sets the value of the 'flag_tresholds' field.
   * @param value the value to set.
   */
  public void setFlagTresholds(org.torproject.metrics.converTor.bridgeStatus.FlagTresholds value) {
    this.flag_tresholds = value;
  }

  /**
   * Gets the value of the 'bridges' field.
   */
  public java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge> getBridges() {
    return bridges;
  }

  /**
   * Sets the value of the 'bridges' field.
   * @param value the value to set.
   */
  public void setBridges(java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge> value) {
    this.bridges = value;
  }

  /** Creates a new BridgeStatus RecordBuilder */
  public static org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder newBuilder() {
    return new org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder();
  }
  
  /** Creates a new BridgeStatus RecordBuilder by copying an existing Builder */
  public static org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder newBuilder(org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder other) {
    return new org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder(other);
  }
  
  /** Creates a new BridgeStatus RecordBuilder by copying an existing BridgeStatus instance */
  public static org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder newBuilder(org.torproject.metrics.converTor.bridgeStatus.BridgeStatus other) {
    return new org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder(other);
  }
  
  /**
   * RecordBuilder for BridgeStatus instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BridgeStatus>
    implements org.apache.avro.data.RecordBuilder<BridgeStatus> {

    private java.lang.CharSequence descriptor_type;
    private java.lang.CharSequence published;
    private org.torproject.metrics.converTor.bridgeStatus.FlagTresholds flag_tresholds;
    private java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge> bridges;

    /** Creates a new Builder */
    private Builder() {
      super(org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.descriptor_type)) {
        this.descriptor_type = data().deepCopy(fields()[0].schema(), other.descriptor_type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.published)) {
        this.published = data().deepCopy(fields()[1].schema(), other.published);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.flag_tresholds)) {
        this.flag_tresholds = data().deepCopy(fields()[2].schema(), other.flag_tresholds);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bridges)) {
        this.bridges = data().deepCopy(fields()[3].schema(), other.bridges);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing BridgeStatus instance */
    private Builder(org.torproject.metrics.converTor.bridgeStatus.BridgeStatus other) {
            super(org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.SCHEMA$);
      if (isValidValue(fields()[0], other.descriptor_type)) {
        this.descriptor_type = data().deepCopy(fields()[0].schema(), other.descriptor_type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.published)) {
        this.published = data().deepCopy(fields()[1].schema(), other.published);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.flag_tresholds)) {
        this.flag_tresholds = data().deepCopy(fields()[2].schema(), other.flag_tresholds);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.bridges)) {
        this.bridges = data().deepCopy(fields()[3].schema(), other.bridges);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'descriptor_type' field */
    public java.lang.CharSequence getDescriptorType() {
      return descriptor_type;
    }
    
    /** Sets the value of the 'descriptor_type' field */
    public org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder setDescriptorType(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.descriptor_type = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'descriptor_type' field has been set */
    public boolean hasDescriptorType() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'descriptor_type' field */
    public org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder clearDescriptorType() {
      descriptor_type = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'published' field */
    public java.lang.CharSequence getPublished() {
      return published;
    }
    
    /** Sets the value of the 'published' field */
    public org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder setPublished(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.published = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'published' field has been set */
    public boolean hasPublished() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'published' field */
    public org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder clearPublished() {
      published = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'flag_tresholds' field */
    public org.torproject.metrics.converTor.bridgeStatus.FlagTresholds getFlagTresholds() {
      return flag_tresholds;
    }
    
    /** Sets the value of the 'flag_tresholds' field */
    public org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder setFlagTresholds(org.torproject.metrics.converTor.bridgeStatus.FlagTresholds value) {
      validate(fields()[2], value);
      this.flag_tresholds = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'flag_tresholds' field has been set */
    public boolean hasFlagTresholds() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'flag_tresholds' field */
    public org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder clearFlagTresholds() {
      flag_tresholds = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'bridges' field */
    public java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge> getBridges() {
      return bridges;
    }
    
    /** Sets the value of the 'bridges' field */
    public org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder setBridges(java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge> value) {
      validate(fields()[3], value);
      this.bridges = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'bridges' field has been set */
    public boolean hasBridges() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'bridges' field */
    public org.torproject.metrics.converTor.bridgeStatus.BridgeStatus.Builder clearBridges() {
      bridges = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public BridgeStatus build() {
      try {
        BridgeStatus record = new BridgeStatus();
        record.descriptor_type = fieldSetFlags()[0] ? this.descriptor_type : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.published = fieldSetFlags()[1] ? this.published : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.flag_tresholds = fieldSetFlags()[2] ? this.flag_tresholds : (org.torproject.metrics.converTor.bridgeStatus.FlagTresholds) defaultValue(fields()[2]);
        record.bridges = fieldSetFlags()[3] ? this.bridges : (java.util.List<org.torproject.metrics.converTor.bridgeStatus.Bridge>) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
