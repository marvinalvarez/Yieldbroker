package com.yieldbroker.assignment.webservice.service;

import com.yieldbroker.assignment.model.Order;

/**
 * Interface for all validations services to follow.
 * 
 * @author Marvin Alvarez
 */
public interface ValidationServiceInterf {

	/**
	 * Returns true if the validation passed.
	 * 
	 * @param order
	 * @return
	 */
	public boolean validate(Order order);
}
