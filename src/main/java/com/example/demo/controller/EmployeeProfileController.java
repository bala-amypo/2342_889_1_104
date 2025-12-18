package com.example.demo.controller;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController

public class EmployeeProfileController{
    @Autowired
    EmployeeProfileService src;
    @PostMapping("/post")
    public Employee_profile postdata(@RequestBody Employee_profile emp){
        return src.savedata(emp);
    }''
    @GetMapping()
}