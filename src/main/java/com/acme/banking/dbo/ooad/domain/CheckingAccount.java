package com.acme.banking.dbo.ooad.domain;

public class CheckingAccount extends Account {

    public CheckingAccount(double amount, double overdraft) {
        super(amount, overdraft);
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "amount=" + amount +
                ", overdraft=" + overdraft +
                '}';
    }
}
