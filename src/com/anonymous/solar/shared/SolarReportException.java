package com.anonymous.solar.shared;

/**
 * This class represents any exceptions generated while dealing with any of the
 * SolarPanel shared classes.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */

@SuppressWarnings("serial")
public class SolarReportException extends Exception {

	/**
	 * 
	 * Inherited constructor from superclass <code>Exception</code>
	 * 
	 */
	public SolarReportException() {
		super();
	}

	/**
	 * 
	 * Class specific constructor
	 * 
	 * @param msg
	 *            - specific error message
	 */
	public SolarReportException(String msg) {
		super("SolarReportException: " + msg);
	}

}
