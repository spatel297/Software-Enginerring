package com.MedicalSystemProject.MedicalSystemProject.Entity;

import java.sql.Date;

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
@Table(name="Billing")
public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billing_id;
	
	@Column(name = "billing_amount")
	private int billing_amount;
	

	@Column(name="billing_date")
	private Date billing_date;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
	private Patient patient;
	
	public Billing() {}

	
	
	
	public Billing(long billing_id, int billing_amount, Date billing_date) {
		super();
		this.billing_id = billing_id;
		this.billing_amount = billing_amount;
		this.billing_date = billing_date;
	}




	public long getBilling_id() {
		return billing_id;
	}

	public void setBilling_id(long billing_id) {
		this.billing_id = billing_id;
	}

	public int getBilling_amount() {
		return billing_amount;
	}

	public void setBilling_amount(int billing_amount) {
		this.billing_amount = billing_amount;
	}

	public Date getBilling_date() {
		return billing_date;
	}

	public void setBilling_date(Date billing_date) {
		this.billing_date = billing_date;
	}




	public Patient getPatient() {
		return patient;
	}




	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	
	
}
