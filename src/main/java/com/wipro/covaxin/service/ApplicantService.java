package com.wipro.covaxin.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.covaxin.exceptionHandling.DuplicateResourceException;
import com.wipro.covaxin.exceptionHandling.ResourceNotFoundException;
import com.wipro.covaxin.model.Applicant;


public interface ApplicantService {
	 List<Applicant> getAllApplicants() throws ResourceNotFoundException;
	 Applicant getApplicantById(long id) throws ResourceNotFoundException;
	Applicant createApplicant(Applicant applicant)throws DuplicateResourceException;
	ResponseEntity<Object> updateApplicant(Applicant applicant, long id) throws ResourceNotFoundException;

    ResponseEntity<Object> removeApplicant(long id) throws ResourceNotFoundException;
}
