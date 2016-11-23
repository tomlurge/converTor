# TODO


incorporate changes in descriptor 1.5
   - Make the DescriptorCollector implementation that uses CollecTor's
     index.json file to determine which descriptor files to fetch the
     new default.  Applications must provide gson-2.2.4.jar or higher
     as dependency.


incorporate changes in descriptor 1.4
   - Add the Simple Logging Facade for Java (slf4j) for logging
     support rather than printing warnings to stderr.  Applications
     must provide slf4j-api-1.7.7.jar or higher as dependency and can
     optionally provide a compatible logging framework of their choice
     (java.util.logging, logback, log4j).
   - Add an alpha version of a DescriptorCollector implementation that
     is not enabled by default and that uses CollecTor's index.json
     file to determine which descriptor files to fetch.  Applications
     can enable this implementation by providing gson-2.2.4.jar or
     higher as dependency and setting property descriptor.collector to
     org.torproject.descriptor.index.DescriptorIndexCollector.


incorporate changes in descriptor 1.3
   - Parse "package" lines in consensuses and votes.
   - Support more than one "directory-signature" line in a vote, which
     may become relevant when authorities start signing votes using
     more than one algorithm.
        replace RelayNetworkStatusVote's getDirectorySignatures() with
        getDirectorySignature() and update metrics-lib dependency
        Ticket URL: <https://trac.torproject.org/projects/tor/ticket/18875#comment:11>
   - Provide directory signatures in consensuses and votes in a list
     rather than a map to support multiple signatures made using the
     same identity key digest but different algorithms.
   - Be more lenient about digest lengths in directory signatures
     which may be longer or shorter than 20 bytes.
   - Parse "tunnelled-dir-server" lines in server descriptors.
   

incorporate changes in descriptor 1.2
 * Medium changes
   - Make unrecognized keys of Torperf results available together with
     the corresponding values, rather than just the whole line.
   - In Torperf results, recognize all percentiles of expected bytes
     read for 0 <= x <= 100 rather than just x = { 10, 20, ..., 90 }.
   - Actually return the signing key digest in network status votes.
   - Parse crypto parts in network status votes.

use checkstyle

add support for logging levels
  https://docs.oracle.com/javase/7/docs/api/java/util/logging/LogManager.html
  
add option to export flattened files with max one level deep nested arrays
  that would be useful for a few stores like HBase and druid
  
add option to export csv
  
*  tests
  + need handmade descriptors for testing 
    since actual descriptors are only sparsely populated
  
better handling of falsy command line arguments

write documentation
  rationale
  tools used, especially avro
  inner workings
    
parquet
  parquet chokes on non-empty output directories if they are not HDFS
  but it is possible to have HDFS on mac.
  install HDFS on mac (and document how to do that)  
 
logging
  something is wrong with sl4j
    SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
    SLF4J: Defaulting to no-operation (NOP) logger implementation
    SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
  how to exclude .DS_Store warning on mac
 

add option to have dates human readable instead of millis
  maybe just for pretty printed json?
  BUT - not possible without breaking the schema (or schema validation)
  MAYBE - schema validation can be turned of?  

