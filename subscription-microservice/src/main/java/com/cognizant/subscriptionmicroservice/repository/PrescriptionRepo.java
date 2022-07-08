package com.cognizant.subscriptionmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.subscriptionmicroservice.model.PrescriptionDetails;

@Repository
public interface PrescriptionRepo extends JpaRepository<PrescriptionDetails,Long> {

}
