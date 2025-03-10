package com.dev.insurance_vehicles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dev.insurance_vehicles"})
public class InsuranceVehiclesApplication {
	public static void main(String[] args) {
		SpringApplication.run(InsuranceVehiclesApplication.class, args);
	}
}
