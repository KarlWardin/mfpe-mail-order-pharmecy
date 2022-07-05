package com.cognizant.drugsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.drugsmicroservice.model.Drugs;

@Repository
public interface DrugsRepo extends JpaRepository<Drugs,Integer>  {

}
