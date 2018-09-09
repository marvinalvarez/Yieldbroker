package com.yieldbroker.assignment.webservice.service.impl;

import org.springframework.stereotype.Service;

import com.yieldbroker.assignment.constant.Side;
import com.yieldbroker.assignment.exception.YieldBrokerBusinessException;
import com.yieldbroker.assignment.model.Order;
import com.yieldbroker.assignment.webservice.service.ValidationServiceInterf;

/**
 * Validates if the side field in the order is valid.
 * 
 * @author Marvin Alvarez
  */
@Service
public class SideValidationService implements ValidationServiceInterf{
	
	
	public boolean validate(Order order) {
		String side = order.getSide();
		System.out.println("validating side=" + side);

		if (Side.BUY.equals(order.getSide()) || Side.SELL.equals(order.getSide())) {
			return true;
		} else {
			throw new YieldBrokerBusinessException("Valid input is 'buy' or 'sell'. Invalid side=" + order.getSide());
		}
	}
}
