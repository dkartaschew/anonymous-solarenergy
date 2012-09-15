package com.anonymous.solar.shared;

public class CustomerData {
	
	private final Double INITIAL_VALUES = 0.0;
	
	private Double dailyAverageUsage;
	private Double hourlyAverageUsage;
	private Double monthlyAverageUsage;
	
	private Double tariff11Cost;
	private Double tariff11Fee;
	private Double tariff13Cost;
	private Double tariff13Fee;
	
	private Double feedInFee;
	private Double annualTariffIncrease;
	
	public CustomerData(){
		dailyAverageUsage = INITIAL_VALUES;
		hourlyAverageUsage = INITIAL_VALUES;
		monthlyAverageUsage = INITIAL_VALUES;
		
		tariff11Cost = INITIAL_VALUES;
		tariff11Fee = INITIAL_VALUES;
		tariff13Cost = INITIAL_VALUES;
		tariff13Fee = INITIAL_VALUES;
		
		feedInFee = INITIAL_VALUES;
		annualTariffIncrease = INITIAL_VALUES;
	}
	
	
	/********************************************************
	 * GETTERS
	 ********************************************************/
	/**
	 * Return the estimated daily average kWh usage
	 * 
	 * @return average daily kWh usage
	 */
	public Double getDailyAverageUsage(){
		return dailyAverageUsage;
	}
	
	/**
	 * Return the estimated monthly average kWh usage
	 * 
	 * @return average daily kWh usage
	 */
	public Double getMonthlyAverageUsage(){
		return monthlyAverageUsage;
	}
	
	/**
	 * Return the estimated hourly average kWh usage
	 * 
	 * @return average daily kWh usage
	 */
	public Double getHourlyAverageUsage(){
		return hourlyAverageUsage;
	}
	
	/**
	 * Return the estimated cost per kWh for Tariff 11
	 * 
	 * @return Tariff 11 Cost
	 */
	public Double getTariff11Cost(){
		return tariff11Cost;
	}
	
	/**
	 * Return the estimated fee for tariff 11
	 * 
	 * @return Tariff 11 Fee
	 */
	public Double getTariff11Fee(){
		return tariff11Fee;
	}
	
	/**
	 * Return the estimated cost per kWh for Tariff 13
	 * 
	 * @return Tariff 13 Cost
	 */
	public Double getTariff13Cost(){
		return tariff13Cost;
	}
	
	/**
	 * Return the estimated fee for tariff 13
	 * 
	 * @return Tariff 13 Fee
	 */
	public Double getTariff13Fee(){
		return tariff13Fee;
	}
	
	/**
	 * Return the estimated feed in fee
	 * 
	 * @return Fee In Fee increase
	 */
	public Double getFeedInFee(){
		return feedInFee;
	}
	
	/**
	 * Return the estimated increase in tariff fees
	 * 
	 * @return Annual Increase in tariff fee
	 */
	public Double getAnnualTariffIncrease(){
		return annualTariffIncrease;
	}
	
	/********************************************************
	 * SETTERS
	 ********************************************************/
	/**
	 * Return the estimated daily average kWh usage
	 * 
	 */
	public void setDailyAverageUsage(Double newAverage){
		dailyAverageUsage = newAverage;
	}
	
	/**
	 * Return the estimated monthly average kWh usage
	 */
	public void setMonthlyAverageUsage(Double newAverage){
		monthlyAverageUsage = newAverage;
	}
	
	/**
	 * Set the estimated hourly average kWh usage
	 * 
	 */
	public void setHourlyAverageUsage(Double newAverage){
		hourlyAverageUsage = newAverage;
	}
	
	/**
	 * Set the estimated cost per kWh for Tariff 11
	 * 
	 */
	public void setTariff11Cost(Double newTariffCost){
		tariff11Cost = newTariffCost;
	}
	
	/**
	 * Set the estimated fee for tariff 11
	 * 
	 */
	public void setTariff11Fee(Double newTariffFee){
		tariff11Fee = newTariffFee;
	}
	
	/**
	 * Set the estimated cost per kWh for Tariff 13
	 * 
	 */
	public void setTariff13Cost(Double newTariffCost){
		tariff13Cost = newTariffCost;
	}
	
	/**
	 * Set the estimated fee for tariff 13
	 * 
	 */
	public void setTariff13Fee(Double newTariffFee){
		tariff13Fee = newTariffFee;
	}
	
	/**
	 * Set the estimated feed in fee
	 * 
	 */
	public void setFeedInFee(Double newFeedInFee){
		feedInFee = newFeedInFee;
	}
	
	/**
	 * Set the estimated increase in tariff fees
	 * 
	 */
	public void setAnnualTariffIncrease(Double newAnnualTariff){
		annualTariffIncrease = newAnnualTariff;
	}
	
	@Override
	public String toString(){
		return "Daily Average: " + dailyAverageUsage + "<br />"
				+ "Hourly Average: " + hourlyAverageUsage + "<br />"
				+ "Tariff 11 Cost: " +  tariff11Cost + "<br />"
				+ "Tariff 11 Fee: " + tariff11Fee + "<br />"
				+ "Tariff 13 Cost: " +  tariff13Cost + "<br />"
				+ "Tariff 13 Fee: " + tariff13Fee + "<br />"
				+ "Feed In Fee: " + feedInFee + "<br />"
				+ "Annual Tariff Increase: " + annualTariffIncrease + "<br />";
	}
	
	public String toString(boolean htmlTags){
		String about = "";
		
		if(htmlTags){
			about += "<html>";
		}
		
		about += "Daily Average: " + dailyAverageUsage + "<br />"
				 + "Hourly Average: " + hourlyAverageUsage + "<br />"
				 + "Tariff 11 Cost: " +  tariff11Cost + "<br />"
				 + "Tariff 11 Fee: " + tariff11Fee + "<br />"
				 + "Tariff 13 Cost: " +  tariff13Cost + "<br />"
				 + "Tariff 13 Fee: " + tariff13Fee + "<br />"
				 + "Feed In Fee: " + feedInFee + "<br />"
				 + "Annual Tariff Increase: " + annualTariffIncrease + "<br />";
		
		if(htmlTags){
			about += "</html>";
		}
		return about;
	}
	
}
