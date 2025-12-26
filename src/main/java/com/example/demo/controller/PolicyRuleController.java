package com.example.demo.controller;

import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    private final PolicyRuleService policyService;

    public PolicyController(PolicyRuleService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public ResponseEntity<PolicyRule> createPolicy(@RequestBody PolicyRule policy) {
        PolicyRule created = policyService.createRule(policy);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<PolicyRule>> getAllPolicies() {
        List<PolicyRule> policies = policyService.getAllRules();
        return ResponseEntity.ok(policies);
    }

    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> getActivePolicies() {
        List<PolicyRule> activePolicies = policyService.getActiveRules();
        return ResponseEntity.ok(activePolicies);
    }
}