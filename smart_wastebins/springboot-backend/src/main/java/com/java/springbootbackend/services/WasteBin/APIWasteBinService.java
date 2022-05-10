package com.java.springbootbackend.services.WasteBin;

import com.google.gson.Gson;
import com.java.springbootbackend.model.WasteBin;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIWasteBinService implements IWasteBinService {

    public static void main(String[] args) {
        new APIWasteBinService().getWasteBins().forEach(System.out::println);
    }

    @Override
    public List<WasteBin> getWasteBins() {
        try {
            JsonNode json = getJsonFromAPI();
            return parseBins(json);
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    private List<WasteBin> parseBins(JsonNode json) {
        ParsedJson object = new Gson().fromJson(json.toString(), ParsedJson.class);
        List<WasteBin> bins = new ArrayList<>();
        for (ParsedJson.InfoBin info : object.assets) {
            bins.add(new WasteBin(info.longitude, info.latitude, info.latestFullness));
        }
        return bins;
    }

    private JsonNode getJsonFromAPI() throws UnirestException {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Token", "THIS IS TOTALY A LEGIT API-TOKEN!!!!");
        headers.put("Cache-Control", "no-cache");

        Map<String, Object> query = new HashMap<>();
        query.put("objectType", "assets");
        query.put("action", "load");

        com.mashape.unirest.http.HttpResponse<JsonNode> response = Unirest.get("https://api.bigbelly.com/api/v2")
                .headers(headers)
                .queryString(query)
                .asJson();
        if (response.getStatus() != HttpServletResponse.SC_OK) {
            throw new RuntimeException("Http response: " + response.getStatus());
        }
        return response.getBody();
    }

    private class ParsedJson {
        private String errorCode;
        private InfoBin[] assets;

        class InfoBin {
            private long latestFullness;
            private String reason;
            private long serialNumber;
            private String accountName;
            private double latitude;
            private long stationSerialNumber;
            private String description;
            private long ageThreshold;
            private long fullnessThreshold;
            private long lastCall;
            private long accountId;
            private String streamType;
            private String position;
            private double longitude;

        }
    }


}
