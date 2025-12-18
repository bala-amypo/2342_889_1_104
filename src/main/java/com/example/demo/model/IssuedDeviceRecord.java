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
    public IssuedDeviceRecord(Long id, Long employeeId, LocalDate issuedDate, LocalDate returnedDate, String iSSUED,
            String rETURNED) {
        this.id = id;
        this.employeeId = employeeId;
        this.issuedDate = issuedDate;
        this.returnedDate = returnedDate;
        ISSUED = iSSUED;
        RETURNED = rETURNED;
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
    public String getISSUED() {
        return ISSUED;
    }
    public void setISSUED(String iSSUED) {
        ISSUED = iSSUED;
    }
    public String getRETURNED() {
        return RETURNED;
    }
    public void setRETURNED(String rETURNED) {
        RETURNED = rETURNED;
    }
}