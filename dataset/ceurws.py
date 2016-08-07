import csv
import requests
import rdflib
import urllib
import dateparser
import re
from bs4 import BeautifulSoup
from rdflib.namespace import FOAF, RDF, XSD, DC

'''
This tool can be used to process volume page in http://ceur-ws.org/, and build rdf data output
Different volume structure can be extended in ProcessPage class, it currently support vol-1549, vol-1550, vol-1551 and
volumes with same structure as these three

Author: Yakun Li, Email: liyakun127@gmail.com
'''


class CommonTools:

    def __init__(self):
        pass

    def url_validation(self, url):
        """validate url address
        :param url:
        :return: data of checked page
        """
        try:
            data = requests.get(url)
        except Exception, e:
            print e.message
        if data.status_code != 200:
            print "Can't connect to " + url
        return data

    def clean_string(self, string):
        """remove leading, tailing space, replace newline, and merge multiple space into one
        :param string: string to be processed
        :return: string after processed
        """
        string = ' '.join(string.strip().replace('\n', '').split()).encode('utf8')
        return string
    
    def clean_string2(self, string):
        return ''.join(e for e in string if e.isalnum())


class IndexPage:

    def __init__(self, ceur='http://ceur-ws.org/'):
        """init function for class IndexPage
        :param ceur: main page of ceur-ws
        """
        self.main_page = ceur
        self.tools = CommonTools()

    def indexing(self):
        """process indexing page
        """
        dict_ = {}
        data = self.tools.url_validation(self.main_page)

        # parsing the content of main page by html parser
        soup = BeautifulSoup(data.text, "html.parser")

        for content in soup.body.find_all('table'):
            for tr in content.find_all('tr'):
                for td in tr.find_all('td', attrs={'bgcolor': ['#DCDBD7', '#FFFFFF']}):
                    # find short title
                    for short_title in td.find_all('font', attrs={'color': '#000000'}):
                        for st in short_title.find_all('a'):
                            dict_[self.tools.clean_string(st['href'])] = [('short_title', self.tools.clean_string(st.text))]

                    # find all 'see also'
                    for see_also in td.find_all('font', attrs={'size': -2}):
                        se_ = []
                        for se in see_also.find_all('a'):
                            se_.append(self.tools.clean_string(se.text))
                        dict_[self.tools.clean_string(st['href'])].append(('see_also', se_))

                    # find all additional information
                    if 'Edited by' in td.text:
                        addition = []
                        for a in td.childGenerator():
                            children = a.encode('utf8').strip().lstrip('<br>').split('\n')
                            children = [x.rstrip('<br>') for x in children if
                                        'ARCHIVE' not in x and 'ONLINE' not in x and 'ftp' not
                                        in x and 'Submitted by' not in x and 'Published on' not in x and 'URN' not in x
                                        and '</br></br></br></br></' not in x and x is not '']
                            if len(children) == 1 and 'Proceedings' not in str(children) and 'Edited by' in str(
                                    children):
                                addition.append(children[0].split(':')[1].split(', '))
                            elif len(children) == 0:  # Vol-1490 no editor information
                                addition.append(children)
                            else:  # full title
                                addition.append(children[0])
                        dict_[st['href'].encode('utf8')].append(('full_title', addition[0]))
                        dict_[st['href'].encode('utf8')].append(('editors', addition[1]))
        return dict_

    def write_csv(self, dict_, filename='ceurws.csv'):
        """ write index page to csv file
        :param dict_: dict object got from index page processing
        :param filename: file name of written csv
        """
        workshops = []
        for key, value in dict_.items():
            new_dict = dict()
            new_dict['workshop'] = key
            for ind, item in enumerate(value):
                new_dict[item[0]] = item[1]
            workshops.append(new_dict)

        # write dicts to file
        all_keys = set().union(*(dic.keys() for dic in workshops))  # union all keys from workshops
        with open(filename, 'wb') as f:
            dict_writer = csv.DictWriter(f, all_keys)
            dict_writer.writeheader()
            dict_writer.writerows(workshops)


class BuildModel:

    def __init__(self):
        self.swc = rdflib.Namespace('http://data.semanticweb.org/ns/swc/ontology/#')
        self.bibo = rdflib.Namespace('http://purl.org/ontology/bibo/#')
        self.dc = rdflib.Namespace('http://purl.org/dc/elements/1.1/#')
        self.swrc = rdflib.Namespace('http://swrc.ontoware.org/ontology/#')
        self.time = rdflib.Namespace('http://purl.org/NET/c4dm/timeline.owl/#')
        self.purl = rdflib.Namespace('http://purl.org/dc/elements/1.1/#')
        self.rdfs = rdflib.Namespace('http://www.w3.org/2000/01/rdf-schema#')
        self.owl = rdflib.Namespace('http://www.w3.org/2002/07/owl#')
        self.issued = rdflib.Namespace('http://dublincore.org/documents/dcmi-terms/#')
        self.location = 'http://dbpedia.org/resource/'
        self.tools = CommonTools()

    def serialize(self, g, filename='1549-1551.ttl'):
        """serialize graph g
        :param g: rdf graph g
        :param filename: file name to serialize
        :return:
        """
        g.serialize(destination=filename, format='turtle', encoding='utf-8')

    def build_event(self, g, page, index_page):
        """build triples for event
        :param g: rdf graph
        :param page: page dictionary data
        :param index_page: index page list
        :return:
        """
        volume = rdflib.URIRef(page.get('volume')+'#event')
        g.add((volume, RDF.type, self.swc.WorkshopEvent))
        g.add((volume, self.swrc.hasLocation, rdflib.Literal(self.location + self.tools.clean_string(page['location'].split(',')[-1]))))
        g.add((volume, self.swrc.isSubEventOf, rdflib.URIRef(page.get('volume') + '#conf')))
        g.add((volume, self.time.beginsAtDatetime, rdflib.Literal(dateparser.parse(self.tools.clean_string(page.get('time'))), datatype=XSD.date)))
        g.add((volume, self.time.endsAtDatetime, rdflib.Literal(dateparser.parse(self.tools.clean_string(page.get('time'))), datatype=XSD.date)))
        for others in index_page[1][1]:
            if others:
                g.add((volume, self.rdfs.seeAlso, rdflib.URIRef('http://ceur-ws.org/' + self.tools.clean_string(others) + '/')))

    def build_conf(self, g, page):
        """build triples for conference
        :param g: rdf graph
        :param page: page dictionary data
        :return:
        """
        g.add((rdflib.URIRef(page.get('volume') + '#conf'), RDF.type, self.swc.ConferenceEvent))

    def build_person(self, g, person_uri, person_name, paper_uri):
        """build triples for person
        :param g: rdf graph
        :param person_uri: uri of person
        :param person_name: name of person
        :param paper_uri: uri of paper written by person
        :return:
        """
        g.add((person_uri, RDF.type, FOAF.person))
        #g.add((person_uri, self.owl.sameAs, rdflib.URIRef(urllib.quote(('http://ceur-ws.org/persons/' + self.tools.clean_string(person_name))))))
        g.add((person_uri, FOAF.made, paper_uri))
        g.add((person_uri, FOAF.name, rdflib.Literal(self.tools.clean_string(person_name))))

    def build_papers(self, g, page):
        """build triples for paper
        :param g: rdf graph
        :param page: page dictionary data
        :return:
        """
        volume = page.get('volume').strip()
        #proc = rdflib.URIRef(volume + 'proc')
        paper_list = []
        for paper in page.get('papers'):
            paper_uri = rdflib.URIRef(volume + '#' + self.tools.clean_string(paper[0]).split('.')[0])
            g.add((paper_uri, RDF.type, self.swc.Paper))
            #g.add((paper_uri, self.swc.partOf, rdflib.URIRef(proc)))
            g.add((paper_uri, self.swc.partOf, rdflib.URIRef(volume)))
            g.add((paper_uri, self.purl.title, rdflib.Literal(self.tools.clean_string(paper[1]))))
            for authors in paper[2: -1]:
                #author = rdflib.URIRef(urllib.quote(self.tools.clean_string(volume + authors)))
                author = rdflib.URIRef(volume + self.tools.clean_string2(authors))
                g.add((paper_uri, self.swrc.author, author))
                self.build_person(g, author, authors, paper_uri)
            paper_list.append(paper_uri)
        return paper_list

    def build_editors(self, g, page):
        """build triples for editors
        :param g: rdf graph
        :param page: page dictionary data
        :return: a list of editors uri
        """
        editors_list = []
        editors = page.get('editors')
        institutions = page.get('institutions')
        volume = page.get('volume').strip()

        # match editors and institutions
        for editor, institution in zip(editors, institutions):
            editor_name = self.tools.clean_string(editor[:-1])
            #editor_uri = rdflib.URIRef(urllib.quote((volume + editor_name)))
            editor_uri = rdflib.URIRef(volume + self.tools.clean_string2(editor_name))
            editors_list.append(editor_uri)
            institution = self.tools.clean_string(institution[1:])
            g.add((editor_uri, RDF.type, FOAF.person))
            g.add((editor_uri, self.swrc.affiliation, rdflib.Literal(institution)))
            #g.add((editor_uri, self.owl.sameAs, rdflib.URIRef(urllib.quote('http://ceur-ws.org/persons/' + editor_name))))
            g.add((editor_uri, FOAF.name, rdflib.Literal(editor_name)))

        return editors_list

    def build_proceeding(self, g, page, paper_list, editor_list):
        """build triples for proceedings
        :param g: rdf graph
        :param page: page dictionary data
        :param paper_list: list of paper uri
        :param editor_list: list of editor uri
        :return:
        """
        volume = page.get('volume').strip()
        #proc = rdflib.URIRef(volume + 'proc')
        proc = rdflib.URIRef(volume)

        g.add((proc, RDF.type, self.swc.Proceedings))

        for paper_uri in paper_list:
            g.add((proc, self.swc.hasPart, paper_uri))

        # present at
        g.add((proc, self.bibo.presentedAt, rdflib.URIRef(volume+'#event')))

        # issued
        g.add((proc, self.issued.issued, rdflib.Literal(dateparser.parse(page.get('issue_date')), datatype=XSD.date)))

        # for editors
        for editor in editor_list:
            g.add((proc, self.swrc.editor, editor))

    def build_model(self, page, index_page):
        """build rdf graph for single volume
        :param page:
        :param index_page:
        :return: rdf graph model for single volume
        """
        g = rdflib.Graph()

        # build event
        self.build_event(g, page, index_page)

        # build conf
        self.build_conf(g, page)

        # build papers and authors
        paper_list = self.build_papers(g, page)

        # build editors
        editors_list = self.build_editors(g, page)

        # build proceeding
        self.build_proceeding(g, page, paper_list, editors_list)

        return g


class ProcessPage:

    def __init__(self, pages):
        """init for class ProcessPage
        :param pages: list of page url to be processed
        """
        self.pages = pages
        self.tools = CommonTools()
        self.modeler = BuildModel()

    def process_page(self, url):
        """process single volume for specific url
        :param url: url of volume
        :return: dictionary data for single volume
        """
        page_ = dict()
        data = self.tools.url_validation(url)
        page_['volume'] = url
        soup = BeautifulSoup(data.text, "html.parser")

        for main in soup.body.find_all('main'):
            for article in main.find_all('article'):
                for dl in article.find_all('dl', attrs={'id': 'document-event'}):
                    for dd in dl.find_all('dd', attrs={'property': 'schema:description'}):
                        page_['full title'] = dd.text
                    for dd in dl.find_all('dd', attrs={'class': 'CEURLOCATION'}):
                        page_['location'] = dd.text
                    for dd in dl.find_all('dd', attrs={'class': 'CEURTIME'}):
                        page_['time'] = dd.text
                for div in article.find_all('div', attrs={'id': 'authors'}):
                    for dl in div.find_all('dl', attrs={'id': 'author-name'}):
                        page_['editors'] = []
                        for dd in dl.find_all('dd'):
                            page_['editors'].append(dd.text)
                    for ul in div.find_all('ul', attrs={'id': 'author-org'}):
                        page_['institutions'] = []
                        for li in ul.find_all('li'):
                            page_['institutions'].append(li.text)
                for div in article.find_all('div', attrs={'id': 'content'}):
                    for section in div.find_all('section', attrs={'class': 'CEURTOC'}):
                        for div2 in section.find_all('div', attrs={'property': 'schema:description'}):
                            for ol in div2.find_all('ol', attrs={'rel': 'schema:hasPart'}):
                                page_['papers'] = []
                                for li in ol.find_all('li'):
                                    papers = []
                                    for link in li.find_all('a', attrs={'class': 'CEURTITLE'}):
                                        papers.append(link['href'])
                                        papers.append(link.text)
                                    for dd in li.find_all('dd'):
                                        papers.append(dd.text)
                                    page_['papers'].append(papers)
        for footer in soup.body.find_all('footer'):
            for p in footer.find_all('p'):
                for time in p.find_all('time', attrs={'class': 'CEURPUBDATE'}):
                    page_['issue_date'] = time.text

        return page_
    
    def grasp_license(self, item_url, g):
        response = requests.get(item_url)
        soup = BeautifulSoup(response.text, 'html.parser')
        test = soup.findAll(text = re.compile('Creative Commons CC0'))
        if test:
            g.add((rdflib.URIRef(item_url), DC.license, rdflib.Literal('http://creativecommons.org/publicdomain/zero/1.0/')))
        else:
            g.add((rdflib.URIRef(item_url), DC.license, rdflib.Literal('http://choosealicense.com/licenses/no-license/')))

    def single_serialize(self, g, vol):
        """ serialize for single volume graph
        :param g: graph for single volume
        :param vol: volume id
        :return:
        """
        self.modeler.serialize(g, vol)

    def merge_serialize(self, vol_list):
        """merge and serialize for list of graph model
        :param vol_list:
        :return:
        """
        g = rdflib.Graph()
        for g_ in vol_list:
            g += g_
        self.modeler.serialize(g)

    def process_data(self, pages_, pages_pre_):
        """process data for vol in pages_, combining information from index data in pages_pre_
        :param pages_: vol page url
        :param pages_pre_: index page dictionary data
        :return:
        """
        rdf_model = []
        for ind, page in enumerate(pages_):
            page_ = self.process_page(page)
            rdf_model.append(self.modeler.build_model(page_, pages_pre_[ind]))
        self.merge_serialize(rdf_model)


index = IndexPage()
dict_ = index.indexing()
pages = ['http://ceur-ws.org/Vol-1549/', 'http://ceur-ws.org/Vol-1550/', 'http://ceur-ws.org/Vol-1551/']
pages_pre = [dict_.get(key) for key in pages]
processor = ProcessPage(pages)
processor.process_data(pages, pages_pre)
#g = rdflib.Graph()
#for keys in dict_:
#    processor.grasp_license(keys, g)
#processor.single_serialize(g, 'license')