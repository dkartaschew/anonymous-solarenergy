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

	SolarSetup instance;
	
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
	
	@Test
	public final void testSolarSetupConstructor() throws SolarSetupException {
		instance = new SolarSetup(new ArrayList<SolarPanels>(), new SolarInverter(), 0.00, 0.00, new LocationData(), new CustomerData(), "Test", "Test");
		assertTrue("Default Solar Name is valid", instance.getSetupName().compareTo("Test") == 0);
	}
	
	

	@Test
	public final void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetCustomerData() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetCustomerData() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetSetupName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetSetupName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetSetupDescription() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetSetupDescription() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetDirectionalPanels() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDetermineInverterLoss() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testLengthUntilInverter() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetInverter() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetInverter() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetWireLength() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetSolarPanels() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetSolarPanels() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetLocationInformation() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetLocationInformation() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetWireLength() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetWireEfficiency() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetWireEfficiency() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAddPanels() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRemovePanels() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetPanels() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testToString1() {
		fail("Not yet implemented"); // TODO
	}

}
