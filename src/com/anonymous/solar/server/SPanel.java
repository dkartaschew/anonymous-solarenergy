package com.anonymous.solar.server;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.anonymous.solar.shared.SolarPanel;

@WebService
public class SPanel {
	
	private DataStoreUtils dsutils = new DataStoreUtils();
	
	@WebMethod
	public List<SolarPanel>  getPanels(){
		return dsutils.getAllPanels();
	}
	@WebMethod
	public boolean insertPanel(SolarPanel panel){
		dsutils.storePanel(panel);
		return true;
	}
}
