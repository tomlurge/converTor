/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package trans.encoders.bridgeStatus;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class BridgeStatus extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 100612750942399106L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BridgeStatus\",\"namespace\":\"trans.encoders.bridgeStatus\",\"fields\":[{\"name\":\"descriptor_type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"bridge-network-status 1.0\"},{\"name\":\"src_date\",\"type\":[\"null\",\"long\"],\"doc\":\"file creation date, in milliseconds, of the data source to this conversion\"},{\"name\":\"published\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: long getPublishedMillis()\"},{\"name\":\"flag_tresholds\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"FlagTresholds\",\"fields\":[{\"name\":\"stable_uptime\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: long getStableUptime()\"},{\"name\":\"stable_mtbf\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: long getStableMtbf()\"},{\"name\":\"enough_mtbf\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: int getEnoughMtbfInfo()\"},{\"name\":\"fast_speed\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: long getFastBandwidth()\"},{\"name\":\"guard_wfu\",\"type\":[\"null\",\"double\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: double getGuardWfu()\"},{\"name\":\"guard_tk\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: long getGuardTk()\"},{\"name\":\"guard_bw_inc_exits\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: long getGuardBandwidthIncludingExits()\"},{\"name\":\"guard_bw_exc_exits\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: long getGuardBandwidthExcludingExits()\"},{\"name\":\"ignoring_advertised_bws\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/BridgeNetworkStatus: int getIgnoringAdvertisedBws()\"}]}],\"doc\":\"see above\"},{\"name\":\"status\",\"type\":[\"null\",{\"type\":\"map\",\"values\":{\"type\":\"record\",\"name\":\"Status\",\"fields\":[{\"name\":\"r\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"R\",\"fields\":[{\"name\":\"nickname\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getNickname()\"},{\"name\":\"identity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getFingerprint()\"},{\"name\":\"digest\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getDescriptor()\"},{\"name\":\"published\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/NetworkStatusEntry: long getPublishedMillis()\"},{\"name\":\"ip\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getAddress()\"},{\"name\":\"or_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/NetworkStatusEntry: int getOrPort()\"},{\"name\":\"dir_port\",\"type\":[\"null\",\"int\"],\"doc\":\"metrics-lib/NetworkStatusEntry: int getDirPort()\"}]}]},{\"name\":\"a\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"OrAddress\",\"fields\":[{\"name\":\"address\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"implementation specific, see actual converter\"},{\"name\":\"port\",\"type\":[\"null\",\"int\"],\"doc\":\"implementation specific, see actual converter\"}]}}],\"doc\":\"metrics-lib/NetworkStatusEntry: getOrAddresses()\"},{\"name\":\"s\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}],\"doc\":\"metrics-lib/NetworkStatusEntry: SortedSet<String> getFlags()\"},{\"name\":\"v\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getVersion()\"},{\"name\":\"w\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"W\",\"fields\":[{\"name\":\"bandwidth\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/NetworkStatusEntry: long getBandwidth()\"},{\"name\":\"measured\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/NetworkStatusEntry: long getMeasured()\"},{\"name\":\"unmeasured\",\"type\":[\"null\",\"boolean\"],\"doc\":\"metrics-lib/NetworkStatusEntry: boolean getUnmeasured()\"}]}]},{\"name\":\"p\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"Policy\",\"fields\":[{\"name\":\"default_policy\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getDefaultPolicy()\"},{\"name\":\"port_summary\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/NetworkStatusEntry: String getPortList()\"}]}]}]},\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries()\"}],\"aliases\":[\"bridge_network_status\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String descriptor_type;
  /** file creation date, in milliseconds, of the data source to this conversion */
  @Deprecated public java.lang.Long src_date;
  /** metrics-lib/BridgeNetworkStatus: long getPublishedMillis() */
  @Deprecated public java.lang.Long published;
  /** see above */
  @Deprecated public trans.encoders.bridgeStatus.FlagTresholds flag_tresholds;
  /** metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries() */
  @Deprecated public java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status> status;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public BridgeStatus() {}

  /**
   * All-args constructor.
   * @param src_date file creation date, in milliseconds, of the data source to this conversion
   * @param published metrics-lib/BridgeNetworkStatus: long getPublishedMillis()
   * @param flag_tresholds see above
   * @param status metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries()
   */
  public BridgeStatus(java.lang.String descriptor_type, java.lang.Long src_date, java.lang.Long published, trans.encoders.bridgeStatus.FlagTresholds flag_tresholds, java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status> status) {
    this.descriptor_type = descriptor_type;
    this.src_date = src_date;
    this.published = published;
    this.flag_tresholds = flag_tresholds;
    this.status = status;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return descriptor_type;
    case 1: return src_date;
    case 2: return published;
    case 3: return flag_tresholds;
    case 4: return status;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: descriptor_type = (java.lang.String)value$; break;
    case 1: src_date = (java.lang.Long)value$; break;
    case 2: published = (java.lang.Long)value$; break;
    case 3: flag_tresholds = (trans.encoders.bridgeStatus.FlagTresholds)value$; break;
    case 4: status = (java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'descriptor_type' field.
   */
  public java.lang.String getDescriptorType() {
    return descriptor_type;
  }

  /**
   * Sets the value of the 'descriptor_type' field.
   * @param value the value to set.
   */
  public void setDescriptorType(java.lang.String value) {
    this.descriptor_type = value;
  }

  /**
   * Gets the value of the 'src_date' field.
   * @return file creation date, in milliseconds, of the data source to this conversion
   */
  public java.lang.Long getSrcDate() {
    return src_date;
  }

  /**
   * Sets the value of the 'src_date' field.
   * file creation date, in milliseconds, of the data source to this conversion
   * @param value the value to set.
   */
  public void setSrcDate(java.lang.Long value) {
    this.src_date = value;
  }

  /**
   * Gets the value of the 'published' field.
   * @return metrics-lib/BridgeNetworkStatus: long getPublishedMillis()
   */
  public java.lang.Long getPublished() {
    return published;
  }

  /**
   * Sets the value of the 'published' field.
   * metrics-lib/BridgeNetworkStatus: long getPublishedMillis()
   * @param value the value to set.
   */
  public void setPublished(java.lang.Long value) {
    this.published = value;
  }

  /**
   * Gets the value of the 'flag_tresholds' field.
   * @return see above
   */
  public trans.encoders.bridgeStatus.FlagTresholds getFlagTresholds() {
    return flag_tresholds;
  }

  /**
   * Sets the value of the 'flag_tresholds' field.
   * see above
   * @param value the value to set.
   */
  public void setFlagTresholds(trans.encoders.bridgeStatus.FlagTresholds value) {
    this.flag_tresholds = value;
  }

  /**
   * Gets the value of the 'status' field.
   * @return metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries()
   */
  public java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status> getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries()
   * @param value the value to set.
   */
  public void setStatus(java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status> value) {
    this.status = value;
  }

  /**
   * Creates a new BridgeStatus RecordBuilder.
   * @return A new BridgeStatus RecordBuilder
   */
  public static trans.encoders.bridgeStatus.BridgeStatus.Builder newBuilder() {
    return new trans.encoders.bridgeStatus.BridgeStatus.Builder();
  }
  
  /**
   * Creates a new BridgeStatus RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new BridgeStatus RecordBuilder
   */
  public static trans.encoders.bridgeStatus.BridgeStatus.Builder newBuilder(trans.encoders.bridgeStatus.BridgeStatus.Builder other) {
    return new trans.encoders.bridgeStatus.BridgeStatus.Builder(other);
  }
  
  /**
   * Creates a new BridgeStatus RecordBuilder by copying an existing BridgeStatus instance.
   * @param other The existing instance to copy.
   * @return A new BridgeStatus RecordBuilder
   */
  public static trans.encoders.bridgeStatus.BridgeStatus.Builder newBuilder(trans.encoders.bridgeStatus.BridgeStatus other) {
    return new trans.encoders.bridgeStatus.BridgeStatus.Builder(other);
  }
  
  /**
   * RecordBuilder for BridgeStatus instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BridgeStatus>
    implements org.apache.avro.data.RecordBuilder<BridgeStatus> {

    private java.lang.String descriptor_type;
    /** file creation date, in milliseconds, of the data source to this conversion */
    private java.lang.Long src_date;
    /** metrics-lib/BridgeNetworkStatus: long getPublishedMillis() */
    private java.lang.Long published;
    /** see above */
    private trans.encoders.bridgeStatus.FlagTresholds flag_tresholds;
    private trans.encoders.bridgeStatus.FlagTresholds.Builder flag_tresholdsBuilder;
    /** metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries() */
    private java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status> status;

    /** Creates a new Builder */
    private Builder() {
      super(trans.encoders.bridgeStatus.BridgeStatus.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(trans.encoders.bridgeStatus.BridgeStatus.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.descriptor_type)) {
        this.descriptor_type = data().deepCopy(fields()[0].schema(), other.descriptor_type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.src_date)) {
        this.src_date = data().deepCopy(fields()[1].schema(), other.src_date);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.published)) {
        this.published = data().deepCopy(fields()[2].schema(), other.published);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.flag_tresholds)) {
        this.flag_tresholds = data().deepCopy(fields()[3].schema(), other.flag_tresholds);
        fieldSetFlags()[3] = true;
      }
      if (other.hasFlagTresholdsBuilder()) {
        this.flag_tresholdsBuilder = trans.encoders.bridgeStatus.FlagTresholds.newBuilder(other.getFlagTresholdsBuilder());
      }
      if (isValidValue(fields()[4], other.status)) {
        this.status = data().deepCopy(fields()[4].schema(), other.status);
        fieldSetFlags()[4] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing BridgeStatus instance
     * @param other The existing instance to copy.
     */
    private Builder(trans.encoders.bridgeStatus.BridgeStatus other) {
            super(trans.encoders.bridgeStatus.BridgeStatus.SCHEMA$);
      if (isValidValue(fields()[0], other.descriptor_type)) {
        this.descriptor_type = data().deepCopy(fields()[0].schema(), other.descriptor_type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.src_date)) {
        this.src_date = data().deepCopy(fields()[1].schema(), other.src_date);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.published)) {
        this.published = data().deepCopy(fields()[2].schema(), other.published);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.flag_tresholds)) {
        this.flag_tresholds = data().deepCopy(fields()[3].schema(), other.flag_tresholds);
        fieldSetFlags()[3] = true;
      }
      this.flag_tresholdsBuilder = null;
      if (isValidValue(fields()[4], other.status)) {
        this.status = data().deepCopy(fields()[4].schema(), other.status);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'descriptor_type' field.
      * @return The value.
      */
    public java.lang.String getDescriptorType() {
      return descriptor_type;
    }

    /**
      * Sets the value of the 'descriptor_type' field.
      * @param value The value of 'descriptor_type'.
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder setDescriptorType(java.lang.String value) {
      validate(fields()[0], value);
      this.descriptor_type = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'descriptor_type' field has been set.
      * @return True if the 'descriptor_type' field has been set, false otherwise.
      */
    public boolean hasDescriptorType() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'descriptor_type' field.
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder clearDescriptorType() {
      descriptor_type = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'src_date' field.
      * file creation date, in milliseconds, of the data source to this conversion
      * @return The value.
      */
    public java.lang.Long getSrcDate() {
      return src_date;
    }

    /**
      * Sets the value of the 'src_date' field.
      * file creation date, in milliseconds, of the data source to this conversion
      * @param value The value of 'src_date'.
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder setSrcDate(java.lang.Long value) {
      validate(fields()[1], value);
      this.src_date = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'src_date' field has been set.
      * file creation date, in milliseconds, of the data source to this conversion
      * @return True if the 'src_date' field has been set, false otherwise.
      */
    public boolean hasSrcDate() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'src_date' field.
      * file creation date, in milliseconds, of the data source to this conversion
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder clearSrcDate() {
      src_date = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'published' field.
      * metrics-lib/BridgeNetworkStatus: long getPublishedMillis()
      * @return The value.
      */
    public java.lang.Long getPublished() {
      return published;
    }

    /**
      * Sets the value of the 'published' field.
      * metrics-lib/BridgeNetworkStatus: long getPublishedMillis()
      * @param value The value of 'published'.
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder setPublished(java.lang.Long value) {
      validate(fields()[2], value);
      this.published = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'published' field has been set.
      * metrics-lib/BridgeNetworkStatus: long getPublishedMillis()
      * @return True if the 'published' field has been set, false otherwise.
      */
    public boolean hasPublished() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'published' field.
      * metrics-lib/BridgeNetworkStatus: long getPublishedMillis()
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder clearPublished() {
      published = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'flag_tresholds' field.
      * see above
      * @return The value.
      */
    public trans.encoders.bridgeStatus.FlagTresholds getFlagTresholds() {
      return flag_tresholds;
    }

    /**
      * Sets the value of the 'flag_tresholds' field.
      * see above
      * @param value The value of 'flag_tresholds'.
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder setFlagTresholds(trans.encoders.bridgeStatus.FlagTresholds value) {
      validate(fields()[3], value);
      this.flag_tresholdsBuilder = null;
      this.flag_tresholds = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'flag_tresholds' field has been set.
      * see above
      * @return True if the 'flag_tresholds' field has been set, false otherwise.
      */
    public boolean hasFlagTresholds() {
      return fieldSetFlags()[3];
    }

    /**
     * Gets the Builder instance for the 'flag_tresholds' field and creates one if it doesn't exist yet.
     * see above
     * @return This builder.
     */
    public trans.encoders.bridgeStatus.FlagTresholds.Builder getFlagTresholdsBuilder() {
      if (flag_tresholdsBuilder == null) {
        if (hasFlagTresholds()) {
          setFlagTresholdsBuilder(trans.encoders.bridgeStatus.FlagTresholds.newBuilder(flag_tresholds));
        } else {
          setFlagTresholdsBuilder(trans.encoders.bridgeStatus.FlagTresholds.newBuilder());
        }
      }
      return flag_tresholdsBuilder;
    }

    /**
     * Sets the Builder instance for the 'flag_tresholds' field
     * see above
     * @return This builder.
     */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder setFlagTresholdsBuilder(trans.encoders.bridgeStatus.FlagTresholds.Builder value) {
      clearFlagTresholds();
      flag_tresholdsBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'flag_tresholds' field has an active Builder instance
     * see above
     * @return True if the 'flag_tresholds' field has an active Builder instance
     */
    public boolean hasFlagTresholdsBuilder() {
      return flag_tresholdsBuilder != null;
    }

    /**
      * Clears the value of the 'flag_tresholds' field.
      * see above
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder clearFlagTresholds() {
      flag_tresholds = null;
      flag_tresholdsBuilder = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries()
      * @return The value.
      */
    public java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status> getStatus() {
      return status;
    }

    /**
      * Sets the value of the 'status' field.
      * metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries()
      * @param value The value of 'status'.
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder setStatus(java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status> value) {
      validate(fields()[4], value);
      this.status = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'status' field has been set.
      * metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries()
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'status' field.
      * metrics-lib/BridgeNetworkStatus: SortedMap<String, NetworkStatusEntry> getStatusEntries()
      * @return This builder.
      */
    public trans.encoders.bridgeStatus.BridgeStatus.Builder clearStatus() {
      status = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public BridgeStatus build() {
      try {
        BridgeStatus record = new BridgeStatus();
        record.descriptor_type = fieldSetFlags()[0] ? this.descriptor_type : (java.lang.String) defaultValue(fields()[0]);
        record.src_date = fieldSetFlags()[1] ? this.src_date : (java.lang.Long) defaultValue(fields()[1]);
        record.published = fieldSetFlags()[2] ? this.published : (java.lang.Long) defaultValue(fields()[2]);
        if (flag_tresholdsBuilder != null) {
          record.flag_tresholds = this.flag_tresholdsBuilder.build();
        } else {
          record.flag_tresholds = fieldSetFlags()[3] ? this.flag_tresholds : (trans.encoders.bridgeStatus.FlagTresholds) defaultValue(fields()[3]);
        }
        record.status = fieldSetFlags()[4] ? this.status : (java.util.Map<java.lang.String,trans.encoders.bridgeStatus.Status>) defaultValue(fields()[4]);
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