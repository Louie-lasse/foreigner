package com.java.springbootbackend.model;

public class Coord {
    private double x;
    private double y;

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        double tmp;
        tmp = this.x;
        return tmp;
    }

    public void setX(double x) {
        if(x >= -180 && 180 >= x) {
            this.x = x;
        }
    }

    public double getY() {
        double tmp;
        tmp = this.y;
        return tmp;
    }

    public void setY(double y) {
        if(y <= 90 && -90 <= y) {
            this.y = y;
        }
    }
}
