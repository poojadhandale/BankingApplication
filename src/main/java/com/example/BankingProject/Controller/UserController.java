package com.example.BankingProject.Controller;


import com.example.BankingProject.Entity.Users;
import com.example.BankingProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/welcome")
    public static String welcome() {
        return "Welcome, this endpoint is not secure";
    }

    @GetMapping("/getUsers")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Users addUser = userService.saveUser(user);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }
}

