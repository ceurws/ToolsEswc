SemPub2015 Tools and Extensions
===============================

This project implements FitLayout-based applications and tools for automatic information extraction from the CEUR-WS.org workshop proceedings pages. The tools were created as a proposed solution of the 
[Task 1](https://github.com/ceurws/lod/wiki/Task1) of the [Semantic Publishing Challenge 2015](https://github.com/ceurws/lod/wiki/SemPub2015) colocated with the [Extended Semantic Web Conference 2015](http://2015.eswc-conferences.org/).

How to Build
------------

The whole package is build using maven. Use `mvn package` for creating the runnable `SemPub2015Extractor.jar`.

The compiled program is also contained in the repository folder [/target/SemPub2015Extractor.jar](https://github.com/liyakun/ToolsEswc/blob/master/target/SemPub2015Extractor.jar) for convenience.


Running the Extraction Task
---------------------------

Run the extraction tool using
```
java -jar SemPub2015Extractor.jar
```

This will start a FitLayout JavaScript console. Use `help()` command for obtaining more info.

Option 1. For accomplishing the SemPub2015 Task1 the following commands should be used:
```
processEvaluationSet(); 
transformToDomain();
```

Option 2. For process all the workshops located in [CEUR](http://ceur-ws.org/) the following commands should be used: 
```
processAllData(); 
transformToDomain();
```

Option 3. For process a single volume, like http://ceur-ws.org/Vol-1/ the following commands should be used:
```
processPage('http://ceur-ws.org/Vol-1/'); 
transformToDomain();
```

The program stores generated data in Blazegraph, detail information see [About_Blazegraph](https://wiki.blazegraph.com/wiki/index.php/About_Blazegraph). This assumes the Blazegraph storage to be running at `http://localhost:9999/blazegraph`. Use `storage.connect()` to connect another repository.

After this, the storage should contain the complete extracted data.


Remove non-relevant data and serialize it from Blazegraph
---------------------------
The transformed data contains a lot non relevant information, like html element information. The target of this section is to guide user to get clean dataset.

1. You need remove most of the non-relevant dataset by using the sparql query in file [/sparql/filter_domain.sparql](https://github.com/liyakun/ToolsEswc/blob/master/src/main/resources/sparql/filter_domain.sparql)in the update window of Blazegraph.

2. Then you need serialize all the dataset out of the repository by using the following command:
```curl -X POST http://localhost:9999/bigdata/sparql --data-urlencode 'query=CONSTRUCT WHERE { hint:Query hint:analytic "true" . hint:Query hint:constructDistinctSPO "false" . ?s ?p ?o }' -H 'Accept:application/rdf+xml' | gzip > output.rdf```
You can also serialize the dataset with other formats, detail see [REST_APT](https://wiki.blazegraph.com/wiki/index.php/REST_API).

3. You need to use the provided python script to remove the remaining non-relevant information.

SPARQL Queries
--------------
The SPARQL queries corresponding to the individual SemPub2015 queries are located in [sparql/ESWC2015-queries.txt](https://github.com/FitLayout/ToolsEswc/blob/master/sparql/ESWC2015-queries.txt).

The transformation query from the domain-independent logical model to the domain-dependent CEUR workshop ontology is located in [logicalTree2domain.sparql](https://github.com/FitLayout/ToolsEswc/blob/master/src/main/resources/sparql/logicalTree2domain.sparql). The transformation itself is included in the `transformToDomain()` call so it's not necessary to execute this query manually.

Publication
-----------
The related publication is the following:

MILIČKA Martin and BURGET Radek. Information Extraction from Web Sources based on Multi-aspect Content Analysis. In: Semantic Web Evaluation Challenges, SemWebEval 2015 at ESWC 2015. Portorož: Springer International Publishing, 2015, pp. 81-92. ISBN 978-3-319-25517-0. ISSN 1865-0929.

Acknowledgements
----------------
This work was supported by the BUT FIT grant FIT-S-14-2299 and the IT4Innovations Centre of Excellence CZ.1.05/1.1.00/02.0070.
