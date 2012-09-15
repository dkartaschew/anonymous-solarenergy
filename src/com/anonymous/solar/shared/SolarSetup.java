/**
 * 
 */
package com.anonymous.solar.shared;

import java.util.ArrayList;

/**
 * Class to hold and work on Solar Installation components, namely inverters
 * themselves.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class SolarSetup {

	private ArrayList<SolarPanels> panels = new ArrayList<SolarPanels>();
	private SolarInverter inverter = null;
	private Double wireLength = 0.00;
	private Double wireEfficiency = 100.00;
	private LocationData locationInformation = null;
	private CustomerData customerData = new CustomerData();
	private String setupName = null;
	private String setupDescription = null;

	public SolarSetup() {

	}

	public SolarSetup(ArrayList<SolarPanels> panels, SolarInverter invertor, Double wireLength, Double wireEfficiency,
			LocationData location, CustomerData customerData, String setupName, String setupDescription) {
		this.panels = panels;
		this.inverter = invertor;
		this.wireLength = wireLength;
		this.wireEfficiency = wireEfficiency;
		this.locationInformation = location;
		this.customerData = customerData;
		this.setupName = setupName;
		this.setupDescription = setupDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inverter == null) ? 0 : inverter.hashCode());
		result = prime * result + ((panels == null) ? 0 : panels.hashCode());
		result = prime * result + ((wireEfficiency == null) ? 0 : wireEfficiency.hashCode());
		result = prime * result + ((wireLength == null) ? 0 : wireLength.hashCode());
		result = prime * result + ((customerData == null) ? 0 : customerData.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SolarSetup other = (SolarSetup) obj;
		if (inverter == null) {
			if (other.inverter != null) {
				return false;
			}
		} else if (!inverter.equals(other.inverter)) {
			return false;
		}
		if (panels == null) {
			if (other.panels != null) {
				return false;
			}
		} else if (!panels.equals(other.panels)) {
			return false;
		}
		if (wireEfficiency == null) {
			if (other.wireEfficiency != null) {
				return false;
			}
		} else if (!wireEfficiency.equals(other.wireEfficiency)) {
			return false;
		}
		if (wireLength == null) {
			if (other.wireLength != null) {
				return false;
			}
		} else if (!wireLength.equals(other.wireLength)) {
			return false;
		}

		if (customerData == null) {
			if (other.customerData != null) {
				return false;
			}
		} else if (!customerData.equals(other.customerData)) {
			return false;
		}
		return true;
	}

	/**
	 * get the object that holds the customer data.
	 * 
	 * @return
	 */
	public CustomerData getCustomerData() {
		return customerData;
	}

	/**
	 * Set the object that will hold the customer data.
	 * 
	 * @param customerData
	 */
	public void setCustomerData(CustomerData customerData) {
		this.customerData = customerData;
	}

	/**
	 * getter for setup name
	 * @return
	 */
	public String getSetupName() {
		return setupName;
	}

	/**
	 * setter for setup name
	 * @param setupName
	 */
	public void setSetupName(String setupName) {
		this.setupName = setupName;
	}

	/**
	 * getter for setup description
	 * @return
	 */
	public String getSetupDescription() {
		return setupDescription;
	}

	/**
	 * setter for setup description.
	 * @param setupDescription
	 */
	public void setSetupDescription(String setupDescription) {
		this.setupDescription = setupDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String details = "<html>";
		int panelCount = panels.size();

		//Setup name and description
		details += "<b>System Name:</b> ";
		details += setupName + "<br /><br />";
		details += "<b>System Description:</b><br />";
		details += setupDescription + "<br /><br />";
		
		// Location information
		details += "<b>Location:</b><br />";
		details += locationInformation.toString(false) + "<br />";	
		
		//Panel Data
		details += "<b>Panel Details:</b><br />";
		details += "You have " + panelCount + " types of panels.<br />";
		try {
			details += panelTimeBreakdown(10.0).direction();
		} catch (SolarPanelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SolarPanelsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(SolarPanels panel : panels){
			details += panel.getPanelType().toString(false) + "<br />";		
		}
		
		//Inverter details
		details += "<b>Inverter Details</b><br />";
		details += inverter.toString(false)+"<br />";
		
		//Customer details
		details += "<b>Customer Details</b><br />";
		details += customerData.toString(false)+"<br /></html>";
		
		return details;
	}
	
	/**
	 * The method will get the inverter efficiency at the specified number of years after use
	 * @param years - the number of years to get data for
	 * @return double representing the new inverter efficiency
	 * @throws Exception 
	 */
	public double DetermineInverterLoss(double years) throws Exception{	
		if(years < 0){
			throw new Exception();
		}
		
		double currentEff = inverter.getInverterEfficiency();
		double loss = inverter.getInverterLossYear() / 100;
		
		return currentEff * Math.pow((1 - loss), years);
	}
	
	/**
	 * Determines how long it will take for the inverter to reach a specified efficiency
	 * @param efficiency - the efficiency the inverter should reach
	 * @return A double representing time
	 */
	public double LengthUntilInverter(double newEff){
		
		double currEff = inverter.getInverterEfficiency();
		double loss = inverter.getInverterLossYear() / 100;
		
		double first = Math.log10(newEff / currEff);
		double second =  Math.log10(1 - loss);
		
		return  first / second;
	}
	
	
	/**
	 * Calculates the quality of the panels are the specified period of time
	 * @param years - the number of years of operation to account for
	 * @return - A PanelBreakDown of all panels in the system.
	 * @throws SolarPanelException
	 * @throws SolarPanelsException 
	 */
	private PanelBreakDown panelTimeBreakdown(Double years) throws SolarPanelException, SolarPanelsException{
		PanelBreakDown breakDown = new PanelBreakDown(years);
		
		for(SolarPanels panelz : panels){
			breakDown.AddPanels(panelz);		
		}		
		return breakDown;
	}

	/**
	 * @return the invertor
	 */
	public SolarInverter getInverter() {
		return inverter;
	}

	/**
	 * @param invertor
	 *            the invertor to set
	 */
	public void setInverter(SolarInverter invertor) {
		this.inverter = invertor;
	}

	/**
	 * @return the wireLength
	 */
	public Double getWireLength() {
		return wireLength;
	}

	/**
	 * @param wireLength
	 *            the wireLength to set
	 */
	public void setWireLength(Double wireLength) {
		this.wireLength = wireLength;
	}

	/**
	 * @return the wireEfficiency
	 */
	public Double getWireEfficiency() {
		return wireEfficiency;
	}

	/**
	 * @param wireEfficiency
	 *            the wireEfficiency to set
	 */
	public void setWireEfficiency(Double wireEfficiency) {
		this.wireEfficiency = wireEfficiency;
	}

	public boolean addPanels(SolarPanels panels) {
		return this.panels.add(panels);
	}

	public boolean removePanels(SolarPanels panels) {
		return this.panels.remove(panels);
	}

	public ArrayList<SolarPanels> getPanels() {
		return panels;
	}

	
	/**
	 * @return the locationLongitude
	 */
	public LocationData getLocation() {
		return locationInformation;
	}

	/**
	 * @param locationLongitude
	 *            the locationLongitude to set
	 */
	public void setLocation(LocationData location) {
		this.locationInformation = location;
	}

}
