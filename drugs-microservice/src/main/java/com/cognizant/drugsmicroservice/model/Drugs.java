package com.cognizant.drugsmicroservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Drug")
public class Drugs {
	@Id
	@Column(name="Drug_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String mf_details;
	private String composition;
	private Date mf_date;
	private Date exp_date;
	private int units_per_package;
	private double cost_per_package;
}
