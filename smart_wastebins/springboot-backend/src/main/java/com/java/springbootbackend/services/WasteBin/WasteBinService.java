package com.java.springbootbackend.services.WasteBin;

import com.java.springbootbackend.model.WasteBin;

import java.util.List;
import java.util.Objects;

public abstract class WasteBinService {

    private static WasteBinService service;

    public static WasteBinService getService(){
        if (Objects.isNull(service)){
            service = new RandomWasteBinService();
        }
        return service;
    }

    public abstract List<WasteBin> getWasteBins();
}
