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

import com.MedicalSystemProject.MedicalSystemProject.Entity.Supporting_Staff;
import com.MedicalSystemProject.MedicalSystemProject.Exception.ResourceNotFoundException;
import com.MedicalSystemProject.MedicalSystemProject.Repository.SSRepository;

@RestController

@RequestMapping("/api/Supporting_Staff")
public class SSController {

	@Autowired
	private SSRepository ssRepository;
	@CrossOrigin

	// get all Supporting_staff
		@GetMapping
		public List<Supporting_Staff> getAllSS(){
			return this.ssRepository.findAll();
		}
		@CrossOrigin

		//get ss by id
		@GetMapping("/{ss_id}")
		public Supporting_Staff getSSById(@PathVariable(value = "ss_id") long ss_id) {
			
			return this.ssRepository.findById(ss_id)
					.orElseThrow(() -> new ResourceNotFoundException("SupportingStaff not found Exception with id:"+ss_id));
			
		}
		
		//create ss
		@CrossOrigin

		@PostMapping
		public Supporting_Staff createSS(@RequestBody Supporting_Staff ss) {
			return this.ssRepository.save(ss);
		}
		@CrossOrigin

		//update ss
		@PutMapping("/{ss_id}")
		public Supporting_Staff updateSS(@RequestBody Supporting_Staff ss,@PathVariable ("ss_id") long ss_id) {
			Supporting_Staff existingSS =this.ssRepository.findById(ss_id)
					.orElseThrow(() -> new ResourceNotFoundException("SupportingStaff not found Exception with id:"+ss_id));
			existingSS.setSs_name(ss.getSs_name());
			existingSS.setSs_contact(ss.getSs_contact());
			existingSS.setSs_type(ss.getSs_type());
			return this.ssRepository.save(existingSS);
			
		}
		
		@CrossOrigin

		//Delete the ss
		@DeleteMapping("/{ss_id}")
		public ResponseEntity<Supporting_Staff> deleteSS(@PathVariable ("ss_id") long ss_id){
			Supporting_Staff existingSS =this.ssRepository.findById(ss_id)
					.orElseThrow(() -> new ResourceNotFoundException("ss not found Exception with id:"+ss_id));
			this.ssRepository.delete(existingSS);
			return ResponseEntity.ok().build();
		}
	
}
