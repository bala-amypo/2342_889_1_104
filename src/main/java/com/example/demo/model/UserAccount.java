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
    p
    public IssuedDeviceRecord(){}