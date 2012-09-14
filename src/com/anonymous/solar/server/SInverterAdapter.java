package com.anonymous.solar.server;

import java.util.List;

import com.anonymous.solar.server.jaxws.*;
import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarPanel;

public class SInverterAdapter {
	
	private SInverter sInv = new SInverter();
	
	public GetInvertersResponse getPanels(){
		List<SolarInverter> invData = sInv.getInverters();
		GetInvertersResponse response = new GetInvertersResponse();
		response.setReturn(invData);
		return response;
	}
	
	public InsertInverterResponse insertPanel(InsertInverter request){
		SolarInverter store = request.getArg0();
		boolean success = sInv.insertInverter(store);
		InsertInverterResponse response = new InsertInverterResponse();
		response.setReturn(success);
		return response;
	}
	
	public RemoveInverterResponse removePanel(RemoveInverter request){
		Long key = request.getArg0();
		boolean success = sInv.removeInverter(key);
		RemoveInverterResponse response = new RemoveInverterResponse();
		response.setReturn(success);
		return response;
	}

}
