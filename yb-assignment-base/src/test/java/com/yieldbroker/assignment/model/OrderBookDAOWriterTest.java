package com.yieldbroker.assignment.model;

import java.math.BigDecimal;
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

import com.yieldbroker.assignment.constant.Side;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderBookDAOWriterTest {

	@Autowired
	private OrderBookDAOWriter writer;

	@Autowired
	private OrderBookDAOReader reader;

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

		{
			Order order = new Order();
			order.setClientOrderId(1);
			order.setPrice(new BigDecimal(11));
			order.setReceivedTime(java.sql.Timestamp.valueOf("2018-09-10 10:10:10.0"));
			order.setSide(Side.SELL);
			order.setVolume(111);
			writer.insert(order);
		}
		{
			Order order = new Order();
			order.setClientOrderId(2);
			order.setPrice(new BigDecimal(22));
			order.setReceivedTime(java.sql.Timestamp.valueOf("2018-09-12 12:12:12.0"));
			order.setSide(Side.BUY);
			order.setVolume(222);
			writer.insert(order);
		}
		{
			Order order = new Order();
			order.setClientOrderId(3);
			order.setPrice(new BigDecimal(33));
			order.setReceivedTime(java.sql.Timestamp.valueOf("2018-09-13 13:13:13.0"));
			order.setSide(Side.BUY);
			order.setVolume(333);
			writer.insert(order);
		}

		{
			List<Order> list = reader.getAll();
			for (Order order : list) {
				System.out.println("order=" + order);
			}
		}

	}

	@Test
	public void delete() {
		{
			Order order = new Order();
			order.setId(161);
			writer.delete(order);
		}
		{
			Order order = new Order();
			order.setId(162);
			writer.delete(order);
		}
		{
			Order order = new Order();
			order.setId(163);
			writer.delete(order);
		}
		{
			List<Order> list = reader.getAll();
			for (Order order : list) {
				System.out.println("order=" + order);
			}
		}

	}

}
