package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="User_Account")

public class UserAccount{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String passwordHash;
    private String ADMIN;
    private String IT_OPERATOR;
    private String AUDITOR;
    private Boolean active;
    public UserAccount(){}
    public UserAccount(Long id, String fullName, String email, String passwordHash, String aDMIN, String iT_OPERATOR,
            String aUDITOR, Boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        ADMIN = aDMIN;
        IT_OPERATOR = iT_OPERATOR;
        AUDITOR = aUDITOR;
        this.active = active;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public String getADMIN() {
        return ADMIN;
    }
    public void setADMIN(String aDMIN) {
        ADMIN = aDMIN;
    }
    public String getIT_OPERATOR() {
        return IT_OPERATOR;
    }
    public void setIT_OPERATOR(String iT_OPERATOR) {
        IT_OPERATOR = iT_OPERATOR;
    }
    public String getAUDITOR() {
        return AUDITOR;
    }
    public void setAUDITOR(String aUDITOR) {
        AUDITOR = aUDITOR;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}