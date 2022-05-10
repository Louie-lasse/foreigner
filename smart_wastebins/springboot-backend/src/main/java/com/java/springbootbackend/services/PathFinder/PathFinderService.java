package com.java.springbootbackend.services.PathFinder;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.Graph;
import com.java.springbootbackend.model.Node;
import com.java.springbootbackend.model.Pair;
import com.java.springbootbackend.services.Weight.WeightService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Abstract singleton class for getting a Pathfinder implementation
 */
public class PathFinderService {

    private static IPathFinderService implementation;

    /**
     * Gets the current implementation of {@code PathFinderService}
     *
     * @return implementation
     */
    public static IPathFinderService getImplementation() {
        if (Objects.isNull(implementation)) {
            implementation = new BasicPathFinder();
        }
        return implementation;
    }

    public static IPathFinderService getImplementation(ServiceType type) {
        return type.implementation;
    }

    public enum ServiceType {

        BASIC(new BasicPathFinder());

        private final IPathFinderService implementation;

        ServiceType(IPathFinderService implementation) {
            this.implementation = implementation;
        }
    }

}
