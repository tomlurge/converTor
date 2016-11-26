# TODO

## now



## later
    
    documentation
      can always be better...
      especially the pages data.md and avro.md could use a bit more love
      
    tests
        add proper testing
        this needs handmade descriptors as test dummys
        since actual descriptors are only sparsely populated
      
    add option to export flattened files with max one level deep nested arrays
      that would be useful for some column stores like HBase and Druid
      and maybe in general be easier to work with despite deviating from the spec
      
    add option to export csv
      
    incorporate changes in descriptor 1.5
       - Make the DescriptorCollector implementation that uses CollecTor's
         index.json file to determine which descriptor files to fetch the
         new default.  Applications must provide gson-2.2.4.jar or higher
         as dependency.
         [??? does this concern us ??? see org.torproject.descriptor.index]
    
    incorporate changes in descriptor 1.2
       - In Torperf results, recognize all percentiles of expected bytes
         read for 0 <= x <= 100 rather than just x = { 10, 20, ..., 90 }.
         [??? does this concern us? not seeing any changes in descriptors (09/2016)]
       - Parse crypto parts in network status votes. [??? does this concern us ???]
    
    use checkstyle
    
    add support for logging levels
      https://docs.oracle.com/javase/7/docs/api/java/util/logging/LogManager.html
      
    logging
      something is wrong with sl4j
        SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
        SLF4J: Defaulting to no-operation (NOP) logger implementation
        SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
      how to exclude .DS_Store warning on mac
      
    better handling of falsy command line arguments
        
    parquet
      parquet chokes on non-empty output directories if they are not HDFS
      but it is possible to have HDFS on mac.
      install HDFS on mac (and document how to do that)  
     
    add option to have dates human readable instead of millis
      maybe just for pretty printed json?
      BUT - not possible without breaking the schema (or schema validation)
      MAYBE - schema validation can be turned of?  
    
    add support for flattened data structure
      flatten nested records that are not arrays or maps into the main structure
      BUT 1 this is a massive task
            that needs modified schemata, encoders and classes 
      BUT 2 there's no clear way on how to do it
            arrays nested within arrays 
            as well as maps that would need to be converted to arrays
            need to be modeled in different ways
            the best model would probably depend on the task/situation
            so no best general solution
            so maybe better to tackle this problem during aggregation
            but not before
      could be combined with CSV output
