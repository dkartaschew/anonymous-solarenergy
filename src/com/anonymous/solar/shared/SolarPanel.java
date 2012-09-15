/**
 * 
 */
package com.anonymous.solar.shared;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;






import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solarPanel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solarPanel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="panelCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="panelLifeYears" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="panelLossYear" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="panelManufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="panelManufacturerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="panelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="panelRRP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="panelWattage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solarPanel", propOrder = {
		"INITIAL_VALUES",
		"key",	
    "panelCost",
    "panelLifeYears",
    "panelLossYear",
    "panelManufacturer",
    "panelManufacturerCode",
    "panelName",
    "panelRRP",
    "panelWattage"
})
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
	private Long key;

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

	/*
	 * Default parameter names to ensure consistency among all consumers of the
	 * class.
	 */
	public static final String PANEL_NAME = "panelName";
	public static final String PANEL_MANUFACTURER = "panelManufacturer";
	public static final String PANEL_MANUFACTURER_CODE = "panelManufacturerCode";
	public static final String PANEL_WATTAGE = "panelWattage";
	public static final String PANEL_LOSS_YEAR = "panelLossYear";
	public static final String PANEL_PANEL_COST = "panelCost";
	public static final String PANEL_RRP = "panelRRP";
	public static final String PANEL_LIFE_YEARS = "panelLifeYears";

	/**
	 * Default constructor for class, defaults all string values to "", and all
	 * number values to 0.00;
	 */
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

	/**
	 * Deafult constructor to take all parameters in one construct.
	 * 
	 * @param panelName
	 *            Name of the panel.
	 * @param panelManufacturer
	 *            Name of the manufacturer.
	 * @param panelManufacturerCode
	 *            Manufacturers code for the panel.
	 * @param panelWattage
	 *            Maximum output wattage under ideal conditions for the panel.
	 * @param panelLossYear
	 *            Expected efficiency loss (in percent) for the panel over 12
	 *            months.
	 * @param panelCost
	 *            Nominal cost of the panel.
	 * @param panelRRP
	 *            Expected RRP cost of the panel.
	 * @param panelLifeYears
	 *            Expected life of the panel according to manufacturers
	 *            specification.
	 * @throws Exception
	 *             if: Name, Manufacturer or Manufacturer code is null, or if
	 *             Wattage, Loss, Cost, RRP or Life is less than 0.
	 */
	public SolarPanel(String panelName, String panelManufacturer, String panelManufacturerCode, Double panelWattage,
			Double panelLossYear, Double panelCost, Double panelRRP, Integer panelLifeYears) throws SolarPanelException {
		setPanelName(panelName);
		setPanelManufacturer(panelManufacturer);
		setPanelManufacturerCode(panelManufacturerCode);
		setPanelWattage(panelWattage);
		setPanelLossYear(panelLossYear);
		setPanelCost(panelCost);
		setPanelRRP(panelRRP);
		setPanelLifeYears(panelLifeYears);
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

	/**
	 * Returns the datastore key if this panel has been stored in the GAE
	 * datastore.
	 * 
	 * @return Panel Key
	 */
	public Long getKey() {
		return key;
	}

	/**
	 * Returns the nominal cost of the panel.
	 * 
	 * @return the panelCost
	 */
	public Double getPanelCost() {
		return panelCost;
	}

	/**
	 * Returns the expected life of the panel according to manufacturers
	 * specification.
	 * 
	 * @return the panelLifeYears
	 */
	public Integer getPanelLifeYears() {
		return panelLifeYears;
	}

	/**
	 * Returns the expected efficiency loss of the panel per 12 months under
	 * ideal conditions.
	 * 
	 * @return the panelLossYear
	 */
	public Double getPanelLossYear() {
		return panelLossYear;
	}

	/**
	 * Returns a string containing the manufacturers name of the panel.
	 * 
	 * @return the panelManufacturer
	 */
	public String getPanelManufacturer() {
		return panelManufacturer;
	}

	/**
	 * Returns a string containing the manufacturers code for the panel.
	 * 
	 * @return the panelManufacturerCode
	 */
	public String getPanelManufacturerCode() {
		return panelManufacturerCode;
	}

	/**
	 * Returns the Descriptive name of the panel, as used by the manufacturer.
	 * 
	 * @return the panelName
	 */
	public String getPanelName() {
		return panelName;
	}

	/**
	 * Returns the expected recommended retail price of the panel, to be used
	 * within calculations.
	 * 
	 * @return the panelRRP
	 */
	public Double getPanelRRP() {
		return panelRRP;
	}

	/**
	 * Returns the maximum output of the solar panel under ideal conditions.
	 * 
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
		result = prime * result + ((panelCost == null) ? 0 : panelCost.hashCode());
		result = prime * result + ((panelLifeYears == null) ? 0 : panelLifeYears.hashCode());
		result = prime * result + ((panelLossYear == null) ? 0 : panelLossYear.hashCode());
		result = prime * result + ((panelManufacturer == null) ? 0 : panelManufacturer.hashCode());
		result = prime * result + ((panelManufacturerCode == null) ? 0 : panelManufacturerCode.hashCode());
		result = prime * result + ((panelName == null) ? 0 : panelName.hashCode());
		result = prime * result + ((panelRRP == null) ? 0 : panelRRP.hashCode());
		result = prime * result + ((panelWattage == null) ? 0 : panelWattage.hashCode());
		return result;
	}

	/**
	 * Set the expected nominal cost of the panel.
	 * 
	 * @param panelCost
	 *            The cost of the panel in $
	 * @throws Exception
	 *             If the cost is null, or negative.
	 */
	public void setPanelCost(Double panelCost) throws SolarPanelException {
		if ((panelCost == null) || (panelCost.doubleValue() < 0.00)) {
			throw new SolarPanelException("Panel cost is below 0.00");
		}
		this.panelCost = panelCost;
	}

	/**
	 * Set the expected life of the panel in years.
	 * 
	 * @param panelLifeYears
	 *            The number of years the panel is expected to last, before
	 *            replacement.
	 * @throws Exception
	 *             If the life is null, or negative.
	 */
	public void setPanelLifeYears(Integer panelLifeYears) throws SolarPanelException {
		if ((panelLifeYears == null) || (panelLifeYears.intValue() < 0)) {
			throw new SolarPanelException("Panel life is below 0 years");
		}
		this.panelLifeYears = panelLifeYears;
	}

	/**
	 * Set the expected efficiency loss of the panel as a percentage. eg 1.00 =
	 * 1% loss per year.
	 * 
	 * @param panelLossYear
	 *            The expected efficency loss of the panel per year
	 * @throws Exception
	 *             If the loss is null or negative.
	 */
	public void setPanelLossYear(Double panelLossYear) throws SolarPanelException {
		if ((panelLossYear == null) || (panelLossYear.doubleValue() < 0.00)) {
			throw new SolarPanelException("Panel Loss value is below 0.00");
		}
		this.panelLossYear = panelLossYear;
	}

	/**
	 * Set the manufacturers name for the panel.
	 * 
	 * @param panelManufacturer
	 *            A string containing the manufacturers name.
	 * @throws Exception
	 *             If the string supplied is null.
	 */
	public void setPanelManufacturer(String panelManufacturer) throws SolarPanelException {
		if ((panelManufacturer == null)) {
			throw new SolarPanelException("Panel Manufacturer given null string");
		}
		this.panelManufacturer = panelManufacturer;
	}

	/**
	 * Set the Manufacturers Code for the panel.
	 * 
	 * @param panelManufacturerCode
	 *            The code for the panel.
	 * @throws Exception
	 *             If the string supplied is null.
	 */
	public void setPanelManufacturerCode(String panelManufacturerCode) throws SolarPanelException {
		if ((panelManufacturerCode == null)) {
			throw new SolarPanelException("Panel Manufacturer Code given null string");
		}
		this.panelManufacturerCode = panelManufacturerCode;
	}

	/**
	 * Set the descriptive name for the panel as given by the manufacturer
	 * 
	 * @param panelName
	 *            The name of the panel
	 * @throws Exception
	 *             If the string supplied is null.
	 */
	public void setPanelName(String panelName) throws SolarPanelException {
		if ((panelName == null)) {
			throw new SolarPanelException("Panel Name given null string");
		}
		this.panelName = panelName;
	}

	/**
	 * Set the Recommended Retail Price of the panel, to be used within the cost
	 * calculations.
	 * 
	 * @param panelRRP
	 *            The rrp for the panel.
	 * @throws Exception
	 *             If the rrp is null, a negative value, or below the cost.
	 */
	public void setPanelRRP(Double panelRRP) throws SolarPanelException {
		if ((panelRRP == null) || (panelRRP.doubleValue() < 0.00)
				|| (panelRRP.doubleValue() < this.panelCost.doubleValue())) {
			throw new SolarPanelException("Panel RRP is below $0.00, or below the cost of the panel");
		}
		this.panelRRP = panelRRP;
	}

	/**
	 * Set the expected maximum wattage output of the panel under ideal
	 * conditions.
	 * 
	 * @param panelWattage
	 *            the maximum expected wattage of the panel under ideal
	 *            conditions.
	 * @throws Exception
	 *             If the wattage is null or negative.
	 */
	public void setPanelWattage(Double panelWattage) throws SolarPanelException {
		if ((panelWattage == null) || (panelWattage.doubleValue() < 0.00)) {
			throw new SolarPanelException("Panel wattage given as negative");
		}
		this.panelWattage = panelWattage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	//@Override
	/*public String toString() {
		return "SolarPanel [panelName=" + panelName + ", panelManufacturer=" + panelManufacturer
				+ ", panelManufacturerCode=" + panelManufacturerCode + ", panelWattage=" + panelWattage
				+ ", panelLossYear=" + panelLossYear + ", panelCost=" + panelCost + ", panelRRP=" + panelRRP
				+ ", panelLifeYears=" + panelLifeYears + "]";
	}*/
	@Override
	public String toString(){
		return getPanelName() + 
				" - Cost: $" + getPanelCost() + 
				" - Life: " + getPanelLifeYears() + " years" + 
				" - Wattage: " + getPanelWattage() + "W" + 
				" - Efficiency Loss: " + panelLossYear + "%";
	}
	
	public String toString(boolean htmlTags){
		if(htmlTags){
			return "<html><b>Name: " + panelName + "</b><br />"
					+ "Manufacturer: " + panelManufacturer + "<br />"
					+ "Code: " + panelManufacturerCode + "<br />"
					+ "Wattage: " + panelWattage + "<br />"
					+ "Loss/year: " + panelLossYear + "<br />"
					+ "Cost : $" + panelCost + "<br />"
					+ "RRP: $" + panelRRP + "<br />"
					+ "Life(years): " + panelLifeYears + "<br /></html>";
		} else {
			return "<b>Name: " + panelName + "</b><br />"
					+ "Manufacturer: " + panelManufacturer + "<br />"
					+ "Code: " + panelManufacturerCode + "<br />"
					+ "Wattage: " + panelWattage + "<br />"
					+ "Loss/year: " + panelLossYear + "<br />"
					+ "Cost : $" + panelCost + "<br />"
					+ "RRP: $" + panelRRP + "<br />"
					+ "Life(years): " + panelLifeYears + "<br />";
		}
	}

}
