package com.java.springbootbackend.model;

import com.java.springbootbackend.services.PathFinder.IPathFinderService;
import com.java.springbootbackend.services.PathFinder.PathFinderService;
import com.java.springbootbackend.services.Weight.IWeightService;
import com.java.springbootbackend.services.Weight.WeightService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Coord, Node> nodes;

    private Coord start;

    public Graph(List<Coord> coords, Coord start) {
        this.start = start;
        IWeightService weightService = WeightService.getService();
        nodes = new HashMap<>();
        Node node;
        double weight;
        coords.add(start);
        for (Coord c : coords) {
            node = new Node(c);
            for (Coord other : coords) {
                if (!c.equals(other)) {
                    weight = weightService.getWeight(c, other);
                    node.addEdge(other, weight);
                }
            }
            nodes.put(c, node);
        }
    }

    public Pair<Double, List<Coord>> shortestPath() {
        IPathFinderService pf = PathFinderService.getImplementation();
        return pf.findPath(this);
    }

    public Map<Coord, Node> getNodes() {
        return nodes;
    }

    public Coord getStart() {
        return start;
    }
}
