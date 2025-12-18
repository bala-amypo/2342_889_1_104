package com.example.demo.controller;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/Employee")
public class EmployeeProfileController{
    @Autowired
    EmployeeProfileService src;
    @PostMapping("/post")
    public EmployeeProfile postdata(@RequestBody EmployeeProfile emp){
        return src.savedata(emp);
    }
    @GetMapping("/getid/{id}")
    public EmployeeProfile getIdVal(@PathVariable Long id){
        return src.getidval(id);
    }
    @PutMapping("/update/{id}")
    public EmployeeProfile updateId(@PathVariable Long id,@RequestBody EmployeeProfile emp){
        return src.update(id,emp);
    }
}