package com.cognizant.drugsmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.drugsmicroservice.repository.DrugsLocationRepo;

@Service
public class DrugsLocationService {

	@Autowired
	private DrugsLocationRepo repo;
	
}
