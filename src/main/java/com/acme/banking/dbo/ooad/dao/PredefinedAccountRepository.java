package com.acme.banking.dbo.ooad.dao;

import com.acme.banking.dbo.ooad.domain.Account;
import com.acme.banking.dbo.ooad.domain.CheckingAccount;
import com.acme.banking.dbo.ooad.domain.SavingAccount;

import java.util.Arrays;
import java.util.Collection;

public class PredefinedAccountRepository implements AccountRepository {
    private static final int AMOUNT_300 = 300;
    private static final int AMOUNT_600 = 600;
    private static final int AMOUNT_1200 = 1200;
    private static final int AMOUNT_1800 = 1800;
    private static final int OVERDRAFT_300 = 300;
    private static final int OVERDRAFT_1200 = 1200;

    @Override
    public Collection<Account> getAllAccounts() {
        return Arrays.asList(
                new SavingAccount(AMOUNT_300),
                new SavingAccount(AMOUNT_600),
                new CheckingAccount(AMOUNT_1200, OVERDRAFT_300),
                new CheckingAccount(AMOUNT_1800, OVERDRAFT_1200)
        );
    }
}
