package com.yieldbroker.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main application
 * 
 * @author Marvin ALvarez
 *
 */
@SpringBootApplication
@EnableSwagger2
public class AssignmentApplication {

	/**
	 * Main class to start the webservice.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
}