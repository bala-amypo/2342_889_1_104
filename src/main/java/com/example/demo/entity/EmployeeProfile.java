package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Student")

public class EmployeeProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Should not contain blank spaces")
    @Column(unique=true)
    private String employeeID;
    @NotBlank(message="Should not contain blank spaces")
    private String fullName;
    @Email(message="Invalid format")
    @NotBlank(message="Should not contain blank spaces")
    @Column(unique=true)
    private String email;
    @NotBlank(message="Should not contain blank spaces")
    private String department;
    @NotBlank(message="Should not contain blank spaces")
    private String jobRole;
    private Boolean active;
    private LocalDateTime createAt;
    public EmployeeProfile(Long id,String employeeId)
}