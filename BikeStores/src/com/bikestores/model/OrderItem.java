package com.bikestores.model;

public class OrderItem {
	private int productId;
    private int quantity;
    private double price;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItem [productId=" + productId + ", quantity=" + quantity + ", price=" + price + ", getProductId()="
				+ getProductId() + ", getQuantity()=" + getQuantity() + ", getPrice()=" + getPrice() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public OrderItem(int productId, int quantity, double price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
}
