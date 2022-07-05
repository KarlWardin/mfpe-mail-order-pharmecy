package com.cognizant.drugsmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.drugsmicroservice.model.Drugs;
import com.cognizant.drugsmicroservice.model.DrugsLocation;
import com.cognizant.drugsmicroservice.service.DrugsLocationService;
import com.cognizant.drugsmicroservice.service.DrugsService;

@RestController
public class DrugsController {
	@Autowired
	private DrugsService drugsService;
	@Autowired
	private DrugsLocationService drugsLocationservice;

	@GetMapping("/searchDrugsByID/{Drug_Id}")
	public void searchDrugsByID(@PathVariable("Drug_Id") int id) {

	}

	@GetMapping("/searchDrugsByName/{Drug_Name}")
	public void searchDrugsByName(@PathVariable("Drug_Name") int id) {

	}

	@GetMapping("/{Drug_Name}/{Location}")  //??
	public void searchDrugsByIDAndLocation(@PathVariable("Drug_Name") int id, @PathVariable("Location") String location) {

	}
}
