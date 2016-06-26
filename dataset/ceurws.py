import requests
import csv
import urllib
from bs4 import BeautifulSoup


def process_page(page_url):
    pass


def indexing(main_page):
    """
    process indexing page
    :param main_page: the url of the main page of ceur-ws
    :return:
    """
    dict_ = {}
    try:
        data = requests.get(main_page)
    except Exception, e:
        print e.message
    if data.status_code != 200:
        print "Can't connect to " + main_page

    # parsing the content of main page by html parser
    soup = BeautifulSoup(data.text, "html.parser")

    for content in soup.body.find_all('table'):
        for tr in content.find_all('tr'):
            for td in tr.find_all('td', attrs={'bgcolor': ['#DCDBD7', '#FFFFFF']}):
                # find short title
                for short_title in td.find_all('font', attrs={'color': '#000000'}):
                    for st in short_title.find_all('a'):
                        dict_[st['href'].encode('utf8')] = [('short_title', st.text.encode('utf8'))]

                # find all 'see also'
                for see_also in td.find_all('font', attrs={'size': -2}):
                    se_ = []
                    for se in see_also.find_all('a'):
                        se_.append(se.text.encode('utf8'))
                    dict_[st['href'].encode('utf8')].append(('see_also', se_))

                # find all additional information
                if 'Edited by' in td.text:
                    addition = []
                    for a in td.childGenerator():
                        children = a.encode('utf8').strip().lstrip('<br>').split('\n')
                        children = [x.rstrip('<br>') for x in children if 'ARCHIVE' not in x and 'ONLINE' not in x and 'ftp' not
                                         in x and 'Submitted by' not in x and 'Published on' not in x and 'URN' not in x
                                         and '</br></br></br></br></' not in x and x is not '']
                        if len(children) == 1 and 'Proceedings' not in str(children) and 'Edited by' in str(children):
                            addition.append(children[0].split(':')[1].split(', '))
                        elif len(children) == 0:  # Vol-1490 no editor information
                            addition.append(children)
                        else:   # full title
                            addition.append(children[0])
                    dict_[st['href'].encode('utf8')].append(('full_title', addition[0]))
                    dict_[st['href'].encode('utf8')].append(('editors', addition[1]))

    workshops = []
    for key, value in dict_.items():
        new_dict = {}
        new_dict['workshop'] = key
        for index, item in enumerate(value):
            new_dict[item[0]] = item[1]
        workshops.append(new_dict)

    #  write dicts to file
    all_keys = set().union(*(dic.keys() for dic in workshops))  # union all keys from workshops
    with open("ceurws.csv", 'wb') as f:
        dict_writer = csv.DictWriter(f, all_keys)
        dict_writer.writeheader()
        dict_writer.writerows(workshops)


def main():
    ceur = 'http://ceur-ws.org/'
    indexing(ceur)
    site = 1550
    more_data = True
    while more_data and site < 1553:
        try:
            vol = ceur + 'Vol-' + str(site)
            print 'Requesting ' + vol
            data = requests.get(vol)
            site += 1
        except Exception, e:
            more_data = False
            print e.message
        if data.status_code != 200:
            print "Can't connect to " + vol + " (status code: " + data.status_code + ")."


if __name__ == "__main__":
    main()
