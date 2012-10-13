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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solarInverter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solarInverter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inverterCost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inverterEfficiency" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inverterLifeYears" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="inverterLossYear" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inverterManufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inverterManufacturerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inverterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inverterRRP" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="inverterWattage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solarInverter", propOrder = {
	"INITIAL_VALUES",
	"key",
    "inverterCost",
    "inverterEfficiency",
    "inverterLifeYears",
    "inverterLossYear",
    "inverterManufacturer",
    "inverterManufacturerCode",
    "inverterName",
    "inverterRRP",
    "inverterWattage"
})


/**
 * Class to hold and work on Solar Installation components, namely inverters
 * themselves.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
@PersistenceCapable
@XmlRootElement
public class SolarInverter {

	private final Double INITIAL_VALUES = 0.0;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;

	@Persistent
	private String inverterName;
	
	@Persistent
	private String inverterManufacturer;
	
	@Persistent
	private String inverterManufacturerCode;
	
	@Persistent
	private Double inverterWattage;
	
	@Persistent
	private Double inverterLossYear;
	
	@Persistent
	private Double inverterEfficiency;
	
	@Persistent
	private Double inverterCost;
	
	@Persistent
	private Double inverterRRP;
	
	@Persistent
	private Integer inverterLifeYears;
	
	public static final String INVERTER_NAME = "inverterName";
	public static final String INVERTER_MANUFACTURER = "inverterManufacturer";
	public static final String INVERTER_CODE = "inverterCode";
	public static final String INVERTER_WATTAGE = "inverterWattage";
	public static final String INVERTER_LOSS_YEAR = "inverterLossYear";
	public static final String INVERTER_EFFICIENCY = "inverterEfficiency";
	public static final String INVERTER_COST = "inverterCost";
	public static final String INVERTER_RRP = "inverterRRP";
	public static final String INVERTER_LIFE = "inverterLife";
	
	public SolarInverter() {
		inverterName = new String();
		inverterManufacturer = new String();
		inverterManufacturerCode = new String();
		inverterWattage = INITIAL_VALUES;
		inverterLossYear = INITIAL_VALUES;
		inverterEfficiency = INITIAL_VALUES;
		inverterCost = INITIAL_VALUES;
		inverterRRP = INITIAL_VALUES;
		inverterLifeYears = 0;
	}

	public SolarInverter(String inverterName, String inverterManufacturer, String inverterManufacturerCode,
			Double inverterWattage, Double inverterLossYear, Double inverterEfficiency, Double inverterCost,
			Double inverterRRP, Integer inverterLifeYears) {
		this.inverterName = inverterName;
		this.inverterManufacturer = inverterManufacturer;
		this.inverterManufacturerCode = inverterManufacturerCode;
		this.inverterWattage = inverterWattage;
		this.inverterLossYear = inverterLossYear;
		this.inverterEfficiency = inverterEfficiency;
		this.inverterCost = inverterCost;
		this.inverterRRP = inverterRRP;
		this.inverterLifeYears = inverterLifeYears;
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
		result = prime * result + ((inverterCost == null) ? 0 : inverterCost.hashCode());
		result = prime * result + ((inverterEfficiency == null) ? 0 : inverterEfficiency.hashCode());
		result = prime * result + ((inverterLifeYears == null) ? 0 : inverterLifeYears.hashCode());
		result = prime * result + ((inverterLossYear == null) ? 0 : inverterLossYear.hashCode());
		result = prime * result + ((inverterManufacturer == null) ? 0 : inverterManufacturer.hashCode());
		result = prime * result + ((inverterManufacturerCode == null) ? 0 : inverterManufacturerCode.hashCode());
		result = prime * result + ((inverterName == null) ? 0 : inverterName.hashCode());
		result = prime * result + ((inverterRRP == null) ? 0 : inverterRRP.hashCode());
		result = prime * result + ((inverterWattage == null) ? 0 : inverterWattage.hashCode());
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
		SolarInverter other = (SolarInverter) obj;
		if (inverterCost == null) {
			if (other.inverterCost != null) {
				return false;
			}
		} else if (!inverterCost.equals(other.inverterCost)) {
			return false;
		}
		if (inverterEfficiency == null) {
			if (other.inverterEfficiency != null) {
				return false;
			}
		} else if (!inverterEfficiency.equals(other.inverterEfficiency)) {
			return false;
		}
		if (inverterLifeYears == null) {
			if (other.inverterLifeYears != null) {
				return false;
			}
		} else if (!inverterLifeYears.equals(other.inverterLifeYears)) {
			return false;
		}
		if (inverterLossYear == null) {
			if (other.inverterLossYear != null) {
				return false;
			}
		} else if (!inverterLossYear.equals(other.inverterLossYear)) {
			return false;
		}
		if (inverterManufacturer == null) {
			if (other.inverterManufacturer != null) {
				return false;
			}
		} else if (!inverterManufacturer.equals(other.inverterManufacturer)) {
			return false;
		}
		if (inverterManufacturerCode == null) {
			if (other.inverterManufacturerCode != null) {
				return false;
			}
		} else if (!inverterManufacturerCode.equals(other.inverterManufacturerCode)) {
			return false;
		}
		if (inverterName == null) {
			if (other.inverterName != null) {
				return false;
			}
		} else if (!inverterName.equals(other.inverterName)) {
			return false;
		}
		if (inverterRRP == null) {
			if (other.inverterRRP != null) {
				return false;
			}
		} else if (!inverterRRP.equals(other.inverterRRP)) {
			return false;
		}
		if (inverterWattage == null) {
			if (other.inverterWattage != null) {
				return false;
			}
		} else if (!inverterWattage.equals(other.inverterWattage)) {
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
	public String toString(){
		return getInverterName() + 
				" - Cost: " + String.format("$%,.2f", getInverterCost()) + 
				" - Life: " + getInverterLifeYears() + " years" + 
				" - Wattage: " + getInverterWattage() + "W" + 
				" - Efficiency Loss: " + inverterLossYear + "%";
	}

	public String toString(boolean htmlTags) {

		if(htmlTags){
			return "<html><p>Wattage: " + inverterWattage + "W </p>" + "<p>Efficiency: " + inverterEfficiency + "%</p>"
			+ "<p>Life: " + inverterLifeYears.toString() + " Years</p>" + "<p>RRP: " + String.format("$%,.2f", inverterRRP) + "</p>" + "</html>";
		} else {
			return "Name: " + inverterName + "W" + "<br />" +
				   "Manufacturer: " + inverterManufacturer + "W" + "<br />" +
				   "Code: " + inverterManufacturerCode + "W" + "<br />" + 
				   "Wattage: " + inverterWattage + "W" + "<br />" + 
				   "Efficiency: " + inverterEfficiency + "%<br />"	+ 
				   "Life: " + inverterLifeYears.toString() + " Years<br />" +
				   "Cost: $" + inverterCost.toString() + "<br />" + 
				   "RRP: " + String.format("$%,.2f", inverterRRP) + "<br />";
		}
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
	 * @return the inverterName
	 */
	public String getInverterName() {
		return inverterName;
	}

	/**
	 * @param inverterName
	 *            the inverterName to set
	 */
	public void setInverterName(String inverterName) {
		this.inverterName = inverterName;
	}

	/**
	 * @return the inverterManufacturer
	 */
	public String getInverterManufacturer() {
		return inverterManufacturer;
	}

	/**
	 * @param inverterManufacturer
	 *            the inverterManufacturer to set
	 */
	public void setInverterManufacturer(String inverterManufacturer) {
		this.inverterManufacturer = inverterManufacturer;
	}

	/**
	 * @return the inverterManufacturerCode
	 */
	public String getInverterManufacturerCode() {
		return inverterManufacturerCode;
	}

	/**
	 * @param inverterManufacturerCode
	 *            the inverterManufacturerCode to set
	 */
	public void setInverterManufacturerCode(String inverterManufacturerCode) {
		this.inverterManufacturerCode = inverterManufacturerCode;
	}

	/**
	 * @return the inverterWattage
	 */
	public Double getInverterWattage() {
		return inverterWattage;
	}

	/**
	 * @param inverterWattage
	 *            the inverterWattage to set
	 */
	public void setInverterWattage(Double inverterWattage) {
		this.inverterWattage = inverterWattage;
	}

	/**
	 * @return the inverterLossYear
	 */
	public Double getInverterLossYear() {
		return inverterLossYear;
	}

	/**
	 * @param inverterLossYear
	 *            the inverterLossYear to set
	 */
	public void setInverterLossYear(Double inverterLossYear) {
		this.inverterLossYear = inverterLossYear;
	}

	/**
	 * @return the inverterEfficiency
	 */
	public Double getInverterEfficiency() {
		return inverterEfficiency;
	}

	/**
	 * @param inverterEfficiency
	 *            the inverterEfficiency to set
	 */
	public void setInverterEfficiency(Double inverterEfficiency) {
		this.inverterEfficiency = inverterEfficiency;
	}

	/**
	 * @return the inverterCost
	 */
	public Double getInverterCost() {
		return inverterCost;
	}

	/**
	 * @param inverterCost
	 *            the inverterCost to set
	 */
	public void setInverterCost(Double inverterCost) {
		this.inverterCost = inverterCost;
	}

	/**
	 * @return the inverterRRP
	 */
	public Double getInverterRRP() {
		return inverterRRP;
	}

	/**
	 * @param inverterRRP
	 *            the inverterRRP to set
	 */
	public void setInverterRRP(Double inverterRRP) {
		this.inverterRRP = inverterRRP;
	}

	/**
	 * @return the inverterLifeYears
	 */
	public Integer getInverterLifeYears() {
		return inverterLifeYears;
	}

	/**
	 * @param inverterLifeYears
	 *            the inverterLifeYears to set
	 */
	public void setInverterLifeYears(Integer inverterLifeYears) {
		this.inverterLifeYears = inverterLifeYears;
	}

}
