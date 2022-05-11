package com.java.springbootbackend.controller;

import com.google.gson.Gson;
import com.java.springbootbackend.model.WasteBin;
import com.java.springbootbackend.model.Data;
import com.java.springbootbackend.services.JSONJavaParser.JSONJavaParser;
import org.json.JSONArray;
import org.json.JSONObject;
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
        if (amount > getAllWasteBins().size() || amount < 0) {
            return getAllWasteBins();
        }

        List<WasteBin> temp = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            temp.add(getAllWasteBins().get(i));
        }
        return temp;
    }

    public List<WasteBin> JSONJavaParser(JSONArray array){
        Gson g = new Gson();
        WasteBin javaWasteBin;
        List<WasteBin> wasteBins = new ArrayList<>();

        for(int n = 0; n < array.length(); n++)
        {
            JSONObject JSONWasteBin = array.getJSONObject(n);
            javaWasteBin = g.fromJson(JSONWasteBin.toString(), WasteBin.class);
            wasteBins.add(javaWasteBin);
        }

        return wasteBins;
    }
}
