// package com.example.demo.model;
// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name="Employee_profile")

// public class EmployeeProfile{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @NotBlank
//     @Column (unique=true)
//     private String employeeId;
//     @Column(nullable=false)
//     private String fullName;
//     @NotBlank
//     @Column (unique=true)
//     private String email;
//     private String department;
//     @Column(nullable=false)
//     private String jobRole;
//     private Boolean active;
//     private LocalDateTime createdAt;
//     public EmployeeProfile(){}
//     public EmployeeProfile(Long id,String employeeId,String fullName,String email,String department,String jobRole,Boolean active,LocalDateTime createdAt){
//         this.employeeId=employeeId;
//         this.fullName=fullName;
//         this.email=email;
//         this.department=department;
//         this.jobRole=jobRole;
//         this.active=active;
//     }
//     @PrePersist
//     void onCreate(){
//         this.createdAt=LocalDateTime.now();
//         if(this.jobRole==null){
//             this.jobRole="STAFF";
//         }
//         if(this.active==null){
//             this.active=true;
//         }
//     }
//     public Long getid(){
//         return id;
//     }
//     public void setid(Long id){
//         this.id=id;
//     }
//     public String getemployeeId(){
//         return employeeId;
//     }
//     public void setemployeeId(String employeeId){
//         this.employeeId=employeeId;
//     }
//     public String getfullName(){
//         return fullName;
//     }
//     public void setfullName(String fullName){
//         this.fullName=fullName;
//     }
//     public String getemail(){
//         return email;
//     }
//     public void setemail(String email){
//         this.email=email;
//     }
//     public String getdepartment(){
//         return department;
//     }
//     public void setdepartment(String department){
//         this.department=department;
//     }
//     public String getjobRole(){
//         return jobRole;
//     }
//     public void setjobRole(String jobRole){
//         this.jobRole=jobRole;
//     }
//     public Boolean getactive(){
//         return active;
//     }
//     public void setactive(Boolean active){
//         this.active=active;
//     }
//     public LocalDateTime getcreatedAt(){
//         return createdAt;
//     }
//     public void setcreatedAt(LocalDateTime createdAt){
//         this.createdAt=createdAt;
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "employee_profiles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "employeeId"),
        @UniqueConstraint(columnNames = "email")
    }
)
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String employeeId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String jobRole;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.jobRole == null) {
            this.jobRole = "STAFF";
        }
        if (this.active == null) {
            this.active = true;
        }
    }

    public EmployeeProfile() {
    }

    public EmployeeProfile(String employeeId, String fullName, String email,
                           String department, String jobRole) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.jobRole = jobRole;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
