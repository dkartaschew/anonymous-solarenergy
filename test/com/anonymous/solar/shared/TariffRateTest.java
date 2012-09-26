package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TariffRateTest {

	TariffRate rate;
	
	@Before
	public void setUp() throws Exception {
		rate = new TariffRate();
	}
	
	
	/*******************
	 * Getters
	 * Assumption: All components have an initial value of 0
	 *******************/
	@Test
	public void testGetProvider() {
		assertTrue(rate.getTariffProvider().compareTo(new String()) == 0);
	}
	
	@Test
	public void testGetState() {
		assertTrue(rate.getTariffState().compareTo(new String()) == 0);
	}
	
	@Test
	public void testGetFeedInFee() {
		assertTrue(rate.getTariffFeedInFee() == 0);
	}
	
	@Test
	public void testGetTariff11Cost() {
		assertTrue(rate.getTariff11Cost() == 0);
	}
	
	@Test
	public void testGetTariff11Fee() {
		assertTrue(rate.getTariff11Fee() == 0);
	}
	
	@Test
	public void testGetTariff33Cost() {
		assertTrue(rate.getTariff33Cost() == 0);
	}
	
	@Test
	public void testGetTariff33Fee() {
		assertTrue(rate.getTariff33Fee() == 0);
	}
	
	
	/*****************************
	 * Setters - standard input
	 *  Passing in data that should
	 * 		not throw an exception
	 * 		be returned though the getter
	 *****************************/

	@Test
	public void testSetProvider() throws TariffRateException {
		rate.setTariffProvider("abc");
		assertTrue(rate.getTariffProvider().compareTo("abc") == 0);
	}
	
	@Test
	public void testSetState() throws TariffRateException {
		rate.setTariffState("QLD");
		assertTrue(rate.getTariffState().compareTo("QLD") == 0);
	}
	
	@Test
	public void testSetFeedInFee() throws TariffRateException {
		rate.setTariffFeedInFee(10.0);
		assertTrue(rate.getTariffFeedInFee() == 10.0);
	}
	
	@Test
	public void testSetTariff11Cost() throws TariffRateException {
		rate.setTariff11Cost(10.0);
		assertTrue(rate.getTariff11Cost() == 10.0);
	}
	
	@Test
	public void testSetTariff11Fee() throws TariffRateException {
		rate.setTariff11Fee(10.1);
		assertTrue(rate.getTariff11Fee() == 10.1);
	}
	
	@Test
	public void testSetTariff33Cost() throws TariffRateException {
		rate.setTariff33Cost(10.2);
		assertTrue(rate.getTariff33Cost() == 10.2);
	}
	
	@Test
	public void testSetTariff33Fee() throws TariffRateException {
		rate.setTariff33Fee(10.3);
		assertTrue(rate.getTariff33Fee() == 10.3);
	}
	
	/*****************************
	 * Setters - obscure input
	 * Null and empty string values to throw an exception
	 *****************************/

	@Test(expected = TariffRateException.class)
	public void testErrorProvider() throws TariffRateException {
		rate.setTariffProvider(null);
	}
	
	@Test(expected = TariffRateException.class)
	public void testErrorState() throws TariffRateException {
		rate.setTariffState(null);
	}
	
	@Test(expected = TariffRateException.class)
	public void testEmptyProvider() throws TariffRateException {
		rate.setTariffProvider("");
	}
	
	@Test(expected = TariffRateException.class)
	public void testEmptyState() throws TariffRateException {
		rate.setTariffState("");
	}
	
	@Test(expected = TariffRateException.class)
	public void testErrorFeedInFee() throws TariffRateException {
		rate.setTariffFeedInFee(null);
	}
	
	@Test(expected = TariffRateException.class)
	public void testErrorTariff11Cost() throws TariffRateException {
		rate.setTariff11Cost(null);
	}
	
	@Test(expected = TariffRateException.class)
	public void testErrorTariff11Fee() throws TariffRateException {
		rate.setTariff11Cost(null);
	}
	
	@Test(expected = TariffRateException.class)
	public void testErrorTariff33Cost() throws TariffRateException {
		rate.setTariff33Cost(null);
	}
	
	@Test(expected = TariffRateException.class)
	public void testErrorTariff33Fee() throws TariffRateException {
		rate.setTariff33Fee(null);
	}
	
	/*****************************
	 * Setters - good input
	 * Passing in existing states 
	 * Assumption: The program will not throw an error for existing states
	 *****************************/
	@Test
	public void testSetStateQLD() throws TariffRateException {
		rate.setTariffState("QLD");
	}
	
	@Test
	public void testSetStateNSW() throws TariffRateException {
		rate.setTariffState("NSW");
	}
	
	@Test
	public void testSetStateVIC() throws TariffRateException {
		rate.setTariffState("VIC");
	}
	
	@Test
	public void testSetStateTAS() throws TariffRateException {
		rate.setTariffState("TAS");
	}
	
	@Test
	public void testSetStateNT() throws TariffRateException {
		rate.setTariffState("NT");
	}
	
	@Test
	public void testSetStateSA() throws TariffRateException {
		rate.setTariffState("SA");
	}
	
	@Test
	public void testSetStateWA() throws TariffRateException {
		rate.setTariffState("WA");
	}
	
	/*****************************
	 * Setters - bad input
	 * Passing in non existent states 
	 * Assumption: The program will  throw an error for non existing states
	 *****************************/
	@Test(expected = TariffRateException.class)
	public void testSetStateBad1() throws TariffRateException {
		rate.setTariffState("QLA");
	}
	
	@Test(expected = TariffRateException.class)
	public void testSetStateBad2() throws TariffRateException {
		rate.setTariffState("NNN");
	}
	
	@Test(expected = TariffRateException.class)
	public void testSetStateBad3() throws TariffRateException {
		rate.setTariffState("VCC");
	}
	
	
}
