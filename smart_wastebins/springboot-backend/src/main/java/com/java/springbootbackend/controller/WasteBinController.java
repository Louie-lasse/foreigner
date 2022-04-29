package com.java.springbootbackend.controller;

import com.java.springbootbackend.model.WasteBin;
import com.java.springbootbackend.model.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@CrossOrigin("*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
@RequestMapping("/api/v1/wastebins")
public class WasteBinController {

    private final Data data = Data.getInstance();

    @GetMapping
    public List<WasteBin> getAllWasteBins(){
        return data.getWasteBins();
    }

    @GetMapping("/{amount}")
    public List<WasteBin> getBins(@PathVariable(value = "amount") int amount) {
        List<WasteBin> temp = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            temp.add(getAllWasteBins().get(i));
        }
        return temp;
    }
}
