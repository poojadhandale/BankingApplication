package com.example.BankingProject.Entity;

import jakarta.persistence.*;
        import lombok.Getter;
import lombok.Setter;


@Table(name = "accounts")
@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    private double balance;

}
