package com.example.demo.service;
import com.example.demo.model.IssuedDeviceRecord;
public interface IssuedDeviceRecordService{
    IssuedDeviceRecord issueDevice(IssuedDeviceRecord record);
    IssuedDeviceRecord returnDevice(Long Id);
    IssuedDeviceRecord getIssuedDevicesByEmployee(Long employeeId);
}