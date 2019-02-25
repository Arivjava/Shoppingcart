package com.ari.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@Column(name="customerid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId ;
	
	@Column(name="customer_name")
	private String customerName ;
	
	@Column(name="delivery_address")
	private String deliveryAddressString ;
	
	@Column(name="contactno")
	private String contactNo ;
	 
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliveryAddressString() {
		return deliveryAddressString;
	}

	public void setDeliveryAddressString(String deliveryAddressString) {
		this.deliveryAddressString = deliveryAddressString;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Customer(String customerName, String deliveryAddressString, String contactNo) {
		super();
		this.customerName = customerName;
		this.deliveryAddressString = deliveryAddressString;
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", deliveryAddressString="
				+ deliveryAddressString + ", contactNo=" + contactNo + "]";
	}
	
	

}
