package com.java.springbootbackend.controller;

import com.java.springbootbackend.model.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@CrossOrigin("*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@RequestMapping("/api/v1/path")
public class PathController {

    private final Data data = Data.getInstance();

    @GetMapping
    public Pair<Double, List<IMappable>> getPath(
            @RequestParam("latitude") double x,
            @RequestParam("longitude") double y,
            @RequestParam("limit") Optional<Integer> limit
    ) {
        List<WasteBin> all = data.getWasteBins();
        List<IMappable> bins;
        if (limit.isPresent() && limit.get() >= 0) {
            bins = all.stream().limit(limit.get()).collect(Collectors.toList());
        } else {
            bins = new ArrayList<>(all);
        }
        return new Graph(bins, new Coord(x, y)).shortestPath();
    }
}
