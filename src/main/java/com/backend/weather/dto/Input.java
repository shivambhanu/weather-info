package com.backend.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Input {
    private String pincode;
    private LocalDate date;
}
