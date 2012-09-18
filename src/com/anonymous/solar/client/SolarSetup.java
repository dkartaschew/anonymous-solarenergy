
package com.anonymous.solar.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solarSetup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solarSetup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerData" type="{http://server.solar.anonymous.com/}customerData" minOccurs="0"/>
 *         &lt;element name="inverter" type="{http://server.solar.anonymous.com/}solarInverter" minOccurs="0"/>
 *         &lt;element name="location" type="{http://server.solar.anonymous.com/}locationData" minOccurs="0"/>
 *         &lt;element name="panels" type="{http://server.solar.anonymous.com/}solarPanels" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="setupDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="setupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wireEfficiency" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="wireLength" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solarSetup", propOrder = {
    "customerData",
    "inverter",
    "location",
    "panels",
    "setupDescription",
    "setupName",
    "wireEfficiency",
    "wireLength"
})
public class SolarSetup {

    protected CustomerData customerData;
    protected SolarInverter inverter;
    protected LocationData location;
    @XmlElement(nillable = true)
    protected List<SolarPanels> panels;
    protected String setupDescription;
    protected String setupName;
    protected Double wireEfficiency;
    protected Double wireLength;

    /**
     * Gets the value of the customerData property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerData }
     *     
     */
    public CustomerData getCustomerData() {
        return customerData;
    }

    /**
     * Sets the value of the customerData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerData }
     *     
     */
    public void setCustomerData(CustomerData value) {
        this.customerData = value;
    }

    /**
     * Gets the value of the inverter property.
     * 
     * @return
     *     possible object is
     *     {@link SolarInverter }
     *     
     */
    public SolarInverter getInverter() {
        return inverter;
    }

    /**
     * Sets the value of the inverter property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolarInverter }
     *     
     */
    public void setInverter(SolarInverter value) {
        this.inverter = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationData }
     *     
     */
    public LocationData getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationData }
     *     
     */
    public void setLocation(LocationData value) {
        this.location = value;
    }

    /**
     * Gets the value of the panels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the panels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPanels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SolarPanels }
     * 
     * 
     */
    public List<SolarPanels> getPanels() {
        if (panels == null) {
            panels = new ArrayList<SolarPanels>();
        }
        return this.panels;
    }

    /**
     * Gets the value of the setupDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetupDescription() {
        return setupDescription;
    }

    /**
     * Sets the value of the setupDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetupDescription(String value) {
        this.setupDescription = value;
    }

    /**
     * Gets the value of the setupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetupName() {
        return setupName;
    }

    /**
     * Sets the value of the setupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetupName(String value) {
        this.setupName = value;
    }

    /**
     * Gets the value of the wireEfficiency property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWireEfficiency() {
        return wireEfficiency;
    }

    /**
     * Sets the value of the wireEfficiency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWireEfficiency(Double value) {
        this.wireEfficiency = value;
    }

    /**
     * Gets the value of the wireLength property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWireLength() {
        return wireLength;
    }

    /**
     * Sets the value of the wireLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWireLength(Double value) {
        this.wireLength = value;
    }

}
