package com.example.BankingProject.Controller;

import com.example.BankingProject.Entity.Account;
import com.example.BankingProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/addAccounts")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        Account newAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping("/accountById/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> getAccount = accountService.getAccountById(id);
        return getAccount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Long id) {
        Account deleteAccount = accountService.getAccountById(id).orElse(null);
        accountService.deleteAccountById(id);
        return new ResponseEntity<>(deleteAccount, HttpStatus.OK);
    }
}
