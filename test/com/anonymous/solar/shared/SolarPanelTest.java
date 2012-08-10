package com.anonymous.solar.shared;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class SolarPanelTest {

	private SolarPanel instance;

	@Before
	public void setUp() throws Exception {
		instance = new SolarPanel();
	}

	/*
	 * Test default state of the object when no parameters are passed to the
	 * constructor.
	 */
	@Test
	public void testSolarPanel() {
		assertTrue("Default Name is \"\"", instance.getPanelName()
				.compareTo("") == 0);
		assertTrue("Default manufacturer is \"\"", instance
				.getPanelManufacturer().compareTo("") == 0);
		assertTrue("Default MCode is \"\"", instance.getPanelManufacturerCode()
				.compareTo("") == 0);
		assertTrue("Default Wattage is \"\"", instance.getPanelWattage()
				.doubleValue() == 0.00);
		assertTrue("Default RRP is \"\"",
				instance.getPanelRRP().doubleValue() == 0.00);
		assertTrue("Default Cost is \"\"", instance.getPanelCost()
				.doubleValue() == 0.00);
		assertTrue("Default Loss is \"\"", instance.getPanelLossYear()
				.doubleValue() == 0.00);
		assertTrue("Default Life is \"\"", instance.getPanelLifeYears()
				.intValue() == 0);
	}

	/*
	 * Test default state of the object when parameters are passed to the
	 * constructor.
	 */
	@Test
	public void testSolarPanelStringStringStringDoubleDoubleDoubleDoubleInteger() {
		try {
			instance = new SolarPanel("Name", "Manufacturer",
					"ManufacturerCode", new Double(1.0), new Double(2.0),
					new Double(3.0), new Double(4.0), new Integer(5));
		} catch (Exception e) {
			fail("Constructor fails with good values.");
		}
		assertTrue("Default Name is \"\"",
				instance.getPanelName().compareTo("Name") == 0);
		assertTrue("Default manufacturer is \"\"", instance
				.getPanelManufacturer().compareTo("Manufacturer") == 0);
		assertTrue("Default MCode is \"\"", instance.getPanelManufacturerCode()
				.compareTo("ManufacturerCode") == 0);
		assertTrue("Default Wattage is \"\"", instance.getPanelWattage()
				.doubleValue() == 1.00);
		assertTrue("Default Loss is \"\"", instance.getPanelLossYear()
				.doubleValue() == 2.00);
		assertTrue("Default Cost is \"\"", instance.getPanelCost()
				.doubleValue() == 3.00);
		assertTrue("Default RRP is \"\"",
				instance.getPanelRRP().doubleValue() == 4.00);
		assertTrue("Default Life is \"\"", instance.getPanelLifeYears()
				.intValue() == 5);
	}

	/*
	 * Test setPanelName() methods
	 */
	@Test
	public void testSetPanelName() throws Exception {
		instance.setPanelName("Name");
		assertTrue("Panel name not set",
				instance.getPanelName().compareTo("Name") == 0);
	}

	@Test
	public void testSetPanelName2() throws Exception {
		instance.setPanelName("Name");
		assertTrue("Panel name not set",
				instance.getPanelName().compareTo("Name") == 0);
		instance.setPanelName("NoName");
		assertTrue("Panel name not set",
				instance.getPanelName().compareTo("NoName") == 0);
	}

	@Test
	public void testSetPanelZeroLengthName() throws Exception {
		instance.setPanelName("Name");
		assertTrue("Panel name not set",
				instance.getPanelName().compareTo("Name") == 0);
		instance.setPanelName("");
		assertTrue("Panel name not set",
				instance.getPanelName().compareTo("") == 0);
	}

	@Test(expected = Exception.class)
	public void testSetPanelNullName() throws Exception {
		instance.setPanelName(null);
	}

	/*
	 * Test set Manufacturer() methods
	 */
	@Test
	public void testSetManufacturerName() throws Exception {
		instance.setPanelManufacturer("Name");
		assertTrue("Panel name not set", instance.getPanelManufacturer()
				.compareTo("Name") == 0);
	}

	@Test
	public void testSetManufacturerName2() throws Exception {
		instance.setPanelManufacturer("Name");
		assertTrue("Panel name not set", instance.getPanelManufacturer()
				.compareTo("Name") == 0);
		instance.setPanelManufacturer("NoName");
		assertTrue("Panel name not set", instance.getPanelManufacturer()
				.compareTo("NoName") == 0);
	}

	@Test
	public void testSetManufacturerZeroLengthName() throws Exception {
		instance.setPanelManufacturer("Name");
		assertTrue("Panel name not set", instance.getPanelManufacturer()
				.compareTo("Name") == 0);
		instance.setPanelManufacturer("");
		assertTrue("Panel name not set", instance.getPanelManufacturer()
				.compareTo("") == 0);
	}

	@Test(expected = Exception.class)
	public void testSetManufacturerNullName() throws Exception {
		instance.setPanelManufacturer(null);
	}

	/*
	 * Test set manufacturer code methods.
	 */
	@Test
	public void testSetManufacturerCodeName() throws Exception {
		instance.setPanelManufacturerCode("Name");
		assertTrue("Panel name not set", instance.getPanelManufacturerCode()
				.compareTo("Name") == 0);
	}

	@Test
	public void testSetManufacturerCodeName2() throws Exception {
		instance.setPanelManufacturerCode("Name");
		assertTrue("Panel name not set", instance.getPanelManufacturerCode()
				.compareTo("Name") == 0);
		instance.setPanelManufacturerCode("NoName");
		assertTrue("Panel name not set", instance.getPanelManufacturerCode()
				.compareTo("NoName") == 0);
	}

	@Test
	public void testSetManufacturerCodeZeroLengthName() throws Exception {
		instance.setPanelManufacturerCode("Name");
		assertTrue("Panel name not set", instance.getPanelManufacturerCode()
				.compareTo("Name") == 0);
		instance.setPanelManufacturerCode("");
		assertTrue("Panel name not set", instance.getPanelManufacturerCode()
				.compareTo("") == 0);
	}

	@Test(expected = Exception.class)
	public void testSetManufacturerCodeNullName() throws Exception {
		instance.setPanelManufacturerCode(null);
	}

	/*
	 * Test set wattage methods.
	 */
	@Test
	public void testSetWattage() throws Exception {
		instance.setPanelWattage(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelWattage()
				.doubleValue() == 1.0);
	}

	@Test
	public void testSetWattage2() throws Exception {
		instance.setPanelWattage(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelWattage()
				.doubleValue() == 1.0);
		instance.setPanelWattage(new Double(3.0));
		assertTrue("Panel name not set", instance.getPanelWattage()
				.doubleValue() == 3.0);
	}

	@Test
	public void testSetWattage3() throws Exception {
		instance.setPanelWattage(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelWattage()
				.doubleValue() == 1.0);
		instance.setPanelWattage(new Double(0.0));
		assertTrue("Panel name not set", instance.getPanelWattage()
				.doubleValue() == 0.0);
	}

	@Test(expected = Exception.class)
	public void testSetWattageNull() throws Exception {
		instance.setPanelWattage(null);
	}

	@Test(expected = Exception.class)
	public void testSetWattageNegative() throws Exception {
		instance.setPanelWattage(new Double(-1.0));
	}

	@Test(expected = Exception.class)
	public void testSetWattageNegative2() throws Exception {
		instance.setPanelWattage(new Double(-0.0000000000000000001));
	}
	
	/*
	 * Test set cost methods.
	 */
	@Test
	public void testSetCost() throws Exception {
		instance.setPanelCost(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelCost()
				.doubleValue() == 1.0);
	}

	@Test
	public void testSetCost2() throws Exception {
		instance.setPanelCost(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelCost()
				.doubleValue() == 1.0);
		instance.setPanelCost(new Double(3.0));
		assertTrue("Panel name not set", instance.getPanelCost()
				.doubleValue() == 3.0);
	}

	@Test
	public void testSetCost3() throws Exception {
		instance.setPanelCost(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelCost()
				.doubleValue() == 1.0);
		instance.setPanelCost(new Double(0.0));
		assertTrue("Panel name not set", instance.getPanelCost()
				.doubleValue() == 0.0);
	}

	@Test(expected = Exception.class)
	public void testSetCostNull() throws Exception {
		instance.setPanelCost(null);
	}

	@Test(expected = Exception.class)
	public void testSetCostNegative() throws Exception {
		instance.setPanelCost(new Double(-1.0));
	}

	@Test(expected = Exception.class)
	public void testSetCostNegative2() throws Exception {
		instance.setPanelCost(new Double(-0.0000000000000000001));
	}
	
	/*
	 * Test set rrp methods.
	 */
	@Test
	public void testSetRRP() throws Exception {
		instance.setPanelRRP(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelRRP()
				.doubleValue() == 1.0);
	}

	@Test
	public void testSetRRP2() throws Exception {
		instance.setPanelRRP(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelRRP()
				.doubleValue() == 1.0);
		instance.setPanelRRP(new Double(3.0));
		assertTrue("Panel name not set", instance.getPanelRRP()
				.doubleValue() == 3.0);
	}

	@Test
	public void testSetRRP3() throws Exception {
		instance.setPanelRRP(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelRRP()
				.doubleValue() == 1.0);
		instance.setPanelRRP(new Double(0.0));
		assertTrue("Panel name not set", instance.getPanelRRP()
				.doubleValue() == 0.0);
	}

	@Test(expected = Exception.class)
	public void testSetRRPNull() throws Exception {
		instance.setPanelRRP(null);
	}

	@Test(expected = Exception.class)
	public void testSetRRPNegative() throws Exception {
		instance.setPanelRRP(new Double(-1.0));
	}

	@Test(expected = Exception.class)
	public void testSetRRPNegative2() throws Exception {
		instance.setPanelRRP(new Double(-0.0000000000000000001));
	}
	
	@Test(expected = Exception.class)
	public void testSetRRPbelowCost() throws Exception {
		instance.setPanelCost(new Double(10));
		instance.setPanelRRP(new Double(9));
	}
	
	@Test
	public void testSetRRPbelowCost2() throws Exception {
		instance.setPanelCost(new Double(1));
		instance.setPanelRRP(new Double(1));
	}
	
	/*
	 * Test set efficiency loss year methods.
	 */
	@Test
	public void testSetLossYear() throws Exception {
		instance.setPanelLossYear(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelLossYear()
				.doubleValue() == 1.0);
	}

	@Test
	public void testSetLossYear2() throws Exception {
		instance.setPanelLossYear(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelLossYear()
				.doubleValue() == 1.0);
		instance.setPanelLossYear(new Double(3.0));
		assertTrue("Panel name not set", instance.getPanelLossYear()
				.doubleValue() == 3.0);
	}

	@Test
	public void testSetLossYear3() throws Exception {
		instance.setPanelLossYear(new Double(1.0));
		assertTrue("Panel name not set", instance.getPanelLossYear()
				.doubleValue() == 1.0);
		instance.setPanelLossYear(new Double(0.0));
		assertTrue("Panel name not set", instance.getPanelLossYear()
				.doubleValue() == 0.0);
	}

	@Test(expected = Exception.class)
	public void testSetLossYearNull() throws Exception {
		instance.setPanelLossYear(null);
	}

	@Test(expected = Exception.class)
	public void testSetLossYearNegative() throws Exception {
		instance.setPanelLossYear(new Double(-1.0));
	}

	@Test(expected = Exception.class)
	public void testSetLossYearNegative2() throws Exception {
		instance.setPanelLossYear(new Double(-0.0000000000000000001));
	}
	
	/*
	 * Test set panel life year methods.
	 */
	@Test
	public void testSetPanelYear() throws Exception {
		instance.setPanelLifeYears(new Integer(1));
		assertTrue("Panel name not set", instance.getPanelLifeYears()
				.doubleValue() == 1.0);
	}

	@Test
	public void testSetPanelYear2() throws Exception {
		instance.setPanelLifeYears(new Integer(1));
		assertTrue("Panel name not set", instance.getPanelLifeYears()
				.doubleValue() == 1.0);
		instance.setPanelLifeYears(new Integer(3));
		assertTrue("Panel name not set", instance.getPanelLifeYears()
				.doubleValue() == 3.0);
	}

	@Test
	public void testSetPanelYear3() throws Exception {
		instance.setPanelLifeYears(new Integer(1));
		assertTrue("Panel name not set", instance.getPanelLifeYears()
				.doubleValue() == 1.0);
		instance.setPanelLifeYears(new Integer(0));
		assertTrue("Panel name not set", instance.getPanelLifeYears()
				.doubleValue() == 0.0);
	}

	@Test(expected = Exception.class)
	public void testSePanelYearNull() throws Exception {
		instance.setPanelLifeYears(null);
	}

	@Test(expected = Exception.class)
	public void testSetPanelYearNegative() throws Exception {
		instance.setPanelLifeYears(new Integer(-1));
	}

}
