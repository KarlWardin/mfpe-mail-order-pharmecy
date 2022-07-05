package com.cognizant.refillmicroservice.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.refillmicroservice.model.RefillOrder;

@RestController
public class RefillController {

	@GetMapping("/viewRefillStatus/{Subscription_ID}")
	public RefillOrder viewRefillStatus(@PathVariable int Subscription_ID) {
		return null;
	}

	@GetMapping("/getRefillDuesAsOfDate/{Subscription_ID}/{fromDate}")
	public RefillOrder getRefillDuesAsOfDate(@PathVariable("Subscription_ID") int Subscription_ID,
			@PathVariable("fromDate") Date fromDate) {
		return null;
	}
	
	@PostMapping("/requestAdhocRefill")
	public RefillOrder requestAdhocRefill(
			//Input: Policy_ID, Member_ID, Subscription_ID, Location
			) {
		return null;
	}

}
