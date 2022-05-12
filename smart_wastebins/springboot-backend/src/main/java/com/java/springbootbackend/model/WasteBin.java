package com.java.springbootbackend.model;

public class WasteBin {

    private final double latitude;
    private final double longitude;
    private double fullness;
    private String groupName;
    private String reason;
    private long serialNumber;

    private final Coord coordinates = new Coord(0, 0);


    public WasteBin(double latitude, double longitude, double fullness, String groupName, String reason, long serialNumber) {
        setFullness(fullness);
        setCoordinates(latitude, longitude);
        this.serialNumber = serialNumber;
        this.reason = reason;
        this.latitude = latitude;
        this.longitude = longitude;
        this.groupName = groupName;
    }

    public WasteBin(double latitude, double longitude, double fullness) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.fullness = fullness;
    }

    public long getSerialNumber() {
        long tmp;
        tmp = serialNumber;
        return tmp;
    }

    public String getGroupName() {
        String tmp;
        tmp = groupName;
        return tmp;
    }

    public String getReason() {
        String tmp;
        tmp = reason;
        return tmp;
    }
    public double getLatitude() {
        double tmp;
        tmp = latitude;
        return tmp;
    }
    public double getLongitude() {
        double tmp;
        tmp = longitude;
        return tmp;
    }

    public double getFullness() {
        double temp;
        temp = fullness;
        return temp;
    }

    public void setFullness(double fullness) {
        if (fullness > 0 && fullness < 1) {
            this.fullness = fullness;
        }
    }

    public Coord getCoordinates() {
        Coord temp;
        temp = coordinates;
        return temp;
    }

    public void setCoordinates(double longitude, double latitude) {
        coordinates.setX(longitude);
        coordinates.setY(latitude);
    }

    @Override
    public String toString() {
        return "WasteBin{" +
                "fullness=" + fullness +
                ", coordinates=" + coordinates +
                '}';
    }
}
