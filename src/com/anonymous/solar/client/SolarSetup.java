
package com.anonymous.solar.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="locationLatitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="locationLongitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    "locationLatitude",
    "locationLongitude",
    "setupDescription",
    "setupName",
    "wireEfficiency",
    "wireLength"
})
public class SolarSetup {

    protected CustomerData customerData;
    protected SolarInverter inverter;
    protected Double locationLatitude;
    protected Double locationLongitude;
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
     * Gets the value of the locationLatitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLocationLatitude() {
        return locationLatitude;
    }

    /**
     * Sets the value of the locationLatitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLocationLatitude(Double value) {
        this.locationLatitude = value;
    }

    /**
     * Gets the value of the locationLongitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLocationLongitude() {
        return locationLongitude;
    }

    /**
     * Sets the value of the locationLongitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLocationLongitude(Double value) {
        this.locationLongitude = value;
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
