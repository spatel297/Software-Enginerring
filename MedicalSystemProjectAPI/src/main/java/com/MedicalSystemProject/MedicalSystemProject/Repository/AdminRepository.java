package com.MedicalSystemProject.MedicalSystemProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MedicalSystemProject.MedicalSystemProject.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
