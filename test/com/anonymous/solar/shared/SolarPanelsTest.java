package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SolarPanelsTest {
	
	private static String DEFAULT_NAME = "default";
	
	SolarPanels instance;
	SolarPanel panel = new SolarPanel();

	@Before
	public void setUp() throws Exception {
		instance = new SolarPanels();
		panel.setPanelName(DEFAULT_NAME);
	}

	/**
	 * Test default values in the instance configuration. (panel type)
	 */
	@Test
	public void testDefaultSettingsPanelType() {
		assertTrue("default class is SolarPanels", instance.getClass() == SolarPanels.class);
		assertTrue("default panel type is null", instance.getPanelType() == null);
	}
	
	/**
	 * Test default values in the instance configuration. (count)
	 */
	@Test
	public void testDefaultSettingsPanelType2() {
		assertTrue("default panel count is null", instance.getPanelCount() == 0);
	}

	/**
	 * Test default values in the instance configuration. (direction)
	 */
	@Test
	public void testDefaultSettingsPanelType3() {
		assertTrue("default panel count is null", instance.getPanelDirection() == 0.0);
	}

	/**
	 * Test default values in the instance configuration. (azimuth)
	 */
	@Test
	public void testDefaultSettingsPanelType4() {
		assertTrue("default panel count is null", instance.getPanelAzimuth() == 0.0);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testConstructor() throws SolarPanelsException {
		instance = new SolarPanels(panel, 1, 1.00, 1.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor2() throws SolarPanelsException {
		instance = new SolarPanels(null, 1, 1.00, 1.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor3() throws SolarPanelsException {
		instance = new SolarPanels(panel, -1, 1.00, 1.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor4() throws SolarPanelsException {
		instance = new SolarPanels(panel, null, 1.00, 1.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor5() throws SolarPanelsException {
		instance = new SolarPanels(panel, 1, -1.0, 1.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor6() throws SolarPanelsException {
		instance = new SolarPanels(panel, 1, 361.00, 1.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor7() throws SolarPanelsException {
		instance = new SolarPanels(panel, 1, null, 1.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor8() throws SolarPanelsException {
		instance = new SolarPanels(panel, 1, 1.00, -1.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor9() throws SolarPanelsException {
		instance = new SolarPanels(panel, 1, 1.00, 91.00);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}
	
	/**
	 * Test default constructor.
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testConstructor10() throws SolarPanelsException {
		instance = new SolarPanels(panel, 1, 1.00, null);
		assertTrue("default panel type is valid", instance.getPanelType() == panel);
	}

	/****************************************************************************
	 * Set panel information in instance.
	 ****************************************************************************/
	
	/**
	 * Test setting the panel type.
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelType() throws SolarPanelsException {
		instance.setPanelType(panel);
		assertTrue("Panel type set correctly", instance.getPanelType() == panel);
	}
	
	/**
	 * Test setting the panel type to null
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelType2() throws SolarPanelsException {
		instance.setPanelType(null);
		assertTrue("Panel type set correctly", instance.getPanelType() == panel);
	}
	
	/**
	 * Test setting the panel type to null after setting a new panel
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelType3() throws SolarPanelsException {
		instance.setPanelType(panel);
		assertTrue("Panel type set correctly", instance.getPanelType() == panel);
		instance.setPanelType(null);
		assertTrue("Panel type set correctly", instance.getPanelType() == null);
	}
	
	/**
	 * Test setting the panel type to a new panel type
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelType4() throws SolarPanelsException {
		instance.setPanelType(panel);
		assertTrue("Panel type set correctly", instance.getPanelType() == panel);
		SolarPanel panel2 = new SolarPanel();
		instance.setPanelType(panel2);
		assertTrue("Panel type set correctly", instance.getPanelType() == panel2);
	}
	
	/****************************************************************************
	 * Set panel count information in instance.
	 ****************************************************************************/
	
	/**
	 * Test setting the panel count.
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelCount() throws SolarPanelsException {
		instance.setPanelCount(1);
		assertTrue("Panel count set correctly", instance.getPanelCount() == 1);
	}
	
	/**
	 * Test setting the panel count to 0
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelCount2() throws SolarPanelsException {
		instance.setPanelCount(0);
		assertTrue("Panel count set correctly", instance.getPanelCount() == 0);
	}
	
	/**
	 * Test setting the panel count to MAx value
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelCount3() throws SolarPanelsException {
		instance.setPanelCount(Integer.MAX_VALUE);
		assertTrue("Panel count set correctly", instance.getPanelCount() == Integer.MAX_VALUE);
	}
	
	/**
	 * Test setting the panel count to -MIN VALUE
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelCount4() throws SolarPanelsException {
		instance.setPanelCount(Integer.MIN_VALUE);
		assertTrue("Panel count set correctly", instance.getPanelCount() == Integer.MIN_VALUE);
	}
	
	/**
	 * Test setting the panel count to -1
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelCount5() throws SolarPanelsException {
		instance.setPanelCount(-1);
		assertTrue("Panel count set correctly", instance.getPanelCount() == -1);
	}
	
	/**
	 * Test setting the panel count to null
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelCount6() throws SolarPanelsException {
		instance.setPanelCount(null);
		assertTrue("Panel count set correctly", instance.getPanelCount() == null);
	}
	
	/****************************************************************************
	 * Set panel direction information in instance.
	 ****************************************************************************/
	
	/**
	 * Test setting the panel direction.
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelDirection() throws SolarPanelsException {
		instance.setPanelDirection(0.00);
		assertTrue("Panel count set correctly", instance.getPanelDirection() == 0.00);
	}
	
	/**
	 * Test setting the panel direction to 360
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelDirection2() throws SolarPanelsException {
		instance.setPanelDirection(360.00);
		assertTrue("Panel count set correctly", instance.getPanelDirection() == 360.00);
	}
	
	/**
	 * Test setting the panel direction to MAx value
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelDirection3() throws SolarPanelsException {
		instance.setPanelDirection(Double.MAX_VALUE);
		assertTrue("Panel count set correctly", instance.getPanelDirection() == Double.MAX_VALUE);
	}
	
	/**
	 * Test setting the panel direction to -MIN VALUE
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelDirection4() throws SolarPanelsException {
		instance.setPanelDirection(-1 * Double.MAX_VALUE);
		assertTrue("Panel count set correctly", instance.getPanelDirection() == Double.MIN_VALUE);
	}
	
	/**
	 * Test setting the panel direction to -1
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelDirection5() throws SolarPanelsException {
		instance.setPanelDirection(-1.0);
		assertTrue("Panel count set correctly", instance.getPanelDirection() == -1.00);
	}
	
	/**
	 * Test setting the panel direction to 361
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelDirection6() throws SolarPanelsException {
		instance.setPanelDirection(361.00);
		assertTrue("Panel count set correctly", instance.getPanelDirection() == 361.00);
	}
	
	/**
	 * Test setting the panel direction to null
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelDirection7() throws SolarPanelsException {
		instance.setPanelDirection(null);
		assertTrue("Panel count set correctly", instance.getPanelDirection() == null);
	}
	
	/****************************************************************************
	 * Set panel Azimuth information in instance.
	 ****************************************************************************/
	
	/**
	 * Test setting the panel azimuth.
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelAzimuth() throws SolarPanelsException {
		instance.setPanelAzimuth(0.00);
		assertTrue("Panel count set correctly", instance.getPanelAzimuth() == 0.00);
	}
	
	/**
	 * Test setting the azimuth to 90
	 * @throws SolarPanelsException 
	 */
	@Test
	public void testSetPanelAzimuth2() throws SolarPanelsException {
		instance.setPanelAzimuth(90.00);
		assertTrue("Panel count set correctly", instance.getPanelAzimuth() == 90.00);
	}
	
	/**
	 * Test setting the azimuth to MAx value
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelAzimuth3() throws SolarPanelsException {
		instance.setPanelAzimuth(Double.MAX_VALUE);
		assertTrue("Panel count set correctly", instance.getPanelAzimuth() == Double.MAX_VALUE);
	}
	
	/**
	 * Test setting the panel azimuth to -MIN VALUE
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelAzimuth4() throws SolarPanelsException {
		instance.setPanelAzimuth(-1 * Double.MAX_VALUE);
		assertTrue("Panel count set correctly", instance.getPanelAzimuth() == Double.MIN_VALUE);
	}
	
	/**
	 * Test setting the panel azimuth to -1
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelAzimuth5() throws SolarPanelsException {
		instance.setPanelAzimuth(-1.0);
		assertTrue("Panel count set correctly", instance.getPanelAzimuth() == -1.00);
	}
	
	/**
	 * Test setting the panel azimuth to 90.00001
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelAzimuth6() throws SolarPanelsException {
		instance.setPanelAzimuth(90.00001);
		assertTrue("Panel count set correctly", instance.getPanelAzimuth() == 90.00001);
	}
	
	/**
	 * Test setting the panel azimuth to null
	 * @throws SolarPanelsException 
	 */
	@Test(expected = SolarPanelsException.class)
	public void testSetPanelAzimuth7() throws SolarPanelsException {
		instance.setPanelAzimuth(null);
		assertTrue("Panel count set correctly", instance.getPanelAzimuth() == null);
	}
}
