package com.anonymous.solar.desktop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.anonymous.solar.client.LocationInformation;
import com.anonymous.solar.client.LocationInformationService;
import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.LocationDataException;

public class SolarClientSOAPTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * These tests are against LIVE DATA. There is currently NO easy way to test
	 * SOAP connections against a location dummy source within the GAE
	 * framework. (This is due to the how the SOAP Client/Server services are
	 * implemented on GAE).
	 * 
	 * Similar with the SOAP Server side. There is no way to hook a local GAE
	 * service instance via JUnit, so we rely on these client side tests to also
	 * test the server side components as well. Yes, it's poor, but it's the
	 * best that I can work out at the moment, so it's better than nothing.
	 * 
	 * (I know I can create a JAX-WS service for testing, but this is very
	 * different to using GAE on the server side, and requires either Jetty or
	 * Tomcat to be setup, which both offer full JVMs not the restricted on as
	 * presented by GAE).
	 */

	/**
	 * Test saving data to the GAE. (This is set to ignore, as this is testing
	 * against LIVE DATA).
	 * 
	 * @throws LocationDataException
	 */
	@Ignore
	@Test
	public void testSaveDate() throws LocationDataException {
		LocationData location = new LocationData();
		location.setLocationName("Test Location 1");
		LocationInformation locationSOAP = new LocationInformationService().getLocationInformationPort();
		Long result = locationSOAP.storeLocationInformation(location);
		assertTrue("result should be non-zero", result != 0);
	}

	/**
	 * Test loading any data from the service.
	 */
	@Test
	public void testLoadData() {
		LocationInformation locationSOAP = new LocationInformationService().getLocationInformationPort();
		List<LocationData> locations = locationSOAP.storeLocationGetAll();
		assertTrue("At least Location returned", locations.size() != 0);
	}

	/**
	 * Test loading any data from the service, and ensuring we ae getting what
	 * we expected.
	 */
	@Test
	public void testLoadData2() {
		LocationInformation locationSOAP = new LocationInformationService().getLocationInformationPort();
		List<LocationData> locations = locationSOAP.storeLocationGetAll();
		assertTrue("At least Location returned", locations.size() != 0);
		assertTrue("Single location object is sane",
				locations.get(0).getLocationName().compareTo("Surfers Paradise") == 0);
	}
}
