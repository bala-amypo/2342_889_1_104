package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.IssuedDeviceRecord;
import com.example.demo.repository.IssuedDeviceRecordRepository;
import com.example.demo.service.IssuedDeviceService;

@Service
public IssuedDeviceServiceImpl implements IssuedDeviceService{
    @Autowired
    private IssuedDeviceRecordRepository rep;
    public IssuedDeviceServiceImpl(IssuedDeviceRecordRepository rep){
        this.rep=rep;
    }
    @Override
    public IssuedDeviceRecord issueDevice(IssuedDeviceRecord record){
        return rep.save(record);
    }
    public IssuedDeviceRecord returnDevice(Long recordId){
        IssuedDeviceRecord record=rep.findById(recordId).orElse(null);
        if(record!=null&&record.getReturnedDate()==null){
            record.setReturnedDate(LocalDate.now());
            return rep.save(record);
        }
        return null;
    }
}