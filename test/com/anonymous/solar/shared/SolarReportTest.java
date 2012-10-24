package com.anonymous.solar.shared;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SolarReportTest {
	
	SolarReport report;

	@Before
	public void setUpThrowsError() throws Exception {
		report = new SolarReport();
	}
	
	/*****************************************************************************************************
	 * Check content gets added in correct form
	 *****************************************************************************************************/
	/**
	 * Check content can't be added after adding: String
	 * @throws SolarReportException
	 */
	@Test
	public void addContentSolarStringAddsContent() throws SolarReportException {
		String current = report.toString();
		
		String expected = "abc";
		
		report.addContent("abc");
		
		assertTrue("Not added correctly", report.toString().compareTo(current + expected) == 0);	
	}
	
	/*****************************************************************************************************
	 * Test for correct starting tags and finishing tags
	 *****************************************************************************************************/
	
	/**
	 * Check start <DOCTYPE and <html tags are present
	 * @throws SolarReportException
	 */
	@Test
	public void testForCorrectTagsStart() throws SolarReportException {
		report.Finalize();
		String html = report.toString();
		
		String substring = html.substring(0, 27);
		
		assertTrue("Start Tags not found (Result: " + substring + ")", substring.compareTo("<!DOCTYPE html><html><head>") == 0);
	}
	
	/**
	 * Check end and <html tags are present
	 * @throws SolarReportException
	 */
	@Test
	public void testForCorrectTagsEnd() throws SolarReportException {
		report.Finalize();
		String html = report.toString();
		
		String substring = html.substring(html.length() - 14, html.length() - 0);
		
		assertTrue("End Tags not found (Result: " + substring + ")", substring.compareTo("</body></html>") == 0);
	}
	
	/********************************************************************************************************
	 * Check exception is thrown after finalization
	 ********************************************************************************************************/
	
	/**
	 * Check content can't be added after adding: String
	 * @throws SolarReportException
	 */
	@Test (expected = SolarReportException.class)
	public void addContentSolarStringThrowsError() throws SolarReportException {
		report.Finalize();
		report.addContent("dfd");
	}
	
	/**
	 * Check content can't be added after adding: Solar Result Details
	 * @throws SolarReportException
	 */
	@Test (expected = SolarReportException.class)
	public void addContentSolarResultDetailsThrowsError() throws SolarReportException {
		report.Finalize();
		report.addContent(new SolarResult(), 10);
	}
	
	
}
