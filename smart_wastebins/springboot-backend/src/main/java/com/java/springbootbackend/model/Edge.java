package com.java.springbootbackend.model;
import static java.lang.Math.*;

public class Edge {

    private final Coord coord;
    private final double weight;

    public Edge(Coord coord, double weight) {
        this.coord = coord;
        this.weight = weight;
    }

    public Coord getCoord() {
        return coord;
    }

    public double getWeight() {
        return weight;
    }

}
