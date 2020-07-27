package com.MedicalSystemProject.MedicalSystemProject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long doctor_id;
	
	@Column(name = "doctor_name")
	private String doctor_name;
	

	@Column(name="doctor_contact")
	private String doctor_contact;
	
	@Column(name = "doctor_speciality")
	private String doctor_speciality;
	
    public Doctor() {}

	public Doctor(String doctor_name, String doctor_contact, String doctor_speciality) {
		super();
		this.doctor_name = doctor_name;
		this.doctor_contact = doctor_contact;
		this.doctor_speciality = doctor_speciality;
	}



	public long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(long doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_contact() {
		return doctor_contact;
	}

	public void setDoctor_contact(String doctor_contact) {
		this.doctor_contact = doctor_contact;
	}

	public String getDoctor_speciality() {
		return doctor_speciality;
	}

	public void setDoctor_speciality(String doctor_speciality) {
		this.doctor_speciality = doctor_speciality;
	}

	
	
	
}
