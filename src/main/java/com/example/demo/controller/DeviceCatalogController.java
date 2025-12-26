package com.example.demo.controller;

import com.example.demo.model.DeviceCatalogItem;
import com.example.demo.service.DeviceCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private final DeviceCatalogService deviceService;

    public DeviceController(DeviceCatalogService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public ResponseEntity<DeviceCatalogItem> createDevice(@RequestBody DeviceCatalogItem device) {
        DeviceCatalogItem created = deviceService.createItem(device);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<DeviceCatalogItem>> getAllDevices() {
        List<DeviceCatalogItem> devices = deviceService.getAllItems();
        return ResponseEntity.ok(devices);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DeviceCatalogItem> updateDeviceStatus(@PathVariable Long id, @RequestParam Boolean active) {
        DeviceCatalogItem updated = deviceService.updateActiveStatus(id, active);
        return ResponseEntity.ok(updated);
    }
}