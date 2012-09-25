package com.anonymous.solar.server;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.TariffRate;

@WebService
public class TRate {
	
	private DataStoreUtils dsutils = new DataStoreUtils();
	
	@WebMethod
	public List<TariffRate>  getTariffRates(){
		return dsutils.getAllTariffs();
	}
	
	@WebMethod
	public boolean insertTariffRate(TariffRate panel){
		dsutils.storeTariffRate(panel);
		return true;
	}
	
	@WebMethod
	public boolean removeTariffRate(Long key){
		dsutils.removeTariffRate(key);
		return true;
	}
}
