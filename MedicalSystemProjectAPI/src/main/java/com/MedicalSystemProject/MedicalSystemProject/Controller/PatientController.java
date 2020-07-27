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

import com.MedicalSystemProject.MedicalSystemProject.Entity.Patient;
import com.MedicalSystemProject.MedicalSystemProject.Exception.ResourceNotFoundException;
import com.MedicalSystemProject.MedicalSystemProject.Repository.PatientRepository;


@RestController

@RequestMapping("/api/Patient")
public class PatientController {

	
	@Autowired
	private PatientRepository patientRepository;
	
	
	@CrossOrigin
	// get all patients
	@GetMapping
	public List<Patient> getAllPatients(){
		return this.patientRepository.findAll();
	}
	
	@CrossOrigin
	//get patients by id
	@GetMapping("/{patient_id}")
	public Patient getPatientById(@PathVariable(value = "patient_id") long patient_id) {
		
		return this.patientRepository.findById(patient_id)
				.orElseThrow(() -> new ResourceNotFoundException("patient not found Exception with id:"+patient_id));
		
	}
	
	//create patient
		@CrossOrigin
		@PostMapping
		public Patient createPatient(@RequestBody Patient patient) {
			return this.patientRepository.save(patient);
		}
		
		@CrossOrigin
		//update patient
		@PutMapping("/{patient_id}")
		public Patient updatePatient(@RequestBody Patient patient,@PathVariable ("patient_id") long patient_id) {
			Patient existingPatient =this.patientRepository.findById(patient_id)
					.orElseThrow(() -> new ResourceNotFoundException("Patient not found Exception with id:"+patient_id));
			existingPatient.setPatient_name(patient.getPatient_name());
			existingPatient.setPatient_contact(patient.getPatient_contact());
			existingPatient.setSickness_type(patient.getSickness_type());
			return this.patientRepository.save(existingPatient);
			
		}
		
		@CrossOrigin
		//Delete the patient
		@DeleteMapping("/{patient_id}")
		public ResponseEntity<Patient> deletePatient(@PathVariable ("patient_id") long patient_id){
			Patient existingPatient =this.patientRepository.findById(patient_id)
					.orElseThrow(() -> new ResourceNotFoundException("patient not found Exception with id:"+patient_id));
			this.patientRepository.delete(existingPatient);
			return ResponseEntity.ok().build();
		}
		
		
}
