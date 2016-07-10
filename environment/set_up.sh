#!/usr/bin/env bash

# install dependencies
apt-get update
apt-get remove -y openjdk*
apt-get install -y openjdk-7-jdk maven php5 curl git wget python-pip python-levenshtein
pip install rdflib fuzzywuzzy requests

# get the software needed
wget https://sourceforge.net/projects/bigdata/files/bigdata/2.1.1/blazegraph.jar
git clone https://github.com/ceurws/ToolsEswc.git


