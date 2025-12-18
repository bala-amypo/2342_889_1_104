package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.EmployeeProfile;
@Repository
public interface EligibiRepository extends JpaRepository<EmployeeProfile,Long>{
}