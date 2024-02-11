package com.letcode.SecureBankSystem.entity;

import javax.persistence.*;

@Table(name = "user_setting")
@Entity
public class UserSettingsEntity {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean receiveNewletter;

    private String preferredLanguage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isReceiveNewletter() {
        return receiveNewletter;
    }

    public void setReceiveNewletter(boolean receiveNewletter) {
        this.receiveNewletter = receiveNewletter;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
    public UserSettingsEntity(Long id, boolean receiveNewletter, String preferredLanguage) {
        this.id = id;
        this.receiveNewletter = receiveNewletter;
        this.preferredLanguage = preferredLanguage;
    }

    @OneToOne
    @JoinColumn(name = "user_id") //is the foreign key to link one to one 
    private UserEntity user;

}
