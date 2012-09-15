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
	 * Test insertion and retrival of location data.
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
		
		assertTrue("Number of Locations = 1", locations.size() == 2);
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
}
