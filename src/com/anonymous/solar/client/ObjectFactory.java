
package com.anonymous.solar.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

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
public class ObjectFactory {

    private final static QName _InsertPanelResponse_QNAME = new QName("http://server.solar.anonymous.com/", "insertPanelResponse");
    private final static QName _InsertPanel_QNAME = new QName("http://server.solar.anonymous.com/", "insertPanel");
    private final static QName _GetPanelsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "getPanelsResponse");
    private final static QName _GetPanels_QNAME = new QName("http://server.solar.anonymous.com/", "getPanels");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.anonymous.solar.client
     * 
     */
    public ObjectFactory() {
    }

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

}
