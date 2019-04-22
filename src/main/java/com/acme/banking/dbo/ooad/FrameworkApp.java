package com.acme.banking.dbo.ooad;

import com.acme.banking.dbo.ooad.dao.StubAccountRepository;
import com.acme.banking.dbo.ooad.domain.Account;
import com.acme.banking.dbo.ooad.service.NastolgieXchangeService;
import com.acme.banking.dbo.ooad.service.ReportingService;

import java.util.Collection;

public class FrameworkApp {
    public static void main(String[] args) {
        final ReportingService reportingService = new ReportingService(
                new NastolgieXchangeService(30),
                new StubAccountRepository()
        );

        final Collection<Account> accounts = reportingService.getAllAccountsInUsd();

        accounts.forEach(System.out::println);
    }
}
