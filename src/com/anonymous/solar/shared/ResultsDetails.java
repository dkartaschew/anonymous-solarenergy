package com.anonymous.solar.shared;

import java.util.ArrayList;
import java.util.List;

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
 *       	&lt;element name="monthID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       	&lt;element name="inverterOutput" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       	&lt;element name="inverterEfficency" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       	&lt;element name="solarBanksOutputList" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
 *       	&lt;element name="solarPowerEfficencyList" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
 *       	&lt;element name="powerGenerated" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       	&lt;element name="income" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       	&lt;element name="ROI" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       	&lt;element name="daylightHours" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       	&lt;element name="inverterReplaced" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       	&lt;element name="banksReplaced" type="{http://server.solar.anonymous.com/}solarPanels" maxOccurs="unbounded" minOccurs="0"/>
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
    "monthID",
    "inverterOutput",
    "inverterEfficiency",
    "solarBanksOutputList",
    "solarBanksEfficencyList",
    "powerGenerated",
    "income",
    "ROI",
    "daylightHours",
    "inverterReplaced",
    "banksReplaced"
})
/**
 * This class holds the results breakdown for the monthly output of the solar system
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 *
 */
public class ResultsDetails {

	protected Integer monthID;
	protected Double inverterOutput;
	protected Double inverterEfficiency;
    @XmlElement(nillable = true)
	protected List<Double> solarBanksOutputList;
    @XmlElement(nillable = true)
	protected List<Double> solarBanksEfficencyList;
	protected Double powerGenerated;
	protected Double income;
	protected Double ROI;
	protected Double daylightHours;
	protected Boolean inverterReplaced;
    @XmlElement(nillable = true)
	protected List<SolarPanels> banksReplaced;
	
	public ResultsDetails() {
		solarBanksOutputList = new ArrayList<Double>();
		solarBanksEfficencyList = new ArrayList<Double>();
		banksReplaced = new ArrayList<SolarPanels>();
		inverterReplaced = false;
	}
	
	/**
	 * This method returns the month the results were for
	 * 
	 * @return an integer representing the month this was calculated in 
	 * 		   (January = 0, December = 11)
	 */
	public int getMonthID() {
		return monthID;
	}
	
	/**
	 * This method set the month the results were for
	 * 
	 * @param newMonthID - the month the results we're calculated for
	 */
	public void setMonthID(int newMonthID) {
		monthID = newMonthID;
	}
	
	/**
	 * This method returns the output of the inverter for the month
	 * 
	 * @return - the wattage output for the inverter
	 */
	public double getinverterOutput() {
		return inverterOutput;
	}
	
	/**
	 * This method sets the output for the inverter for the month
	 * 
	 * @param newInverterOutput - the wattage output for the inverter
	 */
	public void setInverterOutput(double newInverterOutput) {
		inverterOutput = newInverterOutput;
	}

	/**
	 * This method returns the efficiency for the inverter for the month
	 * 
	 * @return a double that represents the current efficiency of the inverter
	 */
	public double getInverterEfficiency() {
		return inverterEfficiency;
	}

	/**
	 * This method set the efficiency for the inverter for the month
	 * 
	 * @param newInverterEfficiency - the current efficiency of the inverter for the month
	 */
	public void setInverterEfficiency(double newInverterEfficiency) {
		inverterEfficiency = newInverterEfficiency;
	}

	/**
	 * This method returns a list that holds the output for each solar bank for
	 * the month
	 * 
	 * @return an ArrayList<Double> that holds the output for each solar bank
	 */
	public ArrayList<Double> getSolarBanksOutputList() {
		return (ArrayList<Double>)solarBanksOutputList;
	}

	/**
	 * This method sets a list that holds the output for each solar bank
	 * 
	 * @param newSolarBanksOutputList - a list that represents the output for each
	 * 								    solar bank
	 */
	public void setSolarBanksOutputList(ArrayList<Double> newSolarBanksOutputList) {
		solarBanksOutputList = newSolarBanksOutputList;
	}

	/**
	 * This method returns the current efficiency of each solar bank.
	 * 
	 * @return an ArrayList<Double> that represents a list with the efficiency
	 * 		   for each solar bank
	 */
	public ArrayList<Double> getSolarBanksEfficencyList() {
		return (ArrayList<Double>)solarBanksEfficencyList;
	}

	/**
	 * This method sets the efficiency list for the solar banks
	 * 
	 * @param newSolarBanksEfficencyList a list that holds the efficiency for each double
	 */
	public void setSolarBanksEfficencyList(ArrayList<Double> newSolarBanksEfficencyList) {
		solarBanksEfficencyList = newSolarBanksEfficencyList;
	}

	/**
	 * This method returns the power generated by the system in the given month
	 * 
	 * @return a double that represents the power generated by the system (KW/H)
	 */
	public double getPowerGenerated() {
		return powerGenerated;
	}

	/**
	 * This method sets the power generated by the system for the month
	 * 
	 * @param newPowerGenerated - the power generated by the system
	 */
	public void setPowerGenerated(double newPowerGenerated) {
		powerGenerated = newPowerGenerated;
	}

	/**
	 * This method sets the income(savings generated) by the system
	 * for the month
	 * 
	 * @return - a double that represents the income for 
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * 
	 * @param newIncome
	 */
	public void setIncome(double newIncome) {
		income = newIncome;
	}

	public double getROI() {
		return ROI;
	}

	public void setROI(double newROI) {
		ROI = newROI;
	}

	public double getDaylightHours() {
		return daylightHours;
	}

	public void setDaylightHours(double newDaylightHours) {
		daylightHours = newDaylightHours;
	}
	
	public boolean getInverterReplaced() {
		return inverterReplaced;
	}
	
	public void setInverterReplaced(boolean isInverterReplaced) {
		inverterReplaced = isInverterReplaced;
	}
	
	public ArrayList<SolarPanels> getBanksReplaced() {
		return (ArrayList<SolarPanels>)banksReplaced;
	}
	
	public void setBanksReplaced(ArrayList<SolarPanels> newBanksReplaced) {
		banksReplaced = newBanksReplaced;
	}
	
	public boolean isBanksReplaced() {
		if (banksReplaced.size() > 0) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	

}
