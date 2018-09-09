package com.yieldbroker.assignment.model.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yieldbroker.assignment.constant.Side;
import com.yieldbroker.assignment.model.Order;

public class OrderSorting_BuyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<Order> list = new ArrayList<Order>();

		{
			Order order = new Order();
			order.setClientOrderId(1111);
			order.setPrice(new BigDecimal(11));
			order.setReceivedTime(java.sql.Timestamp.valueOf("2018-09-12 10:10:10.0"));
			order.setSide(Side.BUY);
			order.setVolume(111);

			list.add(order);
		}
		{
			Order order = new Order();
			order.setClientOrderId(1111);
			order.setPrice(new BigDecimal(11));
			order.setReceivedTime(java.sql.Timestamp.valueOf("2018-09-11 10:10:10.0"));
			order.setSide(Side.BUY);
			order.setVolume(111);

			list.add(order);
		}
		{
			Order order = new Order();
			order.setClientOrderId(1111);
			order.setPrice(new BigDecimal(111));
			order.setReceivedTime(java.sql.Timestamp.valueOf("2018-08-10 10:10:10.0"));
			order.setSide(Side.BUY);
			order.setVolume(11);

			list.add(order);
		}
		{
			Order order = new Order();
			order.setClientOrderId(1111);
			order.setPrice(new BigDecimal(11));
			order.setReceivedTime(java.sql.Timestamp.valueOf("2018-09-10 10:10:10.0"));
			order.setSide(Side.BUY);
			order.setVolume(111);

			list.add(order);
		}

		System.out.println("unsorted");
		this.print(list);

		Collections.sort(list, new OrderSorting_Buy());

		System.out.println("sorted");
		this.print(list);
	}

	private void print(List<Order> list) {
		for (Order order : list) {
			System.out.println("order=" + order);
		}
	}
}
