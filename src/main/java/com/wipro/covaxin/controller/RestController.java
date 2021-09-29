package com.wipro.covaxin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.covaxin.exceptionHandling.DuplicateResourceException;
import com.wipro.covaxin.exceptionHandling.ResourceNotFoundException;
import com.wipro.covaxin.model.Applicant;
import com.wipro.covaxin.service.ApplicantService;





@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
	 @Autowired
	    private ApplicantService service;
	 @GetMapping("/")
	    public String index(Model model) {

	        // add `message` attribute
	        model.addAttribute("message", "Thank you for visiting.");

	        // return view name
	        return "index";
	    }
	 @GetMapping("applicant")
	    private List<Applicant> getAllApplicants() throws ResourceNotFoundException {
	        return service.getAllApplicants();
	    }
	 @GetMapping("applicant/{id}")
	    private Applicant getApplicantById(@PathVariable long id) throws ResourceNotFoundException {
	        return service.getApplicantById(id);
	    }

	@PostMapping("applicant")
	public Applicant createApplicant(@Valid @RequestBody Applicant newApplicant) throws DuplicateResourceException   {
		return service.createApplicant(newApplicant);
	}
	 @PutMapping("updateApplicant/{id}")
	    private ResponseEntity<Object> updateApplicant(@RequestBody Applicant applicant, @PathVariable long id) throws ResourceNotFoundException {
	        return service.updateApplicant(applicant,id);
	    }

	    @DeleteMapping("removeApplicant/{id}")
	    private ResponseEntity<Object> removeApplicant(@PathVariable long id) throws ResourceNotFoundException {
	        return service.removeApplicant(id);
	    }
}
