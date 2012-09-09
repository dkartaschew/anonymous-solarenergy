
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

    private final static QName _StoreLocationGetAllResponse_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationGetAllResponse");
    private final static QName _StoreLocationInformationResponse_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationInformationResponse");
    private final static QName _StoreLocationInformation_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationInformation");
    private final static QName _StoreLocationGetAll_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationGetAll");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.anonymous.solar.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StoreLocationGetAll }
     * 
     */
    public StoreLocationGetAll createStoreLocationGetAll() {
        return new StoreLocationGetAll();
    }

    /**
     * Create an instance of {@link DoubleArray }
     * 
     */
    public DoubleArray createDoubleArray() {
        return new DoubleArray();
    }

    /**
     * Create an instance of {@link StoreLocationGetAllResponse }
     * 
     */
    public StoreLocationGetAllResponse createStoreLocationGetAllResponse() {
        return new StoreLocationGetAllResponse();
    }

    /**
     * Create an instance of {@link StoreLocationInformation }
     * 
     */
    public StoreLocationInformation createStoreLocationInformation() {
        return new StoreLocationInformation();
    }

    /**
     * Create an instance of {@link LocationData }
     * 
     */
    public LocationData createLocationData() {
        return new LocationData();
    }

    /**
     * Create an instance of {@link StoreLocationInformationResponse }
     * 
     */
    public StoreLocationInformationResponse createStoreLocationInformationResponse() {
        return new StoreLocationInformationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreLocationGetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "StoreLocationGetAllResponse")
    public JAXBElement<StoreLocationGetAllResponse> createStoreLocationGetAllResponse(StoreLocationGetAllResponse value) {
        return new JAXBElement<StoreLocationGetAllResponse>(_StoreLocationGetAllResponse_QNAME, StoreLocationGetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreLocationInformationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "StoreLocationInformationResponse")
    public JAXBElement<StoreLocationInformationResponse> createStoreLocationInformationResponse(StoreLocationInformationResponse value) {
        return new JAXBElement<StoreLocationInformationResponse>(_StoreLocationInformationResponse_QNAME, StoreLocationInformationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreLocationInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "StoreLocationInformation")
    public JAXBElement<StoreLocationInformation> createStoreLocationInformation(StoreLocationInformation value) {
        return new JAXBElement<StoreLocationInformation>(_StoreLocationInformation_QNAME, StoreLocationInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreLocationGetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "StoreLocationGetAll")
    public JAXBElement<StoreLocationGetAll> createStoreLocationGetAll(StoreLocationGetAll value) {
        return new JAXBElement<StoreLocationGetAll>(_StoreLocationGetAll_QNAME, StoreLocationGetAll.class, null, value);
    }

}
