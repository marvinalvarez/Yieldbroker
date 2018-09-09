package com.yieldbroker.assignment.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yieldbroker.assignment.model.Order;
import com.yieldbroker.assignment.model.OrderBook;
import com.yieldbroker.assignment.model.OrderBookDAOWriter;

/**
 * Order Book Controller for retrieving, adding, and deleting orders from the
 * Order Book.
 * 
 * @author Marvin Alvarez
 */
@Component
public class OrderBookController {
	@Autowired
	private OrderBookDAOWriter orderBookDAOWriter;

	@Autowired
	private OrderBook orderBook;

	/**
	 * Gets the current contents of the order book
	 * 
	 * @return order book containing buy and sell orders
	 */
	public OrderBook getOrderBook() {
		return orderBook;
	}

	/**
	 * Places an order into the order book
	 * 
	 * @param order
	 */
	public void placeOrder(Order order) {

		order.setReceivedTime(new Timestamp(System.currentTimeMillis()));
		this.orderBookDAOWriter.insert(order);
	}

	/**
	 * Place an order into the order book
	 * 
	 * @param clientOrderId
	 *            - Order ID selected by client to identify the order
	 * @param side
	 *            - either "buy" or "sell"
	 * @param price
	 *            - the price to buy or sell at. (must be positive)
	 * @param volume
	 *            - the amount to buy or sell. (must be positive)
	 */
	public void placeOrder(int clientOrderId, String side, BigDecimal price, int volume) {
		Order order = new Order();
		order.setClientOrderId(clientOrderId);
		order.setSide(side);
		order.setPrice(price);
		order.setVolume(volume);

		this.placeOrder(order);
	}

	/**
	 * Removes the clients order id from the order book
	 * 
	 * @param Order
	 *            order
	 */
	public void cancelOrder(Order order) {
		this.orderBookDAOWriter.deleteByClientOrderId(order.getClientOrderId());
	}

	/**
	 * Removes the clients order id from the order book
	 * 
	 * @param clientOrderId
	 */
	public void cancelOrder(int clientOrderId) {
		this.orderBookDAOWriter.deleteByClientOrderId(clientOrderId);
	}
}