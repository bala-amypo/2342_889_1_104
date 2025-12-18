package com.example.demo.service;
import com.example.demo.model.EmployeeProfile;
public interface EmployeeProfileService{
    EmployeeProfile createEmployee(EmployeeProfile employee);
    EmployeeProfile getEmployeeById(Long id);
    
    EmployeeProfile updateEmployeeStatus(Long id,boolean active);
}