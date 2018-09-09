package com.yieldbroker.assignment.model.sort;

import java.util.Comparator;

import com.yieldbroker.assignment.model.Order;

/**
 * Comparator for sorting BUY trades where they are sorted by price (descending)
 * and then time stamp (ascending).
 * 
 * @author Marvin Alvarez
 */
public class OrderSorting_Buy implements Comparator<Order> {

	/**
	 * Comparator for sorting BUY trades where they are sorted by price (descending)
	 * and then time stamp (ascending).
	 */
	@Override
	public int compare(Order o1, Order o2) {

		if (o1.getPrice().compareTo(o2.getPrice()) == 0) {
			return o1.getReceivedTime().compareTo(o2.getReceivedTime());
		} else {
			return o2.getPrice().compareTo(o1.getPrice());
		}
	}
}
