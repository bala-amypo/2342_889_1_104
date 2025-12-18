package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService{
    @Autowired
    private EmployeeProfileRepository rep;
    public EmployeeProfileServiceImpl(EmployeeProfileRepository rep){
        this.rep=rep;
    }
    @Override
    public EmployeeProfile createEmployee(EmployeeProfile employee){
        return rep.save(emp);
    }

    @Override
    public EmployeeProfile getValueById(Long id){
        return rep.findById(id).orElse(null);
    }
    @Override
    public List<EmployeeProfile> getAllEmployee(){
        return rep.findAll();
    }
    @Override
    public EmployeeProfile updateEmployeeStatus(Long id,boolean active){
        EmployeeProfile existing = rep.findById(id).orElse(null);
        if(existing!=null){
            existing.setActive(active);
            return rep.save(existing);
        }
        return null;
    }
}