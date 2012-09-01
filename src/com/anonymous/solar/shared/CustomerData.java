package com.anonymous.solar.shared;

public class CustomerData {
	
	private final Double INITIAL_VALUES = 0.0;
	
	private Double dailyAverageUsage;
	private Double hourlyAverageUsage;
	
	private Double tariff11Cost;
	private Double tariff11Fee;
	private Double tariff13Cost;
	private Double tariff13Fee;
	
	private Double feedInFee;
	private Double annualTariffIncrease;
	
	public CustomerData(){
		dailyAverageUsage = INITIAL_VALUES;
		hourlyAverageUsage = INITIAL_VALUES;
		
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
	 * @return average daily kWh usage
	 */
	public void setDailyAverageUsage(double newAverage){
		dailyAverageUsage = newAverage;
	}
	
	/**
	 * Return the estimated hourly average kWh usage
	 * 
	 * @return average daily kWh usage
	 */
	public void setHourlyAverageUsage(double newAverage){
		hourlyAverageUsage = newAverage;
	}
	
	/**
	 * Return the estimated cost per kWh for Tariff 11
	 * 
	 * @return Tariff 11 Cost
	 */
	public void setTariff11Cost(double newTariffCost){
		tariff11Cost = newTariffCost;
	}
	
	/**
	 * Return the estimated fee for tariff 11
	 * 
	 * @return Tariff 11 Fee
	 */
	public void setTariff11Fee(double newTariffFee){
		tariff11Fee = newTariffFee;
	}
	
	/**
	 * Return the estimated cost per kWh for Tariff 13
	 * 
	 * @return Tariff 13 Cost
	 */
	public void setTariff13Cost(double newTariffCost){
		tariff13Cost = newTariffCost;
	}
	
	/**
	 * Return the estimated fee for tariff 13
	 * 
	 * @return Tariff 13 Fee
	 */
	public void setTariff13Fee(double newTariffFee){
		tariff13Fee = newTariffFee;
	}
	
	/**
	 * Return the estimated feed in fee
	 * 
	 * @return Fee In Fee increase
	 */
	public void setFeedInFee(double newFeedInFee){
		feedInFee = newFeedInFee;
	}
	
	/**
	 * Return the estimated increase in tariff fees
	 * 
	 * @return Annual Increase in tariff fee
	 */
	public void setAnnualTariffIncrease(double newAnnualTariff){
		annualTariffIncrease = newAnnualTariff;
	}
	
	@Override
	public String toString(){
		return "Daily Average: \t\t" + dailyAverageUsage + "\n"
				+ "Hourly Average: \t" + hourlyAverageUsage + "\n"
				+ "Tariff 11 Cost: \t\t" +  tariff11Cost + "\n"
				+ "Tariff 11 Fee: \t\t" + tariff11Fee + "\n"
				+ "Tariff 13 Cost: \t\t" +  tariff13Cost + "\n"
				+ "Tariff 13 Fee: \t\t" + tariff13Fee + "\n"
				+ "Feed In Fee: \t\t" + feedInFee + "\n"
				+ "Annual Tariff Increase: \t" + annualTariffIncrease + "\n";
	}
	
	public String toString(String indent){
		return    indent + "Daily Average: \t\t" + dailyAverageUsage + "\n"
				+ indent + "Hourly Average: \t" + hourlyAverageUsage + "\n"
				+ indent + "Tariff 11 Cost: \t\t" +  tariff11Cost + "\n"
				+ indent + "Tariff 11 Fee: \t\t" + tariff11Fee + "\n"
				+ indent + "Tariff 13 Cost: \t\t" +  tariff13Cost + "\n"
				+ indent + "Tariff 13 Fee: \t\t" + tariff13Fee + "\n"
				+ indent + "Feed In Fee: \t\t" + feedInFee + "\n"
				+ indent + "Annual Tariff Increase: \t" + annualTariffIncrease + "\n";
	}
	
}
