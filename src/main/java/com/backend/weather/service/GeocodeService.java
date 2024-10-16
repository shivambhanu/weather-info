package com.backend.weather.service;

import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;


@Service
public class GeocodeService {
    private final String API_KEY = "670fb2eb0b393864048573wdqad738e";

    public String getLatLong(String pincode) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://geocode.maps.co/search?q="+ pincode + "&api_key=" + API_KEY;
        String response = restTemplate.getForObject(url, String.class);


        JSONObject json = new JSONObject(response);
        if (json.has("current")) {
            return json.getJSONObject("current").toString();  // Return JSON as String
        } else {
            throw new IllegalArgumentException("Weather information not available for this date");
        }
    }
}
