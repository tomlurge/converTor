todo  this needs more love


    build convertor
      on the shell navigate to project directory (same level as build.xml)
      standard: 
        run 'ant jar'
      bundled with dependencies and schemata:
        run 'ant jar bundle'
      look into ./jar-dist for result
      



    building metrics-lib
        add a directory <root-dir>/lib alongside <root>/src
        download and add all dependencies mentioned in build.xml to /lib
        in the shell go to <root-dir> and invoke 'ant jar'
        enjoy the <root-dir>/descriptor-1.1.0-dev.jar (or similar version)


    building convert2json from IntelliJ
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