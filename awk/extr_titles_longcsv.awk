#! /usr/bin/gawk
#
# To be applied to http://ceur-ws.org
# Extracts the titles and publication dates for the individual volumes
# (c) Radek Burget 2015
#

#Run:
#cat index.html | awk -f extr_titles_longcsv.awk | php -r 'while(($line=fgets(STDIN)) !== FALSE) echo html_entity_decode($line, ENT_QUOTES|ENT_HTML401);' >titles_long.csv

function ltrim(s) { sub(/^[ \t\r\n]+/, "", s); return s }
function rtrim(s) { sub(/[ \t\r\n\.,]+$/, "", s); return s }
function trim(s)  { return rtrim(ltrim(s)); }
function clean(s) { gsub(/<\/?[A-Za-z]+>/, "", s); return s }

BEGIN {
	curvol="none";
	curproc="";
	curdate="";
	OFS=";;";
	afterTitle = 0;
}

tolower($0) ~ /name="?vol-[1-9][0-9]*"/ {
	match($0, /Vol-[1-9][0-9]*/);
	curvol = substr($0, RSTART, RLENGTH);
}

tolower($0) ~ /href="http:\/\/ceur-ws\.org\/vol-[1-9][0-9]*\/"/ {
	match($0, />.+</);
	curtitle = substr($0, RSTART+1, RLENGTH-2);
	afterTitle = 1;
}

tolower($0) ~ /^edited by:/ {
	afterTitle = 0;
}

tolower($0) ~ /proceedings/ {
	if (afterTitle == 1) {
		curproc = trim($0);
		curdate = curproc; #the date is here or after the proceedings
	}
}

tolower($0) ~ /[12][09][0-9][0-9]/ {
	if (afterTitle == 1) {
		curdate = trim($0);
	}
}

tolower($0) ~ /^published on ceur-ws:/ {
	match($0, /:.+$/);
	subm = substr($0, RSTART+1, RLENGTH-5);
	print "<http://ceur-ws.org/" curvol "/>", 
			trim(clean(curtitle)),
			trim(clean(subm)),
			trim(clean(curproc)),
			trim(clean(curdate));
}
