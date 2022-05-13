package com.java.springbootbackend.model;

/**
 * Class for representing a Coordinate
 */
public class Coord implements IMappable {
    private double latitude;
    private double longitude;

    /**
     * Public constructor, setting {@code x} and {@code y} respectively
     *
     * @param latitude  latitude
     * @param longitude longitude
     */
    public Coord(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Public getter for {@code x}-value
     *
     * @return {@code x}
     */
    @Override
    public double getLatitude() {
        return latitude;
    }

    /**
     * Public getter for {@code y}-value
     *
     * @return {@code y}
     */
    @Override
    public double getLongitude() {
        return longitude;
    }


    /**
     * Public setter for {@code latitude}-value
     * <p>
     * Accepts values between -180 and 180
     * </p>
     *
     * @param latitude the longitude of the {@code Coord}
     */
    public void setLatitude(double latitude) {
        if (latitude >= -180 && 180 >= latitude) {
            this.latitude = latitude;
        }
    }


    /**
     * Public setter for {@code longitude}-value
     * <p>
     * Accepts values between -90 and 90
     * </p>
     *
     * @param longitude set the longitude of hte {@code Coord}
     */
    public void setLongitude(double longitude) {
        if (longitude <= 90 && -90 <= longitude) {
            this.longitude = longitude;
        }
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + latitude +
                ", y=" + longitude +
                '}';
    }
}
