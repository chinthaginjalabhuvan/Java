package com.bikestores.model;

import java.time.LocalDate;
import java.util.List;

public class Order {
	private int id;
    private int customerId;
    private int storeId;
    private LocalDate orderDate;
    private List<OrderItem> items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", storeId=" + storeId + ", orderDate=" + orderDate
				+ ", items=" + items + ", getId()=" + getId() + ", getCustomerId()=" + getCustomerId()
				+ ", getStoreId()=" + getStoreId() + ", getOrderDate()=" + getOrderDate() + ", getItems()=" + getItems()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public Order(int id, int customerId, int storeId, LocalDate orderDate, List<OrderItem> items) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.storeId = storeId;
		this.orderDate = orderDate;
		this.items = items;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
}
