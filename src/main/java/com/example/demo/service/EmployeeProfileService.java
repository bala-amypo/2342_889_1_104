package com.example.demo.service;
import com.example.demo.model.EmployeeProfile;
public interface EmployeeProfileService{
    EmployeeProfile savedata(EmployeeProfile emp);
    EmployeeProfile getid(Long id);
    EmployeeProfile update(Long id,EmployeeProfile emp);
}