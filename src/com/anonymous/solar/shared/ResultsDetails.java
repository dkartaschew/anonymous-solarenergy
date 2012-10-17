package com.anonymous.solar.shared;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for resultsDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solarResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       	&lt;element name="monthArray" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       	&lt;element name="powerOutputArray" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
 *        &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultsDetails", propOrder = {
    "monthArray",
    "powerOutputArray"
})
/**
 * This class holds the results breakdown for the monthly power output of the solar system
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 *
 */
public class ResultsDetails {

	@XmlElement(nillable = true)
	protected int[] monthArray;
	@XmlElement(nillable = true)
	protected double[] powerOutputArray;
	
	public ResultsDetails() {
		monthArray = new int[12];
		powerOutputArray = new double[12];
	}
	
	public int[] getMonthArray() {
		return monthArray;
	}
	
	public void setMonthArray(int[] newMonthArray) {
		monthArray = newMonthArray;
	}
	
	public double[] getPowerOutputArray() {
		return powerOutputArray;
	}
	
	public void setPowerOutputArray(double[] newPowerOutputArray) {
		powerOutputArray = newPowerOutputArray;
	}
	
	

}
