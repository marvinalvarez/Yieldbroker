package com.yieldbroker.assignment.webservice;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yieldbroker.assignment.constant.Side;
import com.yieldbroker.assignment.model.Order;
import com.yieldbroker.assignment.model.OrderBookDAOReader;
import com.yieldbroker.assignment.model.OrderBookDAOWriter;
import com.yieldbroker.assignment.webservice.service.OrderValidationService;
import com.yieldbroker.assignment.webservice.service.impl.ClientOrderIdValidationService;
import com.yieldbroker.assignment.webservice.util.JsonUtil;

import io.swagger.annotations.ApiOperation;

@RestController
public class OrderBookWebService {

	@Autowired
	private OrderBookDAOReader orderbookDaoReader;

	@Autowired
	private OrderBookDAOWriter orderBookDAOWriter;

	@Autowired
	private OrderValidationService orderValidationService;
	
	@Autowired
	private ClientOrderIdValidationService clientOrderIdValidationService;

	@RequestMapping(value = "/market/orderbook", method = RequestMethod.POST)
	@ApiOperation(value = "Returns all orders grouped by side (i.e. buy or sell)")
	public String getOrderBook() {
		Map<String, List<Order>> map = new HashMap<String, List<Order>>();

		{
			List<Order> list = orderbookDaoReader.getBySide(Side.BUY);
			map.put("buyOrders", list);
		}
		{
			List<Order> list = orderbookDaoReader.getBySide(Side.SELL);
			map.put("sellOrders", list);
		}
		String json = JsonUtil.convert(map);
		return json;
	}

	@RequestMapping(value = "/market/orderbook_side", method = RequestMethod.POST)
	@ApiOperation(value = "Returns the order book by side")
	public String getOrderBook_Sell(@RequestParam("side") String side) {
		Map<String, List<Order>> map = new HashMap<String, List<Order>>();

		{
			List<Order> list = orderbookDaoReader.getBySide(side);
			map.put("sellOrders", list);
		}
		String json = JsonUtil.convert(map);
		return json;
	}

	@RequestMapping(value = "/market/placeOrder", method = RequestMethod.POST)
	@ApiOperation(value = "Places an order in the order book")
	public String placeOrder(@RequestParam("clientOrderId") int clientOrderId, @RequestParam("side") String side,
			@RequestParam("price") BigDecimal price, @RequestParam("volume") int volume) {

		Order order = new Order();
		order.setClientOrderId(clientOrderId);
		order.setSide(side);
		order.setPrice(price);
		order.setVolume(volume);
		order.setReceivedTime(new Timestamp(System.currentTimeMillis()));

		this.orderValidationService.isValid(order);

		orderBookDAOWriter.insert(order);

		String result = "Order is added to internal list of buy or sell orders.";
		return result;
	}

	@RequestMapping(value = "/market/cancelOrder", method = RequestMethod.POST)
	@ApiOperation(value = "Removes an order from the orderbook")
	public String removeOrder(@RequestParam("clientOrderId") int clientOrderId) {

		Order order = new Order();
		order.setClientOrderId(clientOrderId);
		
		System.out.println("Deleting order with clientOrderId=" + order.getClientOrderId());
		clientOrderIdValidationService.validate(order);
		
		orderBookDAOWriter.remove(order.getClientOrderId());

		String result = "Order removed from order book.";
		return result;
	}
}
