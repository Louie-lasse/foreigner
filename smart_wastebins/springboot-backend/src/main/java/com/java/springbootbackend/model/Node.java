package com.java.springbootbackend.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Node {

    Coord coord;
    List<Edge> edges;

    public Node(Coord coord) {
        this.coord = coord;
        this.edges = new ArrayList<>();
    }

    public Coord getCoord() {
        return coord;
    }

    public void addEdge(Coord c, double w) {
        edges.add(new Edge(c, w));
    }

    public void sort(Comparator<Edge> comparator) {
        edges.sort(comparator);
    }

    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }
}
