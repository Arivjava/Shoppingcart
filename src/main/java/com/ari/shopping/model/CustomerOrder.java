package com.ari.shopping.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_orders")
public class CustomerOrder {
    
	@Id
	@Column(name="orderid ")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int orderId ;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@Column(name="orderdate")
	private LocalDate orderDate ;
	
	@Column(name="order_status")
	private String orderStatus;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

 
	
	public CustomerOrder() {
		super();
		
	}

 	public CustomerOrder(int orderId, Customer customer, LocalDate orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

 	public CustomerOrder(Customer customer, LocalDate orderDate, String orderStatus) {
		super();
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

 	
	@Override
	public String toString() {
		return "CustomerOrder [orderId=" + orderId + ", customer=" + customer + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatus + "]";
	}

	 
	
}
