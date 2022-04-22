package com.java.springbootbackend.services.PathFinder;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.Node;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class PathFinderService {

    private static PathFinderService implementation;

    public static PathFinderService getImplementation() {
        if (Objects.isNull(implementation)) {
            implementation = new BasicPathFinder();
        }
        return implementation;
    }

    public List<Coord> findPath(Map<? extends Coord, ? extends Node> map, Coord start) {
        return getImplementation().calculatePath(map, start);
    }

    protected abstract List<Coord> calculatePath(Map<? extends Coord, ? extends Node> map, Coord start);

}
