package com.cognizant.drugsmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Drug-Location")
public class DrugsLocation {
	@Id
	@Column(name="Drug_Id")
	private int id;
	//TODO -- ex "private String loc"
	
}
