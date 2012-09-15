package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PanelBreakDownTest {

	private PanelBreakDown breakDown;
	private SolarPanel panel;
	final private Double NORTH = 0.0;
	final private Double EAST = 90.0;
	final private Double SOUTH = 180.0;
	final private Double WEST = 270.0;

	
	@Before
	public void setUp() throws Exception {
		breakDown = new PanelBreakDown();
		panel = new SolarPanel("Empty", "Empty", "Empty", 100.0, 5.0, 100.0, 100.0, 30);
	}
	
	@Test
	public void directionAll25() throws SolarPanelException, SolarPanelsException{
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, EAST, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, SOUTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, WEST, 5.0));
		
		assertTrue(breakDown.direction(), (breakDown.direction().compareTo("North Panels: 25.0%<br />East " + 
				"Panels: 25.0%<br />South Panels: 25.0%<br />West Panels: 25.0%<br />") == 0));
	}
	
	@Test
	public void directionHalfHalfNS() throws SolarPanelException, SolarPanelsException{
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, SOUTH, 5.0));
		
		assertTrue(breakDown.direction(), (breakDown.direction().compareTo("North Panels: 50.0%<br />East " + 
				"Panels: 0.0%<br />South Panels: 50.0%<br />West Panels: 0.0%<br />") == 0));
	}
	
	@Test
	public void directionHalfHalfEW() throws SolarPanelException, SolarPanelsException{
		breakDown.AddPanels(new SolarPanels(panel, 5, EAST, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, WEST, 5.0));
		
		assertTrue(breakDown.direction(), (breakDown.direction().compareTo("North Panels: 0.0%<br />East " + 
				"Panels: 50.0%<br />South Panels: 0.0%<br />West Panels: 50.0%<br />") == 0));
	}
	
	
	
	
	/*
	 * 	@Test
	public void testGetNorthDouble() throws SolarPanelException {
		ArrayList<SolarPanels> panels = new ArrayList<SolarPanels>();
		panels.add(new SolarPanels(panel, 5, NORTH, 5.0));
		panels.add(new SolarPanels(panel, 5, NORTH, 5.0));
		
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		
		assertTrue("UnexpectedData", breakDown.getNorthPanels() == p);
	}
	 */
	
	@Test
	public void testTotalNE() throws SolarPanelException, SolarPanelsException{
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, EAST, 5.0));
		assertTrue("UnexpectedData", breakDown.getTotal() == 10);
	}
	
	@Test
	public void testTotalSW() throws SolarPanelException, SolarPanelsException{
		breakDown.AddPanels(new SolarPanels(panel, 5, SOUTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, WEST, 5.0));
		assertTrue("UnexpectedData", breakDown.getTotal() == 10);
	}
	
	@Test
	public void AddNorthDoubleNotSame() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, EAST, 5.0));
		assertTrue("UnexpectedData", breakDown.getNorth() == 5);
	}
	
	@Test
	public void AddEastDoubleNotSame() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, EAST, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, SOUTH, 5.0));
		assertTrue("UnexpectedData", breakDown.getEast() == 5);
	}
	
	@Test
	public void AddSouthDoubleNotSame() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, SOUTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, WEST, 5.0));
		assertTrue("UnexpectedData", breakDown.getSouth() == 5);
	}
	
	@Test
	public void AddWestDoubleNotSame() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, WEST, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		assertTrue("UnexpectedData", breakDown.getWest() == 5);
	}
	
	@Test
	public void AddNorthDouble() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		assertTrue("UnexpectedData", breakDown.getNorth() == 10);
	}
	
	@Test
	public void AddEastDouble() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, EAST, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, EAST, 5.0));
		assertTrue("UnexpectedData", breakDown.getEast() == 10);
	}
	
	@Test
	public void AddSouthDouble() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, SOUTH, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, SOUTH, 5.0));
		assertTrue("UnexpectedData", breakDown.getSouth() == 10);
	}
	
	@Test
	public void AddWestDouble() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, WEST, 5.0));
		breakDown.AddPanels(new SolarPanels(panel, 5, WEST, 5.0));
		assertTrue("UnexpectedData", breakDown.getWest() == 10);
	}
	
	@Test
	public void AddNorthSingle() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, NORTH, 5.0));
		assertTrue("UnexpectedData", breakDown.getNorth() == 5);
	}
	
	@Test
	public void AddEastSingle() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, EAST, 5.0));
		assertTrue("UnexpectedData", breakDown.getEast() == 5);
	}
	
	@Test
	public void AddSouthSingle() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, SOUTH, 5.0));
		assertTrue("UnexpectedData", breakDown.getSouth() == 5);
	}
	
	@Test
	public void AddWestSingle() throws SolarPanelException, SolarPanelsException {
		breakDown.AddPanels(new SolarPanels(panel, 5, WEST, 5.0));
		assertTrue("UnexpectedData", breakDown.getWest() == 5);
	}

}
