package com.backend.weather.controller;

import com.backend.weather.dto.WeatherResponse;
import com.backend.weather.entity.PincodeToLatLong;
import com.backend.weather.entity.Weather;
import com.backend.weather.service.GeocodeService;
import com.backend.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @Autowired
    private GeocodeService geocodeService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public Weather getWeatherInfo(@RequestParam String pincode) {
        PincodeToLatLong pincodeToLatLong = geocodeService.getLatLong(pincode);
        double lat = pincodeToLatLong.getLatitude();
        double lon = pincodeToLatLong.getLongitude();

        // Fetch weather info from OpenWeather API
        WeatherResponse weatherResponse = weatherService.getWeatherInfo(lat, lon);

        // Save new weather data to DB
        Weather newWeather = new Weather(
                weatherResponse.getWeather().get(0).getMain(),
                weatherResponse.getWeather().get(0).getDescription(),
                weatherResponse.getMain().getTemp(),
                weatherResponse.getMain().getFeels_like(),
                weatherResponse.getMain().getTemp_min(),
                weatherResponse.getMain().getTemp_max(),
                weatherResponse.getMain().getPressure(),
                weatherResponse.getMain().getHumidity(),
                weatherResponse.getWind().getSpeed()
        );

        return newWeather;
    }
}

