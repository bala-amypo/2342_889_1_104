// package com.example.demo.model;
// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name="Eligibility_CheckRecord")

// public class EligibilityCheckRecord{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     private Long employeeId;
//     private Long deviceItemID;
//     private Boolean isEligible;
//     private String reason;
//     private LocalDateTime checkedAt;
//     public EligibilityCheckRecord(Long id, Long employeeId, Long deviceItemID, Boolean isEligible, String reaso,
//             LocalDateTime checkedAt) {
//         this.id = id;
//         this.employeeId = employeeId;
//         this.deviceItemID = deviceItemID;
//         this.isEligible = isEligible;
//         this.reason = reason;
//         this.checkedAt = checkedAt;
//     }
//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }
//     public Long getEmployeeId() {
//         return employeeId;
//     }
//     public void setEmployeeId(Long employeeId) {
//         this.employeeId = employeeId;
//     }
//     public Long getDeviceItemID() {
//         return deviceItemID;
//     }
//     public void setDeviceItemID(Long deviceItemID) {
//         this.deviceItemID = deviceItemID;
//     }
//     public Boolean getIsEligible() {
//         return isEligible;
//     }
//     public void setIsEligible(Boolean isEligible) {
//         this.isEligible = isEligible;
//     }
//     public String getReason() {
//         return reason;
//     }
//     public void setReason(String reason) {
//         this.reason = reason;
//     }
//     public LocalDateTime getCheckedAt() {
//         return checkedAt;
//     }
//     public void setCheckedAt(LocalDateTime checkedAt) {
//         this.checkedAt = checkedAt;
//     } 
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "eligibility_check_records")
public class EligibilityCheckRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Many checks can belong to one employee
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeProfile employee;

    // 🔹 Many checks can belong to one device
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_item_id", nullable = false)
    private DeviceCatalogItem deviceItem;

    @Column(nullable = false)
    private Boolean isEligible;

    @Column(nullable = false, length = 500)
    private String reason;

    @Column(nullable = false, updatable = false)
    private LocalDateTime checkedAt;

    // 🔹 Auto-populate timestamp
    @PrePersist
    protected void onCheck() {
        this.checkedAt = LocalDateTime.now();
    }

    // 🔹 No-args constructor (required by JPA)
    public EligibilityCheckRecord() {
    }

    // 🔹 Constructor with core fields
    public EligibilityCheckRecord(EmployeeProfile employee,
                                  DeviceCatalogItem deviceItem,
                                  Boolean isEligible,
                                  String reason) {
        this.employee = employee;
        this.deviceItem = deviceItem;
        this.isEligible = isEligible;
        this.reason = reason;
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public EmployeeProfile getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeProfile employee) {
        this.employee = employee;
    }

    public DeviceCatalogItem getDeviceItem() {
        return deviceItem;
    }

    public void setDeviceItem(DeviceCatalogItem deviceItem) {
        this.deviceItem = deviceItem;
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
}
