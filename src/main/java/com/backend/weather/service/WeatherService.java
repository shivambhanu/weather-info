package com.backend.weather.service;

import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.time.LocalDate;

@Service
public class WeatherService {

    private final String OPENWEATHER_API_KEY = "your_openweather_api_key";

    public String getWeatherInfo(double lat, double lon, LocalDate date) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        long timestamp = date.atStartOfDay().toEpochSecond(java.time.ZoneOffset.UTC);
        String url = "http://api.openweathermap.org/data/2.5/onecall/timemachine?lat=" + lat +
                "&lon=" + lon + "&dt=" + timestamp + "&appid=" + OPENWEATHER_API_KEY;

        String response = restTemplate.getForObject(url, String.class);
        JSONObject json = new JSONObject(response);

        if (json.has("current")) {
            return json.getJSONObject("current").toString();  // Return JSON as String
        } else {
            throw new IllegalArgumentException("Weather information not available for this date");
        }
    }
}
