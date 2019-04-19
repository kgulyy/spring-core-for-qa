package com.acme.banking.dbo.ooad.domain;

public abstract class Account {
    protected double amount;
    protected double overdraft;

    public Account(double amount, double overdraft) {
        this.amount = amount;
        this.overdraft = overdraft;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getOverdraft() {
        return overdraft;
    }
}
