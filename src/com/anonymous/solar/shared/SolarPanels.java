/**
 * 
 */
package com.anonymous.solar.shared;

/**
 * Class to hold and work on Solar Installation components, namely inverters
 * themselves.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class SolarPanels {

	private SolarPanel panelType = null;
	private Integer panelCount = 0;
	private Double panelDirection = 0.00;
	private Double panelAzimuth = 0.00;

	public SolarPanels() {
	}

	public SolarPanels(SolarPanel panelType, Integer panelCount, Double panelDirection, Double panelAzimuth) {
		this.panelType = panelType;
		this.panelCount = panelCount;
		this.panelDirection = panelDirection;
		this.panelAzimuth = panelAzimuth;
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
	 * @return the panelType
	 */
	public SolarPanel getPanelType() {
		return panelType;
	}

	/**
	 * @param panelType
	 *            the panelType to set
	 */
	public void setPanelType(SolarPanel panelType) {
		this.panelType = panelType;
	}

	/**
	 * @return the panelCount
	 */
	public Integer getPanelCount() {
		return panelCount;
	}

	/**
	 * @param panelCount
	 *            the panelCount to set
	 */
	public void setPanelCount(Integer panelCount) {
		this.panelCount = panelCount;
	}

	/**
	 * @return the panelDirection
	 */
	public Double getPanelDirection() {
		return panelDirection;
	}

	/**
	 * @param panelDirection
	 *            the panelDirection to set
	 */
	public void setPanelDirection(Double panelDirection) {
		this.panelDirection = panelDirection;
	}

	/**
	 * @return the panelAzimuth
	 */
	public Double getPanelAzimuth() {
		return panelAzimuth;
	}

	/**
	 * @param panelAzimuth
	 *            the panelAzimuth to set
	 */
	public void setPanelAzimuth(Double panelAzimuth) {
		this.panelAzimuth = panelAzimuth;
	}

}
