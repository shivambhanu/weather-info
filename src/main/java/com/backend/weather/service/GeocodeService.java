package com.backend.weather.service;
import com.backend.weather.dto.GeocodeResponse;
import com.backend.weather.entity.PincodeToLatLong;
import com.backend.weather.repository.PincodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;

@Service
public class GeocodeService {
    @Autowired
    private PincodeRepository pincodeRepository;

    private Dotenv dotenv = Dotenv.load();
    private String geocodingApiKey = dotenv.get("OPENWEATHER_API_KEY");

    public PincodeToLatLong getLatLong(String pincode) {
        if(pincodeRepository.findById(pincode).isPresent()){
            return pincodeRepository.findById(pincode).get();
        } else {
            String url = "https://api.openweathermap.org/geo/1.0/zip?zip="+ pincode +",IN&appid=" + geocodingApiKey;
//      Example:  https://api.openweathermap.org/geo/1.0/zip?zip=852201,IN&appid=9ca1b469920197a4d21d30bae7c388f4

            RestTemplate restTemplate = new RestTemplate();
            GeocodeResponse geoRes = restTemplate.getForObject(url, GeocodeResponse.class);

            PincodeToLatLong pincodeToLatLong = new PincodeToLatLong(pincode, geoRes.getLat(), geoRes.getLon());
            return pincodeRepository.save(pincodeToLatLong);
        }

    }


    public List<PincodeToLatLong> getAllPincodeToLatLong(){
        return pincodeRepository.findAll();
    }
}
