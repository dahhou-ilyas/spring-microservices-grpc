package com.example.scorecalculator.repository;

import com.example.scorecalculator.domain.UserLogInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserLogInfoRepository extends JpaRepository<UserLogInfo, Long> {

    UserLogInfo findByIdNumber(BigInteger idNumber);
}
