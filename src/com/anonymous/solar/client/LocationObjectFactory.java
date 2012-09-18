
package com.anonymous.solar.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.SolarInverter;
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

	//Location
    private final static QName _StoreLocationGetAllResponse_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationGetAllResponse");
    private final static QName _StoreLocationInformationResponse_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationInformationResponse");
    private final static QName _StoreLocationInformation_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationInformation");
    private final static QName _StoreLocationGetAll_QNAME = new QName("http://server.solar.anonymous.com/", "StoreLocationGetAll");
    
    //Panel
    private final static QName _InsertPanelResponse_QNAME = new QName("http://server.solar.anonymous.com/", "insertPanelResponse");
    private final static QName _InsertPanel_QNAME = new QName("http://server.solar.anonymous.com/", "insertPanel");
    private final static QName _GetPanelsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "getPanelsResponse");
    private final static QName _GetPanels_QNAME = new QName("http://server.solar.anonymous.com/", "getPanels");

    //inverter
    private final static QName _RemoveInverterResponse_QNAME = new QName("http://server.solar.anonymous.com/", "removeInverterResponse");
    private final static QName _GetInvertersResponse_QNAME = new QName("http://server.solar.anonymous.com/", "getInvertersResponse");
    private final static QName _InsertInverterResponse_QNAME = new QName("http://server.solar.anonymous.com/", "insertInverterResponse");
    private final static QName _GetInverters_QNAME = new QName("http://server.solar.anonymous.com/", "getInverters");
    private final static QName _InsertInverter_QNAME = new QName("http://server.solar.anonymous.com/", "insertInverter");
    private final static QName _RemoveInverter_QNAME = new QName("http://server.solar.anonymous.com/", "removeInverter");
    
    private final static QName _CalculateYearlySavings_QNAME = new QName("http://server.solar.anonymous.com/", "calculateYearlySavings");
    private final static QName _CalculateAllResultsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "calculateAllResultsResponse");
    private final static QName _CalculateAllResults_QNAME = new QName("http://server.solar.anonymous.com/", "calculateAllResults");
    private final static QName _CalculateYearlySavingsOverTimeResponse_QNAME = new QName("http://server.solar.anonymous.com/", "calculateYearlySavingsOverTimeResponse");
    private final static QName _CalculateYearlySavingsOverTime_QNAME = new QName("http://server.solar.anonymous.com/", "calculateYearlySavingsOverTime");
    private final static QName _CalculateMonthlySavingsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "calculateMonthlySavingsResponse");
    private final static QName _CalculateDailySavings_QNAME = new QName("http://server.solar.anonymous.com/", "calculateDailySavings");
    private final static QName _CalculateYearlySavingsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "calculateYearlySavingsResponse");
    private final static QName _CalculateDailySavingsResponse_QNAME = new QName("http://server.solar.anonymous.com/", "calculateDailySavingsResponse");
    private final static QName _CalculateMonthlySavings_QNAME = new QName("http://server.solar.anonymous.com/", "calculateMonthlySavings");



    /**
     * Create an instance of {@link RemoveInverter }
     * 
     */
    public RemoveInverter createRemoveInverter() {
        return new RemoveInverter();
    }

    /**
     * Create an instance of {@link RemoveInverterResponse }
     * 
     */
    public RemoveInverterResponse createRemoveInverterResponse() {
        return new RemoveInverterResponse();
    }

    /**
     * Create an instance of {@link InsertInverterResponse }
     * 
     */
    public InsertInverterResponse createInsertInverterResponse() {
        return new InsertInverterResponse();
    }

    /**
     * Create an instance of {@link GetInvertersResponse }
     * 
     */
    public GetInvertersResponse createGetInvertersResponse() {
        return new GetInvertersResponse();
    }

    /**
     * Create an instance of {@link SolarInverter }
     * 
     */
    public SolarInverter createSolarInverter() {
        return new SolarInverter();
    }

    /**
     * Create an instance of {@link GetInverters }
     * 
     */
    public GetInverters createGetInverters() {
        return new GetInverters();
    }

    /**
     * Create an instance of {@link InsertInverter }
     * 
     */
    public InsertInverter createInsertInverter() {
        return new InsertInverter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveInverterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "removeInverterResponse")
    public JAXBElement<RemoveInverterResponse> createRemoveInverterResponse(RemoveInverterResponse value) {
        return new JAXBElement<RemoveInverterResponse>(_RemoveInverterResponse_QNAME, RemoveInverterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInvertersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "getInvertersResponse")
    public JAXBElement<GetInvertersResponse> createGetInvertersResponse(GetInvertersResponse value) {
        return new JAXBElement<GetInvertersResponse>(_GetInvertersResponse_QNAME, GetInvertersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertInverterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "insertInverterResponse")
    public JAXBElement<InsertInverterResponse> createInsertInverterResponse(InsertInverterResponse value) {
        return new JAXBElement<InsertInverterResponse>(_InsertInverterResponse_QNAME, InsertInverterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInverters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "getInverters")
    public JAXBElement<GetInverters> createGetInverters(GetInverters value) {
        return new JAXBElement<GetInverters>(_GetInverters_QNAME, GetInverters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertInverter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "insertInverter")
    public JAXBElement<InsertInverter> createInsertInverter(InsertInverter value) {
        return new JAXBElement<InsertInverter>(_InsertInverter_QNAME, InsertInverter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveInverter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "removeInverter")
    public JAXBElement<RemoveInverter> createRemoveInverter(RemoveInverter value) {
        return new JAXBElement<RemoveInverter>(_RemoveInverter_QNAME, RemoveInverter.class, null, value);
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
     * Create an instance of {@link CustomerData }
     * 
     */
    public CustomerData createCustomerData() {
        return new CustomerData();
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
     * Create an instance of {@link CalculateMonthlySavingsResponse }
     * 
     */
    public CalculateMonthlySavingsResponse createCalculateMonthlySavingsResponse() {
        return new CalculateMonthlySavingsResponse();
    }

    /**
     * Create an instance of {@link CalculateYearlySavingsOverTime }
     * 
     */
    public CalculateYearlySavingsOverTime createCalculateYearlySavingsOverTime() {
        return new CalculateYearlySavingsOverTime();
    }

    /**
     * Create an instance of {@link CalculateMonthlySavings }
     * 
     */
    public CalculateMonthlySavings createCalculateMonthlySavings() {
        return new CalculateMonthlySavings();
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
     * Create an instance of {@link CalculateAllResults }
     * 
     */
    public CalculateAllResults createCalculateAllResults() {
        return new CalculateAllResults();
    }

    /**
     * Create an instance of {@link CalculateAllResultsResponse }
     * 
     */
    public CalculateAllResultsResponse createCalculateAllResultsResponse() {
        return new CalculateAllResultsResponse();
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
     * Create an instance of {@link SolarPanels }
     * 
     */
    public SolarPanels createSolarPanels() {
        return new SolarPanels();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateAllResultsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateAllResultsResponse")
    public JAXBElement<CalculateAllResultsResponse> createCalculateAllResultsResponse(CalculateAllResultsResponse value) {
        return new JAXBElement<CalculateAllResultsResponse>(_CalculateAllResultsResponse_QNAME, CalculateAllResultsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateAllResults }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateAllResults")
    public JAXBElement<CalculateAllResults> createCalculateAllResults(CalculateAllResults value) {
        return new JAXBElement<CalculateAllResults>(_CalculateAllResults_QNAME, CalculateAllResults.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateMonthlySavingsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateMonthlySavingsResponse")
    public JAXBElement<CalculateMonthlySavingsResponse> createCalculateMonthlySavingsResponse(CalculateMonthlySavingsResponse value) {
        return new JAXBElement<CalculateMonthlySavingsResponse>(_CalculateMonthlySavingsResponse_QNAME, CalculateMonthlySavingsResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateMonthlySavings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.solar.anonymous.com/", name = "calculateMonthlySavings")
    public JAXBElement<CalculateMonthlySavings> createCalculateMonthlySavings(CalculateMonthlySavings value) {
        return new JAXBElement<CalculateMonthlySavings>(_CalculateMonthlySavings_QNAME, CalculateMonthlySavings.class, null, value);
    }

}
