package com.acme.banking.dbo.ooad.service;

public class NastolgieXchangeService implements CurrencyService {
    private double rate;

    public NastolgieXchangeService(double rate) {
        this.rate = rate;
    }

    @Override
    public double getXchangeRate() {
        return rate;
    }
}
