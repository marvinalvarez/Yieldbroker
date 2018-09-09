package com.yieldbroker.assignment.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * A pojo that represents an order object in the order book.
 * 
 * @author Marvin Alvarez
 */
public class Order {

	/**
	 * Auto-incremented ID
	 */
	private int id;

	/**
	 * Client entered order id.
	 */
	private int clientOrderId;

	/**
	 * Price
	 */
	private BigDecimal price;

	/**
	 * Timestamp received time.
	 */
	private Timestamp receivedTime;

	/**
	 * Buy or Sell
	 */
	private String side;

	/**
	 * Volume
	 */
	private int volume;

	/**
	 * Constructor
	 */
	public Order() {

	}

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param clientOrderId
	 * @param price
	 * @param receivedTime
	 * @param side
	 * @param volume
	 */
	public Order(int id, int clientOrderId, BigDecimal price, Timestamp receivedTime, String side, int volume) {
		super();
		this.id = id;
		this.clientOrderId = clientOrderId;
		this.price = price;
		this.receivedTime = receivedTime;
		this.side = side;
		this.volume = volume;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the clientOrderId
	 */
	public int getClientOrderId() {
		return clientOrderId;
	}

	/**
	 * @param clientOrderId
	 *            the clientOrderId to set
	 */
	public void setClientOrderId(int clientOrderId) {
		this.clientOrderId = clientOrderId;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the receivedTime
	 */
	public Timestamp getReceivedTime() {
		return receivedTime;
	}

	/**
	 * @param receivedTime
	 *            the receivedTime to set
	 */
	public void setReceivedTime(Timestamp receivedTime) {
		this.receivedTime = receivedTime;
	}

	/**
	 * @return the side
	 */
	public String getSide() {
		return side;
	}

	/**
	 * @param side
	 *            the side to set
	 */
	public void setSide(String side) {
		this.side = side;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume
	 *            the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", clientOrderId=" + clientOrderId + ", price=" + price + ", receivedTime="
				+ receivedTime + ", side=" + side + ", volume=" + volume + "]";
	}

}