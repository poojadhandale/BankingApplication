package com.example.BankingProject.Controller;

import com.example.BankingProject.Entity.Account;
import com.example.BankingProject.Response.AccountResponse;
import com.example.BankingProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        try {
            return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addAccounts")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        Account newAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping("/accountById/{id}")
    public ResponseEntity<AccountResponse> getAccountById(@PathVariable Long id) {
        AccountResponse getAccount = accountService.getAccountById(id);
        return new ResponseEntity<>(getAccount, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<AccountResponse> deleteAccount(@PathVariable Long id) {
        AccountResponse deleteAccount = accountService.getAccountById(id);
        accountService.deleteAccountById(id);
        return new ResponseEntity<>(deleteAccount, HttpStatus.OK);
    }
}
