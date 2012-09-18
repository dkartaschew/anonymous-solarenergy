package com.anonymous.solar.shared;

/**
 * This class represents any exceptions generated while dealing with any of the
 * SolarInverter shared classes.
 * 
 * @author 08311382 Michael Munchin
 * @version 1.0
 */

@SuppressWarnings("serial")
public class SolarInverterException extends Exception {

	/**
	 * 
	 * Inherited constructor from superclass <code>Exception</code>
	 * 
	 */
	public SolarInverterException() {
		super();
	}

	/**
	 * 
	 * Class specific constructor
	 * 
	 * @param msg
	 *            - specific error message
	 */
	public SolarInverterException(String msg) {
		super("SolarInverterException: " + msg);
	}

}
