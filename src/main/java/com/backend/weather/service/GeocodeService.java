package com.backend.weather.service;

import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;


@Service
public class GeocodeService {
    private final String API_KEY = "670fb2eb0b393864048573wdqad738e";

    public double[] getLatLong(String pincode) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://geocode.maps.co/search?q="+ pincode + "&api_key=" + API_KEY;
        String response = restTemplate.getForObject(url, String.class);


        JSONObject json = new JSONObject(response);
        if (json.getJSONArray("results").length() > 0) {
            JSONObject location = json.getJSONArray("results")
                    .getJSONObject(0)
                    .getJSONObject("geometry")
                    .getJSONObject("location");
            double lat = location.getDouble("lat");
            double lon = location.getDouble("lng");
            return new double[]{lat, lon};
        } else {
            throw new IllegalArgumentException("Invalid pincode or no location found");
        }
    }
}
