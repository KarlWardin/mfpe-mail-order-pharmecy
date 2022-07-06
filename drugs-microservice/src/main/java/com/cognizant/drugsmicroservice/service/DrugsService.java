package com.cognizant.drugsmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.drugsmicroservice.exception.InvalidTokenException;
import com.cognizant.drugsmicroservice.feign.AuthorizationClient;
import com.cognizant.drugsmicroservice.model.Drugs;
import com.cognizant.drugsmicroservice.model.Stock;
import com.cognizant.drugsmicroservice.repository.DrugsLocationRepo;
import com.cognizant.drugsmicroservice.repository.DrugsRepo;

@Service
public class DrugsService {

	@Autowired
	private DrugsRepo drugRepo;
	@Autowired
	private DrugsLocationRepo locationRepo;

	@Autowired
	private AuthorizationClient authorizationClient;

	public List<Drugs> getAllDrugs() {
		return drugRepo.findAll();
	}

	public Drugs getDrugById(String id, String token) throws InvalidTokenException {
		if (authorizationClient.getValidity(token)) {
			return drugRepo.getById(id);
		}
		throw new InvalidTokenException("Invalid Credentials");
	}

	public Drugs getDrugByName(String name, String token) throws InvalidTokenException {
		if (authorizationClient.getValidity(token)) {
			return drugRepo.findBydrugName(name).get();
		}
		throw new InvalidTokenException("Invalid Credentials");
	}

	public Stock getDispatchableDrugStock(int id, String location, String token) throws InvalidTokenException {
		if (authorizationClient.getValidity(token)) {
			Stock stock = new Stock();
			return stock;
		}
		throw new InvalidTokenException("Invalid Credentials");
	}

}
