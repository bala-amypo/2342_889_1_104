package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;

@Service
public class
private EmployeeProfileRepository rep;

@Override
public EmployeeProfile savedata(EmployeeProfile emp){
    return rep.save(emp);
}

@Override
public EmployeeProfile id(Long id){
    return rep.findById(id);
}