package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Employee_profile")

public class EmployeeProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String employeeId;
    private String fullName;
    @Email(message="Invalid format")
    @Column(unique=true)
    private String email;
    private String department;
    private String jobRole;
    private Boolean active;
    private LocalDateTime createdAt;
    public EmployeeProfile(){}
    public EmployeeProfile(Long id,String employeeId,String fullName,String email,String department,String jobRole,Boolean active,LocalDateTime createdAt){
        this.id=id;
        this.employeeId=employeeId;
        this.fullName=fullName;
        this.email=email;
        this.department=department;
        this.jobRole=jobRole;
        this.active=active;
        this.createdAt=createdAt;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getemployeeId(){
        return employeeId;
    }
    public void setemployeeId(String employeeId){
        this.employeeId=employeeId;
    }
    public String getfullName(){
        return fullName;
    }
    public void setfullName(String fullName){
        this.fullName=fullName;
    }
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email=email;
    }
    public String getdepartment(){
        return department;
    }
    public void setdepartment(String department){
        this.department=department;
    }
    public String getjobRole(){
        return jobRole;
    }
    public void setdepartment(String jobRole){
        this.jobRole=jobRole;
    }
    public Boolean getactive(){
        return active;
    }
    public void setactive(Boolean active){
        this.active=active;
    }
    public LocalDateTime createdAt(){
        return createdAt;
    }
    public void setactive(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
}