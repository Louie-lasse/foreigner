package com.java.springbootbackend.model;

public class WasteBin implements IMappable {

    private double fullness;
    private String groupName;
    private String reason;
    private long serialNumber;

    private final Coord coordinates;


    public WasteBin(double latitude, double longitude, double fullness, String groupName, String reason, long serialNumber) {
        this.coordinates = new Coord(latitude, longitude);
        setFullness(fullness);
        this.serialNumber = serialNumber;
        this.reason = reason;
        this.groupName = groupName;
    }

    public WasteBin(double latitude, double longitude, double fullness) {
        this.coordinates = new Coord(latitude, longitude);
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
        return coordinates.getLatitude();
    }

    public double getLongitude() {
        return coordinates.getLongitude();
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

    @Override
    public String toString() {
        return "WasteBin{" +
                "fullness=" + fullness +
                ", coordinates=" + coordinates +
                '}';
    }
}
