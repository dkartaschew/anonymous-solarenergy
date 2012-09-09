
package com.anonymous.solar.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SolarCalculator", targetNamespace = "http://server.solar.anonymous.com/")
@XmlSeeAlso({
    LocationObjectFactory.class
})
public interface SolarCalculator {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.anonymous.solar.client.SolarResult
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "calculateYearlySavingsOverTime", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.CalculateYearlySavingsOverTime")
    @ResponseWrapper(localName = "calculateYearlySavingsOverTimeResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.CalculateYearlySavingsOverTimeResponse")
    @Action(input = "http://server.solar.anonymous.com/SolarCalculator/calculateYearlySavingsOverTimeRequest", output = "http://server.solar.anonymous.com/SolarCalculator/calculateYearlySavingsOverTimeResponse")
    public SolarResult calculateYearlySavingsOverTime(
        @WebParam(name = "arg0", targetNamespace = "")
        SolarResult arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.anonymous.solar.client.SolarResult
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "calculateDailySavings", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.CalculateDailySavings")
    @ResponseWrapper(localName = "calculateDailySavingsResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.CalculateDailySavingsResponse")
    @Action(input = "http://server.solar.anonymous.com/SolarCalculator/calculateDailySavingsRequest", output = "http://server.solar.anonymous.com/SolarCalculator/calculateDailySavingsResponse")
    public SolarResult calculateDailySavings(
        @WebParam(name = "arg0", targetNamespace = "")
        SolarResult arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns com.anonymous.solar.client.SolarResult
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "calculateYearlySavings", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.CalculateYearlySavings")
    @ResponseWrapper(localName = "calculateYearlySavingsResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.CalculateYearlySavingsResponse")
    @Action(input = "http://server.solar.anonymous.com/SolarCalculator/calculateYearlySavingsRequest", output = "http://server.solar.anonymous.com/SolarCalculator/calculateYearlySavingsResponse")
    public SolarResult calculateYearlySavings(
        @WebParam(name = "arg0", targetNamespace = "")
        SolarResult arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
