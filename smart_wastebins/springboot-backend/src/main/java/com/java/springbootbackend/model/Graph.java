package com.java.springbootbackend.model;

import com.java.springbootbackend.services.Weight.WeightService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Coord, Node> nodes;

    public Graph(List<Coord> coords){
        WeightService weightService = WeightService.getImplementation();
        nodes = new HashMap<>();
        Node node;
        double weight;
        for (Coord c : coords){
            node = new Node(c);
            for (Coord other : coords) {
                if (!c.equals(other)){
                    weight = weightService.calculateWeight(c, other);
                    node.addEdge(other, weight);
                }
            }
            nodes.put(c, node);
        }
    }

    public List<Coord> shortestPath(){
        throw new RuntimeException("Not implemented yet :.(");
    }

}
