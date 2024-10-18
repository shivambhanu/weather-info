package com.backend.weather.repository;

import com.backend.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    public Weather findByPincodeAndDate(String pincode, LocalDate date);
}
