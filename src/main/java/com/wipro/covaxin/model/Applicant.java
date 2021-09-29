package com.wipro.covaxin.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "applicants")
@Document(collection="Applicant")
public class Applicant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	@Column(name = "APPLICANT_ID")
	private long applicantId;
	
	@NotNull
	@Size(min=2,message="Name should have atleast 2 characters")
	@Column(name = "APPLICANT_NAME")
	private String applicantName;
	

	@Column(name = "VACCINATION_TIME_SLOT")
	private Date vaccinationTimeSlot;
	
	/*@OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "AADHAR_ID", referencedColumnName = "AADHAR_ID")
	private AadharDetails aadharDetails;*/

	public Applicant() {

	}

	public long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}

	public Applicant(String applicantName, Date vaccinationTimeSlot, AadharDetails aadharDetails) {
		super();
		this.applicantName = applicantName;
		this.vaccinationTimeSlot = vaccinationTimeSlot;
		//this.aadharDetails = aadharDetails;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public Date getVaccinationTimeSlot() {
		return vaccinationTimeSlot;
	}

	public void setVaccinationTimeSlot(Date vaccinationTimeSlot) {
		this.vaccinationTimeSlot = vaccinationTimeSlot;
	}

/*	public AadharDetails getAadharDetails() {
		return aadharDetails;
	}

	public void setAadharDetails(AadharDetails aadharDetails) {
		this.aadharDetails = aadharDetails;
	}
*/
}
