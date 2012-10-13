/**
 * 
 */
package com.anonymous.solar.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for solarSetup complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="solarSetup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerData" type="{http://server.solar.anonymous.com/}customerData" minOccurs="0"/>
 *         &lt;element name="inverter" type="{http://server.solar.anonymous.com/}solarInverter" minOccurs="0"/>
 *         &lt;element name="locationInformation" type="{http://server.solar.anonymous.com/}locationData" minOccurs="0"/>
 *         &lt;element name="setupDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="setupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="solarPanels" type="{http://server.solar.anonymous.com/}solarPanels" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wireEfficiency" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="wireLength" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solarSetup", propOrder = { "customerData", "inverter", "locationInformation", "setupDescription",
		"setupName", "solarPanels", "wireEfficiency", "wireLength" })
/**
 * Class to hold and work on Solar Installation components, namely inverters
 * themselves.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
@XmlRootElement
public class SolarSetup {

	protected CustomerData customerData;
	protected SolarInverter inverter;
	protected LocationData locationInformation;
	protected String setupDescription;
	protected String setupName;
	@XmlElement(nillable = true)
	protected List<SolarPanels> solarPanels;
	protected Double wireEfficiency;
	protected Double wireLength;

	public SolarSetup() {
		solarPanels = new ArrayList<SolarPanels>();
		customerData = new CustomerData();
	}

	public SolarSetup(ArrayList<SolarPanels> panels, SolarInverter invertor, Double wireLength, Double wireEfficiency,
			LocationData location, CustomerData customerData, String setupName, String setupDescription)
			throws SolarSetupException {

		setCustomerData(customerData);
		setInverter(invertor);
		setLocationInformation(location);
		setSetupDescription(setupDescription);
		setSetupName(setupName);
		setSolarPanels(panels);
		setWireEfficiency(wireEfficiency);
		setWireLength(wireLength);
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
		result = prime * result + ((solarPanels == null) ? 0 : solarPanels.hashCode());
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
		if (solarPanels == null) {
			if (other.solarPanels != null) {
				return false;
			}
		} else if (!solarPanels.equals(other.solarPanels)) {
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
	 * @throws SolarSetupException
	 *             if the customer data object is null
	 */
	public void setCustomerData(CustomerData customerData) throws SolarSetupException {
		if (customerData == null) {
			throw new SolarSetupException("The supplied customer object is null");
		}
		this.customerData = customerData;
	}

	/**
	 * Get the Setup name used by the application
	 * 
	 * @return Setup Name
	 */
	public String getSetupName() {
		return setupName;
	}

	/**
	 * Set the setup name
	 * 
	 * @param setupName
	 * @throws SolarSetupException
	 *             if the name is null or length = 0.
	 */
	public void setSetupName(String setupName) throws SolarSetupException {
		if (setupName == null || setupName.length() == 0) {
			throw new SolarSetupException("The supplied name is null");
		}
		this.setupName = setupName;
	}

	/**
	 * Get the setup description
	 * 
	 * @return Setup description
	 */
	public String getSetupDescription() {
		return setupDescription;
	}

	/**
	 * Set the setup description.
	 * 
	 * @param setupDescription
	 * @throws SolarSetupException
	 *             if the description is null.
	 */
	public void setSetupDescription(String setupDescription) throws SolarSetupException {
		if (setupDescription == null) {
			throw new SolarSetupException("The supplied description is null");
		}
		this.setupDescription = setupDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String details = "<html>";
		int panelCount = solarPanels.size();

		// Setup name and description
		details += "<b>System Name:</b> ";
		details += setupName + "<br /><br />";
		details += "<b>System Description:</b><br />";
		details += setupDescription + "<br /><br />";

		// Location information
		details += "<b>Location:</b><br />";
		details += locationInformation.toString(false) + "<br />";

		// Panel Data
		details += "<b>Panel Details:</b><br />";
		details += "You have " + panelCount + " types of panels.<br />";
		details += getDirectionBreakdown();

		for (SolarPanels panel : solarPanels) {
			details += panel.getPanelType().toString(false) + "<br />";
		}

		// Inverter details
		details += "<b>Inverter Details</b><br />";
		details += inverter.toString(false) + "<br />";

		// Customer details
		details += "<b>Customer Details</b><br />";
		details += customerData.toString(false) + "<br /></html>";

		return details;
	}

	/**
	 * Get information on the direction of each panel 
	 * @return = HTML about direction without <html> tags
	 */
	public String getDirectionBreakdown(){
		double north = GetDirectionalPanelsCount(Direction.NORTH);
		double east = GetDirectionalPanelsCount(Direction.EAST);
		double south = GetDirectionalPanelsCount(Direction.SOUTH);
		double west = GetDirectionalPanelsCount(Direction.WEST);
		double total = north + east + south + west;
		
		
		
		String direction = String.format("North Panels: %.2f %%<br/>", north/total*100);
		
		direction += String.format("East Panels: %.2f %%<br/>", east/total*100);
		direction += String.format("South Panels: %.2f %%<br/>", south/total*100);
		direction += String.format("West Panels: %.2f %%<br/><br/>", west/total*100);
		
		return direction;
	}
	
	public double GetDirectionalPanelsCount(Direction direction) {
		ArrayList<SolarPanels> directionalPanels = new ArrayList<SolarPanels>();

		switch (direction) {
		case NORTH:
			for (SolarPanels panelz : solarPanels) {
				if (panelz.getPanelDirection() <= 45 || panelz.getPanelDirection() > 315) {
					directionalPanels.add(panelz);
				}
			}
			break;
		case EAST:
			for (SolarPanels panelz : solarPanels) {
				if (panelz.getPanelDirection() > 45 && panelz.getPanelDirection() <= 135) {
					directionalPanels.add(panelz);
				}
			}
			break;
		case SOUTH:
			for (SolarPanels panelz : solarPanels) {
				if (panelz.getPanelDirection() > 135 && panelz.getPanelDirection() <= 225) {
					directionalPanels.add(panelz);
				}
			}
			break;
		case WEST:
			for (SolarPanels panelz : solarPanels) {
				if (panelz.getPanelDirection() > 225 && panelz.getPanelDirection() <= 315) {
					directionalPanels.add(panelz);
				}
			}
			break;
		}
		return directionalPanels.size();
	}
	
	/**
	 * Return all the panels that are orientated a set direction.
	 * 
	 * @param direction
	 *            The direction of panels requested.
	 * @return An arraylist of panels that face the specified direction.
	 */
	public ArrayList<SolarPanels> GetDirectionalPanels(Direction direction) {
		ArrayList<SolarPanels> directionalPanels = new ArrayList<SolarPanels>();

		switch (direction) {
		case NORTH:
			for (SolarPanels panelz : solarPanels) {
				if (panelz.getPanelDirection() <= 45 || panelz.getPanelDirection() > 315) {
					directionalPanels.add(panelz);
				}
			}
			break;
		case EAST:
			for (SolarPanels panelz : solarPanels) {
				if (panelz.getPanelDirection() > 45 && panelz.getPanelDirection() <= 135) {
					directionalPanels.add(panelz);
				}
			}
			break;
		case SOUTH:
			for (SolarPanels panelz : solarPanels) {
				if (panelz.getPanelDirection() > 135 && panelz.getPanelDirection() <= 225) {
					directionalPanels.add(panelz);
				}
			}
			break;
		case WEST:
			for (SolarPanels panelz : solarPanels) {
				if (panelz.getPanelDirection() > 225 && panelz.getPanelDirection() <= 315) {
					directionalPanels.add(panelz);
				}
			}
			break;
		}
		return directionalPanels;
	}

	/**
	 * The method will get the inverter efficiency at the specified number of
	 * years after use
	 * 
	 * @param years
	 *            - the number of years to get data for
	 * @return double representing the new inverter efficiency
	 * @throws Exception
	 */
	public double DetermineInverterLoss(double years) throws Exception {
		if (years < 0) {
			throw new Exception();
		}

		double currentEff = inverter.getInverterEfficiency();
		double loss = inverter.getInverterLossYear() / 100;

		return currentEff * Math.pow((1 - loss), years);
	}

	/**
	 * Determines how long it will take for the inverter to reach a specified
	 * efficiency
	 * 
	 * @param efficiency
	 *            - the efficiency the inverter should reach
	 * @return A double representing time
	 */
	public double LengthUntilInverter(double newEff) {

		double currEff = inverter.getInverterEfficiency();
		double loss = inverter.getInverterLossYear() / 100;

		double first = Math.log10(newEff / currEff);
		double second = Math.log10(1 - loss);

		return first / second;
	}

	/**
	 * Get the Inverter utilised in this setup.
	 * 
	 * @return the invertor
	 */
	public SolarInverter getInverter() {
		return inverter;
	}

	/**
	 * Set the inverter to be utilised in this setup.
	 * 
	 * @param invertor
	 *            the invertor to set
	 * @throws SolarSetupException
	 *             if the inverter is null.
	 */
	public void setInverter(SolarInverter invertor) throws SolarSetupException {
		if (invertor == null) {
			throw new SolarSetupException("The supplied Inverter was null");
		}
		this.inverter = invertor;
	}

	/**
	 * Get the arraylist of all solar panels that make up this installation.
	 * @return Array list of solar panels.
	 */
	public ArrayList<SolarPanels> getSolarPanels() {
		if (solarPanels == null) {
			solarPanels = new ArrayList<SolarPanels>();
		}
		return (ArrayList<SolarPanels>) solarPanels;
	}

	/**
	 * Set the entire array list of panels.
	 * @param solarPanels
	 * @throws SolarSetupException if the arraylist passed is null.
	 */
	public void setSolarPanels(ArrayList<SolarPanels> solarPanels) throws SolarSetupException {
		if (solarPanels == null) {
			throw new SolarSetupException("The supplied solarPanels was null");
		}
		this.solarPanels = solarPanels;
	}

	/**
	 * Get the location data for this installation.
	 * @return
	 */
	public LocationData getLocationInformation() {
		return locationInformation;
	}

	/**
	 * Set the location for this installation
	 * @param locationInformation
	 * @throws SolarSetupException if the installation information is null.
	 */
	public void setLocationInformation(LocationData locationInformation) throws SolarSetupException {
		if (locationInformation == null) {
			throw new SolarSetupException("The supplied locationInformation was null");
		}
		this.locationInformation = locationInformation;
	}

	/**
	 * Get the length of wiring utilised in the setup.
	 * 
	 * @return the wireLength
	 */
	public Double getWireLength() {
		return wireLength;
	}

	/**
	 * Set the length of wiring utilised in the setup
	 * @param wireLength
	 *            the wireLength to set
	 * @throws SolarSetupException If the length is null or less than 0.00
	 */
	public void setWireLength(Double wireLength) throws SolarSetupException {
		if (wireLength == null || wireLength < 0.00) {
			throw new SolarSetupException("The supplied wire Length was null or less than 0.00");
		}
		this.wireLength = wireLength;
	}

	/**
	 * Get the wire efficiency used in this installation.
	 * @return the wireEfficiency
	 */
	public Double getWireEfficiency() {
		return wireEfficiency;
	}

	/**
	 * Set the Wire efficiency as used in this installation.
	 * @param wireEfficiency
	 *            the wireEfficiency to set
	 * @throws SolarSetupException if the efficiency is null or less than 0.00
	 */
	public void setWireEfficiency(Double wireEfficiency) throws SolarSetupException {
		if (wireEfficiency == null || wireEfficiency < 0.00) {
			throw new SolarSetupException("The supplied wire Efficiency was null or less than 0.00");
		}
		this.wireEfficiency = wireEfficiency;
	}

	/**
	 * Add a group of panels to this solar setup.
	 * @param panelsthe SolarPanels to add.
	 * @return if the addition succeeded or not.
	 * @throws SolarSetupException if the panel information was null
	 */
	public boolean addPanels(SolarPanels panels) throws SolarSetupException {
		if (panels == null) {
			throw new SolarSetupException("The supplied panel information was null");
		}
		return this.solarPanels.add(panels);
	}

	/**
	 * Remove a group of panels from this solar setup.
	 * @param panels the SolarPanels to remove.
	 * @return if the removal succeeded or not.
	 * @throws SolarSetupException if the panels to be removed was null
	 */
	public boolean removePanels(SolarPanels panels) throws SolarSetupException {
		if (panels == null) {
			throw new SolarSetupException("The supplied panel information was null");
		}
		return this.solarPanels.remove(panels);
	}

}
