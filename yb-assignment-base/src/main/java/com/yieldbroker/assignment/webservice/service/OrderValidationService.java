package com.yieldbroker.assignment.webservice.service;

import org.springframework.stereotype.Service;

import com.yieldbroker.assignment.constant.Side;
import com.yieldbroker.assignment.exception.YieldBrokerBusinessException;
import com.yieldbroker.assignment.model.Order;

@Service
public class OrderValidationService {

	public boolean isValid(Order order) {
		return this.validate_side(order);
	}

	public boolean validate_side(Order order) {
		String side = order.getSide();
		System.out.println("validing side=" + side);

		if (Side.BUY.equals(order.getSide()) || Side.SELL.equals(order.getSide())) {
			return true;
		} else {
			throw new YieldBrokerBusinessException("Valid input is 'buy' or 'sell'. Invalid side=" + order.getSide());
		}
	}

}
