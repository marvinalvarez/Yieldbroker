package com.yieldbroker.assignment.model;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderBookTest {

	@Autowired
	private OrderBook orderBook;
	
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
		orderBook.refresh();
		System.out.println(orderBook.toString());
		{
			List<Order> buyOrders = orderBook.getBuyOrders();
			System.out.println("buyOrders.size()=" + buyOrders.size());
		}
		{
			List<Order> sellOrders = orderBook.getSellOrders();
			System.out.println("sellOrders.size()=" + sellOrders.size());
		}

	}

}
