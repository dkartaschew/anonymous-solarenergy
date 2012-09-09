package com.anonymous.solar.shared;

import java.util.Arrays;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Location Data Class that holds all necessary information to be utilised
 * within the solar power calculator.
 *
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
@PersistenceCapable
public class LocationData {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;

	@Persistent
    private Double longitude = 0.00;

	@Persistent
    private Double latitude = 0.00;

	@Persistent
    private String locationName = "";

	@Persistent
    private Double[][] locationWeatherData = {
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0},
        {0.0, 100.0}};

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
    public LocationData(Double lon, Double lat, String name, Double[][] locData) throws LocationDataException {
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
     * Get longitude of location
     *
     * @return
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
     * Get latitude of location
     *
     * @return
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
     * Get location name,
     *
     * @return
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
     * Return weather information
     *
     * @return
     */
    public Double[][] getLocationWeatherData() {
        return locationWeatherData;
    }


    /**
     * set new weather information.
     *
     * @param locationWeatherData
     * @throws Exception
     */
    public void setLocationWeatherData(Double[][] locationWeatherData) throws LocationDataException {
        if (locationWeatherData == null) {
            throw new LocationDataException("Location weather information is null");
        }
        if (locationWeatherData.length != 12) {
            throw new LocationDataException("Location weather information doesn't have 12mths data");
        }

        this.locationWeatherData = locationWeatherData;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 67 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 67 * hash + (this.locationName != null ? this.locationName.hashCode() : 0);
        hash = 67 * hash + Arrays.deepHashCode(this.locationWeatherData);
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LocationData other = (LocationData) obj;
        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))) {
            return false;
        }
        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))) {
            return false;
        }
        if ((this.locationName == null) ? (other.locationName != null) : !this.locationName.equals(other.locationName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.locationWeatherData, other.locationWeatherData)) {
            return false;
        }
        return true;
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
     * @param htmlTags If <htnml> should be included
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
