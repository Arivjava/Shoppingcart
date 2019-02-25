package com.ari.shopping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="order_items")
public class OrderItem {
		
	@Id
	@Column(name="orderitemid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderItemId ;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name="orderid")
	private CustomerOrder customerOrder ;
	
	@Column(name="productcode")
	private String productCode ;
	
	@Column(name="order_qty")
	private int orderQTY;
	
	@Column(name="purchase_price")
	private double purchaseprice ;
	
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}


 	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public int getOrderQTY() {
		return orderQTY;
	}


	public void setOrderQTY(int orderQTY) {
		this.orderQTY = orderQTY;
	}


	public double getPurchaseprice() {
		return purchaseprice;
	}


	public void setPurchaseprice(double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}


	public int getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}


	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}


	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}


	public OrderItem(CustomerOrder customerOrder, String productCode, int orderQTY, double purchaseprice) {
		super();
		this.customerOrder = customerOrder;
		this.productCode = productCode;
		this.orderQTY = orderQTY;
		this.purchaseprice = purchaseprice;
	}


	public OrderItem(String productCode, int orderQTY, double purchaseprice) {
		super();
		this.productCode = productCode;
		this.orderQTY = orderQTY;
		this.purchaseprice = purchaseprice;
	}


	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", customerOrder=" + customerOrder + ", productCode="
				+ productCode + ", orderQTY=" + orderQTY + ", purchaseprice=" + purchaseprice + "]";
	}


 
	
	
	
}
