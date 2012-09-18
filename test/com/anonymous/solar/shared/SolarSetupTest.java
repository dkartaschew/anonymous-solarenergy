package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import com.anonymous.solar.shared.SolarPanels;

/**
 * Test Class for SolarSetup.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class SolarSetupTest {

	private SolarSetup instance;

	// Test Data
	private ArrayList<SolarPanels> panels = new ArrayList<SolarPanels>();
	private SolarInverter inverter = new SolarInverter("Inverter", "InverterManufacturer", "AA1234", 100.0, 0.5, 98.0,
			150.0, 300.0, 15);
	private Double wireLength = 25.00;
	private Double wireEfficiency = 100.00;

	// private List<Double> locData = new ArrayList<Double>(1.0,2.0);
	// private LocationData locationInformation = new LocationData(25.0, 25.0,
	// "Test", {1.0,2.0,3.0});
	private CustomerData customerData = new CustomerData();
	private String setupName = "SetupName";
	private String setupDescription = "SetupDescription";
	private LocationData location = new LocationData();

	@Before
	public void setUp() throws Exception {
		instance = new SolarSetup();
	}

	/**
	 * Ensure configuration of default setup is valid. (name)
	 */
	@Test
	public final void testSolarSetupName() {
		assertTrue("Default Solar Name is valid", instance.getSetupName() == null);
	}

	/**
	 * Ensure configuration of default setup is valid. (description)
	 */
	@Test
	public final void testSolarSetupDescription() {
		assertTrue("Default Description is valid", instance.getSetupDescription() == null);
	}

	/**
	 * Ensure configuration of default setup is valid. (wirelength)
	 */
	@Test
	public final void testSolarSetupLength() {
		assertTrue("Default wire length is valid", instance.getWireLength() == null);
	}

	/**
	 * Ensure configuration of default setup is valid. (wireefficiency)
	 */
	@Test
	public final void testSolarSetupEff() {
		assertTrue("Default wire efficiency is valid", instance.getWireEfficiency() == null);
	}

	/**
	 * Ensure configuration of default setup is valid. (customer)
	 */
	@Test
	public final void testSolarSetupCustomer() {
		assertTrue("Default customer information is valid", instance.getCustomerData().getClass() == CustomerData.class);
	}

	/**
	 * Ensure configuration of default setup is valid. (inverter)
	 */
	@Test
	public final void testSolarSetupInverter() {
		assertTrue("Default Solar Inverter is valid", instance.getInverter() == null);
	}

	/**
	 * Ensure configuration of default setup is valid. (panels)
	 */
	@Test
	public final void testSolarSetupPanels() {
		assertTrue("Default Solar Panels is valid", instance.getSolarPanels() != null);
	}

	/**
	 * Ensure configuration of default setup is valid. (panels)
	 */
	@Test
	public final void testSolarSetupPanels2() {
		assertTrue("Default Solar Panels count is valid", instance.getSolarPanels().size() == 0);
	}

	/**
	 * Ensure configuration of default setup is valid. (panels)
	 */
	@Test
	public final void testSolarSetupLocation() {
		assertTrue("Default Solar Panels count is valid", instance.getLocationInformation() == null);
	}

	/**
	 * test default constructor.
	 * 
	 * @throws SolarSetupException
	 */
	@Test
	public final void testSolarSetupConstructor() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), inverter, 0.00, 0.00, new LocationData(),
				new CustomerData(), "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. null panels
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor2() throws SolarSetupException {
		instance = new SolarSetup(null, new SolarInverter(), 0.00, 0.00, new LocationData(), new CustomerData(),
				"Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. null inverter
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor3() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), null, 0.00, 0.00, new LocationData(),
				new CustomerData(), "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. null length
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor4() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), null, 0.00, new LocationData(),
				new CustomerData(), "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. negative length
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor5() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), -10.00, 0.00, new LocationData(),
				new CustomerData(), "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. null efficiency
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor6() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), 0.00, null, new LocationData(),
				new CustomerData(), "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. negative efficiency
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor7() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), 0.00, -10.00, new LocationData(),
				new CustomerData(), "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. null location
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor8() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), 0.00, 0.00, null,
				new CustomerData(), "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. null customer
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor9() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), 0.00, 0.00, new LocationData(),
				null, "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. null name
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor10() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), 0.00, 0.00, new LocationData(),
				new CustomerData(), null, "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. zero length name
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor11() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), 0.00, 0.00, new LocationData(),
				new CustomerData(), "", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * test default constructor. null description
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public final void testSolarSetupConstructor12() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), 0.00, 0.00, new LocationData(),
				new CustomerData(), "Test", null);
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}

	/**
	 * Set the customer information.
	 * 
	 * @throws SolarSetupException
	 */
	@Test
	public void testSetCustomerData() throws SolarSetupException {
		instance.setCustomerData(customerData);
		assertTrue(instance.getCustomerData().equals(customerData));
	}

	/**
	 * Set the customer information.
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetCustomerData2() throws SolarSetupException {
		instance.setCustomerData(null);
		assertTrue(instance.getCustomerData().equals(customerData));
	}

	/**
	 * Set the Setupname
	 * 
	 * @throws SolarSetupException
	 */
	@Test
	public void testSetSetupName() throws SolarSetupException {
		instance.setSetupName(setupName);
		assertTrue(instance.getSetupName().compareTo(setupName) == 0);
	}

	/**
	 * Set the Setupname
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetSetupName2() throws SolarSetupException {
		instance.setSetupName(null);
		assertTrue(instance.getSetupName().compareTo(setupName) == 0);
	}

	/**
	 * Set the Setupname
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetSetupName3() throws SolarSetupException {
		instance.setSetupName("");
		assertTrue(instance.getSetupName().compareTo(setupName) == 0);
	}

	/**
	 * Set the setup description
	 * 
	 * @throws SolarSetupException
	 */
	@Test
	public void testSetSetupDescription() throws SolarSetupException {
		instance.setSetupDescription(setupDescription);
		assertTrue(instance.getSetupDescription().compareTo("SetupDescription") == 0);
	}

	/**
	 * Set the setup description
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetSetupDescription2() throws SolarSetupException {
		instance.setSetupDescription(null);
		assertTrue(instance.getSetupDescription().compareTo("SetupDescription") == 0);
	}

	/**
	 * Set the setup description
	 * 
	 * @throws SolarSetupException
	 */
	@Test
	public void testSetSetupDescription3() throws SolarSetupException {
		instance.setSetupDescription("");
		assertTrue(instance.getSetupDescription().compareTo("") == 0);
	}

	/**
	 * Set the inverter
	 * 
	 * @throws SolarSetupException
	 */
	@Test
	public void testSetInverter() throws SolarSetupException {
		instance.setInverter(inverter);
		instance.getInverter().equals(inverter);
	}

	/**
	 * Set the inverter
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetInverter2() throws SolarSetupException {
		instance.setInverter(null);
		instance.getInverter().equals(inverter);
	}

	/**
	 * Set the wire length
	 * 
	 * @throws SolarSetupException
	 */
	@Test
	public void testSetWireLength() throws SolarSetupException {
		instance.setWireLength(wireLength);
		instance.getWireLength().equals(wireLength);
	}

	/**
	 * Set the wire length
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetWireLength2() throws SolarSetupException {
		instance.setWireLength(null);
		instance.getWireLength().equals(wireLength);
	}

	/**
	 * Set the wire length
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetWireLength3() throws SolarSetupException {
		instance.setWireLength(-10.00);
		instance.getWireLength().equals(wireLength);
	}

	/**
	 * Set the wire efficiency
	 * 
	 * @throws SolarSetupException
	 */
	@Test
	public void testSetWireEfficiency() throws SolarSetupException {
		instance.setWireEfficiency(wireEfficiency);
		instance.getWireEfficiency().equals(wireEfficiency);
	}
	
	/**
	 * Set the wire efficiency
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetWireEfficiency2() throws SolarSetupException {
		instance.setWireEfficiency(null);
		instance.getWireEfficiency().equals(wireEfficiency);
	}
	
	/**
	 * Set the wire efficiency
	 * 
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetWireEfficiency3() throws SolarSetupException {
		instance.setWireEfficiency(-10.00);
		instance.getWireEfficiency().equals(wireEfficiency);
	}

	/**
	 * Test setting the panels.
	 * @throws SolarSetupException
	 */
	@Test
	public void testGetPanels() throws SolarSetupException {
		instance.setSolarPanels(panels);
		assertTrue(instance.getSolarPanels().equals(panels));
	}
	
	/**
	 * Test setting the panels.
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testGetPanels2() throws SolarSetupException {
		instance.setSolarPanels(null);
		assertTrue(instance.getSolarPanels().equals(panels));
	}

	/**
	 * Test setting the location
	 * @throws SolarSetupException
	 */
	@Test
	public void testSetLocation() throws SolarSetupException {
		instance.setLocationInformation(location);
		assertTrue(instance.getLocationInformation().equals(location));
	}
	
	/**
	 * Test setting the location
	 * @throws SolarSetupException
	 */
	@Test(expected = SolarSetupException.class)
	public void testSetLocation2() throws SolarSetupException {
		instance.setLocationInformation(null);
		assertTrue(instance.getLocationInformation().equals(location));
	}
}
