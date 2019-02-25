package com.ari.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class Product {

	 
	private String productCode;
	 
	private String productDesc;
	
	private double unitPrice;
	
	private int quantity;
	
	private String category;
	
	private char productStatus;
	
	public Product() {}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public char getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(char productStatus) {
		this.productStatus = productStatus;
	}


	public Product(String productCode, String productDesc, double unitPrice, int quantity, String category,
			char productStatus) {
		super();
		this.productCode = productCode;
		this.productDesc = productDesc;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.category = category;
		this.productStatus = productStatus;
	}

	public Product(String productDesc, double unitPrice, int quantity, String category,
			char productStatus) {
		super();
		this.productDesc = productDesc;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.category = category;
		this.productStatus = productStatus;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productDesc=" + productDesc + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", category=" + category + ", productStatus=" + productStatus + "]";
	}

}
