package com.anonymous.solar.shared;

/**
 * This class represents any exceptions generated while dealing with any of the
 * SolarSetup shared classes.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */

@SuppressWarnings("serial")
public class SolarSetupException extends Exception {

	/**
	 * 
	 * Inherited constructor from superclass <code>Exception</code>
	 * 
	 */
	public SolarSetupException() {
		super();
	}

	/**
	 * 
	 * Class specific constructor
	 * 
	 * @param msg
	 *            - specific error message
	 */
	public SolarSetupException(String msg) {
		super("SolarSetupException: " + msg);
	}

}
