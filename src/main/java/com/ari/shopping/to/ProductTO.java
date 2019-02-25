package com.ari.shopping.to;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

public class ProductTO {

	private int productId;
	
	@NotEmpty(message="cannot be empty") 
	private String productDesc;
	
	@Positive(message="Invalid price amount")
	private double unitPrice;
	
	@Positive(message="Invalid quantity")
	private int quantity;
	
	@NotEmpty(message="cannot be empty")  
	private String category;
	
	private char productStatus;
	
	public ProductTO(){}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public ProductTO(int productId, @NotEmpty(message = "cannot be empty") String productDesc,
			@NotEmpty(message = "cannot be empty") double unitPrice,
			@Positive(message = "Invalid quantity") int quantity,
			@NotEmpty(message = "cannot be empty") String category,
			@NotEmpty(message = "cannot be empty") char productStatus) {
		super();
		this.productId = productId;
		this.productDesc = productDesc;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.category = category;
		this.productStatus = productStatus;
	}
	@Override
	public String toString() {
		return "ProductTO [productId=" + productId + ", productDesc=" + productDesc + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", category=" + category + ", productStatus=" + productStatus + "]";
	}

 

}
