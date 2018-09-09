package com.yieldbroker.assignment.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DAO for writing data to YB_ORDER.
 * 
 * @author Marvin Alvarez
 */
@Repository
public class OrderBookDAOWriter {
	
	/**
	 * JDBC Template
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Inserts a record into the YB_ORDER table.
	 * 
	 * @param order
	 * @return
	 */
	public int insert(Order order) {
		String sql = "insert into YB_ORDER(client_order_id, price, received_time, side, volume) values(?, ?, ?, ?, ?);";
		System.out.println("sql=" + sql);

		System.out.println("order=" + order);
		int update = jdbcTemplate.update(sql, order.getClientOrderId(), order.getPrice(), order.getReceivedTime(),
				order.getSide(), order.getVolume());

		System.out.println("update/insert=" + update);

		return update;
	}

	/**
	 * Deletes a record from YB_ORDER by the given ID.
	 * 
	 * @param order
	 * @return
	 */
	public int deleteById(Order order) {
		String sql = "delete from YB_ORDER where id = ?";
		System.out.println("sql=" + sql);

		System.out.println("order=" + order);
		int update = jdbcTemplate.update(sql, order.getId());

		System.out.println("deleted=" + update);
		return update;
	}

	/**
	 * Deletes a record from YB_ORDER given the client order id.
	 * 
	 * @param clientOrderId
	 * @return
	 */
	public int deleteByClientOrderId(int clientOrderId) {
		String sql = "delete from YB_ORDER where CLIENT_ORDER_ID = ?";
		System.out.println("sql=" + sql);

		System.out.println("clientOrderId=" + clientOrderId);
		int update = jdbcTemplate.update(sql, clientOrderId);

		System.out.println("deleted=" + update);
		return update;
	}
}