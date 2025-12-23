package com.example.demo.controller;
import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceCatalogController{
    @Autowired
    DeviceCatalogService src;
    @PostMapping
    public DeviceCatalogItem createItem(@RequestBody DeviceCatalogItem item){
        return src.createItem(item);
    }
    @PutMapping("/{id}/active")
    public DeviceCatalogItem updateActiveStatus(@PathVariable Long id,@PathVariable boolean active){
        return src.updateActiveStatus(id,active);
    }
    @GetMapping
    public List<DeviceCatalogItem> getAllItems(){
        return src.getAllItems();
    }
}