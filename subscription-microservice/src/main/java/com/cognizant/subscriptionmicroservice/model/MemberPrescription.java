package com.cognizant.subscriptionmicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="")
public class MemberPrescription {
	private int prescription_id;
    private int member_id;
    private int insurance_policy_number;
    private String insurance_provider;
    private Date prescription_date;
    private String dosage_definition;
    private double prescription_course;
    private Doctor doctor_details;
}


/*
<Prescription details of the member like Member ID, 
Insurance_Policy_Number, 
Insurance Provider, 
Prescription Date, 
drug ID, 
dosage definitions for a day, 
Prescription Course, 
Doctor details etc.>
*/