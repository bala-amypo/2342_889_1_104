package com.example.demo.service;
import com.example.demo.model.PolicyRule;
public interface PolicyRuleService{
    PolicyRule createRule(PolicyRule rule);
    List<PolicyRule> getAllRules();
    List<PolicyRule> getActiveRules();
}