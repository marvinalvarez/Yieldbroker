package com.yieldbroker.assignment.model.sort;

import java.util.Comparator;

import com.yieldbroker.assignment.model.Order;

public class OrderSorting_Sell implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {

		if (o1.getPrice().compareTo(o2.getPrice()) == 0) {
			return o1.getReceivedTime().compareTo(o2.getReceivedTime());
		} else {
			return o1.getPrice().compareTo(o2.getPrice());
		}
	}
}
