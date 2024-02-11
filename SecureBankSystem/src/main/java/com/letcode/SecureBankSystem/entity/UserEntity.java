package com.letcode.SecureBankSystem.entity;
import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.util.enums.Status;

import javax.persistence.*;

@Table(name = "bank_users")
@Entity
public class UserEntity {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
    @Column(name = "email",nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;


    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(CreateUserRequest createUserRequest) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber(CreateUserRequest createUserRequest) {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail(CreateUserRequest createUserRequest) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}


