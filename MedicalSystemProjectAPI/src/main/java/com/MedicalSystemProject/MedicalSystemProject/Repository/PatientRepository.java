package com.MedicalSystemProject.MedicalSystemProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MedicalSystemProject.MedicalSystemProject.Entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
