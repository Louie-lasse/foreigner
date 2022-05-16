package com.java.springbootbackend.controller;

import com.java.springbootbackend.model.*;
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
    public Pair<Double, List<IMappable>> getPath(
            @RequestParam("latitude") double x,
            @RequestParam("longitude") double y
    ) {
        Graph graph = new Graph(new ArrayList<>(data.getWasteBins()), new Coord(x, y));
        return graph.shortestPath();
    }
}
