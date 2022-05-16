package com.java.springbootbackend.model;

public class WasteBin implements IMappable {

    private int fullness;
    private String groupName;
    private long serialNumber;
    private double latitude;
    private double longitude;
    private String description;

    public WasteBin(double latitude, double longitude, int fullness, String groupName, long serialNumber, String description) {
        setFullness(fullness);
        this.latitude = latitude;
        this.longitude = longitude;
        this.serialNumber = serialNumber;
        this.groupName = groupName;
        this.description = description;
    }

    public WasteBin(double latitude, double longitude, int fullness) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.fullness = fullness;
    }

    public String getDescription() {
        String tmp;
        tmp = description;
        return tmp;
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getFullness() {
        double temp;
        temp = fullness;
        return temp;
    }

    public void setFullness(int fullness) {
        if (fullness >= 0 && fullness <= 10) {
            this.fullness = fullness;
        }
    }

    @Override
    public String toString() {
        return "WasteBin{" +
                "fullness=" + fullness +
                ", groupName='" + groupName + '\'' +
                ", serialNumber=" + serialNumber +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", description='" + description + '\'' +
                '}';
    }
}
