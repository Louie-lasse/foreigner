package com.java.springbootbackend.services.PathFinder;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.Graph;
import com.java.springbootbackend.model.Pair;

import java.util.List;

public interface IPathFinderService {

    Pair<Double, List<Coord>> findPath(Graph graph);

}
