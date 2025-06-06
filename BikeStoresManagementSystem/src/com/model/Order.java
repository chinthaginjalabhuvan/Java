package com.model;
import java.util.Date;
 
public class Order {
    private int orderId;
    private int customerId;
    private Date orderDate;
    private double totalAmount;
 
    public Order(int orderId, int customerId, Date orderDate, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
 
	public int getOrderId() {
		return orderId;
	}
 
	public int getCustomerId() {
		return customerId;
	}
 
	public Date getOrderDate() {
		return orderDate;
	}
 
	public double getTotalAmount() {
		return totalAmount;
	}
 
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
 
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
 
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
 
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
 
	
   
}