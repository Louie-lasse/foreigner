package com.java.springbootbackend.model;

import com.java.springbootbackend.services.PathFinder.PathFinderService;
import com.java.springbootbackend.services.Weight.WeightService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Coord, Node> nodes;

    private Coord start;

    public Graph(List<Coord> coords, Coord start) {
        this.start = start;
        WeightService weightService = WeightService.getImplementation();
        nodes = new HashMap<>();
        Node node;
        double weight;
        for (Coord c : coords) {
            node = new Node(c);
            for (Coord other : coords) {
                if (!c.equals(other)) {
                    weight = weightService.calculateWeight(c, other);
                    node.addEdge(other, weight);
                }
            }
            nodes.put(c, node);
        }
    }

    public List<Coord> shortestPath() {
        PathFinderService pf = PathFinderService.getImplementation();
        return pf.findPath(nodes, start);
    }

}
