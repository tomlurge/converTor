/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.encoders.java.tordnsel;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ExitNode extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2745327624495407292L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ExitNode\",\"namespace\":\"converTor.encoders.java.tordnsel\",\"fields\":[{\"name\":\"fingerprint\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/ExitList.Entry: String getFingerprint()\"},{\"name\":\"published\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/ExitList.Entry: long getPublishedMillis()\"},{\"name\":\"last_status\",\"type\":[\"null\",\"long\"],\"doc\":\"metrics-lib/ExitList.Entry: long getLastStatusMillis()\"},{\"name\":\"exit_adresses\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"long\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/ExitList.Entry: String getFingerprint() */
  @Deprecated public java.lang.String fingerprint;
  /** metrics-lib/ExitList.Entry: long getPublishedMillis() */
  @Deprecated public java.lang.Long published;
  /** metrics-lib/ExitList.Entry: long getLastStatusMillis() */
  @Deprecated public java.lang.Long last_status;
  /** metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses() */
  @Deprecated public java.util.Map<java.lang.String,java.lang.Long> exit_adresses;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ExitNode() {}

  /**
   * All-args constructor.
   * @param fingerprint metrics-lib/ExitList.Entry: String getFingerprint()
   * @param published metrics-lib/ExitList.Entry: long getPublishedMillis()
   * @param last_status metrics-lib/ExitList.Entry: long getLastStatusMillis()
   * @param exit_adresses metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()
   */
  public ExitNode(java.lang.String fingerprint, java.lang.Long published, java.lang.Long last_status, java.util.Map<java.lang.String,java.lang.Long> exit_adresses) {
    this.fingerprint = fingerprint;
    this.published = published;
    this.last_status = last_status;
    this.exit_adresses = exit_adresses;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return fingerprint;
    case 1: return published;
    case 2: return last_status;
    case 3: return exit_adresses;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: fingerprint = (java.lang.String)value$; break;
    case 1: published = (java.lang.Long)value$; break;
    case 2: last_status = (java.lang.Long)value$; break;
    case 3: exit_adresses = (java.util.Map<java.lang.String,java.lang.Long>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'fingerprint' field.
   * @return metrics-lib/ExitList.Entry: String getFingerprint()
   */
  public java.lang.String getFingerprint() {
    return fingerprint;
  }

  /**
   * Sets the value of the 'fingerprint' field.
   * metrics-lib/ExitList.Entry: String getFingerprint()
   * @param value the value to set.
   */
  public void setFingerprint(java.lang.String value) {
    this.fingerprint = value;
  }

  /**
   * Gets the value of the 'published' field.
   * @return metrics-lib/ExitList.Entry: long getPublishedMillis()
   */
  public java.lang.Long getPublished() {
    return published;
  }

  /**
   * Sets the value of the 'published' field.
   * metrics-lib/ExitList.Entry: long getPublishedMillis()
   * @param value the value to set.
   */
  public void setPublished(java.lang.Long value) {
    this.published = value;
  }

  /**
   * Gets the value of the 'last_status' field.
   * @return metrics-lib/ExitList.Entry: long getLastStatusMillis()
   */
  public java.lang.Long getLastStatus() {
    return last_status;
  }

  /**
   * Sets the value of the 'last_status' field.
   * metrics-lib/ExitList.Entry: long getLastStatusMillis()
   * @param value the value to set.
   */
  public void setLastStatus(java.lang.Long value) {
    this.last_status = value;
  }

  /**
   * Gets the value of the 'exit_adresses' field.
   * @return metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()
   */
  public java.util.Map<java.lang.String,java.lang.Long> getExitAdresses() {
    return exit_adresses;
  }

  /**
   * Sets the value of the 'exit_adresses' field.
   * metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()
   * @param value the value to set.
   */
  public void setExitAdresses(java.util.Map<java.lang.String,java.lang.Long> value) {
    this.exit_adresses = value;
  }

  /**
   * Creates a new ExitNode RecordBuilder.
   * @return A new ExitNode RecordBuilder
   */
  public static converTor.encoders.java.tordnsel.ExitNode.Builder newBuilder() {
    return new converTor.encoders.java.tordnsel.ExitNode.Builder();
  }
  
  /**
   * Creates a new ExitNode RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ExitNode RecordBuilder
   */
  public static converTor.encoders.java.tordnsel.ExitNode.Builder newBuilder(converTor.encoders.java.tordnsel.ExitNode.Builder other) {
    return new converTor.encoders.java.tordnsel.ExitNode.Builder(other);
  }
  
  /**
   * Creates a new ExitNode RecordBuilder by copying an existing ExitNode instance.
   * @param other The existing instance to copy.
   * @return A new ExitNode RecordBuilder
   */
  public static converTor.encoders.java.tordnsel.ExitNode.Builder newBuilder(converTor.encoders.java.tordnsel.ExitNode other) {
    return new converTor.encoders.java.tordnsel.ExitNode.Builder(other);
  }
  
  /**
   * RecordBuilder for ExitNode instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ExitNode>
    implements org.apache.avro.data.RecordBuilder<ExitNode> {

    /** metrics-lib/ExitList.Entry: String getFingerprint() */
    private java.lang.String fingerprint;
    /** metrics-lib/ExitList.Entry: long getPublishedMillis() */
    private java.lang.Long published;
    /** metrics-lib/ExitList.Entry: long getLastStatusMillis() */
    private java.lang.Long last_status;
    /** metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses() */
    private java.util.Map<java.lang.String,java.lang.Long> exit_adresses;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.encoders.java.tordnsel.ExitNode.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.encoders.java.tordnsel.ExitNode.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.fingerprint)) {
        this.fingerprint = data().deepCopy(fields()[0].schema(), other.fingerprint);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.published)) {
        this.published = data().deepCopy(fields()[1].schema(), other.published);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.last_status)) {
        this.last_status = data().deepCopy(fields()[2].schema(), other.last_status);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.exit_adresses)) {
        this.exit_adresses = data().deepCopy(fields()[3].schema(), other.exit_adresses);
        fieldSetFlags()[3] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing ExitNode instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.encoders.java.tordnsel.ExitNode other) {
            super(converTor.encoders.java.tordnsel.ExitNode.SCHEMA$);
      if (isValidValue(fields()[0], other.fingerprint)) {
        this.fingerprint = data().deepCopy(fields()[0].schema(), other.fingerprint);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.published)) {
        this.published = data().deepCopy(fields()[1].schema(), other.published);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.last_status)) {
        this.last_status = data().deepCopy(fields()[2].schema(), other.last_status);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.exit_adresses)) {
        this.exit_adresses = data().deepCopy(fields()[3].schema(), other.exit_adresses);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'fingerprint' field.
      * metrics-lib/ExitList.Entry: String getFingerprint()
      * @return The value.
      */
    public java.lang.String getFingerprint() {
      return fingerprint;
    }

    /**
      * Sets the value of the 'fingerprint' field.
      * metrics-lib/ExitList.Entry: String getFingerprint()
      * @param value The value of 'fingerprint'.
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.ExitNode.Builder setFingerprint(java.lang.String value) {
      validate(fields()[0], value);
      this.fingerprint = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'fingerprint' field has been set.
      * metrics-lib/ExitList.Entry: String getFingerprint()
      * @return True if the 'fingerprint' field has been set, false otherwise.
      */
    public boolean hasFingerprint() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'fingerprint' field.
      * metrics-lib/ExitList.Entry: String getFingerprint()
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.ExitNode.Builder clearFingerprint() {
      fingerprint = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'published' field.
      * metrics-lib/ExitList.Entry: long getPublishedMillis()
      * @return The value.
      */
    public java.lang.Long getPublished() {
      return published;
    }

    /**
      * Sets the value of the 'published' field.
      * metrics-lib/ExitList.Entry: long getPublishedMillis()
      * @param value The value of 'published'.
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.ExitNode.Builder setPublished(java.lang.Long value) {
      validate(fields()[1], value);
      this.published = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'published' field has been set.
      * metrics-lib/ExitList.Entry: long getPublishedMillis()
      * @return True if the 'published' field has been set, false otherwise.
      */
    public boolean hasPublished() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'published' field.
      * metrics-lib/ExitList.Entry: long getPublishedMillis()
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.ExitNode.Builder clearPublished() {
      published = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'last_status' field.
      * metrics-lib/ExitList.Entry: long getLastStatusMillis()
      * @return The value.
      */
    public java.lang.Long getLastStatus() {
      return last_status;
    }

    /**
      * Sets the value of the 'last_status' field.
      * metrics-lib/ExitList.Entry: long getLastStatusMillis()
      * @param value The value of 'last_status'.
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.ExitNode.Builder setLastStatus(java.lang.Long value) {
      validate(fields()[2], value);
      this.last_status = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'last_status' field has been set.
      * metrics-lib/ExitList.Entry: long getLastStatusMillis()
      * @return True if the 'last_status' field has been set, false otherwise.
      */
    public boolean hasLastStatus() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'last_status' field.
      * metrics-lib/ExitList.Entry: long getLastStatusMillis()
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.ExitNode.Builder clearLastStatus() {
      last_status = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'exit_adresses' field.
      * metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()
      * @return The value.
      */
    public java.util.Map<java.lang.String,java.lang.Long> getExitAdresses() {
      return exit_adresses;
    }

    /**
      * Sets the value of the 'exit_adresses' field.
      * metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()
      * @param value The value of 'exit_adresses'.
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.ExitNode.Builder setExitAdresses(java.util.Map<java.lang.String,java.lang.Long> value) {
      validate(fields()[3], value);
      this.exit_adresses = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'exit_adresses' field has been set.
      * metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()
      * @return True if the 'exit_adresses' field has been set, false otherwise.
      */
    public boolean hasExitAdresses() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'exit_adresses' field.
      * metrics-lib/ExitList.Entry: Map<String, Long> getExitAddresses()
      * @return This builder.
      */
    public converTor.encoders.java.tordnsel.ExitNode.Builder clearExitAdresses() {
      exit_adresses = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public ExitNode build() {
      try {
        ExitNode record = new ExitNode();
        record.fingerprint = fieldSetFlags()[0] ? this.fingerprint : (java.lang.String) defaultValue(fields()[0]);
        record.published = fieldSetFlags()[1] ? this.published : (java.lang.Long) defaultValue(fields()[1]);
        record.last_status = fieldSetFlags()[2] ? this.last_status : (java.lang.Long) defaultValue(fields()[2]);
        record.exit_adresses = fieldSetFlags()[3] ? this.exit_adresses : (java.util.Map<java.lang.String,java.lang.Long>) defaultValue(fields()[3]);
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
