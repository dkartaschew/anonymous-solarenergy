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

	private final String PANEL_ENTITY_NAME = "panels";
	
	/**
	 * Store a new panel into the local datastore
	 * @param panel The panel information to be stored in the datastore
	 */
	public void storePanel(SolarPanel panel) {
		Date date = new Date();
		Entity panelEntity = new Entity(PANEL_ENTITY_NAME);
		panelEntity.setProperty(SolarPanel.PANEL_MANUFACTURER,
				panel.getPanelManufacturer());
		panelEntity.setProperty(SolarPanel.PANEL_MANUFACTURER_CODE,
				panel.getPanelManufacturerCode());
		panelEntity.setProperty(SolarPanel.PANEL_NAME, panel.getPanelName());
		panelEntity.setProperty(SolarPanel.PANEL_WATTAGE, panel.getPanelWattage());
		panelEntity.setProperty(SolarPanel.PANEL_LOSS_YEAR, panel.getPanelLossYear());
		panelEntity.setProperty(SolarPanel.PANEL_PANEL_COST, panel.getPanelCost());
		panelEntity.setProperty(SolarPanel.PANEL_RRP, panel.getPanelRRP());
		panelEntity.setProperty(SolarPanel.PANEL_LIFE_YEARS, panel.getPanelLifeYears());
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
		panel.setPanelName(panelEntity.getProperty(SolarPanel.PANEL_NAME).toString());
		panel.setPanelManufacturer(panelEntity.getProperty(SolarPanel.PANEL_MANUFACTURER)
				.toString());
		panel.setPanelManufacturerCode(panelEntity.getProperty(
				SolarPanel.PANEL_MANUFACTURER_CODE).toString());
		panel.setPanelWattage(Double.parseDouble(panelEntity.getProperty(
				SolarPanel.PANEL_WATTAGE).toString()));
		panel.setPanelLossYear(Double.parseDouble(panelEntity.getProperty(
				SolarPanel.PANEL_LOSS_YEAR).toString()));
		panel.setPanelCost(Double.parseDouble(panelEntity.getProperty(
				SolarPanel.PANEL_PANEL_COST).toString()));
		panel.setPanelRRP(Double.parseDouble(panelEntity
				.getProperty(SolarPanel.PANEL_RRP).toString()));
		panel.setPanelLifeYears(Integer.parseInt(panelEntity.getProperty(
				SolarPanel.PANEL_LIFE_YEARS).toString()));
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
		Query query = new Query(PANEL_ENTITY_NAME).setFilter(new FilterPredicate(
				SolarPanel.PANEL_NAME, Query.FilterOperator.EQUAL, panelName));
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
		Query query = new Query(PANEL_ENTITY_NAME).addSort(SolarPanel.PANEL_MANUFACTURER,
				Query.SortDirection.ASCENDING);

		List<Entity> panelEntities = datastore.prepare(query).asList(
				FetchOptions.Builder.withDefaults());

		for (Entity panelEntity : panelEntities) {
			panelArrayList.add(convertPanelEntity(panelEntity));
		}
		return panelArrayList;
	}

}
