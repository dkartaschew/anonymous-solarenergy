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
	 * @throws SolarPanelException 
	 ***********************************************************/
	
	@Test
	public void testSetDailyUsage() throws SolarPanelException {
		data.setDailyAverageUsage(testData);
		assertTrue("Daily Usage is not set", data.getDailyAverageUsage().doubleValue() == testData);
	}
	
	@Test
	public void testSetHourlyAverageUsage() throws SolarPanelException {
		data.setHourlyAverageUsage(testData);
		assertTrue("Hourly Usage is not set", data.getHourlyAverageUsage().doubleValue() == testData);
	}
	
	@Test
	public void testSetTariff11Cost() throws SolarPanelException {
		data.setTariff11Cost(testData);
		assertTrue("Tariff 11 cost is not set", data.getTariff11Cost().doubleValue() == testData);
	}
	
	@Test
	public void testSetTariff11Fee() throws SolarPanelException {
		data.setTariff11Fee(testData);
		assertTrue("Tariff 11 fee is not set", data.getTariff11Fee().doubleValue() == testData);
	}
	
	@Test
	public void testSetTariff13Cost() throws SolarPanelException {
		data.setTariff13Cost(testData);
		assertTrue("Tariff 13 cost is not set", data.getTariff13Cost().doubleValue() == testData);
	}
	
	@Test
	public void testSetTariff13Fee() throws SolarPanelException {
		data.setTariff13Fee(testData);
		assertTrue("Tariff 13 fee is not set", data.getTariff13Fee().doubleValue() == testData);
	}
	
	/***********************************************************
	 * SETTER TEST for null values.
	 * @throws SolarPanelException 
	 ***********************************************************/
	
	@Test(expected = SolarPanelException.class)
	public void testSetFeedInFeeNULL1() throws SolarPanelException {
		data.setFeedInFee(null);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetAnnualTariffIncreaseNULL1() throws SolarPanelException {
		data.setAnnualTariffIncrease(null);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetDailyUsageNULL() throws SolarPanelException {
		data.setDailyAverageUsage(null);
		assertTrue("Daily Usage is not set", data.getDailyAverageUsage().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetHourlyAverageUsageNULL() throws SolarPanelException {
		data.setHourlyAverageUsage(null);
		assertTrue("Hourly Usage is not set", data.getHourlyAverageUsage().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff11CostNULL() throws SolarPanelException {
		data.setTariff11Cost(null);
		assertTrue("Tariff 11 cost is not set", data.getTariff11Cost().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff11FeeNULL() throws SolarPanelException {
		data.setTariff11Fee(null);
		assertTrue("Tariff 11 fee is not set", data.getTariff11Fee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff13CostNULL() throws SolarPanelException {
		data.setTariff13Cost(null);
		assertTrue("Tariff 13 cost is not set", data.getTariff13Cost().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff13FeeNULL() throws SolarPanelException {
		data.setTariff13Fee(null);
		assertTrue("Tariff 13 fee is not set", data.getTariff13Fee().doubleValue() == testData);
	}
	
	
	@Test(expected = SolarPanelException.class)
	public void testSetFeedInFeeNULL() throws SolarPanelException {
		data.setFeedInFee(null);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetAnnualTariffIncreaseNULL() throws SolarPanelException {
		data.setAnnualTariffIncrease(null);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}

	/***********************************************************
	 * SETTER TEST for negative values.
	 * @throws SolarPanelException 
	 ***********************************************************/
	
	@Test(expected = SolarPanelException.class)
	public void testSetFeedInFeeNegative1() throws SolarPanelException {
		data.setFeedInFee(-1.00);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetAnnualTariffIncreaseNegative1() throws SolarPanelException {
		data.setAnnualTariffIncrease(-1.00);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetDailyUsageNegative() throws SolarPanelException {
		data.setDailyAverageUsage(-1.00);
		assertTrue("Daily Usage is not set", data.getDailyAverageUsage().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetHourlyAverageUsageNegative() throws SolarPanelException {
		data.setHourlyAverageUsage(-1.00);
		assertTrue("Hourly Usage is not set", data.getHourlyAverageUsage().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff11CostNegative() throws SolarPanelException {
		data.setTariff11Cost(-1.00);
		assertTrue("Tariff 11 cost is not set", data.getTariff11Cost().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff11FeeNegative() throws SolarPanelException {
		data.setTariff11Fee(-1.00);
		assertTrue("Tariff 11 fee is not set", data.getTariff11Fee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff13CostNegative() throws SolarPanelException {
		data.setTariff13Cost(-1.00);
		assertTrue("Tariff 13 cost is not set", data.getTariff13Cost().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetTariff13FeeNegative() throws SolarPanelException {
		data.setTariff13Fee(-1.00);
		assertTrue("Tariff 13 fee is not set", data.getTariff13Fee().doubleValue() == testData);
	}
	
	
	@Test(expected = SolarPanelException.class)
	public void testSetFeedInFeeNegative() throws SolarPanelException {
		data.setFeedInFee(-1.00);
		assertTrue("Feed in fee is not set", data.getFeedInFee().doubleValue() == testData);
	}
	
	@Test(expected = SolarPanelException.class)
	public void testSetAnnualTariffIncreaseNegative() throws SolarPanelException {
		data.setAnnualTariffIncrease(-1.00);
		assertTrue("Annual tariff increase is not set", data.getAnnualTariffIncrease().doubleValue() == testData);
	}

	
}
