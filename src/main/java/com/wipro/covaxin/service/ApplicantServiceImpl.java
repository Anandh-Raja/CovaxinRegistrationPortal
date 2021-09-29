package com.wipro.covaxin.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.covaxin.exceptionHandling.DuplicateResourceException;
import com.wipro.covaxin.exceptionHandling.ResourceNotFoundException;

import com.wipro.covaxin.model.Applicant;
import com.wipro.covaxin.repository.AadharDetailsRepository;
import com.wipro.covaxin.repository.ApplicantRepository;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantRepository apprepo;
	@Autowired
	AadharDetailsRepository aadharrepo;
	@Override
	public Applicant createApplicant(@RequestBody Applicant applicant)throws DuplicateResourceException{
		return apprepo.save(applicant);
		/* if(aadharrepo.existsById(applicant.getAadharDetails().getAadharId())){
	            throw new DuplicateResourceException("Applicant with Aadhar Id "+applicant.getAadharDetails().getAadharId()+" already registered");
	        }
	        Date advanceDate = applicant.getAadharDetails().getDob();
	        Calendar thisDateCalender = Calendar.getInstance();
	        thisDateCalender.setTime(advanceDate);
	        thisDateCalender.add(Calendar.YEAR,45);
	        advanceDate=thisDateCalender.getTime();
	        Date currentdate = new Date();
	        if((currentdate.compareTo(advanceDate)>0)){
	            if(applicant.getVaccinationTimeSlot().compareTo(currentdate)<0){
	                return ResponseEntity.accepted().body("Applicant not registered, vaccination time slot is past current date");
	            }
	            apprepo.save(applicant);
	            return new ResponseEntity<>("Applicant registered", HttpStatus.CREATED);
	        }else{
	            return ResponseEntity.accepted().body("Applicant not registered, age is less than 45");
	        }*/
	}
	@Override
	public List<Applicant> getAllApplicants() throws ResourceNotFoundException {
		if(apprepo.findAll().size()==0){
	            throw new ResourceNotFoundException("No applicants registered for vaccination");
	        }
	        return apprepo.findAll();	
	}
	@Override
	public Applicant getApplicantById(long id) throws ResourceNotFoundException {
		 if(!apprepo.existsById(id)){
	            throw new ResourceNotFoundException("Applicant with id "+id+" is not registered");
	        }
	        return apprepo.findById(id).get();
	}
	@Override
	public ResponseEntity<Object> updateApplicant(Applicant applicant, long id) throws ResourceNotFoundException {
		 if(!apprepo.existsById(id)){
	            throw new ResourceNotFoundException("Applicant with id "+id+" is not registered");
	        }
	        Applicant thisApplicant = apprepo.findById(id).get();
	    /*    if(applicant.getAadharDetails()!=null){
	        	applicant.setApplicantId(thisApplicant.getApplicantId());
	        	applicant.setAadharDetails(thisApplicant.getAadharDetails());
	        	apprepo.save(applicant);
	            return ResponseEntity.accepted().body("Update unsuccessful, aadhar details can not be updated");
	        }*/
	        return ResponseEntity.accepted().body("Update Successful");
	}
	@Override
	public ResponseEntity<Object> removeApplicant(long id) throws ResourceNotFoundException {
		 if(!apprepo.existsById(id)){
	            throw new ResourceNotFoundException("Applicant with id "+id+" does not exist, so can not be deleted");
	        }
	        apprepo.deleteById(id);
	        return ResponseEntity.accepted().body("Delete Successful");
	}

}
 