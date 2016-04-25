/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.encoders.java.tordnsel;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Tordnsel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -796201060232282709L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Tordnsel\",\"namespace\":\"converTor.encoders.java.tordnsel\",\"fields\":[{\"name\":\"descriptor_type\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"default\":\"tordnsel 1.0\"},{\"name\":\"downloaded\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/ExitList: long getDownloadedMillis()\"},{\"name\":\"exit_nodes\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"ExitNode\",\"fields\":[{\"name\":\"fingerprint\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/ExitList.Entry: String getFingerprint()\"},{\"name\":\"published\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/ExitList.Entry: long getPublishedMillis()\"},{\"name\":\"last_status\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/ExitList.Entry: long getLastStatusMillis()\"},{\"name\":\"exit_adresses\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"long\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()\"}]}}],\"doc\":\"metrics-lib/ExitList: Set<ExitList.Entry> getEntries()\"}],\"aliases\":[\"exitList\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String descriptor_type;
  /** metrics-lib/ExitList: long getDownloadedMillis() */
  @Deprecated public java.lang.Long downloaded;
  /** metrics-lib/ExitList: Set<ExitList.Entry> getEntries() */
  @Deprecated public java.util.List<converTor.encoders.java.tordnsel.ExitNode> exit_nodes;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Tordnsel() {}

  /**
   * All-args constructor.
   * @param downloaded metrics-lib/ExitList: long getDownloadedMillis()
   * @param exit_nodes metrics-lib/ExitList: Set<ExitList.Entry> getEntries()
   */
  public Tordnsel(java.lang.String descriptor_type, java.lang.Long downloaded, java.util.List<converTor.encoders.java.tordnsel.ExitNode> exit_nodes) {
    this.descriptor_type = descriptor_type;
    this.downloaded = downloaded;
    this.exit_nodes = exit_nodes;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return descriptor_type;
    case 1: return downloaded;
    case 2: return exit_nodes;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: descriptor_type = (java.lang.String)value$; break;
    case 1: downloaded = (java.lang.Long)value$; break;
    case 2: exit_nodes = (java.util.List<converTor.encoders.java.tordnsel.ExitNode>)value$; break;
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
   * Gets the value of the 'downloaded' field.
   * @return metrics-lib/ExitList: long getDownloadedMillis()
   */
  public java.lang.Long getDownloaded() {
    return downloaded;
  }

  /**
   * Sets the value of the 'downloaded' field.
   * metrics-lib/ExitList: long getDownloadedMillis()
   * @param value the value to set.
   */
  public void setDownloaded(java.lang.Long value) {
    this.downloaded = value;
  }

  /**
   * Gets the value of the 'exit_nodes' field.
   * @return metrics-lib/ExitList: Set<ExitList.Entry> getEntries()
   */
  public java.util.List<converTor.encoders.java.tordnsel.ExitNode> getExitNodes() {
    return exit_nodes;
  }

  /**
   * Sets the value of the 'exit_nodes' field.
   * metrics-lib/ExitList: Set<ExitList.Entry> getEntries()
   * @param value the value to set.
   */
  public void setExitNodes(java.util.List<converTor.encoders.java.tordnsel.ExitNode> value) {
    this.exit_nodes = value;
  }

  /**
   * Creates a new Tordnsel RecordBuilder.
   * @return A new Tordnsel RecordBuilder
   */
  public static converTor.encoders.java.tordnsel.Tordnsel.Builder newBuilder() {
    return new converTor.encoders.java.tordnsel.Tordnsel.Builder();
  }
  
  /**
   * Creates a new Tordnsel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Tordnsel RecordBuilder
   */
  public static converTor.encoders.java.tordnsel.Tordnsel.Builder newBuilder(converTor.encoders.java.tordnsel.Tordnsel.Builder other) {
    return new converTor.encoders.java.tordnsel.Tordnsel.Builder(other);
  }
  
  /**
   * Creates a new Tordnsel RecordBuilder by copying an existing Tordnsel instance.
   * @param other The existing instance to copy.
   * @return A new Tordnsel RecordBuilder
   */
  public static converTor.encoders.java.tordnsel.Tordnsel.Builder newBuilder(converTor.encoders.java.tordnsel.Tordnsel other) {
    return new converTor.encoders.java.tordnsel.Tordnsel.Builder(other);
  }
  
  /**
   * RecordBuilder for Tordnsel instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Tordnsel>
    implements org.apache.avro.data.RecordBuilder<Tordnsel> {

    private java.lang.String descriptor_type;
    /** metrics-lib/ExitList: long getDownloadedMillis() */
    private java.lang.Long downloaded;
    /** metrics-lib/ExitList: Set<ExitList.Entry> getEntries() */
    private java.util.List<converTor.encoders.java.tordnsel.ExitNode> exit_nodes;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.encoders.java.tordnsel.Tordnsel.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.encoders.java.tordnsel.Tordnsel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.descriptor_type)) {
        this.descriptor_type = data().deepCopy(fields()[0].schema(), other.descriptor_type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.downloaded)) {
        this.downloaded = data().deepCopy(fields()[1].schema(), other.downloaded);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.exit_nodes)) {
        this.exit_nodes = data().deepCopy(fields()[2].schema(), other.exit_nodes);
        fieldSetFlags()[2] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing Tordnsel instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.encoders.java.tordnsel.Tordnsel other) {
            super(converTor.encoders.java.tordnsel.Tordnsel.SCHEMA$);
      if (isValidValue(fields()[0], other.descriptor_type)) {
        this.descriptor_type = data().deepCopy(fields()[0].schema(), other.descriptor_type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.downloaded)) {
        this.downloaded = data().deepCopy(fields()[1].schema(), other.downloaded);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.exit_nodes)) {
        this.exit_nodes = data().deepCopy(fields()[2].schema(), other.exit_nodes);
        fieldSetFlags()[2] = true;
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
    public converTor.encoders.java.tordnsel.Tordnsel.Builder setDescriptorType(java.lang.String value) {
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
    public converTor.encoders.java.tordnsel.Tordnsel.Builder clearDescriptorType() {
      descriptor_type = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'downloaded' field.
      * metrics-lib/ExitList: long getDownloadedMillis()
      * @return The value.
      */
    public java.lang.Long getDownloaded() {
      return downloaded;
    }

    /**
      * Sets the value of the 'downloaded' field.
      * metrics-lib/ExitList: long getDownloadedMillis()
      * @param value The value of 'downloaded'.
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.Tordnsel.Builder setDownloaded(java.lang.Long value) {
      validate(fields()[1], value);
      this.downloaded = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'downloaded' field has been set.
      * metrics-lib/ExitList: long getDownloadedMillis()
      * @return True if the 'downloaded' field has been set, false otherwise.
      */
    public boolean hasDownloaded() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'downloaded' field.
      * metrics-lib/ExitList: long getDownloadedMillis()
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.Tordnsel.Builder clearDownloaded() {
      downloaded = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'exit_nodes' field.
      * metrics-lib/ExitList: Set<ExitList.Entry> getEntries()
      * @return The value.
      */
    public java.util.List<converTor.encoders.java.tordnsel.ExitNode> getExitNodes() {
      return exit_nodes;
    }

    /**
      * Sets the value of the 'exit_nodes' field.
      * metrics-lib/ExitList: Set<ExitList.Entry> getEntries()
      * @param value The value of 'exit_nodes'.
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.Tordnsel.Builder setExitNodes(java.util.List<converTor.encoders.java.tordnsel.ExitNode> value) {
      validate(fields()[2], value);
      this.exit_nodes = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'exit_nodes' field has been set.
      * metrics-lib/ExitList: Set<ExitList.Entry> getEntries()
      * @return True if the 'exit_nodes' field has been set, false otherwise.
      */
    public boolean hasExitNodes() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'exit_nodes' field.
      * metrics-lib/ExitList: Set<ExitList.Entry> getEntries()
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.Tordnsel.Builder clearExitNodes() {
      exit_nodes = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public Tordnsel build() {
      try {
        Tordnsel record = new Tordnsel();
        record.descriptor_type = fieldSetFlags()[0] ? this.descriptor_type : (java.lang.String) defaultValue(fields()[0]);
        record.downloaded = fieldSetFlags()[1] ? this.downloaded : (java.lang.Long) defaultValue(fields()[1]);
        record.exit_nodes = fieldSetFlags()[2] ? this.exit_nodes : (java.util.List<converTor.encoders.java.tordnsel.ExitNode>) defaultValue(fields()[2]);
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
