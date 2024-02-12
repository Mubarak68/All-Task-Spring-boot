package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.ropsitory.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AbminController {
    public final UserRepository userRepository;

    public AbminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers(){
        List<UserEntity> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }

}
