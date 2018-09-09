package com.yieldbroker.assignment.webservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yieldbroker.assignment.exception.YieldBrokerBusinessException;
import com.yieldbroker.assignment.model.Order;
import com.yieldbroker.assignment.model.OrderBookDAOReader;
import com.yieldbroker.assignment.webservice.service.ValidationServiceInterf;

/**
 * Validates if the Client Order ID exists in the YB_ORDER table.
 * 
 * @author Marvin Alvarez
 */
@Service
public class ClientOrderIdValidationService implements ValidationServiceInterf {

	@Autowired
	private OrderBookDAOReader daoReader;

	/**
	 * Validates if the Client Order ID exists in the YB_ORDER table.
	 */
	public boolean validate(Order order) {
		int clientOrderId = order.getClientOrderId();
		System.out.println("clientOrderId=" + clientOrderId);

		List<Order> list = this.daoReader.getByClientOrderId(clientOrderId);
		System.out.println("number of records to delete. list.size()=" + list.size());

		if (list.size() > 0) {
			return true;
		} else {
			throw new YieldBrokerBusinessException(
					"Client Order Id does not exist in the order book=" + order.getClientOrderId());
		}
	}
}
