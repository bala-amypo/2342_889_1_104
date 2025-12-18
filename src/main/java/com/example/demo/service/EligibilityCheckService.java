package com.example.demo.service;
import com.example.demo.model.EligibilityCheckRecord;
public interface EligibilityCheckService{
    EligibilityCheckRecord validateEligibility(Long employeeId,Long deviceItemId);
    EligibilityCheckRecord getCheckByEmployee(Long employeeId);
}