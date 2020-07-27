package com.MedicalSystemProject.MedicalSystemProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MedicalSystemProject.MedicalSystemProject.Entity.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long>{

}
