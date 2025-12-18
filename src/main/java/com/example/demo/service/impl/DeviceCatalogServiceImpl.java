package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.EmployeeProfile;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;

@Service
public DeviceCatalogServiceImpl implements DeviceCatalogService{
    @Autowired
    private DeviceCatalogItemRepository rep;
}