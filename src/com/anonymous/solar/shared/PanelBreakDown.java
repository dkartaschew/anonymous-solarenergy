package com.anonymous.solar.shared;

import java.awt.List;
import java.util.ArrayList;

public class PanelBreakDown {
	
	ArrayList<SolarPanels> northPanels = new ArrayList<SolarPanels>();
	ArrayList<SolarPanels> eastPanels = new ArrayList<SolarPanels>();
	ArrayList<SolarPanels> southPanels = new ArrayList<SolarPanels>();
	ArrayList<SolarPanels> westPanels = new ArrayList<SolarPanels>();
	Double age;
	
	public PanelBreakDown(Double age){
		this.age = age;
	}
	
	private double DetermineLoss(double years, double loss){	
		final int MAX_EFFICIENCY = 100;
		return MAX_EFFICIENCY * Math.pow((1.0 - (loss / 100)), years);
	}
	
	private SolarPanels degradePanel(SolarPanels oldPanel, Double years) throws SolarPanelException{
		double newEfficiency = DetermineLoss(years, oldPanel.getPanelType().getPanelLossYear());
		double newWattage = newEfficiency / 100 * oldPanel.getPanelType().getPanelWattage();
		SolarPanel panel = new SolarPanel();
		SolarPanels panels;
		
		//Set Panel
		panel.setPanelCost(oldPanel.getPanelType().getPanelCost());
		panel.setPanelLifeYears(oldPanel.getPanelType().getPanelLifeYears());
		panel.setPanelLossYear(oldPanel.getPanelType().getPanelLossYear());
		panel.setPanelManufacturer(oldPanel.getPanelType().getPanelManufacturer());
		panel.setPanelManufacturerCode(oldPanel.getPanelType().getPanelManufacturerCode());
		panel.setPanelName(oldPanel.getPanelType().getPanelName());
		panel.setPanelRRP(oldPanel.getPanelType().getPanelRRP());
		panel.setPanelWattage(newWattage);
		
		//Set Panels
		panels = new SolarPanels(panel, oldPanel.getPanelCount(), oldPanel.getPanelDirection(),
				oldPanel.getPanelAzimuth());
		
		//Return
		return panels;
	}
	
	public void AddPanels(SolarPanels panels) throws SolarPanelException{
		if (panels.getPanelDirection() < 45 || panels.getPanelDirection()  > 315){
			AddNorthPanel(degradePanel(panels, age));
		}
		else if(panels.getPanelDirection()  > 45 && panels.getPanelDirection()  < 135){
			AddEastPanel(degradePanel(panels, age));
		}
		else if(panels.getPanelDirection()  > 135 && panels.getPanelDirection()  < 225){
			AddSouthPanel(degradePanel(panels, age));
		}
		else if(panels.getPanelDirection()  > 225 && panels.getPanelDirection()  < 315){
			AddWestPanel(degradePanel(panels, age));
		}
	}
	
	private void AddNorthPanel(SolarPanels panels){
		northPanels.add(panels);
	}

	private void AddEastPanel(SolarPanels panels){
		eastPanels.add(panels);
	}
	
	private void AddSouthPanel(SolarPanels panels){
		southPanels.add(panels);
	}
	
	private void AddWestPanel(SolarPanels panels){
		westPanels.add(panels);
	}
	
	public ArrayList<SolarPanels> getNorthPanels(){
		return northPanels;
	}
	
	public ArrayList<SolarPanels> getEastPanels(){
		return eastPanels;
	}
	
	public ArrayList<SolarPanels> getSouthPanels(){
		return southPanels;
	}
	
	public ArrayList<SolarPanels> getWestPanels(){
		return westPanels;
	}
	
	public Double getNorth(){
		Double count = 0.0;
		for(SolarPanels panels : northPanels){
			count += panels.getPanelCount();
		}
		return count;
			
	}
	
	public Double getEast(){
		Double count = 0.0;
		for(SolarPanels panels : eastPanels){
			count += panels.getPanelCount();
		}
		return count;
	}
	
	public Double getSouth(){
		Double count = 0.0;
		for(SolarPanels panels : southPanels){
			count += panels.getPanelCount();
		}
		return count;
	}
	
	public Double getWest(){
		Double count = 0.0;
		for(SolarPanels panels : westPanels){
			count += panels.getPanelCount();
		}
		return count;
	}
	
	public Double getTotal(){
		return getNorth() + getEast() + getSouth() + getWest();
	}
	
	public String direction(){
		String direction = "";
		Double total = getTotal();
		direction += "North Panels: " + ( getNorth() / total) * 100 + "%<br />";
		direction += "East Panels: " + (getEast() / total) * 100 + "%<br />";
		direction += "South Panels: " + (getSouth() / total) * 100 + "%<br />";
		direction += "West Panels: " + (getWest() / total) * 100 + "%<br />";
		return direction;
	}
	
	
	public String toString(){
		return "";
	}

}
