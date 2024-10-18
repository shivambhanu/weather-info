package com.backend.weather.service;
import com.backend.weather.dto.GeocodeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class GeocodeService {
    private Dotenv dotenv = Dotenv.load();
    private String geocodingApiKey = dotenv.get("OPENWEATHER_API_KEY");

    public GeocodeResponse getLatLong(String pincode) {
        String url = "https://api.openweathermap.org/geo/1.0/zip?zip="+ pincode +",IN&appid=" + geocodingApiKey;
//      Example:  https://api.openweathermap.org/geo/1.0/zip?zip=852201,IN&appid=9ca1b469920197a4d21d30bae7c388f4

        RestTemplate restTemplate = new RestTemplate();
        GeocodeResponse geoRes = restTemplate.getForObject(url, GeocodeResponse.class);

        return geoRes;
    }
}
