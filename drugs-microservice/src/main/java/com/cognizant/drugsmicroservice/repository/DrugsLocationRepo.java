package com.cognizant.drugsmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.drugsmicroservice.model.DrugsLocation;


@Repository
public interface DrugsLocationRepo extends JpaRepository<DrugsLocation, String> {

}
