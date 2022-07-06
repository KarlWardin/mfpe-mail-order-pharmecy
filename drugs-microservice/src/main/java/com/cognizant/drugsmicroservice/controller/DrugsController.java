package com.cognizant.drugsmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.drugsmicroservice.exception.InvalidTokenException;
import com.cognizant.drugsmicroservice.model.Drugs;
import com.cognizant.drugsmicroservice.model.Stock;
import com.cognizant.drugsmicroservice.service.DrugsService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
public class DrugsController {
	@Autowired
	private DrugsService drugsService;

	@ApiOperation(value = "Get all drugs", response = List.class)
	@GetMapping("/getAllDrugs")
	public List<Drugs> getAllDrugs(@RequestHeader("Authorization") final String token) {
		return drugsService.getAllDrugs();
	}

	@ApiOperation(value = "Search drug by id", response = Drugs.class)
	@GetMapping("/searchDrugsByID/{Drug_Id}")
	public Drugs searchDrugsByID(@RequestHeader("Authorization") final String token,
			@PathVariable("Drug_Id") String id) throws InvalidTokenException {
		return drugsService.getDrugById(id, token);
	}

	@ApiOperation(value = "Search drug by name", response = Drugs.class)
	@GetMapping("/searchDrugsByName/{Drug_Name}")
	public Drugs searchDrugsByName(@RequestHeader("Authorization") final String token,
			@PathVariable("Drug_Name") String name) throws InvalidTokenException {
		return drugsService.getDrugByName(name, token);
	}

	@ApiOperation(value = "Search stock by id", response = Stock.class)
	@GetMapping("/{Drug_Name}/{Location}")
	public Stock searchDrugsByIDAndLocation(@RequestHeader("Authorization") final String token,
			@PathVariable("Drug_Name") int id, @PathVariable("Location") String location) throws InvalidTokenException {
		return drugsService.getDispatchableDrugStock(id, location, token);
	}
}
