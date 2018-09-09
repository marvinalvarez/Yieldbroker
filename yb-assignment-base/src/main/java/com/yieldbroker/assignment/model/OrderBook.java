package com.yieldbroker.assignment.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yieldbroker.assignment.constant.Side;

@Service
public class OrderBook {

	@Autowired
	private OrderBookDAOReader orderBookDao;

	private List<Order> buyOrders = new ArrayList<>();
	private List<Order> sellOrders = new ArrayList<>();

	public OrderBook() {

	}

	public List<Order> getBuyOrders() {

		return this.buyOrders;
	}

	public List<Order> getSellOrders() {

		return this.sellOrders;
	}

	public void refresh() {
		this.buyOrders = this.orderBookDao.getBySide(Side.BUY);
		if (this.buyOrders.size() > 0) {
			//Collections.sort(this.buyOrders, new OrderSorting_Buy());
			// TODO [MARVIN] uncomment
		}

		this.sellOrders = this.orderBookDao.getBySide(Side.SELL);
		if (this.sellOrders.size() > 0) {
			//Collections.sort(this.sellOrders, new OrderSorting_Sell());
			// TODO [MARVIN] uncomment
		}
	}

	@Override
	public String toString() {
		return "OrderBook [buyOrders=" + this.buyOrders + ", sellOrders=" + this.sellOrders + "]";
	}

}
