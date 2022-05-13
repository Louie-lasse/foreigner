package com.java.springbootbackend.services.WasteBin;

import com.java.springbootbackend.model.WasteBin;

import java.util.List;
import java.util.Objects;

public abstract class WasteBinService {

    private static final ServiceType defaultImplementation = ServiceType.RANDOM;

    public static IWasteBinService getService() {
        return getService(defaultImplementation);
    }

    public static IWasteBinService getService(ServiceType type) {
        return type.implementation;
    }

    protected abstract List<WasteBin> getAllBins();

    public enum ServiceType {
        RANDOM(new RandomWasteBinService()),
        API(new APIWasteBinService());

        private final IWasteBinService implementation;

        ServiceType(IWasteBinService service) {
            implementation = service;
        }
    }
}
