package com.backend.weather.controller;

import com.backend.weather.dto.WeatherResponse;
import com.backend.weather.entity.PincodeToLatLong;
import com.backend.weather.entity.Weather;
import com.backend.weather.service.GeocodeService;
import com.backend.weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
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
    private GeocodeService geocodeService;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void testGetWeather() throws JSONException {
        String json = """
        {
          "coord": {
            "lon": 86.5961,
            "lat": 25.875
          },
          "weather": [
            {
              "id": 800,
              "main": "Clear",
              "description": "clear sky",
              "icon": "01n"
            }
          ],
          "main": {
            "temp": 296.95,
            "feels_like": 297.29,
            "temp_min": 296.95,
            "temp_max": 296.95,
            "pressure": 1010,
            "humidity": 73
          },
          "wind": {
            "speed": 1.95,
            "deg": 57,
            "gust": 1.98
          }
        }
        """;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert JSON string to WeatherResponse object
            WeatherResponse weatherResponse = objectMapper.readValue(json, WeatherResponse.class);
            System.out.println(weatherResponse);

            Mockito.when(geocodeService.getLatLong("852201")).thenReturn(new PincodeToLatLong("852201", 25.875, 86.5961));

            Mockito.when(weatherService.getWeatherInfo(25.875, 86.5961)).thenReturn(weatherResponse);

            Weather weather = weatherController.getWeatherInfo("852201");
            assertNotNull(weather);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
