package com.cognizant.subscriptionmicroservice.feign;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.subscriptionmicroservice.model.RefillOrder;


@FeignClient(name = "${refillservice.name}", url = "${refillservice.url}")
public interface RefillServiceClient {

	@GetMapping("/viewRefillStatus/{Subscription_ID}")
	public RefillOrder viewRefillStatus(@RequestHeader("Authorization") String token,
			@PathVariable int Subscription_ID);
	
	@GetMapping("/getRefillDuesAsOfDate/{Subscription_ID}/{fromDate}")
	public RefillOrder getRefillDuesAsOfDate(@RequestHeader("Authorization") String token,@PathVariable("Subscription_ID") int Subscription_ID,
			@PathVariable("fromDate") Date fromDate);
	
	@PostMapping("/requestAdhocRefill")
	public RefillOrder requestAdhocRefill(@RequestHeader("Authorization") String token, Long long1, String string, int i, int j);
	
}
