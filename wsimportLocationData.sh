#!/bin/sh
wsdluri='http://anonymous-solarenergy.appspot.com/LocationInformationService.wsdl'
gensrcdir='./src'
targetpackage='com.anonymous.solar.client'
genoutdir='./war/WEB-INF/classes'
wsimport -verbose -d "$genoutdir" -s "$gensrcdir" -p $targetpackage -keep "$wsdluri"
