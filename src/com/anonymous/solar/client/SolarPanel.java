
package com.anonymous.solar.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solarPanel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solarPanel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="INITIAL_VALUES" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="panelCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="panelLifeYears" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="panelLossYear" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="panelManufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="panelManufacturerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="panelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="panelRRP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="panelWattage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solarPanel", propOrder = {
    "initialvalues",
    "key",
    "panelCost",
    "panelLifeYears",
    "panelLossYear",
    "panelManufacturer",
    "panelManufacturerCode",
    "panelName",
    "panelRRP",
    "panelWattage"
})
public class SolarPanel {

    @XmlElement(name = "INITIAL_VALUES")
    protected Double initialvalues;
    protected Long key;
    protected Double panelCost;
    protected Integer panelLifeYears;
    protected Double panelLossYear;
    protected String panelManufacturer;
    protected String panelManufacturerCode;
    protected String panelName;
    protected Double panelRRP;
    protected Double panelWattage;

    /**
     * Gets the value of the initialvalues property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getINITIALVALUES() {
        return initialvalues;
    }

    /**
     * Sets the value of the initialvalues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setINITIALVALUES(Double value) {
        this.initialvalues = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setKey(Long value) {
        this.key = value;
    }

    /**
     * Gets the value of the panelCost property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPanelCost() {
        return panelCost;
    }

    /**
     * Sets the value of the panelCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPanelCost(Double value) {
        this.panelCost = value;
    }

    /**
     * Gets the value of the panelLifeYears property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPanelLifeYears() {
        return panelLifeYears;
    }

    /**
     * Sets the value of the panelLifeYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPanelLifeYears(Integer value) {
        this.panelLifeYears = value;
    }

    /**
     * Gets the value of the panelLossYear property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPanelLossYear() {
        return panelLossYear;
    }

    /**
     * Sets the value of the panelLossYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPanelLossYear(Double value) {
        this.panelLossYear = value;
    }

    /**
     * Gets the value of the panelManufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanelManufacturer() {
        return panelManufacturer;
    }

    /**
     * Sets the value of the panelManufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanelManufacturer(String value) {
        this.panelManufacturer = value;
    }

    /**
     * Gets the value of the panelManufacturerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanelManufacturerCode() {
        return panelManufacturerCode;
    }

    /**
     * Sets the value of the panelManufacturerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanelManufacturerCode(String value) {
        this.panelManufacturerCode = value;
    }

    /**
     * Gets the value of the panelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanelName() {
        return panelName;
    }

    /**
     * Sets the value of the panelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanelName(String value) {
        this.panelName = value;
    }

    /**
     * Gets the value of the panelRRP property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPanelRRP() {
        return panelRRP;
    }

    /**
     * Sets the value of the panelRRP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPanelRRP(Double value) {
        this.panelRRP = value;
    }

    /**
     * Gets the value of the panelWattage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPanelWattage() {
        return panelWattage;
    }

    /**
     * Sets the value of the panelWattage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPanelWattage(Double value) {
        this.panelWattage = value;
    }

}
