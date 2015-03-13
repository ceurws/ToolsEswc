#! /usr/bin/gawk
#
# To be applied to http://ceur-ws.org
# Extracts the related workshops and prints the relationships as RDF triples
# (c) Radek Burget 2015
#

BEGIN {
	curvol="none";
	see=0;
	OFS="";
}

tolower($0) ~ /name="?vol-[1-9][0-9]*"/ {
	match($0, /Vol-[1-9][0-9]*/);
	curvol = substr($0, RSTART, RLENGTH);
	see=0;
}

tolower($0) ~ /see also/ {
	see=1;
}

tolower($0) ~ /href="?#vol-[1-9][0-9]*"/ {
	if (see) {
		match($0, /Vol-[1-9][0-9]*/);
		relvol = substr($0, RSTART, RLENGTH);
		print "<http://ceur-ws.org/",curvol,"/>", " ceur:related ", "<http://ceur-ws.org/",relvol,"/>";
	}
}
