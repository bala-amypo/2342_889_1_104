package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.service.EligibilityCheckService;
import com.example.demo.repository.EmployeeProfileRepository;

@Service
public EligibilityCheckServiceImpl implements EligibilityCheckService{
    @Autowired
    EmployeeProfileRepository rep;
    @Autowired
    private EligibilityCheckRecordRepository rep;
    public EligibilityCheckServiceImpl (EligibilityCheckRecordRepository rep){
        this.rep=rep;
    }
    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId,Long deviceItemId){
        EligibilityCheckRecord record=new EligibilityCheckRecord();
        record.setEmployeeId(employeeId);
        record.setDeviceItemId(deviceItemId);
        EmployeeRepository employee=employeeRepository.findById(employeeId).orElse(null);
    }
    @Override
    public EligibilityCheckRecord getCheckByEmployee(Long employeeId){

    }
}