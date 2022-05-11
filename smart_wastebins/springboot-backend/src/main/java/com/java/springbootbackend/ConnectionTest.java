package com.java.springbootbackend;

import netscape.javascript.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectionTest {

    public static void main(String[] args){
        try {
            URL url = new URL("https://api.bigbelly.com/api/v2/");

            JSONObject querystring = new JSONObject();
            querystring.put("objectType", "accounts");
            querystring.put("action", "load");

            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

//Getting the response code
            int responsecode = conn.getResponseCode();
            if (responsecode != 200) {
                throw new RuntimeException("HttpsResponseCode: " + responsecode);
            } else {

                List<String> objects = new ArrayList<>();
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    objects.add(scanner.nextLine());
                }

                //Close the scanner
                scanner.close();

                //Get the required data using its key
                objects.forEach(System.out::println);
            }
            conn.disconnect();

        } catch (IndexOutOfBoundsException | IOException e){
            e.printStackTrace();
        }
    }
}
