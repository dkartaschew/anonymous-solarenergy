
package com.anonymous.solar.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.anonymous.solar.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CalculateYearlySavings_QNAME = new QName("http://server.solar.anonymous.com/", "calculateYearlySavings");
    private final static QName _CalculateYearlySavingsOverTimeResponse_QNAME = new QName("http://server.solar.anonymous.com/", "calculateYearlySavingsOverTimeResponse");
    private final static QName _CalculateYearlySavingsOverTime_QNAME = new QName("http://server.solar.anonymous.com/", "calculateYearlySavingsOverTime");
    private final static QName _CalculateDailySavings_QNAME = new QName("http://server.solar.anonymous.com/", "calculateDailySavings");
    private final static QName _CalculateYearlySavingsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "calculateYearlySavingsResponse");
    private final static QName _CalculateDailySavingsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "calculateDailySavingsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.anonymous.solar.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculateYearlySavingsResponse }
     * 
     */
    public CalculateYearlySavingsResponse createCalculateYearlySavingsResponse() {
        return new CalculateYearlySavingsResponse();
    }

    /**
     * Create an instance of {@link CalculateDailySavings }
     * 
     */
    public CalculateDailySavings createCalculateDailySavings() {
        return new CalculateDailySavings();
    }

    /**
     * Create an instance of {@link CalculateYearlySavingsOverTime }
     * 
     */
    public CalculateYearlySavingsOverTime createCalculateYearlySavingsOverTime() {
        return new CalculateYearlySavingsOverTime();
    }

    /**
     * Create an instance of {@link CalculateDailySavingsResponse }
     * 
     */
    public CalculateDailySavingsResponse createCalculateDailySavingsResponse() {
        return new CalculateDailySavingsResponse();
    }

    /**
     * Create an instance of {@link CalculateYearlySavings }
     * 
     */
    public CalculateYearlySavings createCalculateYearlySavings() {
        return new CalculateYearlySavings();
    }

    /**
     * Create an instance of {@link CalculateYearlySavingsOverTimeResponse }
     * 
     */
    public CalculateYearlySavingsOverTimeResponse createCalculateYearlySavingsOverTimeResponse() {
        return new CalculateYearlySavingsOverTimeResponse();
    }

    /**
     * Create an instance of {@link SolarResult }
     * 
     */
    public SolarResult createSolarResult() {
        return new SolarResult();
    }

    /**
     * Create an instance of {@link SolarSetup }
     * 
     */
    public SolarSetup createSolarSetup() {
        return new SolarSetup();
    }

    /**
     * Create an instance of {@link SolarInverter }
     * 
     */
    public SolarInverter createSolarInverter() {
        return new SolarInverter();
    }

    /**
     * Create an instance of {@link CustomerData }
     * 
     */
    public CustomerData createCustomerData() {
        return new CustomerData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateYearlySavings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateYearlySavings")
    public JAXBElement<CalculateYearlySavings> createCalculateYearlySavings(CalculateYearlySavings value) {
        return new JAXBElement<CalculateYearlySavings>(_CalculateYearlySavings_QNAME, CalculateYearlySavings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateYearlySavingsOverTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateYearlySavingsOverTimeResponse")
    public JAXBElement<CalculateYearlySavingsOverTimeResponse> createCalculateYearlySavingsOverTimeResponse(CalculateYearlySavingsOverTimeResponse value) {
        return new JAXBElement<CalculateYearlySavingsOverTimeResponse>(_CalculateYearlySavingsOverTimeResponse_QNAME, CalculateYearlySavingsOverTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateYearlySavingsOverTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateYearlySavingsOverTime")
    public JAXBElement<CalculateYearlySavingsOverTime> createCalculateYearlySavingsOverTime(CalculateYearlySavingsOverTime value) {
        return new JAXBElement<CalculateYearlySavingsOverTime>(_CalculateYearlySavingsOverTime_QNAME, CalculateYearlySavingsOverTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateDailySavings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateDailySavings")
    public JAXBElement<CalculateDailySavings> createCalculateDailySavings(CalculateDailySavings value) {
        return new JAXBElement<CalculateDailySavings>(_CalculateDailySavings_QNAME, CalculateDailySavings.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateYearlySavingsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateYearlySavingsResponse")
    public JAXBElement<CalculateYearlySavingsResponse> createCalculateYearlySavingsResponse(CalculateYearlySavingsResponse value) {
        return new JAXBElement<CalculateYearlySavingsResponse>(_CalculateYearlySavingsResponse_QNAME, CalculateYearlySavingsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateDailySavingsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateDailySavingsResponse")
    public JAXBElement<CalculateDailySavingsResponse> createCalculateDailySavingsResponse(CalculateDailySavingsResponse value) {
        return new JAXBElement<CalculateDailySavingsResponse>(_CalculateDailySavingsResponse_QNAME, CalculateDailySavingsResponse.class, null, value);
    }

}
