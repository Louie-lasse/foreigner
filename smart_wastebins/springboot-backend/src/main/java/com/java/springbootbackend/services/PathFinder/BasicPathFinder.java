package com.java.springbootbackend.services.PathFinder;

import com.java.springbootbackend.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class BasicPathFinder implements IPathFinderService {

    @Override
    public Pair<Double, List<IMappable>> findPath(Graph graph) {
        return calculatePath(graph.getNodes(), graph.getStart());
    }


    /**
     * Finds a short path by always moving to the closest, non-visited node.
     *
     * @param map   a map of all the nodes
     * @param start the starting Coord
     * @return a double representing distance, and an ordered list of nodes
     */
    protected Pair<Double, List<IMappable>> calculatePath(Map<IMappable, ? extends Node> map, IMappable start) {
        map.forEach((BiConsumer<IMappable, Node>) (coord, node) -> node.sort(Comparator.comparingDouble(Edge::getWeight)));
        IMappable current = start;
        double distance = 0;
        List<IMappable> visited = new ArrayList<>();
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

    private Edge findWayHome(Map<IMappable, ? extends Node> map, IMappable current, IMappable start) {
        List<Edge> edges = map.get(current).getEdges();
        for (Edge e : edges) {
            if (e.getCoord() == start)
                return e;
        }
        System.out.println(map);
        throw new RuntimeException("Map error: no way home from " + current);
    }

    private Edge getClosestEdge(List<Edge> edges, List<IMappable> visited) {
        int i = 0;
        Edge path;
        do {
            path = edges.get(i++);
        } while (visited.contains(path.getCoord()));
        return path;
    }

}
