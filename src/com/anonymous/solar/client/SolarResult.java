
package com.anonymous.solar.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solarResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solarResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dailySavings" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="monthlySavings" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="savingsOverYears" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="solarSetup" type="{http://server.solar.anonymous.com/}solarSetup" minOccurs="0"/>
 *         &lt;element name="yearlySavings" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solarResult", propOrder = {
    "dailySavings",
    "monthlySavings",
    "savingsOverYears",
    "solarSetup",
    "yearlySavings"
})
public class SolarResult {

    protected double dailySavings;
    protected double monthlySavings;
    @XmlElement(nillable = true)
    protected List<Double> savingsOverYears;
    protected SolarSetup solarSetup;
    protected double yearlySavings;

    /**
     * Gets the value of the dailySavings property.
     * 
     */
    public double getDailySavings() {
        return dailySavings;
    }

    /**
     * Sets the value of the dailySavings property.
     * 
     */
    public void setDailySavings(double value) {
        this.dailySavings = value;
    }

    /**
     * Gets the value of the monthlySavings property.
     * 
     */
    public double getMonthlySavings() {
        return monthlySavings;
    }

    /**
     * Sets the value of the monthlySavings property.
     * 
     */
    public void setMonthlySavings(double value) {
        this.monthlySavings = value;
    }

    /**
     * Gets the value of the savingsOverYears property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the savingsOverYears property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSavingsOverYears().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getSavingsOverYears() {
        if (savingsOverYears == null) {
            savingsOverYears = new ArrayList<Double>();
        }
        return this.savingsOverYears;
    }

    /**
     * Gets the value of the solarSetup property.
     * 
     * @return
     *     possible object is
     *     {@link SolarSetup }
     *     
     */
    public SolarSetup getSolarSetup() {
        return solarSetup;
    }

    /**
     * Sets the value of the solarSetup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolarSetup }
     *     
     */
    public void setSolarSetup(SolarSetup value) {
        this.solarSetup = value;
    }

    /**
     * Gets the value of the yearlySavings property.
     * 
     */
    public double getYearlySavings() {
        return yearlySavings;
    }

    /**
     * Sets the value of the yearlySavings property.
     * 
     */
    public void setYearlySavings(double value) {
        this.yearlySavings = value;
    }

}
