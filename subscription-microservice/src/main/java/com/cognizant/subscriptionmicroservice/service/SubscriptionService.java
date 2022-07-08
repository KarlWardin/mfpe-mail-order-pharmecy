package com.cognizant.subscriptionmicroservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cognizant.subscriptionmicroservice.exception.InvalidTokenException;
import com.cognizant.subscriptionmicroservice.feign.AuthorizationClient;
import com.cognizant.subscriptionmicroservice.feign.DrugsServiceClient;
import com.cognizant.subscriptionmicroservice.feign.RefillServiceClient;
import com.cognizant.subscriptionmicroservice.model.PrescriptionDetails;
import com.cognizant.subscriptionmicroservice.model.SubscriptionDetails;
import com.cognizant.subscriptionmicroservice.repository.PrescriptionRepo;
import com.cognizant.subscriptionmicroservice.repository.SubscriptionRepo;

@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionRepo subscriptionRepo;
	@Autowired
	private PrescriptionRepo prescriptionRepo;

	// feigns
	@Autowired
	private AuthorizationClient authClient;
	@Autowired
	private DrugsServiceClient drugsClient;
	@Autowired
	private RefillServiceClient refillClient;

	public SubscriptionDetails subscribe(PrescriptionDetails prescription, String token) throws InvalidTokenException {
		if (authClient.getValidity(token)) {
			drugsClient.searchDrugsByName(token, token);
			PrescriptionDetails prescriptionDetails = prescriptionRepo.save(prescription);
			SubscriptionDetails subscriptionDetail = new SubscriptionDetails(1L,prescriptionDetails.getPrescriptionId(),
					prescriptionDetails.getDrugName(), prescriptionDetails.getCourseDuration(),
					prescriptionDetails.getQuantity(), prescriptionDetails.getMemberId(), new Date(),
					prescriptionDetails.getMemberLocation(), "active");

			SubscriptionDetails subscriptionDetails = subscriptionRepo.save(subscriptionDetail);
			refillClient.requestAdhocRefill(token, subscriptionDetails.getSubscriptionId(),
					subscriptionDetails.getMemberId(), subscriptionDetails.getQuantity(),
					subscriptionDetails.getRefillCycle());
			
			return subscriptionDetail;

		}
		throw new InvalidTokenException("Invalid Credentials");
		
	}

	public SubscriptionDetails unsubscribe(String memberId, Long subscriptionId, String token) {
		if (authClient.getValidity(token)) {
			if (!refillClient.getRefillDuesAsOfDate(token, subscriptionId)) {
				return new ResponseEntity<>("You have to clear your payment dues first.", HttpStatus.OK);
			}
			subscriptionRepo.deleteById(subscriptionId);
			refillClient.deleteRefillData(token, subscriptionId);
		}
		throw new InvalidTokenException("Invalid Credentials");
	}

}
