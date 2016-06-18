import subprocess

print 'Dump index.html'
arg = 'wget http://ceur-ws.org/'

print 'Dump editors.csv ...'
arg = "cat index.html | awk -f extr_editors_csv.awk | php -r 'while(($line=fgets(STDIN)) !== FALSE) echo html_entity_decode($line, ENT_QUOTES|ENT_HTML401);' >editors.csv"
subprocess.check_output(arg, shell=True)

print 'Dump editors.n3 ...'
arg = "cat index.html | awk -f extr_editors.awk | php -r 'while(($line=fgets(STDIN)) !== FALSE) echo html_entity_decode($line, ENT_QUOTES|ENT_HTML401);' >editors.n3"
subprocess.check_output(arg, shell=True)

print 'Dump related.csv ...'
arg = "cat index.html | awk -f extr_related_csv.awk | php -r 'while(($line=fgets(STDIN)) !== FALSE) echo html_entity_decode($line, ENT_QUOTES|ENT_HTML401);' >related.csv"
subprocess.check_output(arg, shell=True)

print 'Dump related.ttl ...'
arg = "cat index.html | awk -f extr_related.awk | php -r 'while(($line=fgets(STDIN)) !== FALSE) echo html_entity_decode($line, ENT_QUOTES|ENT_HTML401);' >related.ttl"
subprocess.check_output(arg, shell=True)

print 'Dump titles.csv ...'
arg = "cat index.html | awk -f extr_titles_csv.awk | php -r 'while(($line=fgets(STDIN)) !== FALSE) echo html_entity_decode($line, ENT_QUOTES|ENT_HTML401);' >titles.csv"
subprocess.check_output(arg, shell=True)

print 'Dump titles_long.csv ...'
arg = "cat index.html | awk -f extr_titles_longcsv.awk | php -r 'while(($line=fgets(STDIN)) !== FALSE) echo html_entity_decode($line, ENT_QUOTES|ENT_HTML401);' >titles_long.csv"
subprocess.check_output(arg, shell=True)

print 'Dump titles.n3 ...'
arg = "cat index.html | awk -f extr_titles.awk | php -r 'while(($line=fgets(STDIN)) !== FALSE) echo html_entity_decode($line, ENT_QUOTES|ENT_HTML401);' >titles.n3"
subprocess.check_output(arg, shell=True)

print 'Done dump files.'

arg = "mv ./*.n3 ./*.csv ./*.ttl ../src/main/resources/"
subprocess.check_output(arg, shell=True)
print 'Dump files are moved to ../src/main/resources/'

