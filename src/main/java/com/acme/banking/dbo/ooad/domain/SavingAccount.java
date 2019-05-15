package com.acme.banking.dbo.ooad.domain;

public class SavingAccount extends Account {

    public SavingAccount(double amount) {
        super(amount, 0);
    }

    @Override
    public String toString() {
        return "SavingAccount{ " + super.toString() + " }";
    }
}
