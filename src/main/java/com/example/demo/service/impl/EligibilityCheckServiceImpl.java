package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.repository.EligibilityCheckRecordRepository;
import com.example.demo.service.EligibilityCheckService;

@Service
public EligibilityCheckServiceImpl implements EligibilityCheckService{
    @Autowired
    private EligibilityCheckRecordRepository rep;
    public EligibilityCheckServiceImpl ()
}