package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.bo.CreateContactRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactAdding {

    //Array list is the child of the list, because the list is the parent
    List<CreateContactRequest> allContacts = new ArrayList<>();
    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@RequestBody CreateContactRequest createContactRequest) {
        for (int i=0;i<allContacts.size();i++){
            if (allContacts.get(i).getEmail().equals(createContactRequest.getEmail())){
                return  ResponseEntity.badRequest().body("Contact Already existed with this email");
            }
        }
        allContacts.add(createContactRequest);
        return  ResponseEntity.ok("Contact added successfully");
    }
    @GetMapping("/getContactDetails")
    public ResponseEntity<?> getContactDetails(@RequestParam String name){
        for (int i=0;i<allContacts.size();i++){
            if (allContacts.get(i).getName().equals(name)){
                return ResponseEntity.ok(allContacts.get(i));
            }
        }
        return ResponseEntity.badRequest().body("Contact not founded");
    }

}




