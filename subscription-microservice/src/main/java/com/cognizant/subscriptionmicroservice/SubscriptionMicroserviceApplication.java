package com.cognizant.subscriptionmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SubscriptionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionMicroserviceApplication.class, args);
	}

}
