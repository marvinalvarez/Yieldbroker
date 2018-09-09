package com.yieldbroker.assignment.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderBookDAOWriter {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Order order) {
		String sql = "insert into YB_ORDER(client_order_id, price, received_time, side, volume) values(?, ?, ?, ?, ?);";
		System.out.println("sql=" + sql);

		System.out.println("order=" + order);
		int update = jdbcTemplate.update(sql, order.getClientOrderId(), order.getPrice(), order.getReceivedTime(),
				order.getSide(), order.getVolume());

		System.out.println("update/insert=" + update);

		return update;
	}

	public int delete(Order order) {
		String sql = "delete from YB_ORDER where id = ?";
		System.out.println("sql=" + sql);

		System.out.println("order=" + order);
		int update = jdbcTemplate.update(sql, order.getId());

		System.out.println("deleted=" + update);
		return update;
	}

	public int remove(int clientOrderId) {
		String sql = "delete from YB_ORDER where CLIENT_ORDER_ID = ?";
		System.out.println("sql=" + sql);

		System.out.println("clientOrderId=" + clientOrderId);
		int update = jdbcTemplate.update(sql, clientOrderId);

		System.out.println("deleted=" + update);
		return update;
	}
}