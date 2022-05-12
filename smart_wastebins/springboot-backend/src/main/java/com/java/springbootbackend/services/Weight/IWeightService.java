package com.java.springbootbackend.services.Weight;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.model.IMappable;

public interface IWeightService {
    double getWeight(IMappable c1, IMappable c2);
}
