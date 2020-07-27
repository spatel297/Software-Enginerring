package com.MedicalSystemProject.MedicalSystemProject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Admin")

public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long admin_id;
	
	@Column(name = "admin_name")
	private String admin_name;
	
	@Column(name="admin_contact")
	private String admin_contact;
	
	public Admin() {}
	
	
	public Admin(String admin_name, String admin_contact) {
		super();
		this.admin_name = admin_name;
		this.admin_contact = admin_contact;
	}
	public long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_contact() {
		return admin_contact;
	}
	public void setAdmin_contact(String admin_contact) {
		this.admin_contact = admin_contact;
	} 
}
