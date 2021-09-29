package com.wipro.covaxin.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wipro.covaxin.model.Applicant;
@Repository
public interface ApplicantRepository extends MongoRepository<Applicant,Long>{

}
