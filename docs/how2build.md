
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