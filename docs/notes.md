# TODO

better handling of falsy command line arguments

logging
  what's wrong with sl4j and do we need it?
  how to exclude .DS_Store warning on mac

build nochmal

write documentation
  rationale
  tools used
  inner workings

ask iwekah for review

repair hdfs on server

start conversion to .parquet.snappy
  
  
  
parquet
  parquet chokes on non-empty output directories if they are not HDFS
  but it is possible to have HDFS on mac.
  install HDFS on mac (and document how to do that)

aggregation
      https://metrics.torproject.org/bandwidth-data.html
      https://metrics.torproject.org/servers-data.html
      visionion
      karstens use case
spark
hbase
drill




# PROBLEMS      

       
      

# PROJECTS
       

* ingestion  
    mass ingestion
    periodic ingestion  

* write tests
  + that would involve writing test descriptors too i guess
  + which would mean learning how to write collector data
  + well well well
  
* usecase
  [c] https://blog.torproject.org/blog/did-fbi-pay-university-attack-tor-users     
  [c] f. hat mich um 2 uhr morgens geweckt, kurz nachdem er den angriff entdeckt hat.
  [c] war gerade dev meeting in paris.
  [c] und er hat einen der relays beim angriff entdeckt.
  [c] jetzt ging es darum möglichst alles über diesen relay und ähnliche relays im netzwerk herauszufinden.
  [c] seit wann sind die da,
  [c] wie viele sind es,
  [c] welche ip-präfixe,
  [c] wie viele andere gibt es in diesen ip-präfixen.
  [c] wie schnell sind die, sind es exits,
  [c] contacts?
  [c] platforms?
  [c] versions?
  [c] alles.
  [c] angenommen f. hätte so eine datenbank gehabt,
  [c] was hätte er machen können?
  

# NOTES

* digest is always a hash

* problems with JSON number conversion? see: 
    https://docs.oracle.com/cd/E26161_02/html/GettingStartedGuide/jsonbinding-overview.html

* verbosity
  removed option for verbose output ("flattened" instead of "jagged" arrays, 
  suitable for Drill).
  realizing this option would require to modify the schemata and break the way 
  how they currently nicely document the spec. this and the added complexity 
  seems not to be worth the effort. "Drill-able" arrays will have to be created 
  later on when need arises.
    
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
      
* compression
    
      avro        (1) deflate snappy      (6)               bzip2       xz
      parquet-mr  (2)         snappy      gzip  lzo
      json        (3)         snappy (4)  gzip        zip   bzip2 (5)

   
  (1) https://avro.apache.org/docs/current/api/java/org/apache/avro/file/CodecFactory.html
  (2) https://github.com/Parquet/parquet-mr/blob/master/parquet-hadoop/src/main/java/parquet/hadoop/metadata/CompressionCodecName.java
  (3) https://docs.oracle.com/javase/7/docs/api/java/util/zip/DeflaterOutputStream.html
  (4) https://github.com/dain/snappy/blob/master/src/main/java/org/iq80/snappy/SnappyOutputStream.java
  (5) https://www.google.de/#q=bzip2OutputStream
  
  more 
      https://www.cloudera.com/documentation/archive/impala/1-x/1-0-1/Installing-and-Using-Impala/ciiu_file_formats.html
      (6) some remarks on the interwebs suggest that "deflate" is the same as 
          gzip but i'm not sure
  snappy is a well established hadoop format and available out of the box for 
  avro and parquet, so a no-brainer
  "z compression" is not that easy though. gz and xz are popular in the unix 
  world, but both not supported by all 3 formats. 
  bzip2 has the advantage (also over snappy) of being splittable and therefore 
  well suited for parallelized settings but only avro supports it out of the 
  box.
  but gzip is much faster than bzip2.
    https://blogs.oracle.com/datawarehousing/entry/hadoop_compression_choosing_compression_codec
  gzip is very effective (bzip2 even more so), snappy is very fast.
    see http://www.slideshare.net/Hadoop_Summit/kamat-singh-june27425pmroom210cv2 slide 8
  i guess that in the end all codecs are available for all formats if one only 
  knows where to look and how to do it
  i would like to support
      snappy    fast (still good compression), ubiquitous in hadoop land
      gz        good compression (still fast), ubiquitous in unix land
      bzip2     splittable, very good compression (but can be slow)
       
  so far i settled for snappy (all formats), gzip (parquet and json) and bzip2 
  (avro). that should give something for everybody.
   
   
  
   
# CONSTRUCTION MATERIALS


## USEFUL CHECKS TO DEFEND AGAINST NULL POINTER EXCEPTIONS

      can return -1
        if (desc.XXX() >= 0) {

      can't be null or false, only true'
        if (desc.XXX()) {

      if a method is called on the desc property always check for null
        if (desc.XXX() != null) {

      for keys: test, if there is one and return 'true' if yes, 'false' otherwise
          server.onion_key = desc.getOnionKey() != null;

      List: first check that the list is not null, then if it's empty
          if (desc.XXX() != null && !desc.XXX().isEmpty()) {


## SOME JAGGED MAPS AND FLATTENED ARRAYS

      // <!-- role model SortedMap<String, Integer>
      if (desc.method() != null && !desc.method().isEmpty()) {
        if (jagged) {
          relayExtra.attribute = desc.method();
        } else {
          relayExtra.attribute = new ArrayList<StringInt>();
          ArrayList<StringInt> flatList = new ArrayList<>();
          for (Map.Entry<String, Integer> entry : desc.method().entrySet()) {
            flatList.add(new StringInt(entry.getKey(), entry.getValue()));
          }
          relayExtra.attribute = flatList;
        }
      }
      // role model -->

      // <!-- role model SortedMap<String, Long>
      if (desc.method() != null && !desc.method().isEmpty()) {
        if (jagged) {
          relayExtra.attribute = desc.method();
        } else {
          relayExtra.attribute = new ArrayList<StringLong>();
          ArrayList<StringLong> flatList = new ArrayList<>();
          for (Map.Entry<String, Long> entry : desc.method().entrySet()) {
            flatList.add(new StringLong(entry.getKey(), entry.getValue()));
          }
          relayExtra.attribute = flatList;
        }
      }
      // role model -->

      // <!-- role model SortedMap<String, Double>
      if (desc.method() != null && !desc.method().isEmpty()) {
        if (jagged) {
          relayExtra.attribute = desc.method();
        } else {
          relayExtra.attribute = new ArrayList<StringDouble>();
          ArrayList<StringDouble> flatList = new ArrayList<>();
          for (Map.Entry<String, Double> entry : desc.method().entrySet()) {
            flatList.add(new StringDouble(entry.getKey(), entry.getValue()));
          }
          relayExtra.attribute = flatList;
        }
      }
      // role model -->

## MISC


  
  ENUM
  
  nice example of a switch with enums in proEE design patterns p.67
  
    public enum CoffeeType {
      ESPRESSO, LATTE
    }
    
    public Drink dispenseDrink(CoffeeType type) { 
      Drink coffee = null;
      switch (type) {
        case ESPRESSO: coffee = new Espresso();
        case LATTE: coffee = new Latte(); }
    return coffee; }