package com.wipro.covaxin.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wipro.covaxin.model.AadharDetails;

@Repository
public interface AadharDetailsRepository extends MongoRepository<AadharDetails,Long> {

}
