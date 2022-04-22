package com.java.springbootbackend.services.Weight;

import com.java.springbootbackend.model.Coord;

public class BasicWeightService extends WeightService {

    protected BasicWeightService() {
    }

    @Override
    public double calculate(Coord c1, Coord c2) {
        double deltaX = c1.getX() - c2.getX();
        double deltaY = c1.getY() - c2.getY();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
