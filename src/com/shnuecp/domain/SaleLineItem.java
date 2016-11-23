package com.shnuecp.domain;

public class SaleLineItem {
	ProductDescription desc;
	private int quantity;
	private int subtotal = 0;
	
	SaleLineItem(ProductDescription pd, int quantity){
		this.desc = pd;
		this.quantity = quantity;
	}

	public int getId() {
		return desc.getId();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getName() {
		return desc.getName();
	}
	
	public void addQuantity(int qty){
		this.quantity = this.quantity + qty;
	}

	public int getSubtotal() {
		this.subtotal = this.desc.getPrice() * this.quantity;
		return subtotal;
	}
	
	
}
