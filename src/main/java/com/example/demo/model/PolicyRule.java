package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name="Policy_Rule")

public class PolicyRule{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true)
    private String ruleCode;
    private String description;
    private String appliesToDepartment;
    private String appliesToRole;
    private Integer maxDevicesAllowed;
    private Boolean active; 
}