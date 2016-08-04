#!/usr/bin/env python
from rdflib.namespace import FOAF, RDF, DC, OWL
from fuzzywuzzy.fuzz import WRatio
import codecs
import requests
import subprocess
import rdflib
import urllib
import os
import sys

'''
This script will serialize rdf data from Blazegraph repository generated by ToolsEswc 
located at https://github.com/liyakun/ToolsEswc and remove non-relevant data. 

The output is generated into file all_clean.ttl.gz in current folder.

This script uses python 2.7.6, and it has been tested on Linux Mint 17.3.
'''

swc = rdflib.Namespace('http://data.semanticweb.org/ns/swc/ontology/#')
bibo = rdflib.Namespace('http://purl.org/ontology/bibo/#')
dc = rdflib.Namespace('http://purl.org/dc/elements/1.1/#')
swrc = rdflib.Namespace('http://swrc.ontoware.org/ontology/#')

def check_blazegraph():
    """check whether blazegraph is running
    return: url of running blaezgraph
    """
    url = 'http://localhost:9999/blazegraph/sparql'
    print 'The default url for Blazegraph running is: %s\n' % url
    user_input = raw_input('If using the default url, please press Enter, else please input: ')

    # if user input a specified url, use user input
    if user_input != '':
        url = user_input

    request = requests.get(url)
    if request.status_code == 200:
        print '\n' + url + ' exists\n'
    else:
        raise ValueError('\n' + url + ' does not exist\n')
    
    return url

def serialize_blazegraph(url):
    """serialize data from blazegraph, other formats see https://wiki.blazegraph.com/wiki/index.php/REST_API
    parameters: url: url of running blazegraph
    """
    arg = "curl -X POST " + url + " --data-urlencode 'query=CONSTRUCT  WHERE {hint:Query hint:analytic " + '"true"' +\
          " . hint:Query hint:constructDistinctSPO " + '"false"' + " . ?s ?p ?o }' -H 'Accept:application/x-turtle' " \
                                                                   " > serialized.ttl"
    subprocess.check_output(arg, shell=True)

def serialize_rdflib(g):
    """serialize to rdf data by using rdflib
    parameters: g: rdf graph store read by rdflib
    """
    s = g.serialize(destination='serialized.ttl', format='turtle')

def data_processing():
    """call SemPub2015Extractor.jar to process dataset, generated dataset will be in blazegraph repository
    """
    subprocess.call("/opt/jdk1.7.0_79/bin/java -jar ../target/SemPub2015Extractor.jar", shell=True)
    print "Data process done!"

def clean_by_sparql(url):
    """remove most non relevant data by SPARQL query
    parameters: url: url of running blazegraph
    """
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

def add_license(url):
    """add license information for volumes in ceurws
    parameters: url address of running blazegraph
    """
    arg = "curl -X POST -H 'Content-Type:application/x-turtle' --data-binary '@license.ttl' " + url
    subprocess.check_output(arg, shell=True)

def add_missed_volumes(url):
    arg = "curl -X POST -H 'Content-Type:application/x-turtle' --data-binary '@1549-1551.ttl' " + url
    subprocess.check_output(arg, shell=True)
    arg = "curl -X POST -H 'Content-Type:application/x-turtle' --data-binary '@vol41.ttl' " + url
    subprocess.check_output(arg, shell=True)

def is_similar(name, vol_names):
    """check if the user name in current volume is similar to any existing one
             strategy: 1). split user name by blank space 
                       2). if number of split blocks equal, and corresponding blocks similarity >= 90
             then assert these two are the same person
    parameters: name: user name, vol_names: vol name
    """
    for names in vol_names:
        if WRatio(names[0], name) >= 90:
            return names
        else:
            exist_u = names[0].split(' ')
            new_u = name.split(' ')
            if len(exist_u) == len(new_u):
                for index, part_u in enumerate(exist_u):
                    if WRatio(part_u, new_u[index]) >= 89:
                        same_u = 1
                    else:
                        same_u = 0
                        break
                if same_u == 1:
                    print 'Same as: ' + str(names) + ', ' + name
                    return names
    return False

def same_person(name, person_uri, persons):
    """if same person with different spelling in same volume then take them as same person
    Parameters: name: persone name, person_uri: person uri, persons: persons of each volume
    """
    vol = person_uri.split('#')[0]
    if vol not in persons:  # if the current volume is not processed yet, add it to dictionary
        persons[vol] = []
    result = is_similar(name, persons[vol])
    if result is False:  # if the name is not similarity to any existing one in current volume
        persons[vol].append((name, person_uri))
        return False
    else:
        return result

def change_subject(subject_new, subject_original, g):
    """change the original subject in triple store g with new subject, and also situations used as object
    parameters: new subject_new, original subject_original, triple store g
    """
    for m, n, t in g.triples((subject_original, None, None)):
        g.add((subject_new, n, t))
        g.remove((m, n, t))
    for m, n, t in g.triples((None, None, subject_original)):
        g.add((m, n, subject_new))
        g.remove((m, n, t))

def define_person(filename):
    # remove remaining not used data, including 'country' and 'related'
    g = rdflib.Graph()
    rdf_result = g.parse(filename, format='turtle')
    ns = rdflib.Namespace("http://fitlayout.github.io/ontology/segmentation.owl#")
    rdf_result.remove((None, ns['country'], None))
    rdf_result.remove((None, ns['related'], None))

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
        if result:  # if same person exist, then merge them
            for s, p, o in g.triples((person_uri, None, None)):
                if p == FOAF.name:
                    pass
                    # g.add((result[1], OWL.sameAs, name)) 
                else:
                    g.add((result[1], p, o))
                g.remove((s, p, o))
            for s, p, o in g.triples((None, None, person_uri)):
                g.add((s, p, result[1]))  # replace the user
                g.remove((s, p, o))
        else:
            person_re = rdflib.URIRef('http://ceur-ws.org/persons/' + person_uri.split('#')[-1])
            g.add((person_uri, OWL.sameAs, person_re))
            # g.add((person_re, OWL.sameAs, person_uri))
    return g

def define_section(g):
    for s, p, o in g.triples((None, bibo.section, None)):
        vol = s.split('#')[0]
        #sec = vol + '#' + o
        subj = rdflib.URIRef(urllib.quote((vol+ '#' + "".join(o.split())).encode('utf8')))
        # add new triple for section
        g.add((subj, RDF.type, swc.SessionEvent))
        g.add((subj, swc.partOf, rdflib.URIRef(vol+'#proc')))
        g.add((rdflib.URIRef(vol + '#proc'), swc.hasSession, subj))
        g.add((subj, dc.title, o))
        # replace and remove old section information
        g.add((s, p, subj))
        g.remove((s, p, o))
    return g

def define_series(g):
    for s, p, o in g.triples((None, RDF.type, bibo.Workshop)):
        if 'part-' in s:
            subj = rdflib.URIRef('http://ceur-ws.org/series/' + s.split('part-')[-1])
            g.add((subj, swc.hasPart, s))
            g.add((s, swc.partOf, subj))
    return g

def define_proc_event(g):
    for s, p, o in g.triples((None, RDF.type, swc.WorkshopEvent)):
        subject = s
        subject += '#event'
        change_subject(subject, s, g)

    for s, p, o in g.triples((None, RDF.type, swc.Proceedings)):
        subject = s
        subject = rdflib.URIRef(subject.replace("#proc", ''))
        change_subject(subject, s, g)
    return g

def merge_graphs(g):
    g2 = define_person('1549-1551.ttl')
    g2 = define_section(g2)
    g3 = define_person('vol41.ttl')
    g3 = define_section(g3)
    g += g2
    g += g3
    return g

def redefine_data():
    """redefine some missed concepts in serialized rdf data from blazegraph
    return: redefined triple store
    """
    # merge person
    g = define_person('serialized.ttl')

    # model section as resource
    g = define_section(g)
    
    # set global resources for event series
    g = define_series(g)

    # swap concept of proceeding and event
    g = define_proc_event(g)
    
    g = merge_graphs(g)

    return g

def remove_bad_words():
    """remove non relevant data
    """
    bad_words = ['hint:Query hint:analytic', 'hint:constructDistinctSPO', 'http://www.bigdata.com/',
                 'http://www.openrdf.org/schema/sesame']
    with open('serialized.ttl', 'rb') as old, open('ceur-ws.ttl', 'wb') as new:
        for line in old:
            if not any(bad_word in line for bad_word in bad_words):
                new.write(line)
    os.remove('serialized.ttl')

def check_file(filename):
    if not os.path.exists(os.path.dirname(filename)):
        try:
            os.mkdir(os.path.dirname(filename))
        except OSError as exc:
            if exc.errno != errno.EEXIST:
                raise

def split_into_volume():
    g = rdflib.Graph()
    rdf_result = g.parse('./ceur-ws.ttl', format='turtle')
    #rdf_result = g.parse('./1549-1551.ttl', format='turtle')

    for s, p, o in g.triples((None, RDF.type, swc.WorkshopEvent)):
        g_ = rdflib.Graph()
        filename = './volumes/'+s.split('/')[3]+'.ttl'
        print "process: " + s
        check_file(filename)
        for m, n, t in g.triples((s, None, None)): # add triple for workshop event
            if n == swrc.isSubEventOf:
                g_.add((t, RDF.type, swc.ConferenceEvent)) # add triple for conference event
            for proc, np, tp in g.triples((None, bibo.presentedAt, m)): # add for proceedings
                for proc_, n_, t_ in g.triples((proc, None, None)):
                    if n_ == swc.hasPart: # add for papers
                        for paper, n__, t__ in g.triples((t_, None, None)):
                            if n__ == swrc.author:
                                for author, n___, t___ in g.triples((t__, None, None)):
                                    g_.add((author, n___, t___))
                            g_.add((paper, n__, t__))
                    if n_ == swrc.editor: # add for editors
                        for editor, n__, t__ in g.triples((t_, None, None)):
                            g_.add((editor, n__, t__))
                    if n_ == swc.hasSession: # add for section
                        for section, n__, t__ in g.triples((t_, None, None)):
                            g_.add((section, n__, t__))
                    g_.add((proc_, n_, t_))
            g_.add((m, n, t))
        g_.serialize(destination=filename, format='turtle')

def clean_file(filename):
    """clean a file by replace some string in a file, and rewrite the new data into it
    """
    # Read in the file
    filedata = None
    with open(filename, 'r') as file :
      filedata = file.read()
    
    # Replace the target string
    filedata = filedata.replace('file:///home/yakun/workspace/ToolsEswc/dataset/', '')
    
    # Write the file out again
    with open(filename, 'w') as file:
      file.write(filedata)

def clean_serializatioin(dirname):
    """clean the serialization dataset, one issue is that the serialization contains the path name for some uri
    """
    path = dirname
    dirs = os.listdir( path )
    # This would print all the files and directories
    for file in dirs:
        print "process " + file
        clean_file(dirname + file)

def main():
    url = check_blazegraph()
    #data_processing()
    clean_by_sparql(url)
    add_license(url)
    #add_missed_volumes(url)
    serialize_blazegraph(url)
    #print "Start to redefine data"
    g = redefine_data()
    serialize_rdflib(g)
    remove_bad_words()
    #split_into_volume()
    #clean_serializatioin('./volumes/')
    clean_file('ceur-ws.ttl')

if __name__ == "__main__":
    main()
