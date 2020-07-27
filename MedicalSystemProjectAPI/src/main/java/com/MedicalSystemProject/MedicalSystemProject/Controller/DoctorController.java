package com.MedicalSystemProject.MedicalSystemProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MedicalSystemProject.MedicalSystemProject.Entity.Doctor;
import com.MedicalSystemProject.MedicalSystemProject.Exception.ResourceNotFoundException;
import com.MedicalSystemProject.MedicalSystemProject.Repository.DoctorRepository;


@RestController

@RequestMapping("/api/Doctor")
public class DoctorController {

	
	@Autowired
	private DoctorRepository doctorRepository;
	
	
	@CrossOrigin
	// get all doctors
	@GetMapping
	public List<Doctor> getAllDoctors(){
		return this.doctorRepository.findAll();
	}
	@CrossOrigin
	//get doctors by id
	@GetMapping("/{doctor_id}")
	public Doctor getDoctorById(@PathVariable(value = "doctor_id") long doctor_id) {
		
		return this.doctorRepository.findById(doctor_id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found Exception with id:"+doctor_id));
		
	}
	
	//create doctor
	@CrossOrigin
	@PostMapping
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return this.doctorRepository.save(doctor);
	}
	
	@CrossOrigin
	//update doctor
	@PutMapping("/{doctor_id}")
	public Doctor updateDoctor(@RequestBody Doctor doctor,@PathVariable ("doctor_id") long doctor_id) {
		Doctor existingDoctor =this.doctorRepository.findById(doctor_id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found Exception with id:"+doctor_id));
		existingDoctor.setDoctor_name(doctor.getDoctor_name());
		existingDoctor.setDoctor_contact(doctor.getDoctor_contact());
		existingDoctor.setDoctor_speciality(doctor.getDoctor_speciality());
		return this.doctorRepository.save(existingDoctor);
		
	}
	
	@CrossOrigin
	//Delete the doctor
	@DeleteMapping("/{doctor_id}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable ("doctor_id") long doctor_id){
		Doctor existingDoctor =this.doctorRepository.findById(doctor_id)
				.orElseThrow(() -> new ResourceNotFoundException("doctor not found Exception with id:"+doctor_id));
		this.doctorRepository.delete(existingDoctor);
		return ResponseEntity.ok().build();
	}
	
	
	
}
