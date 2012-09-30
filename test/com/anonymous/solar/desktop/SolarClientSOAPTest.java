package com.anonymous.solar.desktop;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.anonymous.solar.client.LocationInformation;
import com.anonymous.solar.client.LocationInformationService;
import com.anonymous.solar.client.SPanel;
import com.anonymous.solar.client.SPanelService;
import com.anonymous.solar.client.TRate;
import com.anonymous.solar.client.TRateService;
import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.LocationDataException;
import com.anonymous.solar.shared.TariffRate;

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
				locations.get(0).getLocationName().compareTo("Noosa") == 0);
	}
	
	/*******************************
	 ******** TARIFF TESTS *********
	 *******************************/
	
	/**
	 * Try to get a list of tariffs
	 * 
	 * Assumption: Service contains some objects and at least 1 object for the ACT
	 */
	@Test
	public void testTariffGet() {
		TRate TRateSOAP = new TRateService().getTRatePort();
        List<TariffRate> tRateData = (List<TariffRate>) TRateSOAP.getTariffRates();
        assertTrue("No data detected",
        		tRateData.get(0).getTariffState().compareTo("ACT") == 0); 
	}
	
	/**
	 * Try and insert a tariff into the system
	 *  
	 * Assumption: Objects are still been sorted by State, Provider
	 * Assumption 2: No provider has a name with higher priority than "AAAAA"
	 * Assumption 3: The previous test (GET) passed
	 */
	@Test
	public void testTariffInsert() {
		//Generate variables
		String provider = "AAAAA";
		String state = "ACT";
		Double elecDetail = 0.1;
		TariffRate rate = new TariffRate(provider, state, elecDetail, elecDetail, elecDetail, elecDetail
				,elecDetail);
		
		//Insert the tariff
		TRate TRateSOAP = new TRateService().getTRatePort();
        boolean succ = TRateSOAP.insertTariffRate(rate);
        
        //Get a list of current tariffs
        List<TariffRate> tRateData = (List<TariffRate>) TRateSOAP.getTariffRates();
        
        //Test results to check for tariff
        assertTrue("The service has rejected the tariff insert command", succ);
        assertTrue("The tariff did not appear in the store",
        		tRateData.get(0).getTariffProvider().compareTo(provider) == 0); 
	}
	
	/**
	 * Test loading any data from the service, and ensuring we ae getting what
	 * we expected.
	 * 
	 * Assumption: Objects are still been sorted by State, Provider
	 * Assumption 2: No provider has a name with higher priority than "AAAAA"
	 * Assumption 3: The previous test(s) (GET, INSERT) passed
	 * Assumption 4: The previous test (INSERT) has been run and the desired tariff
	 * 				 still sitting at the top (named "AAAAA")
	 */
	@Test
	public void testTariffRemove() {
		//Generate variables
		String provider = "AAAAA";
		String state = "ACT";
		Double elecDetail = 0.1;
		Long key;
		TRate TRateSOAP = new TRateService().getTRatePort();
        
        //Check the tariff is present
        List<TariffRate> tRateData = (List<TariffRate>) TRateSOAP.getTariffRates();
        assertTrue("The panel is not in the store",
        		tRateData.get(0).getTariffProvider().compareTo(provider) == 0); 
        key = tRateData.get(0).getKey();
        
        //Delete the tariff
        boolean succ = TRateSOAP.removeTariffRate(key);
        
        //Get a list of new current tariffs
        tRateData = (List<TariffRate>) TRateSOAP.getTariffRates();
        
        //Test results
        assertTrue("The service has rejected the tariff delete command", succ);
        assertTrue("The panel is still in the store",
        		tRateData.get(0).getTariffProvider().compareTo("AAAAA") != 0); 
		
	}
	
}
