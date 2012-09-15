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
	
	/***********************************************************
	 * SETTER TEST for null values.
	 ***********************************************************/
	
	@Test(expected = SolarPanelException.class)
	public void testSetFeedInFeeNULL1() {
		data.setFeedInFee(null);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetAnnualTariffIncreaseNULL1() {
		data.setAnnualTariffIncrease(null);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetDailyUsageNULL() {
		data.setDailyAverageUsage(null);
		assertTrue("Daily Usage is not set", data.getDailyAverageUsage().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetHourlyAverageUsageNULL() {
		data.setHourlyAverageUsage(null);
		assertTrue("Hourly Usage is not set", data.getHourlyAverageUsage().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff11CostNULL() {
		data.setTariff11Cost(null);
		assertTrue("Tariff 11 cost is not set", data.getTariff11Cost().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff11FeeNULL() {
		data.setTariff11Fee(null);
		assertTrue("Tariff 11 fee is not set", data.getTariff11Fee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff13CostNULL() {
		data.setTariff13Cost(null);
		assertTrue("Tariff 13 cost is not set", data.getTariff13Cost().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff13FeeNULL() {
		data.setTariff13Fee(null);
		assertTrue("Tariff 13 fee is not set", data.getTariff13Fee().doubleValue() == testData);
	}
	
	
	@Test(expected = SolarPanelException.class)
	public void testSetFeedInFeeNULL() {
		data.setFeedInFee(null);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetAnnualTariffIncreaseNULL() {
		data.setAnnualTariffIncrease(null);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}

	/***********************************************************
	 * SETTER TEST for negative values.
	 ***********************************************************/
	
	@Test(expected = SolarPanelException.class)
	public void testSetFeedInFeeNegative1() {
		data.setFeedInFee(-1.00);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetAnnualTariffIncreaseNegative1() {
		data.setAnnualTariffIncrease(-1.00);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetDailyUsageNegative() {
		data.setDailyAverageUsage(-1.00);
		assertTrue("Daily Usage is not set", data.getDailyAverageUsage().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetHourlyAverageUsageNegative() {
		data.setHourlyAverageUsage(-1.00);
		assertTrue("Hourly Usage is not set", data.getHourlyAverageUsage().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff11CostNegative() {
		data.setTariff11Cost(-1.00);
		assertTrue("Tariff 11 cost is not set", data.getTariff11Cost().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff11FeeNegative() {
		data.setTariff11Fee(-1.00);
		assertTrue("Tariff 11 fee is not set", data.getTariff11Fee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff13CostNegative() {
		data.setTariff13Cost(-1.00);
		assertTrue("Tariff 13 cost is not set", data.getTariff13Cost().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff13FeeNegative() {
		data.setTariff13Fee(-1.00);
		assertTrue("Tariff 13 fee is not set", data.getTariff13Fee().doubleValue() == testData);
	}
	
	
	@Test(expected = SolarPanelException.class)
	public void testSetFeedInFeeNegative() {
		data.setFeedInFee(-1.00);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetAnnualTariffIncreaseNegative() {
		data.setAnnualTariffIncrease(-1.00);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}

	
}
