// package com.example.demo.model;
// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;

// @Entity
// @Table(name="Policy_Rule")

// public class PolicyRule{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     @Column(unique=true)
//     private String ruleCode;
//     private String description;
//     private String appliesToDepartment;
//     private String appliesToRole;
//     private Integer maxDevicesAllowed;
//     private Boolean active; 
//     public PolicyRule(){}
//     public PolicyRule(String ruleCode, String description, String appliesToDepartment, String appliesToRole,
//         Integer maxDevicesAllowed, Boolean active) {
//         this.ruleCode = ruleCode;
//         this.description = description;
//         this.appliesToDepartment = appliesToDepartment;
//         this.appliesToRole = appliesToRole;
//         this.maxDevicesAllowed = maxDevicesAllowed;
//         this.active = active;
//     }
//     public String getRuleCode() {
//         return ruleCode;
//     }
//     public void setRuleCode(String ruleCode) {
//         this.ruleCode = ruleCode;
//     }
//     public String getDescription() {
//         return description;
//     }
//     public void setDescription(String description) {
//         this.description = description;
//     }
//     public String getAppliesToDepartment() {
//         return appliesToDepartment;
//     }
//     public void setAppliesToDepartment(String appliesToDepartment) {
//         this.appliesToDepartment = appliesToDepartment;
//     }
//     public String getAppliesToRole() {
//         return appliesToRole;
//     }
//     public void setAppliesToRole(String appliesToRole) {
//         this.appliesToRole = appliesToRole;
//     }
//     public Integer getMaxDevicesAllowed() {
//         return maxDevicesAllowed;
//     }
//     public void setMaxDevicesAllowed(Integer maxDevicesAllowed) {
//         this.maxDevicesAllowed = maxDevicesAllowed;
//     }
//     public Boolean getActive() {
//         return active;
//     }
//     public void setActive(Boolean active) {
//         this.active = active;
//     }
    
// }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "policy_rules",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "ruleCode")
    }
)
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    @Column
    private String description;

    @Column
    private String appliesToRole;

    @Column
    private String appliesToDepartment;

    @Column(nullable = false)
    private Integer maxDevicesAllowed;

    @Column(nullable = false)
    private Boolean active = true;

    public PolicyRule() {
    }

    public PolicyRule(String ruleCode,
                      String description,
                      Integer maxDevicesAllowed) {
        this.ruleCode = ruleCode;
        this.description = description;
        this.maxDevicesAllowed = maxDevicesAllowed;
    }
    public Long getId() {
        return id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppliesToRole() {
        return appliesToRole;
    }

    public void setAppliesToRole(String appliesToRole) {
        this.appliesToRole = appliesToRole;
    }

    public String getAppliesToDepartment() {
        return appliesToDepartment;
    }

    public void setAppliesToDepartment(String appliesToDepartment) {
        this.appliesToDepartment = appliesToDepartment;
    }

    public Integer getMaxDevicesAllowed() {
        return maxDevicesAllowed;
    }

    public void setMaxDevicesAllowed(Integer maxDevicesAllowed) {
        this.maxDevicesAllowed = maxDevicesAllowed;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
