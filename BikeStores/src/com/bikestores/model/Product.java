package com.bikestores.model;

public class Product {
	private int id;
    private String name;
    private String brand;
    private String category;
    private int modelYear;
    private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product(int id, String name, String brand, String category, int modelYear, double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.modelYear = modelYear;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", modelYear="
				+ modelYear + ", price=" + price + ", getId()=" + getId() + ", getName()=" + getName() + ", getBrand()="
				+ getBrand() + ", getCategory()=" + getCategory() + ", getModelYear()=" + getModelYear()
				+ ", getPrice()=" + getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
