package com.anonymous.solar.shared;

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
	private double dailySavings;
	
	public SolarResult(SolarSetup solarSetup) throws SolarResultException {
		SolarSetupExceptionCheck(solarSetup);
		finalSetup = solarSetup;
	}
	
	public SolarSetup getSolarSetup() {
		return finalSetup;
	}
	
	public void setSolarSetup(SolarSetup solarSetup) throws SolarResultException {
		SolarSetupExceptionCheck(solarSetup);
		finalSetup = solarSetup;
	}
	
	private void SolarSetupExceptionCheck(SolarSetup solarSetup) throws SolarResultException {
		if (solarSetup.getInvertor() == null) {
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
