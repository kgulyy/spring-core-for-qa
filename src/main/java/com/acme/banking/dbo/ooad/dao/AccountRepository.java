package com.acme.banking.dbo.ooad.dao;

import com.acme.banking.dbo.ooad.domain.Account;

import java.util.Collection;

public interface AccountRepository {
    Collection<Account> getAllAccounts();
}
