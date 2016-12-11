# NOTES

## conversion of 09-2016 to parquet.snappy takes about 40 minutes 
    
    on a MacBook Pro 2015 2,8 GHz Core i7, 16GB RAM, 1TB SSD


## identity - how to establish identity on converted descriptors
    
    relay           type + published + fingerprint   (could as well be digest)
    bridgeExtra     type + published + fingerprint   (could as well be digest)
    relayExtra      type + published + fingerprint   (could as well be digest) 
    bridge          type + published + fingerprint   (could as well be digest)
    relayConsensus  type + valid-after 
    bridgeStatus    type + valid-after  ???
    relayVote       type + valid-after + identity
    tordnsel        type + downloaded 
    torperf         type + start + source + filesize
    
## date - how date is computed
  
      BridgeNetworkStatus               getPublishedMillis();
      BridgeServerDescriptor            getPublishedMillis();
      BridgeExtraInfoDescriptor         getPublishedMillis();
      BridgePoolAssignment              getPublishedMillis();
      RelayNetworkStatusConsensus       getValidAfterMillis();
      ExitList                          getDownloadedMillis();
      RelayExtraInfoDescriptor          getPublishedMillis();
      RelayServerDescriptor             getPublishedMillis();
      RelayNetworkStatus                getPublishedMillis();
      BridgePoolAssignment              getPublishedMillis();
      TorperfResult                     getStartMillis();
      RelayNetworkStatusVote            getValidAfterMillis();       
      
## digest is always a hash

## problems with JSON number conversion? see: 
    https://docs.oracle.com/cd/E26161_02/html/GettingStartedGuide/jsonbinding-overview.html

## compression
    
      avro        (1) deflate snappy (6)                    bzip2       xz
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
   
   
## when a new attribute comes in
 
 say metrics-lib version 12.7 fancies to support a hitherto neglected attribute
 - check data.md for which spec documents that descriptor
 - look up that spec to see where and how that attribute fits in
 - edit the corresponding avro IDL
 - generate avro avsc (json serialization) and java classes (encoders)
   (see avro.md for a detailed howto)
 - add those avsc schemata and java encoder classes to the source
 - add the attribute to the converter class (ConvertXxxx)
 - build and test
   
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


## ENUM
  
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
   
    
## HOW 2 BUILD
        
    to build convertor run the following command in the project root dir:
    
      ant clean jar bundle
    
    
    annoying java.lang.SecurityException: 
     Invalid signature file digest for Manifest main attributes
     https://stackoverflow.com/questions/1274879/ant-exclude-files-from-merged-jar-file
       answer #2 (alberto) looks helpful
     but in the end i deleted the signature files by hand
       unzip descriptor.jar
         in META-INF directory delete files 'KARSTEN.RSA' and 'KARSTEN.SF'
       re-zip with the following command
         jar cvfm descriptor-1.5.0.jar MANIFEST.MF -C desc/ .
         (after copying the original MANIFEST.MF to your working directory)  
       
    
    building metrics-lib
       add a directory <root-dir>/lib alongside <root>/src
       download and add all dependencies mentioned in build.xml to /lib
       in the shell go to <root-dir> and invoke 'ant jar'
       enjoy the <root-dir>/descriptor-1.1.0-dev.jar (or similar version)
    
    
    building from IntelliJ
     IntelliJ doesn't know how to handle long classpaths,
     messes them up when building the MANIFEST.MF
     therefor, after building artifacts
     - decompress the jar
     - edit the MANIFEST.MF to correct IntelliJs garbage
     - run "jar cmf META-INF/MANIFEST.MF convertToJson.jar lib mteam"
     see https://docs.oracle.com/javase/tutorial/deployment/jar/build.html 
     and https://youtrack.jetbrains.com/issue/IDEA-148005
     
     
    mail von K von nov/dez 2015
     > 1) wie mache ich mit der ConvertToJson einen probelauf?
     > kompilieren? dann irgendein mystisches shell-kommando?
     
     mkdir mteamdev
     cd mteamdev
     mkdir mteam
     # copy ConvertToJson.java to mteam/
     mkdir in
     # copy uncompressed bridge descriptor tarball to in/
     wget https://people.torproject.org/~karsten/volatile/descriptor.jar
     javac -cp descriptor.jar mteam/*.java
     java -cp descriptor.jar:mteam/ ConverToJson
     
     Das wird nicht ganz klappen. Du wirst noch gson-2.1.jar und
     commons-compress-1.4.1.jar im Classpath (-cp, getrennt mit :)
     brauchen. Die findest du im Netz.