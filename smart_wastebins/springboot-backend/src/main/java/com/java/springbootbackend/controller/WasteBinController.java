package com.java.springbootbackend.controller;

import com.java.springbootbackend.model.WasteBin;
import com.java.springbootbackend.model.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
