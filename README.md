# SoftwareEngineeringCourse2019
This repository is about getting more familiar in developing software.

## Built With 

* [Maven](https://maven.apache.org/download.cgi)

In order to build the project you have to download maven as a zip file and you can find this file in the link above. Only the binaries are required, so look for the link to apache-maven-{newest-version(3.6.0)}-bin.zip or apache-maven-{newest-version(3.6.0)}-bin.tar.gz. Once it's downloaded unzip the file and add the bin folder to your path. Check the installation of maven from cmd using the command: 
```
mvn -v
```

If everything is good with the installation you will be presented something like the following:
```
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-25T02:41:47+08:00)
Maven home: C:\opt\apache-maven-3.6.0\bin\..
Java version: 1.8.0_121, vendor: Oracle Corporation, runtime: C:\opt\Java\jdk1.8.0_121
Default locale: en_MY, platform encoding: Cp1252
OS name: "windows 7", version: "6.1", arch: "amd64", family: "windows"
```

After the installation you should use the command: 
```
mvn package 
```
so you can compile your Java code, run any tests, and finish by packaging the code up in a JAR file within the target directory.

## Running Application

### [Source Code Metrics](Metrics)
You can run the application by giving two command line arguments. More specifically, you will run the jar file with dependencies that is created after building with maven.
You need to type the following command in the git bash:
```
java -jar <dependencies.jar> <filewithcode> <string or regex>
```
[README](seip2019/metrics/README.md) | For more info about this application

## Versions

* ***[Java SE Development Kit 8u201](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)***

* [![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven.svg?label=Maven%20Central)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22org.apache.maven%22%20AND%20a%3A%22apache-maven%22)

### Authors

[George Stamatopoulos](https://github.com/Stam21)
