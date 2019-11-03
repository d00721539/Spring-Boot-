package com.example.demo.Entity;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private boolean businessBoolean;
    private String businessName;
    private boolean accountDisabledStatus;
    public User(){

    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isBusinessBoolean() {
        return businessBoolean;
    }

    public void setBusinessBoolean(boolean businessBoolean) {
        this.businessBoolean = businessBoolean;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public boolean isAccountDisabledStatus() {
        return accountDisabledStatus;
    }

    public void setAccountDisabledStatus(boolean accountDisabledStatus) {
        this.accountDisabledStatus = accountDisabledStatus;
    }
}
