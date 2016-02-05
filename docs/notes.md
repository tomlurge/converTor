# TODO

*
  think about convertion per timespan
    arrays of writers?
  implement avro writer functionality
  generate an avro file from torperf
  set up checking/testing of avro file
    convert avro to json, check that visually
    think about testing
  extend tordnsel with exitnode
    difficult...
  write the other converters
  refactor to individual class files per descriptor type
 

* TODO ask KL
  anomalies while writing Avro IDL schemas
  - vote
      there's a method getSigningKeyDigest() which I'm not sure about to ehich property it belongs.
      another methd of the same name in DirectorySignature makes sense though.
      maybe a double?
  -network status entry
      does bridgeStatus status entry "p" map to policy or just getPortList?
  - extra info transport is spec'ed as  transportname address:port [arglist] NL [Any number.]    
      but in metrics-lib implemented as List<String> getTransports()
      and that too seems to be what's in the descriptors
  - check all things identity/digest/certificate
      the documentation was often not helpful in finding the right mapping
      between methods and attributes.
      befor the converter goes into production this has to be checked specifically
      by someone who knows and understands the details
  - NetworkStatusEntry
      mapping is unclear:  
        identity  <->   getFingerprint,   
        digest    <->   getDescriptor 
        ?
 
    
* output wird komplett in eine datei geschrieben
  + verzeichnisstruktur wird igoriert und geht verloren
  
  >> Dann Bau doch deine Methoden wie
  >> JsonRelayServerDescriptor.convert() um in
  >> convertAndAppendToFile(), wobei jede Json*-Klasse selbst weiß
  >> wohin sie schreiben soll.
  
  >  Mach doch pro Dokumenttyp eine Map<String, Writer>, wobei String der
  >  Monat im Format YYYY-MM ist und Writer der ensprechend offene Writer
  >  für die Datei.

* think through the process of mass ingestion  
* and periodic ingestion  

* convert to Parquet 
  
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
  
* modularize
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
  
  
# BUGS



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


