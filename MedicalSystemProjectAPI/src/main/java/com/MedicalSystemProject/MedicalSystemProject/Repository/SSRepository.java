package com.MedicalSystemProject.MedicalSystemProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MedicalSystemProject.MedicalSystemProject.Entity.Supporting_Staff;


@Repository
public interface SSRepository extends JpaRepository<Supporting_Staff, Long>{

}
