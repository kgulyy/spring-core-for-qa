package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.dao.AccountRepository;
import com.acme.banking.dbo.ooad.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class ReportingService {
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private AccountRepository repository;

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
