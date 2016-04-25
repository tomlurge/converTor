# TODO

parse pline
  relay         exit policy
  relayCons     Policy
  relayVote     Policy
  bridge        exit policy
  bridgeStatus  Policy
  
parquet
  file.list
  file.delete
  
bugs 
  in avro+parquet NPE for obfuscation
    maybe add union (nul ...) to idl?
    maybe add null option to all IDLs and remove all checks in converters?
documentation
ant build-script
parquet - shaky on local (non-HDFS) file system 
multithreading - is there an issue?
tests in converter code - do they make sense
massive testing
json - pretty printing without Avro
aggregation
      https://metrics.torproject.org/bandwidth-data.html
      https://metrics.torproject.org/servers-data.html
      visionion
      karstens use case
spark
hbase
drill




# PROBLEMS      

      
  - bridgeStatus
      PROCRASTINATED 
        
      - con.setFastSpeed  desc.getFastBandwidth()); // fastSpeed? stupid name!
      
      - datumsfeld in allen konvertierten descriptoren
          muß in die IDL ? wie benamsen? 
          in welche descriptoren genau?
          oder erst in HBase/RDDs? <- GENAU
      
      NO - IT'S IN THE SPEC
        -   union { null, array<Status> } status; 
            müsste eigentlich
              union { null, array<Status> } statuses; 
           heissen. sowas gabs bei relay oder tordnsel auch
         
        -   setPublished in bridgeStatus.R
            setPublication in relayVote.R
        
        -   fastSpeed zu fastBandwidth
        
     DONE  
      umbenamsung bridgeStatus.FlagTresholds.setIgnoringAdvertisedBws
       
      bridgeStatus.avdl z92 array > map
      ConvertBridgeStatus.java z47 ff
      
      relayVote.avdl z81 array > map
      ConvertRelayVote z93 ff

      metrics-lib updates
        - Include the hostname in directory source entries of consensuses
          and votes. (11.04.16)
      
      

# PROJECTS
       

* think through the process of ingestion  
    mass ingestion
    periodic ingestion  

* check sizes
  + a bunch of Collector descriptors (say: 1 month)
  + converted to verbose and gzipped JSON
  + converted to non-verbose and gzipped JSON
  + converted to - the same - in Parquet
  + check: 
    - all descriptor samples uncompressed in directories -> 57 MB
    - the same as JSON, non-verbose                      -> 67 MB
                                                 compressed 15 MB
    - the same as JSON, but verbose, uncompressed        -> 72 MB
                                                 compressed 15,1 MB
* check sizes again
  + a bunch of archives, XZ, one of each type            ->  1 GB
  + the same as JSON, GZ, with nulls and chatty arrays   ->  5.7 GB
  + the same as JSON, GZ, with chatty arrays             ->  5.63 GB
  +  convert one tarball per type 
      to see if there is one suspiciously big JSON result
  
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