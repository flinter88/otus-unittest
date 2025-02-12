package otus.study.cashmachine.bank.service;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import otus.study.cashmachine.bank.dao.AccountDao;
import otus.study.cashmachine.bank.data.Account;
import otus.study.cashmachine.bank.service.impl.AccountServiceImpl;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;


public class AccountServiceTest {

    @Mock
    AccountDao accountDao;
//    @Mock
//    AccountService accountService;
    //AccountServiceImpl accountService;
    Account testAccount;
    BigDecimal initialAmount;
    long id;

    @BeforeEach
    void init() {
        initialAmount = BigDecimal.valueOf(5000);
        id = 1L;
        AccountService accountService = new AccountServiceImpl(accountDao);
        testAccount = new Account(id, initialAmount);
    }

    @Test
    void createAccountMock() {
// @TODO test account creation with mock and ArgumentMatcher
        when()

    }

    @Test
    void createAccountCaptor() {
//  @TODO test account creation with ArgumentCaptor
    }

    @Test
    void addSum() {
    }

    @Test
    void getSum() {
    }

    @Test
    void getAccount() {
    }

    @Test
    void checkBalance() {
    }
}
