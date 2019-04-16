package com.product;

public class ProductDetails {
	private int pid;
	private String  name;
	private Double price; 
	public void setPid(int pid) {
		this.pid=pid;
	}
	public int getPid() {
		return this.pid;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setPrice(Double price) {
		this.price=price;
	}
	public Double getPrice() {
		return this.price;
	}
}
