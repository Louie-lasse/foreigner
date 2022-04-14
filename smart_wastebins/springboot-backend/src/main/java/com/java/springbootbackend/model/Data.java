package com.java.springbootbackend.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Data {

    private final List<WasteBin> cans;

    private static Data instance;

    private Data(){
        cans = new ArrayList<>();
        cans.add(new WasteBin(36,51.4, 0.3));
        cans.add(new WasteBin(36.2,50.9, 0.74));
    }
    
    public static Data getInstance() {
        if (Objects.isNull(instance)){
            instance = new Data();
        }
        return instance;
    }

    public List<WasteBin> getWasteBins(){
        return cans;
    }

}
