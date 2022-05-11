package com.java.springbootbackend.model;

import static java.lang.Math.*;

/**
 * Class for representing an edge in a graph
 */
public class Edge {

    private final Coord coord;
    private final double weight;

    /**
     * Public constructor for {@code Edge}
     *
     * @param coord,  the {@link Coord} the edge leads to
     * @param weight, the distance/weight of the edge
     */
    public Edge(Coord coord, double weight) {
        this.coord = coord;
        this.weight = weight;
    }

    /**
     * Gets the {@link Coord}
     *
     * @return {@code coord}
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * Gets the weight of the {@code Edge}
     *
     * @return {@code weight}
     */
    public double getWeight() {
        return weight;
    }

}
