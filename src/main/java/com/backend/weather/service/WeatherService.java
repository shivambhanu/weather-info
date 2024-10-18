package com.backend.weather.service;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class WeatherService {

    private Dotenv dotenv = Dotenv.load();
    private String openweatherApiKey = dotenv.get("OPENWEATHER_API_KEY");

    public String getWeatherInfo(double lat, double lon, LocalDate date) {
        RestTemplate restTemplate = new RestTemplate();
        long timestamp = date.atStartOfDay().toEpochSecond(java.time.ZoneOffset.UTC);


        // https://history.openweathermap.org/data/3.0/history/timemachine?lat={lat}&lon={lon}&dt={dt}&appid={API_KEY}
         String url = "https://history.openweathermap.org/data/3.0/history/timemachine?lat="+lat+"&lon="+lon+"&dt="+date+"&appid="+openweatherApiKey;

        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);

        return "filler";
    }
}
