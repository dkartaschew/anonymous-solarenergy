
package com.anonymous.solar.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solarInverter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solarInverter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inverterCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inverterEfficiency" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inverterLifeYears" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="inverterLossYear" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inverterManufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inverterManufacturerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inverterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inverterRRP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inverterWattage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solarInverter", propOrder = {
    "inverterCost",
    "inverterEfficiency",
    "inverterLifeYears",
    "inverterLossYear",
    "inverterManufacturer",
    "inverterManufacturerCode",
    "inverterName",
    "inverterRRP",
    "inverterWattage"
})
public class SolarInverter {

    protected Double inverterCost;
    protected Double inverterEfficiency;
    protected Integer inverterLifeYears;
    protected Double inverterLossYear;
    protected String inverterManufacturer;
    protected String inverterManufacturerCode;
    protected String inverterName;
    protected Double inverterRRP;
    protected Double inverterWattage;

    /**
     * Gets the value of the inverterCost property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInverterCost() {
        return inverterCost;
    }

    /**
     * Sets the value of the inverterCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInverterCost(Double value) {
        this.inverterCost = value;
    }

    /**
     * Gets the value of the inverterEfficiency property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInverterEfficiency() {
        return inverterEfficiency;
    }

    /**
     * Sets the value of the inverterEfficiency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInverterEfficiency(Double value) {
        this.inverterEfficiency = value;
    }

    /**
     * Gets the value of the inverterLifeYears property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInverterLifeYears() {
        return inverterLifeYears;
    }

    /**
     * Sets the value of the inverterLifeYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInverterLifeYears(Integer value) {
        this.inverterLifeYears = value;
    }

    /**
     * Gets the value of the inverterLossYear property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInverterLossYear() {
        return inverterLossYear;
    }

    /**
     * Sets the value of the inverterLossYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInverterLossYear(Double value) {
        this.inverterLossYear = value;
    }

    /**
     * Gets the value of the inverterManufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInverterManufacturer() {
        return inverterManufacturer;
    }

    /**
     * Sets the value of the inverterManufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInverterManufacturer(String value) {
        this.inverterManufacturer = value;
    }

    /**
     * Gets the value of the inverterManufacturerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInverterManufacturerCode() {
        return inverterManufacturerCode;
    }

    /**
     * Sets the value of the inverterManufacturerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInverterManufacturerCode(String value) {
        this.inverterManufacturerCode = value;
    }

    /**
     * Gets the value of the inverterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInverterName() {
        return inverterName;
    }

    /**
     * Sets the value of the inverterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInverterName(String value) {
        this.inverterName = value;
    }

    /**
     * Gets the value of the inverterRRP property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInverterRRP() {
        return inverterRRP;
    }

    /**
     * Sets the value of the inverterRRP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInverterRRP(Double value) {
        this.inverterRRP = value;
    }

    /**
     * Gets the value of the inverterWattage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInverterWattage() {
        return inverterWattage;
    }

    /**
     * Sets the value of the inverterWattage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInverterWattage(Double value) {
        this.inverterWattage = value;
    }

}
