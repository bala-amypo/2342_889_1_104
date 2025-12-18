package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Eligibility_CheckRecord")

public class EligibilityCheckRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long deviceItemID;
    private Boolean isEligible;
    private String reason;
    private LocalDateTime checkedAt;
    public EligibilityCheckRecord(Long id, Long employeeId, Long deviceItemID, Boolean isEligible, String reaso,
            LocalDateTime checkedAt) {
        this.id = id;
        this.employeeId = employeeId;
        this.deviceItemID = deviceItemID;
        this.isEligible = isEligible;
        this.reason = reason;
        this.checkedAt = checkedAt;
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
    public Long getDeviceItemID() {
        return deviceItemID;
    }
    public void setDeviceItemID(Long deviceItemID) {
        this.deviceItemID = deviceItemID;
    }
    public Boolean getIsEligible() {
        return isEligible;
    }
    public void setIsEligible(Boolean isEligible) {
        this.isEligible = isEligible;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }
    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    } 
}