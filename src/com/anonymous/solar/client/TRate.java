
package com.anonymous.solar.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.anonymous.solar.shared.TariffRate;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "TRate", targetNamespace = "http://server.solar.anonymous.com/")
@XmlSeeAlso({
    LocationObjectFactory.class
})
public interface TRate {


    /**
     * 
     * @return
     *     returns java.util.List<com.anonymous.solar.client.TariffRate>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTariffRates", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.GetTariffRates")
    @ResponseWrapper(localName = "getTariffRatesResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.GetTariffRatesResponse")
    public List<TariffRate> getTariffRates();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertTariffRate", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.InsertTariffRate")
    @ResponseWrapper(localName = "insertTariffRateResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.InsertTariffRateResponse")
    public boolean insertTariffRate(
        @WebParam(name = "arg0", targetNamespace = "")
        TariffRate arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "removeTariffRate", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.RemoveTariffRate")
    @ResponseWrapper(localName = "removeTariffRateResponse", targetNamespace = "http://server.solar.anonymous.com/", className = "com.anonymous.solar.client.RemoveTariffRateResponse")
    public boolean removeTariffRate(
        @WebParam(name = "arg0", targetNamespace = "")
        Long arg0);

}