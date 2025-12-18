package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService{
    @Autowired
    private EmployeeProfileRepository rep;
    public EmployeeProfileServiceImplw(EmployeeProfileRepository rep){
        this.rep=rep;
    }
    @Override
    public EmployeeProfile savedata(EmployeeProfile emp){
        return rep.save(emp);
    }

    @Override
    public EmployeeProfile id(Long id){
        return rep.findById(id);
    }

    @Override
    public EmployeeProfile update(Long id,EmployeeProfile emp){
        EmployeeProfile existing = re
    }
}