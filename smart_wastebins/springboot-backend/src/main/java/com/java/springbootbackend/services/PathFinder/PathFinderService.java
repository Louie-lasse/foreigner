package com.java.springbootbackend.services.PathFinder;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.Node;
import com.java.springbootbackend.model.Pair;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Abstract singleton class for getting a Pathfinder implementation
 */
public abstract class PathFinderService {

    private static PathFinderService implementation;

    /**
     * Gets the current implementation of {@code PathFinderService}
     *
     * @return implementation
     */
    public static PathFinderService getImplementation() {
        if (Objects.isNull(implementation)) {
            implementation = new BasicPathFinder();
        }
        return implementation;
    }

    /**
     * Finds a path through a graph using the current implementation
     *
     * @param map   a map from Coord to Node
     * @param start the starting node
     * @return a double representing distance, and an ordered list of nodes
     */
    public Pair<Double, List<Coord>> findPath(Map<? extends Coord, ? extends Node> map, Coord start) {
        return getImplementation().calculatePath(map, start);
    }

    protected abstract Pair<Double, List<Coord>> calculatePath(Map<? extends Coord, ? extends Node> map, Coord start);

}
