package com.yieldbroker.assignment.model;

import java.util.ArrayList;
import java.util.List;

public class OrderBook {

	private List<Order> buyOrders = new ArrayList<>();
	private List<Order> sellOrders = new ArrayList<>();

	public List<Order> getBuyOrders() {
		return buyOrders;
	}

	public List<Order> getSellOrders() {
		return sellOrders;
	}

	@Override
	public String toString() {
		return "OrderBook [buyOrders=" + buyOrders + ", sellOrders=" + sellOrders + "]";
	}

}
