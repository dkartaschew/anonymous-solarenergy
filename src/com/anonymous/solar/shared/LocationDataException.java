package com.anonymous.solar.shared;
/**
 * This class represents any exceptions generated while dealing with any of the
 * Location shared classes.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */

@SuppressWarnings("serial")
public class LocationDataException extends Exception {
	/**
	 * 
	 * Inherited constructor from superclass <code>Exception</code>
	 * 
	 */
	public LocationDataException() {
		super();
	}

	/**
	 * 
	 * Class specific constructor
	 * 
	 * @param msg
	 *            - specific error message
	 */
	public LocationDataException(String msg) {
		super("LocationDataException: " + msg);
	}
}
