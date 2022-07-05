package com.cognizant.drugsmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.drugsmicroservice.repository.DrugsRepo;

@Service
public class DrugsService {

	@Autowired
	private DrugsRepo repo;
	
	
}
