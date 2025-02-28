package com.example.BankingProject.Service;

import com.example.BankingProject.Entity.Account;
import com.example.BankingProject.Repository.AccountRepository;
import com.example.BankingProject.Response.AccountResponse;
import com.example.BankingProject.Response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public AccountResponse getAccountById(Long accountId) {

        Optional<Account> account = accountRepository.findById(accountId);
        AccountResponse accountResponse = mapper.map(account, AccountResponse.class);
        AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/address-service/address/{id}", AddressResponse.class, accountId);
        accountResponse.setAddressResponse(addressResponse);

        return accountResponse;
    }

    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }
}
