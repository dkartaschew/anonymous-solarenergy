package com.anonymous.solar.server;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.anonymous.solar.shared.LocationData;

@WebService
public class LocationInformation {
	
	/**
	 * Private instance of the underlying storage container.
	 */
	private DataStoreUtils dsutils = new DataStoreUtils();
	
	/**
	 * Store a new location information within the datastore
	 * @param location The Location Data to store
	 * @return The item key as stored in the datastore.
	 */
	@WebMethod
	public Long StoreLocationInformation(LocationData location){
		return dsutils.storeLocationData(location);
	}
	
	/**
	 * Retrieve all known locations from the datastore.
	 * @return List of all locations.
	 */
	@WebMethod
	public List<LocationData> StoreLocationGetAll(){
		return dsutils.getAllLocations();
	}
}
