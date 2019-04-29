package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.dao.AccountRepository;
import com.acme.banking.dbo.ooad.domain.Account;
import com.acme.banking.dbo.ooad.domain.CheckingAccount;
import com.acme.banking.dbo.ooad.domain.SavingAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring-context-ooad.xml"})
public class ReportingServiceTest {
    @Autowired
    private ReportingService reportingService;
    @MockBean
    private AccountRepository repository;

    @Test
    public void empty() {
        when(repository.getAllAccounts()).thenReturn(Collections.emptyList());

        final Collection<Account> result = reportingService.getAllAccountsInUsd();

        assertThat(result).isEmpty();
    }

    @Test
    public void negativeAmount() {
        final Collection<Account> accounts = Collections.singletonList(new SavingAccount(-300));
        when(repository.getAllAccounts()).thenReturn(accounts);

        final Collection<Account> result = reportingService.getAllAccountsInUsd();

        assertThat(result).containsOnly(new SavingAccount(-10));
    }

    @Test
    public void zeroAmountAndOverdraft() {
        final Collection<Account> accounts = Collections.singletonList(new CheckingAccount(0, 0));
        when(repository.getAllAccounts()).thenReturn(accounts);

        final Collection<Account> result = reportingService.getAllAccountsInUsd();

        assertThat(result).containsOnly(new CheckingAccount(0, 0));
    }

    @Test
    public void onlySavingAccounts() {
        final Collection<Account> accounts = Arrays.asList(
                new SavingAccount(300),
                new SavingAccount(1_200)
        );
        when(repository.getAllAccounts()).thenReturn(accounts);

        final Collection<Account> result = reportingService.getAllAccountsInUsd();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsOnly(new SavingAccount(10), new SavingAccount(40));
    }

    @Test
    public void onlyCheckingAccounts() {
        final Collection<Account> accounts = Arrays.asList(
                new CheckingAccount(150, 690),
                new CheckingAccount(4200, 18_000),
                new CheckingAccount(30_000, 120_000)
        );
        when(repository.getAllAccounts()).thenReturn(accounts);

        final Collection<Account> result = reportingService.getAllAccountsInUsd();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result).containsOnly(
                new CheckingAccount(5, 23),
                new CheckingAccount(140, 600),
                new CheckingAccount(1_000, 4_000)
        );
    }

    @Test
    public void allTypeAccounts() {
        final Collection<Account> accounts = Arrays.asList(
                new SavingAccount(1_500),
                new CheckingAccount(3_000, 6_000)
        );
        when(repository.getAllAccounts()).thenReturn(accounts);

        final Collection<Account> result = reportingService.getAllAccountsInUsd();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsOnly(
                new SavingAccount(50),
                new CheckingAccount(100, 200)
        );
    }
}
