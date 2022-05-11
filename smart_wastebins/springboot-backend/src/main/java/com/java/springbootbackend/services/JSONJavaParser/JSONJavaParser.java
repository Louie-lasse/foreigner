package com.java.springbootbackend.services.JSONJavaParser;

import com.google.gson.Gson;
import com.java.springbootbackend.model.WasteBin;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONJavaParser {
    public static void main(String[] args) {
        JSONArray array = new JSONArray("[{\"fullness\":0.55,\"coordinates\":{\"x\":57.69937227595341,\"y\":11.96984589099884}}" +
                ",{\"fullness\":0.24,\"coordinates\":{\"x\":55.1615165151565,\"y\":8.5415615515515}}]");

        Gson g = new Gson();
        WasteBin javaWasteBin;
        List<WasteBin> wasteBins = new ArrayList<>();

        for(int n = 0; n < array.length(); n++)
        {
            JSONObject JSONWasteBin = array.getJSONObject(n);
            javaWasteBin = g.fromJson(JSONWasteBin.toString(), WasteBin.class);
            wasteBins.add(javaWasteBin);
        }

        System.out.println(wasteBins);

        //System.out.println(javaWasteBin.getThis()); //John

        //System.out.println(g.toJson(javaWasteBin)); //{"name":"John"}
    }
}
