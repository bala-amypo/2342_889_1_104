package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.IssuedDeviceRecord;
@Repository
public interface IssuedDeviceRecordRepository extends JpaRepository<IssuedDeviceRecord,Long>{
    List<
}