package com.anonymous.solar.shared;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.anonymous.solar.shared.*;


/**
 * 
 * This class will calculate the required results for a solarResult class and return it.
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 *
 */
@WebService
public class SolarCalculatorLocal {

	/**
	 * This method calculates the daily savings for a solar system.
	 * 
	 * @param solarResult the system that needs it's savings calculated
	 * @return the solarResult object with the dailySavings calculation added to it.
	 */
@WebMethod
public SolarResult calculateDailySavings(SolarResult solarResult, int year) {
	
	SolarResult newSolarResult = solarResult;
	SolarSetup solarSystem = newSolarResult.getSolarSetup();
	CustomerData customerData = solarSystem.getCustomerData();
	//double sunlightHours = calculateSunlightHours(solarSystem.getLocationLatitude());
	double sunlightHours = 4.5;
	
	double averageDailySolarGeneration = calculateSystemPowerOutput(solarSystem, sunlightHours, 
			year - 1);
	
	double replacementGeneration = customerData.getHourlyAverageUsage() * sunlightHours;
	double exportedGeneration = averageDailySolarGeneration - replacementGeneration;
	
	double dailySavings = (replacementGeneration * customerData.getTariff11Fee()) +
			(exportedGeneration * customerData.getFeedInFee());
	
	solarResult.setDailySavings(dailySavings);
	
	return newSolarResult;
}

/**
 * This method returns the yearly savings for a solar system.
 * 
 * @param solarResult - the system that needs it's savings calculated
 * @param year - the year in which to calculate the yearly savings for
 * @return the solarResult object with the yearlySavings calculation added to it.
 */
@WebMethod
public SolarResult calculateYearlySavings(SolarResult solarResult, int year) {
	SolarResult newSolarResult = solarResult;
	
	if (newSolarResult.getDailySavings() == 0.0) {
		newSolarResult = calculateDailySavings(newSolarResult, year);
	}
	
	double yearlySavings = 365 * newSolarResult.getDailySavings();
	
	newSolarResult.setYearlySavings(yearlySavings);
	
	return newSolarResult;
}

/**
 * This method calculates the yearly savings over the period of time given and gives the results
 * for each individual year.
 * 
 * @param solarResult - the system that needs it's savings calculated
 * @param year - the value to calculate the yearly savings over time up to.
 * @return an ArrayList<Double> that contains the yearlysavings for each year up to the given
 * 		   year
 */
@WebMethod
public SolarResult calculateYearlySavingsOverTime(SolarResult solarResult, int year) {
	SolarResult newSolarResult = solarResult;
	ArrayList<Double> yearlySavingsOverTime = new ArrayList<Double>();
	
	for (int i = 0; i < year; i++) {
		double yearlySavings = calculateYearlySavings(newSolarResult, i).getYearlySavings();
		yearlySavingsOverTime.add(yearlySavings);
	}
	
	newSolarResult.setSavingsOverYears(yearlySavingsOverTime);
	
	return newSolarResult;
}

/**
 * This calculates the number of sunlight hours for a given location. Using the formula
 * given here: 
 * "http://stackoverflow.com/questions/6372802/calculate-daylight-hours-based-on-
 * gegraphical-coordinates"
 * 
 * 
 * @param lat - the latitude location of the area, sunlight hours are to be calculated for.
 * @return the number of sunlight hours in the area
 */
private double calculateSunlightHours(double lat) {
	double sunlightHours = 0.0;
	int dayOfTheYear = 50;
	
	double p = Math.asin(0.3975 * Math.cos(0.2163108 + 2 * Math.atan(0.9671396 *
			Math.tan(0.00860 * (dayOfTheYear-186)))));
	
	sunlightHours = 24 - (24 / Math.PI) * Math.acos((Math.sin(0.8333 * Math.PI /180) +
			Math.sin(lat * Math.PI / 180) * Math.sin(p))/(Math.cos(lat * Math.PI / 180) *
					Math.cos(p)));
	
	return sunlightHours;
}

/**
 * This calculates the total cost of all solar panels that are to be used in the system.
 * 
 * @param solarSystem - the solarSystem that contains the panels that are used in the system
 * @return the total cost of all solar panels in the system
 */
private double calculateSolarPanelCosts(SolarSetup solarSystem) {
	double solarPanelCosts = 0;
	
	ArrayList<SolarPanels> solarPanels = solarSystem.getPanels();
	
	for (int i = 0; i < solarPanels.size(); i++) {
		SolarPanels currentSolarBank = solarPanels.get(i);
		solarPanelCosts = solarPanelCosts + (currentSolarBank.getPanelCount() * 
				currentSolarBank.getPanelType().getPanelRRP());
	}
	
	return solarPanelCosts;
}

/**
 * 
 * This method calculates the average daily power output for a given system.
 * 
 * @param solarSystem - the system to calculate the power output for
 * @param daylightHours - the number of daylight hours at the location of the system
 * @return the average daily power output of the system
 */
private double calculateSystemPowerOutput(SolarSetup solarSystem, double daylightHours, 
		int year) {
	double powerOutput = 0.0;
	
	ArrayList<SolarPanels> solarPanelBanksList = solarSystem.getPanels();
	for (int i = 0; i < solarPanelBanksList.size(); i++) {
		SolarPanels currentSolarBank = solarPanelBanksList.get(i);
		SolarPanel panelType = currentSolarBank.getPanelType();
		powerOutput = powerOutput + ((currentSolarBank.getPanelCount() * 
				panelType.getPanelWattage()) * (1 - (currentSolarBank.getPanelDirection()/100)) *
				(1 - (year * (panelType.getPanelLossYear()/100))));
	}
	
	powerOutput = powerOutput * (solarSystem.getInverter().getInverterEfficiency() / 100) * 
			daylightHours;
	
	return powerOutput;
}
	
}