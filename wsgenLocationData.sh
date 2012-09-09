#!/bin/sh
class=com.anonymous.solar.server.LocationInformation
clpth='./war/WEB-INF/classes:.:./war/WEB-INF/lib/'
resourcedir='./war'
outsourcedir='./src'
outdir='./war/WEB-INF/classes'
wsgen -verbose -cp "$clpth" -wsdl -keep -r "$resourcedir" -d "$outdir" -s "$outsourcedir"  $class
