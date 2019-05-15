package com.acme.banking.dbo.ooad.domain;

public abstract class Account {
    private double amount;
    private double overdraft;

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

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Account account = (Account) o;

        if (Double.compare(account.amount, amount) != 0) return false;
        return Double.compare(account.overdraft, overdraft) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(amount);
        int result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(overdraft);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "amount=" + amount + ", overdraft=" + overdraft;
    }
}
