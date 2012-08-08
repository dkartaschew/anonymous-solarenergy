package com.anonymous.solar.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.anonymous.solar.shared.SolarPanel;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class DataStoreUtils {

	/**
	 * Store a new panel into the local datastore
	 * @param panel The panel information to be stored in the datastore
	 */
	public void storePanel(SolarPanel panel) {
		Date date = new Date();
		Entity panelEntity = new Entity("panels");
		panelEntity.setProperty("panelManufacturer",
				panel.getPanelManufacturer());
		panelEntity.setProperty("panelManufacturerCode",
				panel.getPanelManufacturerCode());
		panelEntity.setProperty("panelName", panel.getPanelName());
		panelEntity.setProperty("panelWattage", panel.getPanelWattage());
		panelEntity.setProperty("panelLossYear", panel.getPanelLossYear());
		panelEntity.setProperty("panelCost", panel.getPanelCost());
		panelEntity.setProperty("panelRRP", panel.getPanelRRP());
		panelEntity.setProperty("panelLifeYears", panel.getPanelLifeYears());
		panelEntity.setProperty("entryDate", date);

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		datastore.put(panelEntity);
	}

	/**
	 * Convert a datastore entity that represents a solar panel into a SolarPanel object.
	 * @param panelEntity
	 * @return A SolarPanel object with information based on the entity.
	 */
	private SolarPanel convertPanelEntity(Entity panelEntity) {
		SolarPanel panel = new SolarPanel();
		panel.setPanelName(panelEntity.getProperty("panelName").toString());
		panel.setPanelManufacturer(panelEntity.getProperty("panelManufacturer")
				.toString());
		panel.setPanelManufacturerCode(panelEntity.getProperty(
				"panelManufacturerCode").toString());
		panel.setPanelWattage(Double.parseDouble(panelEntity.getProperty(
				"panelWattage").toString()));
		panel.setPanelLossYear(Double.parseDouble(panelEntity.getProperty(
				"panelLossYear").toString()));
		panel.setPanelCost(Double.parseDouble(panelEntity.getProperty(
				"panelCost").toString()));
		panel.setPanelRRP(Double.parseDouble(panelEntity
				.getProperty("panelRRP").toString()));
		panel.setPanelLifeYears(Integer.parseInt(panelEntity.getProperty(
				"panelLifeYears").toString()));
		return panel;
	}

	/**
	 * Retrieve a single solar panels information based on the panel name.
	 * @param panelName The name of the panel to retrieve from the data store.
	 * @return A SolarPanel object with information based on the entity.
	 */
	public SolarPanel getPanelInformation(String panelName) {

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query query = new Query("panels").setFilter(new FilterPredicate(
				"panelName", Query.FilterOperator.EQUAL, panelName));
		return convertPanelEntity(datastore.prepare(query).asSingleEntity());
	}

	/**
	 * Retrieve a list of all solar panels that are available within the datastore.
	 * @return A List of SolarPanels.
	 */
	public List<SolarPanel> getAllPanels() {

		ArrayList<SolarPanel> panelArrayList = new ArrayList<SolarPanel>();

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query query = new Query("panels").addSort("panelManufacturer",
				Query.SortDirection.ASCENDING);

		List<Entity> panelEntities = datastore.prepare(query).asList(
				FetchOptions.Builder.withDefaults());

		for (Entity panelEntity : panelEntities) {
			panelArrayList.add(convertPanelEntity(panelEntity));
		}
		return panelArrayList;
	}

}
