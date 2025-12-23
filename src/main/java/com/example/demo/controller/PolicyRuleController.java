package com.example.demo.controller;
import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api/policy-rules")
public class PolicyRuleController{
    @Autowired
    PolicyRuleService src;
    @PostMapping("POST/")
    public PolicyRule createRule(@RequestBody PolicyRule rule){
        return src.createRule(rule);
    }
    @GetMapping("GET/active")
    public List<PolicyRule> getAllRules(){
        return src.getAllRules();
    }
    @GetMapping("GET/")
    public List<PolicyRule> getActiveRules(){
        return src.getActiveRules();
    }
}