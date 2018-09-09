package com.yieldbroker.assignment.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DAO for reading data from YB_ORDER.
 * 
 * @author Marvin Alvarez *
 */
@Repository
public class OrderBookDAOReader {

	/**
	 * JDBC Template
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Returns all the records from YB_ORDER.
	 * 
	 * @return
	 */
	public List<Order> getAll() {

		String sql = "SELECT id, client_order_id, price, received_time, side, volume FROM YB_ORDER";

		List<Order> result = jdbcTemplate.query(sql,
				(rs, rowNum) -> new Order(rs.getInt("id"), rs.getInt("client_order_id"), rs.getBigDecimal("price"),
						rs.getTimestamp("received_time"), rs.getString("side"), rs.getInt("volume")));

		return result;
	}

	/**
	 * Returns all the records from YB_ORDER by its side (i.e. BUY or SELL).
	 * 
	 * @param side
	 * @return
	 */
	public List<Order> getBySide(String side) {
		String sql = "SELECT id, client_order_id, price, received_time, side, volume FROM YB_ORDER where side = ?";

		List<Order> result = jdbcTemplate.query(sql,
				(rs, rowNum) -> new Order(rs.getInt("id"), rs.getInt("client_order_id"), rs.getBigDecimal("price"),
						rs.getTimestamp("received_time"), rs.getString("side"), rs.getInt("volume")),
				side);

		return result;
	}

	/**
	 * Returns a record from YB_ORDER given the client order id.
	 * 
	 * @param clientOrderId
	 * @return
	 */
	public List<Order> getByClientOrderId(int clientOrderId) {
		String sql = "SELECT id, client_order_id, price, received_time, side, volume FROM YB_ORDER where client_order_id = ?";

		List<Order> result = jdbcTemplate.query(sql,
				(rs, rowNum) -> new Order(rs.getInt("id"), rs.getInt("client_order_id"), rs.getBigDecimal("price"),
						rs.getTimestamp("received_time"), rs.getString("side"), rs.getInt("volume")),
				clientOrderId);

		return result;
	}
}
