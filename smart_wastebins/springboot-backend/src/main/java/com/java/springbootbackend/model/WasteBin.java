package com.java.springbootbackend.model;

public class WasteBin {
    private double fullness;
    private Coord coordinates = new Coord(0, 0);

    public WasteBin(double latitude, double longitude, double fullness) {
        setFullness(fullness);
        setCoordinates(latitude, longitude);
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
