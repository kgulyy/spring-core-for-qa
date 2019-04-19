package com.acme.banking.dbo.ooad.domain;

import java.util.Collection;

public interface AccountRepository {
    Collection<Account> getAllAccounts();
}
