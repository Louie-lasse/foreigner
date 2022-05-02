package com.java.springbootbackend.services.WasteBin;

import com.java.springbootbackend.model.WasteBin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomWasteBinService extends WasteBinService {

    private final List<WasteBin> wasteBins;

    private final static int seed = 0;//change seed to debug

    private final Random random;

    protected RandomWasteBinService() {
        random = new Random(seed);
        wasteBins = new ArrayList<>();
        double x, y, fullness;
        for (int i = 0; i < 10; i++) {
            x = randomDouble(57.634763, 57.761942);
            y = randomDouble(11.889930, 12.053338);
            fullness = randomDouble(0.4, 1);
            wasteBins.add(new WasteBin(x, y, fullness));
        }
    }

    private double randomDouble(double rangeMin, double rangeMax) {
        return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
    }

    public List<WasteBin> getAllBins() {
        return wasteBins;
    }
}
