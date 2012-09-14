package com.anonymous.solar.server;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarPanel;

@WebService
public class SInverter {
	
	private DataStoreUtils dsutils = new DataStoreUtils();
	
	@WebMethod
	public List<SolarInverter>  getInverters(){
		return dsutils.getAllInverters();
	}
	@WebMethod
	public boolean insertInverter(SolarInverter panel){
		dsutils.storeInverter(panel);
		return true;
	}
	
	@WebMethod
	public boolean removeInverter(Long key){
		dsutils.removeInverter(key);
		return true;
	}
}
