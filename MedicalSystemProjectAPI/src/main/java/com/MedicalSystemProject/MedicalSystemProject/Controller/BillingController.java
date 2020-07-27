package com.MedicalSystemProject.MedicalSystemProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MedicalSystemProject.MedicalSystemProject.Entity.Billing;
import com.MedicalSystemProject.MedicalSystemProject.Repository.BillingRepository;

@RestController

@RequestMapping("/api/Billing")
public class BillingController {

	@Autowired
	private BillingRepository billingRepository;

	// get all billing of patients
		@GetMapping
		public List<Billing> getAllBilling(){
			return this.billingRepository.findAll();
		}
		
		
}
