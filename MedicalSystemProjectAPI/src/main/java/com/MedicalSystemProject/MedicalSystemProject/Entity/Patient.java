package com.MedicalSystemProject.MedicalSystemProject.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patient_id;
	
	@Column(name = "patient_name")
	private String patient_name;
	

	@Column(name="patient_contact")
	private String patient_contact;
	
	@Column(name="sickness_type")
	private String sickness_type;
	

	@OneToOne(cascade = CascadeType.ALL)
    private Billing billing;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
	private Doctor doctor;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "ss_id", referencedColumnName = "ss_id")
	private Supporting_Staff ss;
	
	public Patient() {}

	
	
	
	
	public Patient(String patient_name, String patient_contact, String sickness_type) {
		super();
		this.patient_name = patient_name;
		this.patient_contact = patient_contact;
		this.sickness_type = sickness_type;
	}





	public long getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_contact() {
		return patient_contact;
	}

	public void setPatient_contact(String patient_contact) {
		this.patient_contact = patient_contact;
	}

	public String getSickness_type() {
		return sickness_type;
	}

	public void setSickness_type(String sickness_type) {
		this.sickness_type = sickness_type;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Supporting_Staff getSs() {
		return ss;
	}

	public void setSs(Supporting_Staff ss) {
		this.ss = ss;
	}
	
	
	
}
