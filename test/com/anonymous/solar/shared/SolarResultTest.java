package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolarResultTest {

	private SolarSetup setupInstance;
	private SolarResult resultInstance;
	private SolarPanel testPanel;
	private SolarInverter testInverter;
	private SolarPanels testPanels;
	
	@Before
	public void setUp() throws SolarResultException, SolarPanelException{
		testPanel = new SolarPanel("Test Panel", "TestCo", "ABC123", 15.0, 2.0, 100.0, 
				200.0, 15);
		testInverter = new SolarInverter("Test Panel", "TestCo", "ABC123", 15.0, 90.0, 2.0, 
				100.0, 200.0, 15);
		testPanels = new SolarPanels(testPanel, 2, 176.54, 50.21);
	}
	
	/*
	 * Test null values in SolarSetup when passed through SolarResult
	 */
	@Test(expected = SolarResultException.class)
	public void nullSolarPanels() throws SolarResultException {
		setupInstance = new SolarSetup(null, testInverter, 0.00, 100.00, 0.00, 0.00);
		setupInstance.setInvertor(testInverter);
		resultInstance = new SolarResult(setupInstance);
	}
	
	@Test(expected = SolarResultException.class)
	public void nullInverter() throws SolarResultException {
		setupInstance = new SolarSetup();
		setupInstance.addPanels(testPanels);
		resultInstance = new SolarResult(setupInstance);
	}
	
	/*
	 * Tests exception is thrown when the panels list is empty
	 */
	@Test(expected = SolarResultException.class)
	public void emptyPanelsArray() throws SolarResultException {
		setupInstance = new SolarSetup();
		setupInstance.setInvertor(testInverter);
		resultInstance = new SolarResult(setupInstance);
	}

}
