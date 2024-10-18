package com.backend.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeocodeResponse {
    private String zip;
    private String name;
    private double lat;
    private double lon;
    private String country;
}
