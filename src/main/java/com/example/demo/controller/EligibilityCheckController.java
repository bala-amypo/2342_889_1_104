package com.example.demo.controller;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityCheckController{
    @Autowired
    EligibilityCheckService src;
    @PostMapping("POST")
    public EligibilityCheckRecord validateEligibility(@PathVariable Long employeeId,@PathVariable Long deviceItemId){
        return src.validateEligibility(employeeId,deviceItemId);
    }
    @GetMapping("/GET")
    public EligibilityCheckRecord getCheckByEmployee(@PathVariable Long employeeId){
        return src.getCheckByEmployee(employeeId);
    }
}