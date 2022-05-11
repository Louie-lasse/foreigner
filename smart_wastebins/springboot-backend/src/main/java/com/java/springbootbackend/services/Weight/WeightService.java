package com.java.springbootbackend.services.Weight;

import com.java.springbootbackend.model.Coord;
import com.java.springbootbackend.services.WasteBin.IWasteBinService;
import com.java.springbootbackend.services.WasteBin.WasteBinService;

import java.util.Objects;

public abstract class WeightService {

    private static IWeightService implementation;

    public static IWeightService getService() {
        if (Objects.isNull(implementation)) {
            implementation = new BasicWeightService();
        }
        return implementation;
    }

    public static IWeightService getService(ServiceType type) {
        return type.implementation;
    }

    public enum ServiceType {

        BASIC(new BasicWeightService());

        private final IWeightService implementation;

        ServiceType(IWeightService service) {
            implementation = service;
        }
    }
}
