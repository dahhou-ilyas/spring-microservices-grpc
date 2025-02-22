package com.example.cityscore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityScoreResponse {
    private Integer cityScore;
    private String environment;
}
