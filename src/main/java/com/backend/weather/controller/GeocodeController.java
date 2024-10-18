package com.backend.weather.controller;

import com.backend.weather.dto.GeocodeResponse;
import com.backend.weather.service.GeocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeocodeController {

    @Autowired
    private GeocodeService geocodeService;

    @GetMapping("/geocode/{pincode}")
    private ResponseEntity<GeocodeResponse> getGeocodeResponse(@PathVariable String pincode){
        return new ResponseEntity<>(geocodeService.getLatLong(pincode), HttpStatus.OK);
    }
}
