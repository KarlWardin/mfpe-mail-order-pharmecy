package com.cognizant.subscriptionmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.subscriptionmicroservice.model.SubscriptionDetails;

@Repository
public interface SubscriptionRepo extends JpaRepository<SubscriptionDetails,Long> {

}
