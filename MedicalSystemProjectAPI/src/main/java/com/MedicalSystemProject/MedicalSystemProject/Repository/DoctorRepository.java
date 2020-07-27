package com.MedicalSystemProject.MedicalSystemProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MedicalSystemProject.MedicalSystemProject.Entity.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
