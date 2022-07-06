package com.cognizant.drugsmicroservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class Drugs {
	@Id
	private String drugId;;
	private String drugName;
	private String manufacturer;
	private Date manufactureDate;
	private Date expiryDate;
	@OneToMany(mappedBy = "drugs")
    private List<DrugsLocation> druglocationQuantities;
	//private String composition;
	//private int units_per_package;
	//private double cost_per_package;
	
	public Drugs() {
        this.druglocationQuantities = new ArrayList<DrugsLocation>();
    }
	public Drugs(final String drugId, final String drugName, final String manufacturer, final Date manufactureDate, final Date expiryDate, final List<DrugsLocation> druglocationQuantities) {
        this.druglocationQuantities = new ArrayList<DrugsLocation>();
        this.drugId = drugId;
        this.drugName = drugName;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.druglocationQuantities = druglocationQuantities;
    }
}
