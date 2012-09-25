package com.anonymous.solar.shared;

public class TariffRate {
	
	String provider;
	String state;
	double feedInFee;
	double tariff11Cost;
	double tariff33Cost;
	double tariff11Fee;
	double tariff33Fee;
	
	public TariffRate(){
		this.provider = "";
		this.state = "";
		this.feedInFee = 0;
		this.tariff11Cost = 0;
		this.tariff11Fee = 0;
		this.tariff33Cost = 0;
		this.tariff33Fee = 0;
	}
	
	public TariffRate(String provider, String state, double feedIn, double t11C, double t11F, double t33C,
			double t33F){
		this.provider = provider;
		this.state = state;
		this.feedInFee = feedIn;
		this.tariff11Cost = t11C;
		this.tariff11Fee = t11F;
		this.tariff33Cost = t33C;
		this.tariff33Fee = t33C;
	}
	
	/****************************
	 * Getters
	 ****************************/
	public String getProvider(){
		return provider;
	}
	
	public String getState(){
		return state;
	}
	
	public double getFeedInFee(){
		return feedInFee;
	}
	
	public double gettariff11Cost(){
		return tariff11Cost;
	}
	
	public double gettariff11Fee(){
		return tariff11Fee;
	}
	
	public double gettariff33Cost(){
		return tariff33Cost;
	}
	
	public double gettariff33Fee(){
		return tariff33Fee;
	}
	
	/****************************
	 * Setters
	 ****************************/
	public void setProvider(String provider){
		this.provider = provider;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public void setFeedInFee(double feedInFee){
		this.feedInFee = feedInFee;
	}
	
	public void settariff11Cost(double t11C){
		this.tariff11Cost = t11C;
	}
	
	public void settariff11Fee(double t11F){
		this.tariff11Fee = t11F;
	}
	
	public void settariff33Cost(double t33C){
		this.tariff33Cost = t33C;
	}
	
	public void settariff33Fee(double t33F){
		this.tariff33Fee = t33F;
	}
}
