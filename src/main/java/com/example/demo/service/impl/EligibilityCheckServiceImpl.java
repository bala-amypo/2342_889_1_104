package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.service.EligibilityCheckRecordService;

Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService{
    @Autowired
    private final EligibilityCheckRecordRepository rep;
    public EmployeeProfileServiceImpl(EligibilityCheckRecordRepository rep){
        this.rep=rep;
    }
    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId,Long deviceItemId){
        return null;
    }
    @Override
    public EligibilityCheckRecord getCheckByEmployee(Long employeeId){
        return rep.findById(employeeId).orElse(null);
    }
}