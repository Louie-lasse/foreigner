package com.java.springbootbackend.services.PathFinder;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.Edge;
import com.java.springbootbackend.model.Node;
import com.java.springbootbackend.model.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class BasicPathFinder extends PathFinderService {


    @Override
    protected Pair<Double, List<Coord>> calculatePath(Map<? extends Coord, ? extends Node> map, Coord start) {
        map.forEach((BiConsumer<Coord, Node>) (coord, node) -> node.sort(Comparator.comparingDouble(Edge::getWeight)));
        Coord current = start;
        double distance = 0;
        List<Coord> visited = new ArrayList<>();
        while (visited.size() < map.size()) {
            visited.add(current);
            Edge path;
            try {
                path = getClosestEdge(map.get(current).getEdges(), visited);
            } catch (IndexOutOfBoundsException ignored) {
                path = findWayHome(map, current, start);
            }
            distance += path.getWeight();
            current = path.getCoord();
        }
        visited.add(current); //adds start to the end again
        return new Pair<>(distance, visited);

    }

    private Edge findWayHome(Map<? extends Coord, ? extends Node> map, Coord current, Coord start) {
        List<Edge> edges = map.get(current).getEdges();
        for (Edge e : edges) {
            if (e.getCoord() == start)
                return e;
        }
        throw new RuntimeException("Map error: no way home from " + current);
    }

    private Edge getClosestEdge(List<Edge> edges, List<Coord> visited) {
        int i = 0;
        Edge path;
        do {
            path = edges.get(i++);
        } while (visited.contains(path.getCoord()));
        return path;
    }
}