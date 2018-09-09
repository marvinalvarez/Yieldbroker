package com.yieldbroker.assignment.webservice.service;

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

import com.yieldbroker.assignment.exception.YieldBrokerBusinessException;
import com.yieldbroker.assignment.model.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderValidationServiceTest {

	@Autowired
	private OrderValidationService orderValidationService;

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
	public void testAll() {
		Order order = new Order();
		order.setSide("buy");

		boolean validate_side = this.orderValidationService.isValid(order);
		Assert.assertTrue(validate_side);
	}

	@Test
	public void testAll_Invalid() {
		Order order = new Order();
		order.setSide("UKNOWN_SIDE");

		try {
			this.orderValidationService.isValid(order);
		} catch (YieldBrokerBusinessException be) {
			System.out.println("YieldBrokerBusinessException successfully thrown and handled.");
		}
	}

}