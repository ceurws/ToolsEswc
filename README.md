SemPub2015 Tools and Extensions
===============================

This project included the FitLayout extensions that implement the
[Task 1](https://github.com/ceurws/lod/wiki/Task1) of the [Semantic Publishing Challenge 2015](https://github.com/ceurws/lod/wiki/SemPub2015) colocated with the [Extended Semantic Web Conference 2015](http://2015.eswc-conferences.org/).

How to Build
------------

The whole package is build using maven. Use `mvn package` for creating the runnable `SemPub2015Extractor.jar`.


Running the Extraction Task
---------------------------

Run the extraction tool using
```
java -jar SemPub2015Extractor.jar
```

This will start a FitLayout JavaScript console. Use `help()` command for obtaining more info.

For accomplishing the SemPub2015 Task1 the following commands should be used:
```
processEvaluationSet();
transformToDomain();
```
This assumes the Blazegraph storage to be running at `http://localhost:8080/bigdata`. Use `storage.connect()` to connect another repository.

After this, the storage should contain the complete extracted data.



SPARQL Queries
--------------
The SPARQL queries corresponding to the individual SemPub2015 queries are located in [sparql/ESWC2015-queries.txt](https://github.com/FitLayout/ToolsEswc/blob/master/sparql/ESWC2015-queries.txt).

The transformation query from the domain-independent logical model to the domain-dependent CEUR workshop ontology is located in [logicalTree2domain.sparql](https://github.com/FitLayout/ToolsEswc/blob/master/src/main/resources/sparql/logicalTree2domain.sparql). The transformation itself is included in the `transformToDomain()` call so it's not necessary to execute this query manually.
