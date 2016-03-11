# TODO

* ConverTor


  der stand der dinge:
  
  auf github ist der letzte funktionsfähige stand der dinge
  danach gab es ca 3 lokale commits, die alle nicht lauffähig sind
  das aktuelle projekt ist vor allem, die main aufzuräumen 
  und drastisch zu verkleinern
  und überhaupt die architektur aufzuräumen
  und die Main richtig schnieke knapp funktional zu machen
  dabei wuredn auch schon einige fortschritte gemacht,
  aber auch grenzen erreicht
  aber es fehlt auch noch einiges:
  - als nächstes müsste in Conversion die abstarktion des alten codes
    (kommentar ab zeile 58)
    in eine funktion (ab zeile 27) zum laufen gebracht werden
    dazu ist viel könnerschaft im bereich generics von nöten
  - encoder factory ist noch nicht angefangen
  
  zuletzt hat konstantin ein paar anmerkungen gemacht, 
  die auf deutsch in der Main notiert sind 
  der versuch, die Main funktional zu machen, ist wohl vergeblich 
  und sollte abgebrochen werden (jedenfalls auf meinen stand von fähigkeiten)
  
  ich hatte ja erstmal aufgegeben, alles statsiche rauszuschmeissen, 
  nachdem ich es 2 tage erfolglos versucht hatte. aber konstantin hat mir
  gezeigt, wie es geht - siehe kommentare in main und weiter unten
  
  es wäre wahrscheinlich am sinnvollsten, die main wieder imperativer 
  zu gestalten
  - v.a. das, was in Conversion ist, in die iterator-schleife zurück verlegen
  - wenn ich alles, was ich so an singletons brauche, innerhalb der main erzeuge
    und auch innerhalb der main abrufe (weil die conversion dorthin
    zurückverlagert wird) dann muss ich nicht viele variablen 
    durch die gegend tragen
    andernfalls muss ich die variablen in aufraufe externer klassen mitgeben
    nur so komm ich drumrum, sie statisch zu machen
  
  ich muß dringend das singleton pattern wirklich verstehen
  factory wäre wohl auch kein schaden, ist aber vielleicht nicht so wichtig
  und dann das generics buch
    oder den verusch aufgeben, die latte von desckriptor-typ abhängigen
    aufrufen in Conversion in _eine_ funktion umzuwandeln aufgeben
    oder verschieben denn das ist wirklich nicht einfach und ein luxusproblem
  
  also am besten so weiter
  
  - Conversion wieder zurückführen auf den Stnad vor der dem versuch, die 9
    deskriptortypischen aufrufe in einen aufruf zu abstarhieren
  - das dann in den iterator-loop in die main
  
  - das dann wieder zum laufen kriegen
  
  - die main nicht-statisch machen
  - die encoder geschichte auf den weg bringen
    also dass die 9 encoder nur jeweils einmal erzeugt werden, 
    nicht pro conversionsvorgang jeweils neu
  - die sogenannten factories ordentlich machen
  - struktur des codes nochmal durchdenken
      idee war eigentlich, 
        util        (oder: 'concerns'?)
          format
          type
        factories
          encoder
          writer
        converter   (sollte umbenannt werden)
  - wenn das läuft
    entweder zuerst die anderen deskriptoren
    oder die generalisierung der 9 aufrufe
  - und avro.json
      wenn es immernoch keinen bugfix gibt, dann entweder die "pedestrian"
      variante aus convert2json, oder die  variante aus avro pre-1.8
      (die ja in 1.8 als deprecated noch zur verfügung steht)
  - und ein build skript mit ant
  
  
      
  - code style
      
      static 
        entweder  ganz raus, alles als instanzen - besser wegen testen
        oder      nur Conversion nicht static
                  non-static variable nur mit single-chars benamst
      organize static attributes in a properties class (also command line arguments)
                Configuration-object with getters und setters. state pattern?
       
      
      
      clear the view on writer, writer object, writer store
        consolidate into writerFacrtory?
        what is a factory? do i misuse the term?
        
        better: rip writer object apart into 
                encoder factory
                writer factory  
                conversion
        
      generics ...
      
          
          
          
      avro,json,parquet als eigene klassen
      make TypeWriters extend avro/parquet/json writers and implement a common interface
          beispiel: WriterObject als interface, dazu AvroWriterObject, 
          JsonWriterObject, ParquetWriterObject als klassen, die alle 
          implements WriterObject machen.
          controller
          switch
          method
      
  - make JSON conversion work with avro
      either wait for bug fix
      or try deprecated json conversion method
  - build a jar with dependencies
      with ant

  - Parquet is still a little shaky (see docs/parquet.md)
      hadoop file system on local system?

  - aggregation
      https://metrics.torproject.org/bandwidth-data.html
      https://metrics.torproject.org/servers-data.html
      
      

* extend tordnsel with exitnode
    difficult...
    write the other converters
  


* digest is always a hash
       
      
 
* think through the process of mass ingestion  
* and periodic ingestion  

* problems with JSON number conversion? see: 
    https://docs.oracle.com/cd/E26161_02/html/GettingStartedGuide/jsonbinding-overview.html
  
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


