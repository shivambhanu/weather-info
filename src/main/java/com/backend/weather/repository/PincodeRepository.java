package com.backend.weather.repository;

import com.backend.weather.entity.PincodeToLatLong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodeRepository extends JpaRepository<PincodeToLatLong, String> {

}
