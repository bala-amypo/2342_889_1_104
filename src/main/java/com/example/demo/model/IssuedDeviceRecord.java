package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name="Issued_DeviceRecord")

public class IssuedDeviceRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private String fullName;
    @Email(message="Invalid format")
    @Column(unique=true)
    private String email;
    private String department;
    private String jobRole;
    private Boolean active;
    private LocalDateTime createdAt;
    public EmployeeProfile(){}