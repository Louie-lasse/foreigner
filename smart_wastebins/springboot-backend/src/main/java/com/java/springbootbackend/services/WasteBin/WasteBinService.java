package com.java.springbootbackend.services.WasteBin;

import com.java.springbootbackend.model.WasteBin;

import java.util.List;
import java.util.Objects;

public abstract class WasteBinService {

    private static WasteBinService implementation;

    public static WasteBinService getImplementation(){
        if (Objects.isNull(implementation)){
            implementation = new RandomWasteBinService();
        }
        return implementation;
    }

    public List<WasteBin> getWasteBins(){
        return getImplementation().getAllBins();
    }

    protected abstract List<WasteBin> getAllBins();
}
