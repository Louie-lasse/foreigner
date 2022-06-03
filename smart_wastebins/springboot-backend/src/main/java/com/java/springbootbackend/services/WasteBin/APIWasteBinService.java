package com.java.springbootbackend.services.WasteBin;

import com.google.gson.Gson;
import com.java.springbootbackend.model.WasteBin;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class APIWasteBinService implements IWasteBinService {

    private static final String apiToken = "INPUT API TOKEN";

    /**
     * Gets waste bins from bigbelly-API
     *
     * @return a list of {@link WasteBin} returned from the API
     */
    @Override
    public List<WasteBin> getWasteBins() {
        try {
            JsonNode jsonWasteBins = getJsonFromAPI("assets");
            List<WasteBin> bins = parseBins(jsonWasteBins);
            JsonNode errors = getJsonFromAPI("alerts");
            addErrors(bins, errors);
            return bins;
        } catch (UnirestException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void addErrors(List<WasteBin> bins, JsonNode errors) {
        //TODO ensure that the alerts connect to waste bins, assuming they exists
        Map<Long, WasteBin> binMap = getWasteBinMap(bins);
        ParsedAlerts alerts = new Gson().fromJson(errors.toString(), ParsedAlerts.class);
        for (ParsedAlerts.Alerts a : alerts.alerts) {
            if (!binMap.containsKey(a.serialNumber)) {
                System.out.println("Waste-bin with id: " + a.serialNumber + " not present");
            } else {
                WasteBin bin = binMap.get(a.serialNumber);
                bin.setAlertType(a.alertType);
                bin.setAlertCategory(a.alertCategory);
            }
        }
    }

    /**
     * Get a HashMap of serial number -> Wastebin
     *
     * @return a HashMap of {@link WasteBin} with serial number (long) as key.
     */
    private Map<Long, WasteBin> getWasteBinMap(List<WasteBin> wasteBins) {
        try {
            Map<Long, WasteBin> wasteBinMap = new HashMap<>();
            for (WasteBin wastebin : wasteBins) {
                wasteBinMap.put(wastebin.getSerialNumber(), wastebin);
            }
            return wasteBinMap;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }


    /**
     * Parses JSON data into waste bins
     *
     * @param json {@link JsonNode} data to be parsed
     * @return the list of parsed bins
     */
    private List<WasteBin> parseBins(JsonNode json) {
        try {
            ParsedBins object = new Gson().fromJson(json.toString(), ParsedBins.class);
            List<WasteBin> bins = new ArrayList<>();
            for (ParsedBins.InfoBin info : object.assets) {
                bins.add(new WasteBin(info.latitude, info.longitude, info.latestFullness, info.accountName, info.serialNumber, info.description));
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
    private JsonNode getJsonFromAPI(String type) throws UnirestException {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Token", apiToken);
        headers.put("Cache-Control", "no-cache");

        Map<String, Object> query = new HashMap<>();
        query.put("objectType", type);
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
     * private inner class used for parsing the JSON-data of wastebin-alerts
     */
    private class ParsedAlerts {
        private Alerts[] alerts;

        static class Alerts {
            private int accountId;
            private String accountName;
            private String alertType;
            private long serialNumber;
            private double Latitude;
            private int stationSerialNumber;
            private String Description;
            private long startTime;
            private String Position;
            private String alertCategory;
            private double Longitude;
        }

    }

    /**
     * private inner class used for parsing the JSON-data of wastebin-assets
     */
    private static class ParsedBins {
        private String errorCode;
        private InfoBin[] assets;

        static class InfoBin {
            private int latestFullness;
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
