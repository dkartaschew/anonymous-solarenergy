package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SolarInverterTest {
	
	private final double INITIAL_VALUES = 0.0;
	
	private final String TEST_STRING_VALUE 	= "test";
	private final double TEST_DOUBLE_VALUE 	= 5.0;
	private final int 	 TEST_INTEGER_VALUE = 5;
	
	private SolarInverter inverter;
	
	@Before
	public void setUp() throws Exception {
		inverter = new SolarInverter();
	}
	
	@Test
	public void testInitialState() {
		// Strings
		assertTrue(inverter.getInverterName().isEmpty());
		assertTrue(inverter.getInverterManufacturer().isEmpty());
		assertTrue(inverter.getInverterManufacturerCode().isEmpty());
		
		// Numerics
		assertTrue(inverter.getInverterCost() == INITIAL_VALUES);
		assertTrue(inverter.getInverterEfficiency() == INITIAL_VALUES);
		assertTrue(inverter.getInverterLifeYears() == 0);
		assertTrue(inverter.getInverterLossYear() == INITIAL_VALUES);
		assertTrue(inverter.getInverterRRP() == INITIAL_VALUES);
		assertTrue(inverter.getInverterWattage() == INITIAL_VALUES);
	}
	
	@Test
	public void testToStringInitialState() {
		assertTrue(inverter.toString().compareTo(" - Cost: $0.0 - Life: 0 years - Wattage: 0.0W - Efficiency Loss: 0.0%") == 0);
	}
	
	@Test
	public void testToString() {
		inverter.setInverterName(TEST_STRING_VALUE);
		inverter.setInverterManufacturer(TEST_STRING_VALUE);
		inverter.setInverterManufacturerCode(TEST_STRING_VALUE);
		inverter.setInverterWattage(TEST_DOUBLE_VALUE);
		inverter.setInverterLossYear(TEST_DOUBLE_VALUE);
		inverter.setInverterEfficiency(TEST_DOUBLE_VALUE);
		inverter.setInverterCost(TEST_DOUBLE_VALUE);
		inverter.setInverterRRP(TEST_DOUBLE_VALUE);
		inverter.setInverterLifeYears(TEST_INTEGER_VALUE);
		assertTrue(inverter.toString().compareTo("test - Cost: $5.0 - Life: 5 years - Wattage: 5.0W - Efficiency Loss: 5.0%") == 0);
	}
	
	@Test
	public void testInitialEquals() {
		SolarInverter duplicateInverter = inverter;
		
		assertTrue(inverter.equals(duplicateInverter));
	}
	
	@Test
	public void testNotEquals() {
		SolarInverter duplicateInverter = new SolarInverter();
		duplicateInverter.setInverterName(TEST_STRING_VALUE);
		
		assertFalse(inverter.equals(duplicateInverter));
	}
	
	@Test
	public void testEquals() {
		SolarInverter duplicateInverter = new SolarInverter();
		
		assertTrue(inverter.equals(duplicateInverter));
		
		inverter.setInverterName(TEST_STRING_VALUE);
		assertFalse(inverter.equals(duplicateInverter));
		duplicateInverter.setInverterName(TEST_STRING_VALUE);
		
		assertTrue(inverter.equals(duplicateInverter));
	}
	
	/******************************************************************************
	 * GETTER TESTS
	 * 
	 * Assumption: All Strings are empty by default
	 * 			   All Numerics are 0 (or 0.0) by default
	 ******************************************************************************/
	
	@Test
	public void testGetInverterName() {
		assertTrue(inverter.getInverterName().isEmpty());
	}
	
	@Test
	public void testGetInverterManufacturer() {
		assertTrue(inverter.getInverterManufacturer().isEmpty());
	}
	
	@Test
	public void testGetInverterManufacturerCode() {
		assertTrue(inverter.getInverterManufacturerCode().isEmpty());
	}
	
	@Test
	public void testGetInverterWattage() {
		assertTrue(inverter.getInverterWattage() == INITIAL_VALUES);
	}
	
	@Test
	public void testGetInverterLossYear() {
		assertTrue(inverter.getInverterLossYear() == INITIAL_VALUES);
	}
	
	@Test
	public void testGetInverterEfficiency() {
		assertTrue(inverter.getInverterEfficiency() == INITIAL_VALUES);
	}
	
	@Test
	public void testGetInverterCost() {
		assertTrue(inverter.getInverterCost() == INITIAL_VALUES);
	}
	
	@Test
	public void testGetInverterRRP() {
		assertTrue(inverter.getInverterRRP() == INITIAL_VALUES);
	}
	
	@Test
	public void testGetInverterLifeYears() {
		assertTrue(inverter.getInverterLifeYears() == 0);
	}
	
	/******************************************************************************
	 * SETTER TESTS
	 ******************************************************************************/
	
	@Test
	public void testSetInverterName() {
		inverter.setInverterName(TEST_STRING_VALUE);
		assertTrue(inverter.getInverterName().compareTo(TEST_STRING_VALUE) == 0);
	}
	
	@Test
	public void testSetInverterManufacturer() {
		inverter.setInverterManufacturer(TEST_STRING_VALUE);
		assertTrue(inverter.getInverterManufacturer().compareTo(TEST_STRING_VALUE) == 0);
	}
	
	@Test
	public void testSetInverterManufacturerCode() {
		inverter.setInverterManufacturerCode(TEST_STRING_VALUE);
		assertTrue(inverter.getInverterManufacturerCode().compareTo(TEST_STRING_VALUE) == 0);
	}
	
	@Test
	public void testSetInverterWattage() {
		inverter.setInverterWattage(TEST_DOUBLE_VALUE);
		assertTrue(inverter.getInverterWattage() == TEST_DOUBLE_VALUE);
	}
	
	@Test
	public void testSetInverterLossYear() {
		inverter.setInverterLossYear(TEST_DOUBLE_VALUE);
		assertTrue(inverter.getInverterLossYear() == TEST_DOUBLE_VALUE);
	}
	
	@Test
	public void testSetInverterEfficiency() {
		inverter.setInverterEfficiency(TEST_DOUBLE_VALUE);
		assertTrue(inverter.getInverterEfficiency() == TEST_DOUBLE_VALUE);
	}
	
	@Test
	public void testSetInverterCost() {
		inverter.setInverterCost(TEST_DOUBLE_VALUE);
		assertTrue(inverter.getInverterCost() == TEST_DOUBLE_VALUE);
	}
	
	@Test
	public void testSetInverterRRP() {
		inverter.setInverterRRP(TEST_DOUBLE_VALUE);
		assertTrue(inverter.getInverterRRP() == TEST_DOUBLE_VALUE);
	}
	
	@Test
	public void testSetInverterLifeYears() {
		inverter.setInverterLifeYears(TEST_INTEGER_VALUE);
		assertTrue(inverter.getInverterLifeYears() == TEST_INTEGER_VALUE);
	}
	
}