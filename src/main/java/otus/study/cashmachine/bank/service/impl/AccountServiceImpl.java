package otus.study.cashmachine.bank.service.impl;

import otus.study.cashmachine.bank.data.Account;
import otus.study.cashmachine.bank.db.Accounts;
import otus.study.cashmachine.bank.service.AccountService;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {
    @Override
    public Account createAccount(BigDecimal amount) {
        Account newAccount = new Account(Accounts.getNexyId(), amount);
        Accounts.accounts.put(newAccount.getId(), newAccount);
        return newAccount;
    }

    @Override
    public Account getAccount(Long id) {
        return Accounts.accounts.get(id);
    }

    @Override
    public BigDecimal getMoney(Long id, BigDecimal amount) {
        Account account = Accounts.accounts.get(id);
        checkAccount(account);
        if (account.getAmount().subtract(amount).doubleValue() < 10) {
            throw new IllegalArgumentException("Not enough money");
        }
        account.setAmount(account.getAmount().subtract(amount));
        return account.getAmount();
    }

    private static void checkAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
    }

    @Override
    public BigDecimal putMoney(Long id, BigDecimal amount) {
        Account account = getAccountById(id);
        checkAccount(account);
        account.setAmount(account.getAmount().add(amount));
        return account.getAmount();
    }

    private static Account getAccountById(Long id) {
        return Accounts.accounts.get(id);
    }

    @Override
    public BigDecimal checkBalance(Long id) {
        Account account = Accounts.accounts.get(id);
        checkAccount(account);
        return account.getAmount();
    }
}