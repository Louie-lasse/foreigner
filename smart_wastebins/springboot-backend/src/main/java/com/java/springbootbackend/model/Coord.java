package com.java.springbootbackend.model;

/**
 * Class for representing a Coordinate
 */
public class Coord {
    private double x;
    private double y;

    /**
     * Public constructor, setting {@code x} and {@code y} respectively
     *
     * @param x latitude
     * @param y longitude
     */
    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Public getter for {@code x}-value
     *
     * @return {@code x}
     */
    public double getX() {
        return x;
    }

    /**
     * Public setter for {@code x}-value
     * <p>
     * Accepts values between -180 and 180
     * </p>
     *
     * @param x the longitude of the {@code Coord}
     */
    public void setX(double x) {
        if (x >= -180 && 180 >= x) {
            this.x = x;
        }
    }

    /**
     * Public getter for {@code y}-value
     *
     * @return {@code y}
     */
    public double getY() {
        double tmp;
        tmp = this.y;
        return tmp;
    }

    /**
     * Public setter for {@code y}-value
     * <p>
     * Accepts values between -90 and 90
     * </p>
     *
     * @param y set the longitude of hte {@code Coord}
     */
    public void setY(double y) {
        if (y <= 90 && -90 <= y) {
            this.y = y;
        }
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
