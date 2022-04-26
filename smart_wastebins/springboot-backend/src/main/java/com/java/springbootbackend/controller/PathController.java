package com.java.springbootbackend.controller;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.Data;
import com.java.springbootbackend.model.Graph;
import com.java.springbootbackend.model.Pair;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@RequestMapping("/api/v1/path")
public class PathController {

    private final Data data = Data.getInstance();

    @GetMapping
    public Pair<Double, List<Coord>> getPath(
            @RequestParam("latitude") double x,
            @RequestParam("longitude") double y
    ) {
        List<Coord> coords = new ArrayList<>();
        data.getWasteBins().forEach(wasteBin -> coords.add(wasteBin.getCoordinates()));
        Graph graph = new Graph(coords, new Coord(x, y));
        return graph.shortestPath();
    }
}
