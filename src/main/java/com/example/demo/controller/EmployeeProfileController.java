package com.example.demo.controller;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/employees")

public class EmployeeProfileController{
    private final EmployeeProfileService src;
    public EmployeeProfileController(EmployeeProfileService src){
        this.src=src;
    }
    @PostMapping
    public ResponseEntity<EmployeeProfile> createEmployee{
        @RequestBody EmployeeProfile 
    }
}