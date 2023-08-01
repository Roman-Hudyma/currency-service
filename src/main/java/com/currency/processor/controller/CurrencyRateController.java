package com.currency.processor.controller;

import com.currency.processor.dto.CurrencyConversationRateDto;
import com.currency.processor.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    @GetMapping("/currency/rate/{src}/{dst}")
    public CurrencyConversationRateDto getCurrencyRate(
            @PathVariable String src,
            @PathVariable String dst,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant at) {
        double rateValue = currencyRateService.calculateBaseCurrencyValue(src, dst, at);

        return CurrencyConversationRateDto.builder().build();
    }
}
