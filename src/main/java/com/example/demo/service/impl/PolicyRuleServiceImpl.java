package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;


@Service
public PolicyRuleServiceImpl implements PolicyRuleService{
    @Autowired
    private PolicyRuleRepository rep;
    public PolicyRuleServiceImpl(PolicyRuleRepository rep){
        this.rep=rep;
    }
    @Override
    public PolicyRule createRule(PolicyRule rule){
        
    }
}