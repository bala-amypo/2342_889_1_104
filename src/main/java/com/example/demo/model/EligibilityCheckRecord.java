package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name="Eligibility_CheckRecord")

public class EligibilityCheckRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long deviceItemID;
    private Boolean isEligible;
    private Integer maxDevicesAllowed;
    private Boolean active; 