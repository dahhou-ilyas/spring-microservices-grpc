package com.example.scorecalculator.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ncomeBracketMultiplierInfo {
    @Id
    private Long id;

    @Column
    private String currency;

    @Column
    private Integer minThreshold;

    @Column
    private Integer maxThreshold;

    @Column
    private Integer multiplier;
}
