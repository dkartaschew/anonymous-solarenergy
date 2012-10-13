package com.anonymous.solar.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="powerGenerated" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="powerGeneratedOverYears" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="monthlyPowerGenerated" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="monthlyPowerGeneratedOverYears" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
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
    "yearlySavings",
    "powerGenerated",
    "powerGeneratedOverYears",
    "monthlyPowerGenerated",
    "monthlyPowerGeneratedOverYears"
})
/**
 * Class to hold the result of the solar output calculation from the server and to handle
 * any additional calculations using that result
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 *
 */
@XmlRootElement
public class SolarResult {
	
	protected double dailySavings;
    protected double monthlySavings;
    @XmlElement(nillable = true)
    protected List<Double> savingsOverYears;
    protected SolarSetup solarSetup;
    protected double yearlySavings;
    protected double powerGenerated;
    @XmlElement(nillable = true)
    protected List<Double> powerGeneratedOverYears;
    protected double monthlyPowerGenerated;
    @XmlElement(nillable = true)
    protected List<Double> monthlyPowerGeneratedOverYears;
	
	public SolarResult() {
		savingsOverYears = new ArrayList<Double>();
		dailySavings = 0.0;
		yearlySavings = 0.0;
		monthlyPowerGeneratedOverYears = new ArrayList<Double>();
		powerGeneratedOverYears = new ArrayList<Double>();
	}
	
	public SolarResult(SolarSetup solarSetup) throws SolarResultException {
		SolarSetupExceptionCheck(solarSetup);
		savingsOverYears = new ArrayList<Double>();
		dailySavings = 0.0;
		monthlySavings = 0.0;
		yearlySavings = 0.0;
		this.solarSetup = solarSetup;
		monthlyPowerGeneratedOverYears = new ArrayList<Double>();
		powerGeneratedOverYears = new ArrayList<Double>();
		
	}
	
	/**
	 * This method returns the solarSetup that was used to calculate the results
	 * 
	 * @return a SolarSetup object that contains the current solar setup
	 */
	public SolarSetup getSolarSetup() {
		return solarSetup;
	}
	
	/**
	 * 
	 * @param solarSetup
	 * @throws SolarResultException
	 */
	public void setSolarSetup(SolarSetup solarSetup) throws SolarResultException {
		SolarSetupExceptionCheck(solarSetup);
		this.solarSetup = solarSetup;
	}
	
	/**
	 * This method returns the daily savings of the solar system
	 * 
	 * @return a double that represents the daily savings of the system in dollars
	 */
	public double getDailySavings() {
		return dailySavings;
	}
	
	/**
	 * This methods sets the daily savings of the solar system
	 * 
	 * @param newDailySavings - the daily savings for the solar system in dollars
	 */
	public void setDailySavings(double newDailySavings) {
		dailySavings = newDailySavings;
	}
	
	/**
	 * This methods returns the yearly savings of the solar system
	 * 
	 * @return a double that represents the yearly savings of the system in dollars
	 */
	public double getYearlySavings() {
		return yearlySavings;
	}
	
	/**
	 * This methods sets the daily savings of the solar system
	 * 
	 * @param newDailySavings - the daily savings for the solar system in dollars
	 */
	public void setYearlySavings(double newYearlySavings) {
		yearlySavings = newYearlySavings;
	}
	
	/**
	 * This methods returns the monthly savings of the solar system
	 * 
	 * @return a double that represents the yearly savings of the system in dollars
	 */
	public double getMonthlySavings() {
		return monthlySavings;
	}
	
	/**
	 * This methods sets the daily savings of the solar system
	 * 
	 * @param newDailySavings - the daily savings for the solar system in dollars
	 */
	public void setMonthlySavings(double newMonthlySavings) {
		monthlySavings = newMonthlySavings;
	}
	
	/**
	 * This methods gets the yearly savings over years for the solar system
	 * 
	 * @return an ArrayList<Double> that represents the yearly savings over a certain
	 * 		   number of years for the solar system
	 */
	public ArrayList<Double> getSavingsOverYears() {
		return (ArrayList<Double>) savingsOverYears;
	}
	
	/**
	 * This method sets the yearly savings over years for the solar system
	 * 
	 * @param newSavingsOverYears the yearly savings over years for the solar system
	 */
	public void setSavingsOverYears(ArrayList<Double> newSavingsOverYears) {
		savingsOverYears = newSavingsOverYears;
	}
	
	/**
	 * This method returns the cumulative savings for the solar system up to the year provided
	 * 
	 * @param year the year in which to calculate the savings up to
	 * @return a double value that represents the cumulative savings of the system up to the
	 * 		   given year in dollars.
	 */
	public double getCumulativeSavings(int year) {
		double cumulativeSavings = 0;
		
		for (int i = 0; i < year; i++) {
			cumulativeSavings = cumulativeSavings + savingsOverYears.get(i);
		}
		
		return cumulativeSavings;
	}
	
	/**
	 * This method returns the daily power generation of the system
	 * 
	 * @return a double showing the daily power generation of the system
	 */
	public double getPowerGenerated() {
		return powerGenerated;
	}
	
	/**
	 * This method sets the daily power generation of the system
	 * 
	 * @param newPowerGenerated the amount of power generated on the system on a daily basis
	 */
	public void setPowerGenerated(double newPowerGenerated) {
		powerGenerated = newPowerGenerated;
	}
	
	/**
	 * This method set the power generated over the years by the system
	 * 
	 * @return an ArrayList<Double> that represents the power generation of the system over the
	 * 								years
	 */
	public ArrayList<Double> getPowerGeneratedOverYears() {
		return (ArrayList<Double>) powerGeneratedOverYears;
	}
	
	/**
	 * This method sets the power generated by the system over the years
	 * 
	 * @param newPowerGeneratedOverYears a list of values that represents the power generation
	 * 									 for the system each year.
	 */
	public void setPowerGeneratedOverYears(ArrayList<Double> newPowerGeneratedOverYears) {
		powerGeneratedOverYears = newPowerGeneratedOverYears;
	}
	
	/**
	 * This method returns the monthly power generation of the system given
	 * 
	 * @return the monthly power generation of a system
	 */
	public double getMonthlyPowerGenerated() {
		return monthlyPowerGenerated;
	}
	
	/**
	 * This method sets the monthly power generation of the system given
	 * 
	 * @param newMonthlyPowerGenerated the monthly power generation of the system
	 */
	public void setMonthlyPowerGenerated(double newMonthlyPowerGenerated) {
		monthlyPowerGenerated = newMonthlyPowerGenerated;
	}
	
	/**
	 * This method sets the monthly power generated over the years by the system
	 * 
	 * @return a ArrayList<Double> that contains the monthly power generation of the system
	 * 							   over a certain amount of years
	 */
	public ArrayList<Double> getMonthlyPowerGeneratedOverYears() {
		return (ArrayList<Double>) monthlyPowerGeneratedOverYears;
	}
	
	/**
	 * This method sets the monthly power generated over the years by the system
	 * 
	 * @param newMonthlyPowerGeneratedOverYears the new monthly power generated over the years
	 * 											by the system
	 */
	public void setMonthlyPowerGeneratedOverYears(
			ArrayList<Double> newMonthlyPowerGeneratedOverYears) {
		monthlyPowerGeneratedOverYears = newMonthlyPowerGeneratedOverYears;
	}
	
	/**
	 * This method checks that the solar setup passed is a valid solar setup
	 * 
	 * @param solarSetup the solar setup to calculate the results for
	 * @throws SolarResultException - indicates there is a problem with the solar setup 
	 * 								  being passed
	 */
	private void SolarSetupExceptionCheck(SolarSetup solarSetup) throws SolarResultException {
		if (solarSetup.getInverter() == null) {
			throw new SolarResultException("You cannot have a null inverter");
		}
		if (solarSetup.getSolarPanels() == null) {
			throw new SolarResultException("You cannot have null panels");
		}
		if (solarSetup.getSolarPanels().isEmpty()) {
			throw new SolarResultException("You cannot have an empty array of panels");
		}
	}
	
	@Override
	public String toString() {
		String details = "<html>";
		
		details += "<b>Daily Savings: </b>";
		details += dailySavings + "<br /><br />";
		
		details += "<b>Yearly Savings: </b>";
		details += yearlySavings + "<br /><br />";
		
		details += "</html>";
		return details;
	}
	
}
