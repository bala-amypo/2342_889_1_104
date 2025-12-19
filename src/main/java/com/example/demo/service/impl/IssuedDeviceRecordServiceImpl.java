package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceRecordService;

@Service
public class IssuedDeviceRecordServiceImpl implements IssuedDeviceRecordService{
    @Autowired
    private final IssuedDeviceRecordRepository rep;
    public IssuedDeviceRecordServiceImpl(IssuedDeviceRecordRepository rep){
        this.rep=rep;
    }
    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record){
        return rep.save(record);
    }
    @Override
    public IssuedDeviceRecord returnDevice(Long id){
        return rep.findById(id).orElse(null);
    }
    @Override
    public IssuedDeviceRecord getIssuedDevicesByEmployee(Long employeeId){
        return rep.findById(employeeId).orElse(null);
    }
}