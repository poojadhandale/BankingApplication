package com.example.BankingProject.Integration;

import com.example.BankingProject.Entity.Account;
import com.example.BankingProject.Repository.AccountRepository;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost:" + port + "/";

    private static RestTemplate restTemplate;

    private AccountRepository accountRepository;

    private Account Nehal;

    private Account Pooja;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void beforeSetup(){
        baseUrl = baseUrl + "api/accounts";
    }

    @AfterEach
    public void afterSetup(){
        accountRepository.deleteAll();
    }

    @Test
    void getAllAccounts() {

        Account nehal = new Account();
        nehal.setAccountHolderName("Nehal");
        nehal.setBalance(3999);
        Account pooja = new Account();
        pooja.setAccountHolderName("Pooja");
        pooja.setBalance(1000);


        restTemplate.postForObject(baseUrl ,nehal, Account.class);
        restTemplate.postForObject(baseUrl ,pooja, Account.class);

        List<Account> accounts = restTemplate.getForObject(baseUrl, List.class);

        Assertions.assertNotNull(accounts);
        System.out.println(accounts);
    }


}
