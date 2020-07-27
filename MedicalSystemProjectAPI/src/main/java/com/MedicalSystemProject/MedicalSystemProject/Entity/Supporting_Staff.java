package com.MedicalSystemProject.MedicalSystemProject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Supporting_Staff")
public class Supporting_Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ss_id;
	
	@Column(name = "ss_name")
	private String ss_name;
	

	@Column(name="ss_contact")
	private String ss_contact;
	
	@Column(name = "ss_type")
	private String ss_type;
	


	public Supporting_Staff() {}

	
	
	public Supporting_Staff(String ss_name, String ss_contact, String ss_type) {
		super();
		this.ss_name = ss_name;
		this.ss_contact = ss_contact;
		this.ss_type = ss_type;
	}





	public long getSs_id() {
		return ss_id;
	}

	public void setSs_id(long ss_id) {
		this.ss_id = ss_id;
	}

	public String getSs_name() {
		return ss_name;
	}

	public void setSs_name(String ss_name) {
		this.ss_name = ss_name;
	}

	public String getSs_contact() {
		return ss_contact;
	}

	public void setSs_contact(String ss_contact) {
		this.ss_contact = ss_contact;
	}

	public String getSs_type() {
		return ss_type;
	}

	public void setSs_type(String ss_type) {
		this.ss_type = ss_type;
	}
	
	
	
}
