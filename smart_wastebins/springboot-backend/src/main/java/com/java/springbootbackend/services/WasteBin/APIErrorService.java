package com.java.springbootbackend.services.WasteBin;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class APIErrorService {
    /**
     * Connects to the big belly API to retrieve wastebins-errors
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
        query.put("alerts", "load");

        com.mashape.unirest.http.HttpResponse<JsonNode> response = Unirest.get("https://api.bigbelly.com/api/v2")
                .headers(headers)
                .queryString(query)
                .asJson();
        if (response.getStatus() != HttpServletResponse.SC_OK) {
            throw new RuntimeException("Http response: " + response.getStatus());
        }
        return response.getBody();
    }
}
