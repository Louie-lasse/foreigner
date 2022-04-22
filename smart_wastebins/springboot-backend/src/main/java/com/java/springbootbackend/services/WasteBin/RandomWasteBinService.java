package com.java.springbootbackend.services.WasteBin;

import com.java.springbootbackend.model.WasteBin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomWasteBinService extends WasteBinService {

    private final List<WasteBin> wasteBins;

    protected RandomWasteBinService() {
        Random random = new Random(0);
        wasteBins = new ArrayList<>();
        double x, y, fullness;
        for (int i = 0; i < 10; i++) {
            //change seed to debug
            x = random.nextDouble(57.634763, 57.761942);
            y = random.nextDouble(11.889930, 12.053338);
            fullness = random.nextDouble(0.4, 1);
            wasteBins.add(new WasteBin(x, y, fullness));
        }
    }

    public List<WasteBin> getAllBins() {
        return wasteBins;
    }
}
