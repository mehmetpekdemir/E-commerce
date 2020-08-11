package com.mehmetpekdemir.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
