package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService {
    private final DeviceCatalogItemRepository deviceRepo;

    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceCatalogItem createItem(DeviceCatalogItem item) {
        if (item.getMaxAllowedPerEmployee() == null || item.getMaxAllowedPerEmployee() <= 0) {
            throw new BadRequestException("maxAllowedPerEmployee must be greater than 0");
        }
        if (deviceRepo.findByDeviceCode(item.getDeviceCode()).isPresent()) {
            throw new BadRequestException("Device code already exists");
        }
        return deviceRepo.save(item);
    }

    @Override
    public DeviceCatalogItem updateActiveStatus(Long id, Boolean active) {
        DeviceCatalogItem item = deviceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found"));
        item.setActive(active);
        return deviceRepo.save(item);
    }

    @Override
    public List<DeviceCatalogItem> getAllItems() {
        return deviceRepo.findAll();
    }
}
package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EligibilityCheckServiceImpl implements EligibilityCheckService {
    private final EmployeeProfileRepository employeeRepo;
    private final DeviceCatalogItemRepository deviceRepo;
    private final IssuedDeviceRecordRepository issuedRepo;
    private final PolicyRuleRepository policyRepo;
    private final EligibilityCheckRecordRepository eligibilityRepo;

    public EligibilityCheckServiceImpl(EmployeeProfileRepository employeeRepo,
                                     DeviceCatalogItemRepository deviceRepo,
                                     IssuedDeviceRecordRepository issuedRepo,
                                     PolicyRuleRepository policyRepo,
                                     EligibilityCheckRecordRepository eligibilityRepo) {
        this.employeeRepo = employeeRepo;
        this.deviceRepo = deviceRepo;
        this.issuedRepo = issuedRepo;
        this.policyRepo = policyRepo;
        this.eligibilityRepo = eligibilityRepo;
    }

    @Override
    public EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId) {
        EligibilityCheckRecord record = new EligibilityCheckRecord();
        record.setEmployeeId(employeeId);
        record.setDeviceItemId(deviceItemId);

        Optional<EmployeeProfile> empOpt = employeeRepo.findById(employeeId);
        Optional<DeviceCatalogItem> devOpt = deviceRepo.findById(deviceItemId);

        if (empOpt.isEmpty() || devOpt.isEmpty()) {
            record.setIsEligible(false);
            record.setReason("Employee or device not found");
            return eligibilityRepo.save(record);
        }

        EmployeeProfile emp = empOpt.get();
        DeviceCatalogItem dev = devOpt.get();

        if (!emp.getActive()) {
            record.setIsEligible(false);
            record.setReason("Employee is not active");
            return eligibilityRepo.save(record);
        }

        if (!dev.getActive()) {
            record.setIsEligible(false);
            record.setReason("Device is inactive");
            return eligibilityRepo.save(record);
        }

        List<IssuedDeviceRecord> activeAssignments = issuedRepo.findActiveByEmployeeAndDevice(employeeId, deviceItemId);
        if (!activeAssignments.isEmpty()) {
            record.setIsEligible(false);
            record.setReason("Active issuance already exists");
            return eligibilityRepo.save(record);
        }

        Long currentDeviceCount = issuedRepo.countActiveDevicesForEmployee(employeeId);
        if (currentDeviceCount >= dev.getMaxAllowedPerEmployee()) {
            record.setIsEligible(false);
            record.setReason("Maximum allowed devices reached for this device type");
            return eligibilityRepo.save(record);
        }

        List<PolicyRule> activeRules = policyRepo.findByActiveTrue();
        for (PolicyRule rule : activeRules) {
            boolean applies = false;
            
            if (rule.getAppliesToDepartment() == null && rule.getAppliesToRole() == null) {
                applies = true;
            } else if (rule.getAppliesToDepartment() != null && rule.getAppliesToDepartment().equals(emp.getDepartment())) {
                applies = true;
            } else if (rule.getAppliesToRole() != null && rule.getAppliesToRole().equals(emp.getJobRole())) {
                applies = true;
            }
            
            if (applies && currentDeviceCount >= rule.getMaxDevicesAllowed()) {
                record.setIsEligible(false);
                record.setReason("Policy violation: " + rule.getRuleCode());
                return eligibilityRepo.save(record);
            }
        }

        record.setIsEligible(true);
        record.setReason("Eligible");
        return eligibilityRepo.save(record);
    }

    @Override
    public List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId) {
        return eligibilityRepo.findByEmployeeId(employeeId);
    }
}
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {
    private final EmployeeProfileRepository employeeRepo;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee) {
        if (employeeRepo.findByEmployeeId(employee.getEmployeeId()).isPresent()) {
            throw new BadRequestException("EmployeeId already exists");
        }
        if (employeeRepo.findByEmail(employee.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }
        return employeeRepo.save(employee);
    }

    @Override
    public EmployeeProfile updateEmployeeStatus(Long id, Boolean active) {
        EmployeeProfile emp = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        emp.setActive(active);
        return employeeRepo.save(emp);
    }

    @Override
    public EmployeeProfile getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getAllEmployees() {
        return employeeRepo.findAll();
    }
}
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.stereotype.Service;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService {
    private final IssuedDeviceRecordRepository issuedRepo;

    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository issuedRepo) {
        this.issuedRepo = issuedRepo;
    }

    @Override
    public IssuedDeviceRecord returnDevice(Long id) {
        IssuedDeviceRecord record = issuedRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));
        
        if ("RETURNED".equals(record.getStatus())) {
            throw new BadRequestException("Device already returned");
        }
        
        record.setStatus("RETURNED");
        return issuedRepo.save(record);
    }
}
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {
    private final PolicyRuleRepository policyRepo;

    public PolicyRuleServiceImpl(PolicyRuleRepository policyRepo) {
        this.policyRepo = policyRepo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        if (policyRepo.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new BadRequestException("Rule code already exists");
        }
        return policyRepo.save(rule);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return policyRepo.findAll();
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return policyRepo.findByActiveTrue();
    }
}