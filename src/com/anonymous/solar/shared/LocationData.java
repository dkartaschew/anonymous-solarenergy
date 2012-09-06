package com.anonymous.solar.shared;

import java.util.Arrays;

/**
 * Location Data Class that holds all necessary information to be utilised
 * within the solar power calculator.
 *
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class LocationData {

    private Double longitude = 0.00;

    private Double latitude = 0.00;

    private String locationName = "";

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
    public LocationData(Double lon, Double lat, String name, Double[][] locData) throws Exception {
        setLongitude(lon);
        setLatitude(lat);
        setLocationName(name);
        setLocationWeatherData(locData);
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
    public void setLongitude(Double longitude) throws Exception {
        if (longitude == null) {
            throw new Exception();
        }
        if (longitude < -180.00 || longitude > 180.00) {
            throw new Exception();
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
    public void setLatitude(Double latitude) throws Exception {
        if (latitude == null) {
            throw new Exception();
        }
        if (latitude < -90.00 || latitude > 90.00) {
            throw new Exception();
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
    public void setLocationName(String locationName) throws Exception {
        if (locationName == null || locationName.length() == 0) {
            throw new Exception();
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
    public void setLocationWeatherData(Double[][] locationWeatherData) throws Exception {
        if (locationWeatherData == null) {
            throw new Exception();
        }
        if (locationWeatherData.length != 12) {
            throw new Exception();
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
