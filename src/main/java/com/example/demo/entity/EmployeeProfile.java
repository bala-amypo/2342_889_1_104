package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Student")

public class EmployeeProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
}