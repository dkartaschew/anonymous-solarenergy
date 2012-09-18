/**
 * 
 */
package com.anonymous.solar.shared;

import com.anonymous.solar.shared.SolarPanelsException;

/**
 * Class to hold a collection of Solar Panels. themselves.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class SolarPanels {

	private SolarPanel panelType = null;
	private Integer panelCount;
	private Double panelDirection;
	private Double panelAzimuth;

	/**
	 * Default constructor
	 */
	public SolarPanels() {
		panelCount = 0;
		panelDirection = 0.00;
		panelAzimuth = 0.00;
	}

	/**
	 * Default Constructor.
	 * 
	 * @param panelType
	 *            The type of panel to be part of this collection of panels
	 * @param panelCount
	 *            The number of panels in the collection
	 * @param panelDirection
	 *            The direction of the panels in the collection (0 - 360)
	 * @param panelAzimuth
	 *            The azimuth of the panels in the collection (0 - 90)
	 * @throws SolarPanelsException
	 */
	public SolarPanels(SolarPanel panelType, Integer panelCount, Double panelDirection, Double panelAzimuth) {
		try {
			setPanelType(panelType);
			setPanelCount(panelCount);
			setPanelDirection(panelDirection);
			setPanelAzimuth(panelAzimuth);
		} catch (Exception e) {

		}
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
		result = prime * result + ((panelAzimuth == null) ? 0 : panelAzimuth.hashCode());
		result = prime * result + ((panelCount == null) ? 0 : panelCount.hashCode());
		result = prime * result + ((panelDirection == null) ? 0 : panelDirection.hashCode());
		result = prime * result + ((panelType == null) ? 0 : panelType.hashCode());
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
		SolarPanels other = (SolarPanels) obj;
		if (panelAzimuth == null) {
			if (other.panelAzimuth != null) {
				return false;
			}
		} else if (!panelAzimuth.equals(other.panelAzimuth)) {
			return false;
		}
		if (panelCount == null) {
			if (other.panelCount != null) {
				return false;
			}
		} else if (!panelCount.equals(other.panelCount)) {
			return false;
		}
		if (panelDirection == null) {
			if (other.panelDirection != null) {
				return false;
			}
		} else if (!panelDirection.equals(other.panelDirection)) {
			return false;
		}
		if (panelType == null) {
			if (other.panelType != null) {
				return false;
			}
		} else if (!panelType.equals(other.panelType)) {
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
		return "SolarPanels [panelType=" + panelType + ", panelCount=" + panelCount + ", panelDirection="
				+ panelDirection + ", panelAzimuth=" + panelAzimuth + "]";
	}

	/**
	 * Getter to return the type of panels that this group of panels holds.
	 * 
	 * @return the panelType
	 */
	public SolarPanel getPanelType() {
		return panelType;
	}

	/**
	 * Set the type pf panels that this group of panels should represent.
	 * 
	 * @param panelType
	 *            the panelType to set
	 * @throws SolarPanelException
	 * @exception If
	 *                the panel is null.
	 */
	public void setPanelType(SolarPanel panelType) throws SolarPanelsException {
		if (panelType == null) {
			throw new SolarPanelsException("The supplied panel type is null");
		}
		this.panelType = panelType;
	}

	/**
	 * Get the number of panels that are contained within this group of panels.
	 * 
	 * @return the panelCount
	 */
	public Integer getPanelCount() {
		return panelCount;
	}

	/**
	 * Set the number of panels that are contained within this group of panels.
	 * 
	 * @param panelCount
	 *            the panelCount to set
	 * @throws SolarPanelsException
	 * @exception if
	 *                the value passed is null or less than 0.
	 */
	public void setPanelCount(Integer panelCount) throws SolarPanelsException {
		if (panelCount == null || panelCount < 0) {
			throw new SolarPanelsException("The number of solar panels is null or less than zero (0)");
		}
		this.panelCount = panelCount;
	}

	/**
	 * Get the direction that the solar panels are facing.
	 * 
	 * @return the panelDirection
	 */
	public Double getPanelDirection() {
		return panelDirection;
	}

	/**
	 * Set the direction that the solar panels are facing.
	 * 
	 * @param panelDirection
	 *            the panelDirection to set
	 * @throws SolarPanelsException
	 * @exception If
	 *                the direction is null, or less than 0.00 or greater than
	 *                360.00
	 */
	public void setPanelDirection(Double panelDirection) throws SolarPanelsException {
		if (panelDirection == null) {
			throw new SolarPanelsException("The direction given is null");
		}
		if (panelDirection < 0.00 || panelDirection > 360.0) {
			throw new SolarPanelsException("The direction must be a value between 0 and 360.");
		}
		this.panelDirection = panelDirection;
	}

	/**
	 * Get the panel Azimuth
	 * 
	 * @return the panelAzimuth
	 */
	public Double getPanelAzimuth() {
		return panelAzimuth;
	}

	/**
	 * Set the panel Azimuth
	 * 
	 * @param panelAzimuth
	 *            the panelAzimuth to set
	 * @throws SolarPanelsException
	 * @exception if
	 *                the value is null, or less than 0 or greater than 90.
	 */
	public void setPanelAzimuth(Double panelAzimuth) throws SolarPanelsException {
		if (panelAzimuth == null) {
			throw new SolarPanelsException("The azimuth value is null");
		}
		if (panelAzimuth < 0.00 || panelAzimuth > 90.0) {
			throw new SolarPanelsException("The direction must be a value between 0 and 90.");
		}
		this.panelAzimuth = panelAzimuth;
	}

}
