package com.example.demo.controller;

import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/issued-devices")
public class IssuedDeviceController {
    private final IssuedDeviceRecordService issuedDeviceService;

    public IssuedDeviceController(IssuedDeviceRecordService issuedDeviceService) {
        this.issuedDeviceService = issuedDeviceService;
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<IssuedDeviceRecord> returnDevice(@PathVariable Long id) {
        IssuedDeviceRecord returned = issuedDeviceService.returnDevice(id);
        return ResponseEntity.ok(returned);
    }
}