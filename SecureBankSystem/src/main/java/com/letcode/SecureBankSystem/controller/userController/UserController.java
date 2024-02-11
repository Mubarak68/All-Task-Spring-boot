package com.letcode.SecureBankSystem.controller.userController;

import com.letcode.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.service.UserService;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){

        this.userService = userService;
    }
    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest){
        try {
        userService.saveUser(createUserRequest);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User has been Created");
    }

    @PutMapping("/update_user_status")
    public ResponseEntity<String> updateUser(@RequestParam Long userId,@RequestBody UpdateUserRequest updateUserRequest) {
        try {
            userService.updateUserStatus(userId ,updateUserRequest);
        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User Updated successfully");
    }

    @GetMapping("/users-list")
    public List<UserEntity> getAllUsers(){
       return userService.getAllUsers();
    }
}
