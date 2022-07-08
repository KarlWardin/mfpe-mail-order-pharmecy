package com.cognizant.subscriptionmicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrescriptionDetails {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long prescriptionId;
		private String memberId;
		private String memberLocation;
		private String policyNumber;
		private String insuranceProvider;
		private Date prescriptionDate;
		private String drugName;
		private String dosageDefinition;
		private int quantity;
		private int courseDuration; 
		private String doctorName;

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