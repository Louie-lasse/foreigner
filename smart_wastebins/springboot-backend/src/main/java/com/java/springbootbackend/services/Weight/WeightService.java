package com.java.springbootbackend.services.Weight;

import com.java.springbootbackend.model.Coord;

import java.util.Objects;

public abstract class WeightService {

    private static WeightService implementation;

    public static WeightService getImplementation() {
        if (Objects.isNull(implementation)) {
            implementation = new BasicWeightService();
        }
        return implementation;
    }

    public double calculateWeight(Coord c1, Coord c2) {
        return getImplementation().calculate(c1, c2);
    }

    protected abstract double calculate(Coord c1, Coord c2);
}
