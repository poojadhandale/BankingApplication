package com.example.BankingProject.Repository;

import com.example.BankingProject.Entity.Account;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveAccount() {
        Account account = new Account();
        account.setAccountHolderName("Pooja");
        account.setBalance(3000);
        Account newAccount = accountRepository.save(account);

        Assertions.assertNotNull(newAccount);
        Assertions.assertNotNull(newAccount.getId());
    }
}
