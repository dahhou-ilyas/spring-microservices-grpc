package com.example.scorecalculator.rest;

import com.example.scorecalculator.domain.IncomeBracketMultiplierInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@Validated
public class ScoreCalculatorRestService {
    private final Environment environment;

    private final ObjectMapper objectMapper;

    private final IncomeBracketMultiplierInfoService incomeBracketMultiplierInfoService;

    private final ScoreCalculatorService scoreCalculatorService;
    private final UserLogInfoService userLogInfoService;

    @GetMapping("/income-bracket-multiplier-info")
    public ResponseEntity<List<IncomeBracketMultiplierInfo>> getIncomeBracketMultiplierInfo(HttpServletResponse response) {
        response.setHeader(HeaderConstants.X_TOTAL_COUNT.getValue(),
                incomeBracketMultiplierInfoService.getIncomeBracketMultiplerInfoCount().toString());
        return new ResponseEntity<>(incomeBracketMultiplierInfoService.getIncomeBracketMultiplerInfo(), HttpStatus.OK);
    }

    @GetMapping("/calculate-score")
    public BigInteger calculateCityScore(@RequestParam Map<String, Object> scoreCalculatorParamMap) {
        ScoreCalculatorRequest scoreCalculatorRequest = objectMapper.convertValue(scoreCalculatorParamMap, ScoreCalculatorRequest.class);
        scoreCalculatorService.calculateScore(scoreCalculatorRequest);

        userLogInfoService.saveUserLog(scoreCalculatorRequest);
        return scoreCalculatorService.calculateScore(scoreCalculatorRequest);
    }

}
