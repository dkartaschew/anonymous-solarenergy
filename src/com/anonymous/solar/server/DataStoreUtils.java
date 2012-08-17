package com.anonymous.solar.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.anonymous.solar.shared.SolarPanel;

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
}
