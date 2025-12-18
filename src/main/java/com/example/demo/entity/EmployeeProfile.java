package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Employee_profile")

public class EmployeeProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Should not contain blank spaces")
    @Column(unique=true)
    private String employeeId;
    @NotBlank(message="Should not contain blank spaces")
    private String fullName;
    @Email(message="Invalid format")
    @NotBlank(message="Should not contain blank spaces")
    @Column(unique=true)
    private String email;
    @NotBlank(message="Should not contain blank spaces")
    private String department;
    @NotBlank(message="Should not contain blank spaces")
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
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email=email;
    }
    public String getdepartment(){
        return ;
    }
    public void setemail(String email){
        this.email=email;
    }
}