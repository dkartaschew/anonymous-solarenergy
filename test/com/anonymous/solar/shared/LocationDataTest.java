package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for Location Data class
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class LocationDataTest {
	
	LocationData instance;
	ArrayList<Double> weather;

	@Before
	public void setUp() throws Exception {
		instance = new LocationData();
		weather = new ArrayList<Double>();
		for(int i = 0; i < 12; i++){
			weather.add(0.00);
		}
	}

	/**
	 * Test default state of the object when created.
	 */
	@Test
	public void testLocationData() {
		assertTrue("Default Name is \"\"", instance.getLocationName() == null);
		assertTrue("Default Longitude is \"\"", instance.getLongitude() == 0.00);
		assertTrue("Default Latitude is \"\"", instance.getLatitude() == 0.00);
		assertTrue("Default weather data", instance.getLocationWeatherData().size() == 12);
		assertTrue("Default weather efficiency", instance.getLocationWeatherEfficiency().size() == 12);
	}

	/**
	 * Test alternate constructor, should pass.
	 * @throws LocationDataException
	 */
	@Test
	public void testLocation2() throws LocationDataException {
		instance = new LocationData(1.00, 1.00, "Name", weather, weather);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
		assertTrue("Default Longitude is \"\"", instance.getLongitude() == 1.00);
		assertTrue("Default Latitude is \"\"", instance.getLatitude() == 1.00);
		assertTrue("Default weather data", instance.getLocationWeatherData().size() == 12);
		assertTrue("Default weather efficiency", instance.getLocationWeatherEfficiency().size() == 12);
	}
	
	/**
	 * Test alternate constructor, should fail (bad latitude).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation3() throws LocationDataException {
		instance = new LocationData(-200.00, 1.00, "Name", weather, weather);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (bad long).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation4() throws LocationDataException {
		instance = new LocationData(1.00, -1000.00, "Name", weather, weather);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (bad name).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation5() throws LocationDataException {
		instance = new LocationData(1.00, -1.00, "", weather, weather);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (bad name).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation6() throws LocationDataException {
		instance = new LocationData(1.00, -1.00, null,weather, weather);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (null weather).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation7() throws LocationDataException {
		instance = new LocationData(1.00, -1.00, "Name", null, weather);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (bad size weather).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation8() throws LocationDataException {
		ArrayList<Double> weather2 = new ArrayList<Double>();
		for(int i = 0; i < 11; i++){
			weather2.add(0.00);
		}
		instance = new LocationData(1.00, -1.00, "Name", weather2, weather);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (bad size weather).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation9() throws LocationDataException {
		ArrayList<Double> weather2 = new ArrayList<Double>();
		for(int i = 0; i < 13; i++){
			weather2.add(0.00);
		}
		instance = new LocationData(1.00, -1.00, "Name", weather2, weather);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (null efficiency).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation10() throws LocationDataException {
		instance = new LocationData(1.00, -1.00, "Name", weather, null);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (null efficiency).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation11() throws LocationDataException {
		ArrayList<Double> weather2 = new ArrayList<Double>();
		for(int i = 0; i < 11; i++){
			weather2.add(0.00);
		}
		instance = new LocationData(1.00, -1.00, "Name", weather, weather2);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**(expected = LocationDataException.class)
	 * Test alternate constructor, should fail (null efficiency).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation12() throws LocationDataException {
		ArrayList<Double> weather2 = new ArrayList<Double>();
		for(int i = 0; i < 11; i++){
			weather2.add(0.00);
		}
		instance = new LocationData(1.00, -1.00, "Name", weather, weather2);
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (null efficiency).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation13() throws LocationDataException {
		ArrayList<Double> weather2 = new ArrayList<Double>();
		for(int i = 0; i < 11; i++){
			weather2.add(0.00);
		}
		instance = new LocationData(1.00, -1.00, "Name", weather, new ArrayList<Double>(0));
		
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/**
	 * Test alternate constructor, should fail (null efficiency).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testLocation14() throws LocationDataException {
		instance = new LocationData(1.00, -1.00, "Name", new ArrayList<Double>(0), weather);
		assertTrue("Default Name is \"\"", instance.getLocationName().compareTo("Name") == 0);
	}

	/**
	 * Test default datastore key, should be null.
	 */
	@Test
	public void testGetKey() {
		assertTrue("Test default key", instance.getKey() == null);
	}

	/**
	 * Test to ensure we can set our weather efficiency.
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLocationWeatherData2() throws LocationDataException {
		for(int i = 0; i < 12; i++){
			weather.set(i, 10.00);
		}
		instance.setLocationWeatherData(null);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherData().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherData().equals(weather));
	}
	
	/**
	 * Test to ensure we can set our weather efficiency.
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLocationWeatherData() throws LocationDataException {
		for(int i = 0; i < 12; i++){
			weather.set(i, 10.00);
		}
		instance.setLocationWeatherData(weather);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherData().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherData().equals(weather));
	}
	
	/**
	 * Test to ensure we can set our weather efficiency. (bad size array)
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLocationWeatherData3() throws LocationDataException {
		weather = new ArrayList<Double>();
		for(int i = 0; i < 11; i++){
			weather.add(10.00);
		}
		instance.setLocationWeatherData(weather);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherData().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherData().equals(weather));
	}
	
	/**
	 * Test to ensure we can set our weather efficiency. (bad size array)
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLocationWeatherData4() throws LocationDataException {
		weather = new ArrayList<Double>();
		for(int i = 0; i < 13; i++){
			weather.add(10.00);
		}
		instance.setLocationWeatherData(weather);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherData().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherData().equals(weather));
	}

	/**
	 * Test to ensure we can set our weather efficiency.
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLocationWeatherEfficency2() throws LocationDataException {
		for(int i = 0; i < 12; i++){
			weather.set(i, 10.00);
		}
		instance.setLocationWeatherEfficency(null);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherEfficiency().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherEfficiency().equals(weather));
	}
	
	/**
	 * Test to ensure we can set our weather efficiency.
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLocationWeatherEfficency() throws LocationDataException {
		for(int i = 0; i < 12; i++){
			weather.set(i, 10.00);
		}
		instance.setLocationWeatherEfficency(weather);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherEfficiency().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherEfficiency().equals(weather));
	}
	
	/**
	 * Test to ensure we can set our weather efficiency. (bad size array)
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLocationWeatherEfficency3() throws LocationDataException {
		weather = new ArrayList<Double>();
		for(int i = 0; i < 11; i++){
			weather.add(10.00);
		}
		instance.setLocationWeatherEfficency(weather);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherEfficiency().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherEfficiency().equals(weather));
	}
	
	/**
	 * Test to ensure we can set our weather efficiency. (bad size array)
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLocationWeatherEfficency4() throws LocationDataException {
		weather = new ArrayList<Double>();
		for(int i = 0; i < 13; i++){
			weather.add(10.00);
		}
		instance.setLocationWeatherEfficency(weather);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherEfficiency().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherEfficiency().equals(weather));
	}

	/**
	 * Test default getter for latitude.
	 */
	@Test
	public void testGetLatitude() {
		assertTrue("Default Latitude is \"\"", instance.getLatitude() == 0.00);
	}

	/**
	 * Test setter for latitude (should pass with good known value).
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLatitude() throws LocationDataException {
		instance.setLatitude(1.00);
		assertTrue("Default Latitude is \"\"", instance.getLatitude() == 1.00);
	}
	
	/**
	 * Test setter for latitude (should pass with good known value).
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLatitude2() throws LocationDataException {
		instance.setLatitude(90.00);
		assertTrue("Default Latitude is \"\"", instance.getLatitude() == 90.00);
	}
	
	/**
	 * Test setter for latitude (should pass with good known value).
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLatitude3() throws LocationDataException {
		instance.setLatitude(-90.00);
		assertTrue("Default Latitude is \"\"", instance.getLatitude() == -90.00);
	}
	
	/**
	 * Test setter for latitude (should fail with bad known value).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLatitude4() throws LocationDataException {
		instance.setLatitude(90.01);
		assertTrue("Default Latitude is \"\"", instance.getLatitude() == 90.01);
	}
	
	/**
	 * Test setter for latitude (should fail with bad known value).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLatitude5() throws LocationDataException {
		instance.setLatitude(-90.01);
		assertTrue("Default Latitude is \"\"", instance.getLatitude() == -90.01);
	}
	
	/**
	 * Test setter for latitude (should fail with bad known value).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLatitude6() throws LocationDataException {
		instance.setLatitude(null);
	}

	/**
	 * Test default getter for the property
	 */
	@Test
	public void testGetLocationName() {
		assertTrue("Default Name is null", instance.getLocationName() == null);
	}

	/** 
	 * Test the default setter with a good value.
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLocationName() throws LocationDataException {
		instance.setLocationName("Name");
		assertTrue("Default Name is null", instance.getLocationName().compareTo("Name") == 0);
	}
	
	/** 
	 * Test the default setter with a good value.
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLocationName1() throws LocationDataException {
		instance.setLocationName("");
		assertTrue("Default Name is null", instance.getLocationName().compareTo("") == 0);
	}
	
	/** 
	 * Test the default setter with a good value.
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLocationName2() throws LocationDataException {
		instance.setLocationName(null);
		assertTrue("Default Name is null", instance.getLocationName() == null);
	}

	/**
	 * Test get weather data with default data.
	 * @throws LocationDataException 
	 */
	@Test
	public void testGetLocationWeatherData2() throws LocationDataException {
		for(int i = 0; i < 12; i++){
			weather.set(i, 10.00);
		}
		instance.setLocationWeatherData(weather);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherData().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherData().equals(weather));
	}
	
	/**
	 * Test get weather data with default data.
	 */
	@Test
	public void testGetLocationWeatherData() {
		assertTrue("Default list has 12 elements", instance.getLocationWeatherData().size() == 12);
	}

	/**
	 * Test getter for weather efficiency.
	 * @throws LocationDataException 
	 */
	@Test
	public void testGetLocationWeatherEfficiency() throws LocationDataException {
		for(int i = 0; i < 12; i++){
			weather.set(i, 10.00);
		}
		instance.setLocationWeatherEfficency(weather);
		assertTrue("Default list has 12 elements", instance.getLocationWeatherEfficiency().size() == 12);
		assertTrue("Returns new set value.", instance.getLocationWeatherEfficiency().equals(weather));
	}
	
	/**
	 * Test getter for weather efficiency.
	 * @throws LocationDataException 
	 */
	@Test
	public void testGetLocationWeatherEfficiency1() throws LocationDataException {
		assertTrue("Default list has 12 elements", instance.getLocationWeatherEfficiency().size() == 12);
	}

	/**
	 * Test default getter for latitude.
	 */
	@Test
	public void testGetLongitude() {
		assertTrue("Default Longitude is \"\"", instance.getLongitude() == 0.00);
	}

	/**
	 * Test setter for latitude (should pass with good known value).
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLongitude() throws LocationDataException {
		instance.setLongitude(1.00);
		assertTrue("Default Longitude is \"\"", instance.getLongitude() == 1.00);
	}
	
	/**
	 * Test setter for latitude (should pass with good known value).
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLongitude2() throws LocationDataException {
		instance.setLongitude(180.00);
		assertTrue("Default Longitude is \"\"", instance.getLongitude() == 180.00);
	}
	
	/**
	 * Test setter for latitude (should pass with good known value).
	 * @throws LocationDataException
	 */
	@Test
	public void testSetLongitude3() throws LocationDataException {
		instance.setLongitude(-180.00);
		assertTrue("Default Longitude is \"\"", instance.getLongitude() == -180.00);
	}
	
	/**
	 * Test setter for latitude (should fail with bad known value).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLongitude4() throws LocationDataException {
		instance.setLongitude(180.01);
		assertTrue("Default Longitude is \"\"", instance.getLongitude() == 180.01);
	}
	
	/**
	 * Test setter for latitude (should fail with bad known value).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLongitude5() throws LocationDataException {
		instance.setLongitude(-180.01);
		assertTrue("Default Longitude is \"\"", instance.getLongitude() == -180.01);
	}
	
	/**
	 * Test setter for latitude (should fail with bad known value).
	 * @throws LocationDataException
	 */
	@Test(expected = LocationDataException.class)
	public void testSetLongitude6() throws LocationDataException {
		instance.setLongitude(null);
	}

	/**
	 * Test default toString() method on new object.
	 */
	@Test
	public void testToString() {
		assertTrue("Default tostring is null", instance.getLocationName() == null);
	}
	
	/**
	 * Test default toString() method on existing object.
	 * @throws LocationDataException 
	 */
	@Test
	public void testToString2() throws LocationDataException {
		instance.setLocationName("Name");
		assertTrue("Default string is name", instance.toString().compareTo("Name") == 0);
	}
	
	/**
	 * Test default toString() method on existing object.
	 * @throws LocationDataException 
	 */
	@Test
	public void testToString3() throws LocationDataException {
		instance.setLocationName("Melbourne");
		assertTrue("Default string is name", instance.toString().compareTo("Melbourne") == 0);
	}

	/**
	 * Test the toString() overload with default parameters
	 */
	@Test
	public void testToStringBoolean() {
		assertTrue("Default toString(true)", instance.toString(false).compareTo("Location Name: null <br />Latitude: 0.0<br />Longitude: 0.0<br />") == 0);
	}
	
	/**
	 * Test the toString() overload with default parameters, but html output
	 */
	@Test
	public void testToStringBoolean1() {
		assertTrue("Default toString(true)", instance.toString(true).compareTo("<html>Location Name: null <br />Latitude: 0.0<br />Longitude: 0.0<br /></html>") == 0);
	}
	
	/**
	 * Test the toString() overload with set parameters
	 */
	@Test
	public void testToStringBoolean2() throws LocationDataException {
		instance.setLocationName("Melbourne");
		instance.setLatitude(1.00);
		instance.setLongitude(1.00);
		assertTrue("Default toString(true)", instance.toString(false).compareTo("Location Name: Melbourne <br />Latitude: 1.0<br />Longitude: 1.0<br />") == 0);
	}
	
	/**
	 * Test the toString() overload with set parameters, but html output
	 */
	@Test
	public void testToStringBoolean3() throws LocationDataException {
		instance.setLocationName("Melbourne");
		instance.setLatitude(1.00);
		instance.setLongitude(1.00);
		assertTrue("Default toString(true)", instance.toString(true).compareTo("<html>Location Name: Melbourne <br />Latitude: 1.0<br />Longitude: 1.0<br /></html>") == 0);
	}

}
