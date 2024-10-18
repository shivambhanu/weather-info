package com.backend.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private String main;
    private String description;
    private double temperature;
    private double feelsLike;
    private double minimumTemp;
    private double maximumTemp;
    private int pressure;
    private int humidity;
    private double windSpeed;
}
