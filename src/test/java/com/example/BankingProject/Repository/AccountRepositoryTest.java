package com.example.BankingProject.Repository;

import com.example.BankingProject.Entity.Users;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void usersList() {
        userRepository.save(new Users(1L,"Pooja","Rohini","ADMIN,USER"));
        List<Users> users = userRepository.findAll();
        Assert.assertNotNull(users);
        Assert.assertEquals(1, users.size());
    }

}
