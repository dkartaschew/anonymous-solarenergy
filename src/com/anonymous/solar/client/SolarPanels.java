
package com.anonymous.solar.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solarPanels complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solarPanels">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="panelAzimuth" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="panelCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="panelDirection" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="panelType" type="{http://server.solar.anonymous.com/}solarPanel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solarPanels", propOrder = {
    "panelAzimuth",
    "panelCount",
    "panelDirection",
    "panelType"
})
public class SolarPanels {

    protected Double panelAzimuth;
    protected Integer panelCount;
    protected Double panelDirection;
    protected SolarPanel panelType;

    /**
     * Gets the value of the panelAzimuth property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPanelAzimuth() {
        return panelAzimuth;
    }

    /**
     * Sets the value of the panelAzimuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPanelAzimuth(Double value) {
        this.panelAzimuth = value;
    }

    /**
     * Gets the value of the panelCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPanelCount() {
        return panelCount;
    }

    /**
     * Sets the value of the panelCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPanelCount(Integer value) {
        this.panelCount = value;
    }

    /**
     * Gets the value of the panelDirection property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPanelDirection() {
        return panelDirection;
    }

    /**
     * Sets the value of the panelDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPanelDirection(Double value) {
        this.panelDirection = value;
    }

    /**
     * Gets the value of the panelType property.
     * 
     * @return
     *     possible object is
     *     {@link SolarPanel }
     *     
     */
    public SolarPanel getPanelType() {
        return panelType;
    }

    /**
     * Sets the value of the panelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolarPanel }
     *     
     */
    public void setPanelType(SolarPanel value) {
        this.panelType = value;
    }

}
