package com.MedicalSystemProject.MedicalSystemProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MedicalSystemProject.MedicalSystemProject.Entity.Admin;
import com.MedicalSystemProject.MedicalSystemProject.Exception.ResourceNotFoundException;
import com.MedicalSystemProject.MedicalSystemProject.Repository.AdminRepository;

@RestController

@RequestMapping("/api/Admin")
public class AdminController {

	
	@Autowired
	private AdminRepository adminRepository;

	// get all admins
	@GetMapping
	public List<Admin> getAllAdmins(){
		return this.adminRepository.findAll();
	}
	
	//get admins by id
	@GetMapping("/{admin_id}")
	public Admin getAdminById(@PathVariable(value = "admin_id") long admin_id) {
		
		return this.adminRepository.findById(admin_id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found Exception with id:"+admin_id));
		
	}
	
	
	//create admin
	
	@PostMapping
	public Admin creatAdmin(@RequestBody Admin admin) {
		return this.adminRepository.save(admin);
	}
	
	
	//update admin
	@PutMapping("/{admin_id}")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable ("admin_id") long admin_id) {
		Admin existingAdmin =this.adminRepository.findById(admin_id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found Exception with id:"+admin_id));
		existingAdmin.setAdmin_name(admin.getAdmin_name());
		existingAdmin.setAdmin_contact(admin.getAdmin_contact());
		return this.adminRepository.save(existingAdmin);
		
	}
	
	
	//Delete the admin
	@DeleteMapping("/{admin_id}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable ("admin_id") long admin_id){
		Admin existingAdmin =this.adminRepository.findById(admin_id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found Exception with id:"+admin_id));
		this.adminRepository.delete(existingAdmin);
		return ResponseEntity.ok().build();
	}
	
	
	
}
