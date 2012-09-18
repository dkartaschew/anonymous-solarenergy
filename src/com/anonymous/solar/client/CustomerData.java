
package com.anonymous.solar.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annualTariffIncrease" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="dailyAverageUsage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="feedInFee" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="hourlyAverageUsage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="monthlyAverageUsage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariff11Cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariff11Fee" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariff13Cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="tariff13Fee" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerData", propOrder = {
    "annualTariffIncrease",
    "dailyAverageUsage",
    "feedInFee",
    "hourlyAverageUsage",
    "monthlyAverageUsage",
    "tariff11Cost",
    "tariff11Fee",
    "tariff13Cost",
    "tariff13Fee"
})
public class CustomerData {

    protected Double annualTariffIncrease;
    protected Double dailyAverageUsage;
    protected Double feedInFee;
    protected Double hourlyAverageUsage;
    protected Double monthlyAverageUsage;
    protected Double tariff11Cost;
    protected Double tariff11Fee;
    protected Double tariff13Cost;
    protected Double tariff13Fee;

    /**
     * Gets the value of the annualTariffIncrease property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAnnualTariffIncrease() {
        return annualTariffIncrease;
    }

    /**
     * Sets the value of the annualTariffIncrease property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAnnualTariffIncrease(Double value) {
        this.annualTariffIncrease = value;
    }

    /**
     * Gets the value of the dailyAverageUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDailyAverageUsage() {
        return dailyAverageUsage;
    }

    /**
     * Sets the value of the dailyAverageUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDailyAverageUsage(Double value) {
        this.dailyAverageUsage = value;
    }

    /**
     * Gets the value of the feedInFee property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFeedInFee() {
        return feedInFee;
    }

    /**
     * Sets the value of the feedInFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFeedInFee(Double value) {
        this.feedInFee = value;
    }

    /**
     * Gets the value of the hourlyAverageUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getHourlyAverageUsage() {
        return hourlyAverageUsage;
    }

    /**
     * Sets the value of the hourlyAverageUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setHourlyAverageUsage(Double value) {
        this.hourlyAverageUsage = value;
    }

    /**
     * Gets the value of the monthlyAverageUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMonthlyAverageUsage() {
        return monthlyAverageUsage;
    }

    /**
     * Sets the value of the monthlyAverageUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMonthlyAverageUsage(Double value) {
        this.monthlyAverageUsage = value;
    }

    /**
     * Gets the value of the tariff11Cost property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTariff11Cost() {
        return tariff11Cost;
    }

    /**
     * Sets the value of the tariff11Cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTariff11Cost(Double value) {
        this.tariff11Cost = value;
    }

    /**
     * Gets the value of the tariff11Fee property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTariff11Fee() {
        return tariff11Fee;
    }

    /**
     * Sets the value of the tariff11Fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTariff11Fee(Double value) {
        this.tariff11Fee = value;
    }

    /**
     * Gets the value of the tariff13Cost property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTariff13Cost() {
        return tariff13Cost;
    }

    /**
     * Sets the value of the tariff13Cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTariff13Cost(Double value) {
        this.tariff13Cost = value;
    }

    /**
     * Gets the value of the tariff13Fee property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTariff13Fee() {
        return tariff13Fee;
    }

    /**
     * Sets the value of the tariff13Fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTariff13Fee(Double value) {
        this.tariff13Fee = value;
    }

}
