package com.yieldbroker.assignment.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
	private int id;
	private int clientOrderId;
	private BigDecimal price;
	private Timestamp receivedTime;
	private String side;
	private int volume;

	public Order()
	{
		
	}
	
	public Order(int id, int clientOrderId, BigDecimal price, Timestamp receivedTime, String side, int volume) {
		super();
		this.id = id;
		this.clientOrderId = clientOrderId;
		this.price = price;
		this.receivedTime = receivedTime;
		this.side = side;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientOrderId() {
		return clientOrderId;
	}

	public void setClientOrderId(int clientOrderId) {
		this.clientOrderId = clientOrderId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Timestamp getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(Timestamp receivedTime) {
		this.receivedTime = receivedTime;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", clientOrderId=" + clientOrderId + ", price=" + price + ", receivedTime="
				+ receivedTime + ", side=" + side + ", volume=" + volume + "]";
	}
}