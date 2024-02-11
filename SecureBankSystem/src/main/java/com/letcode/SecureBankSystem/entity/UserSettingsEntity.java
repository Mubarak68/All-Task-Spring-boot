package com.letcode.SecureBankSystem.entity;

import javax.persistence.*;

@Entity
@Table(name="user_settings")
public class UserSettingsEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean receiveNewsletter;

    private String preferredLanguage;

    // setter and getter

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
