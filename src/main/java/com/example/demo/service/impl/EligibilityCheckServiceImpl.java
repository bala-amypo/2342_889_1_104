package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.service.EligibilityCheckService;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.IssuedDeviceRecordRepository;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService{
    @Autowired
    EmployeeProfileRepository rep;
    @Autowired
    private EligibilityCheckRecordRepository rep;
    public EligibilityCheckServiceImpl (EligibilityCheckRecordRepository rep){
        this.rep=rep;
    }
    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {

        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployeeId(employeeId);
        record.setDeviceItemId(deviceItemId);

        EmployeeProfile employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee == null || Boolean.FALSE.equals(employee.getActive())) {
            record.setEligible(false);
            record.setReason("Employee not active or not found");
            return record;
        }

        long issuedCount =
                issuedDeviceRecordRepository
                        .countByEmployeeIdAndReturnedDateIsNull(employeeId);

        if (issuedCount >= 1) {
            record.setisEligible(false);
            record.setReason("Maximum devices already issued");
        } 
        else {
            record.setisEligible(true);
            record.setReason("Eligible for device issuance");
        }

        return record;
    }

    @Override
    public EligibilityCheckRecord getCheckByEmployee(Long employeeId) {
        return issuedDeviceRecordRepository.findEligibilityChecksByEmployeeId(employeeId);
    }
}