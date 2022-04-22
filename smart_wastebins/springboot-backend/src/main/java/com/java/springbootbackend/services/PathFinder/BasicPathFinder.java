package com.java.springbootbackend.services.PathFinder;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.Node;

import java.util.List;
import java.util.Map;

public class BasicPathFinder extends PathFinderService {


    @Override
    protected List<Coord> calculatePath(Map<? extends Coord, ? extends Node> map, Coord start) {
        throw new RuntimeException("Not implemented yet");
    }
}
