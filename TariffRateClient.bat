set wsdluri=http://anonymous-solarenergy.appspot.com/TRateService.wsdl
set gensrcdir=./src
set targetpackage=com.anonymous.solar.client
set genoutdir=./war/WEB-INF/classes
wsimport -d "%genoutdir%" -s "%gensrcdir%" -p %targetpackage% -keep "%wsdluri%"