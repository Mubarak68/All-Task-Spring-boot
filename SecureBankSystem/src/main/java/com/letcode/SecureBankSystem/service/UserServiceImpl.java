package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.UserRepo;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.util.enums.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
 private final UserRepo userRepo;

 public UserServiceImpl(UserRepo userRepo){
     this.userRepo=userRepo;
 }


    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(String.valueOf(createUserRequest.getStatus())));
        userRepo.save(userEntity);
    }

    @Override
    public void updateUserStatus(Long userId, UpdateUserRequest updateUserRequest) {
        UserEntity userEntity = userRepo.findById(userId)
                .orElseThrow();

        if (!updateUserRequest.getStatus().equals("ACTIVE") && !updateUserRequest.getStatus().equals("INACTIVE")){
            throw new IllegalArgumentException("The status should be ACTIVE or INACTIVE");
        }
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus()));
        userRepo.save(userEntity);

    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }



}

