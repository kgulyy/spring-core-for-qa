package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.domain.Account;
import com.acme.banking.dbo.ooad.dao.AccountRepository;

import java.util.Collection;
import java.util.Collections;

public class ReportingService {
    private CurrencyService currencyService;
    private AccountRepository repository;

    public ReportingService(CurrencyService currencyService, AccountRepository repository) {
        this.currencyService = currencyService;
        this.repository = repository;
    }

    public Collection<Account> getAllAccountsInUsd() {
        final double xchangeRate = currencyService.getXchangeRate();
        final Collection<Account> accounts = repository.getAllAccounts();

        accounts.forEach((account) -> {
            account.setAmount(account.getAmount() / xchangeRate);
            account.setOverdraft(account.getOverdraft() / xchangeRate);
        });

        return Collections.unmodifiableCollection(accounts);
    }
}
