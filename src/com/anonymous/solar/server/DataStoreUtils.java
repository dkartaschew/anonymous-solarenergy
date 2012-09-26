package com.anonymous.solar.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.TariffRate;

public class DataStoreUtils {

	/**
	 * Store a new panel into the local datastore
	 * 
	 * @param panel
	 *            The panel information to be stored in the datastore
	 */
	public Long storePanel(SolarPanel panel) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(panel);
		} finally {
			pm.close();
		}
		return panel.getKey();
	}

	/**
	 * Remove a panel from the datastore based on the key contained in the panel
	 * object. (If key == 0, then object is not in the datastore.
	 * 
	 * @param panelKey
	 *            Key ID of the panel to remove from the datastore.
	 */
	public void removePanel(Long panelKey) {
		if (panelKey > 0) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(SolarPanel.class);
			q.setFilter("key == panelKeyParam");
			q.declareParameters("Long panelKeyParam");
			q.deletePersistentAll(panelKey);
		}
	}
	
	/**
	 * Store a tariff into the data store.
	 * @param TariffRate - a tariffRate variable to store into the datastore
	 * @return
	 */
	public Long storeTariffRate(TariffRate rates) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(rates);
		} finally {
			pm.close();
		}
		return rates.getKey();
	}
	
	/**
	 * Remove a tariffRate from the datastore based on the key contained in the tariffRate
	 * object. (If key == 0, then object is not in the datastore.
	 * 
	 * @param tariffKey
	 *            Key ID of the panel to remove from the datastore.
	 */
	public void removeTariffRate(Long tariffKey) {
		if (tariffKey > 0) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(TariffRate.class);
			q.setFilter("key == tariffKeyParam");
			q.declareParameters("Long tariffKeyParam");
			q.deletePersistentAll(tariffKey);
		}
	}
	
	/**
	 * Retrieve a list of all tariff rates that are available within the
	 * datastore.
	 * 
	 * @return A List of TariffRates.
	 */
	@SuppressWarnings("unchecked")
	public List<TariffRate> getAllTariffs() {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<TariffRate> panelArrayList = new ArrayList<TariffRate>();

		Query q = pm.newQuery(TariffRate.class);
		q.setOrdering("tariffState asc, tariffProvider asc");

		try {
			panelArrayList = (List<TariffRate>) q.execute();
			return panelArrayList;
		} finally {
			q.closeAll();
		}
	}

	/**
	 * Retrieve a single solar panels information based on the panel name.
	 * 
	 * @param panelName
	 *            The name of the panel to retrieve from the data store.
	 * @return A SolarPanel object with information based on the entity.
	 */
	@SuppressWarnings("unchecked")
	public SolarPanel getPanelInformation(String panelName) {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<SolarPanel> panelArrayList = new ArrayList<SolarPanel>();

		Query q = pm.newQuery(SolarPanel.class);
		q.setFilter("panelName == panelNameParam");
		q.declareParameters("String panelNameParam");
		q.setOrdering("panelManufacturer asc");

		try {
			panelArrayList = (List<SolarPanel>) q.execute(panelName);
			if (panelArrayList.isEmpty()) {
				return null;
			}
			return panelArrayList.get(0);
		} finally {
			q.closeAll();
		}
	}

	/**
	 * Retrieve a list of all solar panels that are available within the
	 * datastore.
	 * 
	 * @return A List of SolarPanels.
	 */
	@SuppressWarnings("unchecked")
	public List<SolarPanel> getAllPanels() {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<SolarPanel> panelArrayList = new ArrayList<SolarPanel>();

		Query q = pm.newQuery(SolarPanel.class);
		q.setOrdering("panelManufacturer asc, panelManufacturerCode asc, panelName asc");

		try {
			panelArrayList = (List<SolarPanel>) q.execute();
			return panelArrayList;
		} finally {
			q.closeAll();
		}
	}
	
	/**
	 * Retrieve a list of all solar inverters that are available within the
	 * datastore.
	 * 
	 * @return A List of SolarPanels.
	 */
	@SuppressWarnings("unchecked")
	public List<SolarInverter> getAllInverters() {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<SolarInverter> panelArrayList = new ArrayList<SolarInverter>();

		Query q = pm.newQuery(SolarInverter.class);
		q.setOrdering("inverterManufacturer asc, inverterManufacturerCode asc, inverterName asc");

		try {
			panelArrayList = (List<SolarInverter>) q.execute();
			return panelArrayList;
		} finally {
			q.closeAll();
		}
	}
	
	/**
	 * Store a new inverter into the local datastore
	 * 
	 * @param inverter
	 *            The inverter information to be stored in the datastore
	 */
	public Long storeInverter(SolarInverter inverter) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(inverter);
		} finally {
			pm.close();
		}
		return inverter.getKey();
	}

	/**
	 * Remove a panel from the datastore based on the key contained in the panel
	 * object. (If key == 0, then object is not in the datastore.
	 * 
	 * @param inverterKey
	 *            Key ID of the panel to remove from the datastore.
	 */
	public void removeInverter(Long inverterKey) {
		if (inverterKey > 0) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(SolarInverter.class);
			q.setFilter("key == inverterKeyParam");
			q.declareParameters("Long inverterKeyParam");
			q.deletePersistentAll(inverterKey);
		}
	}
	
	/**
	 * Store a set of Location information within the datastore.
	 * @param locdata
	 * @return
	 */
	public Long storeLocationData(LocationData locdata){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(locdata);
		} finally {
			pm.close();
		}
		return locdata.getKey();
	}
	
	/**
	 * Remove location information from the datastore based on the key contained in the location
	 * object. (If key == 0, then object is not in the datastore.
	 * 
	 * @param locationKey
	 *            Key ID of the location to remove from the datastore.
	 */
	public void removeLocationData(Long locationKey) {
		if (locationKey > 0) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(LocationData.class);
			q.setFilter("key == locationKeyParam");
			q.declareParameters("Long locationKeyParam");
			q.deletePersistentAll(locationKey);
		}
	}
	
	/**
	 * Retrieve a list of all locations that are available within the
	 * datastore.
	 * 
	 * @return A List of Locations.
	 */
	@SuppressWarnings("unchecked")
	public List<LocationData> getAllLocations() {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<LocationData> locationArrayList = new ArrayList<LocationData>();

		Query q = pm.newQuery(LocationData.class);
		q.setOrdering("locationName asc");

		try {
			locationArrayList = (List<LocationData>) q.execute();
			return locationArrayList;
		} finally {
			q.closeAll();
		}
	}
}
