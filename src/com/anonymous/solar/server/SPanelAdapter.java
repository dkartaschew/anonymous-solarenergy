package com.anonymous.solar.server;

import java.util.List;

import com.anonymous.solar.server.jaxws.*;
import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.SolarPanel;

public class SPanelAdapter {
	
	private SPanel sPan = new SPanel();
	
	public GetPanelsResponse getPanels(){
		List<SolarPanel> panData = sPan.getPanels();
		GetPanelsResponse response = new GetPanelsResponse();
		response.setReturn(panData);
		return response;
	}
	
	public InsertPanelResponse setPanel(InsertPanel request){
		SolarPanel store = request.getArg0();
		boolean success = sPan.insertPanel(store);
		InsertPanelResponse response = new InsertPanelResponse();
		response.setReturn(success);
		return response;
	}

}
