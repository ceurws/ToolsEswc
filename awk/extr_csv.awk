#! /usr/bin/gawk
#
# To be applied to http://ceur-ws.org
# Extracts the titles and publication dates for the individual volumes
# (c) Radek Burget 2015
#

BEGIN {
	curvol="none";
	OFS=";;";
}

tolower($0) ~ /name="?vol-[1-9][0-9]*"/ {
	match($0, /Vol-[1-9][0-9]*/);
	curvol = substr($0, RSTART, RLENGTH);
}

tolower($0) ~ /href="http:\/\/ceur-ws\.org\/vol-[1-9][0-9]*\/"/ {
	match($0, />.+</);
	curtitle = substr($0, RSTART+1, RLENGTH-2);
}

tolower($0) ~ /^published on ceur-ws:/ {
	match($0, /:.+$/);
	subm = substr($0, RSTART+1, RLENGTH-5);
	print curvol, curtitle, subm;
}
