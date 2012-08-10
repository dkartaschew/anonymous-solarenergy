/**
 * 
 */
package com.anonymous.solar.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * Singleton Class for communication to datastore.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public final class PMF {
	
	/**
	 * Constructor
	 */
	private static final PersistenceManagerFactory pmfInstance = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	/**
	 * Default Constructor
	 */
	private PMF() {
	}

	/**
	 * Method to obtain PersistenceManagerFactory instance to use to communicate with datastore.
	 * @return PMF instance.
	 */
	public static PersistenceManagerFactory get() {
		return pmfInstance;
	}
}
