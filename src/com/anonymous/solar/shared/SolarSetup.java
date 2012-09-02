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
	private Double locationLatitude = 0.00;
	private Double locationLongitude = 0.00;
	private CustomerData customerData = new CustomerData();
	private String setupName = null;
	private String setupDescription = null;

	public SolarSetup() {

	}

	public SolarSetup(ArrayList<SolarPanels> panels, SolarInverter invertor, Double wireLength, Double wireEfficiency,
			Double locationLatitude, Double locationLongitude, CustomerData customerData, String setupName, String setupDescription) {
		this.panels = panels;
		this.inverter = invertor;
		this.wireLength = wireLength;
		this.wireEfficiency = wireEfficiency;
		this.locationLatitude = locationLatitude;
		this.locationLongitude = locationLongitude;
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
		int count = 1;
		
		// TODO: Convert to using HTML for rendering.
		if(setupName != null && setupName.length() == 0){
			details += "<red>ERROR: NO NAME DETECTED</red>\n\n";
		} else {
			details += "<b>System Name:</b> " + setupName + "\n\n";
		}
		if(setupName != null){
		details += "DESCRIPTION: \n" + setupDescription + "\n\n";
		}

		
		if(panelCount == 0){
			details += "ERROR: NO PANELS DETECTED\n\n";
		} else {
			details += "You have " + panelCount + " types of panels.\n";
			
			for(SolarPanels panel : panels){
				details += "\t" + count + ") " + panel.getPanelCount() + " units of " 
				+ panel.getPanelType().getPanelName() + "\n"
				+ "\tDirection: \t\t" + panel.getPanelDirection() + "\n"
				+ "\tCost per unit: \t\t$" + panel.getPanelType().getPanelCost() + "\n"
				+ "\tWattage: \t\t" + panel.getPanelType().getPanelWattage() + "\n"
				+ "\tLife: \t\t" + panel.getPanelType().getPanelLifeYears() + "\n\n";
				
				count++;			
			}
			
		}//end if
		
		if(inverter == (null)){
			details += "ERROR: NO INVERTER DETECTED\n\n";
		} else {
			details += "Name: " + inverter.getInverterName() + "\n" 
					+ "\tWire Length: " + wireLength + "\n" 
					+ "\tWire Efficiency: " + wireEfficiency + "\n" 
					+ "\tWattage: \t\t" + inverter.getInverterWattage() + "W\n"
					+ "\tCost: \t\t$" + inverter.getInverterCost() + "\n"
					+ "\tLife: \t\t" + inverter.getInverterLifeYears() + "\n"
					+ "\tEfficiency: \t\t" + inverter.getInverterEfficiency() + "\n\n";
		}
		
		//Customer details are always set, no need to check
		details += "Customer Details\n";
		if(customerData.getDailyAverageUsage() == 0 && customerData.getHourlyAverageUsage() == 0){
			details += "WARNING: YOU USE NO ELECTRICITY. THIS SYSTEM IS POINTLESS\n";
		}
		details += customerData.toString("\t")+"</html>";
		return details;
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
	 * @return the locationLatitude
	 */
	public Double getLocationLatitude() {
		return locationLatitude;
	}

	/**
	 * @param locationLatitude
	 *            the locationLatitude to set
	 */
	public void setLocationLatitude(Double locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	/**
	 * @return the locationLongitude
	 */
	public Double getLocationLongitude() {
		return locationLongitude;
	}

	/**
	 * @param locationLongitude
	 *            the locationLongitude to set
	 */
	public void setLocationLongitude(Double locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

}
