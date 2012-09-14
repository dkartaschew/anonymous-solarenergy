
package com.anonymous.solar.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "SInverterService", targetNamespace = "http://server.solar.anonymous.com/", wsdlLocation = "http://anonymous-solarenergy.appspot.com/SInverterService.wsdl")
public class SInverterService
    extends Service
{

    private final static URL SINVERTERSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.anonymous.solar.client.SInverterService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.anonymous.solar.client.SInverterService.class.getResource(".");
            url = new URL(baseUrl, "http://anonymous-solarenergy.appspot.com/SInverterService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://anonymous-solarenergy.appspot.com/SInverterService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SINVERTERSERVICE_WSDL_LOCATION = url;
    }

    public SInverterService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SInverterService() {
        super(SINVERTERSERVICE_WSDL_LOCATION, new QName("http://server.solar.anonymous.com/", "SInverterService"));
    }

    /**
     * 
     * @return
     *     returns SInverter
     */
    @WebEndpoint(name = "SInverterPort")
    public SInverter getSInverterPort() {
        return super.getPort(new QName("http://server.solar.anonymous.com/", "SInverterPort"), SInverter.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SInverter
     */
    @WebEndpoint(name = "SInverterPort")
    public SInverter getSInverterPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.solar.anonymous.com/", "SInverterPort"), SInverter.class, features);
    }

}