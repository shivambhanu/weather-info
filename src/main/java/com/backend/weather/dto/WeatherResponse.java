package com.backend.weather.dto;

import lombok.Data;
import java.util.List;

@Data
public class WeatherResponse {

    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private Wind wind;

    @Data
    public static class Coord {
        private double lon;
        private double lat;
    }

    @Data
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Data
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
    }

    @Data
    public static class Wind {
        private double speed;
        private int deg;
        private double gust;
    }
}
