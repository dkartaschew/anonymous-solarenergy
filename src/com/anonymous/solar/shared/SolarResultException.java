package com.anonymous.solar.shared;

/**
 * This class represents general exceptions dealing with any of SolarResult shared classes.
 * 
 * @author 07377495 Luke Durkan
 * @version 1.0
 */
@SuppressWarnings("serial") //don't need to look at binary i/o
public class SolarResultException extends Exception {

	/**
	 * 
	 * Inherited code from superclass <code>Exception</code>
	 * 
	 */
	public SolarResultException() {
		super();
	}
	
	/**
	 * Main constructor to be used when throwing this exception
	 * 
	 * @param msg - specific error message
	 */
	public SolarResultException(String msg) {
		super("SolarResultException: " + msg);
	}
}
