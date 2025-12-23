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
    @NotBlank
    private Long employeeId;
    @NotNull
    private LocalDate issuedDate;
    @NotNull
    private LocalDate returnedDate;
    private String status;
    public IssuedDeviceRecord(){}
    public IssuedDeviceRecord(Long id, Long employeeId, LocalDate issuedDate, LocalDate returnedDate, String  status) {
        this.id = id;
        this.employeeId = employeeId;
        this.issuedDate = issuedDate;
        this.returnedDate = returnedDate;
        this.status=status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public LocalDate getIssuedDate() {
        return issuedDate;
    }
    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }
    public LocalDate getReturnedDate() {
        return returnedDate;
    }
    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status=staus;
    }
    
}