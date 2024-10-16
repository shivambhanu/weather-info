package com.backend.weather.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class WeatherInfo {

    @Id
    private String pincode;

    private LocalDate date;

    private double latitude;

    private double longitude;

    // Create a variable to store weather info.
}
