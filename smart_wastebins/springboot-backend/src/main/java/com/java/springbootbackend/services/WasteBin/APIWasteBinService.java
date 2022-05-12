package com.java.springbootbackend.services.WasteBin;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.java.springbootbackend.model.WasteBin;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class APIWasteBinService implements IWasteBinService {

    /**
     * Gets waste bins from bigbelly-API
     *
     * @return a list of {@link WasteBin} returned from the API
     */
    @Override
    public List<WasteBin> getWasteBins() {
        try {
            JsonNode json = getJsonFromAPI();
            return parseBins(json);
        } catch (UnirestException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Pares JSON data into waste bins
     *
     * @param json {@link JsonNode} data to be parsed
     * @return the list of parsed bins
     */
    private List<WasteBin> parseBins(JsonNode json) {
        try {
            ParsedJson object = new Gson().fromJson(json.toString(), ParsedJson.class);
            List<WasteBin> bins = new ArrayList<>();
            for (ParsedJson.InfoBin info : object.assets) {
                bins.add(new WasteBin(info.latitude, info.longitude, info.latestFullness));
            }
            return bins;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Connects to the big belly API to retrieve waste bins
     *
     * @return a {@link JsonNode} object containing all waste bins
     * @throws UnirestException if connection to the client failed
     */
    private JsonNode getJsonFromAPI() throws UnirestException {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Token", "MtaHVvy974562ZbrKRSX");
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

    /**
     * private inner class used for parsing the JSON-data
     */
    private static class ParsedJson {
        private String errorCode;
        private InfoBin[] assets;

        static class InfoBin {
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
