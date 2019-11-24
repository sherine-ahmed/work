package com.conichi.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Sherine.Emad
 * Start Conichi application scanning all required services in the package
 *  
 **/

@SpringBootApplication(scanBasePackages = {"com.conichi"})
public class ConichiCurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConichiCurrencyConversionApplication.class, args);
	}
}
