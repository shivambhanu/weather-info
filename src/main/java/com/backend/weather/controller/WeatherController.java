package com.backend.weather.controller;

import com.backend.weather.dto.WeatherResponse;
import com.backend.weather.entity.PincodeToLatLong;
import com.backend.weather.entity.Weather;
import com.backend.weather.repository.WeatherRepository;
import com.backend.weather.service.GeocodeService;
import com.backend.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private GeocodeService geocodeService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public WeatherResponse getWeather(@RequestParam String pincode, @RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);

        // Check if weather data already exists in DB
//        Weather existingData = weatherRepository.findByPincodeAndDate(pincode, date);
//        if (existingData != null) {
//            return existingData;  // Return cached data
//        }

        PincodeToLatLong pincodeToLatLong = geocodeService.getLatLong(pincode);
        double lat = pincodeToLatLong.getLatitude();
        double lon = pincodeToLatLong.getLongitude();

        // Fetch weather info from OpenWeather API
        WeatherResponse weatherResponse = weatherService.getWeatherInfo(lat, lon, localDate);

        // Save new weather data to DB
//        Weather newWeather = new Weather();
//        newWeather.setPincode(pincode);
//        newWeather.setLat(lat);
//        newWeather.setLon(lon);
//        newWeather.setDate(date);
//        newWeather.setWeatherInfo(weatherInfo);
//        weatherRepository.save(newWeather);

        return weatherResponse;
    }
}

