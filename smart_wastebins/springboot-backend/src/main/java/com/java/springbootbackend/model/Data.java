package com.java.springbootbackend.model;

import com.java.springbootbackend.services.WasteBin.WasteBinService;

import java.util.List;
import java.util.Objects;


public class Data {

    private final List<WasteBin> cans;

    private static Data instance;

    private Data() {
        cans = WasteBinService.getService().getWasteBins();
    }

    public static Data getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Data();
        }
        return instance;
    }

    public List<WasteBin> getWasteBins() {
        return cans;
    }

}
