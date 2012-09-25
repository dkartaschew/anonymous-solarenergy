package com.anonymous.solar.server;

import java.util.List;

import com.anonymous.solar.server.jaxws.*;
import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.shared.SolarInverter;
import com.anonymous.solar.shared.SolarPanel;
import com.anonymous.solar.shared.TariffRate;

public class TRateAdapter {
	
	private TRate tRate = new TRate();
	
	public GetTariffRatesResponse getTariffRates(){
		List<TariffRate> tarData = tRate.getTariffRates();
		GetTariffRatesResponse response = new GetTariffRatesResponse();
		response.setReturn(tarData);
		return response;
	}
	
	public InsertTariffRateResponse insertTariffRate(InsertTariffRate request){
		TariffRate store = request.getArg0();
		boolean success = tRate.insertTariffRate(store);
		InsertTariffRateResponse response = new InsertTariffRateResponse();
		response.setReturn(success);
		return response;
	}
	
	public RemoveTariffRateResponse removeTariffRate(RemoveTariffRate request){
		Long key = request.getArg0();
		boolean success = tRate.removeTariffRate(key);
		RemoveTariffRateResponse response = new RemoveTariffRateResponse();
		response.setReturn(success);
		return response;
	}

}
