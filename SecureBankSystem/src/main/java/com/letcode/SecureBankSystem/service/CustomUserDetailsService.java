package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.auth.CustomeUserDetails;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public CustomeUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buildCustomUserDetailsOfUsername(username);
    }

    private CustomeUserDetails buildCustomUserDetailsOfUsername(String username) {
        UserEntity user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Incorrect Username"));

        CustomeUserDetails userDetails = new CustomeUserDetails();
        userDetails.setId(user.getId());
        userDetails.setUserName(user.getUsername());
        userDetails.setPassword(user.getPassword());
        userDetails.setRole(user.getRole().getTitle().name());

        return userDetails;
    }
}

