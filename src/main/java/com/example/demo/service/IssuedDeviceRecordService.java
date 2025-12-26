package com.example.demo.service;

import com.example.demo.model.IssuedDeviceRecord;
import java.util.List;

public interface IssuedDeviceRecordService {
    IssuedDeviceRecord returnDevice(Long id);
    List<IssuedDeviceRecord> getIssuedDevicesByEmployee(Long employeeId);
}