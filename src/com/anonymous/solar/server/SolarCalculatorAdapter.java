package com.anonymous.solar.server;

import com.anonymous.solar.server.jaxws.*;
import com.anonymous.solar.shared.SolarResult;

/**
 * This class acts as an adapter between the JAX-B POJOs that were generated by wsgen that
 * acts as server methods and the signature of the real business logic methods
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 *
 */
public class SolarCalculatorAdapter {
	
	private SolarCalculator solarCalculator = new SolarCalculator();
	
	public CalculateDailySavingsResponse CalculateDailySavings (CalculateDailySavings request) {
		SolarResult solarResult = request.getArg0();
		int year = request.getArg1();
		SolarResult newSolarResult = solarCalculator.calculateDailySavings(solarResult, year);
		
		CalculateDailySavingsResponse response = new CalculateDailySavingsResponse();
		response.setReturn(newSolarResult);
		return response;
	}
	
	public CalculateYearlySavingsResponse CalculateYearlySavings(CalculateYearlySavings request) {
		SolarResult solarResult = request.getArg0();
		int year = request.getArg1();
		SolarResult newSolarResult = solarCalculator.calculateYearlySavings(solarResult, year);
		
		CalculateYearlySavingsResponse response = new CalculateYearlySavingsResponse();
		response.setReturn(newSolarResult);
		return response;
	}
	
	public CalculateYearlySavingsOverTimeResponse CalculateYearlySavingsOverTime(
			CalculateYearlySavingsOverTime request) {
		SolarResult solarResult = request.getArg0();
		int year = request.getArg1();
		SolarResult newSolarResult = solarCalculator.calculateYearlySavingsOverTime(solarResult, 
				year);
		
		CalculateYearlySavingsOverTimeResponse response = new 
				CalculateYearlySavingsOverTimeResponse();
		response.setReturn(newSolarResult);
		return response;
	}

}
