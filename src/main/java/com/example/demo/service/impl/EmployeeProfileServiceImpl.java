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
    public EmployeeProfile savedata(EmployeeProfile emp){
        return rep.save(emp);
    }

    @Override
    public EmployeeProfile getidval(Long id){
        return rep.findById(id);
    }

    @Override
    public EmployeeProfile update(Long id,EmployeeProfile emp){
        EmployeeProfile existing = getidval(id);
        if(existing!=null){
            existing.setfullName(emp.getfullName());
            existing.setemail(emp.getemail());
            existing.setdepartment(emp.getdepartment());
            existing.setjobRole(emp.getjobRole());
            existing.setactive(emp.getactive());
            existing.setcreatedAt(emp.getcreatedAt());
            return rep.save(existing);
        }
    }
}