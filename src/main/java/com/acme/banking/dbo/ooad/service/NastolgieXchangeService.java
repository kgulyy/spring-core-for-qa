package com.acme.banking.dbo.ooad.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@Lazy
@PropertySource("classpath:app.properties")
public class NastolgieXchangeService implements CurrencyService {
    @Value("${rurToUsdRate}")
    private double rurToUsdRate;

    @Override
    public double getXchangeRate() {
        return rurToUsdRate;
    }
}
