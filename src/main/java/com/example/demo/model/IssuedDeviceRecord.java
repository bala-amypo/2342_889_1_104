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
    private LocalDate issuedDate;
    private LocalDate returnedDate;
    private String ISSUED;
    private String RETURNED;
    public IssuedDeviceRecord(){}
}