
package com.yieldbroker.assignment;

import java.math.BigDecimal;

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
import com.yieldbroker.assignment.model.OrderBook;
import com.yieldbroker.assignment.model.OrderBookDAOWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderBookControllerTest2 {

	@Autowired
	private OrderBookController orderBookController;

	@Autowired
	private OrderBookDAOWriter writer;

	@After
	public void tearDown() throws Exception {
		writer.deleteByClientOrderId(2);
	}

	@Test
	public void shouldBeEmpty() {

	}

	@Test
	public void shouldBeBuyOrderAfterPlaceOrder() throws Exception {

		OrderBook orderBook = orderBookController.getOrderBook();
		orderBook.refresh();
		System.out.println("BEFORE=" + orderBook);
	}


}
