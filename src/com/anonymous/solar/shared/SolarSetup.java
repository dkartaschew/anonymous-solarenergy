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
	private SolarInverter invertor = null;
	private Double wireLength = 0.00;
	private Double wireEfficiency = 100.00;
	private Double locationLatitude = 0.00;
	private Double locationLongitude = 0.00;

	public SolarSetup() {
		
	}

	public SolarSetup(ArrayList<SolarPanels> panels, SolarInverter invertor, Double wireLength, Double wireEfficiency,
			Double locationLatitude, Double locationLongitude) {
		this.panels = panels;
		this.invertor = invertor;
		this.wireLength = wireLength;
		this.wireEfficiency = wireEfficiency;
		this.locationLatitude = locationLatitude;
		this.locationLongitude = locationLongitude;
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
		result = prime * result + ((invertor == null) ? 0 : invertor.hashCode());
		result = prime * result + ((panels == null) ? 0 : panels.hashCode());
		result = prime * result + ((wireEfficiency == null) ? 0 : wireEfficiency.hashCode());
		result = prime * result + ((wireLength == null) ? 0 : wireLength.hashCode());
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
		if (invertor == null) {
			if (other.invertor != null) {
				return false;
			}
		} else if (!invertor.equals(other.invertor)) {
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
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SolarSetup [panels=" + panels + ", invertor=" + invertor + ", wireLength=" + wireLength
				+ ", wireEfficiency=" + wireEfficiency + "]";
	}

	/**
	 * @return the invertor
	 */
	public SolarInverter getInvertor() {
		return invertor;
	}

	/**
	 * @param invertor
	 *            the invertor to set
	 */
	public void setInvertor(SolarInverter invertor) {
		this.invertor = invertor;
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
