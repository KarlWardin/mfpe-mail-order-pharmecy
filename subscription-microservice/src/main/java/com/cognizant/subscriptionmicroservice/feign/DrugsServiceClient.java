package com.cognizant.subscriptionmicroservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.subscriptionmicroservice.exception.InvalidTokenException;
import com.cognizant.subscriptionmicroservice.model.Drugs;
import com.cognizant.subscriptionmicroservice.model.Stock;

@FeignClient(name = "${drugsservice.name}", url = "${drugsservice.url}")
public interface DrugsServiceClient {

	@GetMapping("/searchDrugsByID/{Drug_Id}")
	public Drugs searchDrugsByID(@RequestHeader("Authorization") final String token, @PathVariable("Drug_Id") String id)
			throws InvalidTokenException;

	@GetMapping("/searchDrugsByName/{Drug_Name}")
	public Drugs searchDrugsByName(@RequestHeader("Authorization") final String token,
			@PathVariable("Drug_Name") String name) throws InvalidTokenException;

	@GetMapping("/{Drug_Id}/{Location}")
	public Stock searchDrugsByIDAndLocation(@RequestHeader("Authorization") final String token,
			@PathVariable("Drug_Id") String id, @PathVariable("Location") String location) throws InvalidTokenException;
}
