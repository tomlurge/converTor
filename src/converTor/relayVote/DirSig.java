/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package converTor.relayVote;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DirSig extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5751705824052911882L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DirSig\",\"namespace\":\"converTor.relayVote\",\"fields\":[{\"name\":\"algorithm\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirectorySignature: String getAlgorithm()\"},{\"name\":\"identity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirectorySignature: String getIdentity()\"},{\"name\":\"signing_key_digest\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirectorySignature: String getSigningKeyDigest()\"},{\"name\":\"signature\",\"type\":[\"null\",\"boolean\"],\"doc\":\"metrics-lib/DirectorySignature: String getSignature()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/DirectorySignature: String getAlgorithm() */
  @Deprecated public java.lang.String algorithm;
  /** metrics-lib/DirectorySignature: String getIdentity() */
  @Deprecated public java.lang.String identity;
  /** metrics-lib/DirectorySignature: String getSigningKeyDigest() */
  @Deprecated public java.lang.String signing_key_digest;
  /** metrics-lib/DirectorySignature: String getSignature() */
  @Deprecated public java.lang.Boolean signature;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DirSig() {}

  /**
   * All-args constructor.
   * @param algorithm metrics-lib/DirectorySignature: String getAlgorithm()
   * @param identity metrics-lib/DirectorySignature: String getIdentity()
   * @param signing_key_digest metrics-lib/DirectorySignature: String getSigningKeyDigest()
   * @param signature metrics-lib/DirectorySignature: String getSignature()
   */
  public DirSig(java.lang.String algorithm, java.lang.String identity, java.lang.String signing_key_digest, java.lang.Boolean signature) {
    this.algorithm = algorithm;
    this.identity = identity;
    this.signing_key_digest = signing_key_digest;
    this.signature = signature;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return algorithm;
    case 1: return identity;
    case 2: return signing_key_digest;
    case 3: return signature;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: algorithm = (java.lang.String)value$; break;
    case 1: identity = (java.lang.String)value$; break;
    case 2: signing_key_digest = (java.lang.String)value$; break;
    case 3: signature = (java.lang.Boolean)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'algorithm' field.
   * @return metrics-lib/DirectorySignature: String getAlgorithm()
   */
  public java.lang.String getAlgorithm() {
    return algorithm;
  }

  /**
   * Sets the value of the 'algorithm' field.
   * metrics-lib/DirectorySignature: String getAlgorithm()
   * @param value the value to set.
   */
  public void setAlgorithm(java.lang.String value) {
    this.algorithm = value;
  }

  /**
   * Gets the value of the 'identity' field.
   * @return metrics-lib/DirectorySignature: String getIdentity()
   */
  public java.lang.String getIdentity() {
    return identity;
  }

  /**
   * Sets the value of the 'identity' field.
   * metrics-lib/DirectorySignature: String getIdentity()
   * @param value the value to set.
   */
  public void setIdentity(java.lang.String value) {
    this.identity = value;
  }

  /**
   * Gets the value of the 'signing_key_digest' field.
   * @return metrics-lib/DirectorySignature: String getSigningKeyDigest()
   */
  public java.lang.String getSigningKeyDigest() {
    return signing_key_digest;
  }

  /**
   * Sets the value of the 'signing_key_digest' field.
   * metrics-lib/DirectorySignature: String getSigningKeyDigest()
   * @param value the value to set.
   */
  public void setSigningKeyDigest(java.lang.String value) {
    this.signing_key_digest = value;
  }

  /**
   * Gets the value of the 'signature' field.
   * @return metrics-lib/DirectorySignature: String getSignature()
   */
  public java.lang.Boolean getSignature() {
    return signature;
  }

  /**
   * Sets the value of the 'signature' field.
   * metrics-lib/DirectorySignature: String getSignature()
   * @param value the value to set.
   */
  public void setSignature(java.lang.Boolean value) {
    this.signature = value;
  }

  /**
   * Creates a new DirSig RecordBuilder.
   * @return A new DirSig RecordBuilder
   */
  public static converTor.relayVote.DirSig.Builder newBuilder() {
    return new converTor.relayVote.DirSig.Builder();
  }
  
  /**
   * Creates a new DirSig RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DirSig RecordBuilder
   */
  public static converTor.relayVote.DirSig.Builder newBuilder(converTor.relayVote.DirSig.Builder other) {
    return new converTor.relayVote.DirSig.Builder(other);
  }
  
  /**
   * Creates a new DirSig RecordBuilder by copying an existing DirSig instance.
   * @param other The existing instance to copy.
   * @return A new DirSig RecordBuilder
   */
  public static converTor.relayVote.DirSig.Builder newBuilder(converTor.relayVote.DirSig other) {
    return new converTor.relayVote.DirSig.Builder(other);
  }
  
  /**
   * RecordBuilder for DirSig instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DirSig>
    implements org.apache.avro.data.RecordBuilder<DirSig> {

    /** metrics-lib/DirectorySignature: String getAlgorithm() */
    private java.lang.String algorithm;
    /** metrics-lib/DirectorySignature: String getIdentity() */
    private java.lang.String identity;
    /** metrics-lib/DirectorySignature: String getSigningKeyDigest() */
    private java.lang.String signing_key_digest;
    /** metrics-lib/DirectorySignature: String getSignature() */
    private java.lang.Boolean signature;

    /** Creates a new Builder */
    private Builder() {
      super(converTor.relayVote.DirSig.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(converTor.relayVote.DirSig.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.algorithm)) {
        this.algorithm = data().deepCopy(fields()[0].schema(), other.algorithm);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.identity)) {
        this.identity = data().deepCopy(fields()[1].schema(), other.identity);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.signing_key_digest)) {
        this.signing_key_digest = data().deepCopy(fields()[2].schema(), other.signing_key_digest);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.signature)) {
        this.signature = data().deepCopy(fields()[3].schema(), other.signature);
        fieldSetFlags()[3] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing DirSig instance
     * @param other The existing instance to copy.
     */
    private Builder(converTor.relayVote.DirSig other) {
            super(converTor.relayVote.DirSig.SCHEMA$);
      if (isValidValue(fields()[0], other.algorithm)) {
        this.algorithm = data().deepCopy(fields()[0].schema(), other.algorithm);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.identity)) {
        this.identity = data().deepCopy(fields()[1].schema(), other.identity);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.signing_key_digest)) {
        this.signing_key_digest = data().deepCopy(fields()[2].schema(), other.signing_key_digest);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.signature)) {
        this.signature = data().deepCopy(fields()[3].schema(), other.signature);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'algorithm' field.
      * metrics-lib/DirectorySignature: String getAlgorithm()
      * @return The value.
      */
    public java.lang.String getAlgorithm() {
      return algorithm;
    }

    /**
      * Sets the value of the 'algorithm' field.
      * metrics-lib/DirectorySignature: String getAlgorithm()
      * @param value The value of 'algorithm'.
      * @return This builder.
      */
    public converTor.relayVote.DirSig.Builder setAlgorithm(java.lang.String value) {
      validate(fields()[0], value);
      this.algorithm = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'algorithm' field has been set.
      * metrics-lib/DirectorySignature: String getAlgorithm()
      * @return True if the 'algorithm' field has been set, false otherwise.
      */
    public boolean hasAlgorithm() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'algorithm' field.
      * metrics-lib/DirectorySignature: String getAlgorithm()
      * @return This builder.
      */
    public converTor.relayVote.DirSig.Builder clearAlgorithm() {
      algorithm = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'identity' field.
      * metrics-lib/DirectorySignature: String getIdentity()
      * @return The value.
      */
    public java.lang.String getIdentity() {
      return identity;
    }

    /**
      * Sets the value of the 'identity' field.
      * metrics-lib/DirectorySignature: String getIdentity()
      * @param value The value of 'identity'.
      * @return This builder.
      */
    public converTor.relayVote.DirSig.Builder setIdentity(java.lang.String value) {
      validate(fields()[1], value);
      this.identity = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'identity' field has been set.
      * metrics-lib/DirectorySignature: String getIdentity()
      * @return True if the 'identity' field has been set, false otherwise.
      */
    public boolean hasIdentity() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'identity' field.
      * metrics-lib/DirectorySignature: String getIdentity()
      * @return This builder.
      */
    public converTor.relayVote.DirSig.Builder clearIdentity() {
      identity = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'signing_key_digest' field.
      * metrics-lib/DirectorySignature: String getSigningKeyDigest()
      * @return The value.
      */
    public java.lang.String getSigningKeyDigest() {
      return signing_key_digest;
    }

    /**
      * Sets the value of the 'signing_key_digest' field.
      * metrics-lib/DirectorySignature: String getSigningKeyDigest()
      * @param value The value of 'signing_key_digest'.
      * @return This builder.
      */
    public converTor.relayVote.DirSig.Builder setSigningKeyDigest(java.lang.String value) {
      validate(fields()[2], value);
      this.signing_key_digest = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'signing_key_digest' field has been set.
      * metrics-lib/DirectorySignature: String getSigningKeyDigest()
      * @return True if the 'signing_key_digest' field has been set, false otherwise.
      */
    public boolean hasSigningKeyDigest() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'signing_key_digest' field.
      * metrics-lib/DirectorySignature: String getSigningKeyDigest()
      * @return This builder.
      */
    public converTor.relayVote.DirSig.Builder clearSigningKeyDigest() {
      signing_key_digest = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'signature' field.
      * metrics-lib/DirectorySignature: String getSignature()
      * @return The value.
      */
    public java.lang.Boolean getSignature() {
      return signature;
    }

    /**
      * Sets the value of the 'signature' field.
      * metrics-lib/DirectorySignature: String getSignature()
      * @param value The value of 'signature'.
      * @return This builder.
      */
    public converTor.relayVote.DirSig.Builder setSignature(java.lang.Boolean value) {
      validate(fields()[3], value);
      this.signature = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'signature' field has been set.
      * metrics-lib/DirectorySignature: String getSignature()
      * @return True if the 'signature' field has been set, false otherwise.
      */
    public boolean hasSignature() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'signature' field.
      * metrics-lib/DirectorySignature: String getSignature()
      * @return This builder.
      */
    public converTor.relayVote.DirSig.Builder clearSignature() {
      signature = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public DirSig build() {
      try {
        DirSig record = new DirSig();
        record.algorithm = fieldSetFlags()[0] ? this.algorithm : (java.lang.String) defaultValue(fields()[0]);
        record.identity = fieldSetFlags()[1] ? this.identity : (java.lang.String) defaultValue(fields()[1]);
        record.signing_key_digest = fieldSetFlags()[2] ? this.signing_key_digest : (java.lang.String) defaultValue(fields()[2]);
        record.signature = fieldSetFlags()[3] ? this.signature : (java.lang.Boolean) defaultValue(fields()[3]);
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
