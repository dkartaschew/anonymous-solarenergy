package com.anonymous.solar.shared;

import org.junit.Before;
import org.junit.Test;

import com.anonymous.solar.server.DataStoreUtils;

public class DataStoreTest {

	private SolarPanel instance;
	private DataStoreUtils dsutils;
	
	@Before
	public void setUp() throws SolarPanelException {
		instance = new SolarPanel();
		dsutils = new DataStoreUtils();
	}
	
	/*
	 * Store a solar panel
	 */
	@Test
	public void panelStore() {
		dsutils.storePanel(instance);
		}
	
	/*
	 * Retrieve a solar panel
	 */
	@Test
	public void panelRetrieve() {
		//fail("Not yet implemented");
	}

}
