package com.example.demo.service.impl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.repository.DeviceCatalogItemRepository;
import com.example.demo.service.DeviceCatalogService;

@Service
public class DeviceCatalogServiceImpl implements DeviceCatalogService{
    @Autowired
    private DeviceCatalogItemRepository rep;
    public DeviceCatalogServiceImpl(DeviceCatalogItemRepository rep){
        this.rep=rep;
    }
    @Override
    public DeviceCatalogItem createItem(DeviceCatalogItem item{
        return rep.save(item);
    }
    @Override
    public DeviceCatalogItem updateActiveStatus(Long id,boolean active){
        DeviceCatalogItem existing = rep.findById(id).orElse(null);
        if(existing!=null){
            existing.setActive(active);
            return rep.save(existing);
        }
        return null;
    }
    @Override
    public List<DeviceCatalogItem> getAllItems(){
        return rep.findAll();
    }
}