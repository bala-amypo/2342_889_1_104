

package com.example.demo.controller;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityCheckController {
    private final EligibilityCheckService eligibilityService;

    public EligibilityCheckController(EligibilityCheckService eligibilityService) {
        this.eligibilityService = eligibilityService;
    }

    @PostMapping("/check")
    public ResponseEntity<EligibilityCheckRecord> checkEligibility(@RequestParam Long employeeId, @RequestParam Long deviceItemId) {
        EligibilityCheckRecord result = eligibilityService.validateEligibility(employeeId, deviceItemId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EligibilityCheckRecord>> getChecksByEmployee(@PathVariable Long employeeId) {
        List<EligibilityCheckRecord> checks = eligibilityService.getCheckByEmployee(employeeId);
        return ResponseEntity.ok(checks);
    }
}