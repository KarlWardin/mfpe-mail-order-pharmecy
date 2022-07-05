package com.cognizant.subscriptionmicroservice.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class MemberSubscription {
    private int member_id;
	private Date subscription_date;
	private int prescription_id;
	private String refill_occurance;
	private String member_location;
	private String subscription_status;
}


/*
<Subscription details of the member like Member ID, 
Subscription Date, 
Prescription ID, 
Refill Occurrence (Weekly / Monthly etc.), 
Member Location , 
Subscription Status etc.>
*/