package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.DeviceCatalogItem;
import java.util.*;
@Repository
public interface DeviceCatalogItemRepository extends JpaRepository<DeviceCatalogItem,Long>{\
    Optional<IssuedDeviceRecord> findByDeviceCode(String deviceCode);
}