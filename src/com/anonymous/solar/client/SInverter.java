
package com.anonymous.solar.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.anonymous.solar.shared.SolarInverter;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SInverter", targetNamespace = "http://server.solar.anonymous.com/")
@XmlSeeAlso({
    LocationObjectFactory.class
})
public interface SInverter {


    /**
     * 
     * @return
     *     returns java.util.List<com.anonymous.solar.client.SolarInverter>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getInverters", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.GetInverters")
    @ResponseWrapper(localName = "getInvertersResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.GetInvertersResponse")
    public List<SolarInverter> getInverters();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertInverter", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.InsertInverter")
    @ResponseWrapper(localName = "insertInverterResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.InsertInverterResponse")
    public boolean insertInverter(
        @WebParam(name = "arg0", targetNamespace = "")
        SolarInverter arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeInverter", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.RemoveInverter")
    @ResponseWrapper(localName = "removeInverterResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.RemoveInverterResponse")
    public boolean removeInverter(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

}
