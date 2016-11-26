# ConverTor

ConverTor is a command line tool to convert Tor network server descriptors from 
[The Tor Project](https://www.torproject.org/)'s own serialization to more 
popular formats like JSON and Parquet, thereby making them readily accessible to 
analytics tools like Tableau, MongoDB or Apache Spark without the need to resort 
to specialized libraries for accessing them. 


Background
==========

Descriptors get emitted by servers in the Tor network every hour. They are 
collected by the [CollecTor](https://collector.torproject.org/) service and from 
there published in hourly, daily or monthly archives. They are cleaned to 
preserve the privacy properties of the Tor network but still provide a lot of 
insights into the workings of Tor that are valuable for administration, 
development and research. The format of these descriptors is optimized for size 
to allow for efficient transfer over the network. Specialized libraries like 
[metrics-lib](https://dist.torproject.org/descriptor/) (Java) or [stem]
(https://stem.torproject.org/) (Python) are used to access them, which makes 
them hard to access for non programmers. Additionally, since the data format is 
homegrown, it is not possible to work on them with of the mill data science and
big data analytics softwares like Apache Spark, Tableau or the popular MongoDB
NoSQL database. 


How to build
============
On the shell navigate to the project directory (same level as build.xml).  
For building an executable jar complete with merged dependencies and schemata 
just enter `ant`. Look into ./dist for the result. To get everything enter:

    ant clean jar bundle


How to use
==========
On the shell enter:

    java -jar converTor.jar
    
to get a rundwon of available options. A call to convert some descriptors might
look like this:

    java -jar converTor.jar -i=/collector -o=/json -l=/log -cz -g &> log.txt
    
Note the addition of `&> log.txt` which writes error messages to a file.

A reasonable setup could be a working directory - let's call it `work` - in 
which you put `convertor.jar` and 2 subdirectories, `in`with the descriptors to 
convert and `out` for the converted descriptors.  
Maybe you need them as JSON, pretty printed (because you want to have a look at 
them yourself) and you could do:

    java -jar converTor.jar -i=in/ -o=out/ -p
    
If you want to start working with them in MomgoDB right away, you've got to omit
the pretty printing and are well advised to use compression, e.g. like this:

    java -jar converTor.jar -i=in/ -o=out/ -cz
    
Or you need them all as compressed Parquet files to work on them with Spark, 
plus logging enabled to make sure you don't miss anything:

    java -jar converTor.jar -i=in/ -o=out/ -f=parquet --snappy --log

Possible parameters are:

    -f    --format     <arg>    default: json, optional: parquet, avro
    -s    --suffix              a suffix to the file name                                     
    -i    --inPath     <arg>    default: current working directory    
    -o    --outPath    <arg>    default: current working directory    
    -l    --logsPath   <arg>    default: current working directory    
    -cs   --snappy              a compression format popular with Parquet
    -cz   --zip                 compressing Avro as BZip2, Parquet & JSON as GZip 
    -p    --pretty              pretty printed JSON                   
    -m    --maxFiles   <arg>    max files to be opened, default: 20                           
    -d    --debug               print JSON descriptors to console     
    -g    --log                 log to file 'converTor.log'           
    

Caveats
=======

Data might contain double entries. See [CollecTor](https://collector.torproject.org/#data-formats)
for more details.
Pretty printed JSON is primarily intended for human consumption and debugging.
Softwares often require every JSON record in one line (eg. Spark otherwise 
can't ingest it, but MongoDB won't complain).


TODO
====

- incorporate recent metrics-lib/DescripTor updates
- tests (dependend on test descriptors from the Tor metrics team)
- a flattened version, less faithful to the structure of the spec (maybe as CSV)


These are only the most important issues. For a complete overview see [TODO.md]
(TODO.md).


Code overview
=============

`Base` is the class that contains the main method.

The `main` method initializes a new `Base` *base*, which in turn initializes 
`Args` and `Writers` singletons.
`Args` contains default arguments like input directory, output format etc and
evaluates command line arguments.
`Writers` stores fileWriters per descriptor_type and month. It initializes new
fileWriters on demand, according to the type and date of incoming descriptor
and the configured format.

After initialization `main` calls `runConversion()` on the *base* just created
which iterates over the incoming descriptors, converts them according to 
type, gets the appropriate fileWriter from `Writers` and appends the converted 
descriptors to this fileWriter.

Actual converters (`ConvertRelay`, `ConvertBridge` etc) are all subclasses of 
the abstract Class `Convert`. Actual Writers (`WriteAvro`, `WriteParquet` and 
`WriteJson`) are all implementations of the interface `Writer`. Actual 
descriptor types, their properties and methods are all defined as enums in 
`Types`.

Encoding of the converted descriptors is managed in the `WriterXXXX` classes and 
relies on the encoder schemata and autogenerated Avro classes in the package 
`encoders`.

After all descriptors are converted `closeAllWriters()` is called to perform 
some housekeeping, making sure that all writers write to disk before the program
exits.


Avro Schemata
=============
ConverTor uses [Apache Avro](https://avro.apache.org/) to encode the descriptor 
data model in JSON serialization. Java classes autogenerated from this model 
power the conversion from descriptor to Avro, Parquet and JSON. The schemata 
stored in `schema/IDL/*.avdl` are the source from which JSON schemata (see 
`schema/*.avsc`) and Java classes (see `src/convertor/encoders`)
are generated. Modifications to the data model like new fields in descriptors 
etc most probably require changes to the IDL schemata first and then generating
JSON schemata and Java classes. For more details on how to do this see 
[docs/avro.md](docs/avro.md).

