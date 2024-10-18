package com.backend.weather.service;
import com.backend.weather.dto.WeatherResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class WeatherService {

    private Dotenv dotenv = Dotenv.load();
    private String openweatherApiKey = dotenv.get("OPENWEATHER_API_KEY");

    public WeatherResponse getWeatherInfo(double lat, double lon, LocalDate date) {
        RestTemplate restTemplate = new RestTemplate();
        long timestamp = date.atStartOfDay().toEpochSecond(java.time.ZoneOffset.UTC);

        //  https://api.openweathermap.org/data/2.5/weather?lat=57&lon=-2.15&appid=9ca1b469920197a4d21d30bae7c388f4
         String url = "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+openweatherApiKey;

        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
        System.out.println("Weather Response: " + weatherResponse);

        return weatherResponse;
    }
}
