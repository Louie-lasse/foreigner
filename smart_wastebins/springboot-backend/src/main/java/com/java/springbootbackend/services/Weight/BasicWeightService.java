package com.java.springbootbackend.services.Weight;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.IMappable;

public class BasicWeightService implements IWeightService {

    protected BasicWeightService() {
    }

    @Override
    public double getWeight(IMappable c1, IMappable c2) {
        double deltaX = c1.getLatitude() - c2.getLatitude();
        double deltaY = c1.getLongitude() - c2.getLongitude();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
