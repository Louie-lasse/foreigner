package com.java.springbootbackend.services.Weight;

import com.java.springbootbackend.model.Coord;

public interface IWeightService {
    double getWeight(Coord c1, Coord c2);
}
