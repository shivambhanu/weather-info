package com.backend.weather.repository;

import com.backend.weather.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherInfo, Long> {
}
