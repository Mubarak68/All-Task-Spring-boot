package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.bo.CreateFarewellRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CodedController {
    
    @GetMapping("/sayHi")
    public String sayHi(){
        return "Welcome to Coded";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "Welcome, "+ name + " !!";
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody CreateFarewellRequest createFarewellRequest){
        return "GoodBye, " + createFarewellRequest.getName() ;
    }
}
