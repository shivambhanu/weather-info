//package com.backend.weather.controller;
//
//import com.backend.weather.entity.WeatherInfo;
//import com.backend.weather.repository.WeatherRepository;
//import com.backend.weather.service.GeocodeService;
//import com.backend.weather.service.WeatherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/weather")
//public class WeatherController {
//
//    @Autowired
//    private WeatherRepository weatherRepository;
//
//    @Autowired
//    private GeocodeService geocodeService;
//
//    @Autowired
//    private WeatherService weatherService;
//
//    @GetMapping
//    public WeatherInfo getWeather(@RequestParam String pincode, @RequestParam String for_date) {
//        LocalDate date = LocalDate.parse(for_date);
//
//        // Check if weather data already exists in DB
//        WeatherInfo existingData = weatherRepository.findByPincodeAndDate(pincode, date);
//        if (existingData != null) {
//            return existingData;  // Return cached data
//        }
//
//        // Fetch lat/long from Geocode API
//        double[] latLon = geocodeService.getLatLong(pincode);
//        double lat = latLon[0];
//        double lon = latLon[1];
//
//        // Fetch weather info from OpenWeather API
//        String weatherInfo = weatherService.getWeatherInfo(lat, lon, date);
//
//        // Save new weather data to DB
//        WeatherInfo newWeatherInfo = new WeatherInfo();
//        newWeatherInfo.setPincode(pincode);
//        newWeatherInfo.setLat(lat);
//        newWeatherInfo.setLon(lon);
//        newWeatherInfo.setDate(date);
//        newWeatherInfo.setWeatherInfo(weatherInfo);
//
//        weatherRepository.save(newWeatherInfo);
//
//        return newWeatherInfo;
//    }
//}
//
