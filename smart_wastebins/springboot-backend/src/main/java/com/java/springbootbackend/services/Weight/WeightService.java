package com.java.springbootbackend.services.Weight;

import com.java.springbootbackend.model.Coord;

import java.util.Objects;

public abstract class WeightService {

    private static WeightService service;

    public static WeightService getService(){
        if (Objects.isNull(service)){
            service = new BasicWeightService();
        }
        return service;
    }

    public abstract double calculateWeight(Coord c1, Coord c2);
}
