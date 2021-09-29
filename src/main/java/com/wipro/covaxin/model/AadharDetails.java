package com.wipro.covaxin.model;

import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "aadhar_details")
@Document(collection="aadharDetails")
public class AadharDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AADHAR_ID")
	private long aadharId;
	
	@NotNull
	@Size(min=2,message="Name should have atleast 2 characters")
	@Column(name = "NAME")
	private String name;
	
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "GENDER")
	private String gender;
	

	public AadharDetails() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public AadharDetails(String name, Date dob, String gender) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}

	public long getAadharId() {
		return aadharId;
	}

	public void setAadharId(long aadharId) {
		this.aadharId = aadharId;
	}

}
