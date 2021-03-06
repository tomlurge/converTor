/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package trans.encoders.bridgeExtra;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class HidservRendRelayedCells extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6451080655866172063L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"HidservRendRelayedCells\",\"namespace\":\"trans.encoders.bridgeExtra\",\"fields\":[{\"name\":\"cells\",\"type\":[\"null\",\"double\"],\"doc\":\"metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells()\"},{\"name\":\"obfuscation\",\"type\":[\"null\",{\"type\":\"map\",\"values\":\"double\",\"avro.java.string\":\"String\"}],\"doc\":\"metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters()\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells() */
  @Deprecated public java.lang.Double cells;
  /** metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters() */
  @Deprecated public java.util.Map<java.lang.String,java.lang.Double> obfuscation;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public HidservRendRelayedCells() {}

  /**
   * All-args constructor.
   * @param cells metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells()
   * @param obfuscation metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters()
   */
  public HidservRendRelayedCells(java.lang.Double cells, java.util.Map<java.lang.String,java.lang.Double> obfuscation) {
    this.cells = cells;
    this.obfuscation = obfuscation;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return cells;
    case 1: return obfuscation;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: cells = (java.lang.Double)value$; break;
    case 1: obfuscation = (java.util.Map<java.lang.String,java.lang.Double>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'cells' field.
   * @return metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells()
   */
  public java.lang.Double getCells() {
    return cells;
  }

  /**
   * Sets the value of the 'cells' field.
   * metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells()
   * @param value the value to set.
   */
  public void setCells(java.lang.Double value) {
    this.cells = value;
  }

  /**
   * Gets the value of the 'obfuscation' field.
   * @return metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters()
   */
  public java.util.Map<java.lang.String,java.lang.Double> getObfuscation() {
    return obfuscation;
  }

  /**
   * Sets the value of the 'obfuscation' field.
   * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters()
   * @param value the value to set.
   */
  public void setObfuscation(java.util.Map<java.lang.String,java.lang.Double> value) {
    this.obfuscation = value;
  }

  /**
   * Creates a new HidservRendRelayedCells RecordBuilder.
   * @return A new HidservRendRelayedCells RecordBuilder
   */
  public static trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder newBuilder() {
    return new trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder();
  }
  
  /**
   * Creates a new HidservRendRelayedCells RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new HidservRendRelayedCells RecordBuilder
   */
  public static trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder newBuilder(trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder other) {
    return new trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder(other);
  }
  
  /**
   * Creates a new HidservRendRelayedCells RecordBuilder by copying an existing HidservRendRelayedCells instance.
   * @param other The existing instance to copy.
   * @return A new HidservRendRelayedCells RecordBuilder
   */
  public static trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder newBuilder(trans.encoders.bridgeExtra.HidservRendRelayedCells other) {
    return new trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder(other);
  }
  
  /**
   * RecordBuilder for HidservRendRelayedCells instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<HidservRendRelayedCells>
    implements org.apache.avro.data.RecordBuilder<HidservRendRelayedCells> {

    /** metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells() */
    private java.lang.Double cells;
    /** metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters() */
    private java.util.Map<java.lang.String,java.lang.Double> obfuscation;

    /** Creates a new Builder */
    private Builder() {
      super(trans.encoders.bridgeExtra.HidservRendRelayedCells.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.cells)) {
        this.cells = data().deepCopy(fields()[0].schema(), other.cells);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.obfuscation)) {
        this.obfuscation = data().deepCopy(fields()[1].schema(), other.obfuscation);
        fieldSetFlags()[1] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing HidservRendRelayedCells instance
     * @param other The existing instance to copy.
     */
    private Builder(trans.encoders.bridgeExtra.HidservRendRelayedCells other) {
            super(trans.encoders.bridgeExtra.HidservRendRelayedCells.SCHEMA$);
      if (isValidValue(fields()[0], other.cells)) {
        this.cells = data().deepCopy(fields()[0].schema(), other.cells);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.obfuscation)) {
        this.obfuscation = data().deepCopy(fields()[1].schema(), other.obfuscation);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'cells' field.
      * metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells()
      * @return The value.
      */
    public java.lang.Double getCells() {
      return cells;
    }

    /**
      * Sets the value of the 'cells' field.
      * metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells()
      * @param value The value of 'cells'.
      * @return This builder.
      */
    public trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder setCells(java.lang.Double value) {
      validate(fields()[0], value);
      this.cells = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'cells' field has been set.
      * metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells()
      * @return True if the 'cells' field has been set, false otherwise.
      */
    public boolean hasCells() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'cells' field.
      * metrics-lib/ExtraInfoDescriptor: Double getHidservRendRelayedCells()
      * @return This builder.
      */
    public trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder clearCells() {
      cells = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'obfuscation' field.
      * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters()
      * @return The value.
      */
    public java.util.Map<java.lang.String,java.lang.Double> getObfuscation() {
      return obfuscation;
    }

    /**
      * Sets the value of the 'obfuscation' field.
      * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters()
      * @param value The value of 'obfuscation'.
      * @return This builder.
      */
    public trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder setObfuscation(java.util.Map<java.lang.String,java.lang.Double> value) {
      validate(fields()[1], value);
      this.obfuscation = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'obfuscation' field has been set.
      * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters()
      * @return True if the 'obfuscation' field has been set, false otherwise.
      */
    public boolean hasObfuscation() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'obfuscation' field.
      * metrics-lib/ExtraInfoDescriptor: Map<String, Double> getHidservRendRelayedCellsParameters()
      * @return This builder.
      */
    public trans.encoders.bridgeExtra.HidservRendRelayedCells.Builder clearObfuscation() {
      obfuscation = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public HidservRendRelayedCells build() {
      try {
        HidservRendRelayedCells record = new HidservRendRelayedCells();
        record.cells = fieldSetFlags()[0] ? this.cells : (java.lang.Double) defaultValue(fields()[0]);
        record.obfuscation = fieldSetFlags()[1] ? this.obfuscation : (java.util.Map<java.lang.String,java.lang.Double>) defaultValue(fields()[1]);
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
