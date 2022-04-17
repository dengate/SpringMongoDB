package com.example.account.controller;

import com.example.account.dto.response.UserResponse;
import com.example.account.model.User;
import com.example.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/account/user")
public class UserController {

    @Autowired
    UserService service;

    @PostConstruct
    void init(){
        User user = new User();
        user.setUserId(ThreadLocalRandom.current().nextInt());
        user.setUsername("ahmet");
        user.setPassword("12345");
        add(user);
    }

    @PostMapping
    public ResponseEntity<UserResponse> add(@RequestBody User request){
            UserResponse response = service.add(request);
            return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> get(){
        List<UserResponse> response = service.get();
        return ResponseEntity.ok(response);
    }
}
