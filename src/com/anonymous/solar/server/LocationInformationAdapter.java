package com.anonymous.solar.server;

import java.util.List;

import com.anonymous.solar.server.jaxws.*;
import com.anonymous.solar.shared.*;

public class LocationInformationAdapter {

	private LocationInformation location = new LocationInformation();
	
	public StoreLocationGetAllResponse getAllLocations(){
		List<LocationData> locData = location.StoreLocationGetAll();
		StoreLocationGetAllResponse response = new StoreLocationGetAllResponse();
		response.setReturn(locData);
		return response;
	}
	
	public StoreLocationInformationResponse storeLocation(StoreLocationInformation request){
		LocationData store = request.getArg0();
		Long Key = location.StoreLocationInformation(store);
		StoreLocationInformationResponse response = new StoreLocationInformationResponse();
		response.setReturn(Key);
		return response;
	}
	
}
