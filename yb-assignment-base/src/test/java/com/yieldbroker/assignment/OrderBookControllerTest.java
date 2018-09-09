
package com.yieldbroker.assignment;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.yieldbroker.assignment.controller.OrderBookController;
import com.yieldbroker.assignment.model.Order;
import com.yieldbroker.assignment.model.OrderBook;
import com.yieldbroker.assignment.model.OrderBookDAOWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderBookControllerTest {

	@Autowired
	private OrderBookController orderBookController;

	@Autowired
	private OrderBookDAOWriter writer;

	@After
	public void tearDown() throws Exception {
		writer.deleteByClientOrderId(1);
	}

	@Test
	public void shouldBeEmpty() {
		Assert.assertTrue(orderBookController.getOrderBook().getBuyOrders().isEmpty());
		Assert.assertTrue(orderBookController.getOrderBook().getSellOrders().isEmpty());
	}

	@Test
	public void shouldBeBuyOrderAfterPlaceOrder() throws Exception {

		BigDecimal buyPrice = new BigDecimal("2.5");
		int buyVolume = 100;

		orderBookController.placeOrder(1, "buy", buyPrice, buyVolume);
		OrderBook orderBook = orderBookController.getOrderBook();
		List<Order> buyOrders = orderBook.getBuyOrders();
		Assert.assertEquals(1, buyOrders.size());

		Order order = buyOrders.get(0);
		System.out.println("order=" + order);
		Assert.assertEquals(buyPrice, order.getPrice());
		Assert.assertEquals(buyVolume, order.getVolume());
	}

	@Test
	public void shouldBeEmptyAfterPlaceAndCancel() throws Exception {

		orderBookController.placeOrder(1, "buy", new BigDecimal("2.5"), 100);
		orderBookController.cancelOrder(1);

		Assert.assertTrue(orderBookController.getOrderBook().getBuyOrders().isEmpty());
		Assert.assertTrue(orderBookController.getOrderBook().getSellOrders().isEmpty());
	}

}
