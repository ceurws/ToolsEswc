SemPub2015 Tools and Extensions
===============================

This project implements FitLayout-based applications and tools for automatic information extraction from the CEUR-WS.org workshop proceedings pages. The tools were created as a proposed solution of the 
[Task 1](https://github.com/ceurws/lod/wiki/Task1) of the [Semantic Publishing Challenge 2015](https://github.com/ceurws/lod/wiki/SemPub2015) colocated with the [Extended Semantic Web Conference 2015](http://2015.eswc-conferences.org/).

How to Build the tool
---------------------
The whole package is built using maven. 
Therefore, after cloning the repository, you need to use this command `mvn package` to create a runnable `SemPub2015Extractor.jar` program.
To be able to do this, you need to have mvn installed.
We also provide an already compiled version in the target folder.
Go to the target folder and run the SemPub2015Extractor.jar file: `/target/SemPub2015Extractor.jar`.
If you do not want to download the whole program, you can find the runnable program in the following link and download the RAW file.
`https://github.com/liyakun/ToolsEswc/blob/master/target/SemPub2015Extractor.jar`.


To run the extraction tool using
```
java -jar SemPub2015Extractor.jar
```
Please note that you need to have java version 1.7 otherwise you will get errors. 

This will start a FitLayout JavaScript console. Use `help()` command for obtaining more info.

Data storage
-----------
The program stores generated data in Blazegraph, detail information see [About_Blazegraph](https://wiki.blazegraph.com/wiki/index.php/About_Blazegraph). The program assumes that the Blazegraph storage is running at `http://localhost:9999/blazegraph`, and you can use`storage.connect()` to connect another repository. You can get the latest version of the blazegraph software from `https://www.blazegraph.com/download/`.


Running the Extraction Task
---------------------------
Option 1. To accomplish the SemPub2015 Task1 the following commands should be used:
```
processEvaluationSet(); 
transformToDomain();
```

Option 2. To process all the workshops located in [CEUR](http://ceur-ws.org/) the following commands should be used: 
```
processAllData(); 
transformToDomain();
```

Option 3. To process a single volume, like http://ceur-ws.org/Vol-1/ the following commands should be used:
```
processPage('http://ceur-ws.org/Vol-1/'); 
transformToDomain();
```

After this, the storage should contain the complete extracted data.


Serialize RDF Data
-------------------------------------------------
You can serialize the generated rdf dataset from the repository by using the python script provided at [/serialization/serializer.py](https://github.com/ceurws/ToolsEswc/blob/master/serialization/serializer.py), the generated file is called all.ttl.gz. You can also download the most recent generated dataset from.

SPARQL Queries
--------------
The SPARQL queries corresponding to the individual SemPub2015 queries are located in [sparql/ESWC2015-queries.txt](https://github.com/liyakun/ToolsEswc/blob/master/sparql/ESWC2015-queries.txt).

The transformation query from the domain-independent logical model to the domain-dependent CEUR workshop ontology is located in [logicalTree2domain.sparql](https://github.com/liyakun/ToolsEswc/blob/master/src/main/resources/sparql/logicalTree2domain.sparql). The transformation itself is included in the `transformToDomain()` call so it's not necessary to execute this query manually.

Related publications by original developers of the tool
-------------------------------------------------------
The related publication is the following:

MILIČKA Martin and BURGET Radek. Information Extraction from Web Sources based on Multi-aspect Content Analysis. In: Semantic Web Evaluation Challenges, SemWebEval 2015 at ESWC 2015. Portorož: Springer International Publishing, 2015, pp. 81-92. ISBN 978-3-319-25517-0. ISSN 1865-0929.

LICENSE of the tool
-------------------
The detail information is contained in [LICENSE](https://github.com/liyakun/ToolsEswc/blob/master/LICENSE).

Acknowledgements
----------------
The original work was supported by the BUT FIT grant FIT-S-14-2299 and the IT4Innovations Centre of Excellence CZ.1.05/1.1.00/02.0070.
Currently this work is related to EU project OpenAIRE2020 (643410).
