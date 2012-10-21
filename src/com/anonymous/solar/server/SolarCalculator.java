package com.anonymous.solar.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.anonymous.solar.shared.*;

/**
 * 
 * This class will calculate the required results for a solarResult class and
 * return it.
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
	 * @param solarSetup
	 *            the setup to calculate the savings for
	 * @param year
	 *            the year in which to calculate the yearly savings up too
	 * @return a SolarResult object which contains all the calculated savings in
	 *         it
	 * @throws SolarResultException
	 *             if a null or incorrect value is stored in SolarSetup when
	 *             creating a SolarResult object
	 */
	@WebMethod
	public SolarResult calculateAllResults(SolarSetup solarSetup, int year) {
		if (solarSetup == null) {
			return new SolarResult();
		}
		SolarResult newSolarResult = null;
		try {
			newSolarResult = new SolarResult(solarSetup);
		} catch (SolarResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (newSolarResult == null) {
			return new SolarResult();
		}
		try {
			if (newSolarResult.getSolarSetup() == null) {
				return new SolarResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		SolarSetup solarSystem = newSolarResult.getSolarSetup();
		CustomerData customerData = solarSystem.getCustomerData();
		LocationData locationInformation = solarSystem.getLocationInformation();
		ArrayList<ResultsDetails> monthlySystemResults = new ArrayList<ResultsDetails>();
		double newTariff11Fee = customerData.getTariff11Fee();
		double newFeedInFee = customerData.getFeedInFee();

		// get starting month
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int startingMonth = cal.get(java.util.Calendar.MONTH);

		double systemCost = calculateSystemCost(solarSystem);
		newSolarResult.setInitialSystemCost(systemCost);

		for (int i = 0; i < year; i++) {
			// update tariff fees for current year
			// don't update tariff fees in first year
			if (i > 0) {
				newTariff11Fee += newTariff11Fee * customerData.getAnnualTariffIncrease();
				newFeedInFee += newFeedInFee * customerData.getAnnualTariffIncrease();
			}
			// calculations for each month
			for (int j = 0; j < 12; j++) {
				ResultsDetails currentMonthDetails = new ResultsDetails();

				// get current month we're in
				int currentMonth = (startingMonth + j) % 12;
				currentMonthDetails.setMonthID(currentMonth);

				// calculate daylight hours for month
				int daysInCurrentMonth = daysInMonth(currentMonth);
				double daylightHoursInMonth = daysInCurrentMonth
						* calculateSunlightHours(locationInformation.getLatitude(), getDayInMonth(currentMonth));
				currentMonthDetails.setDaylightHours(daylightHoursInMonth);

				// Calculate hardware efficiencies
				ResultsDetails previousMonthDetails = null;
				if (monthlySystemResults.size() > 0) {
					previousMonthDetails = monthlySystemResults.get(monthlySystemResults.size() - 1);
				}
				currentMonthDetails = calculateHardwareState(currentMonthDetails, previousMonthDetails, i, j,
						solarSetup);

				// Calculate power output
				double powerOutput = calculatePowerOutput(currentMonthDetails, solarSetup, locationInformation);
				currentMonthDetails.setPowerGenerated(powerOutput);

				// Calculate savings
				double income = calculateIncome(currentMonthDetails, newTariff11Fee, newFeedInFee, customerData,
						solarSetup);
				currentMonthDetails.setIncome(income);
				
				currentMonthDetails.setExpectedUtilityBill(calculateBill(currentMonthDetails, newTariff11Fee, newFeedInFee, customerData,
						solarSetup));

				// Calculate ROI (Return on Investment)
				double ROI;
				if (j == 0 && i == 0) {
					ROI = -1 * systemCost;// income - systemCost;
				} else {
					ROI = previousMonthDetails.getROI() + ((customerData.getMonthlyAverageUsage() * newTariff11Fee - currentMonthDetails.getExpectedUtilityBill()));
				}
				currentMonthDetails.setROI(ROI);

				monthlySystemResults.add(currentMonthDetails);
			}
		}

		// Transfer calculations to solarResultObject
		newSolarResult.setResultsDeatilsList(monthlySystemResults);
		newSolarResult.setDateTime(new Date());
		newSolarResult.setID(UUID.randomUUID().getMostSignificantBits());

		// newSolarResult = calculateYearlySavingsOverTime(newSolarResult,
		// year);
		// newSolarResult = calculateDailySavings(newSolarResult, 1);
		// newSolarResult = calculateMonthlySavings(newSolarResult, 1);
		// newSolarResult = calculateYearlySavings(newSolarResult, 1);

		return newSolarResult;
	}



	/**
	 * This method calculates the daily savings for a solar system.
	 * 
	 * @param solarResult
	 *            - the system that needs it's savings calculated
	 * @param year
	 *            - the year in which to calculate the yearly savings for
	 * @return the solarResult object with the dailySavings calculation added to
	 *         it.
	 */
	@WebMethod
	public SolarResult calculateDailySavings(SolarResult solarResult, int year) {

		SolarResult newSolarResult = solarResult;
		/*
		 * SolarSetup solarSystem = newSolarResult.getSolarSetup(); CustomerData
		 * customerData = solarSystem.getCustomerData(); LocationData
		 * locationInformation = solarSystem.getLocationInformation(); double
		 * newTariff11Fee = customerData.getTariff11Fee(); double newFeedInFee =
		 * customerData.getFeedInFee();
		 * 
		 * double sunlightHours =
		 * calculateSunlightHours(locationInformation.getLatitude()); //double
		 * sunlightHours = 4.5;
		 * 
		 * double averageDailySolarGeneration =
		 * calculateSystemPowerOutput(solarSystem, sunlightHours, year - 1);
		 * 
		 * solarResult.setPowerGenerated(averageDailySolarGeneration);
		 * //increase tariff with for (int i = 0; i < year; i++) {
		 * newTariff11Fee += newTariff11Fee *
		 * customerData.getAnnualTariffIncrease(); newFeedInFee += newFeedInFee
		 * * customerData.getAnnualTariffIncrease(); }
		 * 
		 * double replacementGeneration = customerData.getHourlyAverageUsage() *
		 * sunlightHours; double exportedGeneration =
		 * averageDailySolarGeneration - replacementGeneration;
		 * 
		 * double dailySavings = (replacementGeneration * newTariff11Fee) +
		 * (exportedGeneration * newFeedInFee);
		 * 
		 * solarResult.setDailySavings(dailySavings);
		 */
		return newSolarResult;
	}

	/**
	 * This method calculates the monthly savings for a solar system
	 * 
	 * @param solarResult
	 *            - the system that needs it's savings calculated
	 * @param year
	 *            - the year in which to calculate the yearly savings for
	 * @return the solarResult object with the monthlySavings calculation added
	 *         to it.
	 */
	@WebMethod
	public SolarResult calculateMonthlySavings(SolarResult solarResult, int year) {
		SolarResult newSolarResult = solarResult;

		/*
		 * if (newSolarResult.getDailySavings() == 0.0) { newSolarResult =
		 * calculateDailySavings(newSolarResult, year); }
		 * 
		 * double monthlySavings = 30 * newSolarResult.getDailySavings();
		 * newSolarResult.setMonthlySavings(monthlySavings);
		 */

		return newSolarResult;
	}

	/**
	 * This method returns the yearly savings for a solar system.
	 * 
	 * @param solarResult
	 *            - the system that needs it's savings calculated
	 * @param year
	 *            - the year in which to calculate the yearly savings for
	 * @return the solarResult object with the yearlySavings calculation added
	 *         to it.
	 */
	@WebMethod
	public SolarResult calculateYearlySavings(SolarResult solarResult, int year) {
		SolarResult newSolarResult = solarResult;
		/*
		 * SolarSetup solarSetup = solarResult.getSolarSetup();
		 * 
		 * newSolarResult = calculateDailySavings(newSolarResult, year);
		 * 
		 * double yearlySavings = 365 * newSolarResult.getDailySavings();
		 * 
		 * ArrayList<SolarPanels> solarPanelBanksList =
		 * solarSetup.getSolarPanels(); double additionalCosts = 0.0;
		 * //Calculate additional costs for(int i = 0; i <
		 * solarPanelBanksList.size(); i++) { SolarPanels currentSolarBank =
		 * solarPanelBanksList.get(i); SolarPanel panelType =
		 * currentSolarBank.getPanelType();
		 * 
		 * additionalCosts += (year / panelType.getPanelLifeYears()) *
		 * (currentSolarBank.getPanelCount() * panelType.getPanelRRP());
		 * 
		 * } //do not need to check year using if statement because integer
		 * division will make //it 0 if below the lifetime of device
		 * additionalCosts += (year /
		 * solarSetup.getInverter().getInverterLifeYears()) *
		 * solarSetup.getInverter().getInverterRRP();
		 * 
		 * yearlySavings = yearlySavings - additionalCosts;
		 * 
		 * newSolarResult.setYearlySavings(yearlySavings);
		 */
		return newSolarResult;
	}

	/**
	 * This method calculates the yearly savings over the period of time given
	 * and gives the results for each individual year. It also calculates the
	 * powerGenerated by the system each year.
	 * 
	 * @param solarResult
	 *            - the system that needs it's savings calculated
	 * @param year
	 *            - the value to calculate the yearly savings over time up to.
	 * @return an ArrayList<Double> that contains the yearlysavings for each
	 *         year up to the given year and an ArrayList<Double> that contains
	 *         the power generated each year up to the given year
	 */
	@WebMethod
	public SolarResult calculateYearlySavingsOverTime(SolarResult solarResult, int year) {
		SolarResult newSolarResult = solarResult;
		/*
		 * ArrayList<Double> yearlySavingsOverTime = new ArrayList<Double>();
		 * ArrayList<Double> powerGeneratedOverTime = new ArrayList<Double>();
		 * ArrayList<Double> monthlyPowerOverYears = new ArrayList<Double>();
		 * 
		 * for (int i = 0; i < year; i++) { SolarResult yearlyResults =
		 * calculateYearlySavings(newSolarResult, i); double yearlySavings =
		 * yearlyResults.getYearlySavings();
		 * yearlySavingsOverTime.add(yearlySavings); double powerGenerated =
		 * yearlyResults.getPowerGenerated();
		 * powerGeneratedOverTime.add(powerGenerated);
		 * 
		 * //need to calculate the power savings in each month of the year
		 * monthlyPowerOverYears =
		 * calculateMonthlyPowerSavingsForYear(newSolarResult, powerGenerated);
		 * newSolarResult
		 * .getMonthlyPowerGeneratedOverYears().addAll(monthlyPowerOverYears); }
		 * 
		 * newSolarResult.setSavingsOverYears(yearlySavingsOverTime);
		 * newSolarResult.setPowerGeneratedOverYears(powerGeneratedOverTime);
		 */
		return newSolarResult;
	}

	/**
	 * This calculates the number of sunlight hours for a given location. Using
	 * the formula given here:
	 * "http://stackoverflow.com/questions/6372802/calculate-daylight-hours-based-
	 * o n - gegraphical-coordinates"
	 * 
	 * 
	 * @param lat
	 *            - the latitude location of the area, sunlight hours are to be
	 *            calculated for.
	 * @return the number of sunlight hours in the area
	 */
	private double calculateSunlightHours(double lat, int dayOfYear) {
		double sunlightHours = 0.0;
		// int dayOfTheYear = 50;

		double p = Math.asin(0.3975 * Math.cos(0.2163108 + 2 * Math.atan(0.9671396 * Math
				.tan(0.00860 * (dayOfYear - 186)))));

		sunlightHours = 24
				- (24 / Math.PI)
				* Math.acos((Math.sin(0.8333 * Math.PI / 180) + Math.sin(lat * Math.PI / 180) * Math.sin(p))
						/ (Math.cos(lat * Math.PI / 180) * Math.cos(p)));

		return Math.abs(sunlightHours);
	}

	/**
	 * This calculates the total cost of all solar panels that are to be used in
	 * the system.
	 * 
	 * @param solarSystem
	 *            - the solarSystem that contains the panels that are used in
	 *            the system
	 * @return the total cost of all solar panels in the system
	 */
	private double calculateSystemCost(SolarSetup solarSystem) {
		double systemCost = 0;

		ArrayList<SolarPanels> solarPanels = solarSystem.getSolarPanels();

		for (int i = 0; i < solarPanels.size(); i++) {
			SolarPanels currentSolarBank = solarPanels.get(i);
			systemCost = systemCost
					+ (currentSolarBank.getPanelCount() * currentSolarBank.getPanelType().getPanelRRP());
		}

		systemCost = systemCost + solarSystem.getInverter().getInverterRRP();

		return systemCost;
	}

	/**
	 * This method calculates the average daily power output for a given system.
	 * 
	 * @param solarSystem
	 *            - the system to calculate the power output for
	 * @param daylightHours
	 *            - the number of daylight hours at the location of the system
	 * @return the average daily power output of the system
	 */
	private double calculateSystemPowerOutput(SolarSetup solarSystem, double daylightHours, int year) {
		double powerOutput = 0.0;
		// Is the year relative to the lifetime of the panel or inverter
		int relativeYear = 0;

		ArrayList<SolarPanels> solarPanelBanksList = solarSystem.getSolarPanels();
		for (int i = 0; i < solarPanelBanksList.size(); i++) {
			SolarPanels currentSolarBank = solarPanelBanksList.get(i);
			SolarPanel panelType = currentSolarBank.getPanelType();
			relativeYear = year % panelType.getPanelLifeYears();

			// Need to account when direction exceeds 180 that the efficiency
			// will start to go up
			// again as 360 degrees == 0 degrees
			if (currentSolarBank.getPanelDirection() <= 180) {
				powerOutput = powerOutput
						+ ((currentSolarBank.getPanelCount() * panelType.getPanelWattage())
								* (1 - (currentSolarBank.getPanelDirection() / 100)) * (1 - (relativeYear * (panelType
								.getPanelLossYear() / 100))));
			} else {
				powerOutput = powerOutput
						+ ((currentSolarBank.getPanelCount() * panelType.getPanelWattage())
								* (1 - ((360 - currentSolarBank.getPanelDirection()) / 100)) * (1 - (relativeYear * (panelType
								.getPanelLossYear() / 100))));
			}

		}

		// If the power output by panels is higher than the inverters size than
		// the power output
		// should be the same as the max output of the inverter
		if (powerOutput > solarSystem.getInverter().getInverterWattage()) {
			powerOutput = solarSystem.getInverter().getInverterWattage();
		}

		relativeYear = year % solarSystem.getInverter().getInverterLifeYears();
		powerOutput = powerOutput
				* ((solarSystem.getInverter().getInverterEfficiency() / 100) - (relativeYear * (solarSystem
						.getInverter().getInverterLossYear()))) * daylightHours;

		return powerOutput;
	}

	/**
	 * This method calculates the/ monthly power savings for the given solar
	 * system over a year which is determined by the dailyPowerGeneration passed
	 * through which should be calculated from the year you are looking to
	 * calculate.
	 * 
	 * @param solarResult
	 *            the solarResult to calculate the monthly power generation for
	 * @param year
	 *            the year in which to calculate the monthly power generation
	 *            for
	 * @param dailyPowerGeneration
	 *            the average daily power generation for the system to use for
	 *            monthly calculations
	 * @return an ArrayList<Double> that contains the monthly power generation
	 *         for the year.
	 */
	private ArrayList<Double> calculateMonthlyPowerSavingsForYear(SolarResult solarResult, double dailyPowerGeneration) {
		SolarResult newSolarResult = solarResult;
		ArrayList<Double> monthlyPowerSavings = new ArrayList<Double>();

		java.util.Calendar cal = java.util.Calendar.getInstance();
		int startingMonth = cal.get(java.util.Calendar.MONTH);

		// for 12 months calculation, this is not a relative to an actual month
		// but just
		// to loop for 12 general months
		for (int i = 0; i < 12; i++) {

			double monthlyPowerGeneration = dailyPowerGeneration * 30;
			int actualMonth = (startingMonth + i) % 12;
			double currentLatitude = newSolarResult.getSolarSetup().getLocationInformation().getLatitude();
			// if latitude of location is negative then in southern hemisphere
			// so the seasons are
			// switched
			// winter is may, june july in sourthern hemisphere
			if (actualMonth >= 4 && actualMonth <= 6 && currentLatitude < 0) {
				monthlyPowerGeneration = monthlyPowerGeneration * 0.3;
			}
			// northern hemisphere winter is november, december, january
			else if ((actualMonth == 10 || actualMonth == 11 || actualMonth == 0) && currentLatitude >= 0) {
				monthlyPowerGeneration = monthlyPowerGeneration * 0.3;
			}

			monthlyPowerSavings.add(monthlyPowerGeneration);
		}

		return monthlyPowerSavings;
	}

	/**
	 * This method returns the number of days in a given month
	 * 
	 * @param month
	 *            the month in which to find the number of days for
	 * @return an integer that represents the number of days in the month given
	 */
	private final static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private int daysInMonth(int month) {
		if (month >= 0 && month < 12) {
			return days[month];
		} else {
			return 0;
		}

		// int numberOfDays = 0;
		//
		// switch (month) {
		// // January
		// case 0:
		// numberOfDays = 31;
		// break;
		// // Feburary
		// case 1:
		// numberOfDays = 28;
		// break;
		// // March
		// case 2:
		// numberOfDays = 31;
		// break;
		// // April
		// case 3:
		// numberOfDays = 30;
		// break;
		// // May
		// case 4:
		// numberOfDays = 31;
		// break;
		// // June
		// case 5:
		// numberOfDays = 30;
		// break;
		// // July
		// case 6:
		// numberOfDays = 31;
		// break;
		// // August
		// case 7:
		// numberOfDays = 31;
		// break;
		// // September
		// case 8:
		// numberOfDays = 30;
		// break;
		// // October
		// case 9:
		// numberOfDays = 31;
		// break;
		// // November
		// case 10:
		// numberOfDays = 30;
		// break;
		// // December
		// case 11:
		// numberOfDays = 31;
		// break;
		// }
		//
		// return numberOfDays;
	}

	/**
	 * This method returns a day located in a given month
	 * 
	 * @param month
	 *            - the month you want to find a day located in
	 * @return an integer that represents a day located in the given month
	 */
	private final static int[] dateMonth = { 1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335 };

	private int getDayInMonth(int month) {

		if (month >= 0 && month < 12) {
			return dateMonth[month];
		} else {
			return 0;
		}

		// int dayInMonth = 0;
		//
		// switch (month) {
		// // January
		// case 0:
		// dayInMonth = 1;
		// break;
		// // Feburary
		// case 1:
		// dayInMonth = 32;
		// break;
		// // March
		// case 2:
		// dayInMonth = 60;
		// break;
		// // April
		// case 3:
		// dayInMonth = 91;
		// break;
		// // May
		// case 4:
		// dayInMonth = 121;
		// break;
		// // June
		// case 5:
		// dayInMonth = 152;
		// break;
		// // July
		// case 6:
		// dayInMonth = 182;
		// break;
		// // August
		// case 7:
		// dayInMonth = 213;
		// break;
		// // September
		// case 8:
		// dayInMonth = 244;
		// break;
		// // October
		// case 9:
		// dayInMonth = 274;
		// break;
		// // November
		// case 10:
		// dayInMonth = 305;
		// break;
		// // December
		// case 11:
		// dayInMonth = 335;
		// break;
		// }
		//
		// return dayInMonth;
	}

	/**
	 * This method calculates the current hardware efficency and optimal power
	 * output within the given year and month.
	 * 
	 * @param currentDetails
	 *            - system breakdown for the current month you're looking at
	 * @param previousMonthDetails
	 *            - system breakdown for the month previously
	 * @param currentYear
	 *            - the year in which to find the hardware state for
	 * @param currentMonth
	 *            - the month in which to find the hardware state for
	 * @param solarSetup
	 *            - the solar setup in which to calculate the hardware state for
	 * @return - returns a ResultsDetails object that is an updated object of
	 *         currentDetails that includes the hardware state of the setup for
	 *         the month
	 */
	private ResultsDetails calculateHardwareState(ResultsDetails currentDetails, ResultsDetails previousMonthDetails,
			int currentYear, int currentMonth, SolarSetup solarSetup) {
		ResultsDetails newResultDetails = currentDetails;

		// calculate current inverter efficency and output

		// at very first month of system no changes occur to the original values
		if (currentMonth == 0 && currentYear == 0) {
			// newResultDetails.setInverterEfficiency(solarSetup.getInverter().getInverterEfficiency());
			newResultDetails.setInverterEfficiency(100.00);
			newResultDetails.setInverterOutput(solarSetup.getInverter().getInverterWattage());

		} else {
			// get previous month efficency then take away loss
			// double currentInverterEfficency =
			// previousMonthDetails.getInverterEfficiency()
			// - (previousMonthDetails.getInverterEfficiency() *
			// (solarSetup.getInverter().getInverterLossYear() / 12));

			// Check if inverter is past it's lifetime or it's efficency is now
			// below 0, when
			// we're at the start of the month for the year
			// if (currentInverterEfficency <= 0
			// || ((currentYear %
			// solarSetup.getInverter().getInverterLifeYears() == 0) &&
			// currentMonth == 0)) {
			// currentInverterEfficency =
			// solarSetup.getInverter().getInverterEfficiency();
			// newResultDetails.setInverterReplaced(true);
			// }
			// double currentInverterOutput =
			// solarSetup.getInverter().getInverterWattage() *
			// (currentInverterEfficency / 100.00); // DK: Add in /100.00 as
			// efficiency is a percentage (eg stored as 99.0 for 99%).
			double currentInverterOutput = previousMonthDetails.getinverterOutput()
					* (solarSetup.getInverter().getInverterLossYear() / 12.00 / 100.00);
			if (currentInverterOutput <= 0
					|| ((currentYear % solarSetup.getInverter().getInverterLifeYears() == 0) && currentMonth == 0)) {
				currentInverterOutput = solarSetup.getInverter().getInverterWattage();
				newResultDetails.setInverterReplaced(true);
			}
			double currentInverterEfficency = currentInverterOutput / solarSetup.getInverter().getInverterWattage()
					* 100.00;

			newResultDetails.setInverterEfficiency(currentInverterEfficency);
			newResultDetails.setInverterOutput(currentInverterOutput);
		}

		// calculate current panelbanks efficiency and output
		ArrayList<Double> currentPanelBanksEfficency = new ArrayList<Double>();
		ArrayList<Double> currentPanelBanksOutput = new ArrayList<Double>();
		ArrayList<SolarPanels> solarBanksReplaced = new ArrayList<SolarPanels>();

		for (int k = 0; k < solarSetup.getSolarPanels().size(); k++) {

			SolarPanels currentSolarBank = solarSetup.getSolarPanels().get(k);
			// set initial 100% efficency values if very first month and
			// intial power output
			if (currentMonth == 0 && currentYear == 0) {
				currentPanelBanksEfficency.add(100.0);

				double bankOutput = currentSolarBank.getPanelCount()
						* currentSolarBank.getPanelType().getPanelWattage();
				currentPanelBanksOutput.add(bankOutput);
			} else {
				// get previous month efficency then take away loss
				// double panelBankEfficency =
				// previousMonthDetails.getSolarBanksEfficencyList().get(k)
				// - (previousMonthDetails.getSolarBanksEfficencyList().get(k) *
				// (currentSolarBank.getPanelType()
				// .getPanelLossYear() / 12));

				// If the efficency is less is 0 or less, or panel is past its
				// life years
				// it will need replaced and the efficency set back to 100%
				// if (panelBankEfficency <= 0
				// || ((currentYear %
				// currentSolarBank.getPanelType().getPanelLifeYears() == 0) &&
				// currentMonth == 0)) {
				// panelBankEfficency = 100.0;
				// solarBanksReplaced.add(currentSolarBank);
				// }

				// double panelBankOutput = (currentSolarBank.getPanelCount() *
				// currentSolarBank.getPanelType()
				// .getPanelWattage()) * (panelBankEfficency / 100.00);

				double panelBankOutput = previousMonthDetails.getSolarBanksOutputList().get(k)
						- (previousMonthDetails.getSolarBanksOutputList().get(k)
								* currentSolarBank.getPanelType().getPanelLossYear() / 100.00);

				if (panelBankOutput <= 0) {
					panelBankOutput = currentSolarBank.getPanelCount()
							* currentSolarBank.getPanelType().getPanelWattage();
					solarBanksReplaced.add(currentSolarBank);
				}
				double panelBankEfficency = panelBankOutput
						/ (currentSolarBank.getPanelCount() * currentSolarBank.getPanelType().getPanelWattage())
						* 100.00;
				currentPanelBanksEfficency.add(panelBankEfficency);
				currentPanelBanksOutput.add(panelBankOutput);
			}
		}

		newResultDetails.setBanksReplaced(solarBanksReplaced);
		newResultDetails.setSolarBanksEfficencyList(currentPanelBanksEfficency);
		newResultDetails.setSolarBanksOutputList(currentPanelBanksOutput);

		return newResultDetails;

	}

	/**
	 * This method calculates the power output for the current month details
	 * given
	 * 
	 * @param currentMonthDetails
	 *            - the month to calculate the power output for
	 * @param solarSetup
	 *            - the setup to calculate the power output for
	 * @param locationData
	 *            - the location data of where the current setup will be located
	 * @return - a double that represents the power that will be produced by the
	 *         system in the given month. (KW/H)
	 */
	private double calculatePowerOutput(ResultsDetails currentMonthDetails, SolarSetup solarSetup,
			LocationData locationData) {
		double powerOutput = 0.0;

		// Set up efficency values for southern hemisphere location
		double northDirectionEfficiency = 1;
		double southDirectionEfficiency = 0.5;
		double eastDirectionEfficiency = 0.75;
		double westDirectionEfficiency = 0.75;
		double winterEffciency = 2 / 3;

		ArrayList<Integer> winterMonths = new ArrayList<Integer>();
		winterMonths.add(4);
		winterMonths.add(5);
		winterMonths.add(6);

		// Check if in northern hemisphere (latitude is positive)
		// if so, change efficiency values
		if (locationData.getLatitude() >= 0) {
			northDirectionEfficiency = 0.5;
			southDirectionEfficiency = 1;
			winterMonths.clear();
			winterMonths.add(10);
			winterMonths.add(11);
			winterMonths.add(0);
		}

		ArrayList<Double> currentSolarBanksOutputList = currentMonthDetails.getSolarBanksOutputList();
		ArrayList<SolarPanels> solarBanksList = solarSetup.getSolarPanels();
		// Calculate power output of each bank with direction of panels into
		// account as
		// well as the current season
		for (int i = 0; i < currentSolarBanksOutputList.size(); i++) {
			SolarPanels currentBank = solarBanksList.get(i);
			// calculate direction of panels and reduce efficency accordinly
			// North
			if (currentBank.getPanelDirection() <= 45 || currentBank.getPanelDirection() > 315) {
				powerOutput = powerOutput + (currentSolarBanksOutputList.get(i) * northDirectionEfficiency);
			}
			// East
			else if (currentBank.getPanelDirection() > 45 && currentBank.getPanelDirection() <= 135) {
				powerOutput = powerOutput + (currentSolarBanksOutputList.get(i) * eastDirectionEfficiency);
			}
			// South
			else if (currentBank.getPanelDirection() > 135 && currentBank.getPanelDirection() <= 225) {
				powerOutput = powerOutput + (currentSolarBanksOutputList.get(i) * southDirectionEfficiency);
			}
			// West
			else {
				powerOutput = powerOutput + (currentSolarBanksOutputList.get(i) * westDirectionEfficiency);
			}
		}

		// Check if it's winter in current location, as panels will be less
		// effective at the
		// time
		if (winterMonths.contains(currentMonthDetails.getMonthID())) {
			powerOutput = powerOutput * winterEffciency;
		}

		// If the solarPanels are producing more power than the inverter can
		// take then
		// the overall power outputted would be equal to inverter output
		if (powerOutput > currentMonthDetails.getinverterOutput()) {
			powerOutput = currentMonthDetails.getinverterOutput();
		}

		// Check for number of cloudy days and take off those day of power
		// output to apply
		// efficency loss
		double numCloudyDays = locationData.getLocationWeatherData().get(currentMonthDetails.getMonthID());
		//double averageDaylightHoursPerDay = currentMonthDetails.getDaylightHours()
		//		/ daysInMonth(currentMonthDetails.getMonthID());

		// Now calculate how much power is produced through the daylight
		// available
		// powerOutput = powerOutput
		// * (averageDaylightHoursPerDay *
		// daysInMonth(currentMonthDetails.getMonthID()) - numCloudyDays);
		//
		// cloudyDaysPowerOutput = powerOutput * (averageDaylightHoursPerDay *
		// numCloudyDays)
		// *
		// locationData.getLocationWeatherEfficiency().get(currentMonthDetails.getMonthID());

		double sunnyDaysPowerOutput = powerOutput * (daysInMonth(currentMonthDetails.getMonthID()) - numCloudyDays)
				/ daysInMonth(currentMonthDetails.getMonthID());
		double cloudyDaysPowerOutput = powerOutput * (numCloudyDays / daysInMonth(currentMonthDetails.getMonthID()))
				* (locationData.getLocationWeatherEfficiency().get(currentMonthDetails.getMonthID()) / 100.00);
		powerOutput = sunnyDaysPowerOutput + cloudyDaysPowerOutput;

		return powerOutput * daysInMonth(currentMonthDetails.getMonthID()) * currentMonthDetails.getDaylightHours() ;
	}

	/**
	 * This method calculates the income for a given month and setup, assuming zero usage (pure feedin).
	 * 
	 * @param currentMonthDetails
	 *            - the month and setup to calculate the income for
	 * @param tariff11Fee
	 *            - the current tariff 11 fee for the setup
	 * @param feedInFee
	 *            - the current feed in fee for the setup
	 * @param customerData
	 *            - an object representing information about customer usage
	 * @param solarSetup
	 *            - the setup that is being used
	 * @return a double that represents the income of the given setup for the
	 *         given month ($)
	 */
	private double calculateIncome(ResultsDetails currentMonthDetails, double tariff11Fee, double feedInFee,
			CustomerData customerData, SolarSetup solarSetup) {
		double income = 0.0;
		double additionalCosts = 0.0;

		//double replacementGeneration = customerData.getMonthlyAverageUsage() * currentMonthDetails.getDaylightHours();
		//double replacementGeneration = customerData.getMonthlyAverageUsage();
		//double exportedGeneration = currentMonthDetails.getPowerGenerated() - replacementGeneration;
		
		income = currentMonthDetails.getPowerGenerated() * feedInFee;

		// Calculate
		if (currentMonthDetails.getInverterReplaced()) {
			additionalCosts += solarSetup.getInverter().getInverterRRP();
		}

		if (currentMonthDetails.isBanksReplaced()) {
			for (int i = 0; i < currentMonthDetails.getBanksReplaced().size(); i++) {
				additionalCosts += currentMonthDetails.getBanksReplaced().get(i).getPanelType().getPanelRRP();
			}
		}

		income = income - additionalCosts;

		return income;
	}
	
	/**
	 * This method calculates the expected utility for a given month and setup. 
	 * (This assumes that we consume what we generate and NOT feed it back into the grid).
	 * 
	 * @param currentMonthDetails
	 *            - the month and setup to calculate the income for
	 * @param tariff11Fee
	 *            - the current tariff 11 fee for the setup
	 * @param feedInFee
	 *            - the current feed in fee for the setup
	 * @param customerData
	 *            - an object representing information about customer usage
	 * @param solarSetup
	 *            - the setup that is being used
	 * @return a double that represents the income of the given setup for the
	 *         given month ($)
	 */
	private Double calculateBill(ResultsDetails currentMonthDetails, double newTariff11Fee, double newFeedInFee,
			CustomerData customerData, SolarSetup solarSetup) {
		
		double usage = (customerData.getMonthlyAverageUsage() - currentMonthDetails.getPowerGenerated());
		double additionalCosts = 0.0;
		
		if (currentMonthDetails.getInverterReplaced()) {
			additionalCosts += solarSetup.getInverter().getInverterRRP();
		}

		if (currentMonthDetails.isBanksReplaced()) {
			for (int i = 0; i < currentMonthDetails.getBanksReplaced().size(); i++) {
				additionalCosts += currentMonthDetails.getBanksReplaced().get(i).getPanelType().getPanelRRP();
			}
		}
		
		if(usage < 0.00){
			// we are generating more than we are using.
			return (usage * newFeedInFee) + additionalCosts;
		} else {
			return (usage * newTariff11Fee) + additionalCosts;
		}
	}

	/**
	 * This method calculates the return on investment for the system
	 * 
	 * @param resultDetailsList
	 *            - a list of the results for all previous months of the system
	 * @param currentMonthDetails
	 *            - the results for the current month
	 * @param initialSystemCost
	 *            - the cost of building the system
	 * @return - a double that represents the return on investment ($)
	 */
	private double calculateROI(ArrayList<ResultsDetails> resultDetailsList, ResultsDetails currentMonthDetails,
			double initialSystemCost) {
		double ROI = 0.0;

		for (int i = 0; i < resultDetailsList.size(); i++) {
			ROI += resultDetailsList.get(i).getIncome();
		}

		ROI += currentMonthDetails.getIncome();

		ROI = ROI - initialSystemCost;

		return ROI;
	}
}
