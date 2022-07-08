package com.cognizant.subscriptionmicroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.subscriptionmicroservice.exception.InvalidTokenException;
import com.cognizant.subscriptionmicroservice.feign.DrugsServiceClient;
import com.cognizant.subscriptionmicroservice.feign.RefillServiceClient;
import com.cognizant.subscriptionmicroservice.model.PrescriptionDetails;
import com.cognizant.subscriptionmicroservice.model.SubscriptionDetails;
import com.cognizant.subscriptionmicroservice.service.SubscriptionService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(produces = "application/json", value = "Manages subscriptions and unsubscriptions")
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;

	@PostMapping("/subscrribe")
	public SubscriptionDetails subscribe(@RequestHeader("Authorization") String token,
			@RequestBody PrescriptionDetails prescription) {

		return subscriptionService.subscribe(prescription, token);

	}

	@PostMapping("/unsubscrribe/{mId}/{sId}")
	public SubscriptionDetails unsubscribe(@RequestHeader("Authorization") String token,
			@PathVariable("mId") String memberId, @PathVariable("sId") Long subscriptionId) {

		return subscriptionService.unsubscribe(memberId, subscriptionId, token);

	}
}
