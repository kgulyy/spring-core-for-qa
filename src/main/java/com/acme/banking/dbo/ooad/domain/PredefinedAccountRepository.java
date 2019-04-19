package com.acme.banking.dbo.ooad.domain;

import java.util.Arrays;
import java.util.Collection;

public class PredefinedAccountRepository implements AccountRepository {
    @Override
    public Collection<Account> getAllAccounts() {
        return Arrays.asList(
                new SavingAccount(300),
                new SavingAccount(600),
                new CheckingAccount(1200, 300),
                new CheckingAccount(1800, 1000)
        );
    }
}
