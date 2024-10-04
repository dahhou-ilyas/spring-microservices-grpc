package com.example.scorecalculator.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
public class UserLogInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date createDate;

    @Column
    private Date lastModifiedDate;

    @Column
    private BigInteger idNumber;

    @Column(length=500)
    private String latestTrxnInfo;
}
