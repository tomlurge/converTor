/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package convertor.encoders.relayConsensus;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DirFooter extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4242954384223697240L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DirFooter\",\"namespace\":\"convertor.encoders.relayConsensus\",\"fields\":[{\"name\":\"bandwidth_weights\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"int\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights()\"},{\"name\":\"consensus_digest\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest()\"},{\"name\":\"directory_signature\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"DirSig\",\"fields\":[{\"name\":\"algorithm\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirectorySignature: String getAlgorithm()\",\"default\":\"sha1\"},{\"name\":\"identity\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirectorySignature: String getIdentity()\"},{\"name\":\"signing_key_digest\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/DirectorySignature: String getSigningKeyDigest()\"},{\"name\":\"signature\",\"type\":[\"null\",\"boolean\"],\"doc\":\"metrics-lib/DirectorySignature: String getSignature()\"}]}}],\"doc\":\"metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights() */
  @Deprecated public java.util.Map<java.lang.String,java.lang.Integer> bandwidth_weights;
  /** metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest() */
  @Deprecated public java.lang.String consensus_digest;
  /** metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures() */
  @Deprecated public java.util.List<convertor.encoders.relayConsensus.DirSig> directory_signature;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DirFooter() {}

  /**
   * All-args constructor.
   * @param bandwidth_weights metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights()
   * @param consensus_digest metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest()
   * @param directory_signature metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures()
   */
  public DirFooter(java.util.Map<java.lang.String,java.lang.Integer> bandwidth_weights, java.lang.String consensus_digest, java.util.List<convertor.encoders.relayConsensus.DirSig> directory_signature) {
    this.bandwidth_weights = bandwidth_weights;
    this.consensus_digest = consensus_digest;
    this.directory_signature = directory_signature;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return bandwidth_weights;
    case 1: return consensus_digest;
    case 2: return directory_signature;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: bandwidth_weights = (java.util.Map<java.lang.String,java.lang.Integer>)value$; break;
    case 1: consensus_digest = (java.lang.String)value$; break;
    case 2: directory_signature = (java.util.List<convertor.encoders.relayConsensus.DirSig>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'bandwidth_weights' field.
   * @return metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights()
   */
  public java.util.Map<java.lang.String,java.lang.Integer> getBandwidthWeights() {
    return bandwidth_weights;
  }

  /**
   * Sets the value of the 'bandwidth_weights' field.
   * metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights()
   * @param value the value to set.
   */
  public void setBandwidthWeights(java.util.Map<java.lang.String,java.lang.Integer> value) {
    this.bandwidth_weights = value;
  }

  /**
   * Gets the value of the 'consensus_digest' field.
   * @return metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest()
   */
  public java.lang.String getConsensusDigest() {
    return consensus_digest;
  }

  /**
   * Sets the value of the 'consensus_digest' field.
   * metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest()
   * @param value the value to set.
   */
  public void setConsensusDigest(java.lang.String value) {
    this.consensus_digest = value;
  }

  /**
   * Gets the value of the 'directory_signature' field.
   * @return metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures()
   */
  public java.util.List<convertor.encoders.relayConsensus.DirSig> getDirectorySignature() {
    return directory_signature;
  }

  /**
   * Sets the value of the 'directory_signature' field.
   * metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures()
   * @param value the value to set.
   */
  public void setDirectorySignature(java.util.List<convertor.encoders.relayConsensus.DirSig> value) {
    this.directory_signature = value;
  }

  /**
   * Creates a new DirFooter RecordBuilder.
   * @return A new DirFooter RecordBuilder
   */
  public static convertor.encoders.relayConsensus.DirFooter.Builder newBuilder() {
    return new convertor.encoders.relayConsensus.DirFooter.Builder();
  }
  
  /**
   * Creates a new DirFooter RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new DirFooter RecordBuilder
   */
  public static convertor.encoders.relayConsensus.DirFooter.Builder newBuilder(convertor.encoders.relayConsensus.DirFooter.Builder other) {
    return new convertor.encoders.relayConsensus.DirFooter.Builder(other);
  }
  
  /**
   * Creates a new DirFooter RecordBuilder by copying an existing DirFooter instance.
   * @param other The existing instance to copy.
   * @return A new DirFooter RecordBuilder
   */
  public static convertor.encoders.relayConsensus.DirFooter.Builder newBuilder(convertor.encoders.relayConsensus.DirFooter other) {
    return new convertor.encoders.relayConsensus.DirFooter.Builder(other);
  }
  
  /**
   * RecordBuilder for DirFooter instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DirFooter>
    implements org.apache.avro.data.RecordBuilder<DirFooter> {

    /** metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights() */
    private java.util.Map<java.lang.String,java.lang.Integer> bandwidth_weights;
    /** metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest() */
    private java.lang.String consensus_digest;
    /** metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures() */
    private java.util.List<convertor.encoders.relayConsensus.DirSig> directory_signature;

    /** Creates a new Builder */
    private Builder() {
      super(convertor.encoders.relayConsensus.DirFooter.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(convertor.encoders.relayConsensus.DirFooter.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.bandwidth_weights)) {
        this.bandwidth_weights = data().deepCopy(fields()[0].schema(), other.bandwidth_weights);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.consensus_digest)) {
        this.consensus_digest = data().deepCopy(fields()[1].schema(), other.consensus_digest);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.directory_signature)) {
        this.directory_signature = data().deepCopy(fields()[2].schema(), other.directory_signature);
        fieldSetFlags()[2] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing DirFooter instance
     * @param other The existing instance to copy.
     */
    private Builder(convertor.encoders.relayConsensus.DirFooter other) {
            super(convertor.encoders.relayConsensus.DirFooter.SCHEMA$);
      if (isValidValue(fields()[0], other.bandwidth_weights)) {
        this.bandwidth_weights = data().deepCopy(fields()[0].schema(), other.bandwidth_weights);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.consensus_digest)) {
        this.consensus_digest = data().deepCopy(fields()[1].schema(), other.consensus_digest);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.directory_signature)) {
        this.directory_signature = data().deepCopy(fields()[2].schema(), other.directory_signature);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'bandwidth_weights' field.
      * metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights()
      * @return The value.
      */
    public java.util.Map<java.lang.String,java.lang.Integer> getBandwidthWeights() {
      return bandwidth_weights;
    }

    /**
      * Sets the value of the 'bandwidth_weights' field.
      * metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights()
      * @param value The value of 'bandwidth_weights'.
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.DirFooter.Builder setBandwidthWeights(java.util.Map<java.lang.String,java.lang.Integer> value) {
      validate(fields()[0], value);
      this.bandwidth_weights = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'bandwidth_weights' field has been set.
      * metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights()
      * @return True if the 'bandwidth_weights' field has been set, false otherwise.
      */
    public boolean hasBandwidthWeights() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'bandwidth_weights' field.
      * metrics-lib/RelayNetworkStatusConsensus: SortedMap<String, Integer> getBandwidthWeights()
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.DirFooter.Builder clearBandwidthWeights() {
      bandwidth_weights = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'consensus_digest' field.
      * metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest()
      * @return The value.
      */
    public java.lang.String getConsensusDigest() {
      return consensus_digest;
    }

    /**
      * Sets the value of the 'consensus_digest' field.
      * metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest()
      * @param value The value of 'consensus_digest'.
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.DirFooter.Builder setConsensusDigest(java.lang.String value) {
      validate(fields()[1], value);
      this.consensus_digest = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'consensus_digest' field has been set.
      * metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest()
      * @return True if the 'consensus_digest' field has been set, false otherwise.
      */
    public boolean hasConsensusDigest() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'consensus_digest' field.
      * metrics-lib/RelayNetworkStatusConsensus: String getConsensusDigest()
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.DirFooter.Builder clearConsensusDigest() {
      consensus_digest = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'directory_signature' field.
      * metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures()
      * @return The value.
      */
    public java.util.List<convertor.encoders.relayConsensus.DirSig> getDirectorySignature() {
      return directory_signature;
    }

    /**
      * Sets the value of the 'directory_signature' field.
      * metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures()
      * @param value The value of 'directory_signature'.
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.DirFooter.Builder setDirectorySignature(java.util.List<convertor.encoders.relayConsensus.DirSig> value) {
      validate(fields()[2], value);
      this.directory_signature = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'directory_signature' field has been set.
      * metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures()
      * @return True if the 'directory_signature' field has been set, false otherwise.
      */
    public boolean hasDirectorySignature() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'directory_signature' field.
      * metrics-lib/RelayNetworkStatusConsensus: List<DirectorySignature> getSignatures()
      * @return This builder.
      */
    public convertor.encoders.relayConsensus.DirFooter.Builder clearDirectorySignature() {
      directory_signature = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public DirFooter build() {
      try {
        DirFooter record = new DirFooter();
        record.bandwidth_weights = fieldSetFlags()[0] ? this.bandwidth_weights : (java.util.Map<java.lang.String,java.lang.Integer>) defaultValue(fields()[0]);
        record.consensus_digest = fieldSetFlags()[1] ? this.consensus_digest : (java.lang.String) defaultValue(fields()[1]);
        record.directory_signature = fieldSetFlags()[2] ? this.directory_signature : (java.util.List<convertor.encoders.relayConsensus.DirSig>) defaultValue(fields()[2]);
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
