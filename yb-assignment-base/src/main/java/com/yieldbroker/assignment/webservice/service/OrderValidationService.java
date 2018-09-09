package com.yieldbroker.assignment.webservice.service;

import org.springframework.stereotype.Service;

import com.yieldbroker.assignment.model.Order;
import com.yieldbroker.assignment.webservice.service.impl.SideValidationService;

/**
 * Validates if an order is valid.
 * 
 * @author Marvin Alvarez
 */
@Service
public class OrderValidationService {

	/**
	 * Additional validation services can be added to this convenience service to validate orders.
	 * 
	 * @param order
	 * @return
	 */
	public boolean isValid(Order order) {
		SideValidationService sideValidationService = new SideValidationService();
		return sideValidationService.validate(order);
	}
}