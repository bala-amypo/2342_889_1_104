package com.example.demo.controller;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.service.IssuedDeviceRecordService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api/issued-devices")
public class IssuedDeviceRecordController{
    @Autowired
    IssuedDeviceRecordService src;
    @PostMapping("POST/")
    public IssuedDeviceRecord issueDevice(@RequestBody IssuedDeviceRecord record){
        return src.issueDevice(record);
    }
    
    @PutMapping("/PUT/{id}/return")
    public IssuedDeviceRecord returnDevice(@PathVariable Long recordId){
        return src.returnDevice(recordId);
    }
    @GetMapping("/GET/employee/{employeeId}")
    public IssuedDeviceRecord getIssuedDevicesByEmployee(@PathVariable Long employeeId){
        return src.getIssuedDevicesByEmployee(employeeId);
    }
}