package com.anonymous.solar.shared;

import java.util.ArrayList;

/**
 * Class to hold the result of the solar output calculation from the server and to handle
 * any additional calculations using that result
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 *
 */
public class SolarResult {

	private SolarSetup finalSetup;
	private double averageDailySavings;
	private double averageYearlySavings;
	private ArrayList<Double> savingsOverYears;
	
	public SolarResult() {
		
	}
	
	public SolarResult(SolarSetup solarSetup) throws SolarResultException {
		SolarSetupExceptionCheck(solarSetup);
		savingsOverYears = new ArrayList<Double>();
		finalSetup = solarSetup;
	}
	
	public SolarSetup getSolarSetup() {
		return finalSetup;
	}
	
	public void setSolarSetup(SolarSetup solarSetup) throws SolarResultException {
		SolarSetupExceptionCheck(solarSetup);
		finalSetup = solarSetup;
	}
	
	public double getDailySavings() {
		return averageDailySavings;
	}
	
	public void setDailySavings(double newDailySavings) {
		averageDailySavings = newDailySavings;
	}
	
	public double getYearlySavings() {
		return averageYearlySavings;
	}
	
	public void setYearlySavings(double newYearlySavings) {
		averageYearlySavings = newYearlySavings;
	}
	
	public ArrayList<Double> getSavingsOverYears() {
		return savingsOverYears;
	}
	
	public void setSavingsOverYears(ArrayList<Double> newSavingsOverYears) {
		savingsOverYears = newSavingsOverYears;
	}
	
	public double getCumulativeSavings(int year) {
		double cumulativeSavings = 0;
		
		for (int i = 0; i < year; i++) {
			cumulativeSavings = cumulativeSavings + savingsOverYears.get(i);
		}
		
		return cumulativeSavings;
	}
	
	private void SolarSetupExceptionCheck(SolarSetup solarSetup) throws SolarResultException {
		if (solarSetup.getInverter() == null) {
			throw new SolarResultException("You cannot have a null inverter");
		}
		if (solarSetup.getPanels() == null) {
			throw new SolarResultException("You cannot have null panels");
		}
		if (solarSetup.getPanels().isEmpty()) {
			throw new SolarResultException("You cannot have an empty array of panels");
		}
	}
	
}
