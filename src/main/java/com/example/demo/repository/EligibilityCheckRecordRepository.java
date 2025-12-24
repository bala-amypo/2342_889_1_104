package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.EligibilityCheckRecord;
import java.util.*;
@Repository
public interface EligibilityCheckRecordRepository extends JpaRepository<EligibilityCheckRecord,Long>{
    Optional<EligibilityCheckRecord> findByEmployee_Id(Long employeeId);
}