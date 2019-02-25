package com.ari.shopping.to;

public class CustomerTO {
	
	private String customerName ;
	private String deliveryAddressString ;
	private String contactNo ;
	 
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliveryAddress() {
		return deliveryAddressString;
	}

	public void setDeliveryAddress(String deliveryAddressString) {
		this.deliveryAddressString = deliveryAddressString;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public CustomerTO() {
		// TODO Auto-generated constructor stub
	}

	public CustomerTO(String customerName, String deliveryAddressString, String contactNo) {
		super();
		this.customerName = customerName;
		this.deliveryAddressString = deliveryAddressString;
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "CustomerTO [customerName=" + customerName + ", deliveryAddressString=" + deliveryAddressString
				+ ", contactNo=" + contactNo + "]";
	}

	
	
}
