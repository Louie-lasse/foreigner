package com.java.springbootbackend.services.WasteBin;

import com.java.springbootbackend.model.WasteBin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

class RandomWasteBinService implements IWasteBinService {

    private List<WasteBin> wasteBins;

    private final static int seed = 0;//change seed to debug

    private Random random;

    protected RandomWasteBinService() {
    }

    private double randomDouble(double rangeMin, double rangeMax) {
        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
    }

    @Override
    public List<WasteBin> getWasteBins() {
        if (Objects.isNull(wasteBins)) {
            random = new Random(seed);
            wasteBins = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                double x, y, fullness;
                x = randomDouble(57.634763, 57.761942);
                y = randomDouble(11.889930, 12.053338);
                fullness = randomDouble(0.4, 1);
                //wasteBins.add(new WasteBin(x, y, fullness));
            }
        }
        return wasteBins;
    }
}
