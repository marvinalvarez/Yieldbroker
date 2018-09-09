package com.yieldbroker.assignment.model;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yieldbroker.assignment.constant.Side;
import com.yieldbroker.assignment.model.sort.OrderSorting_Buy;
import com.yieldbroker.assignment.model.sort.OrderSorting_Sell;

/**
 * An order book that is a representation of the table YB_ORDER
 * 
 * @author Marvin Alvarez
 */
@Service
public class OrderBook {

	/**
	 * DAO for reading the YB_ORDER table
	 */
	@Autowired
	private OrderBookDAOReader orderBookDao;

	/**
	 * Constructor
	 */
	public OrderBook() {
	}

	/**
	 * Returns a list of BUY orders.
	 * 
	 * @return
	 */
	public List<Order> getBuyOrders() {

		List<Order> buyOrders = this.orderBookDao.getBySide(Side.BUY);
		if (buyOrders.size() > 0) {
			Collections.sort(buyOrders, new OrderSorting_Buy());
		}

		return buyOrders;
	}

	/**
	 * Returns a list of SELL orders.
	 * 
	 * @return
	 */
	public List<Order> getSellOrders() {

		List<Order> sellOrders = this.orderBookDao.getBySide(Side.SELL);
		if (sellOrders.size() > 0) {
			Collections.sort(sellOrders, new OrderSorting_Sell());
		}
		return sellOrders;
	}
}