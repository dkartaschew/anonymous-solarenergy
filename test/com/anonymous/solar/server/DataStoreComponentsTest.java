package com.anonymous.solar.server;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.LocationDataException;
import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarInverterException;
import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.SolarPanelException;
import com.anonymous.solar.shared.TariffRate;
import com.anonymous.solar.shared.TariffRateException;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class DataStoreComponentsTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	DataStoreUtils dsutils = new DataStoreUtils();

	@Before
	public void setUp() throws Exception {
		helper.setUp();

	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	/**
	 * Test to ensure we are using a cached copy of the datastore.
	 */
	@Test
	public void testLocationDataEmpty() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean notFound = false;
		try {
			pm.getObjectById(LocationData.class, 1);
			fail("should have raised not found");
		} catch (Exception e) {
			notFound = true;
		} finally {
			pm.close();
		}
		assertTrue(notFound);
	}

	/**
	 * Test basic insertion, to check that no exceptions are thrown.
	 * @throws LocationDataException
	 */
	@Test
	public void testStoreLocationData() throws LocationDataException{
		LocationData location = new LocationData();
		location.setLocationName("Location1");
		dsutils.storeLocationData(location);
	}
	
	/**
	 * Test insertion and retrieval of location data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRetrieveLocationData() throws LocationDataException{
		LocationData location = new LocationData();
		location.setLocationName("Location1");
		dsutils.storeLocationData(location);
		
		List<LocationData> locations = dsutils.getAllLocations();
		
		assertTrue("Number of Locations = 1", locations.size() == 1);
		assertTrue("Single location object is sane", locations.get(0).getLocationName().compareTo("Location1") == 0);
	}
	
	/**
	 * Test insertion and retrival of location data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRetrieveLocationData2() throws LocationDataException{
		LocationData location = new LocationData();
		location.setLocationName("Location1");
		dsutils.storeLocationData(location);
		
		location = new LocationData();
		location.setLocationName("Location2");
		dsutils.storeLocationData(location);
		
		List<LocationData> locations =  dsutils.getAllLocations();
		
		assertTrue("Number of Locations = 2", locations.size() == 2);
		assertTrue("Location 1 correct", locations.get(0).getLocationName().compareTo("Location1") == 0);
		assertTrue("Location 2 correct", locations.get(1).getLocationName().compareTo("Location2") == 0);
	}
	
	/**
	 * Test insertion and removal of location data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRemoveLocationData() throws LocationDataException{
		LocationData location = new LocationData();
		location.setLocationName("Location1");
		dsutils.storeLocationData(location);
		
		LocationData location2 = new LocationData();
		location.setLocationName("Location2");
		dsutils.storeLocationData(location2);
		
		List<LocationData> locations =  dsutils.getAllLocations();
		dsutils.removeLocationData(locations.get(0).getKey());
		
		locations = dsutils.getAllLocations();
		assertTrue("Number of Locations is now 1", locations.size() == 1);
	}
	
	/**
	 * Test insertion and removal of all location data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRemoveLocationData2() throws LocationDataException{
		LocationData location = new LocationData();
		location.setLocationName("Location1");
		dsutils.storeLocationData(location);
		
		LocationData location2 = new LocationData();
		location.setLocationName("Location2");
		dsutils.storeLocationData(location2);
		
		List<LocationData> locations = dsutils.getAllLocations();
		for(LocationData loc: locations){
			dsutils.removeLocationData(loc.getKey());
		}
		
		locations =  dsutils.getAllLocations();
		assertTrue("Number of Locations is now 0", locations.size() == 0);
	}
	
	/********************************************************************************************************
	 ********************************************************************************************************
	 ******************************************* SolarPanel tests *******************************************
	 ********************************************************************************************************/
	
	/**
	 * Test to ensure we are using a cached copy of the datastore.
	 */
	@Test
	public void testPanelDataEmpty(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean notFound = false;
		try {
			//TODO What ID is SolarPanel?
			pm.getObjectById(SolarPanel.class, 1);
			fail("should have raised not found");
		} catch (Exception e) {
			notFound = true;
		} finally {
			pm.close();
		}
		assertTrue(notFound);
	}
	
	/**
	 * Test basic insertion, to check that no exceptions are thrown.
	 * @throws LocationDataException
	 */
	@Test
	public void testStorePanelData() throws SolarPanelException{
		SolarPanel panel = new SolarPanel();
		panel.setPanelName("Panel1");
		dsutils.storePanel(panel);
	}
	
	/**
	 * Test insertion and retrieval of panel data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRetrievePanelData() throws SolarPanelException{
		SolarPanel panel = new SolarPanel();
		panel.setPanelName("Panel1");
		dsutils.storePanel(panel);
		
		List<SolarPanel> panels = dsutils.getAllPanels();
		
		assertTrue("Number of Panels = 1", panels.size() == 1);
		assertTrue("Single panel object is sane", panels.get(0).getPanelName().compareTo("Panel1") == 0);
	}
	
	/**
	 * Test insertion and retrieval of panel data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRetrievePanelData2() throws SolarPanelException{
		SolarPanel panel = new SolarPanel();
		panel.setPanelName("Panel1");
		dsutils.storePanel(panel);
		
		panel = new SolarPanel();
		panel.setPanelName("Panel2");
		dsutils.storePanel(panel);
		
		List<SolarPanel> panels =  dsutils.getAllPanels();
		
		assertTrue("Number of Panels = 2", panels.size() == 2);
		assertTrue("Panel 1 correct", panels.get(0).getPanelName().compareTo("Panel1") == 0);
		assertTrue("Panel 2 correct", panels.get(1).getPanelName().compareTo("Panel2") == 0);
	}
	
	/**
	 * Test insertion and removal of panel data.
	 * @throws SolarPanelException
	 */
	@Test
	public void testRemovePanelData() throws SolarPanelException{
		SolarPanel panel = new SolarPanel();
		panel.setPanelName("Panel1");
		dsutils.storePanel(panel);
		
		SolarPanel panel2 = new SolarPanel();
		panel2.setPanelName("Panel2");
		dsutils.storePanel(panel2);
		
		List<SolarPanel> panels =  dsutils.getAllPanels();
		dsutils.removePanel(panels.get(0).getKey());
		
		panels = dsutils.getAllPanels();
		assertTrue("Number of Panels is now 1", panels.size() == 1);
	}
	
	/**
	 * Test insertion and removal of all location data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRemovePanelData2() throws SolarPanelException{
		SolarPanel panel = new SolarPanel();
		panel.setPanelName("Panel1");
		dsutils.storePanel(panel);
		
		SolarPanel panel2 = new SolarPanel();
		panel2.setPanelName("Panel2");
		dsutils.storePanel(panel2);
		
		List<SolarPanel> panels = dsutils.getAllPanels();
		for(SolarPanel pan: panels){
			dsutils.removePanel(pan.getKey());
		}
		
		panels =  dsutils.getAllPanels();
		assertTrue("Number of Panels is now 0", panels.size() == 0);
	}
	
	/**
	 * Test the retrieval of a single solar panel's information
	 * for the panel named.
	 */
	@Test
	public void testGetPanelInformation() throws SolarPanelException{
		SolarPanel panel = new SolarPanel();
		
		panel.setPanelName("Panel1");
		panel.setPanelLifeYears(25);
		panel.setPanelLossYear(0.2);
		panel.setPanelManufacturer("Panel Co.");
		panel.setPanelManufacturerCode("TEST001");
		panel.setPanelCost(25.5);
		panel.setPanelRRP(30.5);
		panel.setPanelWattage(100.0);
		
		dsutils.storePanel(panel);
		
		SolarPanel testPanel = dsutils.getPanelInformation("Panel1");
		
		assertTrue(testPanel.getPanelName().equals("Panel1"));
		assertTrue(testPanel.getPanelLifeYears() == 25);
		assertTrue(testPanel.getPanelLossYear() == 0.2);
		assertTrue(testPanel.getPanelManufacturer().equals("Panel Co."));
		assertTrue(testPanel.getPanelManufacturerCode().equals("TEST001"));
		assertTrue(testPanel.getPanelCost() == 25.5);
		assertTrue(testPanel.getPanelRRP() == 30.5);
		assertTrue(testPanel.getPanelWattage() == 100.0);
	}
	
	/********************************************************************************************************
	 ********************************************************************************************************
	 ****************************************** SolarInverter test ******************************************
	 ********************************************************************************************************/
	
	/**
	 * Test to ensure we are using a cached copy of the datastore.
	 */
	@Test
	public void testInverterDataEmpty(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean notFound = false;
		try {
			//TODO What ID is SolarInverter?
			pm.getObjectById(SolarInverter.class, 1);
			fail("should have raised not found");
		} catch (Exception e) {
			notFound = true;
		} finally {
			pm.close();
		}
		assertTrue(notFound);
	}
	
	/**
	 * Test basic insertion, to check that no exceptions are thrown.
	 * @throws LocationDataException
	 */
	@Test
	public void testStoreInverterData() throws SolarInverterException{
		SolarInverter inverter = new SolarInverter();
		inverter.setInverterName("Inverter1");
		dsutils.storeInverter(inverter);
	}
	
	/**
	 * Test insertion and retrieval of inverter data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRetrieveInverterData() throws SolarInverterException{
		SolarInverter inverter = new SolarInverter();
		inverter.setInverterName("Inverter1");
		dsutils.storeInverter(inverter);
		
		List<SolarInverter> inverters = dsutils.getAllInverters();
		
		assertTrue("Number of Inverters = 1", inverters.size() == 1);
		assertTrue("Single inverter object is sane", inverters.get(0).getInverterName().compareTo("Inverter1") == 0);
	}
	
	/**
	 * Test insertion and retrieval of inverter data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRetrieveInverterData2() throws SolarInverterException{
		SolarInverter inverter = new SolarInverter();
		inverter.setInverterName("Inverter1");
		dsutils.storeInverter(inverter);
		
		inverter = new SolarInverter();
		inverter.setInverterName("Inverter2");
		dsutils.storeInverter(inverter);
		
		List<SolarInverter> inverters =  dsutils.getAllInverters();
		
		assertTrue("Number of Inverters = 2", inverters.size() == 2);
		assertTrue("Inverter 1 correct", inverters.get(0).getInverterName().compareTo("Inverter1") == 0);
		assertTrue("Inverter 2 correct", inverters.get(1).getInverterName().compareTo("Inverter2") == 0);
	}
	
	/**
	 * Test insertion and removal of inverter data.
	 * @throws SolarInverterException
	 */
	@Test
	public void testRemoveInverterData() throws SolarInverterException{
		SolarInverter inverter = new SolarInverter();
		inverter.setInverterName("Inverter1");
		dsutils.storeInverter(inverter);
		
		SolarInverter inverter2 = new SolarInverter();
		inverter2.setInverterName("Inverter2");
		dsutils.storeInverter(inverter2);
		
		List<SolarInverter> inverters =  dsutils.getAllInverters();
		dsutils.removeInverter(inverters.get(0).getKey());
		
		inverters = dsutils.getAllInverters();
		assertTrue("Number of Inverters is now 1", inverters.size() == 1);
	}
	
	/**
	 * Test insertion and removal of all location data.
	 * @throws LocationDataException
	 */
	@Test
	public void testRemoveInverterData2() throws SolarInverterException{
		SolarInverter inverter = new SolarInverter();
		inverter.setInverterName("Inverter1");
		dsutils.storeInverter(inverter);
		
		SolarInverter inverter2 = new SolarInverter();
		inverter2.setInverterName("Inverter2");
		dsutils.storeInverter(inverter2);
		
		List<SolarInverter> inverters = dsutils.getAllInverters();
		for(SolarInverter inv: inverters){
			dsutils.removeInverter(inv.getKey());
		}
		
		inverters =  dsutils.getAllInverters();
		assertTrue("Number of Inverters is now 0", inverters.size() == 0);
	}
	
	/********************************************************************************************************
	 ********************************************************************************************************
	 ******************************************* TariffRate tests *******************************************
	 ********************************************************************************************************/
	
	/**
	 * Test to ensure we are using a cached copy of the datastore.
	 */
	@Test
	public void testTariffDataEmpty(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean notFound = false;
		try {
			//TODO What ID is TariffRate?
			pm.getObjectById(TariffRate.class, 1);
			fail("should have raised not found");
		} catch (Exception e) {
			notFound = true;
		} finally {
			pm.close();
		}
		assertTrue(notFound);
	}
	
	/**
	 * Test basic insertion, to check that no exceptions are thrown.
	 * @throws TariffRateException 
	 */
	@Test
	public void testStoreTariffData() throws TariffRateException{
		TariffRate rate = new TariffRate();
		rate.setTariffProvider("AAAAA");
		rate.setTariffState("ACT");
		dsutils.storeTariffRate(rate);
	}
	
	/**
	 * Test insertion and retrieval of tariff data.
	 * @throws TariffRateException 
	 */
	@Test
	public void testRetrieveTariffData() throws TariffRateException{
		TariffRate rate = new TariffRate();
		rate.setTariffProvider("AAAAA");
		rate.setTariffState("ACT");
		dsutils.storeTariffRate(rate);
		
		List<TariffRate> tariffs = dsutils.getAllTariffs();
		
		assertTrue("Number of Tariffs = 1", tariffs.size() == 1);
		assertTrue("Single inverter object is sane", tariffs.get(0).getTariffProvider().compareTo("AAAAA") == 0);
	}
	
	/**
	 * Test insertion and retrieval of inverter data.
	 * @throws TariffRateException 
	 */
	@Test
	public void testRetrieveTariffData2() throws TariffRateException{
		TariffRate rate = new TariffRate();
		rate.setTariffProvider("AAAAA");
		rate.setTariffState("ACT");
		dsutils.storeTariffRate(rate);
		
		rate = new TariffRate();
		rate.setTariffProvider("BBBBB");
		rate.setTariffState("ACT");
		dsutils.storeTariffRate(rate);
		
		List<TariffRate> rates =  dsutils.getAllTariffs();
		
		assertTrue("Number of Tariffs = 2", rates.size() == 2);
		assertTrue("Inverter 1 correct", rates.get(0).getTariffProvider().compareTo("AAAAA") == 0);
		assertTrue("Inverter 2 correct", rates.get(1).getTariffProvider().compareTo("BBBBB") == 0);
	}
	
	/**
	 * Test insertion and removal of inverter data.
	 * @throws TariffRateException 
	 */
	@Test
	public void testRemoveTariffData() throws TariffRateException{
		TariffRate rate1 = new TariffRate();
		rate1.setTariffProvider("Rate1");
		rate1.setTariffState("ACT");
		dsutils.storeTariffRate(rate1);
		
		TariffRate rate2 = new TariffRate();
		rate2.setTariffProvider("Rate2");
		rate1.setTariffState("ACT");
		dsutils.storeTariffRate(rate2);
		
		List<TariffRate> rates =  dsutils.getAllTariffs();
		dsutils.removeTariffRate(rates.get(0).getKey());
		
		rates = dsutils.getAllTariffs();
		assertTrue("Number of Inverters is now 1", rates.size() == 1);
	}
	
	/**
	 * Test insertion and removal of all location data.
	 * @throws TariffRateException 
	 */
	@Test
	public void testRemoveTariffData2() throws TariffRateException{
		TariffRate rate1 = new TariffRate();
		rate1.setTariffProvider("Rate1");
		rate1.setTariffState("ACT");
		dsutils.storeTariffRate(rate1);
		
		TariffRate rate2 = new TariffRate();
		rate2.setTariffProvider("Rate2");
		rate1.setTariffState("ACT");
		dsutils.storeTariffRate(rate2);
		
		List<TariffRate> rates = dsutils.getAllTariffs();
		for(TariffRate inv: rates){
			dsutils.removeTariffRate(inv.getKey());
		}
		
		rates =  dsutils.getAllTariffs();
		assertTrue("Number of Inverters is now 0", rates.size() == 0);
	}
	
	
	
	
	
}
