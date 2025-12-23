package com.example.demo.controller;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController{
    @Autowired
    EmployeeProfileService src;
    @PostMapping("POST/")
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile employee){
        return src.createEmployee(employee);
    }
    @GetMapping("GET/{id}")
    public EmployeeProfile getEmployeeById(@PathVariable Long id){
        return src.getEmployeeById(id);
    }
    @GetMapping
    public List<EmployeeProfile> getAllEmployees(){
        return src.getAllEmployees();
    }
    @PutMapping("PUT/{id}/status")
    public EmployeeProfile updateEmployeeStatus(@PathVariable Long id,@PathVariable boolean active){
        return src.updateEmployeeStatus(id,active);
    }
}