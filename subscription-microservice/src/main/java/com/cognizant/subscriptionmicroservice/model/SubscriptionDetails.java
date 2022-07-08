package com.cognizant.subscriptionmicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscriptionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subscriptionId;
	private Long prescriptionId;
	private String drugName;
	private int refillCycle;
	private int quantity;
	private String memberId;
	private Date subscriptionDate;
	private String memberLocation;
	private String subscriptionStatus;
}


/*
<Subscription details of the member like Member ID, 
Subscription Date, 
Prescription ID, 
Refill Occurrence (Weekly / Monthly etc.), 
Member Location , 
Subscription Status etc.>
*/