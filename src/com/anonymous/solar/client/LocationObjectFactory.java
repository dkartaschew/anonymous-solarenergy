
package com.anonymous.solar.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.SolarPanel;


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
public class LocationObjectFactory {

    private final static QName _StoreLocationGetAllResponse_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationGetAllResponse");
    private final static QName _StoreLocationInformationResponse_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationInformationResponse");
    private final static QName _StoreLocationInformation_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationInformation");
    private final static QName _StoreLocationGetAll_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationGetAll");
    private final static QName _InsertPanelResponse_QNAME = new QName("http://server.solar.anonymous.com/", "insertPanelResponse");
    private final static QName _InsertPanel_QNAME = new QName("http://server.solar.anonymous.com/", "insertPanel");
    private final static QName _GetPanelsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "getPanelsResponse");
    private final static QName _GetPanels_QNAME = new QName("http://server.solar.anonymous.com/", "getPanels");


    /**
     * Create an instance of {@link SolarPanel }
     * 
     */
    public SolarPanel createSolarPanel() {
        return new SolarPanel();
    }

    /**
     * Create an instance of {@link InsertPanelResponse }
     * 
     */
    public InsertPanelResponse createInsertPanelResponse() {
        return new InsertPanelResponse();
    }

    /**
     * Create an instance of {@link InsertPanel }
     * 
     */
    public InsertPanel createInsertPanel() {
        return new InsertPanel();
    }

    /**
     * Create an instance of {@link GetPanelsResponse }
     * 
     */
    public GetPanelsResponse createGetPanelsResponse() {
        return new GetPanelsResponse();
    }

    /**
     * Create an instance of {@link GetPanels }
     * 
     */
    public GetPanels createGetPanels() {
        return new GetPanels();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertPanelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "insertPanelResponse")
    public JAXBElement<InsertPanelResponse> createInsertPanelResponse(InsertPanelResponse value) {
        return new JAXBElement<InsertPanelResponse>(_InsertPanelResponse_QNAME, InsertPanelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertPanel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "insertPanel")
    public JAXBElement<InsertPanel> createInsertPanel(InsertPanel value) {
        return new JAXBElement<InsertPanel>(_InsertPanel_QNAME, InsertPanel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPanelsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "getPanelsResponse")
    public JAXBElement<GetPanelsResponse> createGetPanelsResponse(GetPanelsResponse value) {
        return new JAXBElement<GetPanelsResponse>(_GetPanelsResponse_QNAME, GetPanelsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPanels }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "getPanels")
    public JAXBElement<GetPanels> createGetPanels(GetPanels value) {
        return new JAXBElement<GetPanels>(_GetPanels_QNAME, GetPanels.class, null, value);
    }
    
    
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.anonymous.solar.client
     * 
     */
    public LocationObjectFactory() {
    }

    /**
     * Create an instance of {@link StoreLocationGetAll }
     * 
     */
    public StoreLocationGetAll createStoreLocationGetAll() {
        return new StoreLocationGetAll();
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
