/**
 * 
 */
package com.anonymous.solar.shared;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Class to hold and work on Solar Installation components, namely panels
 * themselves.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */

@PersistenceCapable
public class SolarPanel {

	private final Double INITIAL_VALUES = 0.0;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;


	@Persistent
	private String panelName;
	@Persistent
	private String panelManufacturer;
	@Persistent
	private String panelManufacturerCode;
	@Persistent
	private Double panelWattage;
	@Persistent
	private Double panelLossYear;
	@Persistent
	private Double panelCost;
	@Persistent
	private Double panelRRP;
	@Persistent
	private Integer panelLifeYears;

	public static final String PANEL_NAME = "panelName";
	public static final String PANEL_MANUFACTURER = "panelManufacturer";
	public static final String PANEL_MANUFACTURER_CODE = "panelManufacturerCode";
	public static final String PANEL_WATTAGE = "panelWattage";
	public static final String PANEL_LOSS_YEAR = "panelLossYear";
	public static final String PANEL_PANEL_COST = "panelCost";
	public static final String PANEL_RRP = "panelRRP";
	public static final String PANEL_LIFE_YEARS = "panelLifeYears";

	public SolarPanel() {
		panelName = new String();
		panelManufacturer = new String();
		panelManufacturerCode = new String();
		panelWattage = INITIAL_VALUES;
		panelLossYear = INITIAL_VALUES;
		panelCost = INITIAL_VALUES;
		panelRRP = INITIAL_VALUES;
		panelLifeYears = 0;
	}

	public SolarPanel(String panelName, String panelManufacturer,
			String panelManufacturerCode, Double panelWattage,
			Double panelLossYear, Double panelCost, Double panelRRP,
			Integer panelLifeYears) {
		this.panelName = panelName;
		this.panelManufacturer = panelManufacturer;
		this.panelManufacturerCode = panelManufacturerCode;
		this.panelWattage = panelWattage;
		this.panelLossYear = panelLossYear;
		this.panelCost = panelCost;
		this.panelRRP = panelRRP;
		this.panelLifeYears = panelLifeYears;
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
		SolarPanel other = (SolarPanel) obj;
		if (panelCost == null) {
			if (other.panelCost != null) {
				return false;
			}
		} else if (!panelCost.equals(other.panelCost)) {
			return false;
		}
		if (panelLifeYears == null) {
			if (other.panelLifeYears != null) {
				return false;
			}
		} else if (!panelLifeYears.equals(other.panelLifeYears)) {
			return false;
		}
		if (panelLossYear == null) {
			if (other.panelLossYear != null) {
				return false;
			}
		} else if (!panelLossYear.equals(other.panelLossYear)) {
			return false;
		}
		if (panelManufacturer == null) {
			if (other.panelManufacturer != null) {
				return false;
			}
		} else if (!panelManufacturer.equals(other.panelManufacturer)) {
			return false;
		}
		if (panelManufacturerCode == null) {
			if (other.panelManufacturerCode != null) {
				return false;
			}
		} else if (!panelManufacturerCode.equals(other.panelManufacturerCode)) {
			return false;
		}
		if (panelName == null) {
			if (other.panelName != null) {
				return false;
			}
		} else if (!panelName.equals(other.panelName)) {
			return false;
		}
		if (panelRRP == null) {
			if (other.panelRRP != null) {
				return false;
			}
		} else if (!panelRRP.equals(other.panelRRP)) {
			return false;
		}
		if (panelWattage == null) {
			if (other.panelWattage != null) {
				return false;
			}
		} else if (!panelWattage.equals(other.panelWattage)) {
			return false;
		}
		return true;
	}

	public Key getKey() {
        return key;
    }

	
	/**
	 * @return the panelCost
	 */
	public Double getPanelCost() {
		return panelCost;
	}

	/**
	 * @return the panelLifeYears
	 */
	public Integer getPanelLifeYears() {
		return panelLifeYears;
	}

	/**
	 * @return the panelLossYear
	 */
	public Double getPanelLossYear() {
		return panelLossYear;
	}

	/**
	 * @return the panelManufacturer
	 */
	public String getPanelManufacturer() {
		return panelManufacturer;
	}

	/**
	 * @return the panelManufacturerCode
	 */
	public String getPanelManufacturerCode() {
		return panelManufacturerCode;
	}

	/**
	 * @return the panelName
	 */
	public String getPanelName() {
		return panelName;
	}

	/**
	 * @return the panelRRP
	 */
	public Double getPanelRRP() {
		return panelRRP;
	}

	/**
	 * @return the panelWattage
	 */
	public Double getPanelWattage() {
		return panelWattage;
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
		result = prime * result
				+ ((panelCost == null) ? 0 : panelCost.hashCode());
		result = prime * result
				+ ((panelLifeYears == null) ? 0 : panelLifeYears.hashCode());
		result = prime * result
				+ ((panelLossYear == null) ? 0 : panelLossYear.hashCode());
		result = prime
				* result
				+ ((panelManufacturer == null) ? 0 : panelManufacturer
						.hashCode());
		result = prime
				* result
				+ ((panelManufacturerCode == null) ? 0 : panelManufacturerCode
						.hashCode());
		result = prime * result
				+ ((panelName == null) ? 0 : panelName.hashCode());
		result = prime * result
				+ ((panelRRP == null) ? 0 : panelRRP.hashCode());
		result = prime * result
				+ ((panelWattage == null) ? 0 : panelWattage.hashCode());
		return result;
	}

	/**
	 * @param panelCost
	 *            the panelCost to set
	 */
	public void setPanelCost(Double panelCost) {
		this.panelCost = panelCost;
	}

	/**
	 * @param panelLifeYears
	 *            the panelLifeYears to set
	 */
	public void setPanelLifeYears(Integer panelLifeYears) {
		this.panelLifeYears = panelLifeYears;
	}

	/**
	 * @param panelLossYear
	 *            the panelLossYear to set
	 */
	public void setPanelLossYear(Double panelLossYear) {
		this.panelLossYear = panelLossYear;
	}

	/**
	 * @param panelManufacturer
	 *            the panelManufacturer to set
	 */
	public void setPanelManufacturer(String panelManufacturer) {
		this.panelManufacturer = panelManufacturer;
	}

	/**
	 * @param panelManufacturerCode
	 *            the panelManufacturerCode to set
	 */
	public void setPanelManufacturerCode(String panelManufacturerCode) {
		this.panelManufacturerCode = panelManufacturerCode;
	}

	/**
	 * @param panelName
	 *            the panelName to set
	 */
	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}

	/**
	 * @param panelRRP
	 *            the panelRRP to set
	 */
	public void setPanelRRP(Double panelRRP) {
		this.panelRRP = panelRRP;
	}

	/**
	 * @param panelWattage
	 *            the panelWattage to set
	 */
	public void setPanelWattage(Double panelWattage) {
		this.panelWattage = panelWattage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SolarPanel [panelName=" + panelName + ", panelManufacturer="
				+ panelManufacturer + ", panelManufacturerCode="
				+ panelManufacturerCode + ", panelWattage=" + panelWattage
				+ ", panelLossYear=" + panelLossYear + ", panelCost="
				+ panelCost + ", panelRRP=" + panelRRP + ", panelLifeYears="
				+ panelLifeYears + "]";
	}

}
