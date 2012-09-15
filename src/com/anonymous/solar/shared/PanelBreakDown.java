package com.anonymous.solar.shared;

import java.awt.List;
import java.util.ArrayList;

public class PanelBreakDown {
	
	ArrayList<SolarPanels> northPanels = new ArrayList<SolarPanels>();
	ArrayList<SolarPanels> eastPanels = new ArrayList<SolarPanels>();
	ArrayList<SolarPanels> southPanels = new ArrayList<SolarPanels>();
	ArrayList<SolarPanels> westPanels = new ArrayList<SolarPanels>();
	
	public PanelBreakDown(){
	}
	
	public void AddPanels(SolarPanels panels) throws SolarPanelException, SolarPanelsException{
		if (panels.getPanelDirection() < 45 || panels.getPanelDirection()  > 315){
			AddNorthPanel(panels);
		}
		else if(panels.getPanelDirection()  > 45 && panels.getPanelDirection()  < 135){
			AddEastPanel(panels);
		}
		else if(panels.getPanelDirection()  > 135 && panels.getPanelDirection()  < 225){
			AddSouthPanel(panels);
		}
		else if(panels.getPanelDirection()  > 225 && panels.getPanelDirection()  < 315){
			AddWestPanel(panels);
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
