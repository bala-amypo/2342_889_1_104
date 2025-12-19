package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.PolicyRule;
@Repository
public interface PolicyRuleRepository extends JpaRepository<PolicyRule,String>{
    List<PolicyRule> findByActiveTrue();
}