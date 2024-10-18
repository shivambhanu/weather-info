package com.backend.weather.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PincodeToLatLong {
    @Id
    private String pincode;

    private Long latitude;

    private Long longitude;
}
