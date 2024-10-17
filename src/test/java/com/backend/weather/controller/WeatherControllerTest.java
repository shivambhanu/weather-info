package com.backend.weather.controller;

import com.backend.weather.controller.WeatherController;
import com.backend.weather.entity.WeatherInfo;
import com.backend.weather.repository.WeatherRepository;
import com.backend.weather.service.GeocodeService;
import com.backend.weather.service.WeatherService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WeatherControllerTest {

    @Autowired
    private WeatherController weatherController;

    @MockBean
    private WeatherRepository weatherRepository;

    @MockBean
    private GeocodeService geocodeService;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void testGetWeather() throws JSONException {
        Mockito.when(geocodeService.getLatLong("411014")).thenReturn(new double[]{18.5204, 73.8567});
        Mockito.when(weatherService.getWeatherInfo(18.5204, 73.8567, java.time.LocalDate.of(2020, 10, 15)))
                .thenReturn("{\"temp\": 300.15}");

        WeatherInfo weatherInfo = weatherController.getWeather("411014", "2020-10-15");
        assertNotNull(weatherInfo);
    }
}
