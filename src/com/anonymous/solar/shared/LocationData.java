
package com.anonymous.solar.shared;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * <p>Java class for locationData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="locationData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="locationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locationWeatherData" type="{http://jaxb.dev.java.net/array}doubleArray" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "locationData", propOrder = {
	"key",
    "latitude",
    "locationName",
    "locationWeatherData",
    "longitude"
})
@PersistenceCapable
public class LocationData {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
    protected Double latitude;
	@Persistent
    protected String locationName;
    @XmlElement(nillable = true)
    @Persistent
    protected List<DoubleArray> locationWeatherData;
    @Persistent
    protected Double longitude;

    /*
	 * Default parameter names to ensure consistency among all consumers of the
	 * class.
	 */
	public static final String LOCATION_LONGITUDE = "longitude";
	public static final String LOCATION_LATITUDE = "latitude";
	public static final String LOCATION_NAME = "locationName";
	public static final String LOCATION_wEATHER_DATA = "locationWeatherData";
    
	/**
     * Default Constructor;
     */
    public LocationData() {
    }


    /**
     * Constructor
     *
     * @param lon Longitude (-180 > x > 180);
     * @param lat Latitude(-90 > x > 90);
     * @param name Location Name (not null or "")
     * @param locData Array of [12]{days of cloud cover,panel efficiency when in
     * cloud}
     * @throws Exception
     */
    public LocationData(Double lon, Double lat, String name, List<DoubleArray> locData) throws LocationDataException {
        setLongitude(lon);
        setLatitude(lat);
        setLocationName(name);
        setLocationWeatherData(locData);
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
     * set new weather information.
     *
     * @param locationWeatherData
     * @throws Exception
     */
    public void setLocationWeatherData(List<DoubleArray> locationWeatherData) throws LocationDataException {
        if (locationWeatherData == null) {
            throw new LocationDataException("Location weather information is null");
        }
        if (locationWeatherData.size() != 12) {
            throw new LocationDataException("Location weather information doesn't have 12mths data");
        }

        this.locationWeatherData = locationWeatherData;
    }
	
    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Set latitude of location
     *
     * @param latitude
     * @throws Exception
     */
    public void setLatitude(Double latitude) throws LocationDataException {
        if (latitude == null) {
            throw new LocationDataException("Latitude = null");
        }
        if (latitude < -90.00 || latitude > 90.00) {
            throw new LocationDataException("Latitude is out of bounds");
        }
        this.latitude = latitude;
    }

    /**
     * Gets the value of the locationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * set location name.
     *
     * @param locationName
     * @throws Exception
     */
    public void setLocationName(String locationName) throws LocationDataException {
        if (locationName == null || locationName.length() == 0) {
            throw new LocationDataException("Location Name is null or zero length");
        }
        this.locationName = locationName;
    }

    /**
     * Gets the value of the locationWeatherData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationWeatherData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationWeatherData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DoubleArray }
     * 
     * 
     */
    public List<DoubleArray> getLocationWeatherData() {
        if (locationWeatherData == null) {
            locationWeatherData = new ArrayList<DoubleArray>();
        }
        return this.locationWeatherData;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Set longitude of location.
     *
     * @param longitude
     * @throws Exception
     */
    public void setLongitude(Double longitude) throws LocationDataException {
        if (longitude == null) {
            throw new LocationDataException("Longitude = null");
        }
        if (longitude < -180.00 || longitude > 180.00) {
            throw new LocationDataException("Longitude out of bounds");
        }

        this.longitude = longitude;
    }

    /**
     * Basic ToString() method. DO NOT MODIFY THIS, as this is used by comboboxes for displaying location names;
     * @return 
     */
    @Override
    public String toString() {
        return locationName;
    }


    /**
     * Output HTML encoded strings.
     *
     * @param htmlTags If <html> should be included
     * @return String with class information.
     */
    public String toString(boolean htmlTags) {
        String content = "<p>Location Name: " + locationName + " </p>"
                + "<p>Latitude: " + latitude.toString() + "%</p>"
                + "<p>Longitude: " + longitude.toString() + " Years</p>";
        if (htmlTags) {
            return "<html>" + content + "</html>";
        } else {
            return content;
        }
    }
}
