# TODO


## now

    rename project from 'ConverTor' to 'trans'
      see `docs/rename.md`

## next

    add support for time frames
      currently ConverTor exports data in monthly junks/files. 
      this is insuficient as e.g. Spark only works on single files, not on
      directories.
      we need support for arbitrary time frames (everything in the -in dir is 
      converted into one -out file) and maybe also hourly, daily, yearly files.

    add support for flattened serializations, 
      without multi-level nested arrays or maps.
      this is necessary because tools like Spark and Drill have trouble
      accessing deeply nested complex structures. an array or a map are okay,
      but e.g. a map _within_ an array is not.
      probably needs new schemata, new ConvertXxxx, and one more control level
      in the Base logic (because now it's not only Types, but needs to be 
      Types+Nesting)
      while on it a flattened version could also do away with all nested structs
      which are included to mimic the structure of the spec but are not strictly
      necessary and may or may not be helpful when working with the data.

      
## later

    slimming down output
      it's quite easy to comment out unneded parts of the data in convertor 
      classes to slim down the outputted files. especially JSON output could
      profit from this. should be documented.
    
    converting a single descriptor archive
      converTor only accepts directories as input parameter
      
    check -i option on startup
      when started without -i parameter ConverTor tries to convert everything
      in the current working directory which can be annoying. but what to do?
    
    documentation
      can always be better...
      especially the pages data.md and avro.md could use a bit more love
      
    tests
        add proper testing
        this needs handmade descriptors as test dummys
        since actual descriptors are only sparsely populated
      
    add option to export csv
      
    incorporate changes from descriptor 1.5
       - Make the DescriptorCollector implementation that uses CollecTor's
         index.json file to determine which descriptor files to fetch the
         new default.  Applications must provide gson-2.2.4.jar or higher
         as dependency.
         [??? does this concern us ??? see org.torproject.descriptor.index]
    
    incorporate changes from descriptor 1.2
       - In Torperf results, recognize all percentiles of expected bytes
         read for 0 <= x <= 100 rather than just x = { 10, 20, ..., 90 }.
         [does this concern us? not seeing any changes in descriptors (09/2016)]
       - Parse crypto parts in network status votes. [does this concern us ?]
    
    use checkstyle
    
    add support for logging levels
      https://docs.oracle.com/javase/7/docs/api/java/util/logging/LogManager.html
      
    logging
      something is wrong with sl4j
        SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
        SLF4J: Defaulting to no-operation (NOP) logger implementation
        SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further
        details.
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
    
