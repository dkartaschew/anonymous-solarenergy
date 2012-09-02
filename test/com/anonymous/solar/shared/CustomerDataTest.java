package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerDataTest {
	
	private CustomerData data;
	private static Double testData = 5.0;
	
	@Before
	public void setUp() throws Exception {
		data = new CustomerData();
	}
	
	/***********************************************************
	 * GETTER TEST
	 * 
	 * Assumption: The initial value of '0' has been given to all variables
	 ***********************************************************/

	
	
	@Test
	public void testGetDailyUsage() {
		assertTrue("UnexpectedData", data.getDailyAverageUsage().doubleValue() == 0.0);
	}
	
	@Test
	public void testGetHourlyAverageUsage() {
		assertTrue("UnexpectedData", data.getHourlyAverageUsage().doubleValue() == 0.0);
	}
	
	@Test
	public void testGetTariff11Cost() {
		assertTrue("UnexpectedData", data.getTariff11Cost().doubleValue() == 0.0);
	}
	
	@Test
	public void testGetTariff11Fee() {
		assertTrue("UnexpectedData", data.getTariff11Fee().doubleValue() == 0.0);
	}
	
	@Test
	public void testGetTariff13Cost() {
		assertTrue("UnexpectedData", data.getTariff13Cost().doubleValue() == 0.0);
	}
	
	@Test
	public void testGetTariff13Fee() {
		assertTrue("UnexpectedData", data.getTariff13Fee().doubleValue() == 0.0);
	}
	
	
	@Test
	public void testGetFeeInFee() {
		assertTrue("UnexpectedData", data.getFeedInFee().doubleValue() == 0.0);
	}
	
	@Test
	public void testGetAnnualTariffIncrease() {
		assertTrue("UnexpectedData", data.getAnnualTariffIncrease().doubleValue() == 0.0);
	}
	
	
	/***********************************************************
	 * SETTER TEST
	 ***********************************************************/
	
	@Test
	public void testSetDailyUsage() {
		data.setDailyAverageUsage(testData);
		assertTrue("Daily Usage is not set", data.getDailyAverageUsage().doubleValue() == testData);
	}
	
	@Test
	public void testSetHourlyAverageUsage() {
		data.setHourlyAverageUsage(testData);
		assertTrue("Hourly Usage is not set", data.getHourlyAverageUsage().doubleValue() == testData);
	}
	
	@Test
	public void testSetTariff11Cost() {
		data.setTariff11Cost(testData);
		assertTrue("Tariff 11 cost is not set", data.getTariff11Cost().doubleValue() == testData);
	}
	
	@Test
	public void testSetTariff11Fee() {
		data.setTariff11Fee(testData);
		assertTrue("Tariff 11 fee is not set", data.getTariff11Fee().doubleValue() == testData);
	}
	
	@Test
	public void testSetTariff13Cost() {
		data.setTariff13Cost(testData);
		assertTrue("Tariff 13 cost is not set", data.getTariff13Cost().doubleValue() == testData);
	}
	
	@Test
	public void testSetTariff13Fee() {
		data.setTariff13Fee(testData);
		assertTrue("Tariff 13 fee is not set", data.getTariff13Fee().doubleValue() == testData);
	}
	
	
	@Test
	public void testSetFeedInFee() {
		data.setFeedInFee(testData);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test
	public void testSetAnnualTariffIncrease() {
		data.setAnnualTariffIncrease(testData);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}

}
