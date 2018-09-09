package com.yieldbroker.assignment.webservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yieldbroker.assignment.controller.OrderBookController;
import com.yieldbroker.assignment.model.Order;
import com.yieldbroker.assignment.model.OrderBook;
import com.yieldbroker.assignment.webservice.service.OrderValidationService;
import com.yieldbroker.assignment.webservice.service.impl.ClientOrderIdValidationService;
import com.yieldbroker.assignment.webservice.util.JsonUtil;

import io.swagger.annotations.ApiOperation;

/**
 * RESTful webservices to expose the OrderBook and its operations.
 * 
 * @author Marvin Alvarez
 */
@RestController
public class OrderBookWebService {

	@Autowired
	private OrderBookController orderBookController;

	@Autowired
	private OrderValidationService orderValidationService;

	@Autowired
	private ClientOrderIdValidationService clientOrderIdValidationService;

	/**
	 * Returns the order book.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/market/orderbook", method = RequestMethod.POST)
	@ApiOperation(value = "Returns all orders grouped by side (i.e. buy or sell)")
	public String getOrderBook() {
		Map<String, List<Order>> map = new HashMap<String, List<Order>>();

		OrderBook orderBook = this.orderBookController.getOrderBook();
		{
			List<Order> list = orderBook.getBuyOrders();
			map.put("buyOrders", list);
		}
		{
			List<Order> list = orderBook.getSellOrders();
			map.put("sellOrders", list);
		}
		String json = JsonUtil.convert(map);
		return json;
	}

	/**
	 * Places an order on the order book.
	 * 
	 * @param clientOrderId
	 * @param side
	 * @param price
	 * @param volume
	 * @return
	 */
	@RequestMapping(value = "/market/placeOrder", method = RequestMethod.POST)
	@ApiOperation(value = "Places an order in the order book")
	public String placeOrder(@RequestParam("clientOrderId") int clientOrderId, @RequestParam("side") String side,
			@RequestParam("price") BigDecimal price, @RequestParam("volume") int volume) {

		Order order = new Order();
		order.setClientOrderId(clientOrderId);
		order.setSide(side);
		order.setPrice(price);
		order.setVolume(volume);
		this.orderValidationService.isValid(order);

		this.orderBookController.placeOrder(order);

		String result = "Order is added to internal list of buy or sell orders.";
		return result;
	}

	/**
	 * Removes an order from the order book.
	 * 
	 * @param clientOrderId
	 * @return
	 */
	@RequestMapping(value = "/market/cancelOrder", method = RequestMethod.POST)
	@ApiOperation(value = "Removes an order from the orderbook")
	public String removeOrder(@RequestParam("clientOrderId") int clientOrderId) {

		Order order = new Order();
		order.setClientOrderId(clientOrderId);

		System.out.println("Deleting order with clientOrderId=" + order.getClientOrderId());
		clientOrderIdValidationService.validate(order);

		this.orderBookController.cancelOrder(order);

		String result = "Order removed from order book.";
		return result;
	}
}
