package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.dao.AccountRepository;
import com.acme.banking.dbo.ooad.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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
}
