package com.example.BankingProject.Service;

import com.example.BankingProject.Entity.Account;
import com.example.BankingProject.Repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    @DisplayName("Saving account")
    void saveAccount() {
        Account account = new Account();
        account.setAccountHolderName("Pooja");
        account.setBalance(3000);

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account newAccount = accountService.saveAccount(account);
        Assertions.assertNotNull(newAccount);
        Assertions.assertEquals("Pooja", newAccount.getAccountHolderName());
    }

    @Test
    void getAccountById() {
    }

    @Test
    void deleteAccountById() {
    }
}
