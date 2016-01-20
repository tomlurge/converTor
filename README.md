# converTor
## part of analytics server project - see https://github.com/tomlurge/mteam
### analytics server for Tor measurement data

measurement team is setting up an analytics environment to play with raw metrics data.  
please check below if it meets your requirements and if you have any suggestions for the setup.

 Setting up an environment to analyze Tor data is no trivial task. Access to the 
 raw data is only feasable programatically through special libraries. Also the 
 data is collected on a node per hour basis whereas most of the time one will be 
 interested in certain kinds of nodes within a certain period of time. Therefor a 
 lot of aggregation has to be performed upfront before you can even start to ask 
 the questions that you came for. Not to mention that the shere amount of data 
 might block your notebook for days and eat up your harddrive on the way. 
    
 The analytics project plans to provide a small set of tools to ease these 
 problems:   
 
 * a converter from raw CollecTor data to JSON and more performant Avro/Parquet
 * a Big Data setup providing popular interfaces like MapReduce, R and SQL
   and an easy migration path to scale huge tasks from notebook to cloud 
 * a collection of pre-aggregated datasets and aggregation scripts.
 
 With these tools it should become much more feasable to work with Tor data and 
 perform analytics as need arises, without too much fuzz and effort upfront. 
 
<img src="docs/32c3/slide.png">

This is still work in progress - please allow a few more months.
 
 
## Motivation + Setup
An idea came up during the Berlin dev meeting: it would be good to have all measurement data on one server, loaded into a database, with a suite of analytics software readily set up, available to everybody who needs to do aggregation, analytics, research etc on the data. 

Right now everybody who wants to analyze Tor metrics data first has to downlod raw data from the metrics website, load it into a local database, massage it, setup a query environment etc. That can be cumbersome and use siginificant computing resources, making your notebook unusable for hours or eating up hundreds of gigabytes of disk space if you don’t optimize properly. That makes on the fly quick and dirty prototyping and analysis quite unfeasable and prohibitively tedious.

We plan to change this by setting up an analytics server free for everybody to use:

* containing as much raw metrics data as possible
* in a HBase database on Hadoop/HDFS 
* with analytic tools like Spark and Drill on top
* supporting diverse languages - SQL, R, Python, Java, Scala, Clojure -
* with gateways to desktop-ish tools like Tableau and MongoDB 

Please see the detailed description below, tell us if you have any suggestions concerning the setup and request a login (to be available soon)!


## Data
The data will be available as raw as possible, like it is served by CollecTor, preloaded into a database and maybe also in some pre-aggregated sets that concentrate on “popular” aspects of the data. The complete dataset is about 50 GB compressed, or 5 TB uncompressed. For a start we may need to concentrate on the last 2 or 3 years.


## Analytics
The amount of data practically rules out the usual RDBMS suspects (PostgreSQL etc). We also want to have easy access to the analytical tools that are available in the big data ecosystem.

Hadoop [0] is a popular candidate for Big Data processing, but has a reputation of being slightly outdated, not so well engineered [1] and is not available in Debian stable (which likely won’t change [2]). It seems like choosing Hadoop means risking to run into nasty little problems down the road. Most solutions outlined below are or can be based on Hadoop File System (HDFS) but that is available independently of the Hadoop MapReduce system.

Disco [3] is another MapReduce engine. Seems solid, heavyly uses Python, but relies on it’s own file system [4] which would make it harder or impossible to use with other tools like Spark, that require HDFS (or compatible). Would need more research/googling to be really sure but right now it doesn't seems worth the effort.

Spark [5] is faster than Hadoop MapReduce when working in memory and can work equally well from disk. Storage is based on Hadoop and "works with any Hadoop compatible data source including HDFS, HBase, Cassandra, etc.” [6]. It can work with Amazons Elastic MapReduce EMR instances (which in turn allows running Spark on EMR). EMR pricing is not prohibitive [7]. Ooni uses this setup [8].
Spark supports R, Scala, Java, Python and Clojure. It provides an interactive shell for Python and Scala and plugins for SQL-like queries, MLib (machine learning lib) and some graph processing. Its performance but also the SQL plugin and the wide range of supported programming languages make Spark quite attractive.

Hive [9] is another analytics engine on top of Hadoop that has similar features to Spark [10] (its feature set was lagging behind Spark for some time but has catched up recently). Since Ooni uses Spark and the two are not very different with respect to feature set we favor Spark (and hope for synergies). 

MongoDB [11], which is available in Debian stable and supports Map Reduce [12], may not be performant enough and is in some ways rather shoddy.

Redis [13] has a good reputation and while optimized for in-memory operations it can work from disk too. It is available as Debian stable [14]. Map reduce operations are available as add ons [15] but not in Debian stable. Like MongoDB there is not much interesting analytics software available besides MapReduce.

Drill [16] is a nice analytic tool: a 'schema-free SQL query engine for Big Data’ which accepts a variety of data sources including HDFS, MongoDB, Amazon S3, with impressive performance and a wide range of possible applications. 

Both Spark and Drill support Tableau, a nice Desktop data visualization tool that allows to work with data in a rather intuitive way.

In summary it seems like Spark and Drill are the aggregation and analytic softwares that we want to have. Together they support a nice array of languages (SQL, R, Java, Python, Scala, Clojure) and desktop-ish tools (MongoDB, Tableau) which should make them readily useable for a lot of people.


## Storage
Amazons EMR is an option but for now we’ll install our own box. We could go with CSV files in the Hadoop Distributed File System HDFS to keep complexity down but given the amount of data some more effort seems justified.  
Two databases are supported by both Spark and Drill: Apache Cassandra [17][18] and Apache HBase [19][20][21]. Both are column-oriented key-value-store. HBase follows the same design principles as Cassandra but comes out of the Hadoop community and is better integrated wiht other offerings. Also while Cassandra is more optimized for easy scaling and write performance HBase has the emphasis on fast read [22]. It also seems like getting Drill to work with Cassandra is not as easy as advertized [23]. So HBase seems like the better fit.  

Another option are specialzed file formats like Parquet [24][25] and Avro [26|. 
Both  support semistructured data - that is data with nested structures, where one document does not easily map to one row while HBase is schemaless. They are better suited to continuous reads where e.g. one map reduce job crawls the entire data set whereas a database. HBase OTOH is indexed and will always be faster in selecting a single document but that is not our typical use case 
[27][28]. Parquet seems better suited than Avro since it is column oriented and 
provides faster access to a certain field in a big data set. "Parquet is efficient for column based query and avro for full scan or when we need all the columns 
data" [29]. Maybe Parquet has also better compression for our type of data. 
But: "I'd go ahead and write Avro schemas for your data. Once that's done, choosing between Avro container files and Parquet files is about as simple as swapping out" two 
container classes [29]. There is an overlap between Parquet and Avro though: "A variety of tools and frameworks including MapReduce, Hive, Impala, and Pig provided the ability to work with Parquet data and a number of data models such as AVRO, Protobuf, and Thrift have been expanded to be used with Parquet as storage format." [30] Parquet 
provides only data storage and needs a data model added through Avro, Thrift 
[31] or others while Avro provides both.

	        |  fixed     schemafree
	        |  schema    + indexed
	--------+---------------------
	complex |  Parquet   MongoDB
	        |  Avro
	        |
	flat    |  CSV       HBase

Hopefully Drill and Spark will work from the same data and not want to import it into their own store (thereby duplicating it) but we’re not sure about that right now. 
Any help and remarks appreciated!

Redis and MongoDB, the 2 systems that are available as Debian stable packages, are not well enough supported by analytic softwares to be useful.


## Conclusion
Measurement team will set up a hosted server with 32 GB RAM and 5 TB storage (partly as SSD), install Apache HBase as database and Apache Spark and Apache Drill as analytics softwares and import a lot of raw measurement data into HBase. We then give login to the machine on request and hope that you have fun with map reducing, data sciencing, visualizing...
This is a test: we plan to keep the server running for at least the next 3 months or so. If it doesn’t prove useful we will probably shut it down afterwards, but we hope otherwise.


# First steps

We are no Big Data experts, this is our first foray into that crowded and confusing area. So please bear with us and (gently but mercylessly) point out mistakes and misconceptions you might very well find in our work.

After sifting through the vast space of tools, formats and techniques of Big and not so big Data we came to a few conclusions. They are not all proven but we had to define a baseline from which to make our own experiences.

## The plan

We settled for the Hadoop ecosystem since it is mostly without alternative in the open source Big Data space. Hadoop in itself is a file system, HDFS, which everybody relies on, and a map reduce engine, which everybody tries to avoid. Hadoops map reduce engine is (or was) of course the core of its offering, the central algorithmical paradigm of Big Data, and the distributed file system only a necessary foundation for it. But Hadoops map reduce engine was difficult to program and soon tools emerged that wrapped it into a nicer interface, eg Hive and Pig. The filesystem though was okay (although not with very big clusters and in high availability environments which led to some frustrations, workarounds etc - but these should not concen us with our littel 2 TB dataset) and is the de facto standard which most Big Data solutions build on.

Of all the tools that emerged on top of we settled for 2: Spark and Drill. Spark offers a lot of language interfaces to work with the underlying map reduce engine: Java, Python, Scala, R, even Clojure, and SQL, and some machine learning library. There should be something in it for everybody and since we offer this server as a service to the Tor community to do your own research we figured that this pletora of languages might be a compelling offer. All the better that Onionoo uses Spark too.
Drill OTOH seems to be the most modern interface to Big Data. On the surface it offers SQl, real ANSI:2003 SQL, not only SQL-ish and SQL-like interfaces as the other map-reduce-wrappers before. And it works on any structured or unstructured data you throw at it without further ado, even fulltext and JSON. Thereby Drill promises to be the most approachable solutions of all. So far we can only hope that it will deliver but we'll certainly try.
Then, since we have Hadoop we also have Hadoop Mapreduce and you're free to try that out, doin' it the old way without all those wrappers and niceties that only try to seperate you from the metal. Yeah.

Storagewise we're still struggling. What we learned so far is that most of our data, as it is offered by collecTor, is indeed preaggregated and hierarchically structured. But contrary to what we first believed all storage solutions that seemed attractive for some reason also support hierarchical data structures, even HBase. The choices now boil down to a database - HBase - or a file system - Avro or Parquet, or both. The filesystems are more performant while HBase seems easier to intergrate. Maybe we'll do both since the also fit different purposes and use cases. That still needs to be worked out.

## The data

The plan here is to convert collecTor data into an intermediate JSON representation that can then be imported in all sorts of data crunchers: HBase, Parquet, Spark, and even PostgreSQL and MongoDB. Finding a JSON schema that represents the collecTor data thoroughly is easy. Importing that JSON into PostgreSQL, MongoDB and Drill should be easy too. We still have to work on HBase, Parquet/Avro and Spark.   
We might store JSON in compressed .gz files that we can keep around for download. Drill can work on those files (https://drill.apache.org/docs/querying-plain-text-files/#querying-compressed-files) and generate Parquet files from them which then in turn might serve as the base from which Spark can work. 

## Caveats

One feedback that we got was a plea for PostgreSQL instead of a complicated Big Data setup that might just be not woth it for our kind of data volume. That may be right: we are dealing with roughly 2 TB, not with Petabytes and since PostgreSQL now offers metrialized views we could even do some aggregation with it. And everybody knows SQL. But OTOH we would be near to the limits of PostgreSQL already, we would not be able to easily scale out into the cloud on demand like we can with a Hadoop Map reduce job that's too big for our server and we don't get the seamless integration of statistically inclined toolsets and languages like R as we get it in the Hadoop eco system. Plus we learn something new :-)

Another rather obvious approach would have been to go with MongoDB and its map reduce framework. We tried that but it doesn't scale like we want it to and it sometimes felt rather poorly engineered. We didn't want o go that road any further.

We had reservations about Hadoop first since it has some weak points by design too but these mainly concern much bigger usecases than ours. There's still the problem of so many different moving parts in a Hadoop installation that not always work together as expected. That _is_ a problem and so far we can only hope that it won't hit us too badly.

As mentioned above we will transform collecTor data to JSON before ingesting it into the Hadoop environment. That JSON data can easily be imported into PostgreSQL or MongoDB as well, so that route is not blocked - rather to the contrary.


---   
[0] http://hadoop.apache.org/   
[1] https://news.ycombinator.com/item?id=4298284 - see the 4. comment thread for a nice rundown on the cons of Hadoop.   
[2] https://wiki.debian.org/Hadoop   
[3] http://discoproject.org/  
[4] http://disco.readthedocs.org/en/develop/howto/ddfs.html?highlight=hdfs  
[5] http://spark.apache.org/  
[6] http://www.infoq.com/articles/apache-spark-introduction  
[7] https://aws.amazon.com/elasticmapreduce/pricing/  
[8] https://github.com/TheTorProject/ooni-pipeline  
[9] http://hive.apache.org/   
[10] http://www.zdnet.com/article/sql-and-hadoop-its-complicated/  
[11] https://www.mongodb.org/  
[12] https://docs.mongodb.org/manual/core/map-reduce/  
[13] https://redis.io  
[14] https://packages.debian.org/search?suite=jessie&arch=any&searchon=names&keywords=redis  
[15] http://heynemann.github.io/r3/   
[16] https://drill.apache.org/, https://drill.apache.org/faq/  
[17] http://cassandra.apache.org/  
[18] http://www.planetcassandra
.org/getting-started-with-apache-spark-and-cassandra  
[19] http://hbase.apache.org/  
[20] http://www.vidyasource.com/blog/Programming/Scala/Java/Data/Hadoop/Analytics/2014/01/25/lighting-a-spark-with-hbase  
[21] http://www.slideshare.net/cloudera/5-h-base-schemahbasecon2012  
[22] http://www.infoworld.com/article/2848722   
[23] http://stackoverflow.com/questions/31017755  
[24] https://parquet.apache.org/documentation/latest/  
[25] http://arnon.me/2015/08/spark-parquet-s3/   
[26] https://avro.apache.org/docs/1.7.7/index.html   
[27] http://statrgy.com/2015/05/07/hbase-parquet-or-avro/   
[28] http://www.infoworld.com/article/2915565   
[29] http://stackoverflow.com/questions/28957291   
[30] https://www.mapr.com/blog/evolving-parquet-self-describing-data-format-new-paradigms-consumerization-hadoop-data    
[31] https://thrift.apache.org/