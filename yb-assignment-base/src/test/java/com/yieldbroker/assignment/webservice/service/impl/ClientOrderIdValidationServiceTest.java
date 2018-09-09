package com.yieldbroker.assignment.webservice.service.impl;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
import com.yieldbroker.assignment.exception.YieldBrokerBusinessException;
import com.yieldbroker.assignment.model.Order;
import com.yieldbroker.assignment.model.OrderBookDAOWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ClientOrderIdValidationServiceTest {

	@Autowired
	private ClientOrderIdValidationService validationService;

	@Autowired
	private OrderBookDAOWriter orderBookWriter;

	private static Order order = new Order();
	{
		order.setClientOrderId(77777);
		order.setPrice(new BigDecimal(11));
		order.setReceivedTime(java.sql.Timestamp.valueOf("2018-09-10 10:10:10.0"));
		order.setSide(Side.SELL);
		order.setVolume(111);
	}

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
	public void test_Valid() {
		// insert test data
		orderBookWriter.insert(order);

		boolean validate = this.validationService.validate(order);
		System.out.println("validate=" + validate);
		Assert.assertTrue(validate);

		// cleanup
		orderBookWriter.delete(order);
	}

	@Test
	public void test_Invalid() {
		Order order = new Order();
		order.setClientOrderId(88888);

		try {
			this.validationService.validate(order);
			Assert.fail("YieldBrokerBusinessException must be thrown.");
		} catch (YieldBrokerBusinessException be) {
			System.out.println("YieldBrokerBusinessException successfully thrown and handled.");
		}
	}
}