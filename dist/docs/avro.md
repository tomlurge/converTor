# HOW 2 USE IT

## extract JSON schema(ta) from an Avro IDL file

    java -jar avro-tools-*.jar idl2schemata <descriptor>.avdl .
          generates a complete JSON schema for the IDL schema
          under the same name, with different ending
          and also one schema per nested record in the IDL schema
          those nested schemata can be deleted - we dont need them 
            
## compile (generate classes from) a schema
   
    java -jar avro-tools-*.jar compile -string schema <descriptor>.avsc .
          generates one class per schema and any nested record
          we need all those classes
          it generates the classpath as indicated in the @namespace
          attribute at the top of the IDL. tha namepace attribute has to 
          reflect the actual project structure or things will fall apart
            
## verbose description of how to compile java classes from IDL schemata

    copy all IDLs to a working directory together with avro-tools-*.jar
    in that directory execute (I renamed avro-tools-*.jar to atools.jar)
        
        ash:work t$ java -jar atools.jar idl2schemata bridge.avdl schemata
        ash:work t$ java -jar atools.jar idl2schemata bridgeExtra.avdl schemata
        ash:work t$ java -jar atools.jar idl2schemata bridgeStatus.avdl schemata
        ash:work t$ java -jar atools.jar idl2schemata relay.avdl schemata
        ash:work t$ java -jar atools.jar idl2schemata relayExtra.avdl schemata
        ash:work t$ java -jar atools.jar idl2schemata relayVote.avdl schemata
        ash:work t$ java -jar atools.jar idl2schemata relayConsensus.avdl schemata
        ash:work t$ java -jar atools.jar idl2schemata tordnsel.avdl schemata
        ash:work t$ java -jar atools.jar idl2schemata torperf.avdl schemata
        
    this will generate JSON schemata from the IDL schemata in the folder 'schemata'
        one for each IDL, named the same, but with ending .avsc instead of .avdl
        and a lot of .avdl-files for each nested record in the IDLs.
        copy only the main .avsc files to the root directory
        and to the src/encoders/json directory (for reference)
        delete the nested record .avsc files, the folder 'schemata' and the avdl-files
        
    from the working directory, that now should only contain the avro-tools.jar
    and the 9 avsc schema files generate the avro java classes
    
        ash:work t$ java -jar atools.jar compile -string schema relay.avsc .
        ash:work t$ java -jar atools.jar compile -string schema relayExtra.avsc .
        ash:work t$ java -jar atools.jar compile -string schema relayVote.avsc .
        ash:work t$ java -jar atools.jar compile -string schema relayConsensus.avsc .
        ash:work t$ java -jar atools.jar compile -string schema bridge.avsc .
        ash:work t$ java -jar atools.jar compile -string schema bridgeExtra.avsc .
        ash:work t$ java -jar atools.jar compile -string schema bridgeStatus.avsc .
        ash:work t$ java -jar atools.jar compile -string schema tordnsel.avsc .
        ash:work t$ java -jar atools.jar compile -string schema torperf.avsc .
  
     now you've got a 'trans.encoders.classes' folder with subfolders for each
     descriptor type. copy those to the same path in the /src directory. enjoy.
    
            
    convert .avro to JSON
      java -jar avro-tools-*.jar tojson myFile.avro > myFile.json
      
    get schema from avro file
      java -jar avro-tools-*.jar getschema torperf_2015-11.avro
 
    
# BACKGROUNDS
    
## SOME INTRODUCTORY DOCUMENTATION

    DOCS - 1.8.0 at the time of writing
      intro https://avro.apache.org/docs/current/gettingstartedjava.html
      spec  https://avro.apache.org/docs/current/spec.html
      idl   https://avro.apache.org/docs/current/idl.html
    MORE
      json  https://docs.oracle.com/cd/E26161_02/html/GettingStartedGuide/jsonbinding-overview.html
      avro+json+parquet   https://gist.github.com/hammer/76996fb8426a0ada233e
      good example of a complex schema: https://stackoverflow.com/questions/28163225/how-to-define-avro-schema-for-complex-json-document    

      
      
## IMPORTS

    import org.apache.avro.file.DataFileReader;
    import org.apache.avro.file.DataFileWriter;
    import org.apache.avro.io.DatumReader;
    import org.apache.avro.io.DatumWriter;
    import org.apache.avro.specific.SpecificDatumReader;
    import org.apache.avro.specific.SpecificDatumWriter;


## good to know:

 a schema file can only contain a single schema definition   
 eg {"name": "favorite_number",  "type": ["int", "null"]}
   favorite_number can either be an int or null, essentially making it an optional field. 

 IDL schemata have to be build up from the back
    since they support no forward referencing, it's not possible to start the 
    schema with the top/outer most element and work towards the details.
    so start reading (and writing) them from the end.
    

## Avro MAPPINGS

  generic
    a dynamic mapping, can be used even when the schema is not known ahead of runtime
  specific
    when you have a copy of the schema before you read or write data
    generated classes also provide a more domain-oriented API for user code than Generic ones.
  reflective
    maps Avro types onto preexisting Java types using reflection
    
    
## Avro TYPES

    null
    boolean
    int
    long
    float
    double
    bytes
    string
    array     items
    map       values, key has to be of type string
    record    fields
    enum      symbols
    fixed
    union


## WORKING WITH iT  (from hadoop def guide p350 ff)

sample SCHEMA

    {
      "type": "record",
      "name": "StringPair", 
      "doc": "A pair of strings.", 
      "fields": [
        {"name": "left", "type": "string"},
        {"name": "right", "type": "string"} 
      ]
    }


### using the _generic_ api

load the schema 
   
    Schema.Parser parser = new Schema.Parser(); 
    Schema mySchema = parser.parse(getClass().getResourceAsStream("mySchema.avsc"));
    
create an instance of the avro record  

    GenericRecord myDatum = new GenericData.Record(mySchema); 
    myDatum.put("left", "L");
    myDatum.put("right", "R");

serialize record   
.to output stream

    ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    DatumWriter<GenericRecord> myWriter = 
            new GenericDatumWriter<GenericRecord>(mySchema);
    Encoder myEncoder = EncoderFactory.get().binaryEncoder(out, null); 
    myWriter.write(myDatum, myEncoder);
    encoder.flush();
    out.close();
    
.to file

    File myFile = new File("data.avro"); 
    DatumWriter<GenericRecord> myWriter =
            new GenericDatumWriter<GenericRecord>(mySchema); 
    DataFileWriter<GenericRecord> dataFileWriter = 
            new DataFileWriter<GenericRecord>(myWriter);
    dataFileWriter.create(mySchema, myFile);
    dataFileWriter.append(myDatum);
    dataFileWriter.close();

To write a file to HDFS, we get an Output Stream by calling create() on 
FileSystem (see “Writing Data” on page 61).


### using the _specific_ api 

load the schema 

    create class 'StringPair' by using one of 3 options
      - maven (see hadoop def guide p351)
      - ant (see there)
      - avro command line tools      

create an instance of the avro record  

    StringPair myDatum = new StringPair();
    myDatum.setLeft("L");
    myDatum.setRight("R");

serialize record to output stream

    ByteArrayOutputStream out = new ByteArrayOutputStream(); 
    DatumWriter<StringPair> myWriter = 
            new SpecificDatumWriter<StringPair>(StringPair.class); 
    Encoder myEncoder = EncoderFactory.get().binaryEncoder(out, null); 
    myWriter.write(myDatum, myEncoder);
    myEncoder.flush();
    out.close();
    

##  Schemata + Avro TOOLS commands

    avro tools offer plenty of features, but is badly documented - use google!
   
    defining a schema for avro is possible in two ways
      JSON  verbose, cumbersome
      IDL   concise, tidy, lucid
    obviously IDL is the way to go
    but automatic building of the Java classes only works with JSON schemata
    avro-tools has an option to convert IDL to JSON: idl2schemata
    so the workflow for initial development of schemata is:
      define schemata in IDL (eg schema.avdl)
      extract JSON schemata of the types from an Avro IDL file
      % java -jar avro-tools-*.jar idl2schemata ~/schema.avdl .
     
    compile (generate classes from) a schema
      % java -jar avro-tools-*.jar compile -string schema ~/descriptor.avsc .
      //  the -string option is important because otherwise in some places 
      //  we get type charset instead of string
    
    convert .avro to JSON
    % java -jar avro-tools-*.jar tojson myFile.avro > myFile.json
      //  note the ">" - it's not in the docs, but nonetheless mandatory
      //  optional --pretty
      //  don't use totext, use tojson
      
    get schema from avro file
     java -jar avro-tools-*.jar getschema torperf_2015-11.avro
     
    some more tips
    http://www.michael-noll.com/blog/2013/03/17/reading-and-writing-avro-files-from-the-command-line/
    
    
## java 

### import

    http://www.hascode.com/2014/03/using-apache-avro-with-java-and-maven/
    
    import org.apache.avro.file.DataFileReader;
    import org.apache.avro.file.DataFileWriter;
    import org.apache.avro.io.DatumReader;
    import org.apache.avro.io.DatumWriter;
    import org.apache.avro.specific.SpecificDatumReader;
    import org.apache.avro.specific.SpecificDatumWriter;
 
    
### maven

    <dependencies>
    	<dependency>
    		<groupId>org.apache.avro</groupId>
    		<artifactId>avro</artifactId>
    		<version>1.7.7</version>
    	</dependency>
    </dependencies>
     
    <build>
    	<plugins>
    		<plugin>
    			<groupId>org.apache.avro</groupId>
    			<artifactId>avro-maven-plugin</artifactId>
    			<version>1.7.7</version>
    			<executions>
    				<execution>
    					<phase>generate-sources</phase>
    					<goals>
    						<goal>schema</goal>
    					</goals>
    					<configuration>
    						<sourceDirectory>${project.basedir}/src/main/avro/</sourceDirectory>
    						<outputDirectory>${project.basedir}/src/main/java/</outputDirectory>
    					</configuration>
    				</execution>
    			</executions>
    		</plugin>
    	</plugins>
    </build>

Replace the goal 'schema' with goal 'idl' and it will generate classes from an IDL

    <executions>
     <execution>
       <phase>generate-sources</phase>
       <goals>
         <goal>idl</goal>
       </goals>
       <configuration>
         <sourceDirectory>
           ${project.basedir}/src/main/avro/
         </sourceDirectory>
         <outputDirectory>
           ${project.basedir}/src/main/java/
         </outputDirectory>
       </configuration>
     </execution>
    </executions>
    
    AFTER THE FOLLOWING HINT FROM THE MAILING LIST:
    You don't need nothing but the Avro Maven plugin for generating Java classes 
    from Avro IDL. That is exactly what the idl goal does. Your snippet looks 
    nice, just configure the idl goal instead of the schema goal.

You may run the following command to create the class from the schema file:

    mvn generate-sources
    
A maven plugin is available that auto generates classes when the schema changes.


## PARQUET - AvroParquetWriter

The Avro schema is:

    {
      "type": "record",
      "name": "StringPair", "doc": "A pair of strings.", "fields": [
        {"name": "left", "type": "string"},
        {"name": "right", "type": "string"} 
      ]
    }

We create a schema instance and a generic record with:

    Schema.Parser parser = new Schema.Parser();
    Schema schema = parser.parse(getClass().getResourceAsStream("StringPair.avsc"));
    
    GenericRecord datum = new GenericData.Record(schema); 
    datum.put("left", "L");
    datum.put("right", "R");
    
Then we can write a Parquet file:

    Path path = new Path("data.parquet"); 
    AvroParquetWriter<GenericRecord> writer =
            new AvroParquetWriter<GenericRecord>(path, schema); 
    writer.write(datum);
    writer.close();

AvroParquetWriter converts the Avro schema into a Parquet schema, and also 
translates each Avro GenericRecord instance into the corresponding Parquet types 
to write to the Parquet file. The file is a regular Parquet file, with an extra 
piece of metadata to store the Avro schema. 
To see the Parquet schema that was generated from the Avro schema, we can use 
the following:

    % parquet-tools schema data.parquet 
    message StringPair {
      required binary left (UTF8);
      required binary right (UTF8);
    }

## GENERIC or SPECIFIC mapping

Avro specific mapping requires the auto generation of classes from the schema 
whereas generic mapping works from the schema directly. Generic mapping though 
doesn't provide static type checking.
Therefor, as much as we'd love to work with the schema directly, without any 
autogenerated classes in between, we don't want to abandon type checking. After
all, this is Java, isn't it!


## CONSTRUCTOR or BUILDER

After completing code generation, let's create some Users and set their fields.
    
    // Constructor
    User user1 = new User();
    user1.setName("Alyssa");
    user1.setFavoriteNumber(256);
    // Leave favorite color null
    
    // Alternate constructor
    User user2 = new User("Ben", 7, "red");
    
    // Construct via builder
    User user3 = User.newBuilder()
                 .setName("Charlie")
                 .setFavoriteColor("blue")
                 .setFavoriteNumber(null)
                 .build();
            
As shown in this example, Avro objects can be created either by invoking a 
constructor directly or by using a builder. Unlike constructors, builders will 
automatically set any default values specified in the schema. Additionally, 
builders validate the data as it set, whereas objects constructed directly will 
not cause an error until the object is serialized. However, using constructors 
directly generally offers better performance, as builders create a copy of the 
datastructure before it is written. 

  Builder
    
    - validate the data as it's set
    - automatically sets any default values specified in the schema
    - requires to set all fields even if they are null
    - however less performant because it constructs a complete datastructure in 
      memory before it is written 
    
  Constructor
  
    - validates when serializing
    - doesn't honor defaults from schema
    - fields don't need to be set explicitely if a default value is given (?)
    - datastructures are easier to constructs when building the record
    - is more performant
    
Conclusion: **constructor**s provide better performance and simpler code but 
**builder**s offer more type safety and better handling of defaults. 


##  e.g. Torperf descriptors
    
    provides 3 different types of conversion with Avro:
      SPECIFIC with CONSTRUCTOR
      SPECIFIC with BUILDER
      GENERIC
    
    
    //  SPECIFIC with CONSTRUCTOR
    class ConvertTorperf extends ConvertCommons {
    
      static Converted convert(TorperfResult desc) {
    
        Torperf conversion = new Torperf();
    
        conversion.setDescriptorType("torperf 1.0");
        conversion.setSource(desc.getSource());
        conversion.setFilesize(desc.getFileSize());
        conversion.setStart(desc.getStartMillis());
        conversion.setSocket(desc.getSocketMillis());
        conversion.setConnect(desc.getConnectMillis());
        conversion.setNegotiate(desc.getNegotiateMillis());
        conversion.setRequest(desc.getRequestMillis());
        conversion.setResponse(desc.getResponseMillis());
        conversion.setDatarequest(desc.getDataRequestMillis());
        conversion.setDataresponse(desc.getDataResponseMillis());
        conversion.setDatacomplete(desc.getDataCompleteMillis());
        conversion.setWritebytes(desc.getWriteBytes());
        conversion.setReadbytes(desc.getReadBytes());
        conversion.setDidtimeout(desc.didTimeout());
        if (desc.getDataPercentiles() != null && !desc.getDataPercentiles().isEmpty()) {
          conversion.setDataperc10(desc.getDataPercentiles().get(10));
          conversion.setDataperc20(desc.getDataPercentiles().get(20));
          conversion.setDataperc30(desc.getDataPercentiles().get(30));
          conversion.setDataperc40(desc.getDataPercentiles().get(40));
          conversion.setDataperc50(desc.getDataPercentiles().get(50));
          conversion.setDataperc60(desc.getDataPercentiles().get(60));
          conversion.setDataperc70(desc.getDataPercentiles().get(70));
          conversion.setDataperc80(desc.getDataPercentiles().get(80));
          conversion.setDataperc90(desc.getDataPercentiles().get(90));
        }
        conversion.setLaunch(desc.getLaunchMillis());
        conversion.setUsedAt(desc.getUsedAtMillis());
        if (desc.getPath() != null && !desc.getPath().isEmpty()) {
            conversion.setPath(desc.getPath());
        }
        conversion.setBuildtimes(desc.getBuildTimes());
        conversion.setTimeout(desc.getTimeout());
        conversion.setQuantile(desc.getQuantile());
        conversion.setCircId(desc.getCircId());
        conversion.setUsedBy(desc.getUsedBy());
    
        Converted converted = new Converted();
        converted.type = DescriptorType.torperfType;
        converted.date = dateTimeFormat.format(desc.getStartMillis()).substring(0,7);
        converted.load = conversion;
        return converted;
      }
    }
    
    
    //  SPECIFIC with BUILDER
    
    static class SpecificBuilderAvroTorperfDescriptor extends AvroDescriptor {
      static Torperf convert(TorperfResult desc) {
    
        //  tests needed below
        boolean percentiles = desc.getDataPercentiles() != null &&
                              !desc.getDataPercentiles().isEmpty();
        boolean path = desc.getPath() != null && !desc.getPath().isEmpty();
    
        Torperf torperf;
        torperf = Torperf.newBuilder()
    
                .setDescriptorType("torperf 1.0")
                .setSource(desc.getSource())
                .setFilesize(desc.getFileSize())
                .setStart(desc.getStartMillis())
                .setSocket(desc.getSocketMillis())
                .setConnect(desc.getConnectMillis())
                .setNegotiate(desc.getNegotiateMillis())
                .setRequest(desc.getRequestMillis())
                .setResponse(desc.getResponseMillis())
                .setDatarequest(desc.getDataRequestMillis())
                .setDataresponse(desc.getDataResponseMillis())
                .setDatacomplete(desc.getDataCompleteMillis())
                .setWritebytes(desc.getWriteBytes())
                .setReadbytes(desc.getReadBytes())
                .setDidtimeout(desc.didTimeout())
                .setDataperc10(percentiles ? desc.getDataPercentiles().get(10) : null)
                .setDataperc20(percentiles ? desc.getDataPercentiles().get(20) : null)
                .setDataperc30(percentiles ? desc.getDataPercentiles().get(30) : null)
                .setDataperc40(percentiles ? desc.getDataPercentiles().get(40) : null)
                .setDataperc50(percentiles ? desc.getDataPercentiles().get(50) : null)
                .setDataperc60(percentiles ? desc.getDataPercentiles().get(60) : null)
                .setDataperc70(percentiles ? desc.getDataPercentiles().get(70) : null)
                .setDataperc80(percentiles ? desc.getDataPercentiles().get(80) : null)
                .setDataperc90(percentiles ? desc.getDataPercentiles().get(90) : null)
                .setLaunch(desc.getLaunchMillis())
                .setUsedAt(desc.getUsedAtMillis())
                .setPath(path ? desc.getPath() : null)
                .setBuildtimes(desc.getBuildTimes())
                .setTimeout(desc.getTimeout())
                .setQuantile(desc.getQuantile())
                .setCircId(desc.getCircId())
                .setUsedBy(desc.getUsedBy())
    
                .build();
    
        return torperf;
      }
    }
    
    
    //  GENERIC
    
    static class GenericAvroTorperfDescriptor extends AvroDescriptor {
      static GenericRecord convert(GenericRecord torperf, TorperfResult desc) {
    
        //      manually check types for consistency
        //        yes, manually! one might think "this is java", but still...
        //        BUT there is a validatingEncoder that checks types
        //            against the schema while encoding
    
        torperf.put("descriptor_type", "torperf 1.0");
        torperf.put("source", desc.getSource());
        torperf.put("filesize", desc.getFileSize());
        torperf.put("start", dateTimeFormat.format(desc.getStartMillis()));
        torperf.put("socket", dateTimeFormat.format(desc.getSocketMillis()));
        torperf.put("connect", dateTimeFormat.format(desc.getConnectMillis()));
        torperf.put("negotiate", dateTimeFormat.format(desc.getNegotiateMillis()));
        torperf.put("request", dateTimeFormat.format(desc.getRequestMillis()));
        torperf.put("response", dateTimeFormat.format(desc.getResponseMillis()));
        torperf.put("datarequest", dateTimeFormat.format(desc.getDataRequestMillis()));
        torperf.put("dataresponse", dateTimeFormat.format(desc.getDataResponseMillis()));
        torperf.put("datacomplete", dateTimeFormat.format(desc.getDataCompleteMillis()));
        torperf.put("writebytes", desc.getWriteBytes());
        torperf.put("readbytes", desc.getReadBytes());
        torperf.put("didtimeout", desc.didTimeout());
        if (desc.getDataPercentiles() != null && !desc.getDataPercentiles().isEmpty()) {
          torperf.put("dataperc10", desc.getDataPercentiles().get(10));
          torperf.put("dataperc20", desc.getDataPercentiles().get(20));
          torperf.put("dataperc30", desc.getDataPercentiles().get(30));
          torperf.put("dataperc40", desc.getDataPercentiles().get(40));
          torperf.put("dataperc50", desc.getDataPercentiles().get(50));
          torperf.put("dataperc60", desc.getDataPercentiles().get(60));
          torperf.put("dataperc70", desc.getDataPercentiles().get(70));
          torperf.put("dataperc80", desc.getDataPercentiles().get(80));
          torperf.put("dataperc90", desc.getDataPercentiles().get(90));
        }
        torperf.put("launch", desc.getLaunchMillis());
        torperf.put("used_at", desc.getUsedAtMillis());
        torperf.put("path", desc.getPath());
        torperf.put("buildtimes", desc.getBuildTimes());
        torperf.put("timeout", desc.getTimeout());
        torperf.put("quantile", desc.getQuantile());
        torperf.put("circ_id", desc.getCircId());
        torperf.put("used_by", desc.getUsedBy());
    
        return torperf;
      }
    }

##  An example protocol in Avro IDL
 
@namespace("org.apache.avro.test")
protocol Simple {

    @aliases(["org.foo.KindOf"])
    enum Kind {
        FOO,
        BAR, // the bar enum value
        BAZ
    }

    fixed MD5(16);

    record TestRecord {
        @order("ignore")
        string name;

        @order("descending")
        Kind kind;

        MD5 hash;

        union { MD5, null} @aliases(["hash"]) nullableHash;

        array<long> arrayOfLongs;
    }

    error TestError {
        string message;
    }

    string hello(string greeting);
    TestRecord echo(TestRecord `record`);
    int add(int arg1, int arg2);
    bytes echoBytes(bytes data);
    void `error`() throws TestError;
    void ping() oneway;
}

    
    
    
    
## MISC
 
 
* defaults
  it is possible to have defaults with Avro, but they have to be declared 
  explicitly and the corresponding type has to be the first in the union.
    see:
    https://avro.apache.org/docs/current/spec.html#Unions
      Unions, as mentioned above, are represented using JSON arrays. For 
      example, ["null", "string"] declares a schema which may be either a null 
      or string.
      (Note that when a default value is specified for a record field whose type 
      is a union, the type of the default value must match the first element of 
      the union. Thus, for unions containing "null", the "null" is usually 
      listed first, since the default value of such unions is typically null.)
    https://avro.apache.org/docs/current/spec.html#schema_record
      Default values for union fields correspond to the first schema in the 
      union.