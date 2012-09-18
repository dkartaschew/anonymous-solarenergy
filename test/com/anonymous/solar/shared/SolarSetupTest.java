package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SolarSetupTest {

	private SolarSetup instance;
	
	// Test Data
	private ArrayList<SolarPanels> panels = new ArrayList<SolarPanels>();
	private SolarInverter inverter = new SolarInverter("Inverter", "InverterManufacturer", "AA1234",
			100.0, 0.5, 98.0, 150.0, 300.0, 15);
	private Double wireLength = 25.00;
	private Double wireEfficiency = 100.00;
	
	//private List<Double> locData = new ArrayList<Double>(1.0,2.0);
	//private LocationData locationInformation = new LocationData(25.0, 25.0, "Test", {1.0,2.0,3.0});
	private CustomerData customerData = new CustomerData();
	private String setupName = "SetupName";
	private String setupDescription = "SetupDescription";
	
	private LocationData location = new LocationData();
	
	
	@Before
	public void setUp() throws Exception {
		instance = new SolarSetup();
	}
	
	// setCustomerData
	@Test
	public void testSetCustomerData() {
		instance.setCustomerData(customerData);
		assertTrue(instance.getCustomerData().equals(customerData));
	}

	// setSetupName
	@Test
	public void testSetSetupName() {
		instance.setSetupName(setupName);
		assertTrue(instance.getSetupName().compareTo("SetupName") == 0);
	}

	// setSetupDescription
	@Test
	public void testSetSetupDescription() {
		instance.setSetupDescription(setupDescription);
		assertTrue(instance.getSetupDescription().compareTo("SetupDescription") == 0);
	}

	// setInverter
	@Test
	public void testSetInverter() {
		instance.setInverter(inverter);
		instance.getInverter().equals(inverter);
	}

	// setWireLength
	@Test
	public void testSetWireLength() {
		instance.setWireLength(wireLength);
		instance.getWireLength().equals(wireLength);
	}

	// setWireEfficiency
	@Test
	public void testSetWireEfficiency() {
		instance.setWireEfficiency(wireEfficiency);
		instance.getWireEfficiency().equals(wireEfficiency);
	}
	// getPanels
	@Test
	public void testGetPanels() {
		instance.setSolarPanels(panels);
		assertTrue(instance.getSolarPanels().equals(panels));
	}

	// setLocation
	@Test
	public void testSetLocation() {
		instance.setLocationInformation(location);
		assertTrue(instance.getLocationInformation().equals(location));
	}
	
}
