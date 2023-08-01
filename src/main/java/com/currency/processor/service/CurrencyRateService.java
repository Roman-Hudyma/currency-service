package com.currency.processor.service;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CurrencyRateService {

    private final double eurRate = 0.93;

    //In the real case we need to use external api or data provider to fetch rates at the time we got a request.
    public Double calculateBaseCurrencyValue(String src, String dst, Instant at) {
        return eurRate;
    }
}
