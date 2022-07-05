package com.cognizant.subscriptionmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.subscriptionmicroservice.feign.DrugsServiceClient;
import com.cognizant.subscriptionmicroservice.feign.RefillServiceClient;
import com.cognizant.subscriptionmicroservice.model.MemberPrescription;
import com.cognizant.subscriptionmicroservice.model.MemberSubscription;

@RestController
public class SubscriptionController {

	@Autowired
	private DrugsServiceClient drugsServiceClient;
	
	@Autowired
	private RefillServiceClient refillServiceClient;
	
	@PostMapping("/subscrribe")
	public MemberSubscription subscribe(@RequestBody MemberPrescription prescription) {
		//o/p-   Subscription Status, Subscription Status Description
		//drugsServiceClient
		return null;
	}
	@PostMapping("/unsubscrribe")
	public MemberSubscription unsubscribe(int Member_ID, int Subscription_ID) {
		//o/p-  Subscription Status, Subscription Status Description
		//refillServiceClient
		return null;
	}
}
