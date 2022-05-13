package com.java.springbootbackend.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class for representing a node in a {@link Graph}
 */
public class Node {

    IMappable coord;
    List<Edge> edges;

    /**
     * Create a node with a specific {@link Coord}
     *
     * @param coord the coord of this node
     */
    public Node(IMappable coord) {
        this.coord = coord;
        this.edges = new ArrayList<>();
    }

    /**
     * getter for the {@code coord}
     *
     * @return coord
     */
    public IMappable getCoord() {
        return coord;
    }

    /**
     * Adds a new edge, with a {@code coord} and a {@code weight}
     *
     * @param coord  coordinate of the next node
     * @param weight weight to the next node
     */
    public void addEdge(IMappable coord, double weight) {
        edges.add(new Edge(coord, weight));
    }

    /**
     * Sorts a node's {@code edges} using a {@code Comparator<Edge>}
     *
     * @param comparator the comparator used in sorting
     */
    public void sort(Comparator<Edge> comparator) {
        edges.sort(comparator);
    }

    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }
}
