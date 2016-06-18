#!/usr/bin/env python
import codecs
import requests
import subprocess
import rdflib
from rdflib.namespace import FOAF, RDF, DC
from fuzzywuzzy import fuzz
import urllib
import os
import re

'''
This script will serialize rdf data from Blazegraph repository generated by ToolsEswc located at https://github.com/liyakun/ToolsEswc and remove non-relevant data. The output is generated into file
all_clean.ttl.gz in the same folder with this script.

This script uses python 2.7.6, and it has been tested on Linux Mint 17.3.
It should also run on Ubuntu with corresponding version of Linux Mint 17.3.

It should also able to run Windows as long as you have the corresponding python and shell tools installed.
'''

url = 'http://localhost:9999/blazegraph/sparql'
print 'The default url for Blazegraph running is: %s\n' % url
user_input = raw_input('If using the default url, please press Enter, else please input: ')

# if user input a specified url, use user input
if user_input != '':
    url = user_input

# check whether Blazegraph is running on http://localhost:9999/bigdata/sparql
request = requests.get(url)
if request.status_code == 200:
    print '\n' + url + ' exists\n'
else:
    raise ValueError('\n' + url + ' does not exist\n')

# remove most non relevant data by SPARQL query
arg = "curl --get -X DELETE -H 'Accept: application/xml' " + url + \
      " --data-urlencode 'query=PREFIX box: <http://fitlayout.github.io/ontology/render.owl#> PREFIX segm: " \
      "<http://fitlayout.github.io/ontology/segmentation.owl#> CONSTRUCT { ?a ?b ?c } " \
      "WHERE {{ ?a rdf:type segm:AreaTree } union { ?a rdf:type segm:LogicalArea } union " \
      "{ ?a rdf:type segm:Area } union { ?a rdf:type box:Box } union { ?a rdf:type box:Page } " \
      "union { ?a segm:ititle ?c  } union { ?a segm:ishort ?c  } union { ?a segm:idateplace ?c  } " \
      "union { ?a segm:iproceedings ?c  } union { ?a segm:istartdate ?c  } union { ?a segm:ienddate ?c  } " \
      "union { ?a segm:isubmitted ?c  } union { ?a segm:icoloc ?c  } union { ?a segm:editorname ?c  } " \
      "union { ?a segm:hasTag ?c  } union { ?a segm:support ?c  } ?a ?b ?c.}'"
subprocess.check_output(arg, shell=True)

# add license information, assuming license.ttl in current directory
arg = "curl -X POST -H 'Content-Type:application/x-turtle' --data-binary '@license.ttl' " + url

# serialize data from repository, you can also serialize with other formats, detail see 
# https://wiki.blazegraph.com/wiki/index.php/REST_API
arg = "curl -X POST " + url + " --data-urlencode 'query=CONSTRUCT  WHERE {hint:Query hint:analytic " + '"true"' +\
      " . hint:Query hint:constructDistinctSPO " + '"false"' + " . ?s ?p ?o }' -H 'Accept:application/x-turtle' " \
                                                               " > output.ttl"
subprocess.check_output(arg, shell=True)

# regenerate data set with abbreviations
g = rdflib.Graph()
rdf_result = g.parse('output.ttl', format='n3')
ns = rdflib.Namespace("http://fitlayout.github.io/ontology/segmentation.owl#")
rdf_result.remove((None, ns['country'], None))
rdf_result.remove((None, ns['related'], None))

# check if the user name in current volume is similar to any existing one
def is_similarity(name, vol_names):
    for names in vol_names:
        if fuzz.WRatio(name, names[0]) > 90:
            # print 'Same as: ' + str(names) + ', ' + name
            return names
    return False

# if same person with different spelling in same volume, then 
def same_person(name, person_uri, persons):
    vol = person_uri.split('#')[0]
    if vol not in persons:  # if the current volume is not processed yet, add it to dictionary
        persons[vol] = []
    result = is_similarity(name, persons[vol])
    if result is False:  # if the name is not similarity to any existing one in current volume
        persons[vol].append((name, person_uri))
        return False
    else:
        return result

# solve mixing affiliation, and merging user names
g.bind("foaf", FOAF)
persons = {}
for i, row in enumerate(g.query('SELECT ?name ?person WHERE {?person a foaf:Person ; foaf:name ?name}')):
    name, person_uri = row
    #  1). most cases, the affiliation start with '(' after person name
    if '(' in name:
        short_name = rdflib.term.Literal(name.split('(')[0].strip())
        short_person = rdflib.URIRef(urllib.unquote(person_uri.encode('utf8')).decode('utf8').split('(')[0])
        for s, p, o in g.triples((person_uri, None, None)):
            if p == FOAF.name:
                g.add((short_person, FOAF.name, short_name))
            else:
                g.add((short_person, p, o))
            g.remove((s, p, o))
        for s, p, o in g.triples((None, None, person_uri)):
            g.add((s, p, short_person))
            g.remove((s, p, o))
    #  2). solve the same person name issue    
    result = same_person(name, person_uri, persons)  # if same person name exist, then return the person name, and uri
    if result:
        for s, p, o in g.triples((person_uri, None, None)):
            g.add((result[1], p, o))
            g.remove((s, p, o))
        for s, p, o in g.triples((None, None, person_uri)):
            g.add((s, p, result[1]))  # replace the user
            g.remove((s, p, o))

# model section as resource
swc = rdflib.Namespace('http://data.semanticweb.org/ns/swc/ontology/#')
bibo = rdflib.Namespace('http://purl.org/ontology/bibo/#')
dc = rdflib.Namespace('http://purl.org/dc/elements/1.1/#')
for s, p, o in g.triples((None, bibo.section, None)):
    vol = s.split('#')[0]
    subj = rdflib.URIRef(vol+ '#' + "".join(o.split()))
    # add new triple for section
    g.add((subj, RDF.type, swc.SessionEvent))
    g.add((subj, swc.partOf, rdflib.URIRef(vol+'#proc')))
    g.add((rdflib.URIRef(vol + '#proc'), swc.hasSession, subj))
    g.add((subj, dc.title, o))
    # replace and remove old section information
    g.add((s, p, subj))
    g.remove((s, p, o))
    

# serialize data
s = g.serialize(format='n3')
with open('serialized.ttl', 'wb') as file_:
    file_.write(s)
os.remove('output.ttl')

# remove non relevant data, and solve issues with data set from 
bad_words = ['hint:Query hint:analytic', 'hint:constructDistinctSPO', 'http://www.bigdata.com/',
             'http://www.openrdf.org/schema/sesame']
persons = []
with open('serialized.ttl', 'rb') as old, open('removed.ttl', 'wb') as new:
    for line in old:
        #  replace vol-1 with vol-1/#event
        if re.search(re.compile('\<http\:\/\/ceur\-ws\.org\/Vol\-\d+\/\>'), line):
            event = line.split('/')
            event[1] += '//'
            event[2] += '/'
            event[3] += '/#event'
            line = ''.join(map(str, event))
        #  replace vol-1/#proc, with vol-1
        elif re.search(re.compile('\<http\:\/\/ceur\-ws\.org\/Vol\-\d+\/\#proc\>'), line):
            proc = line.split('/')
            proc[-1] = proc[-1].split('>')[-1]
            proc[1] += '//'
            proc[2] += '/'
            proc[3] += '/>'
            line = ''.join(map(str, proc))
        elif 'a foaf:Person' in line:
            pass
            # print line
        if not any(bad_word in line for bad_word in bad_words):
            new.write(line)
os.remove('serialized.ttl')


