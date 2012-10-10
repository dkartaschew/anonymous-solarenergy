package com.anonymous.solar.server;
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
public class SolarCalculator {

	/**
	 * This method calculates all the savings for a SolarSetup and returns a
	 * SolarResult object containing these calculations
	 * 
	 * @param solarSetup the setup to calculate the savings for
	 * @param year the year in which to calculate the yearly savings up too
	 * @return a SolarResult object which contains all the calculated savings in it
	 * @throws SolarResultException if a null or incorrect value is stored in SolarSetup
	 * 								when creating a SolarResult object
	 */
	@WebMethod
	public SolarResult calculateAllResults(SolarSetup solarSetup, int year) {
		SolarResult newSolarResult = null;
		try {
			newSolarResult = new SolarResult(solarSetup);
		} catch (SolarResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newSolarResult = calculateYearlySavingsOverTime(newSolarResult, year);
		newSolarResult = calculateDailySavings(newSolarResult, 1);
		newSolarResult = calculateMonthlySavings(newSolarResult, 1);
		newSolarResult = calculateYearlySavings(newSolarResult, 1);
		
		return newSolarResult;
	}
	/**
	 * This method calculates the daily savings for a solar system.
	 * 
	 * @param solarResult - the system that needs it's savings calculated
	 * @param year - the year in which to calculate the yearly savings for
	 * @return the solarResult object with the dailySavings calculation added to it.
	 */
	@WebMethod
	public SolarResult calculateDailySavings(SolarResult solarResult, int year) {
		
		SolarResult newSolarResult = solarResult;
		SolarSetup solarSystem = newSolarResult.getSolarSetup();
		CustomerData customerData = solarSystem.getCustomerData();
		LocationData locationInformation = solarSystem.getLocationInformation();
		double newTariff11Fee = customerData.getTariff11Fee();
		double newFeedInFee = customerData.getFeedInFee();
		
		double sunlightHours = calculateSunlightHours(locationInformation.getLatitude());
		//double sunlightHours = 4.5;
		
		double averageDailySolarGeneration = calculateSystemPowerOutput(solarSystem, 
				sunlightHours, year - 1);
		
		solarResult.setPowerGenerated(averageDailySolarGeneration);
		//increase tariff with 
		for (int i = 0; i < year; i++) {
			newTariff11Fee += newTariff11Fee * customerData.getAnnualTariffIncrease();
			newFeedInFee += newFeedInFee * customerData.getAnnualTariffIncrease();
		}
		
		double replacementGeneration = customerData.getHourlyAverageUsage() * sunlightHours;
		double exportedGeneration = averageDailySolarGeneration - replacementGeneration;
		
		double dailySavings = (replacementGeneration * newTariff11Fee) +
				(exportedGeneration * newFeedInFee);
		
		solarResult.setDailySavings(dailySavings);
		
		return newSolarResult;
	}
	
	/**
	 * This method calculates the monthly savings for a solar system
	 * 
	 * @param solarResult - the system that needs it's savings calculated
	 * @param year - the year in which to calculate the yearly savings for
	 * @return the solarResult object with the monthlySavings calculation added to it.
	 */
	@WebMethod
	public SolarResult calculateMonthlySavings(SolarResult solarResult, int year) {
		SolarResult newSolarResult = solarResult;
		
		if (newSolarResult.getDailySavings() == 0.0) {
			newSolarResult = calculateDailySavings(newSolarResult, year);
		}
		
		double monthlySavings = 30 * newSolarResult.getDailySavings();
		newSolarResult.setMonthlySavings(monthlySavings);
		
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
		SolarSetup solarSetup = solarResult.getSolarSetup();
		
		newSolarResult = calculateDailySavings(newSolarResult, year);
		
		double yearlySavings = 365 * newSolarResult.getDailySavings();
		
		ArrayList<SolarPanels> solarPanelBanksList = solarSetup.getSolarPanels();
		double additionalCosts = 0.0;
		//Calculate additional costs
		for(int i = 0; i < solarPanelBanksList.size(); i++) {
			SolarPanels currentSolarBank = solarPanelBanksList.get(i);
			SolarPanel panelType = currentSolarBank.getPanelType();
			
			additionalCosts += (year / panelType.getPanelLifeYears()) *
					(currentSolarBank.getPanelCount() * panelType.getPanelRRP());
			
		}
		//do not need to check year using if statement because integer division will make
		//it 0 if below the lifetime of device
		additionalCosts += (year / solarSetup.getInverter().getInverterLifeYears()) * 
				solarSetup.getInverter().getInverterRRP();
		
		yearlySavings = yearlySavings - additionalCosts;
		
		newSolarResult.setYearlySavings(yearlySavings);
		
		return newSolarResult;
	}
	
	/**
	 * This method calculates the yearly savings over the period of time given and gives the results
	 * for each individual year. It also calculates the powerGenerated by the system each year.
	 * 
	 * @param solarResult - the system that needs it's savings calculated
	 * @param year - the value to calculate the yearly savings over time up to.
	 * @return an ArrayList<Double> that contains the yearlysavings for each year up to the given
	 * 		   year
	 * 		   and an ArrayList<Double> that contains the power generated each year up to the
	 * 		   given year
	 */
	@WebMethod
	public SolarResult calculateYearlySavingsOverTime(SolarResult solarResult, int year) {
		SolarResult newSolarResult = solarResult;
		ArrayList<Double> yearlySavingsOverTime = new ArrayList<Double>();
		ArrayList<Double> powerGeneratedOverTime = new ArrayList<Double>();
		ArrayList<Double> monthlyPowerOverYears = new ArrayList<Double>();
		
		for (int i = 0; i < year; i++) {
			SolarResult yearlyResults = calculateYearlySavings(newSolarResult, i);
			double yearlySavings = yearlyResults.getYearlySavings();
			yearlySavingsOverTime.add(yearlySavings);
			double powerGenerated = yearlyResults.getPowerGenerated();
			powerGeneratedOverTime.add(powerGenerated);
			
			//need to calculate the power savings in each month of the year
			monthlyPowerOverYears = calculateMonthlyPowerSavingsForYear(newSolarResult, 
					powerGenerated);
			newSolarResult.getMonthlyPowerGeneratedOverYears().addAll(monthlyPowerOverYears);
		}
		
		newSolarResult.setSavingsOverYears(yearlySavingsOverTime);
		newSolarResult.setPowerGeneratedOverYears(powerGeneratedOverTime);
		
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
		
		ArrayList<SolarPanels> solarPanels = solarSystem.getSolarPanels();
		
		for (int i = 0; i < solarPanels.size(); i++) {
			SolarPanels currentSolarBank = solarPanels.get(i);
			solarPanelCosts = solarPanelCosts + (currentSolarBank.getPanelCount() * 
					currentSolarBank.getPanelType().getPanelRRP());
		}
		
		return solarPanelCosts;
	}
	
	/**
	 * This method calculates the average daily power output for a given system.
	 * 
	 * @param solarSystem - the system to calculate the power output for
	 * @param daylightHours - the number of daylight hours at the location of the system
	 * @return the average daily power output of the system
	 */
	private double calculateSystemPowerOutput(SolarSetup solarSystem, double daylightHours, 
			int year) {
		double powerOutput = 0.0;
		//Is the year relative to the lifetime of the panel or inverter
		int relativeYear = 0;
		
		ArrayList<SolarPanels> solarPanelBanksList = solarSystem.getSolarPanels();
		for (int i = 0; i < solarPanelBanksList.size(); i++) {
			SolarPanels currentSolarBank = solarPanelBanksList.get(i);
			SolarPanel panelType = currentSolarBank.getPanelType();
			relativeYear = year % panelType.getPanelLifeYears();
			
			//Need to account when direction exceeds 180 that the efficiency will start to go up
			//again as 360 degrees == 0 degrees
			if (currentSolarBank.getPanelDirection() <= 180) {
				powerOutput = powerOutput + ((currentSolarBank.getPanelCount() * 
						panelType.getPanelWattage()) * (1 - (currentSolarBank.getPanelDirection()/100)) *
						(1 - (relativeYear * (panelType.getPanelLossYear()/100))));
			} else {
				powerOutput = powerOutput + ((currentSolarBank.getPanelCount() * 
						panelType.getPanelWattage()) * (1 - ((360 - currentSolarBank.getPanelDirection())/100)) *
						(1 - (relativeYear * (panelType.getPanelLossYear()/100))));
			}

		}
		
		//If the power output by panels is higher than the inverters size than the power output
		//should be the same as the max output of the inverter
		if (powerOutput > solarSystem.getInverter().getInverterWattage()) {
			powerOutput = solarSystem.getInverter().getInverterWattage();
		}
		
		relativeYear = year % solarSystem.getInverter().getInverterLifeYears();
		powerOutput = powerOutput * ((solarSystem.getInverter().getInverterEfficiency() / 100) -
				(relativeYear * (solarSystem.getInverter().getInverterLossYear()))) * 
				daylightHours;
		
		return powerOutput;
	}
	
	/**
	 * This method calculates the/ monthly power savings for the given solar system over a year
	 * which is determined by the dailyPowerGeneration passed through which should be calculated
	 * from the year you are looking to calculate.
	 * 
	 * @param solarResult the solarResult to calculate the monthly power generation for
	 * @param year the year in which to calculate the monthly power generation for
	 * @param dailyPowerGeneration the average daily power generation for the system to use for
	 * 		  monthly calculations
	 * @return an ArrayList<Double> that contains the monthly power generation for the year.
	 */
	private ArrayList<Double> calculateMonthlyPowerSavingsForYear(SolarResult solarResult, 
			double dailyPowerGeneration) {
		SolarResult newSolarResult = solarResult;
		ArrayList<Double> monthlyPowerSavings = new ArrayList<Double>();
		
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int startingMonth = cal.get(java.util.Calendar.MONTH);
		
		//for 12 months calculation, this is not a relative to an actual month but just
		//to loop for 12 general months
		for (int i = 0; i < 12; i++) {
			
			double monthlyPowerGeneration = dailyPowerGeneration * 30;
			int actualMonth = (startingMonth + i) % 12;
			double currentLatitude = newSolarResult.getSolarSetup().getLocationInformation().getLatitude();
			//if latitude of location is negative then in southern hemisphere so the seasons are
			//switched
			//winter is may, june july in sourthern hemisphere
			if (actualMonth >= 4 && actualMonth <= 6 && currentLatitude < 0) {
				monthlyPowerGeneration = monthlyPowerGeneration * 0.3;
			}
			//northern hemisphere winter is november, december, january
			else if ((actualMonth == 10 || actualMonth == 11 || actualMonth == 0) && 
					currentLatitude >= 0) {
				monthlyPowerGeneration = monthlyPowerGeneration * 0.3;
			}
			
			monthlyPowerSavings.add(monthlyPowerGeneration);
		}
		
		return monthlyPowerSavings;
	}
	
}
